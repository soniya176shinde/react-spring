package com.app.pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "Company_Details")
//@Proxy(lazy = false)

public class Company 
{

	@Id //PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private Long companyId;
	@Column
	private String company_name ;
	@Column(length = 20,unique = true)
    private String company_email;
    @Column
	private String address ;
	@Column
	private String city ;
	@Column
	private String state ;
	@Column
	private String pin_code ;
	@Column(length = 10)
	private String contact_no ;
	@Lob
	private byte[] image;
	@Column(length = 30)
	private String imageContentType;
	@Column(length = 40)
	private String imageName;
	
	// @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")

	 private Login user;
	
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnoreProperties("company")//To tell SC : ignore property of list of accts during ser n de-serial .
//	@LazyCollection(LazyCollectionOption.FALSE) 
	private List<Services> services = new ArrayList<>();
	
 
	 @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	
	 private List<Feedback> feedback = new ArrayList<>();
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	
	private List<Quotation> quotation = new ArrayList<>();
	
	 public Company() {
		 System.out.println("Company Constructor....");
		}
	public Company(String company_name, String company_email, String address, String city, String state,
			String pin_code, String contact_no, byte[] image, String imageContentType, String imageName, Login user) {
		super();
		
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
	public Login getUser() {
		return user;
	}
	public void setUser(Login user) {
		this.user=user;
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
	
	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	}
	
	public void addService(Services a) {
		services.add(a);
		a.setCompany(this);
	}

	public void removeService(Services a) {
		services.remove(a);
		a.setCompany(null);
	}


	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", company_name=" + company_name + ", company_email=" + company_email
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", pin_code=" + pin_code
				+ ", contact_no=" + contact_no + ", image=" + Arrays.toString(image) + ", imageContentType="
				+ imageContentType + ", imageName=" + imageName + ", user=" + user + "]";
	}

	
	
	
}
