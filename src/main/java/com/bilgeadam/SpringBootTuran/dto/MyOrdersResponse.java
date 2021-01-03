package com.bilgeadam.SpringBootTuran.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyOrdersResponse {
	private String success;

    private String userid;
    private String useremail;
    private String tax;
    private String shipping;
    private List<OrderDTO> orderes = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	public List<OrderDTO> getOrderes() {
		return orderes;
	}
	public void setOrderes(List<OrderDTO> orderes) {
		this.orderes = orderes;
	}

}
