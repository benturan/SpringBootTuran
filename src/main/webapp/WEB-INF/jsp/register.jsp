<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>BilgeAdam ETicaret Projesi</title>
<!--SEO Meta Tags-->
<meta name="description" content="Responsive HTML5 E-Commerce Template" />
<meta name="keywords"
	content="responsive html5 template, e-commerce, shop, bootstrap 3.0, css, jquery, flat, modern" />
<meta name="author" content="8Guild" />
<!--Mobile Specific Meta Tag-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!--Favicon-->
<link rel="shortcut icon" href="favicon.ico"
	type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!--Master Slider Styles-->
<link href="masterslider/style/masterslider.css"
	rel="stylesheet" media="screen">
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
	<header data-offset-top="500" data-stuck="600">
		<!--data-offset-top is when header converts to small variant and data-stuck when it becomes visible. Values in px represent position of scroll from top. Make sure there is at least 100px between those two values for smooth animation-->

		<!--Search Form-->
		<form class="search-form closed" method="get" role="form"
			autocomplete="off">
			<div class="container">
				<div class="close-search">
					<i class="icon-delete"></i>
				</div>
				<div class="form-group">
					<label class="sr-only" for="search-hd">Ürün ara</label> <input
						type="text" class="form-control" name="search-hd" id="search-hd"
						placeholder="Search for product">
					<button type="submit">
						<i class="icon-magnifier"></i>
					</button>
				</div>
			</div>
		</form>

		<!--Mobile Menu Toggle-->
		<div class="menu-toggle">
			<i class="fa fa-list"></i>
		</div>

		<div class="container">
			<a class="logo" href="/allindex"><img
				src="img/logo-scheme4.png" alt="Limo" /></a>
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

					<button class="search-btn btn-outlined-invert">
						<i class="icon-magnifier"></i>
					</button>
				</div>
				<!--Toolbar Close-->
			</div>
		</div>
	</header>
	<!--Header Close-->

	<!--Page Content-->
	<div class="page-content">

		<!--Breadcrumbs-->
		<ol class="breadcrumb">
			<li><a href="allindex">Anasayfa</a></li>

		</ol>
		<!--Breadcrumbs Close-->

		<!--Login / Register-->
		<section class="log-reg container">
			<h2>Giriş Yap/ Kayıt ol</h2>
			<h4>Sosyal medya ile bağlan</h4>
			<div class="social-login">
				<a class="facebook" href="#"><i class="fa fa-facebook-square"></i></a>
				<a class="google" href="#"><i class="fa fa-google-plus-square"></i></a>
				<a class="twitter" href="#"><i class="fa fa-twitter-square"></i></a>
			</div>
			<div class="row">
				<!--Login-->
				<div class="col-lg-5 col-md-5 col-sm-5">
					<form method="post" class="login-form">
						<div class="form-group group">
							<label for="log-email2">Mail adresi</label> <input type="email"
								class="form-control" name="log-email2" id="log-email2"
								placeholder="E-posta adresinizi giriniz" required> <a
								class="help-link" href="#">Mail adresimi unuttum</a>
						</div>
						<div class="form-group group">
							<label for="log-password2">Şifre</label> <input type="text"
								class="form-control" name="log-password2" id="log-password2"
								placeholder="Şifrenizi giriniz" required> <a
								class="help-link" href="#">Şifremi unuttum</a>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" name="remember">
								Beni hatırla</label>
						</div>
						<input class="btn btn-black" type="submit" value="Giriş yap">
					</form>
				</div>
				<!--burası-->
				<!--Registration-->		
					<div class="col-lg-7 col-md-7 col-sm-7">
						<form method="post" action="/kayitWeb"
							class="registr-form">
							<div class="form-group group">
								<label for="name">Ad</label> <input type="text"
									class="form-control" name="name" id="name" placeholder="Adınız"
									required>
							</div>
							<div class="form-group group">
								<label for="surname">Soyad</label> <input type="text"
									class="form-control" name="surname" id="surname"
									placeholder="Soyadınız" required>
							</div>
							<div class="form-group group">
								<label for="email">
								<c:choose>
      							 <c:when test="${message != null}">
      							 <font face="tahoma" size="5" color="red">
            					 <b> Email Adresiniz daha önceden kullanılmıştır.</b> </font>
      							 </c:when>
      							 <c:otherwise>
             						E-posta 
       							</c:otherwise>
  								</c:choose>`								
								 </label> 
								<input type="email"	class="form-control" name="email" id="email" placeholder="E-posta adresi giriniz "  ${message} required>
							</div>
							<div class="form-group group">
								<label for="password">Şifre</label> <input type="password"
									class="form-control" name="password" id="password"
									placeholder="Şifre giriniz" required>
							</div>
							
				
              <div class="form-group group">
                <label for="rf-password-repeat">Şifreyi Tekrar giriniz</label>
                <input type="password" class="form-control" name="rf-password-repeat" id="ConfirmPassword" placeholder="Şifreyi Tekrar giriniz" required>
              </div>
              
           
							<div class="form-group group">
								<label for="telephone">Telefon Numarası</label> <input
									type="tel" class="form-control phone_us" name="telephone"
									id="tel" placeholder="Telefon numraranız" required>
							</div>
							<div class="form-group group">
								<label>Cinsiyet</label> <select name="gender">
									<option selected>Erkek</option>
									<option>Kadın</option>
								</select></div>

							<div class="checkbox">
								<label><input type="checkbox" name="checkbox">
									Şartları okudum ve kabul ediyorum.</label>
							</div>
							<input class="btn btn-black" type="submit" id="btnSubmit" value="Kayıt ol">
						</form>
					</div>
				</div>
			</section>
		<!--Login / Register Close-->

		<!--Brands Carousel Widget-->
		<section class="brand-carousel">
			<div class="container">
				<h2>Markalar</h2>
				<div class="inner">
					<a class="item" href="#"><img
						src="img/brands/1.png" alt="1" /></a> <a class="item"
						href="#"><img src="img/brands/1.png" alt="1" /></a> <a
						class="item" href="#"><img src="img/brands/1.png"
						alt="1" /></a> <a class="item" href="#"><img
						src="img/brands/1.png" alt="1" /></a> <a class="item"
						href="#"><img src="img/brands/1.png" alt="1" /></a> <a
						class="item" href="#"><img src="img/brands/1.png"
						alt="1" /></a> <a class="item" href="#"><img
						src="img/brands/1.png" alt="1" /></a>
				</div>
			</div>
		</section>
		<!--Brands Carousel Close-->

	</div>
	<!--Page Content Close-->

	<!--Sticky Buttons-->
	<div class="sticky-btns">
		<form  class="quick-contact" method="post" name="quick-contact">
			<h3>Contact us</h3>
			<p class="text-muted">Lorem ipsum dolor sit amet, consectetur
				adipisicing elit, sed do.</p>
			<div class="form-group">
				<label for="qc-name">Ad Soyad</label> <input
					class="form-control input-sm" type="text" name="qc-name"
					id="qc-name" placeholder="Enter full name" required>
			</div>
			<div class="form-group">
				<label for="qc-email">Mail adresi</label> <input
					class="form-control input-sm" type="email" name="qc-email"
					id="qc-email" placeholder="Enter email" required>
			</div>
			<div class="form-group">
				<label for="qc-message">Mesajınız</label>
				<textarea class="form-control input-sm" name="qc-message"
					id="qc-message" placeholder="Enter your message" required></textarea>
			</div>
			<input class="btn btn-black btn-sm btn-block" type="submit"
				value="Send">
		</form>
		<span id="qcf-btn"><i class="fa fa-envelope"></i></span> <span
			id="scrollTop-btn"><i class="fa fa-chevron-up"></i></span>
	</div>
	<!--Sticky Buttons Close-->

	<!--Subscription Widget-->
	<section class="subscr-widget gray-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 col-md-8 col-sm-8">
					<h2>Ürünler hakkında bilgi almak için üye olun.</h2>
					<form class="subscr-form" role="form" autocomplete="off">
						<div class="form-group">
							<label class="sr-only" for="subscr-name">Adınız</label> <input
								type="text" class="form-control" name="subscr-name"
								id="subscr-name" placeholder="Enter name" required>
							<button class="subscr-next">
								<i class="icon-arrow-right"></i>
							</button>
						</div>
						<div class="form-group fff" style="display: none">
							<label class="sr-only" for="subscr-email">Mail adresiniz</label> <input
								type="email" class="form-control" name="subscr-email"
								id="subscr-email" placeholder="Enter email" required>
							<button type="submit" id="subscr-submit">
								<i class="icon-check"></i>
							</button>
						</div>
					</form>
					<p class="p-style2">Lütfen devam etmeden önce alanı doldurunuz.</p>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-lg-offset-1">
					<p class="p-style3">Get more followers. In case of high quality
						newsletters the customers return rate can increase up to 20%! Have
						you already estimated your possible income? We took that into
						account and created a decent subscription form.</p>
				</div>
			</div>
		</div>
	</section>
	<!--Subscription Widget Close-->

	

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
	
	
	
	<!--Telefon mask ve Şifre kontrol-->
	<script type="text/javascript" src="js/input-mask/jquery.mask.min.js"></script>
	<script type="text/javascript" src="js/input-mask/mask.js"></script>
	<script src="js/input-mask/password.js"></script>



</body>
<!--Body Close-->
</html>