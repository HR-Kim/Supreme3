<%@page import="kr.co.supreme.orderstatus.service.OrderSearch"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "kr.co.supreme.code.*" %>
<%@page import = "kr.co.supreme.cmn.StringUtil" %>
<%@page import = "kr.co.supreme.cmn.Search" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		String url      = request.getContextPath()+"orderStauts/get_retrieve.do";
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
							<th>Product</th>
							<th class="text-left">Order number</th>
							<th class="text-left">Product name</th>
							<th class="text-left">Status</th>
							<th class="text-center">Price</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total</th>
							<th class="text-center">Select</th>
						</tr>
					</thead>
					<tbody id="tablerow">
					
						<c:choose>
							<c:when test="${currentlist.size()>0}" >
								<c:forEach var="cvo" items="${currentlist}">
								<c:if test="${cvo.u_id==$(user.id)}">
							<input type="hidden" name="od_status" id="od_status" value="${cvo.od_status}"/>	
						<tr>
							<td class="thumb"><img value="${cvo.p_image}" alt=""></td>
							<td class="price text-left"><c:out value="${cvo.detail_code}"/></td>
							<td class="details">
								<a href="#" name="name" id="name"><c:out value="${cvo.p_name}" /></a>
							</td>							
							<td><c:out value="${cvo.od_status}"/></td>
							<td class="price text-center"><strong><c:out value="${cvo.unit_price}"/></strong><br><del class="font-weak"><small><c:out value="${cvo.p_price}"/></small></del></td>
							<td class="price text-center"><c:out value="${cvo.quantitiy}"/></td>
							<td class="total text-center"><strong class="primary-color"><c:out value="${cvo.quantitiy * cvo.unit_price}"/></strong></td>
							<td class="total text-center">
							<button class="icon-btn.main-btn" name="cancle" id="cancle">주문취소</button>
							</td>
						</tr>
							</c:if>
							</c:forEach>
						
						</c:when>
					</c:choose>
					</tbody>
				</table>
			
		</div>
	</div>
	
	<div class="col-md-12">
			<div class="order-summary clearfix">
				<div class="section-title">
					<h3 class="title">Previous Order</h3>
				</div>
				<form name="frmData" id="frmData" method="post">				
				<table class="shopping-cart-table table" id=prelist >
					<thead>
						<tr>
							<th>Product</th>
							<th class="text-left">Product name</th>
							<th class="text-left">Status</th>
							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
							
						</tr>
					</thead>
					
					<tbody>
						<c:choose>
							<c:when test="${prelist.size()>0}">
								<c:forEach var="pvo" items="${prelist}">
								<c:if test="${cvo.u_id==$(user.id)}">
								<input type="hidden" name="detailCode" id="detailCode" value="${pvo.detail_code}"/>							
								<input type="hidden" name="name" id="name" value="${pvo.p_name}"/>							
								<input type="hidden" name="status" id="status" value="${pvo.od_status}"/>							
								<input type="hidden" name="unit_price" id="unit_price" value="${pvo.unit_price}"/>							
								<input type="hidden" name="quantitiy" id="quantitiy" value="${pvo.quantitiy}"/>							
								<input type="hidden" name="p_price" id="p_price" value="${pvo.p_price}"/>							
						<tr>
							<input type="hidden" name="cdetailCode" id="cdetailCode" value="${pvo.detail_code}"/>	
							<td class="thumb" id="image" name="image"><img value="${pvo.p_image}" alt=""></td>
							
							<td class="details">
								<a href="#" name="name" id="name"><c:out value="${pvo.p_name}" /></a>
							</td>							
							<td class ="pod_status" id="pod_status"><c:out value="${pvo.od_status}"/></td>
							<td class="price text-center" style="display:none;" id="detail_code" name="detail_code"><c:out value="${pvo.detail_code}"/></td>
							<td class="price text-center" id="unit_price" name="unit_price"><strong>$<c:out value="${pvo.unit_price}"/></strong></td>
							<td class="total text-center" id="quantitiy" name="quantitiy"><strong class="primary-color"><c:out value="${pvo.quantitiy * pvo.unit_price}"/></strong></td>
							<td class="total text-center">
							<button class="icon-btn.main-btn" name="refund" id="refund"  onclick="javascript:openRefundPopup(this.form);">환불</button>
							<button class="icon-btn.main-btn" name="change" id="change"  onclick="javascript:openChangePopup(this.form);">교환</button>
							</td>
						</tr>
							</c:if>
							</c:forEach>
						</c:when>
					
					</c:choose>
			
					</tbody>
	
				</table>
			</form>
			<!-- /row -->
			</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->
	<!--// div container -->
	
	
	<!-- jQuery Plugins -->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/slick.min.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.zoom.min.js"></script>
	<script src="../resources/js/main.js"></script>
	
	<script type="text/javascript">
	
	/**주문 취소 */

	$(document).on('click', '#cancle', function(){	
		
		var str =""
		var cancle = $(this);
		
		//cancle.parent() : check의 부모는 <td>
		//cancle. parent().parent() : <td>의 부모이므로 <tr>
		
		var tr = cancle.parent().parent();
		var td =tr.children();
		
		console.log("클릭한 row의 모든 데이터 "+tr.text());
		
		var detail_code = td.eq(1).text();
		console.log("detail_code "+detail_code);
		
		var od_statust =  td.eq(3).text();
		
		console.log("od_status "+od_status);
		
		if(od_statust=="배송중"){
			alert("배송중인 상품은 취소할 수 없습니다.")
		}else{
	 
		$.ajax({
			type : "POST",
			url : "${context}/orderStauts/do_update.do",
			dataType : "html",
			data : {
				
				"od_status" : "9",
				"detail_code": detail_code
			},
			success : function(data){
				var update;
				update = confirm("주문을 취소합니다");
				if(update){
					document.write("주문이 취소되었습니다.")
				}
				location.reload();

			}
			
		  }); 
		}
	});	
	
	/**주문 취소상태의 경우 버튼 나오지 않게*/
	$(document).ready(function(){	
	var cancel_s = $("#pod_status").html();
	console.log("cancel_s: "+cancel_s)
		
	if(cancel_s=="취소"){
		$("#refund").css("display", "none");
		$("#change").css("display", "none");
	}
	});
		
	
	/**교환 버튼*/
	function setChildValue2(detail_code){
	     document.getElementById("detail_code").value = detail_code;
	     
	 }
	 
	 function openChangePopup(frm){
	
	 console.log("detail_code"+detail_code)
	 var url    ="../orderStatus/change_popup.jsp";
	 var title  = "testpop";
	 var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=600, height=400, top=0,left=20"; 
	 window.open("../orderStatus/change_popup.jsp",title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
	                                              //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
	                                              //가능합니다.
	    frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
	    frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
	    frm.method = "post";
	    frm.submit();     
	    
	    
	   }
  
	/**환불버튼*/
	function setChildValue(detail_code){
	     document.getElementById("detail_code").value = detail_code;
	     
	 }
	 
	 function openRefundPopup(frm){
	
	 console.log("detail_code"+detail_code)
	 var url    ="../orderStatus/refund_popup.jsp";
	 var title  = "testpop";
	 var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=600, height=400, top=0,left=20"; 
	 window.open("../orderStatus/refund_popup.jsp",title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
	                                              //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
	                                              //가능합니다.
	    frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
	    frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
	    frm.method = "post";
	    frm.submit();     
	    
	    
	   }
	 function doRetrieve(){
			var frm = document.boardFrm;
			frm.pageNum.value= 1;
			frm.action = "${context}/orderStauts/get_retrieve.do";
			frm.submit();
		}
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