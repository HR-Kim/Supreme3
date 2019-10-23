<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="context" value="${pageContext.request.contextPath }" />
<%
	/** 페이지 사이즈 */
	String pageSize   = "10"  ; 	
	/** 페이지 번호 */
	String pageNum    = "1"  ;	
	/** 검색조건 */
	String searchDiv  = "" ;
	/** 검색어 */
	String searchWord = "test01" ;
	
	String ext = "xls" ;

	
	Search vo = (Search)request.getAttribute("vo");
	if(null !=vo){
		pageSize   = StringUtil.nvl(vo.getPageSize()+"","10");
		pageNum    = StringUtil.nvl(vo.getPageNum()+"","1");
		searchDiv  = StringUtil.nvl(vo.getSearchDiv(),"");
		searchWord = StringUtil.nvl(vo.getSearchWord(),"");	
	}else{
		pageSize   = "10";
		pageNum    = "1";
		searchDiv  = "";
		searchWord = "";
	}
	
	String extParam = (String)request.getAttribute("ext");
	if(extParam !=null) ext = extParam;
	
	//페이지사이즈
	List<Code> listPageSize=(request.getAttribute("listPageSize")==null)?
			(List<Code>)new ArrayList<Code>():(List<Code>)(request.getAttribute("listPageSize"));
	//게시판 검색 구분
	List<Code> listBoardSearch=(request.getAttribute("listBoardSearch")==null)?
			(List<Code>)new ArrayList<Code>():(List<Code>)(request.getAttribute("listBoardSearch"));
	
	//paging 
	//maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName	
	int maxNum      = 0;//totalCnt
	int bottomCount = 10;
	int currPageNo  = 1;//pageNum
	int rowPerPage  = 10;//pageSize	
	
	String url      = request.getContextPath()+"/product/get_retrieve.do";
	String scriptName ="search_page";

%>
<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8">
<title>Product Page</title>
<head>

</head>

<body>
   <!-- Header -->
   <%@include file ="/template/header.jsp" %>
   <!--/ Header -->
	
   <!-- HOME -->
   <div id="home">
  
      <!-- container -->
      <div class="container">
         <!-- home wrap -->
         <div class="home-wrap">
            <!-- home slick -->
            
            <!-- /home slick -->
         </div>
         <!-- /home wrap -->
      </div>
      <!-- /container -->
   </div>
   <!-- /HOME -->

   <!-- section -->
   <div class="section">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
            <!-- banner -->
            
            <!-- /banner -->

            <!-- banner -->
           
            <!-- /banner -->

            <!-- banner -->
            
            <!-- /banner -->

         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->

   <!-- section -->
   <div class="section">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
            <!-- section-title -->
            <div class="col-md-12">
               <div class="section-title">
                  <h2 class="title"></h2>
                  <div class="pull-right">
                     <div class="product-slick-dots-1 custom-dots"></div>
                  </div>
               </div>
            </div>
            <!-- /section-title -->
			 <div class="col-md-12">
               <div class="section-title">
                  <h2 class="title">YOON</h2>
                  <div class="pull-right">
                     <div class="product-slick-dots-2 custom-dots">
                     </div>
                  </div>
               </div>
            </div>
            <!-- banner -->
           
            <!-- /banner -->

            <!-- Product Slick -->
            <div class="col-md-9 col-sm-6 col-xs-6">
               <div class="row">
                  <div id="product-slick-1" class="product-slick">
                     <!-- Product Single -->	

                    	<c:choose>
                    		<c:when test="${list.size()>0}">
                    		
                    			<c:forEach var="vo" items="${list}">
			                    
				                     <div class="product product-single">
				                        <div class="product-thumb detail" title="<c:out value='${vo.p_code}'/>">
				                           <img src="../resources/img/test567.jpg" alt="">
				                        </div>                       	
				                    
				                        <div class="product-body">
				                           <h3 ><c:out value="${vo.p_name}"/></h3>                           
				                           <h2 class="product-name"><a href="#"><c:out value="${vo.p_price}"/></a></h2>                   
				                        </div>
				                     </div>
                     		   </c:forEach>
                    	   </c:when>
                       </c:choose>
                       <!-- /Product Single -->
                   	 </div>  
                    
                    

                     <!-- Product Single -->
                   			
                     <!-- /Product Single -->

                     <!-- Product Single -->
                 
                     <!-- /Product Single -->

                     <!-- Product Single -->
                    
                     <!-- /Product Single -->
               
               </div>
            </div>
            <!-- /Product Slick -->
         </div>
         <!-- /row -->

         <!-- row -->
        
            <!-- section title -->
            
            <!-- section title -->

            <!-- Product Single -->
       
            <!-- /Product Single -->

            <!-- Product Slick -->
           
            <!-- /Product Slick -->
        
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->

   <!-- section -->
   <div class="section section-grey">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
           
         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->

   <!-- section -->
   <div class="section">
      <!-- container -->
      
         <!-- /row -->
		
         <!-- row -->
       
            <!-- /Product Single -->
         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->


<form class="form-horizontal" name="productFrm" id="productFrm" method="post">
   	<input type="text" name="p_code" />
</form>
	
	
	
		
   <!-- jQuery Plugins -->
<%--    <script src="${context}/resources/js/jquery.min.js"></script>
   <script src="${context}/resources/js/bootstrap.min.js"></script>
   <script src="${context}/resources/js/slick.min.js"></script>
   <script src="${context}/resources/js/nouislider.min.js"></script>
   <script src="${context}/resources/js/jquery.zoom.min.js"></script>
   <script src="${context}/resources/js/main.js"></script>  --%>
	
   <script>

   
   
  $('.detail').on('click',function() {
	  
	  	var p_codeVal = $(this).attr("title"); 
	  	
		var frm = document.productFrm;
   		frm.p_code.value=p_codeVal;
   		frm.action = "${context}/product/get_selectOne.do";
   		frm.submit();
   		
  });	//-- function

		
   
  $(document).ready(function() {
				//alert("ready");
	 	
    });

  </script>

   <!-- FOOTER -->
   <%@include file ="/template/footer.jsp" %>
   <!-- /FOOTER -->
   	
</body>

</html>