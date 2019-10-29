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
import org.springframework.web.servlet.LocaleResolver;

import com.google.gson.Gson;

import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.Search;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.code.service.Code;
import kr.co.supreme.code.service.CodeService;
import kr.co.supreme.product.service.Product;
import kr.co.supreme.product.service.ProductSearch;
import kr.co.supreme.product.service.ProductService;

@Controller
public class ProductController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LocaleResolver localeResolver;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CodeService codeService;
	
	private final String VIEW_LIST_NM  ="product/product_main";
	private final String VIEW_LIST_M_NM  ="product/product_main2";
	private final String VIEW_ADMIN_MNG_NM  ="product/product_mng";
	private final String VIEW_ADMIN_UPT_NM  ="product/product_update";
	private final String VIEW_MNG_NM  ="product/product_detail";
	
	
	   
	   /**수정 */
	   @RequestMapping(value="product/do_update.do",method = RequestMethod.POST
	         ,produces = "application/json;charset=UTF-8")
	   @ResponseBody      
	   public String do_update(Product product) {
	      String gsonStr = "";
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");      
    
	      
	      int flag = this.productService.do_update(product);
	      Message  message=new Message();
	      
	      if(flag>0) {
	         message.setMsgId(String.valueOf(flag));
	         message.setMsgMsg("제품 수정이 완료되었습니다.");
	      }else {
	         message.setMsgId(String.valueOf(flag));
	         message.setMsgMsg("제품 수정에 실패했습니다.");         
	      }
	      
	      Gson gson=new Gson();
	      gsonStr = gson.toJson(message);      
	      
	      
	      return gsonStr;
	      
	   }
	   
	   /**수량 수정 */
	   @RequestMapping(value="product/do_stock_update.do",method = RequestMethod.POST
	         ,produces = "application/json;charset=UTF-8")
	   @ResponseBody      
	   public String do_stock_update(Product product) {
	      String gsonStr = "";
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");      
    
	      
	      int flag = this.productService.do_stock_update(product);
	      Message  message=new Message();
	      
	      if(flag>0) {
	         message.setMsgId(String.valueOf(flag));
	         message.setMsgMsg("윤구제품 수정이 완료되었습니다.");
	      }else {
	         message.setMsgId(String.valueOf(flag));
	         message.setMsgMsg("윤구제품 수정에 실패했습니다.");         
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
	         message.setMsgMsg("제품을 삭제하였습니다.");
	      }else {
	         message.setMsgId(String.valueOf(flag));
	         message.setMsgMsg("제품을 삭제하지 못했습니다.");         
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
	      
//	      if(null == product.getH_code() || "".equals(product.getH_code().trim())) {
//	         throw new IllegalArgumentException("대분류 번호를 입력하세요.");
//	      }
//	      
//	      if(null == product.getL_code() || "".equals(product.getL_code().trim())) {
//	         throw new IllegalArgumentException("소분류 번호를 입력하세요.");
//	      }
//	      if(null == product.getP_name() || "".equals(product.getP_name().trim())) {
//		         throw new IllegalArgumentException("상품명을 입력하세요.");
//		  } 

	      
	      int flag = this.productService.do_save(product);
	      Message  message=new Message();
	      
	      if(flag>0) {
	         message.setMsgId(String.valueOf(flag));
	         message.setMsgMsg("제품을 등록하였습니다.");
	      }else {
	         message.setMsgId(String.valueOf(flag));
	         message.setMsgMsg("제품을 등록하지 못했습니다.");         
	      }
	      
	      Gson gson=new Gson();
	      String gsonStr = gson.toJson(message);
	      
	      LOG.debug("============================");
	      LOG.debug("=gsonStr="+gsonStr);
	      LOG.debug("============================");            
	      
	      return gsonStr;
	   }

	   /**단건조회 */
	   @RequestMapping(value="product/get_selectOne.do",method = RequestMethod.POST)
	   public String get_selectOne(Product product,Model model) {
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");
		
	      
	    
	      Product outVO= (Product) this.productService.get_selectOne(product);
	      LOG.debug("============================");
	      LOG.debug("=outVO="+outVO);
	      LOG.debug("============================");
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
	   
	   
	   
	   /**단건조회 */
	   @RequestMapping(value="product/get_admin_selectOne.do",method = RequestMethod.GET)
	   public String get_admin_selectOne(Product product,Model model) {
	      LOG.debug("============================");
	      LOG.debug("=product="+product);
	      LOG.debug("============================");
		
	      
	    
	      Product outVO= (Product) this.productService.get_selectOne(product);
	      LOG.debug("============================");
	      LOG.debug("=outVO="+outVO);
	      LOG.debug("============================");
	      model.addAttribute("vo", outVO);
	      
	      return VIEW_ADMIN_UPT_NM;
	   }
	   
	   
	   /**목록조회 */
	   @RequestMapping(value="product/get_admin_retrieve.do",method = RequestMethod.GET)
	   public String get_admin_retrieve(HttpServletRequest req,ProductSearch search, Model model) {
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
	      model.addAttribute("vo", search);
	      
	      LOG.debug("2=========================");
	      LOG.debug("2=param="+search);
	      LOG.debug("2=========================");   
	      	
	      //Code:PAGE_SIZE
			Code code=new Code();
			code.setCodeId("PAGE_SIZE");
			//Code정보조회
			List<Code> codeList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeList", codeList);
			
			code.setCodeId("PRODUCT_SEARCH");
			//Code정보조회
			List<Code> codeSearchList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeSearchList", codeSearchList);
			
			code.setCodeId("HIGH_CODE");
			//Code정보조회
			List<Code> codeHCodeList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeHCodeList", codeHCodeList);
			
			code.setCodeId("LOW_CODE");
			//Code정보조회
			List<Code> codeLCodeList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeLCodeList", codeLCodeList);
			
			code.setCodeId("PRODUCT_STATUS");
			//Code정보조회
			List<Code> codeStatusList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeStatusList", codeStatusList);
			LOG.debug("2.5=========================");
		    LOG.debug("2.5=코드 조회 완료");
		    LOG.debug("2.5=search="+search);
		    LOG.debug("2.5=========================");   
	      
	      
	      //목록조회
		      
	      List<Product> list = (List<Product>) this.productService.get_admin_retrieve(search);
	      model.addAttribute("list", list);
	      
	      //총건수
	      int totalCnt = 0;
	      if(null != list && list.size()>0) {
	         totalCnt = list.get(0).getTotalCnt();
	      }
	      model.addAttribute("totalCnt", totalCnt);
	      return VIEW_ADMIN_MNG_NM;
	   }
	   
	   
	   /**목록조회 */
	   @RequestMapping(value="product/get_cat_retrieve.do",method = RequestMethod.GET)
	   public String get_cat_retrieve(HttpServletRequest req,ProductSearch search, Model model) {
		   LOG.debug("1=========================");
		   LOG.debug("1=param="+search);
		   LOG.debug("1=========================");
		   
		   //param
	      if(search.getPageSize()==0) {
	         search.setPageSize(9);
	      }
	      
	      if(search.getPageNum()==0) {
	         search.setPageNum(1);
	      }      
	      
	      search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
	      search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
	      model.addAttribute("vo", search);
	      
	      LOG.debug("2=========================");
	      LOG.debug("2=param="+search);
	      LOG.debug("2=========================");   
	      	
	      //Code:PAGE_SIZE
			Code code=new Code();
			code.setCodeId("PAGE_SIZE");
			//Code정보조회
			List<Code> codeList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeList", codeList);
			
			code.setCodeId("PRODUCT_SEARCH");
			//Code정보조회
			List<Code> codeSearchList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeSearchList", codeSearchList);
			
			code.setCodeId("HIGH_CODE");
			//Code정보조회
			List<Code> codeHCodeList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeHCodeList", codeHCodeList);
			
			code.setCodeId("LOW_CODE");
			//Code정보조회
			List<Code> codeLCodeList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeLCodeList", codeLCodeList);
			
			code.setCodeId("PRODUCT_STATUS");
			//Code정보조회
			List<Code> codeStatusList = (List<Code>) codeService.get_retrieve(code);
			model.addAttribute("codeStatusList", codeStatusList);
			LOG.debug("2.5=========================");
		    LOG.debug("2.5=코드 조회 완료");
		    LOG.debug("2.5=search="+search);
		    LOG.debug("2.5=========================");   
	      
	      
	      //목록조회
		      
	      List<Product> list = (List<Product>) this.productService.get_admin_retrieve(search);
	      model.addAttribute("list", list);
	      
	      //총건수
	      int totalCnt = 0;
	      if(null != list && list.size()>0) {
	         totalCnt = list.get(0).getTotalCnt();
	      }
	      model.addAttribute("totalCnt", totalCnt);
	      return VIEW_LIST_M_NM;
	   }
	   
	   
	   
	}

