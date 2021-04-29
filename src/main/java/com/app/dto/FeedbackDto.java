package com.app.dto;

import com.app.pojos.Clients;
import com.app.pojos.Company;

public class FeedbackDto {
	
	private Long feedbackId;
	
	private String experience ;
	
    private String comments;
    private Company company;
    private Clients client;
    public FeedbackDto()
    {}


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


	public FeedbackDto(Long feedbackId, String experience, String comments, Company company, Clients client) {
		super();
		this.feedbackId = feedbackId;
		this.experience = experience;
		this.comments = comments;
		this.company = company;
		this.client = client;
	}


	@Override
	public String toString() {
		return "FeedbackDto [feedbackId=" + feedbackId + ", experience=" + experience + ", comments=" + comments + "]";
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

}
