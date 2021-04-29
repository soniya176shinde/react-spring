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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Feedback_Details")
@Proxy(lazy = false)
public class Feedback {
	
	@Id //PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="feedback_id")
	private Long feedbackId;
	@Column
	private String experience ;
	@Column
    private String comments;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="company_id")
	//@JsonIgnoreProperties("feedback")
	private Company company;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id")
	//@JsonIgnoreProperties("feedback")
	//@LazyCollection(LazyCollectionOption.FALSE) 
	private Clients client;
	public Feedback()
	{
		System.out.println("Feedback Constructor....");
   }
	
	public Feedback(String experience, String comments, Company company, Clients client) {
		super();
		this.experience = experience;
		this.comments = comments;
		this.company = company;
		this.client = client;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", experience=" + experience + ", comments=" + comments + "]";
	}
	

}
