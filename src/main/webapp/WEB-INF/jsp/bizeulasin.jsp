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
    <!--Master Slider Styles-->
    <link href="masterslider/style/masterslider.css" rel="stylesheet" media="screen">
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
           
              <!--Cart Dropdown-->
                   <jsp:include page="cart.jsp"></jsp:include> 

            <button class="search-btn btn-outlined-invert"><i class="icon-magnifier"></i></button>
          </div><!--Toolbar Close-->
        </div>
      </div>
    </header><!--Header Close-->
    
    <!--Page Content-->
    <div class="page-content">
    
      <!--Breadcrumbs-->
      <ol class="breadcrumb">
        <li><a href="/allindex">Anasayfa</a></li>
        <li>İletişim</li>
      </ol><!--Breadcrumbs Close-->
      
      <div class="container"><h2>İletişim</h2></div>
      
      <!--Google Map-->
      <section class="map container">
      	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3009.1312502533424!2d29.004558314698627!3d41.04425877929715!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14cab7989d1328b7%3A0xdd75b40c13d8ae49!2sBilge%20Adam%20Akademi!5e0!3m2!1str!2str!4v1593801084394!5m2!1str!2str" width="800" height="400" style="border:0"></iframe>
      </section><!--Google Map Close-->
      
      <!--Contacts-->
      <section class="container">
      	<div class="row">
          <!--Contact Info-->
        	<div class="col-lg-5 col-lg-offset-1 col-md-5 col-sm-5">
            <h3>İletişim Bilgileri</h3>
            <div class="cont-info-widget">
            <ul>
              <li><i class="fa fa-building"></i>Abbasağa, Barbaros Blv. No:13, <br/>34353 Beşiktaş/İstanbul</li>
              <li><a href="#"><i class="fa fa-envelope"></i>mail@Limo.com</a></li>
              <li><a href="#"><i class="fa fa-support"></i>support@Limo.com</a></li>
              <li><i class="fa fa-phone"></i> 444 3 330</li>
            </ul>
            </div>
          </div>
          <!--Mesaj kutusu-->
          
        	<div class="col-lg-5 col-md-7 col-sm-7">
          	<h3>Bir mesaj bırak</h3>
          	<form class="contact-form" method="post" action = "/mesaj">
            	<div class="form-group">
              	<label class="sr-only" for="cf-name">Name</label>
              	<input type="text" class="form-control" name="name" id="name" placeholder="Adınızı Yazın" required>
              </div>
            	<div class="form-group">
              	<label class="sr-only" for="cf-email">Email</label>
              	<input type="email" class="form-control" name="email" id="email" placeholder="E-mail adresini girinix" required>
              </div>
            	<div class="form-group">
              	<label class="sr-only" for="cf-message">Message</label>
                <textarea class="form-control" name="usermessage" id="usermessage" rows="5" placeholder="Mesajınız" required></textarea>
              </div>
              <input class="btn btn-primary" type="submit"  >
            </form>
          </div>
          
           <!--Mesaj kutusu-->
        </div>
      </section><!--Contacts Close-->
      
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
    <script src="js/plugins/jquery.nouislider.min.js"></script>
		<script src="js/scripts.js"></script>

    
    
  </body><!--Body Close-->
</html>
