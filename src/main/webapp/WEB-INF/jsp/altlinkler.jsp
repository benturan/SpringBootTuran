<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--Footer-->
    <footer class="footer">
    	<div class="container">
      	<div class="row">
        	<div class="col-lg-5 col-md-5 col-sm-5">
          	<div class="info">
              <a class="logo" href="/allindex"><img src="img/logo-footer.png" alt="Limo"/></a>
              <p>90'li yıllara dayanan tecrübemiz ile hızlı ve güvenilir alışverişin adresi. Limo! Yanlızca seçkin kişiler için.</p>
            <div class="social">
              	<a href="https://twitter.com/EcommerceLimo" target="_blank"><i class="fa fa-twitter-square"></i></a>
              	<a href="https://www.facebook.com/LimoEcommerce" target="_blank"><i class="fa fa-facebook-square"></i></a>
              	<a href="https://www.instagram.com/limo.ecommerce/" target="_blank"><i class="fa fa-instagram"></i></a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4">
          	<h2>Son Eklenenler</h2>
          	<c:forEach items="${enson}" var="ürün">
            <ul class="list-unstyled">
            	<li>${ürün.dates } <a href="#">${ürün.name }</a></li>              
            </ul>
            </c:forEach>
          </div>
          <div class="contacts col-lg-3 col-md-3 col-sm-3">
          	<h2>İletişim</h2>
            <p class="p-style3">
            	Abbasağa, Barbaros Blv. No:13,<br/>
              34353 Beşiktaş/İstanbul<br/>
              <a href="mailto:limoprojesi@yandex.com">limoprojesi@yandex.com</a><br/>
              +48 543765234<br/>
              +48 555 234 54 34<br/>
            </p>
          </div>
        </div>
       
        <div class="copyright">
        	<div class="row">
          	<div class="col-lg-7 col-md-7 col-sm-7">
              <p>&copy; 2014 Limo. All Rights Reserved. Designed by <a href="http://8guild.com/" target="_blank">8Guild</a></p>
            </div>
          	<div class="col-lg-5 col-md-5 col-sm-5">
            	<div class="payment">
                <img src="img/payment/visa.png" alt="Visa"/>
                <img src="img/payment/paypal.png" alt="PayPal"/>
                <img src="img/payment/master.png" alt="Master Card"/>
                <img src="img/payment/discover.png" alt="Discover"/>
                <img src="img/payment/amazon.png" alt="Amazon"/>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer><!--Footer Close-->