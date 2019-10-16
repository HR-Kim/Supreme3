package kr.co.supreme.order;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.co.supreme.cart.service.Cart;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.order.service.Order;
import kr.co.supreme.order.service.impl.OrderDaoImpl;
import kr.co.supreme.user.service.User;



@WebAppConfiguration  //테스트할 DI 컨테이너를 웹 애플리케이션 전용 DI 컨테이너로 처리
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoOrderWebTest {
private final Logger LOG = LoggerFactory.getLogger(this.getClass());	

	@Autowired
	private WebApplicationContext context;//테스트할 Application Context를 인젝션
	
	private MockMvc mockMvc;//테스트할 컨텍스트를 지정한 MockMvc를 생성
	
	//Test Data
		List<Order> list;
		List<String> headers;
		List<Cart> cart;
		
		@Autowired
		OrderDaoImpl  orderDaoImpl;
		
		@Before
		public void setUp() {
			headers = Arrays.asList("주문번호"
									,"아이디"
									,"수령자이름"
									,"수령자우편번호"
									,"수령자주소1"
									,"수령자주소2"
									,"수령자전화번호"
									,"요청사항"
									,"결제구분"
									,"은행명"
									,"입금인명"
									,"입금날짜"
									,"주문날짜"
									);
			
			list = Arrays.asList(
					 new Order("05", "admin", "test", "1234", "주소1", "주소2", "010-1234-1234", "test", "1", "test", "test", "19/10/01","test"),
					 new Order("06", "admin", "test", "1234", "주소1", "주소2", "010-1234-1234", "test", "1", "test", "test", "19/10/01","test"),
					 new Order("07", "admin", "test", "1234", "주소1", "주소2", "010-1234-1234", "test", "1", "test", "test", "19/10/01","test"),
					 new Order("08", "admin", "test", "1234", "주소1", "주소2", "010-1234-1234", "test", "1", "test", "test", "19/10/01","test")
					
					);
			
			cart = Arrays.asList(
//					 new Cart(01, 1,1, 10000, "admin"),
//					 new Cart(02, 2,1, 10000, "admin"),
//					 new Cart(03, 3,1, 10000, "admin")
					 
					);
			
			mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
			
		}
		
		@Test
//		@Ignore
		public void save() throws Exception {
			Search search=new Search();
			search.setSearchWord("01");
			LOG.debug("======================================");
			LOG.debug("=01. 단건등록=");
			LOG.debug("======================================");
			
			for(Order vo : list) {
				do_save(vo);
			}
			
			
			LOG.debug("======================================");
			LOG.debug("=02. 단건조회=");
			LOG.debug("======================================");
			List<Order> getIdList = (List<Order>) orderDaoImpl.get_IdList(search);
			
		
			
		}
		
		
		private void do_save(Order vo) throws Exception{
			//url,param
			MockHttpServletRequestBuilder createMessage =
					MockMvcRequestBuilders.post("/order/do_save.do")
					.param("orderCode", vo.getOrderCode())
					.param("id", vo.getId())
					.param("rName", vo.getrName())
					.param("rPostcode", vo.getrPostcode())
					.param("rAddress1", vo.getrAddress1())
					.param("rAddress2", vo.getrAddress2())
					.param("rTel", vo.getrTel())
					.param("request", vo.getRequest())
					.param("payMethod", vo.getPayMethod())
					.param("bank", vo.getBank())
					.param("depositName", vo.getDepositName())
					.param("depositDate", vo.getDepositDate())
					.param("orderDate", vo.getOrderDate());
			
			
			ResultActions resultActions = mockMvc.perform(createMessage)
					.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
					.andExpect(status().isOk());
			String result = resultActions.andDo(print())
					.andReturn()
					.getResponse().getContentAsString();
			
			LOG.debug("=====================================");
			LOG.debug("=result="+result);
			LOG.debug("=====================================");			
		}
		
		
		private Order get_selectOne(Order vo) throws Exception {
			//url,param
			MockHttpServletRequestBuilder createMessage = 
					MockMvcRequestBuilders.get("/order/do_selectOne.do")
					.param("id", vo.getId());
			//url call 결과 return
			MvcResult result = mockMvc.perform(createMessage)
					                   .andExpect(status().isOk())
					                   .andReturn()
					                   ;
			
			//result:return VO 객체로 됨.(결과 출력 않됨.)
			ModelAndView  modelAndView=result.getModelAndView();
			
			Order outVO = (Order) modelAndView.getModel().get("vo");
			
			LOG.debug("=====================================");
			LOG.debug("=outVO="+outVO);
			LOG.debug("=====================================");		
			
			return outVO;
			
		}
		
		//CRD
		@Test
		@Ignore
		public void delete() throws Exception {
			LOG.debug("======================================");
			LOG.debug("=01. 기존 데이터 삭제=");
			LOG.debug("======================================");
			Search search=new Search();
			search.setSearchWord("01");
			List<Order> getIdList = (List<Order>) orderDaoImpl.get_IdList(search);
			for(Order vo : getIdList) {
				do_delete(vo);
			}
			
		}
		
		private void do_delete(Order vo) throws Exception{
			//url,param
			MockHttpServletRequestBuilder createMessage =
					MockMvcRequestBuilders.post("/order/do_delete.do")
					.param("orderCode", vo.getOrderCode());
			
			
			ResultActions resultActions = mockMvc.perform(createMessage)
					.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
					.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));		
			String result = resultActions.andDo(print())
					.andReturn()
					.getResponse().getContentAsString();
			
			LOG.debug("=====================================");
			LOG.debug("=result="+result);
			LOG.debug("=====================================");			
		}
		//junit의 테스트 메소드 작성방법
		//@Test public void 메소드이름(파라메터 사용금지){ }
		@Test
		public void getBean() {
			LOG.debug("====================");
			LOG.debug("=context="+context);
			LOG.debug("=mockMvc="+mockMvc);
			LOG.debug("====================");
			assertThat(context,  is(notNullValue()));
			assertThat(mockMvc,  is(notNullValue()));
		}
		
}
