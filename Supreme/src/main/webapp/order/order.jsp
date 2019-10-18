<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.supreme.cart.service.Cart"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//Cart list = (Cart)request.getAttribute("list");
List<Cart> list = new ArrayList<Cart>();
Cart cart = new Cart();

for(int i=0;i<3;i++){
	cart.setCartCode(i);
	cart.setpCode(i);
	cart.setQuantity(i);
	cart.setUnitPrice(i);
	cart.setId("admin");

	list.add(cart);
}





 %>
<c:set var="context" value="${pageContext.request.contextPath }" />
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>주문 / 결제</title>
<!-- 부트스트랩 -->
<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- 입력 Form -->
	<div class="container">
		<!-- div title -->
		<div class="page-header">
			<h1>주문 / 결제</h1>
		</div>
		<!--// div title -->
	
		<div class="col-lg-12"></div>
		<div class="col-lg-12"></div>
		<div class="panel panel-default"></div>
		<!-- 입력 form -->
		<form action="do_update.do" name="frmJoin" id="frmJoin" method="post" class="form-horizontal">
			
			<h3>받는사람 정보</h3>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-8">	
					<input type="text" maxlength="300"  class="form-control input-sm" id="name"  name="name">
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">우편번호</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="postcode"  name="postcode">
				</div>
			</div>
			<div class="form-group">
				<label for="address1" class="col-sm-2 control-label">주소</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="address1"  name="address1">
				</div>
			</div>
			<div class="form-group">
				<label for="address2" class="col-sm-2 control-label">상세주소</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="address2"  name="address2">
				</div>
			</div>
			<div class="form-group">
				<label for="tel" class="col-sm-2 control-label">연락처</label>
				<div class="text-left col-sm-3">
					<input type="text" maxlength="300" with="20%" class="form-control input-sm" id="tel"  name="tel">
				</div>
			</div>	
			<div class="form-group">
				<label for="request" class="col-sm-2 control-label">배송 요청사항</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="request"  name="request">
				</div>
			</div>
			<br>
			<br>
			
			<h3>배송 0건중 0건</h3>
			<div class="form-group">
				<label for="product" class="col-sm-2 control-label">상품목록</label>
				<div class="col-sm-4">
					<input type="text" maxlength="300"  class="form-control input-sm" id="product">
				</div>
			</div>
			<br>
			<br>
			<h3>결제정보</h3>
			<div class="form-group">
				<label for="paymethod" class="col-sm-2 control-label">결제방법</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="paymethod"  name="paymethod">
				</div>
			</div>	
			<div class="form-group">
				<label for="bank" class="col-sm-2 control-label">은행명</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="bank"  name="bank" >
				</div>
			</div>
			<div class="form-group">
				<label for="depositName" class="col-sm-2 control-label">입금인명</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="depositName"  name="depositName">
				</div>
			</div>		
			
		</form>
		
		<!-- Button Area -->
		<div class="row">
			<div class="col-lg-10 col-sm-10 col-xs-10">
				<div class="text-right">
					<button type="button" class="btn btn-primary btn-lg"  id="doPayment">결제하기</button>
				</div>
			</div>
		</div>
		
	</div>
	<!--// div container -->
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${context}/resources/js/jquery-1.12.4.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
		
		//등록
	    $("#doPayment").on("click",function(){
	    	console.log("doSave");
	    	payment();
	    	
	    	
	  
	    });
		
		function payment(){
			
			
			if(!$("#name").val()){
				alert("이름을 입력하세요.");
				document.getElementById("name").focus();
				return false;
			}
			if(!$("#postcode").val()){
				alert("우편번호를 입력하세요.");
				document.getElementById("postcode").focus();
				return false;
			} 
			
			if(!$("#address1").val()){
				alert("주소를 입력하세요.");
				document.getElementById("address1").focus();
				return false;
			}	
			if(!$("#address2").val()){
				alert("상세주소를 입력하세요.");
				document.getElementById("address2").focus();
				return false;
			}	
		
			if(!$("#tel").val()){
				alert("연락처를 입력하세요.");
				document.getElementById("tel").focus();
				return false;
			}	
			
			
			console.log("check okay!");
			
			
			
			$.ajax({
	            type:"POST",
	            url:"${context}/order/do_save.do",
	            dataType:"html",// JSON
	            data:{
	            	/* "order_code" :"111",
	            	"id" :"admin",
	            	"r_name": $("#name").val(),
	            	"email": $("#email").val(),
	            	"name": $("#name").val(),
	            	"name": $("#phone").val(),
	            	"r_postcode1": $("#postcode").val(),
	            	"r_address2": $("#address").val(),
	            	"r_tel" : $("#phone2").val(),
	            	"request": $("#request").val(),
	            	"product": $("#product").val(),
	            	"totalprice": $("#totalprice").val(),
	            	"delivery": $("#delivery").val(),
	            	"pay_method": $("#paymentway").val(),
	            	"bank": "111",
	            	"deposit_name": "111", */
	            	"orderCode" : 222,
	            	"id" : "admin",
	            	"rName" : $("#name").val(),
	            	"rPostcode" : $("#postcode").val(),
	            	"rAddress1" : $("#address1").val(),
	            	"rAddress2" : $("#address2").val(),
	            	"rTel" : $("#tel").val(),
	            	"request" : $("#request").val(),
	            	"payMethod" : $("#paymethod").val(),
	              	"bank" : $("#bank").val(),
	              	"depositName" : $("#depositName").val(),
	              	
	            	
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
	                //console.log(data);
	            	//{"msgId":"1","msgMsg":"삭제 되었습니다.","totalCnt":0,"num":0}
	            	var parseData = $.parseJSON(data);
	            	if(parseData.msgId=="1"){
	            		alert(parseData.msgMsg);
	            		console.log("가입완료!");
	            	}else{
	            		alert(parseData.msgMsg);
	            	}
	            	

	            	
	            },
	            complete: function(data){//무조건 수행
	             
	            },
	            error: function(xhr,status,error){
	             
	            }
	        });	
			
			
		};
		
	

	
		
	</script>	
	 
</body>
</html>