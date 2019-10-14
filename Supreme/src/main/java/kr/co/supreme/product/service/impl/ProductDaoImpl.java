package kr.co.supreme.product.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.product.service.Product;

@Repository
public class ProductDaoImpl implements WorkDiv {
	Logger LOG=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "kr.co.supreme.product";
	
	@Override
	public int do_update(DTO dto) {
		String statement = NAMESPACE+".do_update";
		Product product = (Product) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+product);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		

		int flag = this.sqlSessionTemplate.update(statement,product);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
		
	}

	@Override
	public int do_delete(DTO dto) {
		String statement = NAMESPACE+".do_delete";
		Product product = (Product) dto;
		
		LOG.debug("=========================");
		LOG.debug("1. param:"+product);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.delete(statement,product);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public int do_save(DTO dto) {
		String statement = this.NAMESPACE+".do_save";
		Product product = (Product) dto;
		
		LOG.debug("=========================");
		LOG.debug("1.param:"+product);
		LOG.debug("=========================");
		
		
		LOG.debug("=========================");
		LOG.debug("2.statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.insert(statement,product);
		LOG.debug("=========================");
		
		LOG.debug("3.flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		String statement = this.NAMESPACE+".get_selectOne";
		Product product = (Product) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+product);
		LOG.debug("2. statement:"+statement);
		Product outVO = this.sqlSessionTemplate.selectOne(statement,product);
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
		LOG.debug("2. statement:"+statement);
		List<Product> list = this.sqlSessionTemplate.selectList(statement,search);
		LOG.debug("3. list:"+list);
		LOG.debug("=========================");
		return list;	
	}

	@Override
	public List<?> get_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<?> get_productIdList(DTO dto){
		String statement = this.NAMESPACE+".get_productIdList";
		Search search = (Search) dto;		
		LOG.debug("=========================");
		LOG.debug("1. param:"+search);
		LOG.debug("2. statement:"+statement);
		List<Product> list =this.sqlSessionTemplate.selectList(statement, search);
		LOG.debug("3. list:"+list);
		LOG.debug("=========================");
		return list;		
	}

}
