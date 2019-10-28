<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath }" />    
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>반려묘 전문 쇼핑몰 :: 묘한생각</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="${context}/resources/css/bootstrap.min.css" />

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="${context}/resources/css/slick.css" />
	<link type="text/css" rel="stylesheet" href="${context}/resources/css/slick-theme.css" />

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet" href="${context}/resources/css/nouislider.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="${context}/resources/css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="${context}/resources/css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<!-- HEADER -->
	<header>
		

		<!-- header -->
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="${context}/product/get_cat_retrieve.do">
							<img src="${context}/resources/img/logo.png" alt="">
						</a>
					</div>
					<!-- /Logo -->

					<!-- Search -->
					<div class="header-search">
						<!-- <form>
							<input class="input search-input" type="text" placeholder="검색어를 입력하세요">
							<select class="input search-categories">
								<option value="0">전체</option>
								<option value="1">Category 01</option>
								<option value="1">Category 02</option>
							</select>
							<button class="search-btn"><i class="fa fa-search"></i></button>
						</form> -->
					</div>
					<!-- /Search -->
				</div>
				<div class="pull-right">
					<ul class="header-btns">
						<!-- Account -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								<div class="header-btns-icon">
									<i class="fa fa-user-o"></i>
								</div>
								<strong class="text-uppercase">My Account <i class="fa fa-caret-down"></i></strong>
							</div>
							<% 
								Object user = session.getAttribute("user"); 
								if( user == null){
							%>
							<a href="${context}/user/login.do" class="text-uppercase">Login</a> 
							<% 
								}else{
							%>
							<a href="#" class="text-uppercase" onclick="logout()">Logout</a> 
							<%		
								}
							%>
							
							 / <a href="${context}/user/join.do" class="text-uppercase">Join</a>
							<ul class="custom-menu">
								<li><a href="${context}/user/update.do"><i class="fa fa-user-o"></i> 회원 정보 수정</a></li>
								<li><a href="${context}/orderStatus/get_retrieve.do"><i class="fa fa-check"></i> 주문 내역 확인</a></li>
								<% 
								if( user == null){
								%>
								<li><a href="${context}/user/login.do"><i class="fa fa-unlock-alt"></i> Login</a></li>
								<% 
								}else{
								%>
								<li><a href="#" onclick="logout()"><i class="fa fa-unlock-alt"></i> Logout</a></li>
								<%		
								}
								%>
							</ul>
						</li>
						<!-- /Account -->

						<!-- Cart -->
						<li class="header-cart">
							<a href="${context}/cart/direct.do">
								<div class="header-btns-icon">
									<i class="fa fa-shopping-cart"></i>
								</div>
								<strong class="text-uppercase">My Cart</strong>
							</a>
							
						</li>
						<!-- /Cart -->

						<!-- Mobile nav toggle-->
						<li class="nav-toggle">
							<button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
						</li>
						<!-- / Mobile nav toggle -->
					</ul>
				</div>
			</div>
			<!-- header -->
		</div>
		<!-- container -->
	</header>
	<!-- /HEADER -->

	<!-- NAVIGATION -->
	<div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
				<!-- category nav -->
				<div class="category-nav show-on-click">
					<span class="category-header">카테고리 <i class="fa fa-list"></i></span>
					<ul class="category-list">
						<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=10">먹거리</a></li>
						<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=20">생활용품</a></li>
						<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=30">위생용품</a></li>
						<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=40">외출용품</a></li>
					</ul>
				</div>
				<!-- /category nav -->

				<!-- menu nav -->
				<div class="menu-nav">
					<span class="menu-header">Menu <i class="fa fa-bars"></i></span>
					<ul class="menu-list">
						<li class="dropdown default-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"> 먹거리  <i class="fa fa-caret-down"></i></a>
							<div class="custom-menu">
								<div class="row">
									<div class="col-md-12">
										<ul class="list-links">
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=10&lCodeCat=11"><i class="fa fa-paw"></i>  사료</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?hCodeCat=10&lCodeCat=12"><i class="fa fa-paw"></i> 간식</a></li>
										</ul>
									</div>
								</div>
							</div>	
						</li>		
						<li class="dropdown default-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"> 생활용품  <i class="fa fa-caret-down"></i></a>
							<div class="custom-menu">
								<div class="row">
									<div class="col-md-12">
										<ul class="list-links">
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=21"><i class="fa fa-paw"></i> 하우스</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=22"><i class="fa fa-paw"></i> 캣타워</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=23"><i class="fa fa-paw"></i> 낚시대</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=24"><i class="fa fa-paw"></i> 레이저</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=25"><i class="fa fa-paw"></i> 스크래쳐</a></li>
										</ul>
									</div>
								</div>
							</div>	
						</li>
						<li class="dropdown default-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"> 위생용품  <i class="fa fa-caret-down"></i></a>
							<div class="custom-menu">
								<div class="row">
									<div class="col-md-12">
										<ul class="list-links">
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=31"><i class="fa fa-paw"></i> 목욕용품</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=32"><i class="fa fa-paw"></i> 화장실용품</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=33"><i class="fa fa-paw"></i> 미용용품</a></li>
										</ul>
									</div>
								</div>
							</div>	
						</li>
						<li class="dropdown default-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"> 외출용품  <i class="fa fa-caret-down"></i></a>
							<div class="custom-menu">
								<div class="row">
									<div class="col-md-12">
										<ul class="list-links">
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=41"><i class="fa fa-paw"></i> 이동장</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=42"><i class="fa fa-paw"></i> 가슴줄</a></li>
											<li><br></li>
											<li><a href="${context}/product/get_cat_retrieve.do?lCodeCat=43"><i class="fa fa-paw"></i> 의류</a></li>
										</ul>
									</div>
								</div>
							</div>	
						</li>
						<li><a href="#"> 공지사항 </a></li>
						</li>
					</ul>
				</div>
				<!-- menu nav -->
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /NAVIGATION -->

	<!-- BREADCRUMB -->
	
	<!-- /BREADCRUMB -->

	
	
	
	<form class="form-horizontal" name="Frm1" id="Frm1" method="post">
	   	<input type="hidden" name="h_code" />
	</form>
	
	<form class="form-horizontal" name="Frm2" id="Frm2" method="post">
	   	<input type="hidden" name="l_code" />
	</form>
		
	<!-- jQuery Plugins -->
	<script src="${context}/resources/js/jquery.min.js"></script>
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<script src="${context}/resources/js/slick.min.js"></script>
	<script src="${context}/resources/js/nouislider.min.js"></script>
	<script src="${context}/resources/js/jquery.zoom.min.js"></script>
	<script src="${context}/resources/js/main.js"></script>


	<script>
		function logout(){
			alert("로그아웃 하시겠습니까?");
			location.href = "${context}/user/do_logout.do";
			location.reload();
		};
	
	
	   $('.detail1').on('click',function() {
			  
		 /*  location.href="${context}/product/product_insert.jsp"; */
		   
		
	 	 });	//-- function
	 	 
	   $('.detail2').on('click',function() {
			  
		 /*  location.href="${context}/product/product_insert.jsp"; */
			   
			  
		  });	//-- function
		 	 
		 	 
		$('.detail3').on('click',function() {
				  
		 /*  location.href="${context}/product/product_insert.jsp"; */
				   
		  
			 });	//-- function
			  
		 $('.detail4').on('click',function() {
					  
		 /*  location.href="${context}/product/product_insert.jsp"; */
					   
					  
			 });	//-- function
   
   </script>
	
</html>
