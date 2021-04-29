package com.app.controller;

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

import com.app.dto.CompanyDto;
import com.app.dto.ResponseDTO;
import com.app.dto.ServiceDto;
import com.app.pojos.Company;
import com.app.pojos.Services;
import com.app.service.IService;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceController
{
	@Autowired
	private IService Service;
	@GetMapping
	public ResponseDTO<?> getAllUsers() {
		System.out.println("in get all service");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching service list successfully", Service.getAllService());
	}
	
	@PostMapping("/add")
	public ResponseDTO<?> addServiceDetails(@RequestBody ServiceDto serviceDTO) {
		

		System.out.println("in add servcie details " + serviceDTO);
		return new ResponseDTO<>(HttpStatus.OK, "service details added", Service.addServiceDetails(serviceDTO));
	}
	
	@GetMapping("/{serviceId}")
	public ResponseDTO<?> getServiceDetails(@PathVariable Long serviceId) {
		System.out.println("in get service dtls " + serviceId);
		return new ResponseDTO<>(HttpStatus.OK, "Sending service details", Service.getServiceDetails(serviceId));
	}
	
	
	@GetMapping("/getservicebycompanyid/{companyId}")
	public ResponseDTO<?> getCompanyDetails_by_uid(@PathVariable Long companyId) {
		System.out.println("in get company dtls " + companyId);
		List<Services> service=Service.getAllService();
		Services s1=new Services();
		for (Services c: service)   
		{ 
			if((c.getCompany().getCompanyId())== companyId )
			{ 
				
				s1=c;
				
			}
		//prints the elements of the List  
		//System.out.println(cities);   
		}  
		return new ResponseDTO<>(HttpStatus.OK, "Sending company details", s1);
	}
	
	@PutMapping("/{serviceId}")
	public ResponseDTO<?> updateServiceDetails(@PathVariable Long serviceId, @RequestBody ServiceDto serviceDTO) {
		System.out.println("in rest : update details " + serviceId + " " + serviceDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Updated service details",
				Service.updateServiceDetails(serviceId, serviceDTO));
	}

	
	@DeleteMapping("/{serviceId}")
	public ResponseDTO<?> deleteUserDetails(@PathVariable Long serviceId) {
		System.out.println("in del Service dtls " + serviceId);
		try {
			Service.deleteServiceDetails(serviceId);
			return new ResponseDTO<>(HttpStatus.OK, "Service details deleted", null);
		} catch (RuntimeException e) {
			System.out.println("err in delete " + e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Service details deletion failed", null);
		}
	}
	
}
