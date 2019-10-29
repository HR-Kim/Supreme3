<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "kr.co.supreme.code.*" %>
<%@page import = "kr.co.supreme.cmn.StringUtil" %>
<%@page import = "kr.co.supreme.cmn.Search" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>\
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value ="${pageContext.request.contextPath }"/>
<% request.setCharacterEncoding("UTF-8"); %>  
<% 
    String detail_code = request.getParameter("detailCode");
	String name		   = request.getParameter("name");
	String status	   = request.getParameter("status");
	String unit_price  = request.getParameter("unit_price");
	String quantitiy   = request.getParameter("quantitiy");
	String p_price     = request.getParameter("p_price");
	
	int uprice		   = Integer.parseInt(unit_price);
	int qaun		   = Integer.parseInt(quantitiy);
	int total 		   = uprice * qaun;
	 System.out.println("name: "+name);
	 System.out.println("detail_code: "+detail_code);
	 System.out.println("status: "+status);
	 System.out.println("unit_price: "+unit_price);
	 System.out.println("quantitiy: "+quantitiy);
%> 

<html>
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

<!-- row -->
	<div class="row">
	<div class="col-md-12">
			<div class="order-summary clearfix">
				<div class="section-title">

					<h3 class="title"> 환불신청</h3>
				</div>
				<div class= "container">
				<div>
				<input type="hidden" name="detailCode" id="detailCode" value="<%=detail_code%>"/>
				<table class="shopping-cart-table table" id="listTable" >
					<thead> 
						<tr>
							<th>Order Number</th>
							<th class="text-left">Product</th>
							<th class="text-left">Status</th>
							<th class="text-center">Price</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total</th>
						</tr>
					</thead>
					<tbody id="tablerow">
						<tr>
							
							<td><%=detail_code%></td>
							<td class="details">
								<a href="#"><%=name%></a>
							</td>	
							<td class="thumb" id="status"><%=status%></td>						
							<td class="price text-center"><strong>$<%=unit_price%></strong><br><del class="font-weak"><small>$<%=p_price%></small></del></td>
							<td class="price text-center"><%=quantitiy%></td>
							<td class="total text-center"><%=total %><strong class="primary-color"></strong>원</td>
							<td class="total text-center">
							</td>
						</tr>
						
					</tbody>
				</table>
				<tr>
					<td>
						<h5 class="text">상품 교환 신청 이후 7일 내로 묘한생각 본사로 보내주세요</h5>
						<h5 class="text"><strong>[서울특별시 마포구 월드컵북로 21 2층 풍성빌딩 묘한생각 앞]</strong></h5>
					<td>

					<h5 class="text">제품 확인 후 교환까지 7일에서 14일이 소요될 예정이니</h5>
					<h5 class="text">My Page내 '상품 배송상태'를 확인해 주세요</h5>
					<h5 class="text">배송완료가 떴는데 상품을 수령하지 못하셨을 경우 </h5>
					<h5 class="text">02) 6334-2630으로 문의바랍니다. </h5>
				
					<input type="checkbox" name="checkOrder" id ="checkOrder" value="check"> 상기 내용을 모두 확인하였습니다.
				</tr>

				</div>
				</div>
				<div class="pull-right">
					<button class="primary-btn" name="refundBtn" id="refundBtn" >환불신청</button>
				</div>
			</div>
		</div>
	</div>
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/slick.min.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.zoom.min.js"></script>
	<script src="../resources/js/main.js"></script>
	<script>
	
	$("#refundBtn").on("click", function() {
		alert("change");
		var checkbox = $('[name=checkOrder]').is(':checked'); 
		if (checkbox != true){
			alert ("약관에 동의해주세요")
			return false;
		}else{
			
		var dcode = <%=detail_code%>
		console.log("dcode"+dcode)
		
		$.ajax({
			type : "POST",
			url : "${context}/orderStauts/do_update.do",
			dataType : "html",
			data : {
				
				"od_status" : "5",
				"detail_code": dcode
			},
			success : function(data){
				alert ("변경되었습니다")
				opener.document.location.reload();
				window.close();
			}
		  });
		}
	});	
	
	</script>	

</body>
</html>