<%@page import="kr.co.supreme.product.service.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import = "kr.co.supreme.code.*" %>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	Product pro = (Product) request.getAttribute("vo"); 


	

%>
<c:set var="context" value ="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>
	<!-- Header -->
   <%@include file ="/admin/admin_header.jsp" %>
   <!--/ Header -->

	<!-- 입력 Form -->
	<div class="container">
	<!-- div title -->
		<div class="page-header">
			<h1>상품 수정</h1>
			<h6><% pro.toString();%></h6>
		</div>
		<!--// div title -->
	
		<div class="col-lg-12"></div>
		<div class="col-lg-12"></div>
		<div class="panel panel-default"></div>
		<!-- 입력 form -->
		<form action="do_save.do" name="frmJoin" id="frmJoin" method="post" class="form-horizontal">
			<input type="hidden"  name="fileId" id="fileId" value="<c:out value='${vo.p_image}'/>">
			<div class="form-group">
				<input type="hidden"  name="p_code" id="p_code" value="<c:out value='${vo.p_code}'/>">
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">대분류 번호</label>
				<div class="col-sm-2">
					<%if(pro.getH_code().equals("10")){ %>
					<select id='h_code' name="h_code" class="form-control input-sm">
						<option value="10" selected="selected">먹거리</option>
						<option value="20">생활용품</option>
						<option value="30">위생용품</option>
						<option value="40">외출용품</option>
					</select>
					<%}else if(pro.getH_code().equals("20")){ %>
					<select id='h_code' name="h_code" class="form-control input-sm">
						<option value="10" >먹거리</option>
						<option value="20" selected="selected">생활용품</option>
						<option value="30">위생용품</option>
						<option value="40">외출용품</option>
					</select>
					<%}else if(pro.getH_code().equals("30")){ %>
					<select id='h_code' name="h_code" class="form-control input-sm">
						<option value="10" >먹거리</option>
						<option value="20">생활용품</option>
						<option value="30"  selected="selected">위생용품</option>
						<option value="40">외출용품</option>
					<%}else if(pro.getH_code().equals("40")){ %>
					<select id='h_code' name="h_code" class="form-control input-sm">
						<option value="10" >먹거리</option>
						<option value="20" >생활용품</option>
						<option value="30" >위생용품</option>
						<option value="40" selected="selected">외출용품</option>
					</select>
					<%}else{ %>
					<select id='h_code' name="h_code" class="form-control input-sm">
						
					</select>
					<%} %>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">소분류 번호</label>
				<div class="col-sm-2">
					<%if(pro.getL_code().equals("11")){ %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11" selected="selected">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("12")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12" selected="selected">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("21")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21" selected="selected">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("22")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22" selected="selected">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("23")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23" selected="selected">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("24")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24" selected="selected">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("25")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25" selected="selected">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("31")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31" selected="selected">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("32")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32" selected="selected">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("33")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33" selected="selected">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("41")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41" selected="selected">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("42")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42" selected="selected">가슴줄</option>
						<option value="43">의류</option>
					</select>
					<%}else if(pro.getL_code().equals("43")){  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
						<option value="11">사료</option>
						<option value="12">간식</option>
						<option value="21">하우스</option>
						<option value="22">캣타워</option>
						<option value="23">낚싯대</option>
						<option value="24">레이저</option>
						<option value="25">스크레쳐</option>
						<option value="31">목욕 용품</option>
						<option value="32">화장실 용품</option>
						<option value="33">미용 용품</option>
						<option value="41">이동장</option>
						<option value="42">가슴줄</option>
						<option value="43" selected="selected">의류</option>
					</select>
					<%}else{  %>
					<select id='l_code' name="l_code" class="form-control input-sm">
					</select>
					<%} %>
				</div>
			</div>
			
			<div class="form-group">
				<label for="p_name" class="col-sm-2 control-label">상품명</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_name" placeholder="상품명을 입력해주세요" name="p_name"
						value="<c:out value='${vo.p_name}'/>">
				</div>
			</div>
			
			<div class="form-group">
				<label for="p_company" class="col-sm-2 control-label">제조회사</label>
				<div class="text-left col-sm-3">
					<input type="text" maxlength="300" with="20%" class="form-control input-sm" id="p_company" placeholder="이메일을 입력해주세요" name="p_company"
						value="<c:out value='${vo.p_company}'/>">
				</div>
			</div>	
			
			<div class="form-group">
				<label for="p_price" class="col-sm-2 control-label">가격</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_price" placeholder="상품가격을 입력해주세요." name="p_price"
						value="<c:out value='${vo.p_price}'/>">
				</div>
			</div>
			
			<div class="form-group">
				<label for="stock" class="col-sm-2 control-label">재고</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="stock" placeholder="상품 재고를 입력해주세요." name="stock"
						value="<c:out value='${vo.stock}'/>">
				</div>
			</div>
			
			<div class="form-group">
				<label for="status" class="col-sm-2 control-label">상태</label>
				<div class="col-sm-2">
					<%if(pro.getStatus().equals("10")){ %>
					<select id="status" class="form-control input-sm">
						<option value="10" selected="selected">판매중</option>
						<option value="20">재입고 예정</option>
						<option value="30">매진</option>
					</select>
					<%}else if(pro.getStatus().equals("20")){ %>
					<select id="status" class="form-control input-sm">
						<option value="10">판매중</option>
						<option value="20" selected="selected">재입고 예정</option>
						<option value="30">매진</option>
					</select>
					<%}else if(pro.getStatus().equals("30")){ %>
					<select id="status" class="form-control input-sm">
						<option value="10">판매중</option>
						<option value="20">재입고 예정</option>
						<option value="30" selected="selected">매진</option>
					</select>
					<%}else{ %>
					<select id="status" class="form-control input-sm">
					</select>
					<%} %>
				</div>
			</div>
			
			<div class="form-group">
				<label for="p_new" class="col-sm-2 control-label">신상품</label>
				<div class="col-sm-2">
					<%if(pro.getP_new().equals("N")){ %>
					<select id="p_new" class="form-control input-sm">
						<option value="N" selected="selected">해제</option>
						<option value="Y">설정</option>
					</select>
					<%}else if(pro.getP_new().equals("Y")){ %>
					<select id="p_new" class="form-control input-sm">
						<option value="N">해제</option>
						<option value="Y" selected="selected">설정</option>
					</select>
					<%}else{ %>
					<select id="p_new" class="form-control input-sm">
					</select>
					<%} %>
				</div>
			</div>
			
			<div class="form-group">
				<label for="p_best" class="col-sm-2 control-label">베스트 상품</label>
				<div class="col-sm-2">
					<%if(pro.getP_best().equals("N")){ %>
					<select id="p_best" class="form-control input-sm">
						<option value="N" selected="selected">해제</option>
						<option value="Y">설정</option>
					</select>
					<%}else if(pro.getP_best().equals("Y")){ %>
					<select id="p_best" class="form-control input-sm">
						<option value="N">해제</option>
						<option value="Y" selected="selected">설정</option>
					</select>
					<%}else{ %>
					<select id="p_best" class="form-control input-sm">
					</select>
					<%} %>
				</div>
			</div>
			
			<div class="form-group">
				<label for="p_sale" class="col-sm-2 control-label">할인 상품</label>
				<div class="col-sm-2">
					<%if(pro.getP_sale().equals("N")){ %>
					<select id="p_sale" class="form-control input-sm">
						<option value="N" selected="selected">해제</option>
						<option value="Y">설정</option>
					</select>
					<%}else if(pro.getP_sale().equals("Y")){ %>
					<select id="p_sale" class="form-control input-sm">
						<option value="N">해제</option>
						<option value="Y" selected="selected">설정</option>
					</select>
					<%}else{ %>
					<select id="p_sale" class="form-control input-sm">
					</select>
					<%} %>
				</div>
			</div>
			
			<div class="form-group">
				<label for="p_content" class="col-sm-2 control-label">상품 설명</label>
				<div class="col-sm-8">
					<textarea rows="4" class="form-control input-sm" id="p_content" placeholder="상세 설명을 입력해 주세요." name="p_content"
						><c:out value='${vo.p_content}'/></textarea>
				</div>
			</div>
			
			<div class="form-group">
				<label for="sale_percent" class="col-sm-2 control-label">할인율</label>
				<div class="col-sm-2">
					<%if(pro.getSale_percent().equals("100")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100" selected="selected">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("90")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90" selected="selected">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("85")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85" selected="selected">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("80")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80" selected="selected">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("75")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75" selected="selected">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("70")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70" selected="selected">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("65")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65" selected="selected">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("60")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60" selected="selected">40% 할인</option>
						<option value="50">50% 할인</option>
					</select>
					<%}else if(pro.getSale_percent().equals("50")){ %>
					<select id="sale_percent" class="form-control input-sm">
						<option value="100">0% 할인</option>
						<option value="90">10% 할인</option>
						<option value="85">15% 할인</option>
						<option value="80">20% 할인</option>
						<option value="75">25% 할인</option>
						<option value="70">30% 할인</option>
						<option value="65">35% 할인</option>
						<option value="60">40% 할인</option>
						<option value="50" selected="selected">50% 할인</option>
					</select>
					<%}else{ %>
					<select id="sale_percent" class="form-control input-sm">
					</select>
					<%} %>
				</div>
			</div>
			<!-- 첨부 -->
			<div class="form-group">
				<label for="attrFile" class="hidden-xs hidden-sm col-md-2 col-lg-2 control-label">이미지</label>
				<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<button id="attrFile" type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#layerpop">파일 첨부하기</button>
				</div>
			</div>
							
			<!-- 첨부그리드 -->
			<div class="form-group">
				<label for="listFileTable" class="hidden-xs hidden-sm col-md-2 col-lg-2 control-label"></label>
				<div class="table-responsive col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<table class="table  table-striped table-bordered table-hover" id="listFileTable">
						<tbody></tbody>
					</table>
				</div>
			</div>
			
					
		</form>
	
		
		<!-- Button Area -->
		<div class="row">
			<div class="col-lg-10 col-sm-10 col-xs-10">
				<div class="text-right">
					<button type="button" class="btn btn-default btn-sm" id="doRetrieve">목록으로 돌아가기</button>
					<button type="button" class="btn btn-default btn-sm" id="doUpdate">수정하기</button>
					<button type="button" class="btn btn-default btn-sm" id="doDelete">삭제하기</button>
				</div>
			</div>
		</div>
		
		
		
		
		
		<!-- Modal -->
		<div class="modal fade" id="layerpop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">File Upload</h4>
		      </div>
		      <div class="modal-body">
		        <form class="form-horizontal" action="${context }/file/do_save.do" 
		           name="saveFileForm" id="saveFileForm" method="post" enctype="multipart/form-data">
		            <input type="hidden"  name="work_dir"   id="work_dir" value="com">
		            <input type="hidden"  name="attrFileId" id="attrFileId" >
		            <input type="hidden"  name="orgFileNm"  id="orgFileNm" >
		            <input type="hidden"  name="saveFileNm" id="saveFileNm" >
		           
		        	<!-- 첨부파일 -->
		        	<div class="custom-file">
		        		<input type="file" class="custom-file-input" id="file01" name="file01">
		        	</div>
		        </form>
		      </div>
		      <div class="modal-footer">
		      
		        <button type="button" class="btn btn-default" data-dismiss="modal" id="doFileUpload">저장</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		      </div>
		    </div>
		  </div>
		 </div>
		 
	</div>	
	<!-- container  -->	
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
   
   	
	 	//이미지 미리보기 소스
		$(document).ready(function() {
			
			$("#file01").on("change",handleImgFileSelect);
			
			
			if("${vo.p_image}" !=""){
				getFileList('${vo.p_image}');
			}
			
		});
   
	 	
	 	
		//목록이동
		$("#doRetrieve").on("click",function(){
			//alert("doRetrieve");
			//board_attr/get_retrieve.do
			if(confirm("목록으로 돌아가시겠습니까?")== false)return;
			location.href ="${context}/product/get_admin_retrieve.do";
		});  
	 	
	 	
		//삭제
		$("#doDelete").on("click",function(){
			
			if(confirm("제품을 삭제하시겠습니까?") == false)return;
			
						
				$.ajax({
		            type:"POST",
		            url:"${context}/product/do_delete.do",
		            dataType:"html",// JSON
		            data:{
		            	"p_code": $("#p_code").val()	            	
		            },
		            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
		                //console.log(data);
		            	//{"msgId":"1","msgMsg":"삭제 되었습니다.","totalCnt":0,"num":0}
		            	var parseData = $.parseJSON(data);
		            	if(parseData.msgId=="1"){
		            		alert(parseData.msgMsg);
		            		location.href = "${context}/product/get_admin_retrieve.do";
		            		
		            	}else{
		            		alert(parseData.msgMsg);
		            	}
		            		
		            	
		            	
		
		            	
		            },
		            complete: function(data){//무조건 수행
		             
		            },
		            error: function(xhr,status,error){
		             
		            }
		        });	 
			
		});
		
		
   
   
	 	//수정
		$("#doUpdate").on("click",function(){
		   	console.log("doUpdate");
		   	checkValue();
		   		    	
		});
	 
	   function checkValue(){

		   
		   if(!$("#p_name").val()){
				alert("상품명을 입력해주세요.");
				document.getElementById("p_name").focus();
				return false;
			}
		   if(!$("#p_company").val()){
				alert("제조 회사를 입력해주세요..");
				document.getElementById("p_company").focus();
				return false;
			}
		   if(!$("#p_price").val()){
				alert("상품 가격을 입력해주세요..");
				document.getElementById("p_price").focus();
				return false;
			}
		   if(isNaN($("#p_price").val())){
				alert("상품 가격에는 숫자만 입력해 주세요.");
				document.getElementById("p_price").focus();
				return false;
			}
		   if(isNaN($("#stock").val())){
				alert("재고를 입력해주세요.");
				document.getElementById("stock").focus();
				return false;
			}
		   if(isNaN($("#stock").val())){
				alert("재고에는 숫자만 입력해 주세요.");
				document.getElementById("stock").focus();
				return false;
			}
		   if(!$("#p_content").val()){
				alert("상품에 대한 설명을 입력해주세요..");
				document.getElementById("p_content").focus();
				return false;
			}
		  
		   var d = new Date();
		   
		   
		   
		   console.log($("#p_code").val());
		   console.log($("#h_code option:selected").val());
		   console.log($("#l_code option:selected").val());
		   console.log($("#p_name").val());
		   console.log($("#p_company").val());
		   console.log($("#p_price").val());
		   console.log($("#fileId").val());
		   console.log($("#stock").val());
		   console.log("0");
		   console.log($("#status option:selected").val());
		   console.log($("#p_new option:selected").val());
		   console.log($("#p_best option:selected").val());
		   console.log($("#p_sale option:selected").val());
		   console.log( $("#p_content").val());
		   console.log($("#sale_percent option:selected").val());
		   
		   
		   $.ajax({
	            type:"POST",
	            url:"${context}/product/do_update.do",
	            dataType:"html",// JSON
	            data:{
	            	"p_code": $("#p_code").val(),
	            	"h_code":$("#h_code option:selected").val(),
	            	"l_code":$("#l_code option:selected").val(),
	            	"p_name": $("#p_name").val(),
	            	"p_company": $("#p_company").val(),
	            	"p_price": $("#p_price").val(),
	            	"p_image": $("#fileId").val(),
	            	"stock": $("#stock").val(),
	            	"unit_sales": "0",
	            	"status":$("#status option:selected").val(),
	            	"p_new": $("#p_new option:selected").val(),
	            	"p_best": $("#p_best option:selected").val(),
	            	"p_sale": $("#p_sale option:selected").val(),
	            	"p_content": $("#p_content").val(),
	            	"sale_percent": $("#sale_percent option:selected").val()	            		            	
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
	                //console.log(data);
	            	
	            	var parseData = $.parseJSON(data);
	            	if(parseData.msgId=="1"){
	            		alert(parseData.msgMsg);
	            		console.log("수정 완료!");
	            		location.href = "${context}/product/get_admin_retrieve.do";
	            	}else{
	            		alert(parseData.msgMsg);
	            	}
	            	

	            	
	            },
	            complete: function(data){//무조건 수행
	             
	            },
	            error: function(xhr,status,error){
	             
	           }
	        });	 // ajax 
		   
	   };	//checkValue
	   
	   
	 //이미지 함수
		function handleImgFileSelect(e){
			var files = e.target.files;
			var filesArr = Array.prototype.slice.call(files);
			
			filesArr.forEach(function(f){
				if(!f.type.match("image.*")){
					alert("이미지 파일만 업로드할 수 있습니다.");
					return false;
				}
				
				sel_file = f;
				
				var reader = new FileReader();
				reader.onload = function(e){
					$("#img").attr("src", e.target.result);
				}
				
				reader.readAsDataURL(f);
				
			});
		}
	   
	   
	   
	 //파일삭제:db delete,file삭제
		$("#listFileTable>tbody").on("click",".btn-danger",function(e){
			//alert(".btn-danger");
			//button > td parent -> tr
			var tr    = $(this).parent().parent();
			var tds   = tr.children();	

			var fileId = tds.eq(0).text();
			var num    = tds.eq(1).text();
			var orgFileNm = tds.eq(2).text();
			var saveFileNm = tds.eq(3).text();
			console.log("fileId:"+fileId);
			console.log("num:"+num);
			console.log("orgFileNm:"+orgFileNm);
			console.log("saveFileNm:"+saveFileNm);
			//ajax
			$.ajax({
				   type:"POST",
				   url:"${context}/file/do_delete.do",
				   dataType:"html",
				   data:{
				   "fileId":fileId,
				   "num":num,
				   "orgFileNm":orgFileNm,
				   "saveFileNm":saveFileNm
				  }, 
				success: function(data){
				  var jData = JSON.parse(data);
				  if(null != jData && jData.msgId=="1"){
					alert(jData.msgMsg);
					//화면삭제:
					tr.remove();
				  }else{
					alert(jData.msgId+"|"+jData.msgMsg);
				  }
				},
				complete:function(data){
				 
				},
				error:function(xhr,status,error){
					alert("error:"+error);
				}
			}); 
			//--ajax  


			
			//alert("orgFileNm:"+orgFileNm+"|"+saveFileNm);
			console.log("orgFileNm:"+orgFileNm);
			console.log("saveFileNm:"+saveFileNm);
		});

	
		//파일다운로드 
		$("#listFileTable>tbody").on("click",".org-file-name",function(e){
			//alert(".org-file-name");
			//@RequestMapping(value="file/download.do",method = RequestMethod.POST)
			//String orgFileNm  = req.getParameter("orgFileNm");// 원본파일명
		    //String saveFileNm = req.getParameter("saveFileNm");// 저장파일명 

			//td parent -> tr
			var tr    = $(this).parent();
			var tds   = tr.children();	

			var fileId = tds.eq(0).text();
			var num    = tds.eq(1).text();
			var orgFileNm = tds.eq(2).text();
			var saveFileNm = tds.eq(3).text();
			
			//alert("orgFileNm:"+orgFileNm+"|"+saveFileNm);
			console.log("orgFileNm:"+orgFileNm);
			console.log("saveFileNm:"+saveFileNm);
			
			var frm = document.saveFileForm;
			frm.action = "${context}/file/download.do";
			frm.orgFileNm.value = orgFileNm;
			frm.saveFileNm.value= saveFileNm;
			frm.submit();
			
		});
	
		//파일목록 조회:
		function getFileList(fileId){
			//ajax
			
			$.ajax({
				   type:"POST",
				   url:"${context}/file/do_retrieve.do",
				   dataType:"html",
				   data:{
				   "fileId":fileId
				  }, 
				success: function(data){
				    //alert(data);	
				    var jData = JSON.parse(data);
				  
				    if(null != jData){
						//기존 : listFileTable 삭제.
						$("#listFileTable tbody tr").remove();
						  
						//전체 Data를 동적으로 생성.
						$.each(jData,function(index,item){
							$("#listFileTable tbody:last").append("<tr>"+
									"<td class='text-center hidden-xs hidden-sm hidden-md hidden-lg'>"+<c:out value='item.fileId'/>+"</td>"+  
									"<td class='text-center hidden-xs hidden-sm hidden-md hidden-lg'>"+<c:out value='item.num'/>+"</td>"+  
									"<td class='text-left org-file-name'>"+<c:out value='item.orgFileNm'/>+"</td>"+ 
									"<td class='text-center hidden-xs hidden-sm hidden-md hidden-lg'>"+<c:out value='item.saveFileNm'/>+"</td>"+ 
									"<td class='text-right'>"+<c:out value='item.fSize'/>+" &nbsp; byte</td>"+
									"<td class='text-right'><button type='button' class='btn btn-default btn-xs btn-danger' >X</button></td>"+
									"</tr>");
							
						});//$.each
				  }else{
					alert(jData);
				  }
				},
				complete:function(data){
				 
				},
				error:function(xhr,status,error){
					alert("error:"+error);
				}
			}); 
			//--ajax 
		}
	
	
	    //파일업로드 
		$("#doFileUpload").on("click",function(e){
			//console.log("doFileUpload>>");
			if(confirm("등록 하시겠습니까?")== false)return;
			e.preventDefault();
			
			doUploadFile();
			
		});
		
		function doUploadFile(){
			var form = $('form')[1];
			var formData = new FormData(form);
			
			//ajax
			$.ajax({
				   type:"POST",
				   url:"${context }/file/do_save.do",
				   contentType:false,
				   async:false,
				   cache:false,
				   processData:false,
				   enctype:"multipart/form-data",
				   data:formData,
				success: function(data){
				  console.log("data.msgId:"+data.msgId)
				  console.log("data:"+data.msgMsg)
				  
				  $("#attrFileId").val(data.msgMsg);
				  $("#fileId").val(data.msgMsg);
				  
				  //
				  document.getElementById('file01').value="";
				  
				  //var jData = JSON.parse(data);
				  if(null != data && data.msgId=="1"){
					//alert(data.msgMsg);
					
					//fileId file_mng조회
					getFileList($("#fileId").val());
				  }else{
					alert(data.msgId+"|"+data.msgMsg);
				  }
				},
				complete:function(data){
				 
				},
				error:function(xhr,status,error){
					alert("error:"+error);
				}
			}); 
			//--ajax 			
		}
	
   
   </script>
</body>
</html>