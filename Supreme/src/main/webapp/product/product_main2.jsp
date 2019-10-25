<%@page import="kr.co.supreme.product.service.ProductSearch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
		/** 페이지 사이즈 */
		String pageSize   = "9"  ; 	
		/** 페이지 번호 */
		String pageNum    = "1"  ;	
		/** 검색조건 */
		String searchDiv  = "" ;
		/** 검색어 */
		String searchWord = "" ;
			
		String hCodeCat = "";
		
		String lCodeCat = ""; 
		
		String pStatus = "";
		
		ProductSearch vo = (ProductSearch)request.getAttribute("vo");
		
		List<?> proList = (List<?>) request.getAttribute("list");

		
		if(null !=vo){
			pageSize = StringUtil.nvl(vo.getPageSize()+"","9");
			pageNum = StringUtil.nvl(vo.getPageNum()+"","1");
			searchDiv = StringUtil.nvl(vo.getSearchDiv(),"");
			searchWord = StringUtil.nvl(vo.getSearchWord(),"");
			hCodeCat = StringUtil.nvl(vo.gethCodeCat(),"");
			lCodeCat = StringUtil.nvl(vo.getlCodeCat(),"");
			pStatus = StringUtil.nvl(vo.getpStatus(),"");
			
		}else{
			pageSize = "9";
			pageNum  = "1";
			searchDiv = "";
			searchWord = "";
			hCodeCat="";
			lCodeCat="";
			pStatus="";
		}
		
		
		
		//pageCode	
		List<Code> codeList = (request.getAttribute("codeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeList");
				
		//userSearch	
		List<Code> codeSearchList = 
		(request.getAttribute("codeSearchList")==null)?
				(List<Code>)new ArrayList<Code>():
					(List<Code>)request.getAttribute("codeSearchList");		
		
		//hCode
		List<Code> codeHCodeList = (request.getAttribute("codeHCodeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeHCodeList");
		
		//lCode
		List<Code> codeLCodeList = (request.getAttribute("codeLCodeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeLCodeList");
		
		//statusCode
		List<Code> codeStatusList = (request.getAttribute("codeStatusList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeStatusList");
			
		
		int maxNum      = 0;
		int bottomCount = 10;
		int currPageNo  = 1; //pageNum
		int rowPerPage  = 10;//pageSize
		String url      = request.getContextPath()+"/product/get_cat_retrieve.do";
		String scriptName = "search_page";
		
		String iTotalCnt =(request.getAttribute("totalCnt")==null)?"0":request.getAttribute("totalCnt").toString();
		
		maxNum = Integer.parseInt(iTotalCnt);
		currPageNo = Integer.parseInt(pageNum);
		rowPerPage = Integer.parseInt(pageSize);
%>

<c:set var="context" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->


	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="../resources/css/bootstrap.min.css" />

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="../resources/css/slick.css" />
	<link type="text/css" rel="stylesheet" href="../resources/css/slick-theme.css" />

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet" href="../resources/css/nouislider.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="../resources/css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="../resources/css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>


<body>
   <!-- HEADER -->
   <%@include file ="/template/header.jsp" %>
   <!--/ Header -->

   <!-- BREADCRUMB -->
   <div id="breadcrumb">
      <div class="container">
         <ul class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li class="active">Products</li>
         </ul>
      </div>
   </div>
   <!-- /BREADCRUMB -->
	
   <!-- section -->
   <div class="section">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
         
      
            <!-- ASIDE -->
        
            
            <!-- /ASIDE -->

            <!-- MAIN -->
            <!-- 검색영역 -->
			<div class="row">
				<div class="col-md-11 text-right">
					<form class="form-inline" name="frm" id="frm" method="get">
					<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }">
						
						<div class="form-group">
						    <%=StringUtil.makeSelectBox(codeList, "pageSize", pageSize, false) %>
						    <%=StringUtil.makeSelectBox(codeHCodeList, "hCodeCat", hCodeCat, true) %>
						    <%=StringUtil.makeSelectBox(codeLCodeList, "lCodeCat", lCodeCat, true) %>
						    <%=StringUtil.makeSelectBox(codeStatusList, "pStatus", pStatus, true) %>
						    <%=StringUtil.makeSelectBox(codeSearchList, "searchDiv", searchDiv, true) %>
							<input type="text" class="form-control input-sm" id="searchWord" value="${vo.searchWord}" name="searchWord" placeholder="검색어" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-default btn-sm"
								id="doRetrieve" >조회</button>
							
						</div>	
					</form>
				</div>
			</div>
			<!-- //검색영역 -->
            
            <div id="main" class="col-md-10 col-md-offset-1">
            
            
            
               <!-- store top filter -->
              
               <!-- /store top filter -->

               <!-- STORE -->
               <div id="store">
               
                  <!-- row -->
                  <div class="row">
				  
				  <c:choose>
               		<c:when test="${list.size()>0}">
               		
               			<c:forEach var="product" items="${list}">
                     <!-- Product Single -->
                     
                     <div class="col-md-4 col-sm-6 col-xs-6">
                        <div class="product product-single">
                           <div class="product-thumb">
                              <div class="product-label">
                               	<c:choose>
                               	<c:when test="${product.sale_percent=='100'}"></c:when>  
                               	<c:otherwise>                           	
                                 <span class="sale"><c:out value="${product.sale_percent}"/>%에 구매</span>
                                 </c:otherwise>
                                </c:choose> 
                              </div>
                              <button class="main-btn quick-view detail" title="<c:out value='${product.p_code}'/>"><i class="fa fa-search-plus"></i>자세히 보기</button>
                              <img src="${context}/resources" alt="">
                           </div>
                           <div class="product-body">
                              <h3 class="product-price"><c:out value="${product.p_price}"/> 원</h3>
                              
                              <h2 class="product-name"><a href="#"><c:out value="${product.p_name}"/></a></h2>
                             
                           </div>
                           
                        </div>
                        
                        
                     </div>
                       		</c:forEach>
                  			</c:when>
                 		 </c:choose>  
                     
                   


                    
                  </div>
                  <!-- /row -->
                <!-- pagenation -->
				<div class="text-center">
					<%=StringUtil.renderPaing(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %>
				</div>
				<!--// pagenation -->
                  	
               </div>
               <!-- /STORE -->

               <!-- store bottom filter -->
           
               <!-- /store bottom filter -->
            </div>
            <!-- /MAIN -->
         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->


	

	<form class="form-horizontal" name="productFrm" id="productFrm" method="get">
		<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }">
						<input type="hidden" name="p_code" id="p_code" />
	</form>

 
  
   <!-- jQuery Plugins -->
   <script src="${context}/resources/js/jquery.min.js"></script>
   <script src="${context}/resources/js/bootstrap.min.js"></script>
   <script src="${context}/resources/js/slick.min.js"></script>
   <script src="${context}/resources/js/nouislider.min.js"></script>
   <script src="${context}/resources/js/jquery.zoom.min.js"></script>
   <script src="${context}/resources/js/main.js"></script>

   <!-- FOOTER -->
   <%@include file ="/template/footer.jsp" %>
   <!-- /FOOTER -->

   <script>

	   $('.detail').on('click',function() {
			  
		   var p_code = $(this).attr("title");
		   
		   var frm = document.productFrm;
		   frm.p_code.value=p_code;
		   frm.action = "${context}/product/get_selectOne.do";
	   	   frm.submit();
		   
		  
	 	 });	//-- function
	 	
	 	 
	 	//Enter 쳤을 때 조회되도록
			$("#searchWord").keydown(function(key) {
				if (key.keyCode == 13) {
					doRetrieve();
				}
				
			});
	 	 
	 	 
	 	//paging이동
		function search_page(url,pageNum){
			//alert(url+"|"+pageNum);
			var frm = document.productFrm;
			frm.pageNum.value = pageNum;
			frm.action = url;
			frm.submit();
		}
   
	 	
		//조회
		$("#doRetrieve").on("click",function(){
			console.log("doRetrieve");
			doRetrieve();
		});  
	 	 
		function doRetrieve(){
			var frm = document.productFrm;
			frm.pageNum.value= 1;
			frm.action = "${context}/product/get_cat_retrieve.do";
			frm.submit();
		} 
	 	 
   </script>
   
    
   
   
</body>

</html>