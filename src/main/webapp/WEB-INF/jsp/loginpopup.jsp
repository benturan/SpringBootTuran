<%@ page pageEncoding="UTF-8"%>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">
					<i class="fa fa-times"></i>
				</button>
				<h2>
					Giriş Yap veya <a href="/allregister">Kayıt Ol</a>
				</h2>
				<p class="large">Sosyal Media Hesapları</p>
				<div class="social-login">
					<a class="facebook" href="#"><i class="fa fa-facebook-square"></i></a>
					<a class="google" href="#"><i class="fa fa-google-plus-square"></i></a>
					<a class="twitter" href="#"><i class="fa fa-twitter-square"></i></a>
				</div>
			</div>
			<div class="modal-body">
				<form class="login-form" method="POST" action="/allindex">
					<div class="form-group group">
						<label for="log-email">Email</label> <input type="email"
							class="form-control" name="email" id="log-email"
							placeholder="E-mail adresinizi giriniz." required> <a
							class="help-link" href="#">E-mail unuttum?</a>
					</div>
					<div class="form-group group">
						<label for="log-password">Parola</label> <input type="text"
							class="form-control" name="password" id="log-password"
							placeholder="Parolanızı giriniz." required> <a
							class="help-link" href="#">Parolamı unuttum?</a>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" name="remember">
							Beni Hatırla.</label>
					</div>
					<input class="btn btn-black" type="submit" value="Giriş Yap">
				</form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>