package kr.co.supreme.order.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.supreme.board.service.Board;
import kr.co.supreme.cart.service.Cart;
import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.order.service.Order;

@Repository
public class OrderDaoImpl implements WorkDiv {
	Logger LOG=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "kr.co.supreme.order";
	
	public OrderDaoImpl() {} 
	
	/** read count 증가 */
	public int do_updateReadCnt(DTO dto) {
		String statement = NAMESPACE+".do_updateReadCnt";
		Order order = (Order) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+order);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.update(statement, order);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;		
	}
	
	@Override
	public int do_update(DTO dto) {
		String statement = NAMESPACE+".do_update";
		Order order = (Order) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+order);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.update(statement, order);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public int do_delete(DTO dto) {
		String statement = NAMESPACE+".do_delete";
		Order order = (Order) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:"+order);
		LOG.debug("=========================");
		
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");	
		
		int flag = this.sqlSessionTemplate.delete(statement, order);
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public int do_save(DTO dto) {
		
		String statement = this.NAMESPACE+".do_save";
		String statement2 = this.NAMESPACE+".cart_retrieve";
		String statement3 = this.NAMESPACE+".detail_save";
		String statement4 = this.NAMESPACE+".status_save";
		LOG.debug("여기0");
		Search search = new Search();
		LOG.debug("여기는?");
		search.setSearchWord("test01");
		LOG.debug("그럼 여기는?");
		String aaa="admin";
		Order order = (Order) dto;
		LOG.debug("여기1");
		LOG.debug("=========================");
		LOG.debug("1. param:"+order);
		LOG.debug("=========================");
		LOG.debug("여기2");
		LOG.debug("=========================");
		LOG.debug("2. statement:"+statement);
		LOG.debug("=========================");		
		LOG.debug("여기3");
		int flag = this.sqlSessionTemplate.insert(statement, order);
		List<Cart> list = this.sqlSessionTemplate.selectList(statement2, search);
		
		for(int i=0;i<list.size();i++) {
			order.setP_code(Integer.toString(list.get(i).getpCode()));
			order.setQuantitiy(Integer.toString(list.get(i).getQuantity()));
			order.setUnit_price(Integer.toString(list.get(i).getUnitPrice()));
			order.setDetail_code("123"+i); //주문 상세번호 난수 생성.
			this.sqlSessionTemplate.insert(statement3, order);	
			order.setOd_status("1"+i);
			this.sqlSessionTemplate.insert(statement4, order);
		}
			
		LOG.debug("=========================");
		LOG.debug("촤아아아아아!!!:"+list.get(0).getCartCode());
		LOG.debug("=========================");
		LOG.debug("여기4");
		LOG.debug("=========================");
		LOG.debug("3. flag:"+flag);
		LOG.debug("=========================");			
		return flag;
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		String statement = this.NAMESPACE+".get_selectOne";
		Order order = (Order) dto;	
		LOG.debug("=========================");
		LOG.debug("1. param:"+order);
		LOG.debug("2. statement:"+statement);
		Board outVO =this.sqlSessionTemplate.selectOne(statement, order);
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
		List<Board> list =this.sqlSessionTemplate.selectList(statement, search);
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
		List<Board> list =this.sqlSessionTemplate.selectList(statement, search);
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


