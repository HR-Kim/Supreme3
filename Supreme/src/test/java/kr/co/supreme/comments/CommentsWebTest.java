package kr.co.supreme.comments;

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

import kr.co.supreme.board.BoardWebTest;
import kr.co.supreme.board.service.Board;
import kr.co.supreme.comments.service.Comments;
import kr.co.supreme.comments.service.impl.CommentsDaoImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CommentsWebTest {

	
	private Logger LOG = LoggerFactory.getLogger(BoardWebTest.class);
	
	@Autowired
	WebApplicationContext context;
	
	List<Comments> list;
	
	private MockMvc mockMvc;
	
	@Autowired
	private CommentsDaoImpl dao;
	
	
	@Before
	public void setUp() {
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		LOG.debug("setUp()");
		LOG.debug("^^^^^^^^^^^^^^^^^^");
		
		
		list = Arrays.asList(
				 new Comments(6,6,"admin","content1","","admin","")
				,new Comments(7,7,"admin","content2","","admin","")
				,new Comments(8,8,"admin","content3","","admin","")
				,new Comments(9,9,"admin","content4","","admin","")
				,new Comments(10,10,"admin","content5","","admin","")
				);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.debug("===============================");
		LOG.debug("=context="+context);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("=dao="+dao);
		LOG.debug("===============================");
	}
	
	@Test
//	@Ignore
	public void get_retrieve() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.get("/comments/get_retrieve.do")
				.param("pageSize", "10")
				.param("pageNum", "1")
				.param("searchDiv", "30")
				.param("searchWord", "admin")
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
	//@Ignore
	public void get_selectOne() throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				   MockMvcRequestBuilders.get("/comments/do_selectOne.do")
					.param("id", "admin")
					;
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
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/comments/do_update.do")
				.param("cSeq", "11")
				.param("bodSeq", "4")
				.param("id", "test01")
				.param("udtUser", "test01")
				.param("content", "content8")
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
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/comments/do_save.do")
				.param("cSeq", "11")
				.param("bodSeq", "4")
				.param("id", "test01")
				.param("udtUser", "admin")
				.param("content", "content6")
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
	public void do_delete() throws Exception {
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/comments/do_delete.do")
				.param("cSeq", "11")
				.param("bodSeq", "4")
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
