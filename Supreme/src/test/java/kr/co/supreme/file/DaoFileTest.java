package kr.co.supreme.file;

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
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.file.service.File;
import kr.co.supreme.file.service.impl.FileDaoImpl;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//@Test NAME_ASCENDING으로 수행.
public class DaoFileTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private FileDaoImpl daoImpl;
	
	
	List<File> list;
	
	@Before
	public void setUp() {
		//	public File(String fileId, String orgFileNm, String division, String saveFileNm, long fSize, String ext,
		//String regId, String regDt) {
		String fileId = StringUtil.cureDate("yyyyMMdd")+""+StringUtil.getUUID();
		
		LOG.debug(fileId.length()+"");
		list = Arrays.asList( 
				 new File(fileId,1,"J01_원본파일_142.txt","BOARD_ATTR","J01_저장파일_142.txt",10000,"txt","admin","")
				,new File(fileId,2,"J02_원본파일_142.txt","BOARD_ATTR","J02_저장파일_142.txt",20000,"txt","admin","")				
				,new File(fileId,3,"J03_원본파일_142.txt","BOARD_ATTR","J03_저장파일_142.txt",30000,"txt","admin","")
				,new File(fileId,4,"J04_원본파일_142.txt","BOARD_ATTR","J04_저장파일_142.txt",40000,"txt","admin","")
				,new File(fileId,5,"J05_원본파일_142.txt","BOARD_ATTR","J05_저장파일_142.txt",50000,"txt","admin","")
				
				);
		
	}
	
	
	
	
	@Test
	@Ignore
	public void get_file_count() {
		//-------------------
		//기존Data삭제
		//-------------------
		Search search=new Search();
		search.setSearchWord("_142");
		List<File> getIdList = (List<File>) daoImpl.get_fileIdOrgFileNmList(search);
		for(File vo:getIdList) {
			daoImpl.do_delete(vo);
		}
		
		
		//-------------------
		//등록
		//-------------------
		for(File vo: list) {
			int flag = daoImpl.do_save(vo);
			assertThat(1, is(flag));
		}
		getIdList = (List<File>) daoImpl.get_fileIdOrgFileNmList(search);
		assertThat(5, is(getIdList.size()));
		
		
		int fileCnt = daoImpl.get_file_count(getIdList.get(0));
		assertThat(5, is(fileCnt));
	}
	
	@Test
	@Ignore
	public void num_max_plus_one() {
		//-------------------
		//기존Data삭제
		//-------------------
		Search search=new Search();
		search.setSearchWord("_142");
		List<File> getIdList = (List<File>) daoImpl.get_fileIdOrgFileNmList(search);
		for(File vo:getIdList) {
			daoImpl.do_delete(vo);
		}
		
		
		//-------------------
		//등록
		//-------------------
		for(File vo: list) {
			int flag = daoImpl.do_save(vo);
			assertThat(1, is(flag));
		}
		getIdList = (List<File>) daoImpl.get_fileIdOrgFileNmList(search);
		assertThat(5, is(getIdList.size()));
		
		
		int maxNum = daoImpl.num_max_plus_one(getIdList.get(0));
		assertThat(6, is(maxNum));
	}
	
	
	@Test
//	@Ignore
	public void addAndGet() {
		//-------------------
		//기존Data삭제
		//-------------------
		Search search=new Search();
		search.setSearchWord("_142");
		List<File> getIdList = (List<File>) daoImpl.get_fileIdOrgFileNmList(search);
		for(File vo:getIdList) {
			daoImpl.do_delete(vo);
		}
		
		//=====================================
		//1. Data등록
		//=====================================
		for(File vo:list) { 
			int flag = daoImpl.do_save(vo);
			assertThat(1, is(flag));
		}
		
		//=====================================
		//2. 등록Data조회
		//=====================================
		List<File> addlistData = (List<File>) daoImpl.get_retrieve(list.get(0));
		assertThat(5, is(addlistData.size()));
		
		//=====================================
		//3. 비교:boardId는 자동증가로 비교 할수 없음.(제목,내용,등록자)
		//=====================================			
		for(int i=0;i<list.size();i++) {
			checkData(addlistData.get(i),list.get(i));
		}
	}
	
	private void checkData(File org,File vs) {
		assertThat(org.getFileId(), is(vs.getFileId()));
		assertThat(org.getNum(), is(vs.getNum()));
		assertThat(org.getOrgFileNm(), is(vs.getOrgFileNm()));
		assertThat(org.getSaveFileNm(), is(vs.getSaveFileNm()));
		assertThat(org.getDivision(), is(vs.getDivision()));
	}
	
	//FileID테스트 
	@Test
	@Ignore
	public void do_save() {
		//=====================================
		//1. Data등록
		//=====================================
		for(File vo:list) { 
			int flag = daoImpl.do_save(vo);
			assertThat(1, is(flag));
		}
	}
	
	@Test
	@Ignore
	public void do_delete() {
		daoImpl.do_delete(list.get(0));
	}
	
	
	
	@Test
	public void getBean() {
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=boardDaoImpl="+daoImpl);
		LOG.debug("====================");
		assertThat(context,  is(notNullValue()));
		assertThat(daoImpl,  is(notNullValue()));
	}
	
	
	@After
	public void tearDown() {
	
	}
	
	
	
}


