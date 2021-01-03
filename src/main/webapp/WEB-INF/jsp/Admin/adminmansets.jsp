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
				<form name="mansetform" id="mansetform" method="POST"
					action="/Admin/mansetAdd" enctype="multipart/form-data">
					<div class="tray tray-center">

						<!-- create new order panel -->
						<div class="panel mb25 mt5">
							<div class="panel-heading">
								<span class="panel-title hidden-xs">Manşet Ekle</span>
								<ul class="nav panel-tabs-border panel-tabs">

									<li class="active"><a href="#tab1_2" data-toggle="tab"></a>
									</li>
								</ul>
							</div>
							<div class="panel-body p20 pb10">


								<div class="tab-content pn br-n admin-form">

									<div id="tab1_2" class="tab-pane active">

										<div class="section row">

											<div class="section row">
												<div class="col-md-12">
													<label for="mansetmaincategoryId" class="field select">
														<select id="mansetmaincategoryId"
														name="mansetmaincategoryId" OnChange="getCategories()">
															<option value="0" selected="selected">Ana
																Kategori</option>
															<c:forEach items="${parentcategory}" var="parent">
																<option value="${parent.categoryid }">${parent.categoryname}</option>
															</c:forEach>
													</select> <i class="arrow double"></i>
													</label>
													<div id="anaKat"></div>
												</div>
												<!-- end section -->
											</div>

											<div class="section row">
												<div class="col-md-12">
													<label class="field select"> <select
														id="mansetsubcategoryId" name="mansetsubcategoryId"
														OnChange="getCategories2()">
															<option value="0" selected="selected">Alt
																Kategori</option>
													</select> <i class="arrow double"></i>
													</label>
												</div>
											</div>


											<div class="section row">
												<div class="col-md-12">
													<label class="field select"> <select
														id="categoryid" name="categoryid">
															<option value="0" selected="selected">Alt
																Kategori2</option>
													</select> <i class="arrow double"></i>
													</label>
												</div>
												<!-- end section -->
											</div>


										</div>
										<!-- end section row section -->

										<div class="section row mbn">
											<div class="col-md-4">

												<div class="fileupload fileupload-new admin-form"
													data-provides="fileupload">

													<div id="mansetresim"
														class="fileupload-preview thumbnail mb20">
														<img id="resimjs" name="resimjs"
															data-src="holder.js/100%x140" alt="holder">
													</div>
													<div class="row">
														<div class="col-xs-5">

															<span class="button btn-system btn-file btn-block">
																<span class="fileupload-new">Seç</span> <span
																class="fileupload-exists">Değiştir</span> <input
																type="file" name="file" id="file">
															</span>

														</div>

													</div>
												</div>



											</div>
											<div class="col-md-8 pl15">
												<div class="section mb10">
													<label for="baslik" class="field prepend-icon"> <input
														type="text" name="baslik" id="baslik"
														class="event-name gui-input br-light light"
														placeholder="Baslik"> <label for="baslik"
														class="field-icon"> <i class="fa fa-tag"></i>
													</label>
													</label>
												</div>
												<div class="section mb10">
													<label class="field prepend-icon"> <textarea
															style="height: 160px;"
															class="gui-textarea br-light bg-light" id="detay"
															name="detay" placeholder="Manşet Detayı"></textarea> <label
														for="comment" class="field-icon"> <i
															class="fa fa-comments"></i>
													</label> <span class="input-footer hidden"> <strong>Detay:</strong>Don't
															be negative or off topic! just be awesome...
													</span>
													</label>
												</div>
												<div class="section mb10">
													<label class="field select"> <select id="sira"
														name="sira">
															<option value="0" selected="selected">Seçiniz</option>
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
															<option value="6">6</option>
															<option value="7">7</option>
															<option value="8">8</option>
															<option value="9">9</option>
															<option value="10">10</option>
													</select> <i class="arrow double"></i>
													</label>

												</div>
											</div>
											<div class="section row mbn">

												<div class="col-sm-4">

													<button id="btnMansetEkle" type="submit"
														class="btn btn-primary" type="button">Kaydet</button>

												</div>
											</div>
										</div>



										<!-- end section -->

									</div>


								</div>

							</div>
						</div>

						<!-- recent orders table -->
						<div class="panel">

							<div class="panel-body pn">
								<div class="table-responsive">
									<table
										class="table admin-form theme-warning tc-checkbox-1 fs13">
										<thead>
											<tr class="bg-light">
												<th class="text-center">Seç</th>
												<th class="">Image</th>
												<th class="">Baslik</th>
												<th class="">Detay</th>
												<th class="">Sira</th>
												<th class="">Kategori</th>
												<th class="text-right">Statu</th>

											</tr>
										</thead>
										<tbody>

											<c:forEach items="${adminmansetlists}" var="manset">
												<tr>
													<td class="text-center"><label class="option block mn">
															<input type="checkbox" name="mobileos" value="FR">
															<span class="checkbox mn"></span>
													</label></td>

													<td class="w100"><img
														class="img-responsive mw40 ib mr10" title="user"
														src="/img/hero/slideshow/${manset.image}"></td>
													<td class="">${manset.baslik}</td>
													<td class="">${manset.detay}</td>
													<td class="">${manset.sira}</td>
													<td class=""><b>${manset.categoryId}</b></td>
													<td class="text-right">
														<div class="btn-group text-right">
															<button type="button"
																class="btn btn-success br2 btn-xs fs12 dropdown-toggle"
																data-toggle="dropdown" aria-expanded="false">
																Seçiniz <span class="caret ml5"></span>
															</button>
															<ul class="dropdown-menu" role="menu">
																<li><a href="#"
																	onclick="MansetDuzenle(${manset.id});">Düzenle</a></li>
																<li><a
																	onclick="return confirm('Silmek istediğinizden emin misiniz?');"
																	href="/deleteManset/${manset.id}">Sil</a></li>

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
					<input type="text" name="mid" id="mid"></input>
				</form>
				<!-- end: .tray-center -->

				<!-- begin: .tray-right -->
				<aside class="tray tray-right tray290" data-tray-height="match">

					<!-- menu quick links -->

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






	<script type="text/javascript">
		var requestObj = false;
		   var EnAltKategoriParentId = -1;
		   var EntAltKategoriId=-1;
		   var AltKategoriParentId = -1;
		   var AltKategoriId= -1;
		   var MainKategoriParentId = -1;
		   var MainKategoriId=-1;
		   var seciliSira = -1;

		if (window.XMLHttpRequest) {
			requestObj = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			requestObj = new ActiveXObject("Microsoft.XMLHTTP");
		}
		

		   function MansetDuzenle(mid){
			   

			   try {
				   var ana = document.getElementById("mansetresim");
				
				   while (ana.lastElementChild) {
					    ana.removeChild(ana.lastElementChild);
				   }

				   document.getElementById("btnMansetEkle").innerHTML = "Güncelle";
				   document.getElementById("mid").style.visibility = "hidden";
				   document.getElementById("mid").value = mid;
				   document.getElementById("mansetform").action = "";
				  // document.getElementById("mansetform").method = "";
				 //  document.getElementById("mansetform").method = "GET";
				   document.getElementById("mansetform").action = "/Admin/updateManset/"+ mid;
				  // document.getElementById("btnMansetEkle").href = "/Admin/updateManset/"+ mid;;
		
				 }               	   
			   catch(err){
			   }
			   var img = document.createElement('img');	  
			   
			   if (requestObj) {
				   
			          requestObj.open("GET", "/getManset/" + mid);
			          requestObj.onreadystatechange = function ()
			          {

					        
			                     var options = JSON.parse(requestObj.responseText);
			                  
			                     //detay basladi
			                   for( var i=0; i<options.length; i++) { 
				                   
			                	   document.getElementById("baslik").value = options[i][2];
			                	   document.getElementById("detay").innerHTML = options[i][3];
			                	
			                	   img.src = "/img/hero/slideshow/"+options[i][1]; 
			                	   document.getElementById('mansetresim').appendChild(img);

			                	   var anaSira = document.getElementById("sira");
			       				   var seciliSira = options[i][4];
			       				   seciliKategori = options[i][5];
			       				 // sira combobox basladi
			    				   while (anaSira.lastElementChild) {
			    					   anaSira.removeChild(anaSira.lastElementChild);
			    				   }

			    				   for( var j=1; j<=10; j++) { 

				    				   if(seciliSira == j)
					    				{
				    					   var newOption = document.createElement('option');
						                   newOption.value = j;
						                   newOption.innerText = j;
						                   newOption.selected = "selected";               
					                        document.getElementById('sira').appendChild(newOption); 
					    			    }
				    				   else
					    				   {
				    					   var newOption = document.createElement('option');
						                   newOption.value = j;
						                   newOption.innerText = j;              
					                        document.getElementById('sira').appendChild(newOption); 

					    				   }

	
			    				         }
		    				         // sira bitti
		    				         //daha önce seçilmiş Ana, alt , ve en alt kategori combolarını
		    				         // doldurabilmek için en alt kategoriden baslıyorum
		    				         // böylece secili en alt kategorinin parent id sinden alt kategoriye
		    				         // oradan ana kategoriye kadar gidebileceğim
		    				         enaltkategorigetir(seciliKategori);
		                        
			              }  //for bitti
			  
			          }
			          requestObj.send(null);
			      }
			   
			   }

		function enaltkategorigetir(seciliKategoi)   
		{
	         //en alt kategori secimi basladi
	         // Bu metot aslında üç kategori de seçmiş kişini
	         // yani ana kategori, alt kategori, en alt kategoriyi seçmiş kişinin
	         // seçmiş olduğu alt kategoriyi doldurup daha önce seçmiş olduğu kategoriyi seçili
	         // hale getirmek için tasarlandı
	         // ancak EnAltKategoriParentId == 0 sıfır kontrolu ile
	         // eğer kişi sadece ana kategori ve alt kategori seçmiş ancak
	         // en alt kategoriyi seçmemişse ne olacağı ile ilgili
	         // EnAltKategoriParentId == 0 ise demekki kişi sadece Ana kategori ve alt kategori seçmiş
	         // ama en alt kategori seçmemiş, o yüzden en alt kategorinin ve alt kategorinin combolarını sıfırlıyorum
	         	var enAltKategori = document.getElementById("categoryid");
	            while (enAltKategori.lastElementChild) {
	            	enAltKategori.removeChild(enAltKategori.lastElementChild);
				   }
				  // alert("Seçili Kategori " + seciliKategori);
				   var AltKategori = document.getElementById("mansetsubcategoryId");
		            while (AltKategori.lastElementChild) {
		            	AltKategori.removeChild(AltKategori.lastElementChild);
  				   }
				   
            //En alt kategori seçilmiş mi seçilmemiş mi kontolu
			if (requestObj) {
			requestObj.open("GET", "/getParentId/" + seciliKategori);
			requestObj.onreadystatechange = function() {
			if (requestObj.readyState == 4 && requestObj.status == 200) {
			EnAltKategoriParentId = JSON.parse(requestObj.responseText);
			//alert('EnAlt kategori parent Id '+EnAltKategoriParentId);
			
			// Demekki en alt kateori seçilmemiş
				if(EnAltKategoriParentId == 0){
	 			var MainKategori = document.getElementById("mansetmaincategoryId");
     			while (MainKategori.lastElementChild) {
     				MainKategori.removeChild(MainKategori.lastElementChild);
	  					 }

   					 // alert(' main kategori elemanlari temizlendi');
				requestObj.open("GET", "/getAllMainCategories/");
				requestObj.onreadystatechange = function() {
				if (requestObj.readyState == 4 && requestObj.status == 200) {
					var options = JSON.parse(requestObj.responseText);
			
					for (var k = 0; k < options.length; k++) {
					if(k == 0)
					{
					var newOption = document.createElement('option');
					newOption.value = -1;
					newOption.innerText = "Ana Kategori Seçiniz";

					document.getElementById('mansetmaincategoryId').appendChild(
							newOption);
					}
				if( seciliKategori == options[k]["categoryid"])
					{
					var newOption = document.createElement('option');
					newOption.value = options[k]["categoryid"];
					newOption.innerText = options[k]["categoryname"];
					newOption.selected = "selected"; 
					document.getElementById('mansetmaincategoryId').appendChild(
							newOption);
					}
				else
					{
				var newOption = document.createElement('option');
				newOption.value = options[k]["categoryid"];
				newOption.innerText = options[k]["categoryname"];

				document.getElementById('mansetmaincategoryId').appendChild(
						newOption);
						}
					}
				}
			}
					requestObj.send(null);
					}
				else
				{
						if (requestObj) {
						requestObj.open("GET", "/getParentIdAllCategories/" + EnAltKategoriParentId);
						//alert('EnAlt kategori parent Id '+EnAltKategoriParentId+" e gore elemanlar cagrildi");
						requestObj.onreadystatechange = function() {
						if (requestObj.readyState == 4 && requestObj.status == 200) {
						var options = JSON.parse(requestObj.responseText);
			//alert(options +" gelmis olması lazim");
			
					for (var k = 0; k < options.length; k++) {
						if(k == 0)
					{
					var newOption = document.createElement('option');
					newOption.value = -1;
					newOption.innerText = "En Alt Kategori Seçiniz";

					document.getElementById('categoryid').appendChild(
							newOption);
					}
				if( seciliKategori == options[k]["categoryid"])
					{
					var newOption = document.createElement('option');
					newOption.value = options[k]["categoryid"];
					newOption.innerText = options[k]["categoryname"];
					newOption.selected = "selected"; 
					document.getElementById('categoryid').appendChild(
							newOption);
					}
				else
					{
				var newOption = document.createElement('option');
				newOption.value = options[k]["categoryid"];
				newOption.innerText = options[k]["categoryname"];

				document.getElementById('categoryid').appendChild(
						newOption);
					}
			}
                //alert('altkategorgetir cagrilmis olmasi lazim');
                
			altkategorigetir(EnAltKategoriParentId);
		}
	}
	requestObj.send(null);
}
	}

}
}
requestObj.send(null);
}
//alert('en alt kategori secimi bitti');

		}

		function altkategorigetir(EnAltKategoriParentId)
		{

			//alert('altkategorigetir cagrildi');
			//alert('iki secimli kategoride  EnAltKategoriParentId'+EnAltKategoriParentId)
			// alt kategori secimi basladi
	         var AltKategori = document.getElementById("mansetsubcategoryId");
		            while (AltKategori.lastElementChild) {
		            	AltKategori.removeChild(AltKategori.lastElementChild);
   				   }

		           // alert(' alt kategori elemanlari temizlendi');
		          
   				 

if (requestObj) {
//alert('En alt Kategori Id alt kategori de cagrildi'+ EnAltKategoriParentId);
requestObj.open("GET", "/subCategorysFindParentIdByParentId/" + EnAltKategoriParentId);
requestObj.onreadystatechange = function() {
if (requestObj.readyState == 4 && requestObj.status == 200) {
	//en alt kategorinin parent id sin parent id sini bulmak gerekiyor
	AltKategoriParentId = JSON.parse(requestObj.responseText);
	//alert("AltKategoriParendId cagrildi "+AltKategoriParentId);
	//alert("EnAltKategoriParendId cagrildi "+EnAltKategoriParentId);

	if(AltKategoriParentId == 0)
		{
		 var MainKategori = document.getElementById("mansetmaincategoryId");
	     while (MainKategori.lastElementChild) {
	     	MainKategori.removeChild(MainKategori.lastElementChild);
		   }

	 	var enAltKategori = document.getElementById("categoryid");
        while (enAltKategori.lastElementChild) {
        	enAltKategori.removeChild(enAltKategori.lastElementChild);
		   }


    	requestObj.open("GET", "/getParentIdAllCategories/" + EnAltKategoriParentId);
		requestObj.onreadystatechange = function() {
			if (requestObj.readyState == 4 && requestObj.status == 200) {
				var options = JSON.parse(requestObj.responseText);
				
				for (var k = 0; k < options.length; k++) {
					if(k == 0)
						{
						var newOption = document.createElement('option');
						newOption.value = -1;
						newOption.innerText = "Alt Kategori Seçiniz";

						document.getElementById('mansetsubcategoryId').appendChild(
								newOption);
						}
					if( seciliKategori == options[k]["categoryid"])
						{
						var newOption = document.createElement('option');
						newOption.value = options[k]["categoryid"];
						newOption.innerText = options[k]["categoryname"];
						newOption.selected = "selected"; 
						document.getElementById('mansetsubcategoryId').appendChild(
								newOption);
						}
					else
						{
					var newOption = document.createElement('option');
					newOption.value = options[k]["categoryid"];
					newOption.innerText = options[k]["categoryname"];

					document.getElementById('mansetsubcategoryId').appendChild(
							newOption);
						}
				}
				//kişi ana kategori ve alt kategori seçtikten sonra
				// ana kategorinin seçili olarak gelmesi için
				// bu metot diğerinden kopyalandı
				// altkategorinin parent id si bir nevi
				// en alt kategorinin parent idsi olduğu için
				// bu metoda EnAltKategoriParentId parametre olarak gönderildi
				maingetir2(EnAltKategoriParentId); 
			}
		}
		requestObj.send(null);

		}
	else
		{
	if (requestObj) {
		requestObj.open("GET", "/getParentIdAllCategories/" + AltKategoriParentId);
		requestObj.onreadystatechange = function() {
			if (requestObj.readyState == 4 && requestObj.status == 200) {
				var options = JSON.parse(requestObj.responseText);
				
				for (var k = 0; k < options.length; k++) {
					if(k == 0)
						{
						var newOption = document.createElement('option');
						newOption.value = -1;
						newOption.innerText = "Alt Kategori Seçiniz";

						document.getElementById('mansetsubcategoryId').appendChild(
								newOption);
						}
					if( EnAltKategoriParentId == options[k]["categoryid"])
						{
						var newOption = document.createElement('option');
						newOption.value = options[k]["categoryid"];
						newOption.innerText = options[k]["categoryname"];
						newOption.selected = "selected"; 
						document.getElementById('mansetsubcategoryId').appendChild(
								newOption);
						}
					else
						{
					var newOption = document.createElement('option');
					newOption.value = options[k]["categoryid"];
					newOption.innerText = options[k]["categoryname"];

					document.getElementById('mansetsubcategoryId').appendChild(
							newOption);
						}
				}
				maingetir(AltKategoriParentId);
			}
		}
		requestObj.send(null);
	}

		}

	
}
}
requestObj.send(null);
}	
// alt kategori secim bitti
		}


		function maingetir(AltKategoriParentId)
		{

			//alert('AltKategoriParentId maingetirde cagrildi '+AltKategoriParentId);
			//alert('maingetir cagrildi');

			// alt kategori secimi basladi
	         var MainKategori = document.getElementById("mansetmaincategoryId");
		            while (MainKategori.lastElementChild) {
		            	MainKategori.removeChild(MainKategori.lastElementChild);
   				   }

		           // alert(' main kategori elemanlari temizlendi');
		          
   				 



	if (requestObj) {
		requestObj.open("GET", "/getAllMainCategories/");
		requestObj.onreadystatechange = function() {
			if (requestObj.readyState == 4 && requestObj.status == 200) {
				var options = JSON.parse(requestObj.responseText);
				
				for (var k = 0; k < options.length; k++) {
					if(k == 0)
						{
						var newOption = document.createElement('option');
						newOption.value = -1;
						newOption.innerText = "Ana Kategori Seçiniz";

						document.getElementById('mansetmaincategoryId').appendChild(
								newOption);
						}
					if( AltKategoriParentId == options[k]["categoryid"])
						{
						var newOption = document.createElement('option');
						newOption.value = options[k]["categoryid"];
						newOption.innerText = options[k]["categoryname"];
						newOption.selected = "selected"; 
						document.getElementById('mansetmaincategoryId').appendChild(
								newOption);
						}
					else
						{
					var newOption = document.createElement('option');
					newOption.value = options[k]["categoryid"];
					newOption.innerText = options[k]["categoryname"];

					document.getElementById('mansetmaincategoryId').appendChild(
							newOption);
						}
				}
				
			}
		}
		requestObj.send(null);
	}

	


requestObj.send(null);

		}

		function maingetir2(EnAltKategoriParentId)
		{

			//alert('AltKategoriParentId maingetirde cagrildi '+AltKategoriParentId);
			//alert('maingetir cagrildi');

			// alt kategori secimi basladi
	         var MainKategori = document.getElementById("mansetmaincategoryId");
		            while (MainKategori.lastElementChild) {
		            	MainKategori.removeChild(MainKategori.lastElementChild);
   				   }

		           // alert(' main kategori elemanlari temizlendi');
		          
   				 



	if (requestObj) {
		requestObj.open("GET", "/getAllMainCategories/");
		requestObj.onreadystatechange = function() {
			if (requestObj.readyState == 4 && requestObj.status == 200) {
				var options = JSON.parse(requestObj.responseText);
				
				for (var k = 0; k < options.length; k++) {
					if(k == 0)
						{
						var newOption = document.createElement('option');
						newOption.value = -1;
						newOption.innerText = "Ana Kategori Seçiniz";

						document.getElementById('mansetmaincategoryId').appendChild(
								newOption);
						}
					if( EnAltKategoriParentId == options[k]["categoryid"])
						{
						var newOption = document.createElement('option');
						newOption.value = options[k]["categoryid"];
						newOption.innerText = options[k]["categoryname"];
						newOption.selected = "selected"; 
						document.getElementById('mansetmaincategoryId').appendChild(
								newOption);
						}
					else
						{
					var newOption = document.createElement('option');
					newOption.value = options[k]["categoryid"];
					newOption.innerText = options[k]["categoryname"];

					document.getElementById('mansetmaincategoryId').appendChild(
							newOption);
						}
				}
				
			}
		}
		requestObj.send(null);
	}

	


requestObj.send(null);

		}

		function getCategories() {

			$('#mansetsubcategoryId')
					.empty()
					.append(
							'<option value="0" selected="selected">Alt Kategori</option>');
			var select = document.getElementById('mansetmaincategoryId');
			var currentCategory = select.options[select.selectedIndex];
			if (requestObj) {
				requestObj.open("GET", "/getCategory/" + currentCategory.text);
				requestObj.onreadystatechange = function() {
					if (requestObj.readyState == 4 && requestObj.status == 200) {
						var options = JSON.parse(requestObj.responseText);
						for (var i = 0; i < options.length; i++) {
							var newOption = document.createElement('option');
							newOption.value = options[i]["categoryid"];
							newOption.innerText = options[i]["categoryname"];

							document.getElementById('mansetsubcategoryId')
									.appendChild(newOption);
						}
					}
				}
				requestObj.send(null);
			}
		}

		function getCategories2() {

			$('#categoryid')
					.empty()
					.append(
							'<option value="0" selected="selected">Alt Kategori2</option>');
			var select = document.getElementById('mansetsubcategoryId');
			var currentCategory = select.options[select.selectedIndex];
			if (requestObj) {
				requestObj.open("GET", "/getCategory/" + currentCategory.text);
				requestObj.onreadystatechange = function() {
					if (requestObj.readyState == 4 && requestObj.status == 200) {
						var options = JSON.parse(requestObj.responseText);
						for (var i = 0; i < options.length; i++) {
							var newOption = document.createElement('option');
							newOption.value = options[i]["categoryid"];
							newOption.innerText = options[i]["categoryname"];

							document.getElementById('categoryid').appendChild(
									newOption);
						}
					}
				}
				requestObj.send(null);
			}
		}
	</script>
	<!-- END: PAGE SCRIPTS -->

</body>

</html>