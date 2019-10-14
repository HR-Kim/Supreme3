<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "kr.co.supreme.code.*" %>
<%@page import = "kr.co.supreme.cmn.StringUtil" %>
<%@page import = "kr.co.supreme.cmn.Search" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value ="${pageContext.request.contextPath }"/>
<%
	/** 페이지 사이즈 */
	String pageSize   = "10"  ; 	
	/** 페이지 번호 */
	String pageNum    = "1"  ;	
	/** 검색조건 */
	String searchDiv  = "" ;
	/** 검색어 */
	String searchWord = "" ;
	/** 확장자 */
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
	
	String url      = request.getContextPath()+"/orderStauts/get_retrieve.do";
	String scriptName ="search_page";

%>
<!DOCTYPE html>
<html lang="en">

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
	<!-- Header -->
	<%@include file ="header.jsp" %>
	<!--/ Header -->
	<div class="container">
	<!-- row -->
	<div class="row">
	<div class="col-md-12">
			<div class="order-summary clearfix">
				<!-- Grid영역 -->
				
				<div class="section-title">
					<h3 class="title">Orderview</h3>
				</div>
				<table class="shopping-cart-table table" id="listTable">
					<thead>
						<tr>
							<th>Product</th>
							<th class="text-left">Status</th>
							<th class="text-center">Price</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total</th>
							<th class="text-center">Select</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list.size()>0}">
								<c:forEach var="vo" items="${list}">
							<% System.out.print(vo); %>
						<tr>
							<td class="thumb"><img value="${vo.p_image}" alt=""></td>
							
							<td class="details">
								<a href="#"><c:out value="${vo.p_name}" /></a>
									<ul>
										<li><span><c:out value="${vo.od_status}"/></span></li>
									</ul>
							</td>
							
							<td class="price text-center"><strong>$<c:out value="${vo.unit_price}"/></strong><br><del class="font-weak"><small>$<c:out value="${vo.p_price}"/></small></del></td>
							<td class="price text-center"><c:out value="${vo.quantitiy}"/></td>
							<td class="total text-center"><strong class="primary-color"><c:out value="${vo.quantitiy * vo.unit_price}"/></strong></td>
							<td class="total text-center">
							<input type="checkbox" name="checkOrder" value="check"/>
							</td>
						</tr>
							</c:forEach>
						</c:when>
					</c:choose>
					</tbody>
				</table>
				<div class="pull-right">
				<!-- //grid영역 -->
				<button class="primary-btn">Cancle Order</button>
			</div>
		</div>
	</div>
	<div class="col-md-12">
			<div class="order-summary clearfix">
				<div class="section-title">
					<h3 class="title">Previous Order</h3>
				</div>
				<table class="shopping-cart-table table">
					<thead>
						<tr>
							<th>Product</th>
							<th class="text-left">Product name</th>
							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
							<th class="text-center">Status</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list.size()>0}">
								<c:forEach var="vo" items="${list}">
							<% System.out.print(vo); %>
						<tr>
							<td class="thumb"><img value="${vo.p_image}" alt=""></td>
							
							<td class="details">
								<a href="#"><c:out value="${vo.p_name}" /></a>
							</td>
							
							<td class="price text-center"><strong>$<c:out value="${vo.unit_price}"/></strong></td>
							<td class="total text-center"><strong class="primary-color"><c:out value="${vo.quantitiy * vo.unit_price}"/></strong></td>
							<td class="total text-center">
							<button class="icon-btn.main-btn" name="refund" id="refund" onclick="window.open('../template/refund_popup.jsp','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">환불</button>
							<button class="icon-btn.main-btn" name="change" id="change" onclick="window.open('../template/change_popup.jsp','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">교환</button>
							</td>
						</tr>
							</c:forEach>
						</c:when>
					</c:choose>
					</tbody>
				</table>
			<!-- /row -->
			</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->
	
	<script>
		function onePopup(){
			var url    ="../template/change_popup.jsp";
			var name   ="refund_popup";
			var option ="width=500, height=500, top=100, left=200, location=no";
		}
		
		
		//grid click
		$("#refund").on("click","tr",function(){
			alert("listTable");
			var trs = $(this);
			var td  = trs.children();
			
			var boardId = td.eq(0).text();
			//console.log("boardId:"+boardId);
			var frm = document.boardFrm;
			frm.boardId.value=boardId;
			frm.action = "${context}/board/do_selectOne.do";
			frm.submit();
			
		});
	</script>
	
	
	
	<!-- FOOTER -->
	<%@include file ="footer.jsp" %>
	<!-- /FOOTER -->
	<!-- jQuery Plugins -->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/slick.min.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.zoom.min.js"></script>
	<script src="../resources/js/main.js"></script>

</body>

</html>
