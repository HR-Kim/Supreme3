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
<%
	Board vo = (Board)request.getAttribute("bvo"); 
%>
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
	    <dir>
	    <tr>
			<td><input type="hidden" name="seq" id="seq" value="${bvo.b_seq}" ></td>
		</tr>
	   	<tr>
			<td><textarea id="title" name="title" value="${bvo.b_title()} placeholder="제목" maxlength="100" 
					 style="margin-top:20px; width: 1000px; height:50px;"></textarea></td>
		</tr>
		<tr>
			<td><textarea id="contents" name="contents" placeholder="내용" value="${bvo.b_contents()} maxlength="2048" 
					 style="margin-top:20px; width: 1000px; height:500px;"></textarea></td>
		</tr>
	    </dir>
	    </div>
	    <button class="primary-btn" id="do_wirte"style="margin-left:1300px;">등록하기</button>
	   	<dir>
	    </dir>
	    <br>
		<!--// div title -->
<script type="text/javascript">

</script>
</body>
   <!-- FOOTER -->
   <%@include file ="/template/footer.jsp" %>
   <!-- /FOOTER -->	
</html>