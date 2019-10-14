package kr.co.supreme.orderstatus.service.impl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.orderstatus.service.OrderStatusService;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderStatusDaoImpl orderStatusDaoImpl;
	
	
	@Override
	public int do_save(DTO dto) {
		
		return orderStatusDaoImpl.do_save(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int do_update(DTO dto) {
		return orderStatusDaoImpl.do_update(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		return orderStatusDaoImpl.get_selectOne(dto);
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		return orderStatusDaoImpl.get_retrieve(dto);
	}

}
