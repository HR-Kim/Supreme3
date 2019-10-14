package kr.co.supreme.product.service.web;

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
import kr.co.supreme.product.service.Product;
import kr.co.supreme.product.service.ProductService;

@Controller
public class ProductController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService;
	
	private final String VIEW_LIST_NM ="product/product_list";
	private final String VIEW_MNG_NM  ="product/product_mng";
	
	
	   
	   /**수정 */
	   @RequestMapping(value="product/do_update.do",method = RequestMethod.POST
	         ,produces = "application/json;charset=UTF-8")
	   @ResponseBody      
	   public String do_update(Product product) {
	      String gsonStr = "";
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");      
	      if(null == product.gethCode() || "".equals(product.gethCode().trim())) {
		         throw new IllegalArgumentException("대분류 번호를 입력하세요.");
		  }
		      
		  if(null == product.getlCode() || "".equals(product.getlCode().trim())) {
		         throw new IllegalArgumentException("소분류 번호를 입력하세요.");
		  }
		  if(null == product.getpName() || "".equals(product.getpName().trim())) {
			     throw new IllegalArgumentException("상품명을 입력하세요.");
		  }      
	      
	      int flag = this.productService.do_update(product);
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
	   @RequestMapping(value="product/do_delete.do",method = RequestMethod.POST
	         ,produces = "application/json;charset=UTF-8")
	   @ResponseBody
	   public String do_delete(Product product) {
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");
	      
	      int flag = this.productService.do_delete(product);
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
	   @RequestMapping(value="product/do_save.do",method = RequestMethod.POST
	         ,produces = "application/json;charset=UTF-8")
	   @ResponseBody   
	   public String do_save(Product product) {
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");
	      
	      if(null == product.gethCode() || "".equals(product.gethCode().trim())) {
	         throw new IllegalArgumentException("대분류 번호를 입력하세요.");
	      }
	      
	      if(null == product.getlCode() || "".equals(product.getlCode().trim())) {
	         throw new IllegalArgumentException("소분류 번호를 입력하세요.");
	      }
	      if(null == product.getpName() || "".equals(product.getpName().trim())) {
		         throw new IllegalArgumentException("상품명을 입력하세요.");
		  } 

	      
	      int flag = this.productService.do_save(product);
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
	   @RequestMapping(value="product/do_selectOne.do",method = RequestMethod.GET)
	   public String get_selectOne(Product product,Model model) {
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");
	      
	      if(null == product.getpName() || "".equals(product.getpName())) {
	         throw new IllegalArgumentException("상품명을 입력하세요.");
	      }
	      
	      Product outVO= (Product) this.productService.get_selectOne(product);
	      model.addAttribute("vo", outVO);
	      
	      return VIEW_MNG_NM;
	   }
	   
	   
	   /**목록조회 */
	   @RequestMapping(value="product/get_retrieve.do",method = RequestMethod.GET)
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
	      List<Product> list = (List<Product>) this.productService.get_retrieve(search);
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

