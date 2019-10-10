package kr.co.supreme.cart.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.supreme.cart.service.Cart;
import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.WorkDiv;

@Repository
public class CartDaoImpl implements WorkDiv{
	Logger LOG=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "kr.co.supreme.cart";
	
	/** read count 증가 */
	public int do_updateReadCnt(DTO dto) {
		String statement = NAMESPACE+".do_updateReadCnt";
		Cart cart = (Cart) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+cart);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.update(statement, cart);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;		
	}
	
	@Override
	public int do_update(DTO dto) {
		String statement = NAMESPACE+".do_update";
		Cart cart = (Cart) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+cart);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.update(statement, cart);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public int do_delete(DTO dto) {
		String statement = NAMESPACE+".do_delete";
		Cart cart = (Cart) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+cart);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.delete(statement, cart);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public int do_save(DTO dto) {
		String statement = this.NAMESPACE+".do_save";
		Cart cart = (Cart) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+cart);
		LOG.debug("=========================");
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");			
		int flag = this.sqlSessionTemplate.insert(statement, cart);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		String statement = this.NAMESPACE+".get_selectOne";
		Cart cart = (Cart) dto;		
		LOG.debug("=========================");
		LOG.debug("1. param:"+cart);
		LOG.debug("2. statement:"+statement);
		Cart outVO =this.sqlSessionTemplate.selectOne(statement, cart);
		LOG.debug("3. outVO:"+outVO);
		LOG.debug("=========================");
		return outVO;
	}


	public List<?> get_IdList(DTO dto){
		String statement = this.NAMESPACE+".get_IdList";
		Search search = (Search) dto;		
		LOG.debug("=========================");
		LOG.debug("1. param:"+search);
		LOG.debug("2. statement:"+statement);
		List<Cart> list =this.sqlSessionTemplate.selectList(statement, search);
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
		List<Cart> list =this.sqlSessionTemplate.selectList(statement, search);
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

