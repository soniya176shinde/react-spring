package com.app.service;

import java.util.List;

import com.app.dto.FeedbackDto;
import com.app.pojos.Feedback;

public interface IFeedbackService {

	List<Feedback> getAllfeedback();

	Feedback addFeedbackDetails(FeedbackDto feedbackDTO);

	Feedback getFeedbackDetails(Long feedbackId);

}
