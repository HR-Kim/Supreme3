package kr.co.supreme.orderstatus.service.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.code.service.Code;
import kr.co.supreme.code.service.CodeService;
import kr.co.supreme.orderstatus.service.OrderSearch;
import kr.co.supreme.orderstatus.service.OrderStatus;
import kr.co.supreme.orderstatus.service.OrderStatusService;

@Controller
public class OrderStatusController {

	private final String VIEW_MNG_NM = "orderStatus/orderview";
	private final String VIEW_MNG_NME = "template/refund_popup";
	private final String VIEW_ADM_ORDER="orderStatus/orderview_admin";
	
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderStatusService Service;
	
	@Autowired
	CodeService codeService;
	
	/**관리자조회 */
	@RequestMapping(value="orderStatus/get_admin_retrieve.do",method = RequestMethod.GET)
	public String get_retrieve(HttpServletRequest req, OrderSearch search, Model model) {
		//param
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
		
		
		LOG.debug("=========================");
		LOG.debug("====SEARCH====="+search);
		LOG.debug("=========================");
		model.addAttribute("vo",search);
		
		//Code:PAGE_SIZE
		Code code=new Code();
		code.setCodeId("PAGE_SIZE");
		//Code정보조회
		List<Code> codeList = (List<Code>) codeService.get_retrieve(code);
		model.addAttribute("codeList", codeList);
		
		code.setCodeId("ORDER_STATUS");
		//Code정보조회
		List<Code> codeSearchList = (List<Code>) codeService.get_retrieve(code);
		model.addAttribute("codeSearchList", codeSearchList);
		
		code.setCodeId("ORDER_STATUS");
		
		
		//목록조회 
		List<OrderStatus> list = (List<OrderStatus>) this.Service.get_retrieve(search);
		model.addAttribute("list",list);
		
		
		//총건수
		int totalCnt = 0;
		if(null !=list && list.size()>0) {
		totalCnt = list.get(0).getTotalCnt();
		}
		model.addAttribute("totalCnt", totalCnt);
		
		
		return VIEW_ADM_ORDER;
	}

	/**전체조회*/
	@RequestMapping(value="orderStatus/get_retrieve.do",method = RequestMethod.GET)
	public String get_retrieve2(HttpServletRequest req, OrderSearch search, Model model) {
		LOG.debug("1=========================");
		LOG.debug("1=param="+search);
		LOG.debug("1=========================");
		//param
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
		LOG.debug("=========================");
		LOG.debug("====SEARCH====="+search);
		LOG.debug("=========================");
		model.addAttribute("vo",search);
		
		
		
		//목록조회 
		List<OrderStatus> list = (List<OrderStatus>) this.Service.get_retrieve(search);
		model.addAttribute("list",list);
		//현재 주문 목록조회 
		List<OrderStatus> currentlist = (List<OrderStatus>) this.Service.get_current_retrieve(search);
		model.addAttribute("currentlist",currentlist);
		//목록조회 
		List<OrderStatus> prelist = (List<OrderStatus>) this.Service.get_previous_retrieve(search);
		model.addAttribute("prelist",prelist);
				
		
		return VIEW_MNG_NM;
	}
	
	/**단건조회*/
	@RequestMapping(value="orderStatus/do_selectOne.do",method = RequestMethod.GET)
	public String get_selectOne(OrderStatus inVO,Model model) {
		LOG.debug("===================");
		LOG.debug("===inVO==="+inVO);
		LOG.debug("===================");
		
		if(null == inVO.getDetail_code()|| "".equals( inVO.getDetail_code())) {
			throw new IllegalArgumentException("code를 입력 하세요.");
		}
	
		OrderStatus outVO = (OrderStatus) Service.get_selectOne(inVO);
		model.addAttribute("vo",outVO);
	

		return VIEW_MNG_NME;
		
	}
	/**수정*/
	@RequestMapping(value="orderStauts/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_update(OrderStatus inVO) {
		String gsonStr ="";
		LOG.debug("=======================");
		LOG.debug("===inVO="+inVO);
		LOG.debug("=======================");
		
		int flag = Service.do_update(inVO);
		Message message = new Message();
		
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
	
	
	
	/**저장 */
	
	@RequestMapping(value="orderStatus/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_save(OrderStatus inVO) {
		LOG.debug("============================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("============================");
		
		int flag = this.Service.do_save(inVO);
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
			
		
	/**삭제 */
	@RequestMapping(value="orderStatus/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_delete(OrderStatus inVO) {
		LOG.debug("============================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("============================");
		//FILE_ID가 있는 경우 파일테이블 삭제 추가 
		//flag > 1 삭제 성공.
		//flag ==1 && FILE_ID==0 삭제 성공				
		int flag = this.Service.do_delete(inVO);
		Message  message=new Message();
		
		if( flag>0 || (flag ==1 && inVO.getDetail_code()=="0")) {
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
	
}
