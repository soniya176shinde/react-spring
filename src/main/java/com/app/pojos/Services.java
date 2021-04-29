package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "Service_Details")
@Proxy(lazy = false)
public class Services
{
	@Id //PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_id")
	private Long service_id;
	@Column
	private String service_type;
    @Column
	private Double service_charges;
    @Column
	private String status;
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="company_id")
	//@JsonIgnoreProperties("services")
  //  @LazyCollection(LazyCollectionOption.FALSE) 
	private Company company;
    
    
    @OneToMany(mappedBy = "services",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	@JsonIgnoreProperties("services")//To tell SC : ignore property of list of accts during ser n de-serial .
//	@LazyCollection(LazyCollectionOption.FALSE) 
  
    private List<Quotation> quotation = new ArrayList<>();
    public Services()
    {
    	System.out.println("service Constructor....");
    }
    
	public Services(String service_type, Double service_charges, String status, Company company) {
		super();
		this.service_type = service_type;
		this.service_charges = service_charges;
		this.status = status;
		this.company = company;
	}
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
		return "Service [service_id=" + service_id + ", service_type=" + service_type + ", service_charges="
				+ service_charges + ", status=" + status + "]";
	}
	
	
}
