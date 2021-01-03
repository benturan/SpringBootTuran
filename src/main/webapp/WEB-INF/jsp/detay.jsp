<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<li><a href="index.html">Home</a></li>
			<li><a href="shop-filters-left-3cols.html">Shop - filters
					left 3 cols</a></li>
			<li>Shop - single item v1</li>
		</ol>
		<!--Breadcrumbs Close-->

		<!--Shopping Cart Message-->
		<section class="cart-message">
			<i class="fa fa-check-square"></i>
			<p class="p-style3">"Nikon" was successfully added to your cart.</p>
			<a class="btn-outlined-invert btn-black btn-sm"
				href="shopping-cart.html">View cart</a>
		</section>
		<!--Shopping Cart Message Close-->

		<!--Catalog Single Item-->
		<section class="catalog-single">
			<div class="container">
				<div class="row">

					<!--Product Gallery-->
					<div class="col-lg-6 col-md-6">
						<div class="prod-gal master-slider" id="prod-gal">
							<!--Slide1-->



							<c:forEach items="${mediaList}" var="media">
								<div class="ms-slide">
									<img src="masterslider/blank.gif" data-src="${media[4]}"
										alt="${media[4]}" /> <img class="ms-thumb" src="${media[4]}"
										alt="thumb" />
								</div>

							</c:forEach>
						</div>
					</div>

					<!--Product Description-->
					<div class="col-lg-6 col-md-6">

						<!--<c:forEach items="${detail}" var="product">
            <h1>${product[3]}</h1>
            </c:forEach>-->
						<h1>${productDetail.name}</h1>
						<div class="old-price">${productDetail.oldPrice}TL</div>
						<div class="price">${productDetail.price}TL</div>
						<div class="buttons group">


							<form method="POST"
								action="/postCartDetay${productDetail.productID}">
								<input type="hidden" name="action" value="addCartDetay">
								<input type="hidden" name="productID"
									value="${productDetail.productID}"> <input
									type="hidden" name="productPrice"
									value="${productDetail.price}"> <input type="hidden"
									name="productName" value="${productDetail.name}"> <input
									type="hidden" name="productImage"
									value="${productDetail.image}"> <input type="hidden"
									name="productTax" value="${productDetail.tax}">

								<div class="qnt-count">
									<a class="incr-btn" href="#">-</a> <input id="quantity"
										class="form-control" type="text" name="productQuantity"
										value="1"> <a class="incr-btn" href="#">+</a>
								</div>
								<button class="btn btn-primary btn-sm">Sepete Ekle</button>
							</form>
	          
 
							<%!String userId = "";%>
							<%
								HttpSession onemliSayfa = request.getSession();

								userId = (String) onemliSayfa.getValue("UserId");
							%>
							<input type="hidden" id="user_id" name="user_id"
								value="<%=userId%>">


							<%
								if (userId == null) {

									out.write(
											"<button class=\"btn btn-black btn-sm\" data-toggle=\"modal\" data-target=\"#loginModal\">Favorilere Ekle</button>");
							%>

							<%
								} else {
							%>

							<form method="POST" action="/addFavoriteWeb">

								<input type="hidden" name="product_id"
									value="${productDetail.productID}">

								<%!String userId2 = "";%>
								<%
									HttpSession onemliSayfa2 = request.getSession();

										userId2 = (String) onemliSayfa2.getValue("UserId");
								%>
								<input type="hidden" name="user_id" value="<%=userId2%>">
								<button class="btn btn-black btn-sm">Favorilere Ekle</button>

							</form>



							<%
								}
							%>






						</div>
						<p class="p-style2">${productDetail.description}</p>
						<div class="row">
							<div class="col-lg-4 col-md-4 col-sm-5">
								<h3>Tell friends</h3>
								<div class="social-links">
									<a href="#"><i class="fa fa-tumblr-square"></i></a> <a href="#"><i
										class="fa fa-pinterest-square"></i></a> <a href="#"><i
										class="fa fa-facebook-square"></i></a>
								</div>
							</div>
							<div class="col-lg-8 col-md-8 col-sm-7">
								<h3>Tags</h3>
								<div class="tags">
									<a href="#">Backpack</a>, <a href="#">Chanel</a>, <a href="#">Wristlet</a>
								</div>
							</div>
						</div>
						<div class="promo-labels">
							<div
								data-content="This is a place for the unique commercial offer. Make it known.">
								<span><i class="fa fa-truck"></i>Free delivery</span>
							</div>
							<div
								data-content="This is a place for the unique commercial offer. Make it known.">
								<i class="fa fa-space-shuttle"></i>Deliver even on Mars
							</div>
							<div
								data-content="This is a place for the unique commercial offer. Make it known.">
								<i class="fa fa-shield"></i>Safe Buy
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--Catalog Single Item Close-->

		<!--Tabs Widget-->
		<section class="tabs-widget">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs">
				<li class="active"><a href="#specs" data-toggle="tab">Specs</a></li>
				<li><a href="#descr" data-toggle="tab">Description</a></li>
				<li><a href="#review" data-toggle="tab">Reviews</a></li>
			</ul>
			<div class="tab-content">
				<!--Tab1 (Specs)-->
				<div class="tab-pane fade in active" id="specs">
					<div class="container">
						<div class="row">
							<section class="tech-specs">
								<div class="container">
									<div class="row">
										<!--Column 1-->
										<div class="col-lg-6 col-md-6 col-sm-6">
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-dollar"></i><span>Best Price</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Affordable prices</p>
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-umbrella"></i><span>Materials</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Waterproof materials</p>
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-sort-numeric-asc"></i><span>City
															bags</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Any size</p>
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-smile-o"></i><span>Mentions</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Give a smile</p>
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-recycle"></i><span>Eco activity</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Eco-friendly materials
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-4">
														<i class="fa fa-archive"></i><span>Package</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-8">
														<p class="p-style2">Individual packing</p>
													</div>
												</div>
											</div>
										</div>
										<!--Column 2-->
										<div class="col-lg-6 col-md-6 col-sm-6">
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-umbrella"></i><span>Materials</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Waterproof materials</p>
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-4">
														<i class="fa fa-archive"></i><span>Package</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-8">
														<p class="p-style2">Individual packing</p>
													</div>
												</div>
											</div>
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-smile-o"></i><span>Mentions</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Give a smile</p>
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-dollar"></i><span>Best Price</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Affordable prices</p>
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-recycle"></i><span>Eco activity</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Eco-friendly materials
													</div>
												</div>
											</div>
											<!--Item-->
											<div class="item">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-3">
														<i class="fa fa-sort-numeric-asc"></i><span>City
															bags</span>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-9">
														<p class="p-style2">Any size</p>
													</div>
												</div>
											</div>
											<!--Item-->
										</div>
									</div>
								</div>
							</section>
						</div>
					</div>
				</div>

				<!--Tab2 (Description)-->
				<div class="tab-pane fade" id="descr">
					<div class="container">
						<div class="row">
							<div class="col-lg-4 col-md-5 col-sm-5">
								<img class="center-block" src="img/posts-widget/1.jpg"
									alt="Description" />
							</div>
							<div class="col-lg-8 col-md-7 col-sm-7">
								<p class="p-style2">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit, sed do eiusmod tempor incididunt ut labore et
									dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
									exercitation ullamco laboris nisi ut aliquip ex ea commodo
									consequat. Duis aute irure dolor in reprehenderit in voluptate
									velit esse cillum dolore eu fugiat nulla pariatur. Excepteur
									sint occaecat cupidatat non proident, sunt in culpa qui officia
									deserunt mollit anim id est laborum. Sed ut perspiciatis unde
									omnis iste natus error sit voluptatem accusantium doloremque
									laudantium, totam rem aperiam, eaque ipsa quae ab illo
									inventore.</p>
								<div class="row">
									<div class="col-lg-3 col-md-4 col-sm-5 col-xs-6">
										<h4>Unordered list</h4>
										<ul>
											<li>List item</li>
											<li><a href="#">List item link</a></li>
											<li>List item</li>
										</ul>
									</div>
									<div class="col-lg-3 col-md-4 col-sm-5 col-xs-6">
										<h4>Ordered list</h4>
										<ol>
											<li>List item</li>
											<li><a href="#">List item link</a></li>
											<li>List item</li>
										</ol>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--Tab3 (Reviews)-->
				<div class="tab-pane fade" id="review">
					<div class="container">
						<div class="row">
							<!--Disqus Comments Plugin-->
							<div class="col-lg-10 col-lg-offset-1">
								<div id="disqus_thread"></div>
								<script type="text/javascript">
									/* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
									var disqus_shortname = '8guild'; // required: replace example with your forum shortname

									/* * * DON'T EDIT BELOW THIS LINE * * */
									(function() {
										var dsq = document
												.createElement('script');
										dsq.type = 'text/javascript';
										dsq.async = true;
										dsq.src = '//' + disqus_shortname
												+ '.disqus.com/embed.js';
										(document.getElementsByTagName('head')[0] || document
												.getElementsByTagName('body')[0])
												.appendChild(dsq);
									})();
								</script>
								<noscript>
									Please enable JavaScript to view the <a
										href="http://disqus.com/?ref_noscript">comments powered by
										Disqus.</a>
								</noscript>
								<a href="http://disqus.com" class="dsq-brlink">comments
									powered by <span class="logo-disqus">Disqus</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--Tabs Widget Close-->

		<!--Special Offer-->
		<section class="special-offer">
			<div class="container">
				<h2>Special offer</h2>
				<div class="row">
					<!--Tile-->
					<div class="col-lg-3 col-md-3 col-sm-3">
						<div class="tile">
							<div class="price-label">715,00 $</div>
							<a href="#"> <img src="img/offers/special-offer.png"
								alt="Special Offer" /> <span class="tile-overlay"></span>
							</a>
							<div class="footer">
								<a href="#">The Buccaneer</a>
							</div>
						</div>
					</div>
					<!--Plus-->
					<div class="col-lg-1 col-md-1 col-sm-1">
						<div class="sign">+</div>
					</div>
					<!--Tile-->
					<div class="col-lg-3 col-md-3 col-sm-3">
						<div class="tile">
							<div class="price-label">715,00 $</div>
							<a href="#"> <img src="img/offers/special-offer.png"
								alt="Special Offer" /> <span class="tile-overlay"></span>
							</a>
							<div class="footer">
								<a href="#">The Buccaneer</a>
							</div>
						</div>
					</div>
					<!--Equal-->
					<div class="col-lg-1 col-md-1 col-sm-1">
						<div class="sign">=</div>
					</div>
					<!--Offer-->
					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="offer">
							<h3 class="light-color">save</h3>
							<h4 class="text-primary">100,00 $</h4>
							<a class="btn btn-primary" href="#">Buy for 1200$</a>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--Special Offer Close-->

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
