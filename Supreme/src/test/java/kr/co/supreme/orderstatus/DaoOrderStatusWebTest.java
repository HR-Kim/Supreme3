package kr.co.supreme.orderstatus;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;


import kr.co.supreme.orderstatus.service.OrderStatus;
import kr.co.supreme.orderstatus.service.impl.OrderStatusDaoImpl;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
									,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaoOrderStatusWebTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	List<OrderStatus> list;
	
	@Autowired
	private OrderStatusDaoImpl dao;
	
	@Before
	public void setUp() {
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		LOG.debug("setUp()");
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		
		
		list  = Arrays.asList(
				new OrderStatus("","","", null, null, null, null, null, null, null, null, null, null));
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.debug("===============================");
		LOG.debug("=context="+context);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("=dao="+dao);
		LOG.debug("===============================");
	}
	

	@Test

	public void get_retrieve() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.get("/orderStauts/get_retrieve.do")
				.param("pageSize", "10")
				.param("pageNum", "1")
				.param("searchDiv", "10")
				.param("searchWord", "123456789")
				;
		ResultActions resultActions = mockMvc.perform(createMessage)		
				.andExpect(status().isOk()) ;
		        		
				String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
				LOG.debug("===============================");
				LOG.debug("=result="+result);
				LOG.debug("===============================");			
			}
	@Test
	@Ignore
	public void do_save() throws Exception{
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/orderStauts/do_save.do")
				.param("detail_code", "456123789")
				.param("od_status", "0")
				.param("reg_dt","2019-10-14")
				.param("udt_dt","2019-10-14")
				.param("order_code","20191006")
				.param("quantitiy","2")
				.param("unit_price","2000")
				.param("p_name","test")
				.param("p_content","test01")
				.param("p_image","test01")
				.param("nickname","000");
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))		
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1"))) ;
		        		
				String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
				LOG.debug("===============================");
				LOG.debug("=result="+result);
				LOG.debug("===============================");		
			}			

	@Test
	@Ignore
	public void do_update() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/orderStauts/do_update.do")
				.param("od_status", "1")
				.param("detail_code", "123456789");
				

		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))		
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1"))) ;
		        		
				String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
				LOG.debug("===============================");
				LOG.debug("=result="+result);
				LOG.debug("===============================");				
			}
		
	@Test
	@Ignore
	public void get_selectOne() throws Exception{
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.get("/orderStauts/do_selectOne.do")
		.param("detail_code", "123789");
		
		ResultActions resultActions = mockMvc.perform(createMessage)
									  .andExpect(status().isOk());
		String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
		LOG.debug("======================================");
		LOG.debug("====RESULT==="+result);
		LOG.debug("======================================");
		
	}
	@After
	public void tearDown() {
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		LOG.debug("=tearDown=");
		LOG.debug("^^^^^^^^^^^^^^^^^^");
	}
	}
