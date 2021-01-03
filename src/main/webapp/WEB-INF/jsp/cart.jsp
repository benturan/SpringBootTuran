<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<div class="cart-btn">

	<a class="btn btn-outlined-invert" href="/getShoppingCart"><i
		class="icon-shopping-cart-content"></i><span>${countItems}</span><b>${totalAmount}
			$</b></a>

	<!--Cart Dropdown-->
	<div class="cart-dropdown">
		<span></span>
		<!--Small rectangle to overlap Cart button-->
		<div class="body">
			<table align="center">
				<tr>
					<th>Ürün</th>					
					<th>Miktar</th>
					<th>Tutar</th>
					<th>Sil</th>
				</tr>
				<c:forEach items="${cartItemList}" var="cartItem">
					<tr class="item">

						<td><a href="urundetay${cartItem.productId}">${cartItem.productName}</a></td>

						
						<td><input type="text" value="${cartItem.productQuantity}"></td>
						<td class="price">${cartItem.price}</td>
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
											
									   
										$.ajax('/deleteCartIncrease', {
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
										</script>

						
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="footer group">
			<div class="buttons">
				<a class="btn btn-outlined-invert" href="/checkoutAllCart"><i
					class="icon-download"></i>Checkout</a> <a
					class="btn btn-outlined-invert" href="shopping-cart.html"><i
					class="icon-shopping-cart-content"></i>To cart</a>
			</div>
			<div class="total">${totalAmount}$</div>
		</div>
	</div>
	<!--Cart Dropdown Close-->
</div>