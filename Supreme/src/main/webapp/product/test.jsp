<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import = "kr.co.supreme.code.*" %>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value ="${pageContext.request.contextPath }"/>
<%
	/** 페이지 사이즈 */
	String pageSize   = "10"  ; 	
	/** 페이지 번호 */
	String pageNum    = "1"  ;	
	/** 검색조건 */
	String searchDiv  = "" ;
	/** 검색어 */
	String searchWord = "test01" ;
	/** 확장자 */
	String ext = "xls" ;	
	
	Search vo = (Search)request.getAttribute("vo");
	if(null !=vo){
		pageSize   = StringUtil.nvl(vo.getPageSize()+"","10");
		pageNum    = StringUtil.nvl(vo.getPageNum()+"","1");
		searchDiv  = StringUtil.nvl(vo.getSearchDiv(),"");
		searchWord = StringUtil.nvl(vo.getSearchWord(),"");	
	}else{
		pageSize   = "10";
		pageNum    = "1";
		searchDiv  = "";
		searchWord = "";
	}
	
	String extParam = (String)request.getAttribute("ext");
	if(extParam !=null) ext = extParam;
	
	//페이지사이즈
	List<Code> listPageSize=(request.getAttribute("listPageSize")==null)?
			(List<Code>)new ArrayList<Code>():(List<Code>)(request.getAttribute("listPageSize"));
	//게시판 검색 구분
	List<Code> listBoardSearch=(request.getAttribute("listBoardSearch")==null)?
			(List<Code>)new ArrayList<Code>():(List<Code>)(request.getAttribute("listBoardSearch"));
	
	//paging 
	//maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName	
	int maxNum      = 0;//totalCnt
	int bottomCount = 10;
	int currPageNo  = 1;//pageNum
	int rowPerPage  = 10;//pageSize	
	
	String url      = request.getContextPath()+"/cart/get_retrieve.do";
	String scriptName ="search_page";

%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>product update</title>
</head>
<body>
	<!-- Header -->
	<%@include file ="/template/header.jsp" %>
	<!--/ Header -->
	<div class="container">
	<!-- div title -->
		<div class="page-header">
			<h1>상품 등록</h1>
		</div>
	
	
		
		<!-- 입력 form -->
		<form>
		<table>
			<tr>
				<td>
				<div style="border: 1px solid gold; float: left; width: 33%;">첫번째 영역</div>

				
				</td>
			</tr>
			<tr>
				<td>
				<div style="border: 1px solid gold; float: left; width: 33%;">첫e번째 영역</div>
				
				</td>
			</tr>
			<tr>
				<td>
				<div style="border: 1px solid gold; float: left; width: 33%;">첫3번째 영역</div>
				
				</td>
			</tr>
		</table>
		</form>
	</div>	
	
	
	<!-- FOOTER -->
	<%@include file ="/template/footer.jsp" %>
	<!-- /FOOTER -->

	<script src="../resources/js/jquery.min.js"></script>
   	<script src="../resources/js/bootstrap.min.js"></script>
   	<script src="../resources/js/slick.min.js"></script>
    <script src="../resources/js/nouislider.min.js"></script>
  	<script src="../resources/js/jquery.zoom.min.js"></script>
  	<script src="../resources/js/main.js"></script>
   
   <script>
   
   	
   $(document).ready(function() {
		/* alert("ready"); */

	});
	
   
   </script>
</body>
</html>