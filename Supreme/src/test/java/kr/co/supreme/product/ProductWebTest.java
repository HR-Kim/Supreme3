package kr.co.supreme.product;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import kr.co.supreme.cmn.Search;
import kr.co.supreme.product.service.Product;
import kr.co.supreme.product.service.impl.ProductDaoImpl;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.

public class ProductWebTest {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	
	List<Product> list;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Before
	public void setUp() {
		
		
		list = Arrays.asList(
				new Product("1","12","13","test11","test11","5000","test11","3000","50","test11","test11","test11","test11","test11","1194","test11"),
				new Product("2","13","13","test11","test11","5000","test11","3000","50","test11","test11","test11","test11","test11","1194","test11"),
				new Product("3","14","13","test11","test11","5000","test11","3000","50","test11","test11","test11","test11","test11","1194","test11"),
				new Product("4","15","13","test11","test11","5000","test11","3000","50","test11","test11","test11","test11","test11","1194","test11"));
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	@Test
	@Ignore
	public void do_save() throws Exception{
		
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/product/do_save.do")
				.param("p_code","45")
				.param("h_code","21")
				.param("l_code","22")
				.param("p_name","test")
				.param("p_company","test")
				.param("p_price", "44000")
				.param("p_image","test")
				.param("stock","555")
				.param("unit_sales","77")
				.param("status","1")
				.param("p_new","3")
				.param("p_best","3")
				.param("p_sale","3")
				.param("p_content","test")
				.param("sale_percent","50")
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));
		String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
	}
	
	
	@Test
	@Ignore
	public void do_delete() throws Exception{
		MockHttpServletRequestBuilder createMessage =
				MockMvcRequestBuilders.post("/product/do_delete.do")
				.param("p_code", "45");
		
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
		MockHttpServletRequestBuilder createMessage =
				MockMvcRequestBuilders.get("/product/do_selectOne.do")
				.param("p_name", "cc");
		
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
	public void get_retrieve() throws Exception{
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.get("/product/get_retrieve.do")
				.param("searchWord", "01")
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
	public void do_update() throws Exception{
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/product/do_update.do")
				.param("h_code", "02")
				.param("l_code", "03")
				.param("p_name","cc")
				.param("p_company", "cc")
				.param("p_price", "23")
				.param("p_image", "cc")
				.param("stock", "50")
				.param("unit_sales", "44")
				.param("status", "70")
				.param("p_new", "34")
				.param("p_best", "34")
				.param("p_sale", "34")
				.param("p_content", "cc")
				.param("sale_percent", "40")
				.param("p_code","45")
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
	
	@After
	public void tearDown() {
	
	}
}

