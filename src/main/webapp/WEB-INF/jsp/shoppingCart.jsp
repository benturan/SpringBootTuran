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
<body>




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

		<!--Breadcrumbs-->
		<ol class="breadcrumb">
			<li><a href="index.html">Anasayfa</a></li>
			<li>Alışveriş Sepeti</li>
		</ol>
		<!--Breadcrumbs Close-->

		<!--Shopping Cart-->
		<section class="shopping-cart">
			<div class="container">
				<div class="row">

					<!--Items List-->
					<div class="col-lg-9 col-md-9">
						<h2 class="title">Alışveriş Sepeti</h2>
						<table class="items-list">
							<tr>
								<th>&nbsp;</th>
								<th>Ürün Adı</th>
								<th>Fiyatı</th>
								<th>Miktar</th>
								<th>Toplam</th>
							</tr>



									<c:forEach items="${cartItemList}" var="cartItem">
								<tr class="item">
									
								
									<input type="hidden" id="ProductPrice" value="${cartItem.price}" />
									<input type="hidden" id="productName" value="${cartItem.productName}" />
									<input type="hidden" id="productImage" value="${cartItem.image}" />
									<input type="hidden" id="productTax" value="${cartItem.tax}" />
									
									<td class="thumb"><a href="urundetay${cartItem.productId}">
											<!-- <img src="/img/catalog/${cartItem.image}" alt="${cartItem.productName}" /> -->
											<img src="${cartItem.image}" alt="${cartItem.productName}" />
									</a></td>
									<td class="name"><a href="urundetay${cartItem.productId}">${cartItem.productName}</a></td>
									
									<td class="price">${cartItem.price}TL</td>								
									<td class="qnt-count"><a class="incr-btn" href="#" onclick="azalt(${cartItem.productId});">-</a> <input
										class="quantity form-control" type="text" id="quantityText" value="${cartItem.productQuantity}"> <a
										class="incr-btn" href="#" onclick="gonder(${cartItem.productId});">+</a>											
										
										</td>
									<td class="total">${cartItem.lineTotalAmount}TL</td>
									<td class="delete" href="#" onclick="Confirimdeletecart(${cartItem.productId});"><i class="icon-delete"></i></td>
									
									
									
									
									
										
										<script>

										// Sil butonuna tıklandığında onay tekrar onay almak için
										function Confirimdeletecart(adress_id)
										{
										  var x = confirm("Silmek istediginizden emin misiniz?");
										  if (x)
										    return  deletecart(adress_id);
										  else
										    return false;
										}								


										//Confirimdeletecart Onay verildiginde silmek için
										function deletecart(product_id)	{
											
									   
										$.ajax('/deleteCart', {
										    type: 'POST',  // http method
										    data: { product_id: product_id},
										    success: function (data, status, xhr) {
										        //$('p').append('status: ' + status + ', data: ' + data);
										        window.location.href = '/getShoppingCart';
										    },
										    error: function (jqXhr, textStatus, errorMessage) {
										            $('p').append('Error' + errorMessage);
										    }
										});
										}								
																			function gonder(product_id)
										{
									    var quan = "1";
									    var pPrice =  $('#ProductPrice').val();
									    var pName = $('#productName').val();
									    var pImage = $('#productImage').val();
									    var pTax = $('#productTax').val();
										$.ajax('/updateCartIncrease', {
										    type: 'POST',  // http method
										    data: { product_id: product_id,quantity: quan,price: pPrice, productName: pName, productImage: pImage, productTax: pTax},
										    success: function (data, status, xhr) {
										        //$('p').append('status: ' + status + ', data: ' + data);
										        window.location.href = '/getShoppingCart';
										    },
										    error: function (jqXhr, textStatus, errorMessage) {
										            $('p').append('Error' + errorMessage);
										    }
										});
										}
										</script>
										
										<script>
										function azalt(product_id)
										{
									    var quan = "-1";
									    var pPrice =  $('#ProductPrice').val();
									    var pName = $('#productName').val();
									    var pImage = $('#productImage').val();
									    var pTax = $('#productTax').val();
										$.ajax('/updateCartIncrease', {
										    type: 'POST',  // http method
										    data: { product_id: product_id,quantity: quan,price: pPrice, productName: pName, productImage: pImage, productTax: pTax},
										    success: function (data, status, xhr) {
										        //$('p').append('status: ' + status + ', data: ' + data);
										        window.location.href = '/getShoppingCart';
										    },
										    error: function (jqXhr, textStatus, errorMessage) {
										            $('p').append('Error' + errorMessage);
										    }
										});
										}
										</script>
	
																		
								</tr>
							</c:forEach>
						</table>
					</div>

					<!--Sidebar-->
					<div class="col-lg-3 col-md-3">
						<h3>Sepet Toplamı</h3>
						<form class="cart-sidebar"  action="/checkoutAllCart" method="post">
							<div class="cart-totals">
								<table>
									<tr>
										<td>Sepet Alt Toplamı</td>
										<td class="total align-r">${totalAmount} TL</td>
									</tr>
									<tr class="devider">
										<td>KDV</td>
										<td class="align-r">${totalTax}</td>
									</tr>
									<tr class="devider">
										<td>Kargo</td>
										<td class="align-r">Ücretsiz Kargo</td>
									</tr>
									<tr>
										<td>Genel Toplam</td>
										<td class="total align-r">${GeneralTotal} TL</td>
									</tr>
								</table>
<!--  
								<h3>Kupon Kodunuz Var mı?</h3>
								<div class="coupon">
									<div class="form-group">
										<label class="sr-only" for="coupon-code">Kupon Kodunu
											Giriniz</label> <input type="text" class="form-control"
											id="coupon-code" name="coupon-code"
											placeholder="Enter coupon code">
									</div>
									<input type="submit" class="btn btn-primary btn-sm btn-block"
										name="apply-coupon" value="Apply coupon">
								</div>
								-->
<!--  
								<input type="submit" class="btn btn-primary btn-sm btn-block"
									name="update-cart" value="Update shopping cart">-->
									 <input
									type="submit" class="btn btn-black btn-block"
									name="to-checkout" value="Siparişi Tamamla">
							</div>
<!--  
							<a class="panel-toggle" href="#calc-shipping"><h3>Calculate
									shipping</h3></a>
							<div class="hidden-panel calc-shipping" id="calc-shipping">
								<div class="form-group">
									<div class="select-style">
										<select name="country">
											<option>Australia</option>
											<option>Belgium</option>
											<option>Germany</option>
											<option>United Kingdom</option>
											<option>Switzerland</option>
											<option>USA</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="sr-only" for="state">State/ province</label> <input
										type="text" class="form-control" id="state" name="state"
										placeholder="State/ province">
								</div>
								<div class="form-group">
									<label class="sr-only" for="postcode">Postcode/ ZIP</label> <input
										type="text" class="form-control" id="postcode" name="postcode"
										placeholder="Postcode/ ZIP">
								</div>
								<input type="submit" class="btn btn-primary btn-sm btn-block"
									name="update-totals" value="Update totals">
							</div>-->
						</form>
					</div>
				</div>
			</div>
		</section>
		<!--Shopping Cart Close-->

		<!--Catalog Grid-->
		<section class="catalog-grid">
			<div class="container">
				<h2>You may also like</h2>
				<div class="row">
					<!--Tile-->
					<div class="col-lg-3 col-md-4 col-sm-6">
						<div class="tile">
							<div class="price-label">715,00 $</div>
							<a href="#"> <img src="img/catalog/1.png" alt="1" /> <span
								class="tile-overlay"></span>
							</a>
							<div class="footer">
								<a href="#">The Buccaneer</a> <span>by Pirate3d</span>
								<button class="btn btn-primary">Add to Cart</button>
							</div>
						</div>
					</div>
					<!--Tile-->
					<div class="col-lg-3 col-md-4 col-sm-6">
						<div class="tile">
							<div class="price-label">715,00 $</div>
							<a href="#"> <img src="img/catalog/1.png" alt="1" /> <span
								class="tile-overlay"></span>
							</a>
							<div class="footer">
								<a href="#">The Buccaneer</a> <span>by Pirate3d</span>
								<button class="btn btn-primary">Add to Cart</button>
							</div>
						</div>
					</div>
					<!--Tile-->
					<div class="col-lg-3 col-md-4 col-sm-6">
						<div class="tile">
							<div class="price-label">715,00 $</div>
							<a href="#"> <img src="img/catalog/1.png" alt="1" /> <span
								class="tile-overlay"></span>
							</a>
							<div class="footer">
								<a href="#">The Buccaneer</a> <span>by Pirate3d</span>
								<button class="btn btn-primary">Add to Cart</button>
							</div>
						</div>
					</div>
					<!--Tile-->
					<div class="col-lg-3 col-md-4 col-sm-6">
						<div class="tile">
							<div class="price-label">715,00 $</div>
							<a href="#"> <img src="img/catalog/1.png" alt="1" /> <span
								class="tile-overlay"></span>
							</a>
							<div class="footer">
								<a href="#">The Buccaneer</a> <span>by Pirate3d</span>
								<button class="btn btn-primary">Add to Cart</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--Catalog Grid Close-->

		<!--Brands Carousel Widget-->
		<section class="brand-carousel">
			<div class="container">
				<h2>Brands in our shop</h2>
				<div class="inner">
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
					<a class="item" href="#"><img src="img/brands/1.png" alt="1" /></a>
				</div>
			</div>
		</section>
		<!--Brands Carousel Close-->

	</div>
	<!--Page Content Close-->

	<!--Sticky Buttons-->
	<div class="sticky-btns">
		<form class="quick-contact" method="post" name="quick-contact">
			<h3>Contact us</h3>
			<p class="text-muted">Lorem ipsum dolor sit amet, consectetur
				adipisicing elit, sed do.</p>
			<div class="form-group">
				<label for="qc-name">Full name</label> <input
					class="form-control input-sm" type="text" name="qc-name"
					id="qc-name" placeholder="Enter full name" required>
			</div>
			<div class="form-group">
				<label for="qc-email">Email</label> <input
					class="form-control input-sm" type="email" name="qc-email"
					id="qc-email" placeholder="Enter email" required>
			</div>
			<div class="form-group">
				<label for="qc-message">Your message</label>
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
					<h2>Subscribe to our news</h2>
					<form class="subscr-form" role="form" autocomplete="off">
						<div class="form-group">
							<label class="sr-only" for="subscr-name">Enter name</label> <input
								type="text" class="form-control" name="subscr-name"
								id="subscr-name" placeholder="Enter name" required>
							<button class="subscr-next">
								<i class="icon-arrow-right"></i>
							</button>
						</div>
						<div class="form-group fff" style="display: none">
							<label class="sr-only" for="subscr-email">Enter email</label> <input
								type="email" class="form-control" name="subscr-email"
								id="subscr-email" placeholder="Enter email" required>
							<button type="submit" id="subscr-submit">
								<i class="icon-check"></i>
							</button>
						</div>
					</form>
					<p class="p-style2">Please fill the field before continuing</p>
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



</body>
<!--Body Close-->
</html>
