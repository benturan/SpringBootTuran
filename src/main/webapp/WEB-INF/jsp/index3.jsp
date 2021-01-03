<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=windows-1254 "/>
<title>Limo - HTML5 E-Commerce Template</title>
<!--SEO Meta Tags-->
<meta name="description" content="Responsive HTML5 E-Commerce Template" />
<meta name="keywords"
	content="responsive html5 template, e-commerce, shop, bootstrap 3.0, css, jquery, flat, modern" />
<meta name="author" content="8Guild" />
<!--Mobile Specific Meta Tag-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!--Favicon-->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!--Master Slider Styles-->
<link href="masterslider/style/masterslider.css" rel="stylesheet"
	media="screen">
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
<body  >

	<!--Login Modal-->
	<jsp:include page="loginpopup.jsp"></jsp:include>
	<!-- /.modal -->

	<!--Header-->
	<header data-offset-top="500" data-stuck="600">
		<!--data-offset-top is when header converts to small variant and data-stuck when it becomes visible. Values in px represent position of scroll from top. Make sure there is at least 100px between those two values for smooth animation-->

		<!--Search Form-->
		<jsp:include page="searchBar.jsp"></jsp:include>

		<!--Mobile Menu Toggle-->
		<div class="menu-toggle">
			<i class="fa fa-list"></i>
		</div>

		<div class="container">
			<a class="logo" href="/allindex"><img src="img/logo-scheme4.png"
				alt="Limo" /></a>
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

		<!--Hero Slider-->
		<section class="hero-slider">
			<div class="master-slider" id="hero-slider">

				 	<c:forEach items="${mansetList}" var="manset">
					<div class="ms-slide" data-delay="7">
						<div class="overlay"></div>
						<img src="/masterslider/blank.gif"
						data-src="${manset.image}" alt="" />
							<!--data-src="/img/hero/slideshow/${manset.image}" alt="" />-->
						<h2 style="width: 456px; left: 110px; top: 110px;"
							class="dark-color ms-layer" data-effect="top(50,true)"
							data-duration="700" data-delay="250" data-ease="easeOutQuad">${manset.baslik}</h2>
						<p style="width: 456px; left: 110px; top: 210px;"
							class="dark-color ms-layer" data-effect="back(500)"
							data-duration="700" data-delay="500" data-ease="easeOutQuad">${manset.detay}</p>
						<div style="left: 110px; top: 300px;" class="ms-layer button"
							data-effect="left(50,true)" data-duration="500" data-delay="750"
							data-ease="easeOutQuad">
							<a class="btn btn-black" href="/filter${manset.categoryId}">Kataloğa
								Git</a>
						</div>
						<div style="left: 350px; top: 300px;" class="ms-layer button"
							data-effect="bottom(50,true)" data-duration="700"
							data-delay="950" data-ease="easeOutQuad">
							<a class="btn btn-primary" href="/filter${manset.categoryId}">Katagorilere
								Gözat</a>
						</div>
					</div>
				</c:forEach>
				 

				<!--Slide 3-->
				 

			</div>
		</section>
		<!--Hero Slider Close-->

		<!--Categories-->
		<section class="cat-tiles">
			<div class="container">
				<h2>Katagorilere Gözat</h2>
				<div class="row">
				<div id="mainCategories"></div>
				
				</div>
			</div>
		</section>
		<!--Categories Close-->

		<!--Catalog Grid-->
		<section class="catalog-grid">
			<div class="container">
				<h2 class="dark-color">Katalog Seçimleri</h2>
				<div class="row">
				<div id="urunler"></div>
				</div>
			</div>
		</section>
		<!--Catalog Grid Close-->


		<!--Tabs Widget-->
		<section class="tabs-widget">
			<!-- Nav tabs -->

			<!--Çok satan ürünler-->
			<ul class="nav nav-tabs">
				<li class="active"><a href="#bestsel" data-toggle="tab">Çok
						Satan Ürünler</a></li>
				<li><a href="#onsale" data-toggle="tab">İndirimdeki Ürünler</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade in active" id="bestsel">
					<div class="container">
						<div class="row">

							<c:forEach items="${encoksatan}" var="product">

								<div class="col-lg-3 col-md-4 col-sm-${loopCounter.count}">

									<a class="media-link"
										href="getProductDetail${product.productID}">

										<div class="overlay">
											<div class="descr">
												<div>${product.name}<span>${product.price} TL</span>
												</div>
											</div>
										</div> <img src="${product.image}" alt="${loopCounter.count}" />
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="onsale">
					s
					<div class="container">
						<div class="row">

							<!--İndirimli Ürünler-->

							<c:forEach items="${indirimUrun}" var="product">
								<div class="col-lg-6 col-md-6 col-sm-6">
									<a class="media-link"
										href="getProductDetail${product.productID}">
										<div class="overlay">
											<div class="descr">
												<div>${product.name}<span>${product.price} TL</span>
												</div>
											</div>
										</div> <img src="${product.image}" alt="${loopCounter.count}" />
									</a>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
		</section>
		<!--Tabs Widget Close-->

		<!--Posts/Twitter Widget-->
		<section class="posts-widget">
			<div class="tw-bg"></div>
			<div class="container">
				<div class="row">
					<div class="latest-posts col-lg-8 col-md-8">
						<div class="row">
							<div class="col-lg-3">
								<h2 class="extra-bold">Son Favori</h2>
								<a class="btn btn-black btn-block" href="favoriler.html">Favoriler</a>
							</div>
							<div class="col-lg-9">
								<!--Post-->
								<div class="post row">
									<div class="col-lg-6 col-sm-6">
										<a href="#"><img src="img/posts-widget/1.png" alt="1" /></a>
									</div>
									<div class="col-lg-6 col-sm-6">
										<h3>
											<a href="#">An interesting post</a>
										</h3>
										<p>Write a blog to share with customers interesting facts
											about your products. Make them curious and you'll get
											co-operation. Just try it!</p>
										<div class="author">
											<i class="fa fa-user"></i><a href="#">By Resoursa</a>
										</div>
										<div class="comments">
											<i class="fa fa-comment"></i><a href="#">Comments (34)</a>
										</div>
									</div>
								</div>
								<!--Post End-->
								<!--Post-->
								<div class="post row">
									<div class="col-lg-6 col-sm-6">
										<a href="#"><img src="img/posts-widget/2.png" alt="2" /></a>
									</div>
									<div class="col-lg-6 col-sm-6">
										<h3>
											<a href="#">Review post</a>
										</h3>
										<p>You probably know that giving more details is the best
											way to provide info about a product. Write reviews, take
											high-quality pictures, and that will definitely boost the
											sales.</p>
										<div class="author">
											<i class="fa fa-user"></i><a href="#">By Jeddah</a>
										</div>
										<div class="comments">
											<i class="fa fa-comment"></i><a href="#">Comments (101)</a>
										</div>
									</div>
								</div>
								<!--Post End-->
							</div>
						</div>
					</div>
					<div class="twitter-feed col-lg-4 col-md-4">
						<a class="tw-follow" href="https://twitter.com/8Guild"
							target="_blank">
							<div class="button">
								Follow us<i class="fa fa-twitter"></i>
							</div>
							<h2 class="extra-bold">
								On Twitter <i class="fa fa-twitter"></i>
							</h2>
						</a>
						<!--Tweet-->
						<div class="tweet">
							<a href="#">@Resoursa</a>
							<p class="p-style3">Uberly impressed with the AMAZING support
								I constantly get from awesome!!!</p>
							<div class="group">
								<div class="actions">
									<a href="#">Reply</a> <a href="#">Retweet</a> <a href="#">Favorite</a>
								</div>
								<span class="date">5 Mar 2014</span>
							</div>
						</div>
						<!--Tweet Close-->
						<!--Tweet-->
						<div class="tweet">
							<a href="#">@Resoursa</a>
							<p class="p-style3">Uberly impressed with the AMAZING support
								I constantly get from awesome!!!</p>
							<div class="group">
								<div class="actions">
									<a href="#">Reply</a> <a href="#">Retweet</a> <a href="#">Favorite</a>
								</div>
								<span class="date">5 Mar 2014</span>
							</div>
						</div>
						<!--Tweet Close-->
					</div>
				</div>
			</div>
		</section>

		<!--Gallery Widget-->
		<section class="white-bg gallery-widget">
			<div class="container">
				<h2>Ürün Galerisi</h2>
				<div class="filters">
					<a class="active" href="#" data-group="Tüm Ürünler">All</a> <a
						href="#" data-group="City bags">Çanta</a> <a href="#"
						data-group="Gloves">Eldiven</a> <a href="#" data-group="Belts">Kemer</a>
					<a href="#" data-group="video">Fermuar</a>
				</div>
				<div class="gallery-grid">
					<!--Item-->
					<div class="gallery-item" data-groups='["City bags"]'
						data-src="img/gallery-widget/1.png">
						<a href="img/gallery-widget/1.png">
							<div class="overlay">
								<span><i class="icon-expand"></i></span>
							</div> <img src="img/gallery-widget/1.png" alt="1" />
						</a>
					</div>
					<!--Item-->
					<div class="gallery-item" data-groups='["City bags"]'
						data-src="img/gallery-widget/2.png">
						<a href="/resources/img/gallery-widget/2.png">
							<div class="overlay">
								<span><i class="icon-expand"></i></span>
							</div> <img src="img/gallery-widget/2.png" alt="2" />
						</a>
					</div>
					<!--Item-->
					<div class="gallery-item" data-groups='["video"]'
						data-src="https://www.youtube.com/watch?v=AZ3AVR7VnqA">
						<a href="https://www.youtube.com/watch?v=hdEAWW7tZSA">
							<div class="overlay">
								<span><i class="icon-music-play"></i></span>
							</div> <img src="img/gallery-widget/3.png" alt="3" />
						</a>
					</div>
					<!--Item-->
					<div class="gallery-item" data-groups='["Belts"]'
						data-src="img/gallery-widget/4.png">
						<a href="img/gallery-widget/4.png">
							<div class="overlay">
								<span><i class="icon-expand"></i></span>
							</div> <img src="img/gallery-widget/4.png" alt="4" />
						</a>
					</div>
					<!--Item-->
					<div class="gallery-item" data-groups='["Gloves"]'
						data-src="img/gallery-widget/5.png">
						<a href="img/gallery-widget/5.png">
							<div class="overlay">
								<span><i class="icon-expand"></i></span>
							</div> <img src="img/gallery-widget/5.png" alt="5" />
						</a>
					</div>
					<!--Item-->
					<div class="gallery-item" data-groups='["Gloves"]'
						data-src="img/gallery-widget/5.png">
						<a href="img/gallery-widget/6.png">
							<div class="overlay">
								<span><i class="icon-expand"></i></span>
							</div> <img src="img/gallery-widget/6.png" alt="6" />
						</a>
					</div>
				</div>
			</div>
		</section>
		<!--Gallery Widget Close-->

		<!--Brands Carousel Widget-->
		<section class="brand-carousel">
			<div class="container">
				<h2>Markalar</h2>
				<div class="inner">
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/2.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/3.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/4.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/5.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/6.png" alt="1" /></a>
				</div>
			</div>
		</section>
		<!--Brands Carousel Close-->

	</div>
	<!--Page Content Close-->

	<!--Sticky Buttons-->
	<jsp:include page="sticky.jsp"></jsp:include><!--Sticky Buttons Close-->

	<!--Subscription Widget-->
	<section class="subscr-widget gray-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 col-md-8 col-sm-8">
					<h2>Ürünler hakkında bilgi almak için üye olun.</h2>
					<form class="subscr-form" role="form" autocomplete="off">
						<div class="form-group">
							<label class="sr-only" for="subscr-name">Adınız
								Soyadınız:</label> <input type="text" class="form-control"
								name="subscr-name" id="subscr-name"
								placeholder="Adınız Soyadınız." required>
							<button class="subscr-next">
								<i class="icon-arrow-right"></i>
							</button>
						</div>
						<div class="form-group fff" style="display: none">
							<label class="sr-only" for="subscr-email">Email
								adresiniz:</label> <input type="email" class="form-control"
								name="subscr-email" id="subscr-email"
								placeholder="Email adresiniz." required>
							<button type="submit" id="subscr-submit">
								<i class="icon-check"></i>
							</button>
						</div>
					</form>
					<p class="p-style2">Lütfen devam etmeden önce alanı doldurunuz.</p>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-lg-offset-1">
					<p class="p-style3"></p>
				</div>
			</div>
		</div>
	</section>
	<!--Subscription Widget Close-->

	<!--Footer Close-->
	<jsp:include page="altlinkler.jsp"></jsp:include>

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

<script>
    	$(document).ready(function() {
				
    		   var url1 = '/getAllProducts/';
               var url2 = '/getMainCategories/';
               
             //urunler baslangic
               $.when($.get(url1, function (response) {
  
               })).then(function (response) {
  
                   var len = response.length;
                   for(var i=0; i<len; i++){
                       var productID= response[i].productID;
                       var name = response[i].name;
                       var image = response[i].image;
                       var price = response[i].price;
                       var tax = response[i].tax;

                       var tr_str = '<div class="col-lg-3 col-md-4 col-sm-6">'+
                       '<div class="tile">'+
                       '<div class="badges">'+
                       '<span class="sale">Stokta Var</span>'+
                       '</div>">'+
                       '<div class="price-label">' + price + ' TL</div>'+ 
                       '<a href="getProductDetail'+productID+'"><img src="'  + image +'" /><span class="tile-overlay"></span> </a>'+
                       '<div class="footer"><a href="getProductDetail'+productID+'">'+name+'</a>'+ 
                       '<span>Anna Canara</span>'+ 
						'<form method="POST" action="/postCart">'+
						'<input type="hidden" name="action" value="addCart" >'+
						'<input type="hidden" name="productID" value="'+productID+'" >'+
						'<input type="hidden" name="productPrice" value="'+price+'" >'+
						'<input type="hidden" name="productName" value="'+name+'" >'+
						'<input type="hidden" name="productQuantity" value="1" >'+
						'<input type="hidden" name="productImage" value="'+image+'" >'+
						'<input type="hidden" name="productTax" value="'+tax+'" >'+
						'<button id="btnSepet" class="btn btn-primary">Sepete Ekle</button>'+
					    '</form>'+ 
                       '</div>'+
                       '</div>'+
                       '</div>';

             	  $("#urunler").append(tr_str);
                       
                   }
                    
               });

               // urunler bitis 
 

 




              
        	 
						});
					</script>

</body>
<!--Body Close-->
</html>
