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
<title>product insert</title>
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
		<!--// div title -->
	
		<div class="col-lg-12"></div>
		<div class="col-lg-12"></div>
		<div class="panel panel-default"></div>
		<!-- 입력 form -->
		<form action="do_save.do" name="frmJoin" id="frmJoin" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="p_code" class="col-sm-2 control-label">상품코드</label>
				<div class="col-sm-6">
					<input type="text" maxlength="100"  class="form-control input-sm" id="p_code" placeholder="상품코드를 입력해 주세요." name="p_code">
				</div>
				
				<input type="hidden" id="idDuplication" value="id_UnCheck">
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">대분류 번호</label>
			<select id='h_code' name="h_code">
				<option value="10">먹거리</option>
				<option value="20">생활용품</option>
				<option value="30">위생용품</option>
				<option value="40">외출용품</option>
			</select>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">소분류 번호</label>
			<select id='l_code' name="l_code">
				<option value="11">사료</option>
				<option value="12">간식</option>
				<option value="21">하우스</option>
				<option value="22">캣타워</option>
				<option value="23">낚싯대</option>
				<option value="24">레이저</option>
				<option value="25">스크레쳐</option>
				<option value="31">목용 용품</option>
				<option value="32">화장실 용품</option>
				<option value="33">미용 용품</option>
			</select>
			</div>
			<div class="form-group">
				<label for="p_name" class="col-sm-2 control-label">상품명</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_name" placeholder="상품명을 입력해주세요" name="p_name">
				</div>
			</div>
			<div class="form-group">
				<label for="p_company" class="col-sm-2 control-label">제조회사</label>
				<div class="text-left col-sm-3">
					<input type="text" maxlength="300" with="20%" class="form-control input-sm" id="p_company" placeholder="이메일을 입력해주세요" name="p_company">
				</div>
				
			
			</div>	
			<div class="form-group">
				<label for="p_price" class="col-sm-2 control-label">가격</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_price" placeholder="상품가격을 입력해주세요." name="p_price">
				</div>
			</div>
			<div class="form-group">
				<label for="p_image" class="col-sm-2 control-label">이미지</label>
				<div class="col-sm-4">
					<input type="text" maxlength="10"  class="form-control input-sm" id="p_image" placeholder="이미지찾기를 눌러 이미지를 등록해주세요." name="p_image">
				</div>
				<div class="text-right col-sm-4">
					<button type="button" class="btn btn-default btn-sm" id="pcode_search">이미지 찾기</button>
				</div>	
			</div>
			<div class="form-group">
				<label for="stock" class="col-sm-2 control-label">재고</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="stock" placeholder="상품 재고를 입력해주세요." name="stock">
				</div>
			</div>
			<div class="form-group">
				<label for="unit_sales" class="col-sm-2 control-label">팔린 상품수</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="unit_sales" placeholder="test" name="unit_sales">
				</div>
			</div>
			<div class="form-group">
				<label for="status" class="col-sm-2 control-label">상태</label>
					<select id='status'>
					<option value="10">판매중</option>
					<option value="20">재입고 예정</option>
					<option value="30">매진</option>
				</select>
			</div>
			<div class="form-group">
				<label for="p_new" class="col-sm-2 control-label">신상품</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_new" placeholder="신상품을 입력해 주세요." name="p_new">
				</div>
			</div>
			<div class="form-group">
				<label for="p_best" class="col-sm-2 control-label">베스트 상품</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_best" placeholder="베스트 상품을 입력해 주세요." name="p_best">
				</div>
			</div>
			<div class="form-group">
				<label for="p_sale" class="col-sm-2 control-label">할인 상품</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_sale" placeholder="할인 상품를 입력해 주세요." name="p_sale">
				</div>
			</div>
			<div class="form-group">
				<label for="p_content" class="col-sm-2 control-label">상품 설명</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="p_content" placeholder="상세 설명을 입력해 주세요." name="p_content">
				</div>
			</div>
			<div class="form-group">
				<label for="sale_percent" class="col-sm-2 control-label">할인율</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="sale_percent" placeholder="할인율를 입력해 주세요." name="sale_percent">
				</div>
			</div>
			<div class="form-group">
				<label for="reg_dt" class="col-sm-2 control-label">할인율</label>
				<div class="col-sm-8">
					<input type="text" maxlength="300"  class="form-control input-sm" id="reg_dt" placeholder="등록일" name="reg_dt">
				</div>
			</div>
			<!-- 첨부 -->
			
			
					
		</form>
		
		<!-- Button Area -->
		<div class="row">
			<div class="col-lg-10 col-sm-10 col-xs-10">
				<div class="text-right">
					<button type="button" class="btn btn-default btn-sm" id="doSave">등록하기</button>
					<button type="button" class="btn btn-default btn-sm" id="doCancel">취소하기</button>
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
	</div>	<!-- container  -->
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
   
   	
	 //등록
	   $("#doSave").on("click",function(){
	   	console.log("doSave");
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
				alert("상품가격을 입력해주세요.");
				document.getElementById("p_price").focus();
				return false;
			}
		   if(!$("#stock").val()){
				alert("재고를 입력해주세요.");
				document.getElementById("stock").focus();
				return false;
			}
		   if(!$("#p_content").val()){
				alert("상품에 대한 설명을 입력해주세요..");
				document.getElementById("p_content").focus();
				return false;
			}
		  
		   
		   
		   
		   $.ajax({
	            type:"POST",
	            url:"${context}/product/do_save.do",
	            dataType:"html",// JSON
	            data:{
	            	"h_code":$("#h_code option:selected").val(),
	            	"l_code":$("#l_code option:selected").val(),
	            	"p_name": $("#p_name").val(),
	            	"p_company": $("#p_company").val(),
	            	"p_price": $("#p_price").val(),
	            	"p_image": $("#p_image").val(),
	            	"stock": $("#stock").val(),
	            	"unit_sales":$("#unit_sales").val(),
	            	"status":$("#status option:selected").val(),
	            	"p_new": $("#p_new").val(),
	            	"p_best": $("#p_new").val(),
	            	"p_sale": $("#p_sale").val(),
	            	"p_content": $("#p_content").val()
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
	                //console.log(data);
	            	
	            	var parseData = $.parseJSON(data);
	            	if(parseData.msgId=="1"){
	            		alert(parseData.msgMsg);
	            		console.log("등록 완료!");
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
	
   
   </script>
</body>
</html>