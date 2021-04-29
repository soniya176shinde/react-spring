package com.app.dto;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.app.pojos.Login;

public class CompanyDto
{

	
	private Long companyId;
	
	private String company_name ;
	
    private String company_email;
    
	private String address ;
	
	private String city ;
	
	private String state ;
	
	private String pin_code ;
	private String contact_no ;
	private byte[] image;
	private String imageContentType;
	private String imageName;
	private Login user;
	public CompanyDto() {
		
	}
	public CompanyDto(String company_name, String company_email, String address, String city,
			String state, String pin_code, String contact_no) {
		super();
		
		this.company_name = company_name;
		this.company_email = company_email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin_code = pin_code;
		this.contact_no = contact_no;

		
	}
	public CompanyDto(Long companyId, String company_name, String company_email, String address, String city,
			String state, String pin_code, String contact_no, byte[] image, String imageContentType, String imageName,Login user) {
		super();
		this.companyId = companyId;
		this.company_name = company_name;
		this.company_email = company_email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin_code = pin_code;
		this.contact_no = contact_no;
		this.image = image;
		this.imageContentType = imageContentType;
		this.imageName = imageName;
		this.user = user;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Login getUser() {
		return user;
	}
	public void setUser(Login user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CompanyDto [companyId=" + companyId + ", company_name=" + company_name + ", company_email="
				+ company_email + ", address=" + address + ", city=" + city + ", state=" + state + ", pin_code="
				+ pin_code + ", contact_no=" + contact_no + ", image=" + Arrays.toString(image) + ", imageContentType="
				+ imageContentType + ", imageName=" + imageName + ", user=" + user + "]";
	}
	
	
}
