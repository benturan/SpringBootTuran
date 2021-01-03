package com.bilgeadam.SpringBootTuran.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bilgeadam.SpringBootTuran.dto.AddOrderDetailResponse;
import com.bilgeadam.SpringBootTuran.dto.AddOrderResponse;
import com.bilgeadam.SpringBootTuran.dto.CartItemDTO;
import com.bilgeadam.SpringBootTuran.dto.FAQResponse;
import com.bilgeadam.SpringBootTuran.dto.MyOrdersResponse;
import com.bilgeadam.SpringBootTuran.dto.OrderDTO;
import com.bilgeadam.SpringBootTuran.dto.ProductDTO;
import com.bilgeadam.SpringBootTuran.dto.SignUpResponse;
import com.bilgeadam.SpringBootTuran.dto.UserProfileResponse;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Media;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order_Detail;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_User_Adress;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Users;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsOrderDetailServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsOrderServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_User_AdressServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_UsersServiceImpl;

@Controller
public class UserViewController {
	@Autowired
	private HttpSession httpSession;
	private final ETicaret_User_AdressServiceImpl eTicaret_User_AdressServiceImpl;
	private final ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl;
	private final ETicaret_ProductsOrderServiceImpl eTicaret_ProductsOrderServiceImpl;
	private final ETicaret_ProductsOrderDetailServiceImpl eTicaret_ProductsOrderDetailServiceImpl;
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	 
	
	public UserViewController(ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl,
			ETicaret_ProductsOrderServiceImpl eTicaret_ProductsOrderServiceImpl,
			ETicaret_ProductsOrderDetailServiceImpl eTicaret_ProductsOrderDetailServiceImpl,
			ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,
			ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
			ETicaret_User_AdressServiceImpl eTicaret_User_AdressServiceImpl 
			)
	{
		this.eTicaret_UsersServiceImpl = eTicaret_UsersServiceImpl;
		this.eTicaret_ProductsOrderServiceImpl = eTicaret_ProductsOrderServiceImpl;
		this.eTicaret_ProductsOrderDetailServiceImpl = eTicaret_ProductsOrderDetailServiceImpl;
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		this.eTicaret_User_AdressServiceImpl = eTicaret_User_AdressServiceImpl;
	}
	
	@RequestMapping(value = "/allregister", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView model = new ModelAndView("register");
		

		return model;

	}
	
	@RequestMapping(value = "/kayitWeb", method =  RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView  save(String name, String surname,String email, String password,String gender,String telephone){
	
		
		if (eTicaret_UsersServiceImpl.findByUserEmail(email)!= null) {
			ModelAndView model1=new ModelAndView("register");    	
	    	model1.addObject("message", " mesajınız var.");
			return model1;
        }
		ETicaret_Users user = new ETicaret_Users();
    	user.setUsername(name);
    	user.setUsersurname(surname);
    	user.setUseremail(email);  	
    	user.setUserpassword(password);
        user.setTelephone(telephone);
        user.setGender(gender);
        user.setStatus(0);
    	user.setRole("user");
    	eTicaret_UsersServiceImpl.save(user); 
		
    	return new ModelAndView("redirect:/allindex");	

	}
	
	
	@RequestMapping(value = "/kayit", method =  RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ETicaret_Users kaydet(String name, String surname,String email, String password) throws AddressException, MessagingException {
		
		ETicaret_Users user = new ETicaret_Users();
    	user.setUsername(name);
    	user.setUsersurname(surname);
    	user.setUseremail(email);  	
    	user.setUserpassword(password);
    	user.setTelephone("123");
    	user.setGender("erkek");
    	user.setStatus(0);
    	user.setRole("user");
    	ETicaret_Users newUser = eTicaret_UsersServiceImpl.save(user); 
    	
    	final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "webmail.opendart.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ecommerce@opendart.com", "Hercai123");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("ecommerce@opendart.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Opendart tan merhaba");
		msg.setContent(
				"<a href=" + baseUrl + "/acceptMail/" + email + ">Üyeliğinizi onaylamak icin tıklayınız!</a>",
				"text/html");
		msg.setSentDate(new Date());

		Transport.send(msg);
		
		return newUser;
	}
	
	// kullanıcıya onaylaması için mail gönder
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/resentMail", method = RequestMethod.POST, headers = "Accept=application/json")
		@ResponseBody
		private SignUpResponse resendMail(String email) throws AddressException, MessagingException, IOException {
			// gelen email daha önceden status 1 yapılmıssa hiçbir yes yapma sıfır ise aktif
			// et
			SignUpResponse newSignUpResponse = new SignUpResponse();
			long userId = 0;

			userId = eTicaret_UsersServiceImpl.getUserid(email);

			ETicaret_Users user = eTicaret_UsersServiceImpl.userProfile(userId);
			if (user.getStatus() == 1) {
				newSignUpResponse.setSuccess("false");
				newSignUpResponse.setMessage("Başarısız");
				newSignUpResponse.setUserid(Math.toIntExact(0));

			} else {
				newSignUpResponse.setSuccess("true");
				newSignUpResponse.setMessage("Başarılı");
				newSignUpResponse.setUserid(Math.toIntExact(userId));

				final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "webmail.opendart.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("ecommerce@opendart.com", "Hercai123");
					}
				});
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("ecommerce@opendart.com", false));

				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				msg.setSubject("Opendart tan merhaba");
				msg.setContent(
						"<a href=" + baseUrl + "/acceptMail/" + email + ">Üyeliğinizi onaylamak icin tıklayınız!</a>",
						"text/html");
				msg.setSentDate(new Date());

				Transport.send(msg);

			}
			return newSignUpResponse;
		}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/acceptMail/{email}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	private void acceptdMail(@PathVariable("email") String email)
			throws AddressException, MessagingException, IOException {

		long userId = 0;

		userId = eTicaret_UsersServiceImpl.getUserid(email);

		ETicaret_Users user = eTicaret_UsersServiceImpl.userProfile(userId);
		if (user.getStatus() == 0) {
			user.setStatus(1);
			eTicaret_UsersServiceImpl.updateProfile(user);

		} else {

		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public SignUpResponse forgotPassword(String email) {

		SignUpResponse newSignUpResponse = new SignUpResponse();

		String password;
		try {
			password = eTicaret_UsersServiceImpl.forgotPassword(email);

			if (password != "") {
				sendmail(email, password);
				newSignUpResponse.setSuccess("true");
				newSignUpResponse.setMessage("Başarılı");
				newSignUpResponse.setUserid(Math.toIntExact(0));
			}
		} catch (Exception e) {
			e.getMessage();
			newSignUpResponse.setSuccess("notactive");
			newSignUpResponse.setMessage("Başarısız");
			newSignUpResponse.setUserid(0);

		}

		return newSignUpResponse;

	}

	private void sendmail(String email, String password) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "webmail.opendart.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ecommerce@opendart.com", "Hercai123");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("ecommerce@opendart.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Opendart tan merhaba");
		msg.setContent("Sifreniz " + password, "text/html");
		msg.setSentDate(new Date());

		// MimeBodyPart messageBodyPart = new MimeBodyPart();
		// messageBodyPart.setContent("Tutorials point email", "text/html");

		// Multipart multipart = new MimeMultipart();
		// multipart.addBodyPart(messageBodyPart);
		// MimeBodyPart attachPart = new MimeBodyPart();

		// attachPart.attachFile("/var/tmp/image19.png");
		// multipart.addBodyPart(attachPart);
		// msg.setContent(multipart);
		Transport.send(msg);
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/mobileLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public SignUpResponse mobileLogin(String email, String password) {

		SignUpResponse newSignUpResponse = new SignUpResponse();

		long userId = 0;
		try {
			userId = eTicaret_UsersServiceImpl.mobileLogin(email, password);

			ETicaret_Users user = eTicaret_UsersServiceImpl.userProfile(userId);
			if (user.getStatus() == 1 && user.getUserid() > 0) {
				newSignUpResponse.setSuccess("true");
				newSignUpResponse.setMessage("Başarılı");
				newSignUpResponse.setUserid(Math.toIntExact(userId));
			}

			else if (user.getStatus() == 0 && user.getUserid() > 0) {
				newSignUpResponse.setSuccess("notactive");
				newSignUpResponse.setMessage("Başarısız");
				newSignUpResponse.setUserid(Math.toIntExact(user.getUserid()));

			}

		} catch (Exception e) {
			e.getMessage();
			newSignUpResponse.setSuccess("notactive");
			newSignUpResponse.setMessage("Başarısız");
			newSignUpResponse.setUserid(0);

		}

		return newSignUpResponse;

	}
	
	@RequestMapping(value = "/addWebOrder", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addWebOrder(String UserId, String PaymentTypeId, String Price, String Tax, String TotalPrice,String adresId) {
		String mesaj = "";
		ModelAndView model = new ModelAndView("index");
		List<CartItemDTO> cartItemList = new ArrayList<>();
		int userID = 0;
		if (UserId != "") {
			userID = Integer.valueOf(httpSession.getAttribute("UserId").toString());
		} else {
			userID = Integer.valueOf(UserId);
		}

		ETicaret_Products_Order order = new ETicaret_Products_Order();

		int paymentTypeId = Integer.valueOf(PaymentTypeId);
		int adressId = Integer.valueOf(adresId);
		double price = Double.valueOf(Price);
		double tax = Double.valueOf(Tax);
		double totalPrice = Double.valueOf(TotalPrice);
		order.setUserid(userID);
		order.setPaymentTypeId(paymentTypeId);
		Date date = new Date();
		order.setInsertDate(date);
		order.setPrice(price);
		order.setTax(tax);
		order.setTotalPrice(totalPrice);
		order.setOrderTrackingId(1);
		order.setStatus(1);
		order.setAdresId(adressId);

		try {
			ETicaret_Products_Order newOrder = eTicaret_ProductsOrderServiceImpl.save(order);
			if (newOrder.getId() > 0) {

				cartItemList = (List<CartItemDTO>) httpSession.getAttribute("cartItemList");

				for (CartItemDTO item : cartItemList) {
					ETicaret_Products_Order_Detail orderDetail = new ETicaret_Products_Order_Detail();
					orderDetail.setOrderId(Math.toIntExact(newOrder.getId()));
					orderDetail.setProductId(item.getProductId());
					orderDetail.setQuantity(item.getProductQuantity());
					orderDetail.setPrice(item.getPrice());
					orderDetail.setOrderTrackingId(1);
					Date dateOrderDetail = new Date();
					orderDetail.setInsertDate(dateOrderDetail);
					orderDetail.setStatus(1);
					// eticaret_Products_Order_DetailImpl.save(orderDetail);
				}
				httpSession.setAttribute("cartItemList", null);

			} else {
				// return mesaj;
			}
		} catch (Exception ex) {
			// return mesaj;
		}

		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BAŞLADIĞI YER.
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
		List<ETicaret_Products> urunler = eTicaret_ProductsServiceImpl.getAll();
		// List<ETicaret_Manset> mansetList =
		// eTicaret_MansetsServiceImpl.getAllOrderBySira();
		model.addObject("ana", anakategori);
		model.addObject("alt", altkategori);
		model.addObject("urunler", urunler);
		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.

		// List<ETicaret_Products> ürünler =
		// eTicaret_ProductsServiceImpl.get12Products();
		// model.addObject("ürünler", ürünler);

		// List<Tweet> tweetler =
		// twitter.timelineOperations().getUserTimeline("EcommerceLimo");
		// model.addObject("tweet", tweetler);

		// model.addObject("mansetList", mansetList);

		// List<ETicaret_Products> ensoneklenen =
		// eTicaret_ProductsServiceImpl.getClose4();
		// model.addObject("enson", ensoneklenen);
		return model;

	}
	
	@RequestMapping(value = "/alladress", method = RequestMethod.GET)
	public ModelAndView getdata() {
		List<ETicaret_User_Adress> list = eTicaret_User_AdressServiceImpl.getAll();
		ModelAndView model = new ModelAndView("adress");
		model.addObject("lists", list);
		return model;

	}

	// JQery ve Ajax kullanarak burdakai metodu tetikleyerek yapılan adress
		// kayıt işlemleri işlemleri
		@SuppressWarnings({ "unchecked", "unlikely-arg-type" }) // Derleyicini uyarı vermesi için kullanılır.
		@RequestMapping(value = "/adresssave", method = RequestMethod.POST)
		@ResponseBody
		public void adresssave(String adressname, String name, String surname, String companyname, String city,
				String town, String district,String neighborhoods, String adress, String postcode, String phone, String ordernote) {

			// ETicaret_User_Adress adres = new ETicaret_User_Adress();
			Integer userId = Integer.valueOf(httpSession.getAttribute("UserId").toString());
			ETicaret_User_Adress list = eTicaret_User_AdressServiceImpl.controlSave();

			if (list != null) {

				ETicaret_User_Adress adres = new ETicaret_User_Adress();
				adres.setId(list.getId());
				adres.setUserId(userId);
				adres.setUseradresname(adressname);
				adres.setUsername(name);
				adres.setUsersurname(surname);
				adres.setCompanyname(companyname);
				adres.setCity(city);
				adres.setTown(town);
				adres.setDistrict(district);
				adres.setNeighborhoods(neighborhoods);
				adres.setAdress(adress);
				adres.setPostcode(postcode);
				adres.setPhone(phone);
				adres.setOrdernote(ordernote);
				adres.setStatus(1);
				eTicaret_User_AdressServiceImpl.save(adres);

			} else {

				ETicaret_User_Adress adres = new ETicaret_User_Adress();

				adres.setUserId(userId);
				adres.setUseradresname(adressname);
				adres.setUsername(name);
				adres.setUsersurname(surname);
				adres.setCompanyname(companyname);
				adres.setCity(city);
				adres.setTown(town);
				adres.setDistrict(district);
				adres.setNeighborhoods(neighborhoods);
				adres.setAdress(adress);
				adres.setPostcode(postcode);
				adres.setPhone(phone);
				adres.setOrdernote(ordernote);
				adres.setStatus(1);
				eTicaret_User_AdressServiceImpl.save(adres);
			}

		}

		// JQery ve Ajax kullanarak burdakai metodu tetikleyerek yapılan
		// adress update işlemleri
		@SuppressWarnings({ "unchecked", "unlikely-arg-type" }) // Derleyicini uyarı vermesi için kullanılır.
		@RequestMapping(value = "/adressupdate", method = RequestMethod.POST)
		@ResponseBody
		public void adressupdate(String id, String adressname, String name, String surname, String companyname, String city,
				String town, String district,String neighborhoods, String adress, String postcode, String phone, String ordernote) {

			ETicaret_User_Adress adres = new ETicaret_User_Adress();
			Integer userId = Integer.valueOf(httpSession.getAttribute("UserId").toString());

			adres.setId(Long.valueOf(id));
			adres.setUserId(userId);
			adres.setUseradresname(adressname);
			adres.setUsername(name);
			adres.setUsersurname(surname);
			adres.setCompanyname(companyname);
			adres.setCity(city);
			adres.setTown(town);
			adres.setDistrict(district);
			adres.setNeighborhoods(neighborhoods);
			adres.setAdress(adress);
			adres.setPostcode(postcode);
			adres.setPhone(phone);
			adres.setOrdernote(ordernote);
			adres.setStatus(1);
			eTicaret_User_AdressServiceImpl.save(adres);

		}

		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/adresdelete", method = RequestMethod.POST, headers = "Accept=application/json")
		@ResponseBody
		public void adressdelete(String adress_id) {

			// AddToWishlistResponse addToWishlistResponse = new AddToWishlistResponse();
			int adressId = Integer.valueOf(adress_id);
			int usurId = Integer.valueOf(httpSession.getAttribute("UserId").toString());
			ETicaret_User_Adress adres = eTicaret_User_AdressServiceImpl.adressDelete(usurId, adressId);
			// adress.setUserId(usurId);


			adres.setUserId(0);
			adres.setUseradresname("");
			adres.setUsername("");
			adres.setUsersurname("");
			adres.setCompanyname("");
			adres.setCity("");		
			adres.setTown("");
			adres.setDistrict("");
			adres.setNeighborhoods("");
			adres.setAdress("");
			adres.setPostcode("");
			adres.setPhone("");
			adres.setOrdernote("");
			adres.setStatus(0);
			eTicaret_User_AdressServiceImpl.save(adres);

		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/updateform", method = RequestMethod.POST, headers = "Accept=application/json")
		@ResponseBody
		public ETicaret_User_Adress updateform(String adress_id) {

			// AddToWishlistResponse addToWishlistResponse = new AddToWishlistResponse();
			int adressId = Integer.valueOf(adress_id);
			int usurId = Integer.valueOf(httpSession.getAttribute("UserId").toString());
			ETicaret_User_Adress adres = eTicaret_User_AdressServiceImpl.adressDelete(usurId, adressId);
			// adress.setUserId(usurId);
			return adres;


			
		}

	
	@RequestMapping(value = "/allfaq", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public FAQResponse getFAQ() {

		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

		FAQResponse fAQResponse = new FAQResponse();
		fAQResponse.setDescription(baseUrl + "/faq.html");
		fAQResponse.setTitle("Sık Sorulan Sorular");
		return fAQResponse;
	}
	
	@RequestMapping(value = "/allterms", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public FAQResponse getTerms() {

		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

		FAQResponse fAQResponse = new FAQResponse();
		fAQResponse.setDescription(baseUrl + "/terms.html");
		fAQResponse.setTitle("Şartlar ve Koşullar");
		return fAQResponse;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/userProfile", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public UserProfileResponse getUserProfile(String user_id) {

		Long userID = Long.valueOf(user_id);
		UserProfileResponse userProfileResponse = new UserProfileResponse();
		ETicaret_Users user = eTicaret_UsersServiceImpl.userProfile(userID);
		if (user != null) {
			userProfileResponse.setName(user.getUsername());
			userProfileResponse.setSurname(user.getUsersurname());
			userProfileResponse.setEmail(user.getUseremail());
			userProfileResponse.setPassword(user.getUserpassword());
			userProfileResponse.setTelephone(user.getTelephone().toString());
			userProfileResponse.setGender(user.getGender());
			userProfileResponse.setMessage("true");
		} else {
			userProfileResponse.setMessage("false");

		}

		return userProfileResponse;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public UserProfileResponse setUpdateProfile(String user_id, String name, String surname, String email,
			String password, String telephone, String gender) {
		Long userID = Long.valueOf(user_id);
		UserProfileResponse userProfileResponse = new UserProfileResponse();

		ETicaret_Users gelenUser = new ETicaret_Users();
		gelenUser.setUserid(userID);
		gelenUser.setUsername(name);
		gelenUser.setUsersurname(surname);
		gelenUser.setUseremail(email);
		gelenUser.setUserpassword(password);
		gelenUser.setTelephone(telephone);
		gelenUser.setRole("user");
		gelenUser.setStatus(1);
		gelenUser.setGender(gender);
		ETicaret_Users user = eTicaret_UsersServiceImpl.updateProfile(gelenUser);
		try {
			if (user != null) {

				userProfileResponse.setName(user.getUsername());
				userProfileResponse.setSurname(user.getUsersurname());
				userProfileResponse.setEmail(user.getUseremail());
				userProfileResponse.setPassword(user.getUserpassword());
				userProfileResponse.setTelephone(user.getTelephone().toString());
				userProfileResponse.setGender(user.getGender());
				userProfileResponse.setMessage("true");
			} else {
				userProfileResponse.setMessage("false");

			}
		} catch (Exception ex) {
			userProfileResponse.setMessage("false");
		}

		return userProfileResponse;
	}
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	@ResponseBody
	public AddOrderResponse addOrder(String UserId, String PaymentTypeId, String Price, String Tax, String TotalPrice) {
		AddOrderResponse addOrderResponse = new AddOrderResponse();
		ETicaret_Products_Order order = new ETicaret_Products_Order();
		int userID = Integer.valueOf(UserId);
		int paymentTypeId = Integer.valueOf(PaymentTypeId);
		double price = Double.valueOf(Price);
		double tax = Double.valueOf(Tax);
		double totalPrice = Double.valueOf(TotalPrice);
		order.setUserid(userID);
		order.setPaymentTypeId(paymentTypeId);
		Date date = new Date();
		order.setInsertDate(date);
		order.setPrice(price);
		order.setTax(tax);
		order.setTotalPrice(totalPrice);
		order.setOrderTrackingId(1);
		order.setStatus(1);

		try {
			ETicaret_Products_Order newOrder = eTicaret_ProductsOrderServiceImpl.save(order);
			if (newOrder.getId() > 0) {
				addOrderResponse.setMessage("Başarılı");
				addOrderResponse.setSuccess("true");
				addOrderResponse.setOrderId(Math.toIntExact(newOrder.getId()));
			} else {
				addOrderResponse.setMessage("Başarısız");
				addOrderResponse.setSuccess("false");
				addOrderResponse.setOrderId(0);
			}
		} catch (Exception ex) {
			addOrderResponse.setMessage("Başarısız");
			addOrderResponse.setSuccess("false");
			addOrderResponse.setOrderId(0);
		}
		return addOrderResponse;
	}

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@RequestMapping(value = "/addOrderDetail", method = RequestMethod.POST)
	@ResponseBody
	public AddOrderDetailResponse addOrderDetail(String OrderId, List<ProductDTO> productDTOList) {
		AddOrderDetailResponse addOrderDetailResponse = new AddOrderDetailResponse();
		int orderId = Integer.valueOf(OrderId);
		try {
			for (int i = 0; i < productDTOList.size(); i++) {

				ETicaret_Products_Order_Detail orderDetail = new ETicaret_Products_Order_Detail();
				orderDetail.setOrderId(orderId);
				orderDetail.setProductId(productDTOList.get(i).getProductID());
				orderDetail.setQuantity(productDTOList.get(i).getQuantity());
				orderDetail.setPrice(productDTOList.get(i).getPrice());
				orderDetail.setOrderTrackingId(1);
				Date date = new Date();
				orderDetail.setInsertDate(date);
				orderDetail.setStatus(1);
				eTicaret_ProductsOrderDetailServiceImpl.save(orderDetail);
			}
			addOrderDetailResponse.setMessage("Başarılı");
			addOrderDetailResponse.setSuccess("true");
		} catch (Exception e) {
			addOrderDetailResponse.setMessage("Başarısız");
			addOrderDetailResponse.setSuccess("false");
		}

		return addOrderDetailResponse;
	}

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@RequestMapping(value = "/addOrderDetailOne", method = RequestMethod.POST)
	@ResponseBody
	public AddOrderDetailResponse addOrderDetailOne(String OrderId, String ProductId, String Quantity, String Price) {
		AddOrderDetailResponse addOrderDetailResponse = new AddOrderDetailResponse();
		int orderId = Integer.valueOf(OrderId);
		int productId = Integer.valueOf(ProductId);
		double quantity = Double.valueOf(Quantity);
		double price = Double.valueOf(Price);
		try {

			ETicaret_Products_Order_Detail orderDetail = new ETicaret_Products_Order_Detail();
			orderDetail.setOrderId(orderId);
			orderDetail.setProductId(productId);
			orderDetail.setQuantity(quantity);
			orderDetail.setPrice(price);
			orderDetail.setOrderTrackingId(1);
			Date date = new Date();
			orderDetail.setInsertDate(date);
			orderDetail.setStatus(1);
			eTicaret_ProductsOrderDetailServiceImpl.save(orderDetail);

			addOrderDetailResponse.setMessage("Başarılı");
			addOrderDetailResponse.setSuccess("true");
		} catch (Exception e) {
			addOrderDetailResponse.setMessage("Başarısız");
			addOrderDetailResponse.setSuccess("false");
		}

		return addOrderDetailResponse;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/orders", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public MyOrdersResponse getMyOrders(String user_id) {
		MyOrdersResponse myOrdersResponse = new MyOrdersResponse();

		List<OrderDTO> mainETicaret_Products_OrderList = new ArrayList<OrderDTO>();

		int UserId = Integer.valueOf(user_id);
		List<ETicaret_Products_Order> orderList = eTicaret_ProductsOrderServiceImpl.getMyOrders(UserId);

		for (ETicaret_Products_Order str : orderList) {
			// Burada OrderDTo yapılabilir çünkü kullanıcı siparişin durumunu
			// kargo durumunu ödemenin ne ile yapıldığını görmek isteyebilir
			// örneğin PaymentTYpeıd yerine kapıda ödeme yazsın
			OrderDTO order = new OrderDTO();
			order.setOrderid(str.getId());
			order.setPaymentmode(str.getPaymentTypeId());
			order.setDate(str.getInsertDate());
			order.setPrice(str.getPrice());
			order.setTax(str.getTax());
			order.setTotal(str.getTotalPrice());
			order.setOrderTrackingId(str.getOrderTrackingId());

			List<ETicaret_Products_Order_Detail> orderDetailList = eTicaret_ProductsOrderDetailServiceImpl
					.getOrderDetailsByOrderId(Math.toIntExact(str.getId()));
		
			List<ProductDTO> orderDetailProductList = new ArrayList<ProductDTO>();
			for (ETicaret_Products_Order_Detail strorderDetail : orderDetailList) {
			
				List<ETicaret_Products> productListFirst = eTicaret_ProductsServiceImpl
						.ürüngetir(Long.valueOf(strorderDetail.getProductId()));
				//burası order detail deki tek bir ürün için
				for (ETicaret_Products product : productListFirst) {
					ProductDTO  newProductsDTO = new ProductDTO();
					newProductsDTO.setProductID(Math.toIntExact(product.getProductID()));
					newProductsDTO.setCategoryid(Math.toIntExact((product.getCategoryid())));
					newProductsDTO.setName(product.getName());
					newProductsDTO.setDescription(product.getDescription());
					newProductsDTO.setOldPrice(Double.valueOf(product.getOldPrice()));
					newProductsDTO.setPrice(Double.valueOf(product.getPrice()));
					newProductsDTO.setImage(product.getImage());
					newProductsDTO.setLimit(Double.valueOf(product.getLimit()));
					newProductsDTO.setStock(Integer.valueOf(product.getStock()));
					List<Object> mediaList = eTicaret_CategoriesServiceImpl
							.getMainCategories_Products_Medias(Math.toIntExact(product.getProductID()));
					List<ETicaret_Products_Media> newMediaList = new ArrayList<ETicaret_Products_Media>();
					List<Object> resultMedia = (List<Object>) mediaList;
					Iterator itrMedia = resultMedia.iterator();
					while (itrMedia.hasNext()) {
						ETicaret_Products_Media newETicaret_Products_Media = new ETicaret_Products_Media();
						Object[] objMedia = (Object[]) itrMedia.next();

						newETicaret_Products_Media.setId(Integer.valueOf((objMedia[0].toString())));
						newETicaret_Products_Media.setMedia_type_id(Integer.valueOf((objMedia[1].toString())));
						newETicaret_Products_Media.setProductId(Integer.valueOf((objMedia[2].toString())));
						newETicaret_Products_Media.setMedia_name(objMedia[3].toString());
						newETicaret_Products_Media.setMedia_url(objMedia[4].toString());
						newMediaList.add(newETicaret_Products_Media);

					}
					newProductsDTO.setProductMedias(newMediaList);
					orderDetailProductList.add(newProductsDTO);
				

				}
				
				order.setOrdredproduct(orderDetailProductList);

			}
			mainETicaret_Products_OrderList.add(order);

		}
		myOrdersResponse.setSuccess("true");
		myOrdersResponse.setOrderes(mainETicaret_Products_OrderList);
		return myOrdersResponse;

	}



}
