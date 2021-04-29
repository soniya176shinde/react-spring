package com.app.dto;


public class LoginDto {

	private Long userId;
	
	private String email ;
   
	private String password;
    
	private String role ;
	
	private String status ;
	
	public LoginDto() 
	{
		
		
	}
	public LoginDto(Long userId, String email, String password, String role, String status) {
		super();
		this.userId = userId;
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
		return "LoginDto [userId=" + userId + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", status=" + status + "]";
	}
	
}
