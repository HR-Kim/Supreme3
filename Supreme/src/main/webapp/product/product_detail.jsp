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

%>
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
				<li><a href="#">Home</a></li>
				<li><a href="#"><c:out value="${vo.h_code}"/></a></li>
				<li><a href="#"><c:out value="${vo.l_code}"/></a></li>
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
					<div class="col-md-6">
					
						
					</div>
					<div class="col-md-6">
					<div class="product-body">
							
							<h2 class="product-name" title="<c:out value='${vo.p_name}'/>"><c:out value="${vo.p_name}"/></h2>
							<h3 class="product-price" title="<c:out value='${vo.p_price}'/>"><c:out value="${vo.p_price}"/> 원</h3>
							
							<p><strong>상태:</strong><c:out value="${vo.status}"/></p>
							<p><strong>제조회사:</strong><c:out value="${vo.p_company}"/></p>
							
						<div class="product-options">
							<p><strong title="<c:out value='${vo.stock}'/>">상품 재고:</strong><c:out value="${vo.stock}"/> 개 남음</p>	
							<p><strong>팔린 상품개수:</strong><c:out value="${vo.unit_sales}"/> 개 팔림</p>	
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
	   	<input type="hidden" name="p_code" value='모찌'/>
	   	<input type="hidden" name="quantitiy" value='1' />
	   	<input type="hidden" name="unit_price" value='300000'/>
	</form>
	
	<form class="form-horizontal" name="detailFrm2" id="detailFrm2" method="get">
	   	<input type="hidden" name="pCode" value='1111'/>
	   	<input type="hidden" name="quantity" value='1' />
	   	<input type="hidden" name="unitPrice" value='30000'/>
	   	<input type="hidden" name="pName" value='모찌'/>
	   	<input type="hidden" name="id" value='admin'/>
	</form>
	
	
	<!-- /section -->
	<!-- FOOTER -->
	<%@include file ="/template/footer.jsp" %>
	<!-- /FOOTER -->
	
	<!-- jQuery Plugins -->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/slick.min.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.zoom.min.js"></script>
	<script src="../resources/js/main.js"></script>
	
	<script>

	
	
	//구매버튼
	 $("#buy").on('click',function() {
		  
		  /*  var p_name = $(this).attr("title");
		   var p_price = $(this).attr("title");
		   var stock = $(this).attr("title"); */
		   
		  
		   /* frm.p_name.value=p_name;
		   frm.p_price.value=p_price;
		   frm.stock.value=stock; */
		  // frm.action = "${context}/order/get.do";
	   
		  var frm = document.detailFrm;
		  frm.action = "${context}/order/get.do";
	   	 frm.submit();
	   	 
	 	 });
	
	//장바구니 담기버튼
	 $("#cart").on('click',function() {
		  
		  /*  var p_name = $(this).attr("title");
		   var p_price = $(this).attr("title");
		   var stock = $(this).attr("title"); */
		   
		  
		   /* frm.p_name.value=p_name;
		   frm.p_price.value=p_price;
		   frm.stock.value=stock; */
		  // frm.action = "${context}/order/get.do";
	   
		 var frm = document.detailFrm2;
		 frm.action = "${context}/cart/get.do";
	   	 frm.submit();
	   	 alert("장바구니에 담겼습니다.");
	 	 });
		
   
  		 $(document).ready(function() {
					
			
  					
  			
			});	// function
	</script>
</body>

</html>
