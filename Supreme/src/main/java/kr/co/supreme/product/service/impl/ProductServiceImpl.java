package kr.co.supreme.product.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.product.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	private ProductDaoImpl productDaoImpl;
	
	
	@Override
	public String excelDown(Search vo, String ext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int do_update(DTO dto) {
		
		return productDaoImpl.do_update(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return productDaoImpl.do_delete(dto);
	}

	@Override
	public int do_save(DTO dto) {
		// TODO Auto-generated method stub
		return productDaoImpl.do_save(dto);
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return productDaoImpl.get_selectOne(dto);
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		// TODO Auto-generated method stub
		return productDaoImpl.get_retrieve(dto);
	}

	

	
}
