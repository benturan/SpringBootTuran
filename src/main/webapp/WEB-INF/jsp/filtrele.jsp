<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Limo - HTML5 E-Commerce Template</title>
    <!--SEO Meta Tags-->
    <meta name="description" content="Responsive HTML5 E-Commerce Template" />
		<meta name="keywords" content="responsive html5 template, e-commerce, shop, bootstrap 3.0, css, jquery, flat, modern" />
		<meta name="author" content="8Guild" />
    <!--Mobile Specific Meta Tag-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <!--Favicon-->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <!--Master Slider Styles-->
    <link href="/resourcest/masterslider/style/masterslider.css" rel="stylesheet" media="screen">
    <!--Styles-->
    <link href="css/styles.css" rel="stylesheet" media="screen">
    
    
    
    <!--Modernizr-->
		<script src="js/libs/modernizr.custom.js"></script>
    <!--Adding Media Queries Support for IE8-->
    <!--[if lt IE 9]>
      <script src="js/plugins/respond.js"></script>
    <![endif]-->
  </head>

  <!--Body-->
  <body>


  
  
  	<!--Login Modal-->
  	  	<jsp:include page="loginpopup.jsp"></jsp:include>
    <!-- /.modal -->

    <!--Header-->
    <header data-offset-top="500" data-stuck="600"><!--data-offset-top is when header converts to small variant and data-stuck when it becomes visible. Values in px represent position of scroll from top. Make sure there is at least 100px between those two values for smooth animation-->
    
      <!--Search Form-->
      <form class="search-form closed" method="get" role="form" autocomplete="off">
        <div class="container">
          <div class="close-search"><i class="icon-delete"></i></div>
            <div class="form-group">
              <label class="sr-only" for="search-hd">Search for product</label>
              <input type="text" class="form-control" name="search-hd" id="search-hd" placeholder="Search for product">
              <button type="submit"><i class="icon-magnifier"></i></button>
          </div>
        </div>
      </form>
    
      <!--Mobile Menu Toggle-->
      <div class="menu-toggle"><i class="fa fa-list"></i></div>

      <div class="container">
        <a class="logo" href="/allindex"><img src="img/logo-scheme4.png" alt="Limo"/></a>
      </div>
      
      <!--Main Menu-->
      <nav class="menu">
        <div class="container">
          
          <jsp:include page="ustlinkler.jsp"></jsp:include>

        </div>
          
        <div class="catalog-block">
          <div class="container">
            <ul class="catalog">
            <jsp:include page="categories.jsp"></jsp:include>
            </ul>
          </div>
        </div>
      </nav>
      
      <div class="toolbar-container">
        <div class="container">  
          <!--Toolbar-->
          <div class="toolbar group">
           <jsp:include page="loginuser.jsp"></jsp:include>
           
             <jsp:include page="cart.jsp"></jsp:include> 

            <button class="search-btn btn-outlined-invert"><i class="icon-magnifier"></i></button>
          </div><!--Toolbar Close-->
        </div>
      </div>
    </header><!--Header Close-->
    
    <!--Filters Modal-->
    <div class="modal fade" id="filterModal" tabindex="-1" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
        	<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="fa fa-times"></i></button></div>
          <div class="modal-body">
            <!--Here goes filters dynamically pasted by jQuery-->
          </div>
        </div>
      </div>
    </div>
    
    <!--Filters Toggle-->
    <div class="filter-toggle" data-toggle="modal" data-target="#filterModal"><i class="fa fa-filter"></i></div>
    
    <!--Page Content-->
    <div class="page-content">
    
      <!--Breadcrumbs-->
      <ol class="breadcrumb">
        <li><a href="/allindex">Anasayfa</a></li>
        <li>Shop - filters left 2 cols</li>
      </ol><!--Breadcrumbs Close-->
      
      <!--Catalog Grid-->
      <section class="catalog-grid">
      	<div class="container">
          <h2 class="with-sorting">Filters left 2 columns</h2>
          <div class="sorting">
            <a href="#">Sort by name</a>
            <a href="#">Sort by price</a>
          </div>
          <div class="row">
          
            <!--Filters-->
          	<div class="filters-mobile col-lg-4 col-md-4 col-sm-4">
            	<div class="shop-filters">
              	
                <!--Price Section-->
                <section class="filter-section">
                	<h3>Filter by price</h3>
                  <form method="get" name="price-filters">
                  	<span class="clear" id="clearPrice" >Clear price</span>
                    <div class="price-btns">
                      <button class="btn btn-black btn-sm" value="below 50$">below 50$</button><br/>
                      <button class="btn btn-black btn-sm disabled" value="50$-100$">from 50$ to 100$</button><br/>
                      <button class="btn btn-black btn-sm" value="100$-300$">from 100$ to 300$</button><br/>
                      <button class="btn btn-black btn-sm" value="300$-1000$">from 300$ to 1000$</button>
                    </div>
                    <div class="price-slider">
                    	<div id="price-range"></div>
                      <div class="values group">
                      	<!--data-min-val represent minimal price and data-max-val maximum price respectively in pricing slider range; value="" - default values-->
                      	<input class="form-control" name="minVal" id="minVal" type="text" data-min-val="10" value="180">
                        <span class="labels">$ - </span>
                        <input class="form-control" name="maxVal" id="maxVal" type="text" data-max-val="2500" value="1400">
                        <span class="labels">$</span>
                      </div>
                      <input class="btn btn-primary btn-sm" type="submit" value="Filter">
                    </div>
                  </form>
                </section>
                
                <!--Colors Section-->
                <section class="filter-section">
                	<h3>Filter by color</h3>
                  <span class="clear clearChecks">Clear colors</span>
                  <label>
                    <input type="checkbox" name="colors" value="black" id="color_0" checked>
                    Black (12)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="colors" value="white" id="color_1">
                    White (1)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="colors" value="green" id="color_2">
                    Green  (34)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="colors" value="blue" id="color_3">
                    Blue (23)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="colors" value="red" id="color_4">
                    Red (12)</label>
                </section>
                
                <!--Colors Section-->
                <section class="filter-section">
                	<h3>Filter by size</h3>
                  <span class="clear clearChecks">Clear size</span>
                  <label>
                    <input type="checkbox" name="sizes" value="small" id="size_0" checked>
                    Small (12)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="sizes" value="white" id="size_1">
                    Medium (34)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="sizes" value="green" id="size_2">
                    Large (11)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="sizes" value="blue" id="size_3">
                    Extra large (1)</label>
                  <br>
                  <label>
                    <input type="checkbox" name="sizes" value="red" id="size_4">
                    Superman (0)</label>
                </section>
                
                <!--Categories Section-->
                <section class="filter-section">
                	<h3>Categories</h3>
                  <ul class="categories">
                    <li class="has-subcategory"><a href="#">Backpacks (123)</a><!--Class "has-subcategory" for dropdown propper work-->
                      <ul class="subcategory">
                        <li><a href="#">Backpacks (1)</a></li>
                        <li><a href="#">Shoulder Bag (45)</a></li>
                        <li><a href="#">Handbag (34)</a></li>
                        <li><a href="#">Something (12)</a></li>
                        <li><a href="#">Wallet (23)</a></li>
                      </ul>
                    </li>
                    <li><a href="#">Belts (34)</a></li>
                    <li><a href="#">Gloves (78)</a></li>
                    <li class="has-subcategory"><a href="#">Something (45)</a>
                      <ul class="subcategory">
                        <li><a href="#">Subcategory (1)</a></li>
                        <li><a href="#">Subcategory (45)</a></li>
                        <li><a href="#">Subcategory (23)</a></li>
                      </ul>
                    </li>
                    <li><a href="#">Hat bag (23)</a></li>
                  </ul>
                </section>
              </div>
            </div>
            
            <!--Tiles-->
          	<div class="col-lg-8 col-md-8 col-sm-8">
            	<div class="row">
                <!--Tile-->
                
                
                <c:forEach items="${filtreurun}" var="product">
                <div class="col-lg-6 col-md-6 col-sm-12">
                  <div class="tile">
                    <div class="badges">
                     	<c:choose>
										<c:when test="${product.sales == 1}">
											<span class="sale">Sale</span>
										</c:when>
										<c:when test="${product.sales == 2}">
											<span class="best-seller">Best Seller</span>
										</c:when>
										<c:when test="${product.sales == 3}">
											<span class="out">Out</span>
										</c:when>
									</c:choose>
                    </div>
                    <div class="price-label">${product.price} TL</div>
                    <div class="price-label old-price">${product.price} TL</div>
                    <a href="getProductDetail${product.productID}">
                      <img src="${product.image}"  alt="1"/>
                      <span class="tile-overlay"></span>
                    </a>
                    <div class="footer">
						<a href="getProductDetail${product.productID}">${product.name}</a>                     
 					<span>${product.name}</span>
 					 
										
										<form method="POST" action="/postCart">
										<input type="hidden" name="action" value="addCart" >
										<input type="hidden" name="productID" value="${product.productID}" >
										<input type="hidden" name="productPrice" value="${product.price}" >
										<input type="hidden" name="productName" value="${product.name}" >
										<input type="hidden" name="productQuantity" value="1" >
										<input type="hidden" name="productImage" value="${product.image}" >
										<input type="hidden" name="productTax" value="${product.tax}" >
										<button id="btnSepet" class="btn btn-primary">Sepete Ekle</button>
									</form>
                    </div>
                  </div>
                </div>
                </c:forEach>
              <!--Pagination-->
              <ul class="pagination">
                <li class="prev-page"><a class="icon-arrow-left" href="#"></a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li class="next-page"><a class="icon-arrow-right" href="#"></a></li>
              </ul>
            </div>
          </div>
        </div>
      </section><!--Catalog Grid Close-->
    
      <!--Brands Carousel Widget-->
      <section class="brand-carousel">
        <div class="container">
          <h2>Brands in our shop</h2>
          <div class="inner">
            <a class="item" href="#"><img src="img/brands/1.png" alt="1"/></a>
            <a class="item" href="#"><img src="img/brands/1.png" alt="1"/></a>
            <a class="item" href="#"><img src="img/brands/1.png" alt="1"/></a>
            <a class="item" href="#"><img src="img/brands/1.png" alt="1"/></a>
            <a class="item" href="#"><img src="img/brands/1.png" alt="1"/></a>
            <a class="item" href="#"><img src="img/brands/1.png" alt="1"/></a>
            <a class="item" href="#"><img src="img/brands/1.png" alt="1"/></a>
          </div>
        </div>
      </section><!--Brands Carousel Close-->
      
    </div><!--Page Content Close-->
    
    <!--Sticky Buttons-->
    <div class="sticky-btns">
      <form class="quick-contact" method="post" name="quick-contact">
        <h3>Contact us</h3>
        <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do.</p>
        <div class="form-group">
          <label for="qc-name">Full name</label>
          <input class="form-control input-sm" type="text" name="qc-name" id="qc-name" placeholder="Enter full name" required>
        </div>
        <div class="form-group">
          <label for="qc-email">Email</label>
          <input class="form-control input-sm" type="email" name="qc-email" id="qc-email" placeholder="Enter email" required>
        </div>
        <div class="form-group">
          <label for="qc-message">Your message</label>
          <textarea class="form-control input-sm" name="qc-message" id="qc-message" placeholder="Enter your message" required></textarea>
        </div>
        <input class="btn btn-black btn-sm btn-block" type="submit" value="Send">
      </form>
      <span id="qcf-btn"><i class="fa fa-envelope"></i></span>
      <span id="scrollTop-btn"><i class="fa fa-chevron-up"></i></span>
    </div><!--Sticky Buttons Close-->
    
    <!--Subscription Widget-->
    <section class="subscr-widget gray-bg">
      <div class="container">
        <div class="row">
          <div class="col-lg-7 col-md-8 col-sm-8">
            <h2>Subscribe to our news</h2>
            <form class="subscr-form" role="form" autocomplete="off">
              <div class="form-group">
                <label class="sr-only" for="subscr-name">Enter name</label>
                <input type="text" class="form-control" name="subscr-name" id="subscr-name" placeholder="Enter name" required>
                <button class="subscr-next"><i class="icon-arrow-right"></i></button>
              </div>
              <div class="form-group fff" style="display: none">
                <label class="sr-only" for="subscr-email">Enter email</label>
                <input type="email" class="form-control" name="subscr-email" id="subscr-email" placeholder="Enter email" required>
                <button type="submit" id="subscr-submit"><i class="icon-check"></i></button>
              </div>
            </form>
            <p class="p-style2">Please fill the field before continuing</p>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-lg-offset-1">
            <p class="p-style3">Get more followers. In case of high quality newsletters the customers return rate can increase up to 20%! Have you already estimated your possible income? We took that into account and created a decent subscription form. </p>
          </div>
        </div>
      </div>
    </section><!--Subscription Widget Close-->
      
  	<!--Footer-->
   <jsp:include page="altlinkler.jsp"></jsp:include><!--Footer Close-->
    
    <!--Javascript (jQuery) Libraries and Plugins-->
		<script src="js/libs/jquery-1.11.1.min.js"></script>
		<script src="js/libs/jquery-ui-1.10.4.custom.min.js"></script>
    <script src="js/libs/jquery.easing.min.js"></script>
		<script src="js/plugins/bootstrap.min.js"></script>
		<script src="js/plugins/smoothscroll.js"></script>
		<script src="js/plugins/jquery.validate.min.js"></script>
		<script src="js/plugins/icheck.min.js"></script>
		<script src="js/plugins/jquery.placeholder.js"></script>
		<script src="js/plugins/jquery.stellar.min.js"></script>
		<script src="js/plugins/jquery.touchSwipe.min.js"></script>
		<script src="js/plugins/jquery.shuffle.min.js"></script>
    <script src="js/plugins/lightGallery.min.js"></script>
    <script src="js/plugins/owl.carousel.min.js"></script>
    <script src="js/plugins/masterslider.min.js"></script>
    <script src="js/plugins/jquery.nouislider.min.js"></script>
		<script src="js/scripts.js"></script>

    
    
  </body><!--Body Close-->
</html>
