package kr.co.supreme.user.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.user.service.UserService;

@Service
public class UserDaoServiceImpl implements UserService{
	Logger  LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	
	
	@Override
	public DTO idPassCheck(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int do_update(DTO dto) {
		
		return userDaoImpl.do_update(dto);
	}

	@Override
	public String excelDown(Search vo, String ext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		
		return userDaoImpl.get_retrieve(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		
		return userDaoImpl.do_delete(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		
		return userDaoImpl.get_selectOne(dto);
	}

	@Override
	public int do_save(DTO dto) {
		
		return userDaoImpl.do_save(dto);
	}

	@Override
	public void tx_upgradeLevels() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
