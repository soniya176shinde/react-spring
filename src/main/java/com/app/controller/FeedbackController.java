package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CompanyDto;
import com.app.dto.FeedbackDto;
import com.app.dto.ResponseDTO;
import com.app.pojos.Feedback;
import com.app.pojos.Quotation;
import com.app.service.ICompanyService;
import com.app.service.IFeedbackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController
{
	@Autowired
	private IFeedbackService feedbackService;

	
	@GetMapping
	public ResponseDTO<?> getAllfeedback() {
		System.out.println("in get all feedback");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching feedback list successfully", feedbackService.getAllfeedback());
	}
	
	
	@PostMapping("/add")
	public ResponseDTO<?> addFeedbackDetails(@RequestBody FeedbackDto feedbackDTO) {
		

		System.out.println("in add feedback details " + feedbackDTO);
		return new ResponseDTO<>(HttpStatus.OK, "feedback details added", feedbackService.addFeedbackDetails(feedbackDTO));
	}
	
	
	
	@GetMapping("/{feedbackId}")
	public ResponseDTO<?> getFeedbackDetails(@PathVariable Long feedbackId) {
		System.out.println("in get feedback dtls " + feedbackId);
		return new ResponseDTO<>(HttpStatus.OK, "Sending feedback details", feedbackService.getFeedbackDetails(feedbackId));
	}
	
	@GetMapping("/get_feedback_by_companyId/{companyId}")
	public ResponseDTO<?> getFeedbackDetails_by_company(@PathVariable Long companyId) {
		System.out.println("in get feedback dtls " + companyId);
		List<Feedback> l1=feedbackService.getAllfeedback();
		System.out.println(l1);
		List<Feedback> l2=new ArrayList<>();
		for (Feedback q: l1)   
		{ 
			if((q.getCompany().getCompanyId())== companyId )
			{ 
				
				l2.add(q);
				
				
			}
		}
		System.out.println(l2);
		return new ResponseDTO<>(HttpStatus.OK, "Sending Feedback details", l2);
	}
}
