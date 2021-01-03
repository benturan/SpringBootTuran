<%@ page pageEncoding="UTF-8"%>
<div class="sticky-btns">
      <form class="quick-contact" method="post" name="quick-contact" action = "/mesaj">
        <h3>İletişime Geçin</h3>
       <form class="contact-form">
            	<div class="form-group">
              	<label class="sr-only" for="cf-name">Name</label>
              	<input type="text" class="form-control" name="name" id="name" placeholder="Adınızı Yazın" required>
              </div>
            	<div class="form-group">
              	<label class="sr-only" for="cf-email">Email</label>
              	<input type="email" class="form-control" name="email" id="email" placeholder="E-mail adresini girinix" required>
              </div>
            	<div class="form-group">
              	<label class="sr-only" for="cf-message">Message</label>
                <textarea class="form-control" name="usermessage" id="usermessage" rows="5" placeholder="Mesajınız" required></textarea>
              </div>
              <input class="btn btn-primary" type="submit"  >
      </form>
      <span id="qcf-btn"><i class="fa fa-envelope"></i></span>
      <span id="scrollTop-btn"><i class="fa fa-chevron-up"></i></span>
    </div>