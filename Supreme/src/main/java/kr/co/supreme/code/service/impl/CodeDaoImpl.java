package kr.co.supreme.code.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.WorkDiv;
import kr.co.supreme.code.service.Code;



@Repository
public class CodeDaoImpl implements WorkDiv {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Code> codeMapper=new RowMapper<Code>() {

		@Override
		public Code mapRow(ResultSet rs, int rowNum) throws SQLException {
			Code vo=new Code();
			vo.setCodeId(rs.getString("code_id"));
			vo.setCodeNm(rs.getString("code_nm"));
			vo.setNum(rs.getInt("num"));
			return vo;
		}
		
	};
	
	
	
	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int do_save(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO get_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> get_retrieve(DTO dto) {
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT b.code_id,                   \n");
		sb.append("        b.code_nm,                   \n");
		sb.append("        b.num                        \n");
		sb.append(" FROM code_type a join code b        \n");
		sb.append(" ON a.code_type_id = b.code_type_id  \n");
		sb.append(" WHERE a.code_type_id = ?            \n");
		sb.append(" AND b.use_yn = 1                    \n");
		sb.append(" ORDER BY b.num                      \n");
		
		Code inVO = (Code) dto;
		LOG.debug("1==================================");
		LOG.debug("1=param="+inVO);
		LOG.debug("1==================================");
		
		LOG.debug("2==================================");
		LOG.debug("2=sql=\n"+sb.toString());
		LOG.debug("2==================================");
		
		List<Code> list = this.jdbcTemplate.query(sb.toString()
				   ,new Object[] {inVO.getCodeId()} 
				   ,this.codeMapper);
		
		LOG.debug("3==================================");
		LOG.debug("3=list=\n"+list);
		LOG.debug("3==================================");		
		
		return list;
	}

	@Override
	public List<?> get_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
