package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Client_Details")
@Proxy(lazy = false)

public class Clients {

	@Id //PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private Long clientId;
	@Column(length = 10)
	private String mobile_no ;
    @Column
	//@JsonIgnore
	private String address;
    @Column(length = 15)
	private String status ;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Login user;
    
    
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	@JsonIgnoreProperties("client")//To tell SC : ignore property of list of accts during ser n de-serial .
    @LazyCollection(LazyCollectionOption.FALSE) 
    private List<Feedback> feedback = new ArrayList<>();
    
    @OneToMany(mappedBy = "clients",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
   	@JsonIgnoreProperties("clients")//To tell SC : ignore property of list of accts during ser n de-serial .
//   	@LazyCollection(LazyCollectionOption.FALSE) 
   	private List<Quotation> quotation = new ArrayList<>();
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
	public Login getUser() {
		return user;
	}
	public void setUser(Login user) {
		this.user = user;
	}
	public Clients()
	{
		System.out.println("Client Constructor....");
	}
	public Clients(String mobile_no, String address, String status, Login user) {
		super();
		this.mobile_no = mobile_no;
		this.address = address;
		this.status = status;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Clients [clientId=" + clientId + ", mobile_no=" + mobile_no + ", address=" + address + ", status="
				+ status + "]";
	}
    
}
