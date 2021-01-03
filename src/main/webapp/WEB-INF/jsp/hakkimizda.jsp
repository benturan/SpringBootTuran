<%@ page pageEncoding="UTF-8"%>
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
  <body class="parallax"><!--Add this class if you have elements on the page with parallax backgrounds-->


  
  
    <!--Login Modal-->
      	<jsp:include page="loginpopup.jsp"></jsp:include>
   <!-- /.modal -->

    <!--Header-->
    <header data-offset-top="500" data-stuck="600"><!--data-offset-top is when header converts to small variant and data-stuck when it becomes visible. Values in px represent position of scroll from top. Make sure there is at least 100px between those two values for smooth animation-->
    
      <!--Search Form-->
    <jsp:include page="searchBar.jsp"></jsp:include>
    
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
    
    <!--Page Content-->
    <div class="about page-content">
    
    	<!--Hero Static-->
      <section class="hero-static">
      	<div class="overlay"></div>
      	<div style="background-image: url(img/about/about_bg.jpg);" class="bg-image" data-stellar-background-ratio="0.5"></div>
        <div class="content">
        	<div class="inner">
          	<h1>Awesome team.<br/><span>Awesome shop.</span></h1>
          </div>
        </div>
      </section><!--Hero Static Close-->
      
      <!--About Info-->
      <section class="space-top space-bottom container">
      	<h2>About us</h2>
        <div class="row">
        	<div class="col-lg-5 col-md-6 col-sm-6">
          	<h3>Why we are cool</h3>
            <p class="p-style3">Limo is the product which was born thanks to the involvement not only of the UI experts but also great marketers who have tremendous experience in outstanding implementations of e-commerce projects from different domains.</p>
          </div>
        	<div class="col-lg-6 col-lg-offset-1 col-md-6 col-sm-6">
            <p class="p-style3">Limo Theme is quite universal and covers a lot of use cases for either big e-commerce website or smaller ones. Due to 5 different landing pages you can easily guide a client whether directly to a specific product or to a category page. The Product Showcase Home page is a full featured landing page for effective product or service promotion.</p>
          </div>
        </div>
      </section><!--About Info Close-->
      
      <!--Team-->
      <section class="team container">
      	<h3>Meet our team</h3>
      	<div class="row">
        	<!--Member-->
        	<div class="col-lg-3 col-md-3 col-sm-6">
          	<div class="member">
            	<div class="mask"><img src="img/about/team/1.png" alt="1"/></div>
              <h4>Jonathan Doe</h4>
              <h5>CEO, Founder</h5>
              <div class="social">
              	<a href="#"><i class="fa fa-twitter"></i></a>
              	<a href="#"><i class="fa fa-facebook-square"></i></a>
              	<a href="#"><i class="fa fa-pinterest-square"></i></a>
              	<a href="mailto:mail@mail.com"><i class="fa fa-envelope"></i></a>
              </div>
            </div>
          </div>
        	<!--Member-->
        	<div class="col-lg-3 col-md-3 col-sm-6">
          	<div class="member">
            	<div class="mask"><img src="img/about/team/1.png" alt="1"/></div>
              <h4>Jonathan Doe</h4>
              <h5>CEO, Founder</h5>
              <div class="social">
              	<a href="#"><i class="fa fa-twitter"></i></a>
              	<a href="#"><i class="fa fa-facebook-square"></i></a>
              	<a href="#"><i class="fa fa-pinterest-square"></i></a>
              	<a href="mailto:mail@mail.com"><i class="fa fa-envelope"></i></a>
              </div>
            </div>
          </div>
        	<!--Member-->
        	<div class="col-lg-3 col-md-3 col-sm-6">
          	<div class="member">
            	<div class="mask"><img src="img/about/team/1.png" alt="1"/></div>
              <h4>Jonathan Doe</h4>
              <h5>CEO, Founder</h5>
              <div class="social">
              	<a href="#"><i class="fa fa-twitter"></i></a>
              	<a href="#"><i class="fa fa-facebook-square"></i></a>
              	<a href="#"><i class="fa fa-pinterest-square"></i></a>
              	<a href="mailto:mail@mail.com"><i class="fa fa-envelope"></i></a>
              </div>
            </div>
          </div>
        	<!--Member-->
        	<div class="col-lg-3 col-md-3 col-sm-6">
          	<div class="member">
            	<div class="mask"><img src="img/about/team/1.png" alt="1"/></div>
              <h4>Jonathan Doe</h4>
              <h5>CEO, Founder</h5>
              <div class="social">
              	<a href="#"><i class="fa fa-twitter"></i></a>
              	<a href="#"><i class="fa fa-facebook-square"></i></a>
              	<a href="#"><i class="fa fa-pinterest-square"></i></a>
              	<a href="mailto:mail@mail.com"><i class="fa fa-envelope"></i></a>
              </div>
            </div>
          </div>
        </div>
      </section><!--Team Close-->
      
    </div><!--Page Content Close-->
    
    <!--Sticky Buttons-->
        <jsp:include page="sticky.jsp"></jsp:include>
        <!--Sticky Buttons Close-->
    
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
   <jsp:include page="altlinkler.jsp"></jsp:include>
   <!--Footer Close-->
    
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
		<script src="js/scripts.js"></script>

    
    
  </body><!--Body Close-->
</html>
