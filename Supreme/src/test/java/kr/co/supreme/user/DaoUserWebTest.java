package kr.co.supreme.user;

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


import kr.co.supreme.user.service.User;
import kr.co.supreme.user.service.UserSearch;
import kr.co.supreme.user.service.impl.UserDaoImpl;

@WebAppConfiguration  //테스트할 DI 컨테이너를 웹 애플리케이션 전용 DI 컨테이너로 처리
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoUserWebTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	
	
	@Autowired
	private WebApplicationContext context;//테스트할 Application Context를 인젝션
	
	private MockMvc mockMvc;//테스트할 컨텍스트를 지정한 MockMvc를 생성
	
	
	//Test Data
	List<User> list;
	List<String> headers;
	
	@Autowired
	UserDaoImpl  userDaoImpl;
	
	@Before
	public void setUp() {
		headers = Arrays.asList("아이디"
								,"비밀번호"
								,"이름"
								,"레벨"
								,"닉네임"
								,"이메일"
								,"우편번호"
								,"주소1"
								,"주소2"
								,"전화번호"
								,"이미지주소"
								,"등록일"
								);
		
		list = Arrays.asList(
				new User("test01_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test02_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test03_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test04_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01")
				 
				);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	
	
	
//	//id 체크 
//	@Test
//	public void id_check() throws Exception {
//		
//		LOG.debug("======================================");
//		LOG.debug("=01. 기존 데이터 찾고/삭제=");
//		LOG.debug("======================================");
//		UserSearch search=new UserSearch();
//		search.setSearchWord("_142");
//		List<User> getIdList = (List<User>) userDaoImpl.get_userIdList(search);
//		for(User vo : getIdList) {
//			do_delete(vo);
//		}
//		
//		LOG.debug("======================================");
//		LOG.debug("=02. 단건등록=");
//		LOG.debug("======================================");
//		for(User vo : list) {
//			do_save(vo);
//		}
//		
//		LOG.debug("======================================");
//		LOG.debug("=03. 조회=");
//		LOG.debug("======================================");
//		User user01 = list.get(0);
//		
//		id_check(user01);
//		
//		
//		
//		
//		
//	}
	
	
	
	//목록 조회
	@Test
	@Ignore
	public void do_retrieve() throws Exception{
		LOG.debug("======================================");
		LOG.debug("=01. 기존 데이터 찾고/삭제=");
		LOG.debug("======================================");
		UserSearch search=new UserSearch();
		search.setSearchWord("_142");
		List<User> getIdList = (List<User>) userDaoImpl.get_userIdList(search);
		for(User vo : getIdList) {
			do_delete(vo);
		}
		
		LOG.debug("======================================");
		LOG.debug("=02. 단건등록=");
		LOG.debug("======================================");
		for(User vo : list) {
			do_save(vo);
		}
		
		LOG.debug("======================================");
		LOG.debug("=03. 목록조회 like _142");
		LOG.debug("======================================");
		search.setSearchDiv("10");
		search.setSearchWord("_142");
		search.setPageSize(10);
		search.setPageNum(1);
		
		List<User> list = this.get_retrieve(search);
		
		for(User vo: list) {
			LOG.debug(vo.toString());
		}
		
		assertThat(4, is(list.size()));
	}
	
	
	//U
	@Test
	@Ignore
	public void update() throws Exception {
		LOG.debug("======================================");
		LOG.debug("=01. 기존 데이터 찾고/삭제=");
		LOG.debug("======================================");
		UserSearch search=new UserSearch();
		search.setSearchWord("_142");
		//기존Data찾기
		List<User> getIdList = (List<User>) userDaoImpl.get_userIdList(search);
		for(User vo : getIdList) {
			do_delete(vo);
		}
		LOG.debug("======================================");
		LOG.debug("=02. 단건등록=");
		LOG.debug("======================================");
		this.do_save(list.get(0));
		LOG.debug("======================================");
		LOG.debug("=03. 단건조회=");
		LOG.debug("======================================");
		getIdList = (List<User>) userDaoImpl.get_userIdList(search);
		
		//Data수정
		User user = getIdList.get(0);
		user.setPass("U_"+user.getPass());
		user.setName("U_"+user.getName());
		user.setNickname("U_"+user.getNickname());
		user.setEmail("U_"+user.getEmail());
		
		this.do_update(user);
		LOG.debug("======================================");
		LOG.debug("=05. Data 조회/비교=");
		LOG.debug("======================================");		
		User vsData = this.get_selectOne(user);
		
		checkData(user, vsData);
		
	}
		
	
	//CRD
	@Test
//	@Ignore
	public void addAndGet() throws Exception {
		LOG.debug("======================================");
		LOG.debug("=01. 기존 데이터 삭제=");
		LOG.debug("======================================");
		UserSearch search=new UserSearch();
		search.setSearchWord("_142");
		List<User> getIdList = (List<User>) userDaoImpl.get_userIdList(search);
		for(User vo : getIdList) {
			do_delete(vo);
		}
		
		LOG.debug("======================================");
		LOG.debug("=02. 단건등록=");
		LOG.debug("======================================");
		for(User vo : list) {
			do_save(vo);
		}
		
		LOG.debug("======================================");
		LOG.debug("=03. 조회=");
		LOG.debug("======================================");
		getIdList = (List<User>) userDaoImpl.get_userIdList(search);
		
		for(User vo: getIdList) {
			User vsVO = get_selectOne(vo);
			checkData(vsVO,vo);
		}
		
		
	}
	
	private void checkData(User org, User vs) {
		assertThat(org.getId(), is(vs.getId()));
		assertThat(org.getName(), is(vs.getName()));
		assertThat(org.getNickname(), is(vs.getNickname()));
		assertThat(org.getTel(), is(vs.getTel()));
	}
	
	
	private List<User> get_retrieve(UserSearch inVO) throws Exception {
		//url,param,post/get
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.get("/user/get_retrieve.do")
				.param("searchDiv", inVO.getSearchDiv())
				.param("searchWord", inVO.getSearchWord())
				.param("pageSize", String.valueOf(inVO.getPageSize()))
				.param("pageNum", String.valueOf(inVO.getPageNum()));

		//url call 결과 return
		MvcResult result = mockMvc.perform(createMessage)
				                     .andExpect(status().isOk())
				                     .andReturn()
				                     ;		
		ModelAndView   modelAndView= result.getModelAndView();
		List<User> list = (List<User>) modelAndView.getModel().get("list");
		
		LOG.debug("=====================================");
		LOG.debug("=list="+list);
		LOG.debug("=====================================");		
		
		return list;
	}
	
	
	private void do_save(User vo) throws Exception{
		//url,param
		MockHttpServletRequestBuilder createMessage =
				MockMvcRequestBuilders.post("/user/do_save.do")
				.param("id", vo.getId())
				.param("pass", vo.getPass())
				.param("name", vo.getName())
				.param("lvl", vo.getLvl())
				.param("nickname", vo.getNickname())
				.param("email", vo.getEmail())
				.param("postcode", vo.getPostcode())
				.param("address1", vo.getAddress1())
				.param("address2", vo.getAddress2())
				.param("tel", vo.getTel())
				.param("image", vo.getImage())
				.param("reg_dt", vo.getRegDt());
		
		
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
	
	
	private void do_delete(User vo) throws Exception{
		//url,param
		MockHttpServletRequestBuilder createMessage =
				MockMvcRequestBuilders.post("/user/do_delete.do")
				.param("id", vo.getId())
				.param("pass", vo.getPass());
		
		
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
	
	private User get_selectOne(User vo) throws Exception {
		//url,param
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.get("/user/do_selectOne.do")
				.param("id", vo.getId());
		//url call 결과 return
		MvcResult result = mockMvc.perform(createMessage)
				                   .andExpect(status().isOk())
				                   .andReturn()
				                   ;
		
		//result:return VO 객체로 됨.(결과 출력 않됨.)
		ModelAndView  modelAndView=result.getModelAndView();
		
		User outVO = (User) modelAndView.getModel().get("vo");
		
		LOG.debug("=====================================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("=====================================");		
		
		return outVO;
		
	}
	
	private void do_update(User inVO) throws Exception{
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/user/do_update.do")
				.param("id", inVO.getId())
				.param("pass", inVO.getPass())
				.param("name", inVO.getName())
				.param("lvl", inVO.getLvl())
				.param("nickname", inVO.getNickname())
				.param("email", inVO.getEmail())
				.param("postcode", inVO.getPostcode())
				.param("address1", inVO.getAddress1())
				.param("address2", inVO.getAddress2())
				.param("tel", inVO.getTel())
				.param("image", inVO.getImage())
				.param("reg_dt", inVO.getRegDt());
		
		//url call 결과 return
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
	
	//id 중복 체크
	@Test
	@Ignore
	public void id_check() throws Exception {
		
		//url,param
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/user/id_check.do")
				.param("id", "test01_142_");
		//url call 결과 return
		
		MvcResult result = mockMvc.perform(createMessage)
				                   .andExpect(status().isOk())
				                   .andReturn()
				                   ;
		
		//result:return VO 객체로 됨.(결과 출력 않됨.)
		ModelAndView  modelAndView=result.getModelAndView();
		
		int flag = (int) modelAndView.getModel().get("vo");
		
		LOG.debug("=====================================");
		LOG.debug("=flag="+flag);
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
	
	
	@After
	public void tearDown() {
	
	}
	
	
}
