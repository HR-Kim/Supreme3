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
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;



import kr.co.supreme.product.service.Product;



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
	List<String> headers;
	
	@Before
	public void setUp() {
		headers = Arrays.asList("1"
								,"2"
								,"3"
								,"test"
								,"test"
								,"33000"
								,"test.jpg"
								,"test"
								,"30"
								,"test"
								,"test"
								,"test"
								,"test"
								,"test"
								,"40"
								,"test"
				);
		
		list = Arrays.asList(
				new Product(1,"12","13","test11","test11",5000,"test11",3000,50,"test11","test11","test11","test11","test11",1194,"test11"),
				new Product(2,"13","13","test11","test11",5000,"test11",3000,50,"test11","test11","test11","test11","test11",1194,"test11"),
				new Product(3,"14","13","test11","test11",5000,"test11",3000,50,"test11","test11","test11","test11","test11",1194,"test11"),
				new Product(4,"15","13","test11","test11",5000,"test11",3000,50,"test11","test11","test11","test11","test11",1194,"test11"));
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	@Test
	public void do_save(Product vo) throws Exception{
		
		
		
		MockHttpServletRequestBuilder createMessage =
				MockMvcRequestBuilders.post("/product/do_save.do")
				.param("pCode", String.valueOf(vo.getP_code())) 
				.param("hCode", vo.getH_code())
				.param("lCode", vo.getL_code())
				.param("pName", vo.getP_name())
				.param("pCompany", vo.getP_company())
				.param("pPrice", String.valueOf(vo.getP_price()))
				.param("pImage", vo.getP_image())
				.param("stock", String.valueOf(vo.getStock()))
				.param("unitsales", String.valueOf(vo.getUnit_sales()))
				.param("status", vo.getStatus())
				.param("pNew", vo.getP_new())
				.param("pBest", vo.getP_best())
				.param("pSale", vo.getP_sale())
				.param("pContent", vo.getP_content())
				.param("salePercent", String.valueOf(vo.getSale_percent()))
				.param("regDt", vo.getReg_dt());
		
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
	
	@Test
	@Ignore
	public void get_retrieve() throws Exception {
		//url,param,post/get
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.get("/product/get_retrieve.do")
				.param("searchDiv", "10")
				.param("searchWord", "test")
				.param("pageSize", "10")
				.param("pageNum", "1");
				
		//url call 결과 return
		ResultActions resultActions = mockMvc.perform(createMessage)
				                     .andExpect(status().isOk());		
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();
		
		LOG.debug("=====================================");
		LOG.debug("=result="+result);
		LOG.debug("=====================================");			
	}
	
	@After
	public void tearDown() {
	
	}
}

