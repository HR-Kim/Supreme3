package kr.co.supreme.orderstatus.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.orderstatus.service.OrderStatus;


public class OrderStatusDaoImpl implements WorkDiv {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "kr.co.supreme.orderStatus";
	
	@Override
	public int do_update(DTO dto) {
		String statement = NAMESPACE+".do_update";
		OrderStatus orderStatus = (OrderStatus) dto;
		
		LOG.debug("=========================");
		LOG.debug("1. param:"+orderStatus);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.update(statement, orderStatus);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;		
	}

	@Override
	public int do_delete(DTO dto) {
		String statement = NAMESPACE+".do_delete";
		OrderStatus orderStatus = (OrderStatus) dto;
		
		LOG.debug("=========================");
		LOG.debug("1. param:"+orderStatus);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.delete(statement, orderStatus);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;		
	
	}

	@Override
	public int do_save(DTO dto) {
		String statement = this.NAMESPACE+".do_save";
		OrderStatus orderStatus = (OrderStatus) dto;
		
		LOG.debug("=========================");
		LOG.debug("1. param:"+orderStatus);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.insert(statement, orderStatus);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;		
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		String statement = this.NAMESPACE+".get_selectOne";
		OrderStatus orderStatus = (OrderStatus) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+orderStatus);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		OrderStatus outVO = this.sqlSessionTemplate.selectOne(statement, orderStatus);
		LOG.debug("=========================");
		LOG.debug("3. outVO:"+outVO);
		LOG.debug("=========================");			
		return outVO;		
	
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		String statement = this.NAMESPACE+".get_retrieve";
		Search search = (Search) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+search);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		List<OrderStatus> list = this.sqlSessionTemplate.selectOne(statement, search);
		LOG.debug("=========================");
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
