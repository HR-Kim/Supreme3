package kr.co.supreme.cart;

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
import org.springframework.web.context.WebApplicationContext;

import kr.co.supreme.cart.service.Cart;
import kr.co.supreme.cart.service.impl.CartDaoImpl;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.user.service.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoCartTest {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private CartDaoImpl cartDaoImpl;
	
	List<Cart> list;
	
	@Before
	public void setUp() {
		list = Arrays.asList(
				new Cart(191010001,10110001,1,10000,"test01"),
				new Cart(191010002,10110001,3,10000,"test02"),
				new Cart(191010003,10110002,1,20000,"test02"),
				new Cart(191010004,10110002,1,20000,"test01")
				);
				
		LOG.debug("#####setUp");
	}
	
	@Test
	@Ignore
	public void get_retrive() {
		LOG.debug("=get_retrive=");
		Search search=new Search();
		//등록Data조회
		search.setSearchDiv("10");
		search.setPageSize(10);
		search.setPageNum(1);
		search.setSearchWord("");
		List<Cart> getIdList = (List<Cart>) cartDaoImpl.get_IdList(search);
		
		
		LOG.debug("==삭제==");
		//기존 Data삭제
		for(Cart vo:getIdList) {
			cartDaoImpl.do_delete(vo);
		}
		
		
		LOG.debug("==등록==");
		//등록
		for(Cart vo:list) {
			int flag = cartDaoImpl.do_save(vo);
		}
		
		List<Cart> list = (List<Cart>) cartDaoImpl.get_retrieve(search);
		
	}
	
	@Test
	@Ignore
	public void do_save() {
		//ID 값 찾기
		Search search=new Search();
		search.setSearchWord("");
		List<Cart> getIdList = (List<Cart>) cartDaoImpl.get_IdList(search);
		
		LOG.debug(getIdList+"==getIdList==");
		
		//삭제
		System.out.println("=삭제=");
		for(Cart vo:getIdList) {
			cartDaoImpl.do_delete(vo);
			LOG.debug("==test==");
		}
		
		//등록
		for(Cart vo:list) {
			int flag= cartDaoImpl.do_save(vo);
			System.out.println("=등록=");
			System.out.println("Cart vo="+vo);
		}
		
		
	}
	
	@Test
	//@Ignore
	public void addAndGet() {
		//---------------------------
		//-ID값 찾기: ID LIKE
		//---------------------------
		LOG.debug("================================");
		LOG.debug("=1.ID값 찾기: ID LIKE=");
		LOG.debug("================================");
		
		Search search = new Search();
		search.setSearchWord("");
		List<Cart> getIdList = (List<Cart>) cartDaoImpl.get_IdList(search);
		
		
		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=2.삭제=");
		LOG.debug("================================");
		for(Cart vo: getIdList) {
			cartDaoImpl.do_delete(vo);
		}
		
		//-------------------------------------------
		//-등록
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=3.등록=");
		LOG.debug("================================");
		for(Cart vo: list) {
			cartDaoImpl.do_save(vo);
			assertThat(1, is(1));
		}	
		//-------------------------------------------
		//-등록Data조회
		//-------------------------------------------	
		LOG.debug("================================");
		LOG.debug("=4.등록Data조회=");
		LOG.debug("================================");	
		getIdList = (List<Cart>) cartDaoImpl.get_IdList(search);
		assertThat(list.size(), is(getIdList.size()));
			
		//-------------------------------------------
		//-5 비교
		//-------------------------------------------			
		for(int i=0;i<list.size();i++) {
			checkData(list.get(i),getIdList.get(i));
		}		
	}
	
	
	private void checkData(Cart org, Cart vs) {
		assertThat(org.getCartCode(), is(vs.getCartCode()));
		assertThat(org.getpCode(), is(vs.getpCode()));
		assertThat(org.getQuantity(), is(vs.getQuantity()));
		assertThat(org.getUnitPrice(), is(vs.getUnitPrice()));
		assertThat(org.getId(), is(vs.getId()));
	
	}
	
	@Test
	@Ignore
	public void do_delete() {
		LOG.debug("#####do_delete");
		//삭제
		
		for(Cart vo:list) {
			cartDaoImpl.do_delete(vo);
		}

	}
	
	
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=cartDaoImpl="+cartDaoImpl);
		LOG.debug("====================");
		assertThat(context,  is(notNullValue()));
		assertThat(cartDaoImpl,  is(notNullValue()));
	}
	
	
	@After
	public void tearDown() {
		LOG.debug("#####tearDown");
	}
	
	
	
	
}
