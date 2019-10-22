package kr.co.supreme.order.service.web;

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
import org.springframework.web.servlet.LocaleResolver;

import com.google.gson.Gson;

import kr.co.supreme.board.service.Board;
import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.order.service.Order;
import kr.co.supreme.order.service.OrderService;
import kr.co.supreme.cart.service.Cart;

@Controller
public class OrderController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LocaleResolver localeResolver;//SessionLocaleResolver
	
	@Autowired
	OrderService orderService;
	
	
	//view
	private final String VIEW_LIST_NM ="order/order_list";
	private final String VIEW_MNG_NM  ="order/order_mng";
	private final String VIEW  ="order/order_success";
	
	/**수정 */
	@RequestMapping(value="order/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody		
	public String do_update(Order order) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=order="+order);
		LOG.debug("============================");		
		
		//수정해야될 내용 get으로 해서 입력
//		if(null == order.getId() || "".equals(order.getId().trim())) {
//			throw new IllegalArgumentException("ID를 입력 하세요.");
//		}
//		
//		if(null == order.getbTitle() || "".equals(order.getbTitle().trim())) {
//			throw new IllegalArgumentException("제목을 입력 하세요.");
//		}
//		
//		if(null == order.getbContents() || "".equals(order.getbContents().trim())) {
//			throw new IllegalArgumentException("내용을 입력 하세요.");
//		}		
		
		int flag = this.orderService.do_update(order);
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
	@RequestMapping(value="order/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_delete(Order order) {
		LOG.debug("============================");
		LOG.debug("=order="+order);
		LOG.debug("============================");
		
		int flag = this.orderService.do_delete(order);
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
	@RequestMapping(value="order/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String do_save(Order order) {
		LOG.debug("============================");
		LOG.debug("=order="+order);
		LOG.debug("============================");
		
		
		
		
		//저장 되어야 할 내용
//		if(null == order.getbTitle() || "".equals(order.getbTitle().trim())) {
//			throw new IllegalArgumentException("제목을 입력 하세요.");
//		}
//		
//		if(null == order.getbContents() || "".equals(order.getbContents().trim())) {
//			throw new IllegalArgumentException("내용을 입력 하세요.");
//		}
	
		int flag = this.orderService.do_save(order);
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
	@RequestMapping(value="order/do_selectOne.do",method = RequestMethod.GET)
	public String get_selectOne(Order order,Model model) {
		LOG.debug("============================");
		LOG.debug("=order="+order);
		LOG.debug("============================");
		
		if(null == order.getId() || "".equals(order.getId())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		
		Board outVO= (Board) this.orderService.get_selectOne(order);
		model.addAttribute("vo", outVO);
		
		return VIEW_MNG_NM;
	}
	
	/**목록조회 */
	@RequestMapping(value="order/get_retrieve.do",method = RequestMethod.GET)
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
		List<Order> list = (List<Order>) this.orderService.get_retrieve(search);
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
