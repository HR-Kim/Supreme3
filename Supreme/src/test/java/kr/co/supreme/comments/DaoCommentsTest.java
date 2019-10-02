package kr.co.supreme.comments;

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

import kr.co.supreme.comments.service.Comments;
import kr.co.supreme.comments.service.impl.CommentsDaoImpl;
import kr.co.supreme.cmn.Search;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoCommentsTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private CommentsDaoImpl commentsDaoImpl;
	
	
	List<Comments> list;
	
	@Before
	public void setUp() {
	
		list = Arrays.asList(
				 new Comments(1,1,"admin","content1","","admin","")
				,new Comments(2,2,"admin","content2","","admin","")
				,new Comments(3,3,"admin","content3","","admin","")
				,new Comments(4,4,"admin","content4","","admin","")
				,new Comments(5,5,"admin","content5","","admin","")
				);
		
	}
	
	@Test
	@Ignore
	public void get_retrieve() {
		LOG.debug("======================================");
		LOG.debug("=01. 기존 데이터 삭제=");
		LOG.debug("======================================");	
		Search search=new Search();
		search.setSearchWord("");
		List<Comments> getList = (List<Comments>) commentsDaoImpl.get_IdList(search);
		for(Comments vo:getList) {
			commentsDaoImpl.do_delete(vo);
		}	
		
//		LOG.debug("======================================");
//		LOG.debug("=02. 데이터 추가=");
//		LOG.debug("======================================");	
		for(Comments vo:list) { 
			int flag = commentsDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}		
//		
		//=====================================
		//2.01 등록Data조회
		//=====================================
		search.setSearchDiv("10");
		search.setPageSize(10);
		search.setPageNum(1);
		
		List<Comments> list = (List<Comments>) commentsDaoImpl.get_retrieve(search);
		assertThat(5, is(list.size()));		
	}
	
	

	
	@Test
	//@Ignore
	public void do_save() {
		//---------------------------
		//-ID값 찾기: TITLE LIKE
		//---------------------------
		Search search=new Search();
		search.setSearchWord("");
		List<Comments> getIdList = (List<Comments>) commentsDaoImpl.get_IdList(search);
	
		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		for(Comments vo:getIdList) {
			commentsDaoImpl.do_delete(vo);
		}
		
		
		//-------------------------------------------
		//-등록
		//-------------------------------------------		
		for(Comments vo:list) {
			int flag = commentsDaoImpl.do_save(vo);
			assertThat(1, is(1));
		}
	}
		
	@Test
	//@Ignore
	public void do_delete() {
		LOG.debug("#####do_delete");
		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		for(Comments vo:list) {
			commentsDaoImpl.do_delete(vo);
		}
	}
	
	@Test
	@Ignore
	public void do_update() {
		LOG.debug("======================================");
		LOG.debug("=01. 기존 데이터 삭제=");
		LOG.debug("======================================");
		Search search=new Search();
		search.setSearchWord("");
		List<Comments> getList = (List<Comments>) commentsDaoImpl.get_IdList(search);
		for(Comments vo:getList) {
			commentsDaoImpl.do_delete(vo);
		}		
		
		LOG.debug("======================================");
		LOG.debug("=02. 데이터 추가=");
		LOG.debug("======================================");
		for(Comments vo:list) { 
			int flag = commentsDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}		

		//=====================================
		//2.01 등록Data조회
		//=====================================
		List<Comments> addlistData = (List<Comments>) commentsDaoImpl.get_IdList(search);
		assertThat(5, is(addlistData.size()));
		LOG.debug("======================================");
		LOG.debug("=03. 데이터 수정=");
		LOG.debug("======================================");
		Comments comments = addlistData.get(0);
		
		comments.setContent(comments.getContent()+"_YJ");


		
		LOG.debug("======================================");
		LOG.debug("=03.01 데이터 수정=");
		LOG.debug("======================================");			
		int flag = commentsDaoImpl.do_update(comments);
		assertThat(1, is(flag));		
		
		LOG.debug("======================================");
		LOG.debug("=04. 등록 DATA조회=");
		LOG.debug("======================================");			
		addlistData = (List<Comments>) commentsDaoImpl.get_IdList(search);
		
		LOG.debug("======================================");
		LOG.debug("=05. 비교=");
		LOG.debug("======================================");
		this.checkData(comments, addlistData.get(0));
	}
	
	@Test
	@Ignore
	public void addAndGet() {
		//=====================================
		//0. 기존data삭제
		//=====================================		
		Search search=new Search();
		search.setSearchWord("");
		List<Comments> getList = (List<Comments>) commentsDaoImpl.get_IdList(search);
		for(Comments vo:getList) {
			commentsDaoImpl.do_delete(vo);
		}
		
		
		//=====================================
		//1. Data등록
		//=====================================
		for(Comments vo:list) { 
			int flag = commentsDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}
		
		//=====================================
		//2. 등록Data조회
		//=====================================
		List<Comments> comments = (List<Comments>) commentsDaoImpl.get_IdList(search);
		assertThat(5, is(comments.size()));
		
		
		//=====================================
		//3. 비교:boardId는 자동증가로 비교 할수 없음.(제목,내용,등록자)
		//=====================================		
		for(int i=0;i<list.size();i++) {
			checkData(comments.get(i),list.get(i));
		}
	}
	
	private void checkData(Comments org,Comments vs) {

		assertThat(org.getContent(), is(vs.getContent()));
		assertThat(org.getId(), is(vs.getId()));
		
	}
	
	
	
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=commentsDaoImpl="+commentsDaoImpl);
		LOG.debug("====================");
		assertThat(context,  is(notNullValue()));
		assertThat(commentsDaoImpl,  is(notNullValue()));
	}
	
	
	@After
	public void tearDown() {
	
	}
	
	
	
}


