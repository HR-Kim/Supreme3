package kr.co.supreme.cart.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.supreme.cart.service.Cart;
import kr.co.supreme.cart.service.CartService;
import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;

@Service
public class CartServiceImpl implements CartService{

private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CartDaoImpl cartDaoImpl;
	
	
	
	@Override
	public int do_update(DTO dto) {
		
		return cartDaoImpl.do_update(dto);
	}
	@Override
	public int do_delete(DTO dto) {
		return cartDaoImpl.do_delete(dto);
	}

	@Override
	public int do_save(DTO dto) {
		
		return cartDaoImpl.do_save(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		 
		Cart outVO = (Cart) cartDaoImpl.get_selectOne(dto);
		
		//조회 Count증가
		if(null !=outVO) {	
			cartDaoImpl.do_updateReadCnt(dto);
		}
		
		return outVO;
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		return cartDaoImpl.get_retrieve(dto);
	}

}
