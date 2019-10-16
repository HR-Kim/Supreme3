package kr.co.supreme.myitem.service.wep;

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

import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.myitem.service.MyItem;
import kr.co.supreme.myitem.service.MyItemService;


@Controller
public class MyItemController {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MyItemService myItemService;
	
	//view
	private final String VIEW_LIST_NM ="myitem/myitem_list";
	private final String VIEW_MNG_NM  ="myitem/myitem_mng";
	
	/**수정 */
	@RequestMapping(value="myitem/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody		
	public String do_update(MyItem myItem) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=myItem="+myItem);
		LOG.debug("============================");		

		
		if(null == myItem.getId() || "".equals(myItem.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력 하세요.");
		}
		
	
		int flag = this.myItemService.do_update(myItem);
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
	@RequestMapping(value="myitem/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_delete(MyItem myItem) {
		LOG.debug("============================");
		LOG.debug("=myItem="+myItem);
		LOG.debug("============================");
		
		int flag = this.myItemService.do_delete(myItem);
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
	@RequestMapping(value="myitem/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String do_save(MyItem myItem) {
		LOG.debug("============================");
		LOG.debug("=myItem="+myItem);
		LOG.debug("============================");
		
		if(null == myItem.getId() || "".equals(myItem.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력하세요.");
		}
		

		
		int flag = this.myItemService.do_save(myItem);
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
	@RequestMapping(value="myitem/do_selectOne.do",method = RequestMethod.GET)
	public String get_selectOne(MyItem myItem,Model model) {
		LOG.debug("============================");
		LOG.debug("=myItem="+myItem);
		LOG.debug("============================");
		
		//String nullck = Integer.toString(myItem.getCartCode());
		
//		if(nullck == null || "".equals(nullck)) {
//			throw new IllegalArgumentException("Cart_Num를 입력 하세요.");
//		}
		
		MyItem outVO= (MyItem) this.myItemService.get_selectOne(myItem);
		model.addAttribute("vo", outVO);
		
		LOG.debug("=outVO="+outVO);
		
		return VIEW_MNG_NM;
	}
	
	//http://localhost:8080/supreme/myitem/get_retrieve.do?searchWord=test01
	/**목록조회 */
	@RequestMapping(value="myitem/get_retrieve.do",method = RequestMethod.GET)
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
		List<MyItem> list = (List<MyItem>) this.myItemService.get_retrieve(search);
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
