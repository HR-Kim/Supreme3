package kr.co.supreme.orderstatus;

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


import kr.co.supreme.cmn.Search;
import kr.co.supreme.orderstatus.service.OrderStatus;
import kr.co.supreme.orderstatus.service.impl.OrderStatusDaoImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaoOrderStatusTest{
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private OrderStatusDaoImpl daoImpl;
	
	List<OrderStatus> list;
	
	//private String detail_code   ; /*주문상세번호*/
//	private String od_status     ; /*주문상태*/
//	private String reg_dt        ; /*등록일*/
//	private String udt_dt        ; /*처리일자*/
//	private String order_code    ; /*주문번호*/
//	/**주문상세 */
//	private String p_code        ; /*상품번호*/
//	private String quantity      ; /*수량*/
//	private String unit_price    ; /*단가*/
	@Before
	public void setUp() {
		list = Arrays.asList(
				new OrderStatus("123456789","0","no_date","20191007","10010101", "1", "1000", "캣타워", "캣타워입니다", "test", null, null, null)
		);
				
				
	}
	@Test

	public void get_retrieve() {
		Search search = new Search(10,1,"",""); //생성자 참고해서 하드코딩
		List<OrderStatus> orderlist = (List<OrderStatus>) daoImpl.get_retrieve(search); 
		
		for(OrderStatus vo : list) {
			LOG.debug(vo.toString());
			
		}
	}
//	@Test
//
//		public void get_retrieve() {
//		LOG.debug("======================================");
//		LOG.debug("=01. 기존 데이터 삭제=");
//		LOG.debug("======================================");
//		Search search = new Search();
//		search.setSearchWord("123456789");
//		List<OrderStatus> getstatus = (List<OrderStatus>) daoImpl.get_orderStatusList(search);
//		for(OrderStatus vo:getstatus) {
//			daoImpl.do_delete(vo);
//		}
//		LOG.debug("======================================");
//		LOG.debug("=02. 데이터 추가=");
//		LOG.debug("======================================");
//		for(OrderStatus vo:list) { 
//			int flag = daoImpl.do_save(vo);
//			assertThat(1,is(flag));
//		}
//		//=====================================
//		//2.01 등록Data조회
//		//=====================================
//			search.setSearchDiv("10");
//			search.setPageSize(10);
//			search.setPageNum(1);
//			List<OrderStatus> addlistData = (List<OrderStatus>) daoImpl.get_retrieve(search);
//		 	assertThat(1,is(addlistData.size()));
//	}
	@Test
	
	public void do_update() {
		//---------------------------
		//-기존Data삭제
		//---------------------------	
		LOG.debug("================================");
		LOG.debug("=1.기존Data삭제=");
		LOG.debug("================================");
		
		Search search = new Search();
		search.setSearchWord("123456789");
		List<OrderStatus> getstatus = (List<OrderStatus>) daoImpl.get_orderStatusList(search);
		
		for(OrderStatus vo:getstatus) {
			daoImpl.do_delete(vo);
		}
		LOG.debug("======================================");
		LOG.debug("=02. 데이터 추가=");
		LOG.debug("======================================");
		for(OrderStatus vo:list) { 
			int flag = daoImpl.do_save(vo);
			assertThat(1,is(flag));
		}
		//=====================================
		//2.01 등록Data조회
		//=====================================
		List<OrderStatus> addlistData = (List<OrderStatus>) daoImpl.get_orderStatusList(search);
		assertThat(1,is(addlistData.size()));
		LOG.debug("======================================");
		LOG.debug("=03. 데이터 수정=");
		LOG.debug("======================================");
		OrderStatus changeData = addlistData.get(0);
		changeData.setOd_status("2 ");
		LOG.debug("======================================");
		LOG.debug("=03.01 데이터 수정=");
		LOG.debug("======================================");	
		int flag = daoImpl.do_update(changeData);
		assertThat(1,is(flag));
		
		LOG.debug("======================================");
		LOG.debug("=04. 등록 DATA조회=");
		LOG.debug("======================================");		
		addlistData = (List<OrderStatus>) daoImpl.get_orderStatusList(search);
		
		LOG.debug("======================================");
		LOG.debug("=05. 비교=");
		LOG.debug("======================================");
		this.checkData(changeData, addlistData.get(0));
	}
	
	private void checkData(OrderStatus org, OrderStatus vs) {
		assertThat(org.getOd_status(), is(vs.getOd_status()));
		
	}
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=boardDaoImpl="+daoImpl);
		LOG.debug("====================");
		assertThat(context,  is(notNullValue()));
		assertThat(daoImpl,  is(notNullValue()));
	}
	
	
	@After
	public void tearDown() {
	
	}
}