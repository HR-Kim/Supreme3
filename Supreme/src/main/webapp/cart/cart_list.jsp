<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import = "kr.co.supreme.code.*" %>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="context" value ="${pageContext.request.contextPath }"/>

<%
	String id="admin";
	
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
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<%@include file ="/template/header.jsp" %>
	<!--/ Header -->
	<div class="container">
	<!-- row -->
	<div class="row">

			<div class="order-summary clearfix">
				<!-- Grid영역 -->
				
				
					<div class="col-md-12">
						<div class="order-summary clearfix">
							<div class="section-title">
								<h3 class="title">장바구니</h3>
							</div>
							<table class="shopping-cart-table table">
								<thead>
									<tr>
									<th> </th>
										<th>상품명</th>			
										<th class="text-center">가격</th>
										<th class="text-center">수량</th>
										<th class="text-center">총가격</th>
										<th class="text-right"></th>
									</tr>
								</thead>
								<tbody>
								
					<c:choose>
						<c:when test="${list.size()>0 }">
						<c:set var = "sum" value = "0" />
							<c:forEach  var="list"  items="${list}">
								<tr>
									<td class="text-center"><input type="checkbox" name="check"></td>
									<td class="text-center"><c:out value="${list.pName}"/></td>
									<td class="text-center"><c:out value="${list.unitPrice}"/></td>
									<td class="text-center"><c:out value="${list.quantity}"/></td>
									<td class="text-center"><c:out value="${list.unitPrice*list.quantity}"/></td>
									<td class="text-center"><a class="remove" href="#" onclick="go_cart_ajax_delete(${list.cartCode})"><fa class="fa fa-close"></fa></a></td> 
									<c:set var = "sum" value = "${sum + list.unitPrice * list.quantity}" />
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="99">장바구니에 물건이 없습니다.</td>
							</tr>
						</c:otherwise>
					
					
					</c:choose>
								</tbody>
								
								<tfoot>
					<c:choose>
						<c:when test="${list.size()>0 }">
								<tr>
										<th class="empty" colspan="3"></th>
										<th>상품가격</th>
										<th colspan="2" class="sub-total"><fmt:formatNumber pattern="###,###,###" value="${sum}"/></th>
								</tr>
								<tr>
										<th class="empty" colspan="3"></th>
										<th>배송비</th>
										<td colspan="2">무료</td> 
								</tr>
								<tr>
										<th class="empty" colspan="3"></th>
										<th>주문가격</th>
										<th colspan="2" class="total"><fmt:formatNumber pattern="###,###,###" value="${sum}"/></th>
								</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="99"></td>
							</tr>
						</c:otherwise>
					</c:choose>
									
								</tfoot>
							</table>
							<c:if test="${list.size()>0 }">
							<div class="pull-right">
								<button class="primary-btn" id="buy">구매하기</button>
							</div>
							</c:if>
						</div>

					</div>
				<div class="pull-right">
			
			</div>
		</div>
	</div>
	</div>
	<!-- FOOTER -->
	<%@include file ="/template/footer.jsp" %>
	<!-- /FOOTER -->

<script>

$("#buy").on("click",function(){
	console.log("doSave");

	location.href = "${context}/order/get2.do"
	

});


	
	
function go_cart_delete(cseq){
    
    if(confirm("정말 삭제하시겠습니까?")){
        location.href="${context}/order/do_delete.do?cseq="+cseq;      
    }
     
}


function go_cart_ajax_delete(cseq){
	if(confirm("정말 삭제하시겠습니까?")){
		console.log(cseq);
	$.ajax({
        type:"POST",
        url:"${context}/cart/do_delete.do",
        dataType:"html",// JSON
        data:{
        	"cartCode" : cseq,
        	"id" : "admin"
        },
        success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
            //console.log(data);
        	//{"msgId":"1","msgMsg":"삭제 되었습니다.","totalCnt":0,"num":0}
        	var parseData = $.parseJSON(data);
        	if(parseData.msgId=="1"){
        		alert(parseData.msgMsg);
        		console.log("삭제완료!");
        		location.href = "${context}/cart/get_retrieve.do?idd=admin";
        		
        		
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
</script>

</body>
</html>