package kr.co.supreme.user.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.supreme.cmn.DTO;

import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.user.service.User;
import kr.co.supreme.user.service.UserSearch;

@Repository
public class UserDaoImpl implements WorkDiv {
	Logger LOG=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "kr.co.supreme.user";
	
	public UserDaoImpl() {}
	
	
	public DTO id_find(DTO dto) {
		String statement = this.NAMESPACE+".id_find";
		User inVO = (User) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+inVO);
		LOG.debug("2. statement:"+statement);
		User outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3. outVO:"+outVO);
		LOG.debug("=========================");
		return outVO;
	}
	
	public DTO pw_find(DTO dto) {
		String statement = this.NAMESPACE+".pw_find";
		User inVO = (User) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+inVO);
		LOG.debug("2. statement:"+statement);
		User outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3. outVO:"+outVO);
		LOG.debug("=========================");
		return outVO;
	}
	
	
	public List<User> getAll(){
		String statement = this.NAMESPACE+".get_all";
		
		LOG.debug("========================");
		LOG.debug("01.no param=");
		LOG.debug("========================");
		
		LOG.debug("========================");
		LOG.debug("02.statement="+statement);
		LOG.debug("========================");
		
		List<User> list = this.sqlSessionTemplate.selectList(statement);
		
		LOG.debug("========================");
		LOG.debug("03.list="+list);
		LOG.debug("========================");		
		return list;		
	}
	
	/**
	 * 비번check
	 * @param dto
	 * @return
	 */
	public int passwd_check(DTO dto) {
		String statement = this.NAMESPACE+".passwd_check";
		User user = (User) dto;
		LOG.debug("========================");
		LOG.debug("01.param="+user);
		LOG.debug("========================");
		
		LOG.debug("========================");
		LOG.debug("02.statement="+statement);
		LOG.debug("========================");
		
		int flag = this.sqlSessionTemplate.selectOne(statement, user);
		
		LOG.debug("========================");
		LOG.debug("03.flag="+flag);
		LOG.debug("========================");		
		return flag;
	}
	
	
	/**
	 * 아이디 체크
	 * 0<return :성공
	 * @param dto
	 * @return
	 */
	public int id_check(DTO dto) {
		String statement = this.NAMESPACE+".id_check";
		User user = (User) dto;
		LOG.debug("========================");
		LOG.debug("01.param="+user);
		LOG.debug("========================");
		
		LOG.debug("========================");
		LOG.debug("02.statement="+statement);
		LOG.debug("========================");
		
		int flag = this.sqlSessionTemplate.selectOne(statement, user);
		
		LOG.debug("========================");
		LOG.debug("03.flag="+flag);
		LOG.debug("========================");		
		return flag;
	}
	
	
	@Override
	public int do_update(DTO dto) {
		String statement = NAMESPACE+".do_update";
		User inVO = (User) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+inVO);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public int do_delete(DTO dto) {
		String statement = NAMESPACE+".do_delete";
		User inVO = (User) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+inVO);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
		
	}

	@Override
	public int do_save(DTO dto) {
		String statement = this.NAMESPACE+".do_save";
		User inVO = (User) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+inVO);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		String statement = this.NAMESPACE+".get_selectOne";
		User inVO = (User) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+inVO);
		LOG.debug("2. statement:"+statement);
		User outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3. outVO:"+outVO);
		LOG.debug("=========================");
		return outVO;
	}

	/** Test위해 존재: Like (ID추출) */
	public List<?> get_userIdList(DTO dto) {
		String statement = this.NAMESPACE+".get_userIdList";
		UserSearch search = (UserSearch) dto;		
		LOG.debug("=========================");
		LOG.debug("1. param:"+search);
		LOG.debug("2. statement:"+statement);
		List<User> list = this.sqlSessionTemplate.selectList(statement, search);
		LOG.debug("3. list:"+list);
		LOG.debug("=========================");
		return list;		
		
	}
	
	
	@Override
	public List<?> get_retrieve(DTO dto) {
		String statement = this.NAMESPACE+".get_retrieve";
		UserSearch search = (UserSearch) dto;
		String userLvl = "";
		LOG.debug("=========================");
		LOG.debug("1. param:"+search);
		LOG.debug("2. statement:"+statement);
		List<User> list = this.sqlSessionTemplate.selectList(statement, search);
		LOG.debug("3. list:"+list);
		LOG.debug("=========================");
		return list;		
	}

	@Override
	public List<?> get_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
