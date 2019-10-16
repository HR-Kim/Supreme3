package kr.co.supreme.order;


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


import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.order.service.Order;
import kr.co.supreme.order.service.impl.OrderDaoImpl;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoOrderTest {

	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private OrderDaoImpl orderDaoImpl;
	
	List<Order> list;
	
	
	@Before
	public void setUp() {
	
		list = Arrays.asList(
				
		/* VO내용에 맞춰서 입력
		 * 	private int orderCode;        //주문번호
			private String id;            //아이디
			private String rName;         //수령자이름
			private String rPostcode;     //수령자우편번호
			private String rAddress1;     //수령자주소1
			private String rAddress2;     //수령자주소2
			private String rTel;          //수령자전화번호
			private String request;       //요청사항
			private String payMethod;     //결제구분
			private String bank;          //은행명
			private String depositName;   //입금인명
			private String depositDate;   //입금날짜
			private String orderDate;     //주문날짜
		 * 
		 */
		  new Order("20191002","test01","수령자이름","21151","수령자주소","수령자주소2","031-1234-1111","요청사항","1","은행명","입금인명","","") ,new
		  Order("20191003","test01","수령자이름","21151","수령자주소","수령자주소2","031-1234-1111","요청사항","1","은행명","입금인명","","") ,new
		  Order("20191004","test01","수령자이름","21151","수령자주소","수령자주소2","031-1234-1111","요청사항","1","은행명","입금인명","","") ,new
		  Order("20191005","test01","수령자이름","21151","수령자주소","수령자주소2","031-1234-1111","요청사항","1","은행명","입금인명","","") ,new
		  Order("20191006","test01","수령자이름","21151","수령자주소","수령자주소2","031-1234-1111","요청사항","1","은행명","입금인명","","")
		 
				);
	}
	@Test
	//@Ignore
	public void get_retrieve() {
		LOG.debug("======================================");
		LOG.debug("=01. 기존 데이터 삭제=");
		LOG.debug("======================================");	
		Search search=new Search();
		search.setSearchWord("test01");
		List<Order> getList = (List<Order>) orderDaoImpl.get_IdList(search);
		for(Order vo:getList) {
			orderDaoImpl.do_delete(vo);
		}	
			
//		LOG.debug("======================================");
//		LOG.debug("=02. 데이터 추가=");
//		LOG.debug("======================================");	
		for(Order vo:list) { 
			int flag = orderDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}		
//			
		//=====================================
		//2.01 등록Data조회
		//=====================================
		search.setSearchDiv("30");
		search.setPageSize(10);
		search.setPageNum(1);
		
		List<Order> list = (List<Order>) orderDaoImpl.get_retrieve(search);
		assertThat(5, is(list.size()));		
	}
		
	@Test
	@Ignore
	public void do_save() {
		//---------------------------
		//-ID값 찾기: TITLE LIKE
		//---------------------------
		Search search=new Search();
		search.setSearchWord("");
		List<Order> getIdList = (List<Order>) orderDaoImpl.get_IdList(search);

		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		for(Order vo:getIdList) {
			orderDaoImpl.do_delete(vo);
		}

		//-------------------------------------------
		//-등록
		//-------------------------------------------		
		for(Order vo:list) {
			int flag = orderDaoImpl.do_save(vo);
			assertThat(1, is(1));
		}
	}
	
	@Test
	@Ignore
	public void do_delete() {
		LOG.debug("#####do_delete");
		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		for(Order vo:list) {
			orderDaoImpl.do_delete(vo);
		}
	}
	
	@Test
	@Ignore
	public void do_update() {
		LOG.debug("======================================");
		LOG.debug("=01. 기존 데이터 삭제=");
		LOG.debug("======================================");
		Search search=new Search();
		search.setSearchWord("test01");
		List<Order> getList = (List<Order>) orderDaoImpl.get_IdList(search);
		
		for(Order vo:getList) {
			orderDaoImpl.do_delete(vo);
		}		
		
		LOG.debug("======================================");
		LOG.debug("=02. 데이터 추가=");
		LOG.debug("======================================");
		for(Order vo:list) { 
			int flag = orderDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}		

		//=====================================
		//2.01 등록Data조회
		//=====================================
		List<Order> addlistData = (List<Order>) orderDaoImpl.get_IdList(search);
		assertThat(5, is(addlistData.size()));
		LOG.debug("======================================");
		LOG.debug("=03. 데이터 수정=");
		LOG.debug("======================================");
		Order order = addlistData.get(0);
		
		
		//변경 내용 추가할부분 추가해
		order.setrAddress1("인천"+order.getrAddress1());
		

		
		LOG.debug("======================================");
		LOG.debug("=03.01 데이터 수정=");
		LOG.debug("======================================");			
		int flag = orderDaoImpl.do_update(order);
		assertThat(1, is(flag));		
		
		LOG.debug("======================================");
		LOG.debug("=04. 등록 DATA조회=");
		LOG.debug("======================================");			
		addlistData = (List<Order>) orderDaoImpl.get_IdList(search);
		
		LOG.debug("======================================");
		LOG.debug("=05. 비교=");
		LOG.debug("======================================");
		this.checkData(order, addlistData.get(0));
	}
	
	private void checkData(Order org,Order vs) {
		//체크리스트 입력
//		assertThat(org.getbTitle(), is(vs.getbTitle()));
//		assertThat(org.getbContents(), is(vs.getbContents()));
//		assertThat(org.getId(), is(vs.getId()));
		
	}
	
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=orderDaoImpl="+orderDaoImpl);
		LOG.debug("====================");
		assertThat(context,  is(notNullValue()));
		assertThat(orderDaoImpl,  is(notNullValue()));
	}
	
	@Test
	@Ignore
	public void addAndGet() {
		//=====================================
		//0. 기존data삭제
		//=====================================		
		Search search=new Search();
		//삭제 내용
		search.setSearchWord("");
		List<Order> getList = (List<Order>) orderDaoImpl.get_IdList(search);
		for(Order vo:getList) {
			orderDaoImpl.do_delete(vo);
		}
		
		
		//=====================================
		//1. Data등록
		//=====================================
		for(Order vo:list) { 
			int flag = orderDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}
		
		//=====================================
		//2. 등록Data조회
		//=====================================
		List<Order> addlistData = (List<Order>) orderDaoImpl.get_IdList(search);
		assertThat(5, is(addlistData.size()));
		
		
		//=====================================
		//3. 비교:boardId는 자동증가로 비교 할수 없음.(제목,내용,등록자)
		//=====================================		
		for(int i=0;i<list.size();i++) {
			checkData(addlistData.get(i),list.get(i));
		}
	}
	
	
	
	
	@After
	public void tearDown() {
	
	}
}
