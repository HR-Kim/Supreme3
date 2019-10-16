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
	
	String url      = request.getContextPath()+"/myitem/get_retrieve.do";
	String scriptName ="search_page";

%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<%@include file ="/template/header.jsp" %>
	<!--/ Header -->
	<div class="container">
	<!-- row -->
	<div class="row">
	<div class="col-md-12">
			<div class="order-summary clearfix">
				<!-- Grid영역 -->
				
				<div class="section-title">
					<h3 class="title">즐겨찾기</h3>
				</div>
				<table class="shopping-cart-table table" id="listTable">
					<thead>
						<tr>
							<th>Product</th>
							<th class="text-center">Image</th>
							<th class="text-center">Price</th>
							<th class="text-center">Select</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list.size()>0}">
							
								<c:forEach var="vo" items="${list}">
								
							<% 	System.out.println("==vo=="+vo); %>
						<tr>
							<td class="text-left"><c:out value="${vo.pName}"/></td>
							<td class="price text-center"><c:out value="${vo.pImage}"/></td>
							<td class="price text-center"><c:out value="${vo.price}"/></td>
							<td class="total text-center">
							<input type="checkbox" id="checkMyitem" name="checkMyitem" value="check"/>
							</td>
							<td class="total text-center">
							<input type="button" id="deleteButton" name="deleteButton" value="del."/>
							</td>
						</tr>
							</c:forEach>
						</c:when>
					</c:choose>
					</tbody>
				</table>
				<div class="pull-right">
				<!-- //grid영역 -->
				<button class="primary-btn">Add Cart</button>
			</div>
		</div>
	</div>
	<!-- FOOTER -->
	<%@include file ="/template/footer.jsp" %>
	<!-- /FOOTER -->

</body>
</html>