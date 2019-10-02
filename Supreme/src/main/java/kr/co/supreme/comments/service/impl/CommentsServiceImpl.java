package kr.co.supreme.comments.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.comments.service.Comments;
import kr.co.supreme.comments.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService{
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());



	
	@Autowired
	private CommentsDaoImpl commentDaoImpl; // 인터페이스 통해 만들어야함
	
	
	@Override
	public int do_update(DTO dto) {
		
		return commentDaoImpl.do_update(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		return commentDaoImpl.do_delete(dto);
	}

	@Override
	public int do_save(DTO dto) {
		
		return commentDaoImpl.do_save(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		 
		Comments outVO = (Comments) commentDaoImpl.get_selectOne(dto);
		
		//조회 Count증가
		if(null !=outVO) {	
			commentDaoImpl.do_updateReadCnt(dto);
		}
		
		return outVO;
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		return commentDaoImpl.get_retrieve(dto);
	}


	

}

