package kr.co.supreme.myitem;

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

import kr.co.supreme.cmn.Search;
import kr.co.supreme.myitem.service.MyItem;
import kr.co.supreme.myitem.service.impl.MyItemDaoImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoMyItemTest {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private MyItemDaoImpl myItemDaoImpl;
	
	List<MyItem> list;
	
	@Before
	public void setUp() {
		
		list = Arrays.asList(
				new MyItem(000001,"test01",95,"19/10/11","","",0),
				new MyItem(000002,"test01",96,"19/10/11","","",0),
				new MyItem(000003,"test02",95,"19/10/11","","",0),
				new MyItem(000004,"test02",96,"19/10/11","","",0)
				);
		
		
		LOG.debug("#####setUp");
	}
	
	@Test
	@Ignore
	public void get_retrive() {
		LOG.debug("=get_retrive=");
		Search search=new Search();
		//등록Data조회
		search.setSearchDiv("10");
		search.setPageSize(10);
		search.setPageNum(1);
		search.setSearchWord("");
		List<MyItem> getIdList = (List<MyItem>) myItemDaoImpl.get_IdList(search);
		
		List<MyItem> list = (List<MyItem>) myItemDaoImpl.get_retrieve(search);
		
		
		
	}
		
	
	
	@Test
	@Ignore
	public void do_save() {
		//ID값
		Search search=new Search();
		search.setSearchWord("");
		List<MyItem> getIdList = (List<MyItem>) myItemDaoImpl.get_IdList(search);
		
		LOG.debug(getIdList+"==getIdList==");
		
		//삭제
		for(MyItem vo:getIdList) {
			myItemDaoImpl.do_delete(vo);
		}
		
		
		//등록
		for(MyItem vo:list) {
			myItemDaoImpl.do_save(vo);
		}
		
		
		
	}
	
	@Test
	@Ignore
	public void do_delete() {
		LOG.debug("#####do_delete");
		//삭제
		for(MyItem vo:list) {
			myItemDaoImpl.do_delete(vo);
		}
		
	}
	
	
	
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=myItemDaoImpl="+myItemDaoImpl);
		LOG.debug("====================");
		
		assertThat(context,  is(notNullValue()));
		assertThat(myItemDaoImpl,  is(notNullValue()));
		
	}

	@After
	public void tearDown() {
		LOG.debug("#####tearDown");
	}
	
}
