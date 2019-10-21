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
	<%@include file ="../template/header.jsp" %>
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
							<th class="text-left">Order number</th>
							<th class="text-left">Status</th>
							<th class="text-center">Price</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total</th>
							<th class="text-center">Select</th>
						</tr>
					</thead>
					<tbody id="tablerow">
					
						<c:choose>
							<c:when test="${currentlist.size()>0}">
		
								<c:forEach var="cvo" items="${currentlist}">
							<input type="hidden" name="cdetailCode" id="cdetailCode" value="${cvo.detail_code}"/>	
						<tr>
							<td class="thumb"><img value="${cvo.p_image}" alt=""></td>
							<td class="price text-left"><c:out value="${cvo.detail_code}"/></td>
							<td class="details">
								<a href="#"><c:out value="${cvo.p_name}" /></a>
									<ul>
										<li id=orderStatus><span><c:out value="${cvo.od_status}"/></span></li>
									</ul>
							</td>
							<td class="price text-center"><strong>$<c:out value="${cvo.unit_price}"/></strong><br><del class="font-weak"><small>$<c:out value="${cvo.p_price}"/></small></del></td>
							<td class="price text-center"><c:out value="${cvo.quantitiy}"/></td>
							<td class="total text-center"><strong class="primary-color"><c:out value="${cvo.quantitiy * cvo.unit_price}"/></strong></td>
							<td class="total text-center">
							<button class="icon-btn.main-btn" name="cancle" id="cancle">주문취소</button>
							</td>
						</tr>
							
							</c:forEach>
						
						</c:when>
					</c:choose>
					</tbody>
				</table>
			
		</div>
	</div>
	
	<div class="col-md-12">
			<div class="order-summary clearfix">
				<div class="section-title">
					<h3 class="title">Previous Order</h3>
				</div>
				<form name="frmData" id="frmData" method="post">				
				<table class="shopping-cart-table table" id=prelist >
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
							<c:when test="${prelist.size()>0}">
								<c:forEach var="pvo" items="${prelist}">
								<input type="hidden" name="detailCode" id="detailCode" value="${pvo.detail_code}"/>							
								<input type="hidden" name="name" id="name" value="${pvo.p_name}"/>							
								<input type="hidden" name="status" id="status" value="${pvo.od_status}"/>							
								<input type="hidden" name="unit_price" id="unit_price" value="${pvo.unit_price}"/>							
								<input type="hidden" name="quantitiy" id="quantitiy" value="${pvo.quantitiy}"/>							
								<input type="hidden" name="p_price" id="p_price" value="${pvo.p_price}"/>							
						<tr>
							<input type="hidden" name="cdetailCode" id="cdetailCode" value="${pvo.detail_code}"/>	
							<td class="thumb" id="image" name="image"><img value="${pvo.p_image}" alt=""></td>
							
							<td class="details">
								<a href="#" name="name" id="name"><c:out value="${pvo.p_name}" /></a>
								<ul>
									<li name="status" id="status"><span><c:out value="${pvo.od_status}"/></span></li>
								</ul>
							</td>							
							<td class="price text-center" style="display:none;" id="detail_code" name="detail_code"><c:out value="${pvo.detail_code}"/></td>
							<td class="price text-center" id="unit_price" name="unit_price"><strong>$<c:out value="${pvo.unit_price}"/></strong></td>
							<td class="total text-center" id="quantitiy" name="quantitiy"><strong class="primary-color"><c:out value="${pvo.quantitiy * pvo.unit_price}"/></strong></td>
							<td class="total text-center">
							<button class="icon-btn.main-btn" name="refund" id="refund"  onclick="javascript:openRefundPopup(this.form);">환불</button>
							<button class="icon-btn.main-btn" name="change" id="change"  onclick="javascript:openChangePopup(this.form);">교환</button>
							</td>
						</tr>
				
							</c:forEach>
						</c:when>
					</c:choose>
			
					</tbody>
	
				</table>
			</form>
			<!-- /row -->
			</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->
	<!--// div container -->
	
	
	<!-- jQuery Plugins -->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/slick.min.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.zoom.min.js"></script>
	<script src="../resources/js/main.js"></script>
	
	<script type="text/javascript">
	
	/**주문 취소 */
	$("#cancle").click(function(){
		
		var str =""
		var cancle = $(this);
		
		//cancle.parent() : check의 부모는 <td>
		//cancle. parent().parent() : <td>의 부모이므로 <tr>
		
		var tr = cancle.parent().parent();
		var td =tr.children();
		
		console.log("클릭한 row의 모든 데이터 "+tr.text());
		
		var detail_code = td.eq(1).text();
		var od_status	= $("#orderStatus");
		console.log("detail_code "+detail_code);
		console.log("od_status "+orderStatus);
		
		if(od_status = '3'){
			alert ("이미 배송중인 상품은 취소할 수 없습니다.")
			
		}else{
	 
		$.ajax({
			type : "POST",
			url : "${context}/orderStauts/do_update.do",
			dataType : "html",
			data : {
				
				"od_status" : "9",
				"detail_code": detail_code
			},
			success : function(data){
				var update;
				update = confirm("주문을 취소합니다");
				if(update){
					document.write("주문이 취소되었습니다.")
				}
				location.reload();

			}
		  });
		}
	});	
	
	/**주문 취소상태의 경우 버튼 나오지 않게*/

	
	
	
	
	/**교환 버튼*/
	function setChildValue2(detail_code){
	     document.getElementById("detail_code").value = detail_code;
	     
	 }
	 
	 function openChangePopup(frm){
	
	 console.log("detail_code"+detail_code)
	 var url    ="../orderStatus/change_popup.jsp";
	 var title  = "testpop";
	 var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=600, height=400, top=0,left=20"; 
	 window.open("../orderStatus/change_popup.jsp",title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
	                                              //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
	                                              //가능합니다.
	    frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
	    frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
	    frm.method = "post";
	    frm.submit();     
	    
	    
	   }
  
	/**환불버튼*/
	function setChildValue(detail_code){
	     document.getElementById("detail_code").value = detail_code;
	     
	 }
	 
	 function openRefundPopup(frm){
	
	 console.log("detail_code"+detail_code)
	 var url    ="../orderStatus/refund_popup.jsp";
	 var title  = "testpop";
	 var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=600, height=400, top=0,left=20"; 
	 window.open("../orderStatus/refund_popup.jsp",title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
	                                              //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
	                                              //가능합니다.
	    frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
	    frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
	    frm.method = "post";
	    frm.submit();     
	    
	    
	   }
  
	
	</script>
	<!-- FOOTER -->
	<%@include file ="../template/footer.jsp" %>
	<!-- /FOOTER -->

</body>

</html>