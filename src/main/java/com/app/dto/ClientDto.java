package com.app.dto;

import com.app.pojos.Login;

public class ClientDto {

	
	private Long clientId;
	
	private String mobile_no ;
   
	private String address;
   
	private String status ;
	private Login user;
    
	public ClientDto()
	{}
	

	


	public Login getUser() {
		return user;
	}





	public void setUser(Login user) {
		this.user = user;
	}





	public ClientDto(String mobile_no, String address, String status, Login user) {
		super();
		this.mobile_no = mobile_no;
		this.address = address;
		this.status = status;
		this.user = user;
	}





	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClientDto [clientId=" + clientId + ", mobile_no=" + mobile_no + ", address=" + address + ", status="
				+ status + "]";
	}
   
}
