package kr.co.supreme.cart.web;

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


import kr.co.supreme.cart.service.Cart;
import kr.co.supreme.cart.service.CartService;
import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.order.service.Order;

@Controller
public class CartController {

	
Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CartService cartService;
	
	
	@Autowired
	private LocaleResolver localeResolver;//SessionLocaleResolver
	
	//view
	private final String VIEW_LIST_NM ="cart/cart_list";
	private final String VIEW_MNG_NM  ="cart/cart_mng";
	
	/**수정 */
	@RequestMapping(value="cart/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody		
	public String do_update(Cart cart) {
		String gsonStr = "";
		LOG.debug("============================");
		LOG.debug("=cart="+cart);
		LOG.debug("============================");		

		
		if(null == cart.getId() || "".equals(cart.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력 하세요.");
		}
		
	
		int flag = this.cartService.do_update(cart);
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
	@RequestMapping(value="cart/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String do_delete(Cart cart) {
		LOG.debug("============================");
		LOG.debug("=cart="+cart);
		LOG.debug("============================");
		
		int flag = this.cartService.do_delete(cart);
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
	@RequestMapping(value="cart/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String do_save(Cart cart) {
		LOG.debug("============================");
		LOG.debug("=cart="+cart);
		LOG.debug("============================");
		
		if(null == cart.getId() || "".equals(cart.getId().trim())) {
			throw new IllegalArgumentException("아이디를 입력하세요.");
		}
		

		
		int flag = this.cartService.do_save(cart);
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
	@RequestMapping(value="cart/do_selectOne.do",method = RequestMethod.GET)
	public String get_selectOne(Cart cart,Model model) {
		LOG.debug("============================");
		LOG.debug("=cart="+cart);
		LOG.debug("============================");
		
		String nullck = Integer.toString(cart.getCartCode());
		
		if(nullck == null || "".equals(nullck)) {
			throw new IllegalArgumentException("Cart_Num를 입력 하세요.");
		}
		
		Cart outVO= (Cart) this.cartService.get_selectOne(cart);
		model.addAttribute("vo", outVO);
		
		LOG.debug("=outVO="+outVO);
		
		return VIEW_MNG_NM;
	}
	
	/**목록조회 */
	@RequestMapping(value="cart/get_retrieve.do",method = RequestMethod.GET)
	public String get_retrieve(HttpServletRequest req,Search search, Model model) {
		
		LOG.debug("요요요요요요ㅛ"+req.getParameter("idd"));
		//param
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}		
		
		search.setSearchWord(req.getParameter("idd"));
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
		model.addAttribute("vo", search);
		
		
		LOG.debug("============================");
		LOG.debug("=search="+search);
		LOG.debug("============================");		
		
		
		//목록조회
		List<Cart> list = (List<Cart>) this.cartService.get_retrieve(search);
		model.addAttribute("list", list);
		
		//총건수
		int totalCnt = 0;
		if(null != list && list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		model.addAttribute("totalCnt", totalCnt);
		return VIEW_LIST_NM;
	}
	
	//상세페이지에서 값받아오기
		@RequestMapping(value="cart/get.do",method = RequestMethod.GET)
		public String get(Cart cart,Model model) {
			
			
			Search search = new Search();
			//param
			if(search.getPageSize()==0) {
				search.setPageSize(10);
			}
			
			if(search.getPageNum()==0) {
				search.setPageNum(1);
			}	
			search.setSearchWord(cart.getId());
			
			search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
			search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
			
			LOG.debug("============================");
			LOG.debug("========"+cart.getpCode());
			LOG.debug("========"+cart.getQuantity());
			LOG.debug("========"+cart.getpName());
			LOG.debug("========"+cart.getUnitPrice());
			LOG.debug("========"+cart.getId());
			LOG.debug("========"+cart.getCartCode());
			LOG.debug("============================");
			LOG.debug("자 여기"+search.getSearchWord());
			if(cart.getpCode()!=0) {
			int flag = this.cartService.do_save(cart);
			}
			List<Cart> list = (List<Cart>) this.cartService.get_retrieve(search);
			model.addAttribute("list", list);
			return VIEW_LIST_NM;
			
		}
	
}
