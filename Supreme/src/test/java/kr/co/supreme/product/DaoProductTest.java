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
import kr.co.supreme.user.service.User;

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
				new Product("50","01","01","test01","test","9401","test","90","80","10","10","10","10","상품설명","34",""),
				new Product("52","01","02","test02","test","9401","test","90","80","20","20","20","20","상품설명","35",""),
				new Product("51","01","03","test03","test","9401","test","90","80","30","30","30","30","상품설명","36",""),
				new Product("53","01","04","test04","test","9401","test","90","80","40","40","40","40","상품설명","37",""),
				new Product("55","01","05","test05","test","9401","test","90","80","50","50","50","50","상품설명","38",""));
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
//	     Search search=new Search();
//	     search.setSearchWord("");
//	     List<Product> getIdList = (List<Product>) dao.get_productIdList(search);
//	  
	     //-------------------------------------------
	     //-삭제
	     //-------------------------------------------
//	     for(Product vo:getIdList) {
//	    	 dao.do_delete(vo);
//	     }
//	     
	     
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
		    LOG.debug("================================");
			LOG.debug("=1.기존Data삭제=");
			LOG.debug("================================");
			
			Search search = new Search();
			search.setSearchWord("30");
			List<Product> getIdList = (List<Product>) dao.get_productIdList(search);
//			for(Product vo: getIdList) {
//				dao.do_delete(vo);
//			}
			
//			LOG.debug("================================");
//			LOG.debug("=2.등록=");
//			LOG.debug("================================");
//			for(Product vo: list) {
//				dao.do_save(vo);
//				assertThat(1, is(1));
//			}
			
			LOG.debug("================================");
			LOG.debug("=4.등록Data조회=");
			LOG.debug("================================");	
			getIdList = (List<Product>) dao.get_productIdList(search);
			assertThat(getIdList.size(), is(1));
			
			//-------------------
			//등록데이터 수정
			//-------------------
		
			
			Product product = getIdList.get(0);
			product.setP_code(product.getP_code());
			product.setH_code(product.getH_code());
			product.setL_code(product.getL_code());
			product.setP_name(product.getP_name());
			product.setP_company(product.getP_company());
			product.setP_price(product.getP_price());
			product.setP_image(product.getP_image());
			product.setStock(product.getStock());
			product.setUnit_sales(product.getUnit_sales());
			product.setStatus(product.getStatus());
			product.setP_new(product.getP_new());
			product.setP_best(product.getP_best());
			product.setP_sale(product.getP_sale());
			product.setP_content(product.getP_content());
			product.setSale_percent(product.getSale_percent());
			
			int flag = dao.do_update(product);
			assertThat(flag,is(1));
			
			getIdList = (List<Product>) dao.get_productIdList(search);
			checkData(product, getIdList.get(0));
	   }
	   
	   private void checkData(Product org, Product vs) {
		   assertThat(org.getP_code(), is(vs.getP_code()));
		   assertThat(org.getH_code(), is(vs.getH_code()));
		   assertThat(org.getL_code(), is(vs.getL_code()));
		   assertThat(org.getP_name(), is(vs.getP_name()));
		   assertThat(org.getP_company(), is(vs.getP_company()));
		   assertThat(org.getP_price(), is(vs.getP_price()));
		   assertThat(org.getP_image(), is(vs.getP_image()));
		   assertThat(org.getUnit_sales(), is(vs.getUnit_sales()));
		   assertThat(org.getStatus(), is(vs.getStatus()));
		   assertThat(org.getP_new(), is(vs.getP_new()));
		   assertThat(org.getP_best(), is(vs.getP_best()));
		   assertThat(org.getP_sale(), is(vs.getP_sale()));
		   assertThat(org.getP_content(), is(vs.getP_content()));
		   assertThat(org.getSale_percent(),is(vs.getSale_percent()));
		   assertThat(org.getReg_dt(),is(vs.getReg_dt()));
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
//	      for(int i=0;i<list.size();i++) {
//	         checkData(addlistData.get(i),list.get(i));
//	      }
	   }
	   @Test
	   @Ignore
	   public void get_retrieve() {
	      LOG.debug("======================================");
	      LOG.debug("=01. 기존 데이터 삭제=");
	      LOG.debug("======================================");   
	      Search search=new Search();
	      search.setSearchWord("test");
	      List<Product> getList = (List<Product>) dao.get_productIdList(search);
	      LOG.debug("======================================");
	      LOG.debug("=01.getList="+getList);
	      LOG.debug("======================================");
	      for(Product vo:getList) {
	    	  dao.do_delete(vo);
	      }   
	      
	      LOG.debug("======================================");
	      LOG.debug("=02. 데이터 추가=");
	      LOG.debug("======================================");   
	      for(Product vo:list) { 
	         int flag = dao.do_save(vo);
	         assertThat(1, is(flag));
	      }      
	      
//	      =====================================
//	      2.01 등록Data조회
//	      =====================================
	      search.setSearchDiv("10");
	      search.setPageSize(10);
	      search.setPageNum(1);
	      
	      List<Product> list = (List<Product>) dao.get_productIdList(search);
	      assertThat(5, is(list.size()));      
	   }
	
	
	

//	private void checkData(Product org, Product vs) {
//		assertThat(org.getP_code(),is(vs.getP_code()));
//		assertThat(org.getH_code(),is(vs.getH_code()));
//		assertThat(org.getL_code(),is(vs.getL_code()));
//		assertThat(org.getP_name(),is(vs.getP_name()));
//		assertThat(org.getP_company(),is(vs.getP_company()));
//		assertThat(org.getP_price(),is(vs.getP_price()));
//		assertThat(org.getP_image(),is(vs.getP_image()));
//		assertThat(org.getStock(),is(vs.getStock()));
//		assertThat(org.getP_new(),is(vs.getP_new()));
//		assertThat(org.getP_best(),is(vs.getP_best()));
//		assertThat(org.getP_code(),is(vs.getP_code()));
//		assertThat(org.getP_content(),is(vs.getP_content()));
//		assertThat(org.getSale_percent(),is(vs.getSale_percent()));
//		assertThat(org.getSale_percent(),is(vs.getSale_percent()));
//		assertThat(org.getSale_percent(),is(vs.getSale_percent()));
//		assertThat(org.getSale_percent(),is(vs.getSale_percent()));
//	}

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
