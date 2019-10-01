package kr.co.supreme.user;

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


import kr.co.supreme.user.service.User;
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
				
				 new User("test01", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test02", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test03", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01"),
				 new User("test04", "test", "test", "1", "test", "test", "11111", "test", "test", "test", "test", "19/10/01")
				);
		
	}
	
	@Test
	@Ignore
	public void do_save() {
		daoImpl.do_save(list.get(0));
	}
	

	
	@Test
	public void do_delete() {
		daoImpl.do_delete(list.get(0));
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


