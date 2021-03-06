package kr.co.supreme.user;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
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


import kr.co.supreme.user.service.User;
import kr.co.supreme.user.service.UserSearch;
import kr.co.supreme.user.service.impl.UserDaoImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoUserTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private UserDaoImpl daoImpl;
	
	
	List<User> list;
	
	@Before
	public void setUp() {
		
		
		
		list = Arrays.asList( 
				
				 new User("test01_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test02_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test03_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test04_142", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01")
				);
		
	}

	
	@Test
	@Ignore
	public void getAll() throws SQLException {
		List<User> list = daoImpl.getAll();
		for(User user:list) {
			LOG.debug(user.toString());
		}
	}
	
	
	@Test
	@Ignore
	public void get_retrieve() {
		//---------------------------
		//-기존Data삭제
		//---------------------------
		LOG.debug("================================");
		LOG.debug("=1.기존Data삭제=");
		LOG.debug("================================");
		
		UserSearch search = new UserSearch();
		search.setSearchWord("_142");
		List<User> getIdList = (List<User>) daoImpl.get_userIdList(search);
		for(User vo: getIdList) {
			daoImpl.do_delete(vo);
		}
		//-------------------------------------------
		//-등록
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=2.등록=");
		LOG.debug("================================");
		for(User vo: list) {
			daoImpl.do_save(vo);
			assertThat(1, is(1));
		}		
		//-------------------
		//등록Data조회
		//-------------------
		LOG.debug("================================");
		LOG.debug("=3.조회=");
		LOG.debug("================================");
		search.setSearchDiv("10");
		search.setPageSize(4);
		search.setPageNum(1);
		
		List<User> list = (List<User>) daoImpl.get_retrieve(search);
		LOG.debug("================================");
		LOG.debug("=3.1 list="+list);
		LOG.debug("================================");
		assertThat(search.getPageSize(), is(list.size()));
		
		
		
	}
	
	@Test
	@Ignore
	public void do_update() {	
		//---------------------------
		//-기존Data삭제
		//---------------------------
		LOG.debug("================================");
		LOG.debug("=1.기존Data삭제=");
		LOG.debug("================================");
		
		UserSearch search = new UserSearch();
		search.setSearchWord("test");
		List<User> getIdList = (List<User>) daoImpl.get_userIdList(search);
		for(User vo: getIdList) {
			daoImpl.do_delete(vo);
		}
		//-------------------------------------------
		//-등록
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=2.등록=");
		LOG.debug("================================");
		for(User vo: list) {
			daoImpl.do_save(vo);
			assertThat(1, is(1));
		}
		//-------------------------------------------
		//-등록Data조회
		//-------------------------------------------	
		LOG.debug("================================");
		LOG.debug("=4.등록Data조회=");
		LOG.debug("================================");	
		getIdList = (List<User>) daoImpl.get_userIdList(search);
		assertThat(list.size(), is(getIdList.size()));
		
		//-------------------
		//등록데이터 수정
		//-------------------
		User user = getIdList.get(0);
		user.setName(user.getName()+"_U");
		user.setNickname(user.getNickname()+"_U");
		user.setEmail(user.getEmail()+"_U");
		
		int flag = daoImpl.do_update(user);
		assertThat(flag, is(1));
		//-------------------
		//등록데이터 비교
		//-------------------		
		getIdList = (List<User>) daoImpl.get_userIdList(search);
		checkData(user, getIdList.get(0));
	}
	
	
	@Test
	@Ignore
	public void addAndGet() {
		//---------------------------
		//-ID값 찾기: ID LIKE
		//---------------------------
		LOG.debug("================================");
		LOG.debug("=1.ID값 찾기: ID LIKE=");
		LOG.debug("================================");
		
		UserSearch search = new UserSearch();
		search.setSearchWord("test");
		List<User> getIdList = (List<User>) daoImpl.get_userIdList(search);
		
		
		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=2.삭제=");
		LOG.debug("================================");
		for(User vo: getIdList) {
			daoImpl.do_delete(vo);
		}
		
		//-------------------------------------------
		//-등록
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=3.등록=");
		LOG.debug("================================");
		for(User vo: list) {
			daoImpl.do_save(vo);
			assertThat(1, is(1));
		}	
		//-------------------------------------------
		//-등록Data조회
		//-------------------------------------------	
		LOG.debug("================================");
		LOG.debug("=4.등록Data조회=");
		LOG.debug("================================");	
		getIdList = (List<User>) daoImpl.get_userIdList(search);
		assertThat(list.size(), is(getIdList.size()));
			
		//-------------------------------------------
		//-5 비교
		//-------------------------------------------			
		for(int i=0;i<list.size();i++) {
			checkData(list.get(i),getIdList.get(i));
		}		
	}
	
	
	private void checkData(User org, User vs) {
		assertThat(org.getId(), is(vs.getId()));
		assertThat(org.getPass(), is(vs.getPass()));
		assertThat(org.getName(), is(vs.getName()));
		assertThat(org.getNickname(), is(vs.getNickname()));
		assertThat(org.getEmail(), is(vs.getEmail()));
	
	}
	
	
	@Test
	@Ignore
	public void do_save() {
		//---------------------------
		//-ID값 찾기: ID LIKE
		//---------------------------
		LOG.debug("================================");
		LOG.debug("=ID값 찾기: ID LIKE=");
		LOG.debug("================================");
		
		UserSearch search = new UserSearch();
		search.setSearchWord("test");
		List<User> getIdList = (List<User>) daoImpl.get_userIdList(search);
		
		
		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=삭제=");
		LOG.debug("================================");
		for(User vo: getIdList) {
			daoImpl.do_delete(vo);
		}
		
		//-------------------------------------------
		//-등록
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=등록=");
		LOG.debug("================================");
		for(User vo: list) {
			daoImpl.do_save(vo);
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
		for(User vo: list) {
			daoImpl.do_delete(vo);
		}
	}
	
	
	@Test
	@Ignore
	public void id_check() {
		//---------------------------
		//-기존Data삭제
		//---------------------------
		LOG.debug("================================");
		LOG.debug("=1.기존Data삭제=");
		LOG.debug("================================");
		
		UserSearch search = new UserSearch();
		search.setSearchWord("_142");
		List<User> getIdList = (List<User>) daoImpl.get_userIdList(search);
		for(User vo: getIdList) {
			daoImpl.do_delete(vo);
		}
		//-------------------------------------------
		//-등록
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=2.등록=");
		LOG.debug("================================");
		for(User vo: list) {
			daoImpl.do_save(vo);
			assertThat(1, is(1));
		}		
		
		LOG.debug("#####id_check");
		User vo = list.get(0);
		int check = daoImpl.id_check(vo);
		
		if(check==0) {
			LOG.debug("중복된 아이디가 없습니다.");
		}else{
			LOG.debug("이 아이디를 사용할 수 없습니다.");
		}
		
	}
	
	@Test
	public void passwd_check() {
		//---------------------------
		//-기존Data삭제
		//---------------------------
		LOG.debug("================================");
		LOG.debug("=1.기존Data삭제=");
		LOG.debug("================================");
		
		UserSearch search = new UserSearch();
		search.setSearchWord("_142");
		List<User> getIdList = (List<User>) daoImpl.get_userIdList(search);
		for(User vo: getIdList) {
			daoImpl.do_delete(vo);
		}
		//-------------------------------------------
		//-등록
		//-------------------------------------------
		LOG.debug("================================");
		LOG.debug("=2.등록=");
		LOG.debug("================================");
		for(User vo: list) {
			daoImpl.do_save(vo);
			assertThat(1, is(1));
		}		
		
		LOG.debug("#####id_check");
		User vo = list.get(0);
		int check = daoImpl.passwd_check(vo);
		
		if(check==1) {
			LOG.debug("비밀번호가 맞습니다.");
		}else{
			LOG.debug("비밀번호가 잘못되었습니다.");
		}
		
	}
	
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=userDaoImpl="+daoImpl);
		LOG.debug("====================");
		assertThat(context,  is(notNullValue()));
		assertThat(daoImpl,  is(notNullValue()));
	}
	
	
	@After
	public void tearDown() {
	
	}
	
	
	
}


