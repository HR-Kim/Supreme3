package kr.co.supreme.board.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import kr.co.supreme.board.service.Board;
import kr.co.supreme.board.service.BoardService;
import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.user.service.User;


@Service
public class BoardServiceImpl implements BoardService {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());



	
	@Autowired
	private BoardDaoImpl boardDaoImpl; // 인터페이스 통해 만들어야함
	
	
	@Override
	public int do_update(DTO dto) {
		
		return boardDaoImpl.do_update(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		return boardDaoImpl.do_delete(dto);
	}

	@Override
	public int do_save(DTO dto) {
		
		return boardDaoImpl.do_save(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		 
		Board outVO = (Board) boardDaoImpl.get_selectOne(dto);
		
		//조회 Count증가
		if(null !=outVO) {	
			boardDaoImpl.do_updateReadCnt(dto);
		}
		
		return outVO;
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		return boardDaoImpl.get_retrieve(dto);
	}


	

}
