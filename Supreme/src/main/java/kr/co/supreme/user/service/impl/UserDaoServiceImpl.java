package kr.co.supreme.user.service.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.ExcelWriter;
import kr.co.supreme.cmn.Message;

import kr.co.supreme.user.service.User;
import kr.co.supreme.user.service.UserSearch;
import kr.co.supreme.user.service.UserService;

@Service
public class UserDaoServiceImpl implements UserService{
	Logger  LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
//	@Autowired
//	private ExcelWriter excelWriter;
	
	@Override
	public String excelDown(UserSearch vo, String ext) {
		return null;
		
	}
	
//	@Override
//	public String excelDown(Search vo, String ext) {
//		List<String> headers = Arrays.asList("아이디"
//											,"비밀번호"
//											,"이름"
//											,"레벨"
//											,"닉네임"
//											,"이메일"
//											,"우편번호"
//											,"주소1"
//											,"주소2"
//											,"전화번호"
//											,"이미지주소"
//											,"등록일"
//											);
//		List<User> list = (List<User>) userDaoImpl.get_retrieve(vo);
//		String saveFileNm = "";
//		if(ext.equalsIgnoreCase("csv")) {
//			saveFileNm = excelWriter.csvWriterGeneralization(list, headers);
//		}else if(ext.equalsIgnoreCase("xlsx")) {
//			saveFileNm = excelWriter.xlsxWriterGeneralization(list, headers);
//		}else if(ext.equalsIgnoreCase("xls")) {
//			saveFileNm = excelWriter.xlsWriterGeneralization(list, headers);
//		}
//		return saveFileNm;
//	}
	
	@Override
	public DTO idPassCheck(DTO dto) {
		Message outMsg  = new Message();
		//----------------------------------
		//1.Id체크
		//----------------------------------
		int flag = userDaoImpl.id_check(dto);
		if(flag<1) {
			outMsg.setMsgId("10");
			outMsg.setMsgMsg("아이디를 확인 하세요.");
			return outMsg;
		}
		
		//----------------------------------
		//2.비번체크
		//----------------------------------
		flag = userDaoImpl.passwd_check(dto);
		if(flag<1) {
			outMsg.setMsgId("20");
			outMsg.setMsgMsg("비밀번호를 확인 하세요.");
			return outMsg;
		}
		
		if(flag==1) {
			outMsg.setMsgId("30");
			
		}
		
		LOG.debug("===========================================");
		LOG.debug("=outMsg="+outMsg);
		LOG.debug("===========================================");
		return outMsg;
	}

	@Override
	public int do_update(DTO dto) {
		
		return userDaoImpl.do_update(dto);
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

	@Override
	public int id_check(DTO dto) {
		
		return userDaoImpl.id_check(dto);
	}

	@Override
	public int passwd_check(DTO dto) {
		
		return userDaoImpl.passwd_check(dto);
	}

	@Override
	public DTO id_find(DTO dto) {
		
		return userDaoImpl.id_find(dto);
	}

	@Override
	public DTO pw_find(DTO dto) {
		
		return userDaoImpl.pw_find(dto);
	}

	@Override
	public int tel_check(DTO dto) {

		return userDaoImpl.tel_check(dto);
	}

}
