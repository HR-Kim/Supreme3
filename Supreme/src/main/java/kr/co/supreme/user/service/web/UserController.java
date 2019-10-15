package kr.co.supreme.user.service.web;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;


import kr.co.supreme.cmn.Message;

import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.code.service.Code;
import kr.co.supreme.code.service.CodeService;
import kr.co.supreme.user.service.User;
import kr.co.supreme.user.service.UserSearch;
import kr.co.supreme.user.service.UserService;

@Controller
public class UserController {

	
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private LocaleResolver localeResolver;//SessionLocaleResolver
	
//	@Resource(name="downloadView")
//	private View download;
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	CodeService codeService;
	
	
	//view
	private final String VIEW_LIST_NM ="user/user_list";
	private final String VIEW_MNG_NM  ="user/user_mng";
	private final String VIEW_JOIN_NM  ="user/user_join";
	
	
	
	/**단건조회 */
	@RequestMapping(value="user/id_check.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String id_check(User user,Model model) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		
		if(null == user.getId() || "".equals(user.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력 하세요.");
		}
		
	
		int flag = this.userService.id_check(user);
		Message  message=new Message();
		
		if(flag==0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("아이디를 사용할 수 있습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("아이디를 사용할 수 없습니다.");			
		}
		
		Gson gson=new Gson();
		gsonStr = gson.toJson(message);		
		
		
		return gsonStr;
	}
	
	
	/**수정 */
	@RequestMapping(value="user/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody		
	public String do_update(User user) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");		

		
		if(null == user.getId() || "".equals(user.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력 하세요.");
		}
		
	
		int flag = this.userService.do_update(user);
		Message  message=new Message();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정 되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정에 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		gsonStr = gson.toJson(message);		
		
		
		return gsonStr;
		
	}
	/**삭제 */
	@RequestMapping(value="user/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_delete(User user) {
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		
		int flag = this.userService.do_delete(user);
		Message  message=new Message();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제에 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		String gsonStr = gson.toJson(message);
		
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");		
		
		return gsonStr;
	}
	
	/**저장 */
	@RequestMapping(value="user/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String do_save(User user) {
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		
		if(null == user.getId() || "".equals(user.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력하세요.");
		}
		

		
		int flag = this.userService.do_save(user);
		Message  message=new Message();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록에 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		String gsonStr = gson.toJson(message);
		
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");				
		
		return gsonStr;
	}
	
	
	/**단건조회 */
	@RequestMapping(value="user/do_selectOne.do",method = RequestMethod.GET)
	public String get_selectOne(User user,Model model) {
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		
		if(null == user.getId() || "".equals(user.getId())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		
		User outVO=  (User) this.userService.get_selectOne(user);
		model.addAttribute("vo", outVO);
		
		return VIEW_MNG_NM;
	}
	
	/**목록조회 */
	//검색:user/get_retrieve.do
	@RequestMapping(value="user/get_retrieve.do",method=RequestMethod.GET)
	public String get_retrieve(HttpServletRequest req,UserSearch search, Model model) {
		LOG.debug("1=========================");
		LOG.debug("1=param="+search);
		LOG.debug("1=========================");
		
		/** 확장자 */
		String ext = StringUtil.nvl(req.getParameter("ext"));	
		
		
		
		//페이지 사이즈:10
		//페이지 번호:1
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}

		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}		
		
		
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
		LOG.debug("2=========================");
		LOG.debug("2=param="+search);
		LOG.debug("2=========================");

		model.addAttribute("vo", search);
		model.addAttribute("ext", ext);
		//Code:PAGE_SIZE
		Code code=new Code();
		code.setCodeId("PAGE_SIZE");
		//Code정보조회
		List<Code> codeList = (List<Code>) codeService.get_retrieve(code);
		model.addAttribute("codeList", codeList);
		
		code.setCodeId("USER_SEARCH");
		//Code정보조회
		List<Code> codeSearchList = (List<Code>) codeService.get_retrieve(code);
		model.addAttribute("codeSearchList", codeSearchList);
		
		code.setCodeId("USER_LVL");
		//Code정보조회
		List<Code> codeLvlList = (List<Code>) codeService.get_retrieve(code);
		model.addAttribute("codeLvlList", codeLvlList);
		
		
		code.setCodeId("EXCEL_TYPE");
		//엑셀유형Code정보조회
		List<Code> excelList = (List<Code>) codeService.get_retrieve(code);
		model.addAttribute("excelList", excelList);
		
		List<User> list = (List<User>) this.userService.get_retrieve(search);
		model.addAttribute("list", list);
		
		
		//총건수
		int totalCnt = 0;
		if(null !=list && list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		model.addAttribute("totalCnt", totalCnt);
		
		return VIEW_MNG_NM;
	}
	
	
	
}
