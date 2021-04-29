package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CompanyRepository;
import com.app.dao.FeedbackRepository;
import com.app.dto.FeedbackDto;
import com.app.pojos.Clients;
import com.app.pojos.Company;
import com.app.pojos.Feedback;
@Service
@Transactional 
public class FeedbackServiceImpl implements IFeedbackService{

	
	@Autowired
	private FeedbackRepository feedbackRepo;
	@Override
	public List<Feedback> getAllfeedback() {
		return feedbackRepo.findAll();
	}

	@Override
	public Feedback addFeedbackDetails(FeedbackDto feedbackDTO) {
		Feedback feedback = new Feedback();
		BeanUtils.copyProperties(feedbackDTO, feedback);
		System.out.println("add feedback src : " +feedbackDTO);
		System.out.println(feedback);
		// invoke dao's method for persistence
		return feedbackRepo.save(feedback);
	}

	@Override
	public Feedback getFeedbackDetails(Long feedbackId) {
		Optional<Feedback > optionalUser = feedbackRepo.findById(feedbackId);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

}
