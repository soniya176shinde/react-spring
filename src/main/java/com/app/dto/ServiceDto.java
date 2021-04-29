package com.app.dto;

import com.app.pojos.Company;

public class ServiceDto 
{
	
	private Long service_id;
	
	private String service_type;
  
	private Double service_charges;
    
	private String status;
     private Company company;
	public Long getService_id() {
		return service_id;
	}
	public void setService_id(Long service_id) {
		this.service_id = service_id;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public Double getService_charges() {
		return service_charges;
	}
	public void setService_charges(Double service_charges) {
		this.service_charges = service_charges;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "ServiceDto [service_id=" + service_id + ", service_type=" + service_type + ", service_charges="
				+ service_charges + ", status=" + status + ", company=" + company + "]";
	}
     
}
