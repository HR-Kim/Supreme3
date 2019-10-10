package kr.co.supreme.board;

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


import kr.co.supreme.board.service.Board;
import kr.co.supreme.board.service.impl.BoardDaoImpl;
import kr.co.supreme.user.service.User;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardWebTest {

	
	private Logger LOG = LoggerFactory.getLogger(BoardWebTest.class);
	
	@Autowired
	WebApplicationContext context;
	
	List<Board> list;
	
	private MockMvc mockMvc;	//⊃request
	
	@Autowired
	private BoardDaoImpl dao;
	
	
	@Before
	public void setUp() {
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		LOG.debug("setUp()");
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		
		
		list = Arrays.asList(
				 new Board(1,"title1","contents1","admin",0,"","admin","",1,2)
				,new Board(2,"title2","contents2","admin",0,"","admin","",1,2)
				,new Board(3,"title3","contents3","admin",0,"","admin","",1,2)
				,new Board(4,"title4","contents4","admin",0,"","admin","",1,2)
				,new Board(5,"title5","contents5","admin",0,"","admin","",1,2)
	
				);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.debug("===============================");
		LOG.debug("=context="+context);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("=dao="+dao);
		LOG.debug("===============================");
	}
	
	
	
	@Test
	@Ignore
	public void get_retrieve() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.get("/board/get_retrieve.do")
				.param("pageSize", "10")
				.param("pageNum", "1")
				.param("searchDiv", "30")
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
	public void get_selectOne() throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				   MockMvcRequestBuilders.get("/board/do_selectOne.do")
				.param("bSeq", "1");
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				                     .andExpect(status().isOk());
        		                     
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
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/board/do_update.do")
				.param("bTitle", "YJ0614YJ")
				.param("bContents", "YJ0614YJ")
				.param("Id", "test01")
				.param("udtUser", "test01")
				;
		
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
	public void do_save() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/board/do_save.do")
				.param("bSeq", "15")
				.param("bTitle", "YJ15")
				.param("bContents", "YJ")
				.param("Id", "admin")
				;
		
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
	
	
	/*
	 * private void do_delete(User user) throws Exception {
	 * MockHttpServletRequestBuilder createMessage =
	 * MockMvcRequestBuilders.post("/user/do_delete.do") .param("id", user.getId());
	 * 
	 * ResultActions resultActions = mockMvc.perform(createMessage)
	 * .andExpect(MockMvcResultMatchers.content().contentType(
	 * "application/json;charset=UTF-8"));
	 * 
	 * 
	 * String result = resultActions.andDo(print()) .andReturn()
	 * .getResponse().getContentAsString();
	 * LOG.debug("==============================="); LOG.debug("=result="+result);
	 * LOG.debug("==============================="); }
	 */
	
	@Test
//	@Ignore
	public void do_delete() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/board/do_delete.do")
				.param("bSeq", "15");
		
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
