package kr.co.supreme.myitem.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.myitem.service.MyItem;
import kr.co.supreme.myitem.service.MyItemService;

@Service
public class MyItemServiceImpl implements MyItemService {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyItemDaoImpl myItemDaoImpl;
	
	
	@Override
	public int do_update(DTO dto) {
		return myItemDaoImpl.do_update(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		return myItemDaoImpl.do_delete(dto);
	}

	@Override
	public int do_save(DTO dto) {
		return myItemDaoImpl.do_save(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		MyItem outVO = (MyItem) myItemDaoImpl.get_selectOne(dto);
		
		if(null !=outVO) {
			myItemDaoImpl.do_updateReadCnt(dto);
		}
		
		return outVO;
		
		
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		return myItemDaoImpl.get_retrieve(dto);
	}

}
