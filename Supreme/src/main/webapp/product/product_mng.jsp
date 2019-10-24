<%@page import="kr.co.supreme.product.service.ProductSearch"%>
<%@page import="kr.co.supreme.user.service.UserSearch"%>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	/** 페이지 사이즈 */
	String pageSize   = "10"  ; 	
	/** 페이지 번호 */
	String pageNum    = "1"  ;	
	/** 검색조건 */
	String searchDiv  = "" ;
	/** 검색어 */
	String searchWord = "" ;
		
	String hCodeCat = "";
	
	String lCodeCat = ""; 
	
	String pStatus = "";
	
	ProductSearch vo = (ProductSearch)request.getAttribute("vo");
	
	
	
	
	if(null !=vo){
		pageSize = StringUtil.nvl(vo.getPageSize()+"","10");
		pageNum = StringUtil.nvl(vo.getPageNum()+"","1");
		searchDiv = StringUtil.nvl(vo.getSearchDiv(),"");
		searchWord = StringUtil.nvl(vo.getSearchWord(),"");
		hCodeCat = StringUtil.nvl(vo.gethCodeCat(),"");
		lCodeCat = StringUtil.nvl(vo.getlCodeCat(),"");
		pStatus = StringUtil.nvl(vo.getpStatus(),"");
		
	}else{
		pageSize = "10";
		pageNum  = "1";
		searchDiv = "";
		searchWord = "";
		hCodeCat="";
		lCodeCat="";
		pStatus="";
	}
	
	

	//pageCode	
	List<Code> codeList = (request.getAttribute("codeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeList");
			
	//userSearch	
	List<Code> codeSearchList = 
	(request.getAttribute("codeSearchList")==null)?
			(List<Code>)new ArrayList<Code>():
				(List<Code>)request.getAttribute("codeSearchList");		
	
	//hCode
	List<Code> codeHCodeList = (request.getAttribute("codeHCodeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeHCodeList");
	
	//lCode
	List<Code> codeLCodeList = (request.getAttribute("codeLCodeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeLCodeList");
	
	//statusCode
	List<Code> codeStatusList = (request.getAttribute("codeStatusList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeStatusList");
		
	
	int maxNum      = 0;
    int bottomCount = 10;
    int currPageNo  = 1; //pageNum
    int rowPerPage  = 10;//pageSize
    String url      = request.getContextPath()+"/product/get_admin_retrieve.do";
    String scriptName = "search_page";
    
	String iTotalCnt =(request.getAttribute("totalCnt")==null)?"0":request.getAttribute("totalCnt").toString();
    
	maxNum = Integer.parseInt(iTotalCnt);
	currPageNo = Integer.parseInt(pageNum);
	rowPerPage = Integer.parseInt(pageSize);
	
%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>사용자관리</title>

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
   <%@include file ="/admin/admin_header.jsp" %>
   <!--/ Header -->
	<!-- div container -->
	<div class="container">
		<!-- div title -->
		<div class="page-header">
			<h1>사용자 관리</h1>
			
		</div>
		<!--// div title -->
		
		<!-- 검색영역 -->
		<div class="row">
			<div class="col-md-12 text-right">
				<form class="form-inline" name="frm" id="frm" method="get">
					<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }">
					<input type="hidden" name="p_code" id="p_code" />
					<div class="form-group">
					    <%=StringUtil.makeSelectBox(codeList, "pageSize", pageSize, false) %>
					    <%=StringUtil.makeSelectBox(codeHCodeList, "hCodeCat", hCodeCat, true) %>
					    <%=StringUtil.makeSelectBox(codeLCodeList, "lCodeCat", lCodeCat, true) %>
					    <%=StringUtil.makeSelectBox(codeStatusList, "pStatus", pStatus, true) %>
					    <%=StringUtil.makeSelectBox(codeSearchList, "searchDiv", searchDiv, true) %>
						<input type="text" class="form-control input-sm" id="searchWord" value="${vo.searchWord}" name="searchWord" placeholder="검색어" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-default btn-sm"
							id="doRetrieve" >조회</button>
						
					</div>	
				</form>
			</div>
		</div>
		<!-- //검색영역 -->
		
		<!-- Grid영역 -->
		<div class="table-responsive">
			<table class="table  table-striped table-bordered table-hover" id="listTable">
				<thead class="bg-primary">
					<th class="text-center col-md-1 col-xs-1">번호</th>
					<th class="text-center col-md-2 col-xs-2">상품코드</th>
					<th class="hidden">대분류코드</th>
					<th class="hidden">소분류코드</th>
					<th class="text-center col-md-2 col-xs-2">상품이름</th>
					<th class="text-center col-md-1 col-xs-1">상품가격</th>
					<th class="text-center col-md-1 col-xs-1">재고</th>
					<th class="text-center col-md-1 col-xs-1">상태</th>
					<th class="text-center col-md-1 col-xs-1">신상품</th>
					<th class="text-center col-md-1 col-xs-1">베스트</th>
					<th class="text-center col-md-1 col-xs-1">세일</th>
					<th class="text-center col-md-1 col-xs-1">등록일</th>
				</thead>
				
				<tbody>
					<c:choose>
						<c:when test="${list.size()>0 }">
							<c:forEach  var="product"  items="${list}">
								<tr>
									<td class="text-center"><c:out value="${product.num}"/></td>
									<td class="text-center"><c:out value="${product.p_code}"/></td>
									<td class="hidden"><c:out value="${product.h_code}"/></td>
									<td class="hidden"><c:out value="${product.l_code}"/></td>
									<td class="text-center"><c:out value="${product.p_name}"/></td>
									<td class="text-center"><c:out value="${product.p_price}"/></td>
									<td class="text-center"><c:out value="${product.stock}"/></td>
									<td class="text-center"><c:out value="${product.status}"/></td>
									<td class="text-center"><c:out value="${product.p_new}"/></td>
									<td class="text-center"><c:out value="${product.p_best}"/></td>
									<td class="text-center"><c:out value="${product.p_sale}"/></td>
									<td class="text-center"><c:out value="${product.reg_dt}"/></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="99">정보가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- //Grid영역 -->
		<!-- pagenation -->
		<div class="text-center">
			<%=StringUtil.renderPaing(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %>
		</div>
		<!--// pagenation -->
		
		<!-- Button Area -->
		<div class="row">
			<div class="col-lg-12 col-sm-12 col-xs-12">
				<div class="text-right">
					<button type="button" class="btn btn-default btn-sm" id="doSave">제품등록</button>
				</div>
			</div>
		</div>
		
	</div>
	<!--// div container -->
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${context}/resources/js/jquery-1.12.4.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
		
		$("#listTable>tbody").on("click","tr",function(){
			//alert("listTable>tbody");
			var trs = $(this);
			var tds = trs.children();
			if(null == tds || tds.length ==1 )return;
			//console.log("tds.length:"+tds.length);
			
			var pcodeFind = tds.eq(1).text();
			console.log("pcodeFind:"+pcodeFind);
			
			var frm = document.frm;
			frm.p_code.value = pcodeFind;
			frm.action = "${context}/product/get_selectOne.do";
			frm.submit();				
			  
		});
	
	
		//paging이동
		function search_page(url,pageNum){
			//alert(url+"|"+pageNum);
			var frm = document.frm;
			frm.pageNum.value = pageNum;
			frm.action = url;
			frm.submit();
		}
	
		
		
		function doRetrieve(){
			var frm = document.frm;
			frm.pageNum.value= 1;
			frm.action = "${context}/product/get_admin_retrieve.do";
			frm.submit();
		}
	
		//Enter 쳤을 때 조회되도록
		$("#searchWord").keydown(function(key) {
			if (key.keyCode == 13) {
				doRetrieve();
			}
			
		});
		
		//조회
		$("#doRetrieve").on("click",function(){
			console.log("doRetrieve");
			doRetrieve();
		}); 
	
		
		//등록 화면으로 이동
		$("#doSave").on("click",function(){
			console.log("doSave");
			location.href = "${context}/product/product_insert.jsp"
		}); 
		
		
		$(document).ready(function() {
			//alert("ready");
		});
	</script>
</body>
   <!-- FOOTER -->
   <%@include file ="/template/footer.jsp" %>
   <!-- /FOOTER -->	
</html>