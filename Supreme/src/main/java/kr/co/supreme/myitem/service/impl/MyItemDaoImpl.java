package kr.co.supreme.myitem.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.myitem.service.MyItem;

@Repository
public class MyItemDaoImpl implements WorkDiv {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private final String NAMESPACE = "kr.co.supreme.myitem";

	/** read count 증가 */
	public int do_updateReadCnt(DTO dto) {
		String statement = NAMESPACE + ".do_updateReadCnt";
		MyItem myItem = (MyItem) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:" + myItem);
		LOG.debug("=========================");

		LOG.debug("=========================");
		LOG.debug("2. statement:" + statement);
		LOG.debug("=========================");

		int flag = this.sqlSessionTemplate.update(statement, myItem);
		LOG.debug("=========================");
		LOG.debug("3. flag:" + flag);
		LOG.debug("=========================");
		return flag;
	}

	@Override
	public int do_update(DTO dto) {
		String statement = NAMESPACE + ".do_update";
		MyItem myItem = (MyItem) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:" + myItem);
		LOG.debug("=========================");

		LOG.debug("=========================");
		LOG.debug("2. statement:" + statement);
		LOG.debug("=========================");

		int flag = this.sqlSessionTemplate.update(statement, myItem);
		LOG.debug("=========================");
		LOG.debug("3. flag:" + flag);
		LOG.debug("=========================");
		return flag;
	}

	@Override
	public int do_delete(DTO dto) {
		String statement = NAMESPACE + ".do_delete";
		MyItem myItem = (MyItem) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:" + myItem);
		LOG.debug("=========================");

		LOG.debug("=========================");
		LOG.debug("2. statement:" + statement);
		LOG.debug("=========================");

		int flag = this.sqlSessionTemplate.delete(statement, myItem);
		LOG.debug("=========================");
		LOG.debug("3. flag:" + flag);
		LOG.debug("=========================");
		return flag;
	}

	@Override
	public int do_save(DTO dto) {
		String statement = this.NAMESPACE + ".do_save";
		MyItem myItem = (MyItem) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:" + myItem);
		LOG.debug("=========================");
		LOG.debug("=========================");
		LOG.debug("2. statement:" + statement);
		LOG.debug("=========================");
		int flag = this.sqlSessionTemplate.insert(statement, myItem);
		LOG.debug("=========================");
		LOG.debug("3. flag:" + flag);
		LOG.debug("=========================");
		return flag;
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		String statement = this.NAMESPACE + ".get_selectOne";
		MyItem myItem = (MyItem) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:" + myItem);
		LOG.debug("2. statement:" + statement);
		MyItem outVO = this.sqlSessionTemplate.selectOne(statement, myItem);
		LOG.debug("3. outVO:" + outVO);
		LOG.debug("=========================");
		return outVO;
	}

	public List<?> get_IdList(DTO dto) {
		String statement = this.NAMESPACE + ".get_IdList";
		Search search = (Search) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:" + search);
		LOG.debug("2. statement:" + statement);
		List<MyItem> list = this.sqlSessionTemplate.selectList(statement, search);
		LOG.debug("3. list:" + list);
		LOG.debug("=========================");
		return list;
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		String statement = this.NAMESPACE + ".get_retrieve";
		Search search = (Search) dto;
		LOG.debug("=========================");
		LOG.debug("1. param:" + search);
		LOG.debug("2. statement:" + statement);
		List<MyItem> list = this.sqlSessionTemplate.selectList(statement, search);
		LOG.debug("3. list:" + list);
		LOG.debug("=========================");
		return list;
	}

	@Override
	public List<?> get_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
