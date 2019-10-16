package kr.co.supreme.myitem;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import kr.co.supreme.myitem.service.MyItem;
import kr.co.supreme.myitem.service.impl.MyItemDaoImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MyItemWebTest {
	
	private Logger LOG = LoggerFactory.getLogger(MyItemWebTest.class);
	
	@Autowired
	WebApplicationContext context;
	
	List<MyItem> list;
	
	private MockMvc mockMvc;
	
	@Autowired
	private MyItemDaoImpl dao;
	
	@Before
	public void setUp() {
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		LOG.debug("setUp()");
		LOG.debug("^^^^^^^^^^^^^^^^^^");
	
	list = Arrays.asList(
			new MyItem(000001,"test01",95,"","","",0),
			new MyItem(000002,"test02",95,"","","",0),
			new MyItem(000003,"test01",96,"","","",0),
			new MyItem(000004,"test02",96,"","","",0)
			);
	
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	LOG.debug("===============================");
	LOG.debug("=context="+context);
	LOG.debug("=mockMvc="+mockMvc);
	LOG.debug("=dao="+dao);
	LOG.debug("===============================");

}
	
	@Test
	//@Ignore
	public void get_retrieve() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.get("/myitem/get_retrieve.do")
				.param("searchWord", "test01")
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
	public void do_delete() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/myitem/do_delete.do")
				.param("fSeq", "1");
		
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
	public void do_save() throws Exception{
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/myitem/do_save.do")
				.param("fSeq", "100")
				.param("id", "test01" )
				.param("pCode", "95")
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
		.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));
	
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		
		LOG.debug("===============================");
		LOG.debug("=result="+result);
		LOG.debug("===============================");		
	
	}
	
	
	@Test
	public void instanceTest() {
		LOG.debug("===============================");
		LOG.debug("=instanceTest=");
		LOG.debug("===============================");		
	}
	
	@After
	public void tearDown() {
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		LOG.debug("=tearDown=");
		LOG.debug("^^^^^^^^^^^^^^^^^^");
	}
	
	
	
	
	
}
