package kr.co.supreme.user.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.user.service.User;

@Repository
public class UserDaoImpl implements WorkDiv {
	Logger LOG=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "kr.co.supreme.user";
	
	
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
		Search search = (Search) dto;		
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
		Search search = (Search) dto;
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
