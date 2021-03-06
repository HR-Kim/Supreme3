package kr.co.supreme.user.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;

/**
 * 사용자관리 Interface
 * @author sist
 *
 */
public interface UserService {
	/**id,비번 체크 */
	public DTO idPassCheck(DTO dto);	
	/**수정 */
	public int do_update(DTO dto);
	/**ExcelDown */
	public String excelDown(UserSearch vo,String ext);	
	/**목록조회 */
	public List<?> get_retrieve(DTO dto);
	/**삭제 */
	public int do_delete(DTO dto);
	/**단건조회 */
	public DTO get_selectOne(DTO dto);
	/**저장 */
	public int do_save(DTO dto);
	/**등업*/
	public void tx_upgradeLevels() throws SQLException;
	
	public int id_check(DTO dto);
	
	public int passwd_check(DTO dto);
	
	public int tel_check(DTO dto);
	
	/**id찾기 */
	public DTO id_find(DTO dto);
	/**pw찾기 */
	public DTO pw_find(DTO dto);
	
}
