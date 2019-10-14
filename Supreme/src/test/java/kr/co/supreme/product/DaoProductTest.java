package kr.co.supreme.product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import kr.co.supreme.cmn.Search;

import kr.co.supreme.product.service.Product;
import kr.co.supreme.product.service.impl.ProductDaoImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // @Test NAME_ASCENDING으로 수행.
public class DaoProductTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ProductDaoImpl dao;

	private MockMvc mockMvc;

	List<Product> list;

	@Before
	public void setUp() {
		
		list = Arrays.asList(
				new Product(95,"01","01","test01","test",9401,"test",90,80,"10","10","10","10","상품설명",34,""),
				new Product(96,"01","02","test02","test",9401,"test",90,80,"20","20","20","20","상품설명",35,""),
				new Product(97,"01","03","test03","test",9401,"test",90,80,"30","30","30","30","상품설명",36,""),
				new Product(98,"01","04","test04","test",9401,"test",90,80,"40","40","40","40","상품설명",37,""),
				new Product(99,"01","05","test05","test",9401,"test",90,80,"50","50","50","50","상품설명",38,""));
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.debug("===============================");
		LOG.debug("=context=" + context);
		LOG.debug("=mockMvc=" + mockMvc);
		LOG.debug("=dao=" +dao);
		LOG.debug("===============================");

	}

	  @Test
	  @Ignore
	  public void do_save() {
	     //---------------------------
	     //-ID값 찾기: TITLE LIKE
	     //---------------------------
	     Search search=new Search();
	     search.setSearchWord("");
	     List<Product> getIdList = (List<Product>) dao.get_productIdList(search);
	  
	     //-------------------------------------------
	     //-삭제
	     //-------------------------------------------
	     for(Product vo:getIdList) {
	    	 dao.do_delete(vo);
	     }
	     
	     
	     //-------------------------------------------
	     //-등록
	     //-------------------------------------------      
	     for(Product vo:list) {
	        int flag = dao.do_save(vo);
	        assertThat(1,is(1));
	     }
	  }
	  
	  @Test
	  @Ignore
	  public void do_delete() {
		  LOG.debug("#####do_delete");
	      //-------------------------------------------
	      //-삭제
	      //-------------------------------------------
	      for(Product vo:list) {
	         dao.do_delete(vo);
	      }
	   }
	   
	   @Test
	   @Ignore
	   public void do_update() {
	      LOG.debug("======================================");
	      LOG.debug("=01. 기존 데이터 삭제=");
	      LOG.debug("======================================");
	      Search search=new Search();
	      search.setSearchWord("");
	      List<Product> getList = (List<Product>) dao.get_productIdList(search);
	      for(Product vo:getList) {
	         dao.do_delete(vo);
	      }      
	      
	      LOG.debug("======================================");
	      LOG.debug("=02. 데이터 추가=");
	      LOG.debug("======================================");
	      for(Product vo:list) { 
	         int flag = dao.do_save(vo);
	         assertThat(1,is(flag));
	      }      

	      //=====================================
	      //2.01 등록Data조회
	      //=====================================
	      List<Product> addlistData = (List<Product>) dao.get_productIdList(search);
	      assertThat(5, is(addlistData.size()));
	      LOG.debug("======================================");
	      LOG.debug("=03. 데이터 수정=");
	      LOG.debug("======================================");
	      Product product = addlistData.get(0);
	      
	      product.setpBest("20");
	      product.setpSale("20");

	      
	      LOG.debug("======================================");
	      LOG.debug("=03.01 데이터 수정=");
	      LOG.debug("======================================");         
	      int flag = dao.do_update(product);
	      assertThat(1,is(flag));      
	      
	      LOG.debug("======================================");
	      LOG.debug("=04. 등록 DATA조회=");
	      LOG.debug("======================================");         
	      addlistData = (List<Product>) dao.get_productIdList(search);
	      
	      LOG.debug("======================================");
	      LOG.debug("=05. 비교=");
	      LOG.debug("======================================");
	      this.checkData(product, addlistData.get(0));
	   }
	   
	   @Test
	   @Ignore
	   public void addAndGet() {
	      //=====================================
	      //0. 기존data삭제
	      //=====================================      
	      Search search=new Search();
	      search.setSearchWord("");
	      List<Product> getList = (List<Product>) dao.get_productIdList(search);
	      for(Product vo:getList) {
	         dao.do_delete(vo);
	      }
	      
	      
	      //=====================================
	      //1. Data등록
	      //=====================================
	      for(Product vo:list) { 
	         int flag = dao.do_save(vo);
	         assertThat(1 ,is(flag));
	      }
	      
	      //=====================================
	      //2. 등록Data조회
	      //=====================================
	      List<Product> addlistData = (List<Product>) dao.get_productIdList(search);
	      assertThat(5,is(addlistData.size()));
	      
	      
	      //=====================================
	      //3. 비교:boardId는 자동증가로 비교 할수 없음.(제목,내용,등록자)
	      //=====================================      
	      for(int i=0;i<list.size();i++) {
	         checkData(addlistData.get(i),list.get(i));
	      }
	   }
	   @Test
	   //@Ignore
	   public void get_retrieve() {
	      LOG.debug("======================================");
	      LOG.debug("=01. 기존 데이터 삭제=");
	      LOG.debug("======================================");   
	      Search search=new Search();
	      search.setSearchWord("");
	      List<Product> getList = (List<Product>) dao.get_productIdList(search);
	      for(Product vo:getList) {
	    	  dao.do_delete(vo);
	      }   
	      
//	      LOG.debug("======================================");
//	      LOG.debug("=02. 데이터 추가=");
//	      LOG.debug("======================================");   
	      for(Product vo:list) { 
	         int flag = dao.do_save(vo);
	         assertThat(1, is(flag));
	      }      
//	      
	      //=====================================
	      //2.01 등록Data조회
	      //=====================================
	      search.setSearchDiv("10");
	      search.setPageSize(10);
	      search.setPageNum(1);
	      
	      List<Product> list = (List<Product>) dao.get_productIdList(search);
	      assertThat(5, is(list.size()));      
	   }
	
	
	

	private void checkData(Product org, Product vs) {
		assertThat(org.getpCode(),is(vs.getpCode()));
		assertThat(org.gethCode(),is(vs.gethCode()));
		assertThat(org.getlCode(),is(vs.getlCode()));
		assertThat(org.getpName(),is(vs.getpName()));
		assertThat(org.getpCompany(),is(vs.getpCompany()));
		assertThat(org.getpPrice(),is(vs.getpPrice()));
		assertThat(org.getpImage(),is(vs.getpImage()));
		assertThat(org.getStock(),is(vs.getStock()));
		assertThat(org.getpNew(),is(vs.getpNew()));
		assertThat(org.getpBest(),is(vs.getpBest()));
		assertThat(org.getpSale(),is(vs.getpSale()));
		assertThat(org.getpContent(),is(vs.getpContent()));
		assertThat(org.getSalePercent(),is(vs.getSalePercent()));
	}

	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=productImpl="+dao);
		LOG.debug("====================");
		assertThat(context,is(notNullValue()));
		assertThat(dao,is(notNullValue()));
	}
	
	
	@After
	public void tearDown() {
	
	}
}
