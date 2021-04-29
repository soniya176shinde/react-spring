package com.app.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.dto.QuotationDto;
import com.app.dto.ResponseDTO;

import com.app.pojos.Quotation;

import com.app.service.IQuotationService;
import com.app.service.Notificationservice;

@RestController
@RequestMapping("/quotation")
@CrossOrigin
public class QuotationController
{
	@Autowired
	private IQuotationService quotationService;
	@Autowired
	private Notificationservice notification;
	
	@GetMapping
	public ResponseDTO<?> getAllQuotation() {
		System.out.println("in get all Quotation");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching Quotation list successfully", quotationService.getAllQuotation());
	}
	
	
	@PostMapping("/add")
	public ResponseDTO<?> addQuotationDetails(@RequestBody QuotationDto quotationdto) {
		
            quotationdto.setStatus("pending");
		System.out.println("in add Quotation details " + quotationdto);
		return new ResponseDTO<>(HttpStatus.OK, "Quotation details added", quotationService.addQuotationDetails(quotationdto));
	}
	
	
	
	@GetMapping("/{quotationId}")
	public ResponseDTO<?> getQuotationDetails(@PathVariable Long quotationId) {
		System.out.println("in get Quotation dtls " + quotationId);
		return new ResponseDTO<>(HttpStatus.OK, "Sending Quotation details", quotationService.getQuotationDetails(quotationId));
	}

	@GetMapping("/get_quotation_by_clientId/{clientId}")
	public ResponseDTO<?> getQuotationDetails_by_client(@PathVariable Long clientId) {
		System.out.println("in get Quotation dtls " + clientId);
		List<Quotation> l1=quotationService.getAllQuotation();
		List<Quotation> l2=new ArrayList<>();
		for (Quotation q: l1)   
		{ 
			if((q.getClients().getClientId())== clientId )
			{ 
				
				l2.add(q);
				
			}
		}
		System.out.println(l2);
		return new ResponseDTO<>(HttpStatus.OK, "Sending Quotation details", l2);
	}
	
	@GetMapping("/get_quotation_by_companyId/{companyId}")
	public ResponseDTO<?> getQuotationDetails_by_company(@PathVariable Long companyId) {
		System.out.println("in get Quotation dtls " + companyId);
		List<Quotation> l1=quotationService.getAllQuotation();
		System.out.println(l1);
		List<Quotation> l2=new ArrayList<>();
		for (Quotation q: l1)   
		{ 
			if((q.getCompany().getCompanyId())== companyId )
			{ 
				
				l2.add(q);
				
				
			}
		}
		System.out.println(l2);
		return new ResponseDTO<>(HttpStatus.OK, "Sending Quotation details", l2);
	}
	
	@PutMapping("/{quotationId}")
	public ResponseDTO<?> updateQuotationDetails(@PathVariable Long quotationId, @RequestBody QuotationDto quotationdto) {
		System.out.println("in rest : update details " + quotationId + " " + quotationdto);
		try {
		Quotation q=quotationService.updateQuotationDetails(quotationId, quotationdto);
		System.out.println("mail"+q);
		if(q != null)
		{
			System.out.println("quotation update");
			System.out.println(quotationdto.getReceiver());
			System.out.println(quotationdto.getStatus());
			String sub = "Packers and Movers";
			String msg="";
			if(quotationdto.getStatus().equals("approved"))
			{
			  msg = "Welcome Client ......  Your quotation is  " + quotationdto.getStatus() +"  .  Your quotation will be delivered on "+quotationdto.getShift_date();
			}
			else if(quotationdto.getStatus().equals("rejected"))
			{
				  msg = "Sorry Client ......  your quotation is  " + quotationdto.getStatus() ;
			}
			else
			{
				msg = "Thanks for your support ......  your quotation is successfully " + quotationdto.getStatus() ;
			}
			notification.sendMail(quotationdto.getReceiver(), sub, msg);
		
		}
		return new ResponseDTO<>(HttpStatus.OK, "Updated Quotation details",
				q);
		}
		catch (RuntimeException e) 
		{
		return new ResponseDTO<>( HttpStatus.INTERNAL_SERVER_ERROR,"not able to send mail reason = "+e.getMessage(),e);	
		}
		catch (Exception e) 
		{
		return new ResponseDTO<>( HttpStatus.INTERNAL_SERVER_ERROR,"not able to send mail reason = "+e.getMessage(),e);	
		}

		
	}

	
	@DeleteMapping("/{quotationId}")
	public ResponseDTO<?> deleteQuotationDetails(@PathVariable Long quotationId) {
		System.out.println("in del Quotation dtls " + quotationId);
		try {
			quotationService.deleteQuotationDetails(quotationId);
					
			return new ResponseDTO<>(HttpStatus.OK, "Quotation details deleted", null);
		} catch (RuntimeException e) {
			System.out.println("err in delete " + e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Quotation details deletion failed", null);
		}
	}
}
