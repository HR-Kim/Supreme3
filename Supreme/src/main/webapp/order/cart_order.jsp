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
<%@include file ="/template/header.jsp" %>
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
					<input type="text" maxlength="300"   id="postcode" placeholder="우편번호"  name="postcode"disabled="disabled">
				<button type="button" class="btn btn-default btn-sm" id="pcode_search">우편번호 조회</button>
				</div>
			</div>

			
			<div class="form-group">
				<label for="address1" class="col-sm-2 control-label">주소</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="address1" placeholder="주소" name="address1" disabled="disabled">
				</div>
			</div>
			<div class="form-group">
				<label for="address2" class="col-sm-2 control-label">상세주소</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="address2" placeholder="상세 주소를 입력해 주세요." name="address2">
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

			<div class="form-group">
				<label for="product" class="col-sm-2 control-label"></label>
				<div class="col-md-12">
						<div class="order-summary clearfix">
							<div class="section-title">
								<h3 class="title">상품 목록</h3>
							</div>
							<table class="shopping-cart-table table">
								<thead>
									<tr>
										<th>Product</th>
										<th></th>
										<th class="text-center">Price</th>
										<th class="text-center">Quantity</th>
										<th class="text-center">Total</th>
										
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="details"><a href="#">${aaa.getP_code()}</a></td>
										<th></th>
										<td class="price text-center"><strong>${aaa.getUnit_price()}</strong><br></td>
										<td class="qty text-center"><strong class="primary-color">${aaa.getQuantitiy()}</strong></td>
										<td class="total text-center"><strong class="primary-color">${aaa.getUnit_price()}</strong></td>
									</tr>
									
								</tbody>
								
							</table>
								<div class="pull-right">
								<button type="button" class="primary-btn" id="doPayment">결제하기</button>
								</div>
						</div>

					</div>
			<br>
			<br>
		</div>
			
		</form>
		
	
		
	</div>
	<!--// div container -->
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${context}/resources/js/jquery-1.12.4.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<!--밑에 두줄 아임포트 라이브러리 -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>


<!-- 우편번호 -->
<script>
//우편번호 찾기 버튼 이벤트
$("#pcode_search").on("click",function(){
	console.log("pcode_search");
	sample6_execDaumPostcode();
});

//우편번호 찾기 함수
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                
            
            } 

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("address2").focus();
        }
    }).open();
};
</script>



	<script type="text/javascript">
		//등록
	    $("#doPayment").on("click",function(){
	    	console.log("doSave");
	    	pay();
	    	
	    	
	  
	    });
		
	    function pay() {
	    	
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
			
	    	var IMP = window.IMP; // 생략가능
	    	IMP.init('iamport');
	    	// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	    	// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
	    	IMP.request_pay({
	    	pg: 'payco', // version 1.1.0부터 지원.
	    	/*
	    	'kakao':카카오페이,
	    	html5_inicis':이니시스(웹표준결제)
	    	'nice':나이스페이
	    	'jtnet':제이티넷
	    	'uplus':LG유플러스
	    	'danal':다날
	    	'payco':페이코
	    	'syrup':시럽페이
	    	'paypal':페이팔
	    	*/
	    	pay_method: 'card',
	    	/*
	    	'samsung':삼성페이,
	    	'card':신용카드,
	    	'trans':실시간계좌이체,
	    	'vbank':가상계좌,
	    	'phone':휴대폰소액결제
	    	*/
	    	merchant_uid: 'merchant_' + new Date().getTime(),
	    	/*
	    	merchant_uid에 경우
	    	https://docs.iamport.kr/implementation/payment
	    	위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
	    	참고하세요.
	    	나중에 포스팅 해볼게요.
	    	*/
	    	name: '주문명:결제테스트',
	    	//결제창에서 보여질 이름
	    	amount: 100,
	    	//가격
	    	buyer_email: 'iamport@siot.do',
	    	buyer_name: '구매자이름',
	    	buyer_tel: '010-1234-5678',
	    	buyer_addr: '서울특별시 강남구 삼성동',
	    	buyer_postcode: '123-456',
	    	m_redirect_url: 'https://www.yourdomain.com/payments/complete'
	    	/*
	    	모바일 결제시,
	    	결제가 끝나고 랜딩되는 URL을 지정
	    	(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
	    	*/
	    	}, function (rsp) {
	    	console.log(rsp);
	    	if (rsp.success) {
	    	var msg = '결제가 완료되었습니다.';
	    	msg += '고유ID : ' + rsp.imp_uid;
	    	msg += '상점 거래ID : ' + rsp.merchant_uid;
	    	msg += '결제 금액 : ' + rsp.paid_amount;
	    	msg += '카드 승인번호 : ' + rsp.apply_num;
	    	payment();
	    	} else {
	    	var msg = '결제에 실패하였습니다.';
	    	msg += '에러내용 : ' + rsp.error_msg;
	    	}
	    	alert(msg);
	    	});
	    	};
		
		function payment(){
		
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
	            	"id" : "admin",
	            	"rName" : $("#name").val(),
	            	"rPostcode" : $("#postcode").val(),
	            	"rAddress1" : $("#address1").val(),
	            	"rAddress2" : $("#address2").val(),
	            	"rTel" : $("#tel").val(),
	            	"request" : $("#request").val(),	
	              	"p_code" : "123",
	              	"quantitiy" : "1",
	              	"unit_price" : "10000",
	              	"check" : "1"
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
	                //console.log(data);
	            	//{"msgId":"1","msgMsg":"삭제 되었습니다.","totalCnt":0,"num":0}
	            	var parseData = $.parseJSON(data);
	            	if(parseData.msgId=="1"){
	            		alert(parseData.msgMsg);
	            		console.log("결제완료!");
	            		location.href = "${context}/order/order_success.jsp"
	            		
	            		
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
	
</body>
</html>