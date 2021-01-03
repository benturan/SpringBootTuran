<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%! 
	String sifre=""; 
    String userName="";
    String userId="";

%>
				<%
	HttpSession onemliSayfa = request.getSession();	
				 sifre = (String)onemliSayfa.getValue("realpwd");
	if (onemliSayfa.getValue("realpwd")!=""){	
		
		sifre =  (String)onemliSayfa.getValue("realpwd");
		userName =  (String)onemliSayfa.getValue("UserName");
		userId =  (String)onemliSayfa.getValue("UserId");
		
	}
%>
				
				
				 <% if (sifre!=null) 
				 { 
					 out.print("<span class=\"fa\"><b>H</b>OŞ GELDİN <br> &nbsp;  &nbsp; "+userName+"</br></span>");
					 out.write("<a href=\"/closesession\"><button style=\"font-size:24px\"> <i class=\"fa fa-sign-out\"></i></button></a>");
				 %>
     
                 <% } 
				 else { %>
         <a class="login-btn btn-outlined-invert" href="#"
						data-toggle="modal" data-target="#loginModal"><i
						class="icon-profile"></i>
						 <span><b>G</b>İRİŞ Yap</span></a>
						 
      <% } %>