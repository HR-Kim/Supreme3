
<%@page import="kr.co.supreme.orderstatus.service.OrderSearch"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import = "java.util.ArrayList" %>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import = "kr.co.supreme.cmn.StringUtil" %>
<%@page import = "kr.co.supreme.cmn.Search" %>
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
		String searchWord = "" ;
		/** 확장자 */
		String ext = "xls" ;	

		String orderStatus = ""; 
		
		OrderSearch vo = (OrderSearch)request.getAttribute("vo");
		
		if(null !=vo){
			pageSize = StringUtil.nvl(vo.getPageSize()+"","10");
			pageNum = StringUtil.nvl(vo.getPageNum()+"","1");
			searchDiv = StringUtil.nvl(vo.getSearchDiv(),"");
			searchWord = StringUtil.nvl(vo.getSearchWord(),"");
			
			
			orderStatus = StringUtil.nvl(vo.getOrderStatus(),"");
			
		}else{
			pageSize = "10";
			pageNum  = "1";
			searchDiv = "";
			searchWord = "";
			orderStatus="";
		}
		
		String extParam = (String)request.getAttribute("ext");
		if(extParam !=null) ext = extParam;
		
		//pageCode	
		List<Code> codeList = (request.getAttribute("codeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeList");
		
		
		//codeOrderList
		List<Code> codeSearchList = (request.getAttribute("codeSearchList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeSearchList");			
	
		int maxNum      = 0;
	    int bottomCount = 10;
	    int currPageNo  = 1; //pageNum
	    int rowPerPage  = 10;//pageSize			
		String url      = request.getContextPath()+"orderStauts/get_admin_retrieve.do";
		String scriptName ="search_page";
		
		String iTotalCnt =(request.getAttribute("totalCnt")==null)?"0":request.getAttribute("totalCnt").toString();
		maxNum = Integer.parseInt(iTotalCnt);
		currPageNo = Integer.parseInt(pageNum);
		rowPerPage = Integer.parseInt(pageSize);	
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->


	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="../resources/css/bootstrap.min.css" />

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="../resources/css/slick.css" />
	<link type="text/css" rel="stylesheet" href="../resources/css/slick-theme.css" />

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet" href="../resources/css/nouislider.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="../resources/css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="../resources/css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<body>
	<!-- Header -->
	<%@include file ="../template/header.jsp" %>
	<!--/ Header -->
	
	<div class="container">
	<!-- 검색영역 -->
		<div class="row" >
			<div class="col-md-12 text-right" type="hidden">
				<form class="form-inline" name="boardFrm" id="boardFrm" method="get">
					<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }"/>
					<input type="hidden" name="boardId" id="boardId" />
					<div class="form-group">
					    <!-- 페이지 사이즈 -->
						<%=StringUtil.makeSelectBox(codeList, "pageSize", pageSize, false) %>
					    <%=StringUtil.makeSelectBox(codeSearchList, "orderStatus", orderStatus, true) %>

					<input type="text" class="form-control input-sm" id="searchWord" value="${vo.searchWord}" name="searchWord" placeholder="검색어" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-default btn-sm"
							id="doRetrieve" >조회</button>
						
					</div>
				</form>
			</div>
		</div>
		<!--// 검색영역 -->
	<!-- row -->
	<div class="row">
	<div class="col-md-12">
			<div class="order-summary clearfix">
				<!-- Grid영역 -->
				
				<div class="section-title">
					<h3 class="title">Orderview</h3>
				</div>
				<table class="shopping-cart-table table" id="listTable">
					<thead>
						<tr>
							<th>Oder Number</th>
							<th class="text-left">ID</th>
							<th class="text-center">Reg Dt</th>
							<th class="text-center">OrderStatus</th>
							<th class="text-center">changeOrderStatus</th>
						</tr>
					</thead>
					<tbody id="tablerow">
						<c:choose>
							<c:when test="${list.size()>0}">
							<c:forEach var="vo" items="${list}">
						<tr>
							<td class="thumb"><c:out value="${vo.detail_code}" /></td>
							<td class="details"> <a href="#"><c:out value="${vo.u_id}" /></a></td>
							<td class="price text-center"><c:out value="${vo.reg_dt}"/></td>
							<td class="price text-center"><c:out value="${vo.od_status}"/></td>
							<td class="total text-center">
							
							<select name="changeOrderStatus" class="changeOrderStatus"id="furuit${i.count}" >
							<option value="0">주문완료</option>
							<option value="1">결제대기</option>
							<option value="2">배송준비</option>
							<option value="3">배송중</option>
							<option value="4">배송완료</option>
							<option value="6">환불완료</option>
							<option value="9">취소</option>
							</select>
							</span>
							</td>
							
						</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				  </tbody>
				</table>
			</div>
		</div>
		<!-- /container -->
		<div class="text-center">
			<%=StringUtil.renderPaing(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %>
		</div>
		<!--// pagenation -->
	</div>
	<!--// div container -->
	
	
	<!-- jQuery Plugins -->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/slick.min.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.zoom.min.js"></script>
	<script src="../resources/js/main.js"></script>
	
	
	<script type="text/javascript">



	$(".changeOrderStatus").on("change", function(){
		//alert("dd")
		var getval = $(this).val();
		//alert("getval"+getva)
		var tr = $(this).parent().parent();
		var td =tr.children();
		var detail_code = td.eq(0).text();
		$.ajax({
			type : "POST",
			url : "${context}/orderStauts/do_update.do",
			dataType : "html",
			data : {
				
				"od_status" : getval,
				"detail_code": detail_code
			},
			success : function(data){
				var update;
				update = confirm("주문상태를 변경합니다");
				if(update){
					document.write("주문상태가 변경되었습니다.")
				}
				location.reload();

			}
		  });
	});
	
	function doRetrieve(){
		var frm = document.boardFrm;
		frm.pageNum.value= 1;
		frm.action = "${context}/orderStauts/get_admin_retrieve.do";
		frm.submit();
	}
	//paging이동
	function search_page(url,pageNum){
		//alert(url+"|"+pageNum);
		var frm = document.boardFrm;
		frm.pageNum.value = pageNum;
		frm.action = url;
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


	</script>
	<!-- FOOTER -->
	<%@include file ="../template/footer.jsp" %>
	<!-- /FOOTER -->

</body>

</html>
