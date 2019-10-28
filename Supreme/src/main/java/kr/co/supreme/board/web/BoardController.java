package kr.co.supreme.board.web;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.code.service.Code;
import kr.co.supreme.code.service.CodeService;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.board.service.Board;
import kr.co.supreme.board.service.BoardService;

@Controller
public class BoardController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	CodeService  codeService;

	
	
	//view
	private final String VIEW_LIST_NM ="board/board_mng";
	private final String VIEW_MNG_NM  ="board/board_write";
	

	
	/**수정 */
	@RequestMapping(value="board/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody		
	public String do_update(Board board) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=board="+board);
		LOG.debug("============================");		
		if(null == board.getId() || "".equals(board.getId().trim())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		
		if(null == board.getbTitle() || "".equals(board.getbTitle().trim())) {
			throw new IllegalArgumentException("제목을 입력 하세요.");
		}
		
		if(null == board.getbContents() || "".equals(board.getbContents().trim())) {
			throw new IllegalArgumentException("내용을 입력 하세요.");
		}		
		
		int flag = this.boardService.do_update(board);
		Message  message=new Message();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정 되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정 실패.");			
		}
		
		Gson gson=new Gson();
		gsonStr = gson.toJson(message);		
		
		
		return gsonStr;
		
	}

	/**삭제 */
	@RequestMapping(value="board/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_delete(Board board) {
		LOG.debug("============================");
		LOG.debug("=board="+board);
		LOG.debug("============================");
		
		int flag = this.boardService.do_delete(board);
		Message  message=new Message();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 실패.");			
		}
		
		Gson gson=new Gson();
		String gsonStr = gson.toJson(message);
		
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");		
		
		return gsonStr;
	}

	/**저장 */
	@RequestMapping(value="board/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String do_save(Board board) {
		LOG.debug("============================");
		LOG.debug("=board="+board);
		LOG.debug("============================");
		
		if(null == board.getbTitle() || "".equals(board.getbTitle().trim())) {
			throw new IllegalArgumentException("제목을 입력 하세요.");
		}
		
		if(null == board.getbContents() || "".equals(board.getbContents().trim())) {
			throw new IllegalArgumentException("내용을 입력 하세요.");
		}
		
		int flag = this.boardService.do_save(board);
		Message  message=new Message();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 실패.");			
		}
		
		Gson gson=new Gson();
		String gsonStr = gson.toJson(message);
		
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");				
		
		return gsonStr;
	}

	/**단건조회 */
	@RequestMapping(value="board/do_selectOne.do",method = RequestMethod.GET)
	public String get_selectOne(Board board,Model model) {
		LOG.debug("============================");
		LOG.debug("=board="+board);
		LOG.debug("============================");
		
		if(0 == board.getbSeq() || "".equals(board.getbSeq())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		
		Board outVO= (Board) this.boardService.get_selectOne(board);
		model.addAttribute("vo", outVO);
		
		return VIEW_MNG_NM;
	}
	
	
	/**목록조회 */
	@RequestMapping(value="board/get_retrieve.do",method = RequestMethod.GET)
	public String get_retrieve(HttpServletRequest req,Search search, Model model) {
		//param
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}		
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
		model.addAttribute("vo", search);
		
		LOG.debug("============================");
		LOG.debug("=search="+search);
		LOG.debug("============================");		
		Code code=new Code();
		code.setCodeId("PAGE_SIZE");
		//목록조회
		List<Code> listPageSize=(List<Code>) this.codeService.get_retrieve(code);
		model.addAttribute("listPageSize", listPageSize);
		
		//엑셀타입
		code.setCodeId("EXCEL_TYPE");
		List<Code> listExcelType=(List<Code>) this.codeService.get_retrieve(code);		
		model.addAttribute("listExcelType", listExcelType);
				
		
		//게시판 검색 구분
		code.setCodeId("BOARD_SEARCH");
		List<Code> listBoardSearch=(List<Code>) this.codeService.get_retrieve(code);		
		model.addAttribute("listBoardSearch", listBoardSearch);
				
		List<Board> list = (List<Board>) this.boardService.get_retrieve(search);
		model.addAttribute("list", list);
		
		//총건수
		int totalCnt = 0;
		if(null != list && list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		model.addAttribute("totalCnt", totalCnt);
		return VIEW_LIST_NM;
	}
}








