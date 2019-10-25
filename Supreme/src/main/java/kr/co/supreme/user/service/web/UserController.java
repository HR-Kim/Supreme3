package kr.co.supreme.user.service.web;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private final String VIEW_UPT_NM ="user/user_update";
	private final String VIEW_MNG_NM  ="user/user_mng";
	private final String VIEW_JOIN_NM  ="user/user_join";
	private final String VIEW_SECESS_NM  ="user/user_secession";
	private final String VIEW_ID_RESULT ="user/user_id_result";
	private final String VIEW_PW_RESULT ="user/user_pw_result";
	private final String VIEW_ADMIN_LOGIN = "admin/admin_login";
	
	
	/**로그아웃*/
	@RequestMapping(value="user/do_logout.do",method = RequestMethod.GET)
	@ResponseBody
	public void logout(User user,HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		LOG.debug("1=========================");
		LOG.debug("1===logout===");
		LOG.debug("1=========================");
		request.getSession().removeAttribute("user");
		
		session.invalidate();
		
				
			
	}
		
	
	
	/**관리자 로그인*/
	@RequestMapping(value="user/admin_do_login.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String admin_do_login(User user,HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		LOG.debug("1=========================");
		LOG.debug("1=user="+user);
		LOG.debug("1=========================");
		
		Message msg = (Message) userService.idPassCheck(user);
		LOG.debug("2=========================");
		LOG.debug("2=msg="+msg);
		LOG.debug("2=========================");
		if(msg.getMsgId().equals("10")||msg.getMsgId().equals("20")) {
			
		}else {
			//데이터 단건 조회
			User outVO = (User) userService.get_selectOne(user);
			LOG.debug("3=========================");
			LOG.debug("3=outVO="+outVO);
			LOG.debug("3=========================");	
			
			if(outVO.getLvl().equals("ADMIN")) {
//			Locale  locale=new Locale(user.getLang());
//			localeResolver.setLocale(request, response, locale);
			
				
			String email= outVO.getEmail();
			String email1 = email.substring(0, email.indexOf("@"));
			String email2 = email.substring(email.indexOf("@")+1);	
			session.setAttribute("user", outVO);
			session.setAttribute("email1", email1);
			session.setAttribute("email2", email2);
			msg.setMsgId("30");
			}else {
				msg.setMsgId("10");
				msg.setMsgMsg("정보가 잘못되었습니다. 확인해 주세요.");
			}
		}
		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(msg);
		LOG.debug("2=========================");
		LOG.debug("=@Controller=json=="+json);
		LOG.debug("2=========================");
		return json;
		
	}
	
	/**로그인*/
	@RequestMapping(value="user/do_login.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_login(User user,HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		LOG.debug("1=========================");
		LOG.debug("1=user="+user);
		LOG.debug("1=========================");
		
		Message msg = (Message) userService.idPassCheck(user);
		LOG.debug("2=========================");
		LOG.debug("2=msg="+msg);
		LOG.debug("2=========================");
		if(msg.getMsgId().equals("10")||msg.getMsgId().equals("20")) {
			
		}else {
			//데이터 단건 조회
			User outVO = (User) userService.get_selectOne(user);
			LOG.debug("3=========================");
			LOG.debug("3=outVO="+outVO);
			LOG.debug("3=========================");	
//			Locale  locale=new Locale(user.getLang());
//			localeResolver.setLocale(request, response, locale);
			
			String email= outVO.getEmail();
			String email1 = email.substring(0, email.indexOf("@"));
			String email2 = email.substring(email.indexOf("@")+1);	
			session.setAttribute("user", outVO);
			session.setAttribute("email1", email1);
			session.setAttribute("email2", email2);
		}
		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(msg);
		LOG.debug("2=========================");
		LOG.debug("=@Controller=json=="+json);
		LOG.debug("2=========================");
		return json;
		
	}
	
	
	/**id find */
	@RequestMapping(value="user/id_find.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String id_find(User user,Model model) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		

		
		User outVO=  (User) this.userService.id_find(user);
		
		Message  message=new Message();
		
		if(outVO==null) {
			message.setMsgId("0");
			message.setMsgMsg("일치하는 ID가 없습니다. 다시 확인해 주세요.");
		}else {
			message.setMsgId("1");
			message.setMsgMsg("회원님의 아이디는   "+outVO.getId()+" 입니다.");			
		}
		LOG.debug("============================");
		LOG.debug("=messageID="+message.getMsgId());
		LOG.debug("============================");
		LOG.debug("============================");
		LOG.debug("=messageID="+message.getMsgMsg());
		LOG.debug("============================");
		
		Gson gson=new Gson();
		gsonStr = gson.toJson(message);		
		
		
		return gsonStr;
	}
	
	
	/**pass find */
	@RequestMapping(value="user/pw_find.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String pw_find(User user,Model model) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		

		
		User outVO=  (User) this.userService.pw_find(user);
		
		
		Message  message=new Message();
		
		if(outVO==null) {
			message.setMsgId("0");
			message.setMsgMsg("일치하는 회원 정보가 없습니다. 다시 확인해 주세요.");
		}else {
			message.setMsgId("1");
			message.setMsgMsg("회원님의 비밀번호는   "+outVO.getPass()+" 입니다.");			
		}
		LOG.debug("============================");
		LOG.debug("=messageID="+message.getMsgId());
		LOG.debug("============================");
		LOG.debug("============================");
		LOG.debug("=messageID="+message.getMsgMsg());
		LOG.debug("============================");
		
		Gson gson=new Gson();
		gsonStr = gson.toJson(message);		
		
		
		return gsonStr;
	}
	
	
	
	/**password 체크 */
	@RequestMapping(value="user/passwd_check.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String passwd_check(User user,Model model) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		
		if(null == user.getId() || "".equals(user.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력 하세요.");
		}
		
		if(null == user.getPass() || "".equals(user.getPass().trim())) {
			throw new IllegalArgumentException("비밀번호를 입력 하세요.");
		}
	
		int flag = this.userService.passwd_check(user);
		Message  message=new Message();
		
		if(flag==1) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("비밀번호가 맞습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("잘못된 비밀번호를 입력하셨습니다.");			
		}
		
		Gson gson=new Gson();
		gsonStr = gson.toJson(message);		
		
		
		return gsonStr;
	}
	
	
	
	/**tel 중복체크 */
	@RequestMapping(value="user/tel_check.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String tel_check(User user,Model model) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=user="+user);
		LOG.debug("============================");
		
		if(null == user.getTel() || "".equals(user.getTel().trim())) {
			throw new IllegalArgumentException("전화번호를 입력 하세요.");
		}
		
	
		int flag = this.userService.tel_check(user);
		Message  message=new Message();
		
		if(flag==0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("전화번호를 사용할 수 있습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("이미 사용된 전화번호 입니다.");			
		}
		
		Gson gson=new Gson();
		gsonStr = gson.toJson(message);		
		
		
		return gsonStr;
	}
	
	
	/**id중복체크 */
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
			message.setMsgMsg("회원 정보가 수정되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("회원 정보 수정에 실패하였습니다.");			
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
			message.setMsgMsg("회원 정보가 삭제되었습니다. 묘한 생각을 이용해 주셔서 감사합니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("회원 정보 삭제에 실패하였습니다. 기존 비밀번호를 확인해 주세요.");			
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
			message.setMsgMsg("회원 가입이 완료되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("회원 가입에 실패하였습니다.");			
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
		String email= outVO.getEmail();
		String email1 = email.substring(0, email.indexOf("@"));
		String email2 = email.substring(email.indexOf("@")+1);
		
		model.addAttribute("vo", outVO);
		model.addAttribute("email1", email1);
		model.addAttribute("email2", email2);
		return VIEW_UPT_NM;
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

