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
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>ID/PW 찾기</title>
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
	<!-- div container -->
	<div class="container">
		<!-- div title -->
		<div class="page-header">
			<h1 class="p-b-33">ID/PW 찾기</h1>
		</div>
		<!--// div title -->
		<div class="col-lg-12"></div>
		<div class="col-lg-12"></div>
		<div class="panel panel-default"></div>
		
			<div class="col-lg-12">
				<!--  -->
				<ul class="nav nav-tabs nav-justified" role="tablist" id="myTab">
				  	<li role="presentation" class="active">
				  		<a href="#idFind" id="idFind-tab" role="tab" data-toggle="tab" aria-controls="idFind" aria-expanded="true">ID 찾기</a></li>
				 	<li role="presentation">
				 		<a href="#pwFind"  role="tab" id="pwFind-tab" data-toggle="tab" aria-controls="pwFind">PW 찾기</a></li>
				</ul>
			
				<!--  -->
				<div id="myTabContent" class="tab-content">
				    <!-- ID찾기 항목 -->					
				    <div role="tabpanel" class="tab-pane fade in active" id="idFind" aria-labelledBy="idFind-tab">
				        <form action="do_idFind.do" name="frmIdFind" id="frmIdFind" method="post" class="form-horizontal">
					        <!-- 입력 form -->
					        <div class="form-group"></div>
					        <div class="form-group">
					        	<label for="idFind_name" class="col-sm-2 control-label">이름</label>
								<div class="col-sm-8">
									<input type="text" maxlength="300"  class="form-control input-sm" id="idFind_name" placeholder="가입할 때 입력한 이름을 입력하세요." name="idFind_name">
								</div>
							</div>
							<div></div>
							<div class="form-group">
					        	<label for="idFind_tel" class="col-sm-2 control-label">전화번호</label>
								<div class="col-sm-8">
									<input type="text" maxlength="300"  class="form-control input-sm" id="idFind_tel" placeholder="가입할 때 입력한 전화번호를 입력하세요." name="idFind_tel">
								</div>
							</div>
							<div class="form-group">
								<label for="idFind_email1" class="col-sm-2 control-label">이메일</label>
								<div class="text-left col-sm-3">
									<input type="text" maxlength="300" with="20%" class="form-control input-sm" id="idFind_email1" placeholder="이메일" name="idFind_email1">
								</div>
								<label for="idFind_email2" class="col-sm-1 control-label">@</label>
								<div class="text-left col-sm-3">
									<input type="text" maxlength="300"  class="form-control input-sm" id="idFind_email2" placeholder="도메인 (ex naver.com)" name="idFind_email2">
								</div>
							
							</div>	
							
							<div class="row"></div>
							<div class="row"></div>
						</form>	
						<!-- Button Area -->
						<div class="row">
							<div class="col-lg-10 col-sm-10 col-xs-10">
								<div class="text-center">
									<button type="button" class="btn btn-default " id="doIdFind">ID 찾기</button>
								</div>
							</div>
						</div>
						<!-- //Button Area -->
						
				    </div>
				    
				    <!-- PW찾기 항목 -->
			      	<div role="tabpanel" class="tab-pane fade" id="pwFind" aria-labelledBy="pwFind-tab">
			       	 	<form action="do_pwFind.do" name="frmPwFind" id="frmPwFind" method="post" class="form-horizontal">
					        <!-- 입력 form -->
					        <div class="form-group"></div>
					        <div class="form-group">
					        	<label for="pwFind_id" class="col-sm-2 control-label">ID</label>
								<div class="col-sm-8">
									<input type="text" maxlength="300"  class="form-control input-sm" id="pwFind_id" placeholder="ID를 입력하세요." name="pwFind_id">
								</div>
							</div>
					        <div class="form-group">
					        	<label for="pwFind_name" class="col-sm-2 control-label">이름</label>
								<div class="col-sm-8">
									<input type="text" maxlength="300"  class="form-control input-sm" id="pwFind_name" placeholder="가입할 때 입력한 이름을 입력하세요." name="pwFind_name">
								</div>
							</div>
							<div></div>
							<div class="form-group">
					        	<label for="pwFind_tel" class="col-sm-2 control-label">전화번호</label>
								<div class="col-sm-8">
									<input type="text" maxlength="300"  class="form-control input-sm" id="pwFind_tel" placeholder="가입할 때 입력한 전화번호를 입력하세요." name="pwFind_tel">
								</div>
							</div>
							<div class="form-group">
								<label for="pwFind_email1" class="col-sm-2 control-label">이메일</label>
								<div class="text-left col-sm-3">
									<input type="text" maxlength="300" with="20%" class="form-control input-sm" id="pwFind_email1" placeholder="이메일" name="pwFind_email1">
								</div>
								<label for="pwFind_email2" class="col-sm-1 control-label">@</label>
								<div class="text-left col-sm-3">
									<input type="text" maxlength="300"  class="form-control input-sm" id="pwFind_email2" placeholder="도메인 (ex naver.com)" name="pwFind_email2">
								</div>
							
							</div>	
							
							<div class="row"></div>
							<div class="row"></div>
						</form>	
						<!-- Button Area -->
						<div class="row">
							<div class="col-lg-10 col-sm-10 col-xs-10">
								<div class="text-center">
									<button type="button" class="btn btn-default " id="dopwFind">PW 찾기</button>
								</div>
							</div>
						</div>
						<!-- //Button Area -->
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
		$('#myTab a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
		})	
		
		
	</script>	
	 
</body>
</html>