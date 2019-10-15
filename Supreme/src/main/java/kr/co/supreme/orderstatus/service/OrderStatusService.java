package kr.co.supreme.orderstatus.service;

import java.util.List;

import kr.co.supreme.cmn.DTO;

public interface OrderStatusService {
	/**저장 */
	public int do_save(DTO dto);
	/**삭제 */
	public int do_delete(DTO dto);
	/**수정 */
	public int do_update(DTO dto);
	/**단건조회 */
	public DTO get_selectOne(DTO dto);
	/**목록조회 */
	public List<?> get_retrieve(DTO dto);
	/**과거목록*/
	public List<?> get_previous_retrieve(DTO dto);
	/**현재 진행주문*/
	public List<?> get_current_retrieve(DTO dto);
}
