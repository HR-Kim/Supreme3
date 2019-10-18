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
<%
	/** 페이지 사이즈 */
	String pageSize   = "10"  ; 	
	/** 페이지 번호 */
	String pageNum    = "1"  ;	
	/** 검색조건 */
	String searchDiv  = "" ;
	/** 검색어 */
	String searchWord = "test01" ;
	
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
	
	String url      = request.getContextPath()+"/product/get_retrieve.do";
	String scriptName ="search_page";

%>
<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8">
<title>Product Page</title>
<head>

</head>

<body>
   <!-- Header -->
   <%@include file ="/template/header.jsp" %>
   <!--/ Header -->
	
   <!-- HOME -->
   <div id="home">
   <button type="button" class="btn btn-default btn-sm"
		id="doRetrieve" >조회</button>
      <!-- container -->
      <div class="container">
         <!-- home wrap -->
         <div class="home-wrap">
            <!-- home slick -->
            
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
                   
                    <tbody id="listTable">
                    	<c:choose>
                    		<c:when test="${list.size()>0}">
                    		
                    			<c:forEach var="vo" items="${list}">
                    		
                     <div class="product product-single">
                        <div class="product-thumb">
                           <div class="product-label">
                              
                            
                           </div>
                          
                          
                           <img src="../resources/img/test567.jpg" alt="">
                        </div>
                        	
                        <div class="product-body">
                           <h3 ><c:out value="${vo.p_name}"/></h3>
                           <div class="product-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                           </div>
                           <h2 class="product-name"><a href="#"><c:out value="${vo.p_price}"/></a></h2>
                           <div class="product-btns">
                              <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                              <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                              <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                           </div>
                        </div>
                     </div>
                     		</c:forEach>
                    	 </c:when>
                     </c:choose>
                   
                    </table>
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
   
   function search_page(url, pageNum){
		var frm = document.boardFrm;
   		frm.pageNum.value = pageNum;
   		frm.action = url;
   		frm.submit();
	}
   
   $("#listTable>tbody").on("click","tr",function(){
		//alert("listTable");
		var trs = $(this);
		var td  = trs.children();
		if(null==td || td.length==1)return;
		//alert("td.length:"+td.length);
		
		
		var p_name = td.eq(0).text();
		//console.log("boardId:"+boardId);
		var frm = document.boardFrm;
		frm.pageNum.value = 1;
    	frm.action = "${context}/product/do_selectOne.do";
    	frm.submit();
		
	});
   
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
   
   	 	function doRetrieve(){
	    	var frm = document.boardFrm;
	    	frm.pageNum.value = 1;
	    	frm.action = "${context}/product/get_retrieve.do";
	    	frm.submit();
	    }
   		
		$("#doRetrieve").on("click",function(){
			
			doRetrieve();
		});
		
   
  		 $(document).ready(function() {
				//alert("ready");
	 	
			});
  	 </script>
	
</body>

</html>