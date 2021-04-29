package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.QuotationRepository;
import com.app.dto.QuotationDto;

import com.app.pojos.Quotation;
@Service
@Transactional 
public class QuotationServiceImpl implements IQuotationService {

	@Autowired
	private QuotationRepository quotationRepo;
	@Override
	public Quotation addQuotationDetails(QuotationDto quotationdto) {
		Quotation quotation = new Quotation();
		BeanUtils.copyProperties(quotationdto, quotation);
		System.out.println("add Quotation src : " +quotationdto);
		System.out.println(quotation);
		// invoke dao's method for persistence
		return quotationRepo.save(quotation);
	}

	@Override
	public List<Quotation> getAllQuotation() {
		return quotationRepo.findAll();

	}

	@Override
	public Quotation getQuotationDetails(Long quotationId) {
		Optional<Quotation> optionalUser = quotationRepo.findById(quotationId);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	@Override
	public Quotation updateQuotationDetails(Long quotationId, QuotationDto quotationdto) {
		System.out.println("in update "+quotationdto);
		
		Quotation QuotationDetails=quotationRepo.findById(quotationId).get();
		System.out.println("Quotation dtls from db "+QuotationDetails);
		
		BeanUtils.copyProperties(quotationdto, QuotationDetails);
	
		System.out.println("updated Quotation dtls "+QuotationDetails);
		
		return QuotationDetails;
	}

	@Override
	public void deleteQuotationDetails(Long quotationId) {
	
				boolean exists = quotationRepo.existsById(quotationId);
				if (!exists)
					throw new ResourceNotFoundException("Invalid Quotation id!!!!!");
				quotationRepo.deleteById(quotationId);
				return;
		
	}

}
