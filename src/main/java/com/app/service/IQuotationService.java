package com.app.service;

import java.util.List;

import com.app.dto.QuotationDto;
import com.app.pojos.Quotation;

public interface IQuotationService {

	Quotation addQuotationDetails(QuotationDto quotationdto);

	

	List<Quotation> getAllQuotation();



	Quotation getQuotationDetails(Long quotationId);



	Quotation updateQuotationDetails(Long quotationId, QuotationDto quotationdto);



	void deleteQuotationDetails(Long quotationId);

}
