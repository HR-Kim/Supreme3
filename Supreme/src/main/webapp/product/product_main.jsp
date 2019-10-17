<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.supreme.code.service.Code"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.supreme.cmn.StringUtil"%>
<%@page import="kr.co.supreme.cmn.Search"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="context" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
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

   <!-- HOME -->
   <div id="home">
      <!-- container -->
      <div class="container">
         <!-- home wrap -->
         <div class="home-wrap">
            <!-- home slick -->
            <div id="home-slick">
               

               
            </div>
            <!-- /home slick -->
         </div>
         <!-- /home wrap -->
      </div>
      <!-- /container -->
   </div>
   <!-- /HOME -->

   <!-- section -->
   <div class="section">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
            <!-- banner -->
            
            <!-- /banner -->

            <!-- banner -->
           
            <!-- /banner -->

            <!-- banner -->
            
            <!-- /banner -->

         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->

   <!-- section -->
   <div class="section">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
            <!-- section-title -->
            <div class="col-md-12">
               <div class="section-title">
                  <h2 class="title"></h2>
                  <div class="pull-right">
                     <div class="product-slick-dots-1 custom-dots"></div>
                  </div>
               </div>
            </div>
            <!-- /section-title -->
			 <div class="col-md-12">
               <div class="section-title">
                  <h2 class="title">TEST</h2>
                  <div class="pull-right">
                     <div class="product-slick-dots-2 custom-dots">
                     </div>
                  </div>
               </div>
            </div>
            <!-- banner -->
           
            <!-- /banner -->

            <!-- Product Slick -->
            <div class="col-md-9 col-sm-6 col-xs-6">
               <div class="row">
                  <div id="product-slick-1" class="product-slick">
                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <div class="product-label">
                              <span>New</span>
                              <span class="sale">-20%</span>
                           </div>
                           <ul class="product-countdown">
                              <li><span>00 H</span></li>
                              <li><span>00 M</span></li>
                              <li><span>00 S</span></li>
                           </ul>
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product01.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->

                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <div class="product-label">
                              <span class="sale">-20%</span>
                           </div>
                           <ul class="product-countdown">
                              <li><span>00 H</span></li>
                              <li><span>00 M</span></li>
                              <li><span>00 S</span></li>
                           </ul>
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product07.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->

                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <div class="product-label">
                              <span>New</span>
                              <span class="sale">-20%</span>
                           </div>
                           <ul class="product-countdown">
                              <li><span>00 H</span></li>
                              <li><span>00 M</span></li>
                              <li><span>00 S</span></li>
                           </ul>
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product06.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->

                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <div class="product-label">
                              <span>New</span>
                              <span class="sale">-20%</span>
                           </div>
                           <ul class="product-countdown">
                              <li><span>00 H</span></li>
                              <li><span>00 M</span></li>
                              <li><span>00 S</span></li>
                           </ul>
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product08.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->
                  </div>
               </div>
            </div>
            <!-- /Product Slick -->
         </div>
         <!-- /row -->

         <!-- row -->
         <div class="row">
            <!-- section title -->
            <div class="col-md-12">
               <div class="section-title">
                  <h2 class="title">Deals Of The Day</h2>
                  <div class="pull-right">
                     <div class="product-slick-dots-2 custom-dots">
                     </div>
                  </div>
               </div>
            </div>
            <!-- section title -->

            <!-- Product Single -->
            <div class="col-md-3 col-sm-6 col-xs-6">
               <div class="product product-single product-hot">
                  <div class="product-thumb">
                     <div class="product-label">
                        <span class="sale">-20%</span>
                     </div>
                     <ul class="product-countdown">
                        <li><span>00 H</span></li>
                        <li><span>00 M</span></li>
                        <li><span>00 S</span></li>
                     </ul>
                     <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                     <img src="../resources/img/product01.jpg" alt="">
                  </div>
                  <div class="product-body">
                     <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                     <div class="product-rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o empty"></i>
                     </div>
                     <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                     <div class="product-btns">
                        <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                        <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                        <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /Product Single -->

            <!-- Product Slick -->
            <div class="col-md-9 col-sm-6 col-xs-6">
               <div class="row">
                  <div id="product-slick-2" class="product-slick">
                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product06.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50</h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->

                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <div class="product-label">
                              <span class="sale">-20%</span>
                           </div>
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product05.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->

                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product04.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50</h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->

                     <!-- Product Single -->
                     <div class="product product-single">
                        <div class="product-thumb">
                           <div class="product-label">
                              <span>New</span>
                              <span class="sale">-20%</span>
                           </div>
                           <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                           <img src="../resources/img/product03.jpg" alt="">
                        </div>
                        <div class="product-body">
                           <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     <!-- /Product Single -->

                  </div>
               </div>
            </div>
            <!-- /Product Slick -->
         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->

   <!-- section -->
   <div class="section section-grey">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
            <!-- banner -->
            
            <!-- /banner -->

            <!-- banner -->
            
            <!-- /banner -->

            <!-- banner -->
            
            <!-- /banner -->
         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->

   <!-- section -->
   <div class="section">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
            <!-- section title -->
            <div class="col-md-12">
               <div class="section-title">
                  <h2 class="title">Latest Products</h2>
               </div>
            </div>
            <!-- section title -->

            <!-- Product Single -->
            <div class="col-md-3 col-sm-6 col-xs-6">
               <div class="product product-single">
                  <div class="product-thumb">
                     <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                     <img src="../resources/img/product01.jpg" alt="">
                  </div>
                  <div class="product-body">
                     <h3 class="product-price">$32.50</h3>
                     <div class="product-rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o empty"></i>
                     </div>
                     <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                     <div class="product-btns">
                        <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                        <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                        <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /Product Single -->

            <!-- Product Single -->
            <div class="col-md-3 col-sm-6 col-xs-6">
               <div class="product product-single">
                  <div class="product-thumb">
                     <div class="product-label">
                        <span>New</span>
                        <span class="sale">-20%</span>
                     </div>
                     <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                     <img src="../resources/img/product02.jpg" alt="">
                  </div>
                  <div class="product-body">
                     <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                     <div class="product-rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o empty"></i>
                     </div>
                     <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                     <div class="product-btns">
                        <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                        <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                        <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /Product Single -->

            <!-- Product Single -->
            <div class="col-md-3 col-sm-6 col-xs-6">
               <div class="product product-single">
                  <div class="product-thumb">
                     <div class="product-label">
                        <span>New</span>
                        <span class="sale">-20%</span>
                     </div>
                     <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                     <img src="../resources/img/product03.jpg" alt="">
                  </div>
                  <div class="product-body">
                     <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                     <div class="product-rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o empty"></i>
                     </div>
                     <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                     <div class="product-btns">
                        <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                        <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                        <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /Product Single -->

           
            <!-- /Product Single -->
         </div>
         <!-- /row -->

         <!-- row -->
         
            <!-- /banner -->

            <!-- Product Single -->
            <div class="col-md-3 col-sm-6 col-xs-6">
               <div class="product product-single">
                  <div class="product-thumb">
                     <div class="product-label">
                        <span>New</span>
                        <span class="sale">-20%</span>
                     </div>
                     <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                     <img src="../resources/img/product07.jpg" alt="">
                  </div>
                  <div class="product-body">
                     <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                     <div class="product-rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o empty"></i>
                     </div>
                     <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                     <div class="product-btns">
                        <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                        <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                        <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /Product Single -->

            <!-- Product Single -->
            <div class="col-md-3 col-sm-6 col-xs-6">
               <div class="product product-single">
                  <div class="product-thumb">
                     <div class="product-label">
                        <span>New</span>
                        <span class="sale">-20%</span>
                     </div>
                     <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                     <img src="../resources/img/product06.jpg" alt="">
                  </div>
                  <div class="product-body">
                     <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                     <div class="product-rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o empty"></i>
                     </div>
                     <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                     <div class="product-btns">
                        <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                        <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                        <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /Product Single -->

            <!-- Product Single -->
            <div class="col-md-3 col-sm-6 col-xs-6">
               <div class="product product-single">
                  <div class="product-thumb">
                     <div class="product-label">
                        <span>New</span>
                        <span class="sale">-20%</span>
                     </div>
                     <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                     <img src="../resources/img/product05.jpg" alt="">
                  </div>
                  <div class="product-body">
                     <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                     <div class="product-rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o empty"></i>
                     </div>
                     <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                     <div class="product-btns">
                        <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                        <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                        <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /Product Single -->
         </div>
         <!-- /row -->

         <!-- row -->
       
            <!-- /Product Single -->
         </div>
         <!-- /row -->
      </div>
      <!-- /container -->
   </div>
   <!-- /section -->

   <!-- FOOTER -->
   <%@include file ="/template/footer.jsp" %>
   <!-- /FOOTER -->

	
	
	
		
   <!-- jQuery Plugins -->
   <script src="../resources/js/jquery.min.js"></script>
   <script src="../resources/js/bootstrap.min.js"></script>
   <script src="../resources/js/slick.min.js"></script>
   <script src="../resources/js/nouislider.min.js"></script>
   <script src="../resources/js/jquery.zoom.min.js"></script>
   <script src="../resources/js/main.js"></script>
	
   <script>
   
   	function getProductList(p_code){
   		
   		$.ajax({
   			type:"POST",
   			url:"${context}/product/get_retrieve.do",
   			dataType:"html",
   			data:{
   				"p_code" : p_code
   			},
   		   success: function(data){
   			   alert(data);
   			   var jData = JSON.parse(data);
   			   if(null != jData && jData.msgId=="1"){
   				   alert(jData.msgContents);
   			   }else{
   				   alert(jData.msgId+"|"jData.msgContents);
   			   }
   		   },
   		   complete:function(data){
   			   
   		   },
   		   error:function(xhr,status,error){
   				  alert("error:"+error);
   		   		}
   			});	//ajax
   		
   		}	//function
   
   
   $(document).ready(function() {
		//alert("ready");
	});
   </script>
	
</body>

</html>