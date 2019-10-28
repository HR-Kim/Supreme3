package kr.co.supreme.product.service;

import java.util.List;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Search;





public interface ProductService {

	

	public int do_stock_update(DTO dto);
	
	/** 수정 */
	public int do_update(DTO dto);

	/** 삭제 */
	public int do_delete(DTO dto);

	/** 저장 */
	public int do_save(DTO dto);

	/** 단건조회 */
	public DTO get_selectOne(DTO dto);

	/** 목록조회 */
	public List<?> get_retrieve(DTO dto);
	
	/** 목록조회 */
	public List<?> get_admin_retrieve(DTO dto);
	
}
