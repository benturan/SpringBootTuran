<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<title>AbsoluteAdmin - A Responsive Bootstrap 3 Admin Dashboard
	Template</title>
<meta name="keywords"
	content="HTML5 Bootstrap 3 Admin Template UI Theme" />
<meta name="description"
	content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
<meta name="author" content="AbsoluteAdmin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Font CSS (Via CDN) -->
<link rel='stylesheet' type='text/css'
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700'>

<!-- Admin Forms CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/Admin/assets/admin-tools/admin-forms/css/admin-forms.css">

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/Admin/assets/skin/default_skin/css/theme.css">

<!-- Favicon -->
<link rel="shortcut icon" href="/resources/Admin/assets/img/favicon.ico">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->

</head>

<body class="ecom-products-page">

	<!-- Start: Theme Preview Pane -->
	<div id="skin-toolbox" class="hidden">
		<div class="panel">
			<div class="panel-heading">
				<span class="panel-icon"> <i class="fa fa-gear text-primary"></i>
				</span> <span class="panel-title"> Theme Options</span>
			</div>
			<div class="panel-body pn">

				<ul class="nav nav-list nav-list-sm pl15 pt10" role="tablist">
					<li class="active"><a href="#toolbox-header" role="tab"
						data-toggle="tab">Navbar</a></li>
					<li><a href="#toolbox-sidebar" role="tab" data-toggle="tab">Sidebar</a>
					</li>
					<li><a href="#toolbox-settings" role="tab" data-toggle="tab">Misc</a>
					</li>
				</ul>

				<div class="tab-content p20 ptn pb15">
					<div role="tabpanel" class="tab-pane active" id="toolbox-header">
						<form id="toolbox-header-skin">
							<h4 class="mv20">Header Skins</h4>

							<div class="skin-toolbox-swatches">
								<div class="checkbox-custom checkbox-disabled fill mb5">
									<input type="radio" name="headerSkin" id="headerSkin8" checked
										value="bg-light"> <label for="headerSkin8">Light</label>
								</div>
								<div class="checkbox-custom fill checkbox-primary mb5">
									<input type="radio" name="headerSkin" id="headerSkin1"
										value="bg-primary"> <label for="headerSkin1">Primary</label>
								</div>
								<div class="checkbox-custom fill checkbox-info mb5">
									<input type="radio" name="headerSkin" id="headerSkin3"
										value="bg-info"> <label for="headerSkin3">Info</label>
								</div>
								<div class="checkbox-custom fill checkbox-warning mb5">
									<input type="radio" name="headerSkin" id="headerSkin4"
										value="bg-warning"> <label for="headerSkin4">Warning</label>
								</div>
								<div class="checkbox-custom fill checkbox-danger mb5">
									<input type="radio" name="headerSkin" id="headerSkin5"
										value="bg-danger"> <label for="headerSkin5">Danger</label>
								</div>
								<div class="checkbox-custom fill checkbox-alert mb5">
									<input type="radio" name="headerSkin" id="headerSkin6"
										value="bg-alert"> <label for="headerSkin6">Alert</label>
								</div>
								<div class="checkbox-custom fill checkbox-system mb5">
									<input type="radio" name="headerSkin" id="headerSkin7"
										value="bg-system"> <label for="headerSkin7">System</label>
								</div>
								<div class="checkbox-custom fill checkbox-success mb5">
									<input type="radio" name="headerSkin" id="headerSkin2"
										value="bg-success"> <label for="headerSkin2">Success</label>
								</div>
								<div class="checkbox-custom fill mb5">
									<input type="radio" name="headerSkin" id="headerSkin9"
										value="bg-dark"> <label for="headerSkin9">Dark</label>
								</div>
							</div>
						</form>
					</div>
					<div role="tabpanel" class="tab-pane" id="toolbox-sidebar">
						<form id="toolbox-sidebar-skin">

							<h4 class="mv20">Sidebar Skins</h4>
							<div class="skin-toolbox-swatches">
								<div class="checkbox-custom fill mb5">
									<input type="radio" name="sidebarSkin" checked
										id="sidebarSkin3" value=""> <label for="sidebarSkin3">Dark</label>
								</div>
								<div class="checkbox-custom fill checkbox-disabled mb5">
									<input type="radio" name="sidebarSkin" id="sidebarSkin1"
										value="sidebar-light"> <label for="sidebarSkin1">Light</label>
								</div>
								<div class="checkbox-custom fill checkbox-light mb5">
									<input type="radio" name="sidebarSkin" id="sidebarSkin2"
										value="sidebar-light light"> <label for="sidebarSkin2">Lighter</label>
								</div>

							</div>

						</form>
					</div>
					<div role="tabpanel" class="tab-pane" id="toolbox-settings">
						<form id="toolbox-settings-misc">
							<h4 class="mv20 mtn">Layout Options</h4>
							<div class="form-group">
								<div class="checkbox-custom fill mb5">
									<input type="checkbox" checked="" id="header-option"> <label
										for="header-option">Fixed Header</label>
								</div>
							</div>
							<div class="form-group">
								<div class="checkbox-custom fill mb5">
									<input type="checkbox" checked="" id="sidebar-option">
									<label for="sidebar-option">Fixed Sidebar</label>
								</div>
							</div>
							<div class="form-group">
								<div class="checkbox-custom fill mb5">
									<input type="checkbox" id="breadcrumb-option"> <label
										for="breadcrumb-option">Fixed Breadcrumbs</label>
								</div>
							</div>
							<div class="form-group">
								<div class="checkbox-custom fill mb5">
									<input type="checkbox" id="breadcrumb-hidden"> <label
										for="breadcrumb-hidden">Hide Breadcrumbs</label>
								</div>
							</div>
							<h4 class="mv20">Layout Options</h4>
							<div class="form-group">
								<div class="radio-custom mb5">
									<input type="radio" id="fullwidth-option" checked
										name="layout-option"> <label for="fullwidth-option">Fullwidth
										Layout</label>
								</div>
							</div>
							<div class="form-group mb20">
								<div class="radio-custom radio-disabled mb5">
									<input type="radio" id="boxed-option" name="layout-option"
										disabled> <label for="boxed-option">Boxed
										Layout <b class="text-muted">(Coming Soon)</b>
									</label>
								</div>
							</div>

						</form>
					</div>
				</div>
				<div class="form-group mn br-t p15">
					<a href="#" id="clearLocalStorage"
						class="btn btn-primary btn-block pb10 pt10">Clear LocalStorage</a>
				</div>

			</div>
		</div>
	</div>
	<!-- End: Theme Preview Pane -->

	<!-- Start: Main -->
	<div id="main">

		<!-- Start: Header -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- End: Header -->

		<!-- Start: Sidebar -->
		<aside id="sidebar_left" class="nano nano-light affix">

			<!-- Start: Sidebar Left Content -->
			<div class="sidebar-left-content nano-content">

				<!-- Start: Sidebar Header -->
				<header class="sidebar-header">

					<!-- Sidebar Widget - Author -->
					<!-- Sidebar Widget - Author -->
					<div class="sidebar-widget author-widget">
						<div class="media">
							<a class="media-left" href="#"> <img
								src="/resources/Admin/assets/img/avatars/3.jpg"
								class="img-responsive">
							</a>
							<div class="media-body">

								<div class="media-author">Ibrahim Gokyar</div>
							</div>
						</div>
					</div>



				</header>
				<!-- End: Sidebar Header -->

				<!-- Start: Sidebar Menu -->
				<jsp:include page="sollinkler.jsp"></jsp:include>
				<!-- End: Sidebar Menu -->

				<!-- Start: Sidebar Collapse Button -->
				<div class="sidebar-toggle-mini">
					<a href="#"> <span class="fa fa-sign-out"></span>
					</a>
				</div>
				<!-- End: Sidebar Collapse Button -->

			</div>
			<!-- End: Sidebar Left Content -->

		</aside>

		<!-- Start: Content-Wrapper -->
		<section id="content_wrapper">

			<!-- Start: Topbar-Dropdown -->
			<div id="topbar-dropmenu" class="alt">
				<div class="topbar-menu row">
					<div class="col-xs-4 col-sm-2">
						<a href="#" class="metro-tile bg-primary light"> <span
							class="glyphicon glyphicon-inbox text-muted"></span> <span
							class="metro-title">Messages</span>
						</a>
					</div>
					<div class="col-xs-4 col-sm-2">
						<a href="#" class="metro-tile bg-info light"> <span
							class="glyphicon glyphicon-user text-muted"></span> <span
							class="metro-title">Users</span>
						</a>
					</div>
					<div class="col-xs-4 col-sm-2">
						<a href="#" class="metro-tile bg-success light"> <span
							class="glyphicon glyphicon-headphones text-muted"></span> <span
							class="metro-title">Support</span>
						</a>
					</div>
					<div class="col-xs-4 col-sm-2">
						<a href="#" class="metro-tile bg-system light"> <span
							class="glyphicon glyphicon-facetime-video text-muted"></span> <span
							class="metro-title">Videos</span>
						</a>
					</div>
					<div class="col-xs-4 col-sm-2">
						<a href="#" class="metro-tile bg-warning light"> <span
							class="fa fa-gears text-muted"></span> <span class="metro-title">Settings</span>
						</a>
					</div>
					<div class="col-xs-4 col-sm-2">
						<a href="#" class="metro-tile bg-alert light"> <span
							class="glyphicon glyphicon-picture text-muted"></span> <span
							class="metro-title">Pictures</span>
						</a>
					</div>
				</div>
			</div>
			<!-- End: Topbar-Dropdown -->

			<!-- Start: Topbar -->
			<header id="topbar" class="ph10">
				<div class="topbar-left">
					<ul class="nav nav-list nav-list-topbar pull-left">
						<li><a href="/Admin/adminallindex">Dashboard</a></li>
						<li><a href="/Admin/adminallproducts">Urunler</a></li>
						<li><a href="/Admin/adminallorders">Siparisler</a></li>
						<li><a href="/Admin/adminallusers">Uyeler</a></li>
						<li class="active"><a href="/Admin/adminallcategories">Kategoriler</a>
						</li>
					</ul>
				</div>

			</header>
			<!-- End: Topbar -->

			<!-- Begin: Content -->
			<section id="content" class="table-layout animated fadeIn">

				<!-- begin: .tray-center -->
				<div class="tray tray-center">

					<!-- create new order panel -->
					<div class="panel mb25 mt5">
						<div class="panel-heading">
							<span class="panel-title hidden-xs">Kategori Ekle</span>
							<ul class="nav panel-tabs-border panel-tabs">

								<li class="active"><a href="#tab1_2" data-toggle="tab">Detay</a>
								</li>
							</ul>
						</div>
						<div class="panel-body p20 pb10">
							<div class="tab-content pn br-n admin-form">

								<div id="tab1_2" class="tab-pane active">

									<div class="section row">
										<div class="col-md-12">
											<label for="product-category" class="field select"> <select
												id="product-category" name="product-category"
												OnChange="getCategories()">
													<option value="0" selected="selected">Ana Kategori</option>
													<c:forEach items="${parentcategory}" var="parent">
														<option value="${parent.categoryid }">${parent.categoryname}</option>
													</c:forEach>
											</select> <i class="arrow double"></i>
											</label>
										</div>
										<!-- end section -->

										<br />

										<div class="col-md-12">
											<label class="field select"> <select
												id="product-status" name="product-status"
												OnChange="getCategories2()">
													<option value="0" selected="selected">Alt Kategori</option>
											</select> <i class="arrow double"></i>
											</label>
										</div>

										<br />

										<div class="col-md-12">
											<label class="field select"> <select
												id="product-status2" name="product-status2">
													<option value="0" selected="selected">Alt
														Kategori2</option>
											</select> <i class="arrow double"></i>
											</label>
										</div>
										<!-- end section -->

									</div>
									<!-- end section row section -->

									<div class="section row">
										<div class="col-md-4">
											<label for="product-price" class="field prepend-icon">
												<input type="text" name="product-price" id="product-price"
												class="gui-input" placeholder="Product Price..."> <label
												for="product-price" class="field-icon"> <i
													class="fa fa-usd"></i>
											</label>
											</label>
										</div>
										<!-- end section -->

										<div class="col-md-4">
											<label for="product-vendor" class="field prepend-icon">
												<input type="text" name="product-vendor" id="product-vendor"
												class="gui-input" placeholder="Vendor Source..."> <label
												for="product-vendor" class="field-icon"> <i
													class="fa fa-shopping-cart"></i>
											</label>
											</label>
										</div>
										<!-- end section -->

										<div class="col-md-4">
											<label for="product-sku" class="field prepend-icon">
												<input type="text" name="product-sku" id="product-sku"
												class="gui-input" placeholder="Product SKU..."> <label
												for="product-sku" class="field-icon"> <i
													class="fa fa-barcode"></i>
											</label>
											</label>
										</div>
										<!-- end section -->

									</div>
									<!-- end section row section -->

									<div class="section">
										<input id="tagsinput" type="text"
											value="Software, Adobe, Photoshop, Editor, Commercial">
									</div>
									<!-- end section row section -->

									<hr class="short alt">

									<div class="section row mbn">
										<div class="col-sm-8">
											<label class="field option mt10"> <input
												type="checkbox" name="info" checked> <span
												class="checkbox"></span>Save Customer <em
												class="small-text text-muted">- A Random Unique ID will
													be generated</em>
											</label>
										</div>
										<div class="col-sm-4">
											<p class="text-right">
												<button class="btn btn-primary" type="button">Save
													Order</button>
											</p>
										</div>
									</div>
									<!-- end section -->

								</div>
								<div id="tab1_3" class="tab-pane">

									<div class="section">
										<label for="lastaddr" class="field prepend-icon"> <input
											type="text" name="lastaddr" id="lastaddr" class="gui-input"
											placeholder="Street address 2"> <label for="lastaddr"
											class="field-icon"> <i class="fa fa-map-marker"></i>
										</label>
										</label>
									</div>
									<!-- end section -->

									<div class="section">
										<label class="field select"> <select id="location"
											name="location">
												<option value="">Select country...</option>
												<option value="AL">Albania</option>
												<option value="DZ">Algeria</option>
												<option value="AD">Andorra</option>
												<option value="AO">Angola</option>
												<option value="AI">Anguilla</option>
												<option value="AG">Antigua and Barbuda</option>
												<option value="AR">Argentina</option>
												<option value="AM">Armenia</option>
												<option value="AW">Aruba</option>
												<option value="AU">Australia</option>
												<option value="AT">Austria</option>
												<option value="AZ">Azerbaijan Republic</option>
												<option value="BS">Bahamas</option>
												<option value="BH">Bahrain</option>
												<option value="BB">Barbados</option>
												<option value="BE">Belgium</option>
												<option value="BZ">Belize</option>
												<option value="BJ">Benin</option>
												<option value="BM">Bermuda</option>
												<option value="BT">Bhutan</option>
												<option value="BO">Bolivia</option>
												<option value="BA">Bosnia and Herzegovina</option>
												<option value="BW">Botswana</option>
												<option value="BR">Brazil</option>
												<option value="BN">Brunei</option>
												<option value="BG">Bulgaria</option>
												<option value="BF">Burkina Faso</option>
												<option value="BI">Burundi</option>
												<option value="KH">Cambodia</option>
												<option value="CA">Canada</option>
												<option value="CV">Cape Verde</option>
												<option value="KY">Cayman Islands</option>
												<option value="TD">Chad</option>
												<option value="CL">Chile</option>
												<option value="C2">China Worldwide</option>
												<option value="CO">Colombia</option>
												<option value="KM">Comoros</option>
												<option value="CK">Cook Islands</option>
												<option value="CR">Costa Rica</option>
												<option value="HR">Croatia</option>
												<option value="CY">Cyprus</option>
												<option value="CZ">Czech Republic</option>
												<option value="CD">Democratic Republic of the Congo</option>
												<option value="DK">Denmark</option>
												<option value="DJ">Djibouti</option>
												<option value="DM">Dominica</option>
												<option value="DO">Dominican Republic</option>
												<option value="EC">Ecuador</option>
												<option value="EG">Egypt</option>
												<option value="SV">El Salvador</option>
												<option value="ER">Eritrea</option>
												<option value="EE">Estonia</option>
												<option value="ET">Ethiopia</option>
												<option value="FK">Falkland Islands</option>
												<option value="FO">Faroe Islands</option>
												<option value="FJ">Fiji</option>
												<option value="FI">Finland</option>
												<option value="FR">France</option>
												<option value="GF">French Guiana</option>
												<option value="PF">French Polynesia</option>
												<option value="GA">Gabon Republic</option>
												<option value="GM">Gambia</option>
												<option value="GE">Georgia</option>
												<option value="DE">Germany</option>
												<option value="GI">Gibraltar</option>
												<option value="GR">Greece</option>
												<option value="GL">Greenland</option>
												<option value="GD">Grenada</option>
												<option value="GP">Guadeloupe</option>
												<option value="GT">Guatemala</option>
												<option value="GN">Guinea</option>
												<option value="GW">Guinea Bissau</option>
												<option value="GY">Guyana</option>
												<option value="HN">Honduras</option>
												<option value="HK">Hong Kong</option>
												<option value="HU">Hungary</option>
												<option value="IS">Iceland</option>
												<option value="IN">India</option>
												<option value="ID">Indonesia</option>
												<option value="IE">Ireland</option>
												<option value="IL">Israel</option>
												<option value="IT">Italy</option>
												<option value="JM">Jamaica</option>
												<option value="JP">Japan</option>
												<option value="JO">Jordan</option>
												<option value="KZ">Kazakhstan</option>
												<option value="KE">Kenya</option>
												<option value="KI">Kiribati</option>
												<option value="KW">Kuwait</option>
												<option value="KG">Kyrgyzstan</option>
												<option value="LA">Laos</option>
												<option value="LV">Latvia</option>
												<option value="LS">Lesotho</option>
												<option value="LI">Liechtenstein</option>
												<option value="LT">Lithuania</option>
												<option value="LU">Luxembourg</option>
												<option value="MG">Madagascar</option>
												<option value="MW">Malawi</option>
												<option value="MY">Malaysia</option>
												<option value="MV">Maldives</option>
												<option value="ML">Mali</option>
												<option value="MT">Malta</option>
												<option value="MH">Marshall Islands</option>
												<option value="MQ">Martinique</option>
												<option value="MR">Mauritania</option>
												<option value="MU">Mauritius</option>
												<option value="YT">Mayotte</option>
												<option value="MX">Mexico</option>
												<option value="FM">Micronesia</option>
												<option value="MN">Mongolia</option>
												<option value="MS">Montserrat</option>
												<option value="MA">Morocco</option>
												<option value="MZ">Mozambique</option>
												<option value="NA">Namibia</option>
												<option value="NR">Nauru</option>
												<option value="NP">Nepal</option>
												<option value="NL">Netherlands</option>
												<option value="AN">Netherlands Antilles</option>
												<option value="NC">New Caledonia</option>
												<option value="NZ">New Zealand</option>
												<option value="NI">Nicaragua</option>
												<option value="NE">Niger</option>
												<option value="NU">Niue</option>
												<option value="NF">Norfolk Island</option>
												<option value="NO">Norway</option>
												<option value="OM">Oman</option>
												<option value="PW">Palau</option>
												<option value="PA">Panama</option>
												<option value="PG">Papua New Guinea</option>
												<option value="PE">Peru</option>
												<option value="PH">Philippines</option>
												<option value="PN">Pitcairn Islands</option>
												<option value="PL">Poland</option>
												<option value="PT">Portugal</option>
												<option value="QA">Qatar</option>
												<option value="CG">Republic of the Congo</option>
												<option value="RE">Reunion</option>
												<option value="RO">Romania</option>
												<option value="RU">Russia</option>
												<option value="RW">Rwanda</option>
												<option value="KN">Saint Kitts and Nevis Anguilla</option>
												<option value="PM">Saint Pierre and Miquelon</option>
												<option value="VC">Saint Vincent and Grenadines</option>
												<option value="WS">Samoa</option>
												<option value="SM">San Marino</option>
												<option value="ST">São Tomé and Príncipe</option>
												<option value="SA">Saudi Arabia</option>
												<option value="SN">Senegal</option>
												<option value="RS">Serbia</option>
												<option value="SC">Seychelles</option>
												<option value="SL">Sierra Leone</option>
												<option value="SG">Singapore</option>
												<option value="SK">Slovakia</option>
												<option value="SI">Slovenia</option>
												<option value="SB">Solomon Islands</option>
												<option value="SO">Somalia</option>
												<option value="ZA">South Africa</option>
												<option value="KR">South Korea</option>
												<option value="ES">Spain</option>
												<option value="LK">Sri Lanka</option>
												<option value="SH">St. Helena</option>
												<option value="LC">St. Lucia</option>
												<option value="SR">Suriname</option>
												<option value="SJ">Svalbard and Jan Mayen Islands</option>
												<option value="SZ">Swaziland</option>
												<option value="SE">Sweden</option>
												<option value="CH">Switzerland</option>
												<option value="TW">Taiwan</option>
												<option value="TJ">Tajikistan</option>
												<option value="TZ">Tanzania</option>
												<option value="TH">Thailand</option>
												<option value="TG">Togo</option>
												<option value="TO">Tonga</option>
												<option value="TT">Trinidad and Tobago</option>
												<option value="TN">Tunisia</option>
												<option value="TR">Turkey</option>
												<option value="TM">Turkmenistan</option>
												<option value="TC">Turks and Caicos Islands</option>
												<option value="TV">Tuvalu</option>
												<option value="UG">Uganda</option>
												<option value="UA">Ukraine</option>
												<option value="AE">United Arab Emirates</option>
												<option value="GB">United Kingdom</option>
												<option value="US">United States</option>
												<option value="UY">Uruguay</option>
												<option value="VU">Vanuatu</option>
												<option value="VA">Vatican City State</option>
												<option value="VE">Venezuela</option>
												<option value="VN">Vietnam</option>
												<option value="VG">Virgin Islands (British)</option>
												<option value="WF">Wallis and Futuna Islands</option>
												<option value="YE">Yemen</option>
												<option value="ZM">Zambia</option>
										</select> <i class="arrow double"></i>
										</label>
									</div>
									<!-- end section -->

									<div class="section row">
										<div class="col-md-3">
											<label for="zip" class="field prepend-icon"> <input
												type="text" name="zip" id="zip" class="gui-input"
												placeholder="Zip"> <label for="zip"
												class="field-icon"> <i class="fa fa-certificate"></i>
											</label>
											</label>
										</div>
										<!-- end section -->

										<div class="col-md-4">
											<label for="city" class="field prepend-icon"> <input
												type="text" name="city" id="city" class="gui-input"
												placeholder="City"> <label for="city"
												class="field-icon"> <i class="fa fa-building-o"></i>
											</label>
											</label>
										</div>
										<!-- end section -->

										<div class="col-md-5">
											<label for="states" class="field select"> <select
												id="states" name="states">
													<option value="">Choose state</option>
													<option value="AL">Alabama</option>
													<option value="AK">Alaska</option>
													<option value="AZ">Arizona</option>
													<option value="AR">Arkansas</option>
													<option value="CA">California</option>
													<option value="CO">Colorado</option>
													<option value="CT">Connecticut</option>
													<option value="DE">Delaware</option>
													<option value="DC">District Of Columbia</option>
													<option value="FL">Florida</option>
													<option value="GA">Georgia</option>
													<option value="HI">Hawaii</option>
													<option value="ID">Idaho</option>
													<option value="IL">Illinois</option>
													<option value="IN">Indiana</option>
													<option value="IA">Iowa</option>
													<option value="KS">Kansas</option>
													<option value="KY">Kentucky</option>
													<option value="LA">Louisiana</option>
													<option value="ME">Maine</option>
													<option value="MD">Maryland</option>
													<option value="MA">Massachusetts</option>
													<option value="MI">Michigan</option>
													<option value="MN">Minnesota</option>
													<option value="MS">Mississippi</option>
													<option value="MO">Missouri</option>
													<option value="MT">Montana</option>
													<option value="NE">Nebraska</option>
													<option value="NV">Nevada</option>
													<option value="NH">New Hampshire</option>
													<option value="NJ">New Jersey</option>
													<option value="NM">New Mexico</option>
													<option value="NY">New York</option>
													<option value="NC">North Carolina</option>
													<option value="ND">North Dakota</option>
													<option value="OH">Ohio</option>
													<option value="OK">Oklahoma</option>
													<option value="OR">Oregon</option>
													<option value="PA">Pennsylvania</option>
													<option value="RI">Rhode Island</option>
													<option value="SC">South Carolina</option>
													<option value="SD">South Dakota</option>
													<option value="TN">Tennessee</option>
													<option value="TX">Texas</option>
													<option value="UT">Utah</option>
													<option value="VT">Vermont</option>
													<option value="VA">Virginia</option>
													<option value="WA">Washington</option>
													<option value="WV">West Virginia</option>
													<option value="WI">Wisconsin</option>
													<option value="WY">Wyoming</option>
											</select> <i class="arrow double"></i>
											</label>
										</div>
										<!-- end .col8 section -->

									</div>
									<!-- end section row section -->

									<div class="section row mbn">
										<div class="col-sm-8">
											<label class="field option mt10"> <input
												type="checkbox" name="info" checked> <span
												class="checkbox"></span>Save Customer <em
												class="small-text text-muted">- A Random Unique ID will
													be generated</em>
											</label>
										</div>
										<div class="col-sm-4">
											<p class="text-right">
												<button class="btn btn-primary" type="button">Save
													Order</button>
											</p>
										</div>
									</div>
									<!-- end section -->


								</div>
							</div>
						</div>
					</div>

					<!-- recent orders table -->
					<div class="panel">
						<div class="panel-menu p12 admin-form theme-primary">
							<div class="row">
								<div class="col-md-5">
									<label class="field select"> <select
										id="filter-category" name="filter-category">
											<option value="0">Filter by Category</option>
											<option value="1">Smart Phones</option>
											<option value="2">Smart Watches</option>
											<option value="3">Notebooks</option>
											<option value="4">Desktops</option>
											<option value="5">Music Players</option>
									</select> <i class="arrow"></i>
									</label>
								</div>
								<div class="col-md-5">
									<label class="field select"> <select id="filter-status"
										name="filter-status">
											<option value="0">Filter by Status</option>
											<option value="1">Active</option>
											<option value="2">Inactive</option>
											<option value="3">Low Stock</option>
											<option value="4">Out of Stock</option>
									</select> <i class="arrow"></i>
									</label>
								</div>
								<div class="col-md-2">
									<label class="field select"> <select id="bulk-action"
										name="bulk-action">
											<option value="0">Actions</option>
											<option value="1">Edit</option>
											<option value="2">Delete</option>
											<option value="3">Active</option>
											<option value="4">Inactive</option>
									</select> <i class="arrow double"></i>
									</label>
								</div>
							</div>
						</div>
						<div class="panel-body pn">
							<div class="table-responsive">
								<table class="table admin-form theme-warning tc-checkbox-1 fs13">
									<thead>
										<tr class="bg-light">
											<th class="text-center">Select</th>
											<th class="">Image</th>
											<th class="">Product Title</th>
											<th class="">SKU</th>
											<th class="">Price</th>
											<th class="">Stock</th>
											<th class="text-right">Status</th>

										</tr>
									</thead>
									<tbody>

										<c:forEach items="${adminproductlists}" var="product">
											<tr>
												<td class="text-center"><label class="option block mn">
														<input type="checkbox" name="mobileos" value="FR">
														<span class="checkbox mn"></span>
												</label></td>
												<td class="w100"><img
													class="img-responsive mw40 ib mr10" title="user"
													src="/resources/img/catalog/${product.image}"></td>
												<td class="">${product.name}</td>
												<td class="">#4132</td>
												<td class="">${product.price}TL</td>
												<td class="text-danger"><b>0 - Sold Out</b></td>
												<td class="text-right">
													<div class="btn-group text-right">
														<button type="button"
															class="btn btn-danger br2 btn-xs fs12 dropdown-toggle"
															data-toggle="dropdown" aria-expanded="false">
															Sold Out <span class="caret ml5"></span>
														</button>
														<ul class="dropdown-menu" role="menu">
															<li><a href="#">Edit</a></li>
															<li><a href="#">Delete</a></li>
															<li><a href="#">Archive</a></li>
															<li class="divider"></li>
															<li><a href="#">Complete</a></li>
															<li class="active"><a href="#">Pending</a></li>
															<li><a href="#">Canceled</a></li>
														</ul>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- end: .tray-center -->

				<!-- begin: .tray-right -->
				<aside class="tray tray-right tray290" data-tray-height="match">

				

				</aside>
				<!-- end: .tray-right -->

			</section>
			<!-- End: Content -->

		</section>

		<!-- Start: Right Sidebar -->
		<aside id="sidebar_right" class="nano affix">

			<!-- Start: Sidebar Right Content -->
			<div class="sidebar-right-content nano-content">

				<div class="tab-block sidebar-block br-n">
					<ul class="nav nav-tabs tabs-border nav-justified hidden">
						<li class="active"><a href="#sidebar-right-tab1"
							data-toggle="tab">Tab 1</a></li>
						<li><a href="#sidebar-right-tab2" data-toggle="tab">Tab 2</a>
						</li>
						<li><a href="#sidebar-right-tab3" data-toggle="tab">Tab 3</a>
						</li>
					</ul>
					<div class="tab-content br-n">
						<div id="sidebar-right-tab1" class="tab-pane active">

							<h5 class="title-divider text-muted mb20">
								Server Statistics <span class="pull-right"> 2013 <i
									class="fa fa-caret-down ml5"></i>
								</span>
							</h5>
							<div class="progress mh5">
								<div class="progress-bar progress-bar-primary"
									role="progressbar" aria-valuenow="45" aria-valuemin="0"
									aria-valuemax="100" style="width: 44%">
									<span class="fs11">DB Request</span>
								</div>
							</div>
							<div class="progress mh5">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"
									style="width: 84%">
									<span class="fs11 text-left">Server Load</span>
								</div>
							</div>
							<div class="progress mh5">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="45" aria-valuemin="0"
									aria-valuemax="100" style="width: 61%">
									<span class="fs11 text-left">Server Connections</span>
								</div>
							</div>

							<h5 class="title-divider text-muted mt30 mb10">Traffic
								Margins</h5>
							<div class="row">
								<div class="col-xs-5">
									<h3 class="text-primary mn pl5">132</h3>
								</div>
								<div class="col-xs-7 text-right">
									<h3 class="text-success-dark mn">
										<i class="fa fa-caret-up"></i> 13.2%
									</h3>
								</div>
							</div>

							<h5 class="title-divider text-muted mt25 mb10">Database
								Request</h5>
							<div class="row">
								<div class="col-xs-5">
									<h3 class="text-primary mn pl5">212</h3>
								</div>
								<div class="col-xs-7 text-right">
									<h3 class="text-success-dark mn">
										<i class="fa fa-caret-up"></i> 25.6%
									</h3>
								</div>
							</div>

							<h5 class="title-divider text-muted mt25 mb10">Server
								Response</h5>
							<div class="row">
								<div class="col-xs-5">
									<h3 class="text-primary mn pl5">82.5</h3>
								</div>
								<div class="col-xs-7 text-right">
									<h3 class="text-danger mn">
										<i class="fa fa-caret-down"></i> 17.9%
									</h3>
								</div>
							</div>

							<h5 class="title-divider text-muted mt40 mb20">
								Server Statistics <span class="pull-right text-primary fw600">USA</span>
							</h5>


						</div>
						<div id="sidebar-right-tab2" class="tab-pane"></div>
						<div id="sidebar-right-tab3" class="tab-pane"></div>
					</div>
					<!-- end: .tab-content -->
				</div>
			</div>
		</aside>
		<!-- End: Right Sidebar -->

	</div>
	<!-- End: Main -->

	<!-- BEGIN: PAGE SCRIPTS -->

	<!-- BEGIN: PAGE SCRIPTS -->

	<!-- jQuery -->
	<script src="/resources/Admin/vendor/jquery/jquery-1.11.1.min.js"></script>
	<script src="/resources/Admin/vendor/jquery/jquery_ui/jquery-ui.min.js"></script>

	<!-- FileUpload JS -->
	<script src="/resources/Admin/vendor/plugins/fileupload/fileupload.js"></script>
	<script src="/resources/Admin/vendor/plugins/holder/holder.min.js"></script>

	<!-- Tagmanager JS -->
	<script
		src="/resources/Admin/vendor/plugins/tagsinput/tagsinput.min.js"></script>

	<!-- Theme Javascript -->
	<script src="/resources/Admin/assets/js/utility/utility.js"></script>
	<script src="/resources/Admin/assets/js/demo/demo.js"></script>
	<script src="/resources/Admin/assets/js/main.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {

			"use strict";

			// Init Theme Core    
			Core.init();

			// Init Demo JS  
			Demo.init();

			// select dropdowns - placeholder like creation
			var selectList = $('.admin-form select');
			selectList.each(function(i, e) {
				$(e).on('change', function() {
					if ($(e).val() == "0")
						$(e).addClass("empty");
					else
						$(e).removeClass("empty")
				});
			});
			selectList.each(function(i, e) {
				$(e).change();
			});

			// Init tagsinput plugin
			$("input#tagsinput").tagsinput({
				tagClass : function(item) {
					return 'label label-default';
				}
			});

		});
	</script>
	<!-- END: PAGE SCRIPTS -->

</body>

</html>