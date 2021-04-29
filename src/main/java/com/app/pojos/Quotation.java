package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "Quotation_Details")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Proxy(lazy = false)
public class Quotation 
{
	@Id //PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quotation_id")
	private Long quotationId;
	@Column
	private String quotationName ;
    @Column
	//@JsonIgnore  //it ignore data while fetching
	private String address;
    @Column
	private String shift_from ;
    @Column
   	private String shift_to ;
    @Column
   	private String status;
    @Column
   	private String size ;
    @Column(name="shift_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate shift_date;
    
    @DateTimeFormat(pattern = "HH:mm" )
	private LocalTime shift_time;

    @ManyToOne(fetch = FetchType.EAGER)
   	@JoinColumn(name="service_id")
   	@JsonIgnoreProperties("services")
   // @LazyCollection(LazyCollectionOption.FALSE)
    
   	private Services services;
    
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER  )
   	@JoinColumn(name="client_id")
   	@JsonIgnoreProperties("clients")
      // @LazyCollection(LazyCollectionOption.FALSE) 
   	private Clients clients;
    
    @ManyToOne(fetch = FetchType.EAGER )
   	@JoinColumn(name="company_id")
  	//@JsonIgnoreProperties("company")
   // @JsonIgnore
      // @LazyCollection(LazyCollectionOption.FALSE) 
   	private Company company;
    public Quotation()
    {
    	
    	
    	System.out.println("Quotation Constructor....");
    }
	

	public Quotation(String quotationName, String address, String shift_from, String shift_to, String status,
			String size, LocalDate shift_date, LocalTime shift_time, Services services, Clients clients,
			Company company) {
		super();
		this.quotationName = quotationName;
		this.address = address;
		this.shift_from = shift_from;
		this.shift_to = shift_to;
		this.status = status;
		this.size = size;
		this.shift_date = shift_date;
		this.shift_time = shift_time;
		this.services = services;
		this.clients = clients;
		this.company = company;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	public LocalTime getShift_time() {
		return shift_time;
	}
	public void setShift_time(LocalTime shift_time) {
		this.shift_time = shift_time;
	}
	@Override
	public String toString() {
		return "Quotation [quotationId=" + quotationId + ", quotationName=" + quotationName + ", address=" + address
				+ ", shift_from=" + shift_from + ", shift_to=" + shift_to + ", status=" + status + ", size=" + size
				+ ", Shift_date=" + shift_date + ", shift_time=" + shift_time + ", services=" + services + ", clients="
				+ clients + ", company=" + company + ", getQuotationId()=" + getQuotationId() + ", getQuotationName()="
				+ getQuotationName() + ", getAddress()=" + getAddress() + ", getShift_from()=" + getShift_from()
				+ ", getShift_to()=" + getShift_to() + ", getStatus()=" + getStatus() + ", getSize()=" + getSize()
				+ ", getShift_date()=" + getShift_date() + ", getServices()=" + getServices() + ", getClients()="
				+ getClients() + ", getCompany()=" + getCompany() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
    
    
    
    
}
