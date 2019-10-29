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
	/** 페이지 사이즈 */
	String pageSize   = "10"  ; 	
	/** 페이지 번호 */
	String pageNum    = "1"  ;	
	/** 검색조건 */
	String searchDiv  = "" ;
	/** 검색어 */
	String searchWord = "" ;
	
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
	
	

	//pageCode	
	List<Code> codeList = (request.getAttribute("codeList")==null)?(List<Code>)new ArrayList<Code>():(List<Code>)request.getAttribute("codeList");
			
	//페이지사이즈
	List<Code> listPageSize=(request.getAttribute("listPageSize")==null)?
	(List<Code>)new ArrayList<Code>():(List<Code>)(request.getAttribute("listPageSize"));
				
	//게시판 검색 구분
	List<Code> listBoardSearch=(request.getAttribute("listBoardSearch")==null)?
	(List<Code>)new ArrayList<Code>():(List<Code>)(request.getAttribute("listBoardSearch"));
				
				
	//userSearch	
	List<Code> codeSearchList = 
	(request.getAttribute("codeSearchList")==null)?
	(List<Code>)new ArrayList<Code>():
	(List<Code>)request.getAttribute("codeSearchList");		
	
	
	
	//paging 
	//maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName
	int maxNum      = 0;
    int bottomCount = 10;
    int currPageNo  = 1; //pageNum
    int rowPerPage  = 10;//pageSize
    
    String url      = request.getContextPath()+"/board/get_retrieve.do";
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
   <%@include file ="/template/header.jsp" %>
   <!--/ Header -->
	<!-- div container -->
	<div class="container">
		<!-- div title -->
		<div class="section-title">
			<h3 class="title">공지사항</h3>
	    </div>
		<!--// div title -->
		
		<!-- 검색영역 -->
		<div class="row">
			<div class="col-md-12 text-right">
				<form class="form-inline" name="frm" id="frm" method="get">
					<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }">
					<input type="hidden" name="bSeq" id="bSeq" />
					<div class="form-group">
					    <%=StringUtil.makeSelectBox(listPageSize, "pageSize", pageSize, false) %>
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
		<table class="shopping-cart-table table" id="listTable">
					<thead>
						<tr>

							<th class="text-center">번호</th>
							<th class="text-center">제목</th>
							<th class="text-center">작성자</th>
							<th class="text-center">작성날짜</th>
							<th class="text-center">조회수</th>
						</tr>
					</thead>
					<tbody id="tablerow">
						<c:choose>
							<c:when test="${list.size()>0}">
							<c:forEach var="vo" items="${list}">
							<input type="hidden" name="bSeq" id="bSeq" value="${vo.bSeq}"/>							
							<input type="hidden" name="bTitle" id="bTitle" value="${vo.bTitle}"/>							
							<input type="hidden" name="id" id="id" value="${vo.id}"/>							
							<input type="hidden" name="regDt" id="regDt" value="${vo.regDt}"/>							
						<tr>
							
							<td class="price text-center"><c:out value="${vo.bSeq}" /></td>
							<td class="details"> <a href="#"><c:out value="${vo.bTitle}" /></a></td>
							<td class="price text-center"><c:out value="${vo.id}"/></td>
							<td class="price text-center"><c:out value="${vo.regDt}"/></td>
							<td class="price text-center"><c:out value="${vo.readCnt}"/></td>
						</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				  </tbody>
				</table>
			
			<div class="text-right"  >
				<button class="primary-btn" name="dowrite" id="dowrite" onclick="location='${context}/board/board_write.jsp'">등록하기</button>
			</div>
		</div>
		
		<!-- //Grid영역 -->
		<!-- pagenation -->
		<div class="text-center">
			<%=StringUtil.renderPaing(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %>
		</div>
		<!--// pagenation -->
		
		
	</div>
	<!--// div container -->
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${context}/resources/js/jquery-1.12.4.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/slick.min.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.zoom.min.js"></script>
	<script src="../resources/js/main.js"></script>
	<script type="text/javascript">
	
		
	
		//삭제버튼
		
		$("#delete").on("click",function(){
			//alert("dddd")
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[name=rowCheckbox]:checked");
			console.log(checkbox.value())
			
			checkbox.each(function(i){
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				// 체크된 row의 모든 값을 배열에 담는다.
				rowData.push(tr.text());
				
				var seq = td.eq(1).text()
				var title = td.eq(1).text()
				
				console.log("seq : " + seq);
				$.ajax({
					type : "POST",
					url : "${context}/board/do_delete.do",
					dataType : "html",
					data : {
						"bSeq" : seq
					},
					success : function(data){
						var dodelete;
						dodelete = confirm("게시물을 삭제합니다");
						if(dodelete){
							document.write("삭제되었습니다.")
						}
						location.reload();

					}
				  });
				  });
			});
		
		 $("#listTable>tbody").on("click","tr",function(){
			//alert("listTable>tbody");
			var trs = $(this);
			var tds = trs.children();
			if(null == tds || tds.length ==1 )return;
			
			var bSeq = tds.eq(0).text();
			console.log("bSeq:"+bSeq);

			var frm = document.frm;
			frm.bSeq.value=bSeq;
			frm.action = "${context}/board/do_selectOne.do";
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
			frm.action = "${context}/board/get_retrieve.do";
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
	
		
		$(document).ready(function() {
			if("${user.id==admin}"){
				$("#dowrite").show();
			}else{
				$("#dowrite").hide();
			}
		});
	</script>
</body>
   <!-- FOOTER -->
   <%@include file ="/template/footer.jsp" %>
   <!-- /FOOTER -->	
</html>