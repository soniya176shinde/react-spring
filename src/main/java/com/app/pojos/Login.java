package com.app.pojos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Login_Details")
public class Login
{
	@Id //PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(length = 30,unique = true)
	private String email ;
    @Column(length = 20)
	@JsonIgnore
	private String password;
     @Column(length = 15)
	private String role ;
	@Column(length = 15)
	private String status ;
	//@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="user",orphanRemoval=true)
//	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
//	//@JsonIgnoreProperties("user")
	//@OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Company  company;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clients  client;
	public Login() {
		System.out.println("Login Constructor....");
	}
	public Login( String email, String password, String role, String status) {
		super();
		
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", status=" + status + "]";
	}
	
	
}
