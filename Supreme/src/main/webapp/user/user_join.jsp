<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>회원가입</title>
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
			<h1>회원 가입</h1>
		</div>
		<!--// div title -->
	
		<div class="col-lg-12"></div>
		<div class="col-lg-12"></div>
		<div class="panel panel-default"></div>
		<!-- 입력 form -->
		<form action="do_update.do" name="frmEdit" id="frmEdit" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="u_id" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-6">
					<input type="text" maxlength="10"  class="form-control input-sm" id="u_id" placeholder="아이디를 10자 이내로 입력해 주세요." name="u_id">
				</div>
				<div class="text-right col-sm-2">
					<button type="button" class="btn btn-default btn-sm" id="idCheck">ID 중복 확인</button>
				</div>	
			</div>
			<div class="form-group">
				<label for="passwd" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-8">
					<input type="password" maxlength="100"  class="form-control input-sm" id="passwd" placeholder="비밀번호" name="passwd">
				</div>
			</div>
			<div class="form-group">
				<label for="passwd_check" class="col-sm-2 control-label">비밀번호 확인</label>
				<div class="col-sm-8">
					<input type="password" maxlength="100"  class="form-control input-sm" id="passwd_check" placeholder="비밀번호 확인" name="passwd_check">
				</div>
			</div>			
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="name" placeholder="이름" name="name">
				</div>
			</div>
			<div class="form-group">
				<label for="nickname" class="col-sm-2 control-label">닉네임</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="nickname" placeholder="닉네임" name="nickname">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">이메일</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="email" placeholder="이메일(ex email@email.com)" name="email">
				</div>
			</div>	
			<div class="form-group">
				<label for="tel" class="col-sm-2 control-label">전화번호</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="tel" placeholder="'-'없이 번호만 입력해 주세요." name="tel">
				</div>
			</div>
			<div class="form-group">
				<label for="postcode" class="col-sm-2 control-label">우편번호</label>
				<div class="col-sm-4">
					<input type="text" maxlength="10"  class="form-control input-sm" id="postcode" placeholder="우편번호" name="postcode" disabled="disabled">
				</div>
				<div class="text-right col-sm-4">
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
		</form>
		<!-- Button Area -->
		<div class="row">
			<div class="col-lg-10 col-sm-10 col-xs-10">
				<div class="text-right">
					<button type="button" class="btn btn-default btn-sm" id="doInit">초기화</button>
					<button type="button" class="btn btn-default btn-sm" id="doSave">회원가입</button>
					<button type="button" class="btn btn-default btn-sm" id="doUpdate">수정</button>
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
		
		//ID 중복 확인 이벤트
		$("#idCheck").on("click",function(){
			validation();
	    });
		
		function validation(){
			var id = document.getElementById("u_id").value;
			var flag = false;
			if(id==""){
				alert("아이디를 입력해주세요.");
				return false;	
			}else if(( id < "0" || id > "9")&&( id < "A" || id > "Z")&&(id < "a" || id > "z")){
				alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
				return false;
			}else{
				alert("중복 확인하겠습니다.");
				$.ajax({
					type : "POST",
					url : "${context}/user/id_check.do",
					dataType : "html",
					data : {
						"id" : id
					},	
					success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
		                
		            	var parseData = $.parseJSON(data);
		            	if(parseData.msgId=="0"){
		            		alert(parseData.msgMsg);
		            	}else{
		            		alert(parseData.msgMsg);
		            	}
		            	

		            	
		            },
		            complete: function(data){//무조건 수행
		             
		            },
		            error: function(xhr,status,error){
		             
		            }
				});
	        
			}
		};
	
		//등록
	    $("#doSave").on("click",function(){
	    	
	    });
		
		//초기화
		$("#doInit").on("click",function(){
			$("#u_id").val("");
	     	$("#passwd").val("");
	    	$("#passwd_check").val("");
	    	$("#name").val("");
	    	$("#nickname").val("");
	    	$("#email").val("");
	    	$("#tel").val("");
	    	$("#postcode").val(""); 
	    	$("#address1").val(""); 
	    	$("#address2").val(""); 
	    	
		});	
	
	
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
	 
</body>
</html>