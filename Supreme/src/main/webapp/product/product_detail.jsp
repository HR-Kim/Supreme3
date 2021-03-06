<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="kr.co.supreme.product.service.Product"%>
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
Product pro = (Product) request.getAttribute("vo");
%>
<c:set var="context" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8">
<title>Product detail</title>
<head>
	

</head>

<body>
	<!-- Header -->
	<%@include file ="/template/header.jsp" %>
	

	<!-- BREADCRUMB -->
	
	<div id="breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="${context}/product/get_cat_retrieve.do">Home</a></li>
				<%if(pro.getH_code().equals("10")){ %>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=10">먹거리</a></li>
				<% }else if(pro.getH_code().equals("20")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=20">생활용품</a></li>
				<% }else if(pro.getH_code().equals("30")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=30">위생용품</a></li>
				<% }else if(pro.getH_code().equals("40")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=40">외출용품</a></li>
				<%}else {%>
				<li><a href="#"></a></li>
				<%}%>
				
				
				<%if(pro.getL_code().equals("11")){ %>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=10&lCodeCat=11">사료</a></li>
				<% }else if(pro.getL_code().equals("12")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=10&lCodeCat=12">간식</a></li>
				<% }else if(pro.getL_code().equals("21")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=20&lCodeCat=21">하우스</a></li>
				<% }else if(pro.getL_code().equals("22")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=20&lCodeCat=22">캣타워</a></li>
				<% }else if(pro.getL_code().equals("23")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=20&lCodeCat=23">낚싯대</a></li>
				<% }else if(pro.getL_code().equals("24")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=20&lCodeCat=24">레이져</a></li>
				<% }else if(pro.getL_code().equals("25")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=20&lCodeCat=25">스크래쳐</a></li>
				<% }else if(pro.getL_code().equals("31")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=30&lCodeCat=31">목욕용품</a></li>
				<% }else if(pro.getL_code().equals("32")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=30&lCodeCat=32">화장실용품</a></li>
				<% }else if(pro.getL_code().equals("33")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=30&lCodeCat=33">미용용품</a></li>
				<% }else if(pro.getL_code().equals("41")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=40&lCodeCat=41">이동장</a></li>
				<% }else if(pro.getL_code().equals("42")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=40&lCodeCat=42">가슴줄</a></li>
				<% }else if(pro.getL_code().equals("43")) {%>
				<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=40&lCodeCat=43">의류</a></li>
				<%}else {%>
				<li><a href="#"></a></li>
				<%}%>
				<li class="active"><c:out value="${vo.p_name}"/></li>
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
				<!--  Product Details -->
				<div class="product product-details clearfix">
					<div class="col-md-6" >
					<img src="${context}/${vo.p_image}" width="300px" height="300px"  alt="" style="margin-left: auto; margin-right: auto; display: block;">
					</div>
					<div class="col-md-6">
					
					<div class="product-body">
							
							<h2 class="product-name"><c:out value="${vo.p_name}"/></h2>
							<c:choose>
								<c:when test="${vo.sale_percent=='100'}">
									<h3 class="product-price"><fmt:formatNumber value="${vo.p_price}"/> 원</h3>
								</c:when>
								<c:otherwise>
									<small>원가 <del class="font-weak"><fmt:formatNumber value="${vo.p_price}"/> 원</del></small>
									<br>
									<h3 class="product-price"><fmt:formatNumber value="${(vo.p_price*vo.sale_percent)/100}"/> 원</h3>
								</c:otherwise>	
							</c:choose>
							
							
							
							
							
							
							
							<%if(pro.getStatus().equals("10")){ %>
							<p><strong>상태:</strong> 판매중</p>
							<% }else if(pro.getStatus().equals("20")) {%>
							<p><strong>상태:</strong> 재입고 예정</p>
							<%}else if (pro.getStatus().equals("30")) {%>
							<p><strong>상태:</strong>매진</p>
							<%}else {%>
							<p><strong>상태:</strong></p>
							<%}%>
							
							<p><strong>제조회사:</strong><c:out value="${vo.p_company}"/></p>
							
						<div class="product-options">
						
							<p><strong>재고:</strong><c:out value="${vo.stock}"/>개 남음</p>
							<div class="qty-input test">
								<span class="text-uppercase">수량: </span>
								<input class="input" value="1" id="quantity" type="number">
							</div>	
						</div>
						
						
						<div class="product-btns">
								
							<button class="primary-btn add-to-cart buy" id="buy">구매하기</button>	
							<button class="primary-btn add-to-cart" id="cart" >장바구니 담기</button>
							
						</div>
					</div>
					</div>
					<div class="col-md-12">
						<div class="product-tab">
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">상품에 대한 자세한 설명</a></li>
								
							</ul>
							<div class="tab-content">
								<div id="tab1" class="tab-pane fade in active">
									<p><p><c:out value="${vo.p_content}"/></p></p>
								</div>
								
							</div>
						</div>
					</div>

				</div>
				<!-- /Product Details -->
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
			
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	
	
	<form class="form-horizontal" name="detailFrm" id="detailFrm" method="get">
	   	<input type="hidden" name="p_code" value='${vo.p_code}'/>	    
	   	<input type="hidden" name="unit_price" value='${(vo.p_price*vo.sale_percent)/100}'/>
	   	<input type="hidden" name="stock" id ="stock" value='${vo.stock}'/>
	   	<input type="hidden" name="quantitiy"/>
	</form>
	
	<form class="form-horizontal" name="detailFrm2" id="detailFrm2" method="get">
	   	<input type="hidden" name="pCode" value='${vo.p_code}'/>
	    <input type="hidden" name="quantity"/>
	   	<input type="hidden" name="unitPrice" value='${(vo.p_price*vo.sale_percent)/100}'/>
	   	<input type="hidden" name="pName" value='${vo.p_name}'/>
	   	<input type="hidden" name="id" value='${user.id}'/>
	</form>
	
	
	<!-- /section -
	<!-- FOOTER -->
	<%@include file ="/template/footer.jsp" %>
	<!-- /FOOTER -->
	
	<!-- jQuery Plugins -->
	<script src="${context}/resources/js/jquery.min.js"></script>
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<script src="${context}/resources/js/slick.min.js"></script>
	<script src="${context}/resources/js/nouislider.min.js"></script>
	<script src="${context}/resources/js/jquery.zoom.min.js"></script>
	<script src="${context}/resources/js/main.js"></script>
	
	<script>

	
	
	//구매버튼
	 $("#buy").on('click',function() {
		  	  
	   	
		  var quantitiy = $('#quantity').val();
		  var stock = $('#stock').val();
		  
		  
		  var frm = document.detailFrm;
		  
		  frm.quantitiy.value=quantitiy;
		  
		  frm.action = "${context}/order/get.do?stock"+stock;
	   	  frm.submit();
	   	 
	
	   	 
	 	 });				//---function
	 	 
	 	
	
	//장바구니 담기버튼
	 $("#cart").on('click',function() {
		  
		 confirm("장바구니에 담으시겠습니까?");
	   
		 var quantity = $('#quantity').val();
		 
		 var frm = document.detailFrm2;
		 frm.quantity.value=quantity;
		 frm.action = "${context}/cart/get.do";
	   	 frm.submit();
	   	 
	   	 
	   	 
	   	 
	 	 });
		
   
  		 $(document).ready(function() {
					
			
  					
  			
			});	// function
	</script>
</body>

</html>
