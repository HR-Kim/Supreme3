//package kr.co.supreme.orderstatus.service.web;
//
//import java.io.File;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.mail.Message;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.View;
//
//import com.google.gson.Gson;
//
//import kr.co.supreme.cmn.Search;
//import kr.co.supreme.cmn.StringUtil;
//import kr.co.supreme.code.service.CodeService;
//import kr.co.supreme.orderstatus.service.OrderStatus;
//import kr.co.supreme.orderstatus.service.OrderStatusService;
//
//@Controller
//public class OrderStatusController {
//
//	Logger LOG = LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	OrderStatusService orderStatusService;
//	
//	@Autowired
//	CodeService  codeServaice;
//	
//	@Resource(name="downloadView")
//	private View download;
//	
//	
//	//view
//	private final String VIEW_LIST_NM ="board/board_list";
//	private final String VIEW_MNG_NM  ="board/board_mng";
//	
//	
//	/**수정 */
//	@RequestMapping(value="board/do_update.do",method = RequestMethod.POST
//			,produces = "application/json;charset=UTF-8")
//	@ResponseBody		
//	public String do_update(OrderStatus orderStatus) {
//		String gsonStr = "";
//		LOG.debug("============================");
//		LOG.debug("=orderStatus="+orderStatus);
//		LOG.debug("============================");		
//		if(null == orderStatus.getBoardId() || "".equals(orderStatus.getBoardId().trim())) {
//			throw new IllegalArgumentException("ID를 입력 하세요.");
//		}
//		
//		if(null == board.getTitle() || "".equals(board.getTitle().trim())) {
//			throw new IllegalArgumentException("제목을 입력 하세요.");
//		}
//		
//		if(null == board.getContents() || "".equals(orderStatus.getContents().trim())) {
//			throw new IllegalArgumentException("내용을 입력 하세요.");
//		}		
//		
//		int flag = this.orderStatusService.do_update(orderStatus);
//		Message  message=new Message();
//		
//		if(flag>0) {
//			message.setMsgId(String.valueOf(flag));
//			message.setMsgMsg("수정 되었습니다.");
//		}else {
//			message.setMsgId(String.valueOf(flag));
//			message.setMsgMsg("수정 실패.");			
//		}
//		
//		Gson gson=new Gson();
//		gsonStr = gson.toJson(message);		
//		
//		
//		return gsonStr;
//		
//	}
//
//	
//	/**저장 */
//	@RequestMapping(value="board/do_save.do",method = RequestMethod.POST
//			,produces = "application/json;charset=UTF-8")
//	@ResponseBody	
//	public String do_save(orderStatus board) {
//		LOG.debug("============================");
//		LOG.debug("=board="+board);
//		LOG.debug("============================");
//		
//		if(null == orderStatus.getTitle() || "".equals(orderStatus.getTitle().trim())) {
//			throw new IllegalArgumentException("제목을 입력 하세요.");
//		}
//		
//		if(null == orderStatus.getContents() || "".equals(orderStatus.getContents().trim())) {
//			throw new IllegalArgumentException("내용을 입력 하세요.");
//		}
//		
//		int flag = this.orderStatusService.do_save(board);
//		Message  message=new Message();
//		
//		if(flag>0) {
//			message.setMsgId(String.valueOf(flag));
//			message.setMsgMsg("등록 되었습니다.");
//		}else {
//			message.setMsgId(String.valueOf(flag));
//			message.setMsgMsg("등록 실패.");			
//		}
//		
//		Gson gson=new Gson();
//		String gsonStr = gson.toJson(message);
//		
//		LOG.debug("============================");
//		LOG.debug("=gsonStr="+gsonStr);
//		LOG.debug("============================");				
//		
//		return gsonStr;
//	}
//
//	/**단건조회 */
//	@RequestMapping(value="board/do_selectOne.do",method = RequestMethod.GET)
//	public String get_selectOne(Board board,Model model) {
//		LOG.debug("============================");
//		LOG.debug("=board="+board);
//		LOG.debug("============================");
//		
//		if(null == board.getBoardId() || "".equals(board.getBoardId())) {
//			throw new IllegalArgumentException("ID를 입력 하세요.");
//		}
//		
//		Board outVO= (Board) this.orderStatusService.get_selectOne(board);
//		model.addAttribute("vo", outVO);
//		
//		return VIEW_MNG_NM;
//	}
//	
//	
//	/**목록조회 */
//	@RequestMapping(value="board/get_retrieve.do",method = RequestMethod.GET)
//	public String get_retrieve(HttpServletRequest req,Search search, Model model) {
//		//param
//		if(search.getPageSize()==0) {
//			search.setPageSize(10);
//		}
//		
//		if(search.getPageNum()==0) {
//			search.setPageNum(1);
//		}		
//		
//		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
//		search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
//		model.addAttribute("vo", search);
//		
//		LOG.debug("============================");
//		LOG.debug("=search="+search);
//		LOG.debug("============================");		
//		
//		Code code=new Code();
//		//페이지사이즈
//		code.setCodeId("PAGE_SIZE");
//		
//		List<Code> listPageSize=(List<Code>) this.codeService.get_retrieve(code);
//		model.addAttribute("listPageSize", listPageSize);
//		
//		//엑셀타입
//		code.setCodeId("EXCEL_TYPE");
//		List<Code> listExcelType=(List<Code>) this.codeService.get_retrieve(code);		
//		model.addAttribute("listExcelType", listExcelType);
//		
//		//게시판 검색 구분
//		code.setCodeId("BOARD_SEARCH");
//		List<Code> listBoardSearch=(List<Code>) this.codeService.get_retrieve(code);		
//		model.addAttribute("listBoardSearch", listBoardSearch);
//		
//		//목록조회
//		List<Board> list = (List<Board>) this.orderStatusService.get_retrieve(search);
//		model.addAttribute("list", list);
//		
//		//총건수
//		int totalCnt = 0;
//		if(null != list && list.size()>0) {
//			totalCnt = list.get(0).getTotalCnt();
//		}
//		model.addAttribute("totalCnt", totalCnt);
//		return VIEW_LIST_NM;
//	}
//}
//
//
//
//
//
//
//
