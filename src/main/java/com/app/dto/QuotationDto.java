package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;



import com.app.pojos.Clients;
import com.app.pojos.Company;
import com.app.pojos.Services;


public class QuotationDto {
	
	
	private Long quotationId;
	
	private String quotationName ;
   
	private String address;
	private String receiver;
    
	public QuotationDto(String quotationName, String address, String receiver, String shift_from, String shift_to,
			String status, String size, LocalDate shift_date, Company company, Services services, Clients clients,
			LocalTime shift_time) {
		super();
		this.quotationName = quotationName;
		this.address = address;
		this.receiver = receiver;
		this.shift_from = shift_from;
		this.shift_to = shift_to;
		this.status = status;
		this.size = size;
		this.shift_date = shift_date;
		this.company = company;
		this.services = services;
		this.clients = clients;
		this.shift_time = shift_time;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	private String shift_from ;
    
   	private String shift_to ;
  
   	private String status;
   
   	private String size ;
   
	private LocalDate shift_date;
	private Company company;
   	private Services services;
   	private Clients clients;
	private LocalTime shift_time;
	public LocalTime getShift_time() {
		return shift_time;
	}


	public void setShift_time(LocalTime shift_time) {
		this.shift_time = shift_time;
	}


	public QuotationDto()
	{}
	

	


	

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Services getServices() {
		return services;
	}


	public void setServices(Services services) {
		this.services = services;
	}


	public Clients getClients() {
		return clients;
	}


	public void setClients(Clients clients) {
		this.clients = clients;
	}


	public Long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Long quotationId) {
		this.quotationId = quotationId;
	}

	public String getQuotationName() {
		return quotationName;
	}

	public void setQuotationName(String quotationName) {
		this.quotationName = quotationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShift_from() {
		return shift_from;
	}

	public void setShift_from(String shift_from) {
		this.shift_from = shift_from;
	}

	public String getShift_to() {
		return shift_to;
	}

	public void setShift_to(String shift_to) {
		this.shift_to = shift_to;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public LocalDate getShift_date() {
		return shift_date;
	}


	public void setShift_date(LocalDate shift_date) {
		this.shift_date = shift_date;
	}


	@Override
	public String toString() {
		return "QuotationDto [quotationId=" + quotationId + ", quotationName=" + quotationName + ", address=" + address
				+ ", shift_from=" + shift_from + ", shift_to=" + shift_to + ", status=" + status + ", size=" + size
				+ ", shift_date=" + shift_date + ", company=" + company + ", services=" + services + ", clients="
				+ clients + ", shift_time=" + shift_time + "]";
	}

	
	

}
