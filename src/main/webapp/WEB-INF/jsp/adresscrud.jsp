<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<meta charset="utf-8">
<link rel="stylesheet" href="adress/bootstrap.min.css" />
<link rel="stylesheet" href="adress/bootstrap-theme.min.css" />
<script type="text/javascript" src="js/libs/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/libs/bootstrap.min.js"></script>
<script src="adress/adress.js"></script>
<link rel="stylesheet" href="adress/adress.css" />


	<!--AdresSave-->
	<div class="modal" id="u1">
		<div class="modal-dialog modal-adres">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Adres Bilgileri</h4>
				</div>
				<div class="modal-body">


					<ul class="form-style-1">
						<li><label>Adres adı<span class="required"></span></label> 
						<input 	type="text" name="useradresname" " id="adressname" 	class="field-long" placeholder="Örnek Evim,İşim vb." /></li>
						<li><b>Adı</b>&emsp; &emsp; &emsp; &emsp; &emsp; &emsp;&emsp; &emsp; &emsp; &emsp; &emsp;<b>Soyadı</b> <br>
						 <input type="text" name="name" id="name" class="field-divided" placeholder="Adınızı giriniz." />
						 <input type="text" name="surname" id="surname" class="field-divided" placeholder="Soyadınızı giriniz." /></li>
						 <li><label>Şirket <span class="required"></span></label>
						 <input type="text" name="companyname" id="companyname" class="field-long" 	placeholder="Şirket Adına alınıyor ise şirket isimini giriniz." />
						 </li>
						 
					   	<li><label>İL</label> <select name="city" id="city" class="field-select">
					   	</select></li>
						<li><label>İlçe</label> <select name="town" id="town" class="field-select">						
						</select> </select></li>
						<li><label>Semt</label> <select name="district" id="district"class="field-select">
						</select> </select></li>
						<li><label>Mahalle</label> <select name="neighborhoods" id="neighborhoods" class="field-select">
						</select></li>
						<li><label>Adres</label>
						<input type="text" name="adress" id="adress" class="field-long" placeholder="Adres giriniz." /></li>
						<li><b>Posta Kodu</b>&emsp; &emsp; &emsp; &emsp; &emsp;	&emsp; &emsp; &emsp;<b>Telefon</b> <br> 
						<input type="text" 	name="postcode" id="postcode" name="postcode" class="field-divided" placeholder="Posta kodunu giriniz" />
						 <input type="text" name="phone" id="phone" class="field-divided" placeholder="Telefon numaranızı giriniz." /></li>
						<li>
						<li><label>Sipariş notunu giriniz<span
								class="required"></span></label> <textarea name="ordernote"
								id="ordernote" class="field-long field-textarea"
								placeholder="Sipariş notunuzu giriniz" /> </textarea></li>
						<button class="btn btn-primary" onclick="save();">KAYDET</button>

					</ul>

				</div>
			</div>
		</div>
	</div>
	<!--AdresSave Popup Close -->



<!--AdresUpdate Popup-->

<div class="modal" id="u2">
	<div class="modal-dialog modal-adres">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			
					<center><h4 class="modal-title">Adres Bilgileri Güncelleyebilirsiniz.</h4></center>
			</div>
			<div class="modal-body">
				<ul class="form-style-1">
					<li><label>Adres adı<span class="required"></span></label> <input
						type="text" name="updateadressname" " id="updateadressname"
						class="field-long" placeholder="Örnek Evim,İşim vb." /></li>
					<li><b>Adı</b>&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;
						&emsp; &emsp; &emsp; &emsp;<b>Soyadı</b> <br> <input
						type="text" name="updatename" id="updatename"
						class="field-divided" placeholder="Adınızı giriniz." /> <input
						type="text" name="updatesurname" id="updatesurname"
						class="field-divided" placeholder="Soyadınızı giriniz." /></li>
						<li><label>Şirket <span class="required"></span></label> <input
						type="text" name="updatecompanyname" id="updatecompanyname"
						value="" class="field-long"
						placeholder="Şirket Adına alınıyor ise şirket isimini giriniz." />
					   </li>
				        <li><label>İL</label> <select name="city" id="updatecity" class="field-select">	   
                        </select>                       
                        <li><label>İlçe</label> <select name="updatetown" id="updatetown" class="field-select">
                        </select> 				   	
						<li><label>Semt</label> <select name="updatedistrict" id="updatedistrict"class="field-select">
						<option value=""></option>
						</select> </select></li>
						<li><label>Mahalle</label> <select name="updateneighborhoods" id="updateneighborhoods" class="field-select">
						</select></li>
						<li><label>Adres</label>
						<input type="text" name="adress" id="updateadress" class="field-long" placeholder="Adres giriniz." /></li>
					
				
					<li><b>Posta Kodu</b>&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; 	&emsp; &emsp;<b>Telefon</b> <br>
					<input type="text" 	name="updatepostcode" id="updatepostcode" class="field-divided" placeholder="Posta kodunu giriniz" /> 
					<input 	type="text" name="updatephone" id="updatephone" class="field-divided" placeholder="Telefon numaranızı giriniz." /></li>
					<li>
					<li><label>Sipariş notunu giriniz<span
							class="required"></span></label> <textarea name="updateordernote"
							id="updateordernote" class="field-long field-textarea"
							placeholder="Sipariş notunuzu giriniz" /> </textarea></li>
					<input type="hidden" name="updateid" id="updateid" />
					<button class="btn btn-primary" onclick="uptate();">GÜNCELLE</button>
				</ul>

			</div>
		</div>
	</div>
</div>
<!--AdresUpdate Close-->
<p>	&emsp; &emsp; &emsp; &emsp;&emsp; &emsp; &emsp;<button id="adresssave">Yeni Adres Ekle</button></p>
<!--Checkout-->
<section class="checkout">
	<div class="container">

		<!--Expandable Panels-->

		<!--Checkout Form-->
		<div class="row">
			<form id="checkout-form" method="post" action="/addWebOrder">

				<!--Left Column-->
				<div class="col-lg-8 col-md-8 col-sm-8">
					<h3>Kayıtlı Adreslerim</h3>
					<div class="row">

					
						<table id="personadress" >
							<c:forEach items="${adress}" var="adress">
								<tr>
									<th colspan="2">${adress.useradresname}(${adress.username}&nbsp;${adress.usersurname})</th>
									<th>Semt</th>
									<th>İl/İlçe</th>
									<th>Posta Kodu</th>
									<th>Sipariş Notu</th>
									<th>Telefon</th>
									<th>Sil</th>
									<th>Düzenle</th>
									<th>Adres Seciniz</th>

								</tr>
								<tr height=”200″>
									<td width="600">${adress.adress}</td>
									<td>${adress.neighborhoods}</td>
									<td>${adress.district}</td>
									<td>${adress.city}${adress.town}</td>									
									<td>${adress.postcode}</td>
									<td>${adress.ordernote}</td>
									<td>${adress.phone}</td>


									


									<!-- delete işlemin gerçekleştiriyor kodlar adress.js de  Mehmet ÜLKER-->
									<td><a class="btnSelect" href="#"
										onclick="ConfirmDelete(${adress.id})">Sil</a></td>
										
									<!-- update formunu içindeki verirlerle bereber getiriyor kodlar adress.js de  Mehmet ÜLKER-->
									<td><a class="btnSelect" href="#" onclick="updateform(${adress.id});">Düzenle</a></td>

									<td>				
                 					<div class="radio">
                     				 <label><input type="radio" name="adresId" value="${adress.id}" checked="checked"></label>
                 					</div>
                 					</td>
        

								</tr>
							</c:forEach>
						</table>

					</div>
				</div><!--Right Column-->
				<div class="col-lg-3 col-lg-offset-1 col-md-4 col-sm-4">
					<h3>Siparişiniz</h3>
					<table>
						<c:forEach items="${cartItemList}" var="cartItem">
							<tr>
								<th>Ürün</th>
								<th>Fiyat</th>
							</tr>
							<tr>
								<td class="name border">${cartItem.productName}<span>
										<img src="${cartItem.image}" alt="${cartItem.productName}"
										width="25px" height="25px" />
								</span></td>
								<td class="price border">${cartItem.price}TL</td>
							</tr>
						</c:forEach>
					</table>

					<table >
						<tr>
							<td class="th">Sepet Toplamı:</td>
							<td class="price"><input type="text" name="Price"
								value="${totalAmount}"></input></td>
						</tr>
						<tr>
							<td class="th">KDV:</td>
							<td class="price"><input type="text" name="Tax"
								value="${totalTax}"></input></td>
						</tr>
						<tr>
							<td class="th border">Kargo</td>
							<td class="align-r border">Ücretsiz Kargo</td>
						</tr>
						<tr>
							<td class="th">Genel Toplam</td>
							<td class="price"><input type="text" name="TotalPrice"
								value="${GeneralTotal}"></input></td>
						</tr>
					</table>
					<div class="payment-method">
						<div class="radio light">
							<label><input type="radio" name="PaymentTypeId" value="1"
								id="payment01" checked> Banka Havalesi</label>
						</div>
						<p>Ödemenizi doğrudan banka hesabımıza yapın. Ödeme referansı
							olarak lütfen Sipariş Kimliğinizi kullanın. Siparişimiz,
							hesabımızdaki paralar temizlenene kadar gönderilmeyecek.</p>
						<div class="radio light">
							<label><input type="radio" name="PaymentTypeId" value="2"
								id="payment02"> Cheque Payment</label>
						</div>
						<div class="radio light">
							<label><input type="radio" name="PaymentTypeId" value="3"
								id="payment03"> PayPal <span class="pp-label"></span></label>
						</div>
					</div>
					<input class="btn btn-black btn-block" type="submit"
						name="place-order" value="Sipariş Ver">
				</div>
			</form>
		</div>
	</div>
</section>
<!--Checkout Close-->