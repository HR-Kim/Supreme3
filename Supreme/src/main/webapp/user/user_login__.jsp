<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<html lang="ko">
<head>
<style type="text/css">
	.img_wrap{
		width: 140px;
	}
	.img_wrap img{
		max-width: 100%;
	}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" type="text/css" href="${context}/resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${context}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${context}/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${context}/resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${context}/resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${context}/resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${context}/resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${context}/resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${context}/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="${context}/resources/css/main.css">
<!--===============================================================================================-->
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>회원 가입</title>
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
 	<!-- Header -->
	<%@include file ="../template/header.jsp" %>
	<!--/ Header -->
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
				<form class="login100-form validate-form" name="loginForm" id="loginForm" 
				     action="${context}/user/do_login.do" method="post">

					<span class="login100-form-title p-b-33">
						로그인
			
					</span>
					
				    <div class="col-lg-10"></div>
				    <div class="col-lg-10"></div>
				    <div class="col-lg-10"></div>
					<div class="wrap-input100 validate-input" data-validate = "Username is required">
						<input class="input100" type="text" name="u_id" id="u_id" placeholder="아이디">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="passwd" id="passwd"   placeholder="비밀번호">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>
                 </form>
					<div class="container-login100-form-btn m-t-20">
						<button class="login100-form-btn" id="signIn">
							Login
						</button>
					</div>
				
					<div class="text-center p-t-45 p-b-4">
						<span class="txt1">
							아이디와 비밀번호를 잊으셨나요?
						</span>

						<a href="#" class="txt2 hov1">
							아이디/비밀번호 찾기
						</a>
					</div>

					<div class="text-center">
						<span class="txt1">
							묘한 생각에 가입하시겠습니까?
						</span>

						<a href="#" class="txt2 hov1" onclick="joinLocation()">
							회원가입
						</a>
					</div>
				
					
					
				
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>	
		

		

	<script src="${context}/resources/js/main.js"></script>	 
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${context}/resources/js/jquery-1.12.4.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
	
	
		function do_login(){
			var frm = document.loginForm;
			//validation
			frm.submit();
		}
			
		$("#signIn").on("click",function(){
			//alert("signIn");
			
			$.ajax({
				type : "POST",
				url : "${context}/user/do_login.do",
				dataType : "html",
				data : {
					"id" : $("#u_id").val(),
					"pass" : $("#passwd").val()
				},
				success : function(data) {
					var jData = JSON.parse(data);
					
					if(null != jData){
						if (jData.msgId == "30") {
							alert("로그인에 성공했습니다");
	
							
						}else if (jData.msgId == "10") {
							$("#u_id").focus();
							alert(jData.msgMsg);
	
						}else if ( jData.msgId == "20") {
							$("#passwd").focus();
							alert(jData.msgMsg);
						}
					}
				},
				complete : function(data) {

				},
				error : function(xhr, status, error) {
					alert("error:" + error);
					
				}
			});	
		});
		

		//회원가입 창으로 이동
		function joinLocation(){
			location.href = "${context}/user/user_join.jsp"
		};
		
		
		
		
		</script>	
	<!-- FOOTER -->
	<%@include file ="../template/footer.jsp" %>
	<!-- /FOOTER -->
</body>
</html>