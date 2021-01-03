<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 </head>
<body>
 <!--Search Form-->
      <form class="search-form closed" method="get" role="form" autocomplete="off" action="/SearchAllProducts2">
      <input type="hidden" name="action" value="sorgu" >
        <div class="container">
          <div class="close-search"><i class="icon-delete"></i></div>
            <div class="form-group">
              <label class="sr-only" for="search-hd" id="sorgu">Search for product</label>
              <input type="text" class="form-control" name="sorgu" id="sorgu" placeholder="Aramak İstediğiniz Ürünü Yazınız">
              
              <button type="submit"><i class="icon-magnifier"></i></button>
          </div>
        </div>
      </form>
</body>
</html>