package kr.co.supreme.comments.service.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.supreme.board.service.Board;
import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.comments.service.Comments;
import kr.co.supreme.comments.service.CommentsService;

@Controller
public class CommentsController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CommentsService commentsService;
	
	private final String VIEW_LIST_NM ="comments/comments_list";
	private final String VIEW_MNG_NM  ="comments/comments_mng";
	
	/**수정 */
	@RequestMapping(value="comments/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody		
	public String do_update(Comments comments) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=comments="+comments);
		LOG.debug("============================");		
		if(null == comments.getId() || "".equals(comments.getId().trim())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		
		if(null == comments.getContent() || "".equals(comments.getContent().trim())) {
			throw new IllegalArgumentException("내용을 입력 하세요.");
		}
		
		int flag = this.commentsService.do_update(comments);
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
	@RequestMapping(value="comments/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_delete(Comments comments) {
		LOG.debug("============================");
		LOG.debug("=comments="+comments);
		LOG.debug("============================");
		
		int flag = this.commentsService.do_delete(comments);
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
	@RequestMapping(value="comments/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String do_save(Comments comments) {
		LOG.debug("============================");
		LOG.debug("=comments="+comments);
		LOG.debug("============================");
		
		if(null == comments.getId() || "".equals(comments.getId().trim())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		
		if(null == comments.getContent() || "".equals(comments.getContent().trim())) {
			throw new IllegalArgumentException("내용을 입력 하세요.");
		}
		
		int flag = this.commentsService.do_save(comments);
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
	@RequestMapping(value="comments/do_selectOne.do",method = RequestMethod.GET)
	public String get_selectOne(Comments comments,Model model) {
		LOG.debug("============================");
		LOG.debug("=comments="+comments);
		LOG.debug("============================");
		
		if(null == comments.getId() || "".equals(comments.getId())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		
		Comments outVO= (Comments) this.commentsService.get_selectOne(comments);
		model.addAttribute("vo", outVO);
		
		return VIEW_MNG_NM;
	}
	
	
	/**목록조회 */
	@RequestMapping(value="comments/get_retrieve.do",method = RequestMethod.GET)
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
		
		
		//목록조회
		List<Comments> list = (List<Comments>) this.commentsService.get_retrieve(search);
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
