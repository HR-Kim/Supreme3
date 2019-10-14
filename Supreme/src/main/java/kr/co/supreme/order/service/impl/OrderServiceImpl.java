package kr.co.supreme.order.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import kr.co.supreme.cmn.DTO;
import kr.co.supreme.order.service.Order;
import kr.co.supreme.order.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());



	
	@Autowired
	private OrderDaoImpl orderDaoImpl; // 인터페이스 통해 만들어야함
	
	
	@Override
	public int do_update(DTO dto) {
		
		return orderDaoImpl.do_update(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		return orderDaoImpl.do_delete(dto);
	}

	@Override
	public int do_save(DTO dto) {
		
		return orderDaoImpl.do_save(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		 
		Order outVO = (Order) orderDaoImpl.get_selectOne(dto);
		
		//조회 Count증가
		if(null !=outVO) {	
			orderDaoImpl.do_updateReadCnt(dto);
		}
		
		return outVO;
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		return orderDaoImpl.get_retrieve(dto);
	}


	

}