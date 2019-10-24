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
            <div id="main" class="col-md-9">
               <!-- store top filter -->
              
               <!-- /store top filter -->

               <!-- STORE -->
               <div id="store">
               
                  <!-- row -->
                  <div class="row">
				  
				  <c:choose>
               		<c:when test="${list.size()>0}">
               		
               			<c:forEach var="vo" items="${list}">
                     <!-- Product Single -->
                     
                     <div class="col-md-4 col-sm-6 col-xs-6">
                        <div class="product product-single">
                           <div class="product-thumb">
                              <div class="product-label">
                                
                                 <span class="sale"><c:out value="${vo.sale_percent}"/> % 할인 </span>
                              </div>
                              <button class="main-btn quick-view detail" title="<c:out value='${vo.p_code}'/>"><i class="fa fa-search-plus"></i>자세히 보기</button>
                              <img src="${vo.p_image}" alt="">
                           </div>
                           <div class="product-body">
                              <h3 class="product-price"><c:out value="${vo.p_price}"/> 원</h3>
                              
                              <h2 class="product-name"><a href="#"><c:out value="${vo.p_name}"/></a></h2>
                             
                           </div>
                           
                        </div>
                        
                        
                     </div>
                       		</c:forEach>
                  			</c:when>
                 		 </c:choose>  
                     
                   


                    
                  </div>
                  <!-- /row -->
                  	
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


	

	<form class="form-horizontal" name="productFrm" id="productFrm" method="post">
	   	<input type="hidden" name="p_code" />
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
   
   </script>
   
    
   
   
</body>

</html>