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
							<th></th>
							<th class="text-center">Price</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total</th>
							<th class="text-right">Status</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list.size()>0}">
								<c:forEach var="vo" items="${list}">
							<% System.out.print(vo); %>
						<tr>
							<td class="thumb"><img src="../resources/img/thumb-product01.jpg" alt=""></td>
							
							<td class="details">
								<a href="#"><c:out value="${vo.pname}" /></a>
									<ul>
										<li><span><c:out value="${vo.od_status}"/></span></li>
									</ul>
							</td>
							
							<td class="price text-center"><strong><c:out value= "${vo.pprice}"/></strong><br><del class="font-weak"><small>"${vo.unitprice}"</small></del></td>
							<td class="qty text-center"><input class="input" type="number"/> <c:out value="${vo.quantity}"/></td>
							<td class="total text-center"><strong class="primary-color">$32.50</strong></td>
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
							<th></th>
							<th class="text-center">Price</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total</th>
							<th class="text-right">Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="thumb"><img src="../resources/img/thumb-product01.jpg" alt=""></td>
							
							<td class="details">
								<a href="#">Product Name Goes Here</a>
								<ul>
									<li><span>Size: XL</span></li>
									<li><span>Color: Camelot</span></li>
								</ul>
							</td>
							
							<td class="price text-center"><strong>$32.50</strong><br><del class="font-weak"><small>$40.00</small></del></td>
							<td class="qty text-center"><input class="input" type="number" value="1"></td>
							<td class="total text-center"><strong class="primary-color">$32.50</strong></td>
							
						</tr>
						<tr>
							<td class="thumb"><img src="./img/thumb-product01.jpg" alt=""></td>
							<td class="details">
								<a href="#">Product Name Goes Here</a>
								<ul>
									<li><span>Size: XL</span></li>
									<li><span>Color: Camelot</span></li>
								</ul>
							</td>
							<td class="price text-center"><strong>$32.50</strong></td>
							<td class="qty text-center"><input class="input" type="number" value="1"></td>
							<td class="total text-center"><strong class="primary-color">$32.50</strong></td>
							<td class="text-right"><button class="main-btn icon-btn"><i class="fa fa-close"></i></button></td>
						</tr>
						<tr>
							<td class="thumb"><img src="./img/thumb-product01.jpg" alt=""></td>
							<td class="details">
								<a href="#">Product Name Goes Here</a>
								<ul>
									<li><span>Size: XL</span></li>
									<li><span>Color: Camelot</span></li>
								</ul>
							</td>
							<td class="price text-center"><strong>$32.50</strong></td>
							<td class="qty text-center"><input class="input" type="number" value="1"></td>
							<td class="total text-center"><strong class="primary-color">$32.50</strong></td>
							<td class="text-right"><button class="main-btn icon-btn"><i class="fa fa-close"></i></button></td>
						</tr>
					</tbody>
				</table>
				<div class="pull-right">
				<button class="primary-btn">Refund</button>
			</div>
			<!-- /row -->
			</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->
	<!-- FOOTER -->
	<%@include file ="footer.jsp" %>
	<!-- /FOOTER -->
	<!-- jQuery Plugins -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/main.js"></script>

</body>

</html>
