package kr.co.supreme.board;

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

import kr.co.supreme.board.service.Board;
import kr.co.supreme.board.service.impl.BoardDaoImpl;
import kr.co.supreme.cmn.Search;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoBoardTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private BoardDaoImpl boardDaoImpl;
	
	
	List<Board> list;
	
	@Before
	public void setUp() {
	
		list = Arrays.asList(
				 new Board(1,"title1","contents1","admin",0,"","admin","",1,2)
				,new Board(2,"title2","contents2","admin",0,"","admin","",1,2)
				,new Board(3,"title3","contents3","admin",0,"","admin","",1,2)
				,new Board(4,"title4","contents4","admin",0,"","admin","",1,2)
				,new Board(5,"title5","contents5","admin",0,"","admin","",1,2)
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
		List<Board> getList = (List<Board>) boardDaoImpl.get_IdList(search);
		for(Board vo:getList) {
			boardDaoImpl.do_delete(vo);
		}	
		
//		LOG.debug("======================================");
//		LOG.debug("=02. 데이터 추가=");
//		LOG.debug("======================================");	
		for(Board vo:list) { 
			int flag = boardDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}		
//		
		//=====================================
		//2.01 등록Data조회
		//=====================================
		search.setSearchDiv("10");
		search.setPageSize(10);
		search.setPageNum(1);
		
		List<Board> list = (List<Board>) boardDaoImpl.get_retrieve(search);
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
		List<Board> getIdList = (List<Board>) boardDaoImpl.get_IdList(search);
	
		//-------------------------------------------
		//-삭제
		//-------------------------------------------
		for(Board vo:getIdList) {
			boardDaoImpl.do_delete(vo);
		}
		
		
		//-------------------------------------------
		//-등록
		//-------------------------------------------		
		for(Board vo:list) {
			int flag = boardDaoImpl.do_save(vo);
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
		for(Board vo:list) {
			boardDaoImpl.do_delete(vo);
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
		List<Board> getList = (List<Board>) boardDaoImpl.get_IdList(search);
		for(Board vo:getList) {
			boardDaoImpl.do_delete(vo);
		}		
		
		LOG.debug("======================================");
		LOG.debug("=02. 데이터 추가=");
		LOG.debug("======================================");
		for(Board vo:list) { 
			int flag = boardDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}		

		//=====================================
		//2.01 등록Data조회
		//=====================================
		List<Board> addlistData = (List<Board>) boardDaoImpl.get_IdList(search);
		assertThat(5, is(addlistData.size()));
		LOG.debug("======================================");
		LOG.debug("=03. 데이터 수정=");
		LOG.debug("======================================");
		Board board = addlistData.get(0);
		
		board.setbTitle(board.getbTitle()+"_YJ");
		board.setbContents(board.getbContents()+"_YJ");

		
		LOG.debug("======================================");
		LOG.debug("=03.01 데이터 수정=");
		LOG.debug("======================================");			
		int flag = boardDaoImpl.do_update(board);
		assertThat(1, is(flag));		
		
		LOG.debug("======================================");
		LOG.debug("=04. 등록 DATA조회=");
		LOG.debug("======================================");			
		addlistData = (List<Board>) boardDaoImpl.get_IdList(search);
		
		LOG.debug("======================================");
		LOG.debug("=05. 비교=");
		LOG.debug("======================================");
		this.checkData(board, addlistData.get(0));
	}
	
	@Test
	@Ignore
	public void addAndGet() {
		//=====================================
		//0. 기존data삭제
		//=====================================		
		Search search=new Search();
		search.setSearchWord("");
		List<Board> getList = (List<Board>) boardDaoImpl.get_IdList(search);
		for(Board vo:getList) {
			boardDaoImpl.do_delete(vo);
		}
		
		
		//=====================================
		//1. Data등록
		//=====================================
		for(Board vo:list) { 
			int flag = boardDaoImpl.do_save(vo);
			assertThat(1, is(flag));
		}
		
		//=====================================
		//2. 등록Data조회
		//=====================================
		List<Board> addlistData = (List<Board>) boardDaoImpl.get_IdList(search);
		assertThat(5, is(addlistData.size()));
		
		
		//=====================================
		//3. 비교:boardId는 자동증가로 비교 할수 없음.(제목,내용,등록자)
		//=====================================		
		for(int i=0;i<list.size();i++) {
			checkData(addlistData.get(i),list.get(i));
		}
	}
	
	private void checkData(Board org,Board vs) {
		assertThat(org.getbTitle(), is(vs.getbTitle()));
		assertThat(org.getbContents(), is(vs.getbContents()));
		assertThat(org.getId(), is(vs.getId()));
		
	}
	
	
	
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=boardDaoImpl="+boardDaoImpl);
		LOG.debug("====================");
		assertThat(context,  is(notNullValue()));
		assertThat(boardDaoImpl,  is(notNullValue()));
	}
	
	
	@After
	public void tearDown() {
	
	}
	
	
	
}


