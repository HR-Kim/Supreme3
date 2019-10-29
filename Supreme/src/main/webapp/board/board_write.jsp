<%@page import="kr.co.supreme.board.service.Board" %>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@page import="kr.co.supreme.board.service.BoardSearch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
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
   <%@include file ="/template/header.jsp" %>
   <!--/ Header -->
	<!-- div container -->
	<div class="container">
		<!-- div title -->
		<div class="section-title">
			<h3 class="title">공지사항</h3>
	</div>		
		<br>
		<div class="text-right">
			<form class="form-horizontal" name="boardEditFrm" id="boardEditFrm" method="post" action="do_update.do">
				<input type="hidden" class="form-control" name="bSeq" id="bSeq" value="${vo.bSeq }">
					
				  	<c:choose>
						<c:when test="${user.id=='admin' }">
							<div class="text-right"  >
								<button type="button" class="primary-btn" id="doInit">초기화</button>
								<button type="button" class="primary-btn" id="doUpdate">수정</button>
								<button type="button" class="primary-btn" id="doDelete">삭제</button>								
							</div>
						</c:when>
					</c:choose>
				  	
	   			 <tr>
					<td><input type="hidden" name="seq" id="seq" value="${vo.bSeq}" ></td>
				</tr>
			   	<tr>
					<td><input id="title" name="title" value="<c:out value= '${vo.bTitle}'/>" placeholder="제목" maxlength="100" 
							 style="margin-top:20px; width: 1000px; height:50px;"/></td>
				</tr>
		
				<tr>
					<td><textarea id="contents" name="contents" placeholder="내용"  maxlength="2048" 
							 style="margin-top:20px; width: 1000px; height:500px;"><c:out value= '${vo.bContents}'/></textarea></td>
				</tr>
	  	 	</form>
	  	 	<c:choose>
				<c:when test="${user.id=='admin' }">
					<div class="text-right"  >
						<button class="primary-btn" id="do_wirte">등록하기</button>							
					</div>
				</c:when>
			</c:choose>
	  	 	
	  	 	 
	  	 	 <button class="primary-btn" id="goRetrieve">목록으로 돌아가기</button>
	  	 	 <br>
	   	 </div>
	   </div>
	
	    <br>
		<!--// div title -->
		
<script type="text/javascript">

$("#doDelete").on("click", function() {
	
	console.log("title:" + $("#title").val());
	if (confirm("삭제하시겠습니까?") == false)
		return;

	$.ajax({
		type : "POST",
		url : "${context}/board/do_delete.do",
		dataType : "html",
		data : {
			"bSeq"	  : $("#bSeq").val(),	
		},
		success : function(data) {
			location.href = "${context}/board/get_retrieve.do";
		}
	
	});
	});
	//--ajax  

$("#doUpdate").on("click", function() {
	
	console.log("title:" + $("#title").val());
	if (confirm("수정 하시겠습니까?") == false)
		return;

	$.ajax({
		type : "POST",
		url : "${context}/board/do_update.do",
		dataType : "html",
		data : {
			"bSeq"	  : $("#bSeq").val(),
			"bTitle" : $("#title").val(),
			"bContents" : $("#contents").val(),
			"Id" : "admin",
			"udtUser" : "admin",
			"bCode" : 1,
			"pCode" : 1
			
		},
		success : function(data) {
			var jData = JSON.parse(data);
			if (null != jData && jData.msgId == "1") {
				alert(jData.msgMsg);
				location.href = "${context}/board/get_retrieve.do";

			} else {
				alert(jData.msgId + "|" + jData.msgMsg);
			}
		},
		complete : function(data) {

		},
		error : function(xhr, status, error) {
			alert("error:" + error);
		}
	});
	//--ajax  

});


//목록
$("#doRetrieve").on("click", function() {
	if (confirm("목록으로 이동 하시겠습니까?") == false)return;

	location.href = "${context}/board/get_retrieve.do";
});
//목록
$("#goRetrieve").on("click", function() {
	if (confirm("목록으로 이동 하시겠습니까?") == false)return;

	location.href = "${context}/board/get_retrieve.do";
});
//초기화
$("#doInit").on("click", function() {
	//alert("doInit");
	//input data clear
	$("#title").val("")
	$("#contents").val("");
	

	//버튼제어:등록,수정,삭제
	$("#doUpdate").prop("disabled", true);
	$("#doDelete").prop("disabled", true);
	$("#doSave").prop("disabled", false);

	$("#regId").prop("disabled", false);

});

$("#do_wirte").on('click',function(){
	//alert('writebtn');
	var title= $("#title").val();
	//alert("title:"+rtitle)
	alert($("#title").val())
	if(null == title ||title.trim().length ==0){
		$("#title").focus();
		alert('제목을 입력하세요');
		return;	
	}
	var contents = $("#contents").val();
	if(null == contents || contents.trim().length == 0){
		$("#contents").focus();
		alert('내용을 입력 하세요.');
		return ;
	}   
	$.ajax({
		type : "POST",
		url : "${context}/board/do_save.do",
		dataType : "html",
		data : {
			"bSeq"  :10,
			"bTitle" : $("#title").val(),
			"bContents" : $("#contents").val(),
			"readCnt"   : 0,
			"Id" : "admin",
			"udtUser" : "admin",
			"bCode" : 1,
			"pCode" : 1
		},
		success : function(data){
			var update;
			update = confirm("등록하시겠습니까?");
			if(update){
				document.write("등록되었습니다.")
			}
			location.href = "${context}/board/get_retrieve.do";

		}
	  }); 
});

$(document).ready(function() {
	$("goRetrieve").hide();
	if($("#title").val()==""){
		$("#doUpdate").hide();
		$("#doDelete").hide();
		$("#doRetrieve").hide();
		$("#doInit").hide();
		$("goRetrieve").show();
	}  
});
</script>
</body>
   <!-- FOOTER -->
   <%@include file ="/template/footer.jsp" %>
   <!-- /FOOTER -->	
</html>