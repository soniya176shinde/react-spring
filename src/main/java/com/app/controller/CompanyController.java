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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.CompanyDto;

import com.app.dto.ResponseDTO;
import com.app.pojos.Company;
import com.app.pojos.Login;
import com.app.service.ICompanyService;


@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {
	@Autowired
	private ICompanyService companyService;

	
	@GetMapping
	public ResponseDTO<?> getAllCompany() {
		System.out.println("in get all company");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching company list successfully", companyService.getAllcompany());
	}
	
	
	@PostMapping("/add")
	public ResponseDTO<?> addCompanyDetails(@RequestBody CompanyDto companyDTO) {
		

		System.out.println("in add company details " + companyDTO);
		return new ResponseDTO<>(HttpStatus.OK, "company details added", companyService.addCompanyDetails(companyDTO));
	}
	
//	@PostMapping("/add")
//	public ResponseDTO<?> addCompanyDetails(@RequestParam MultipartFile image,@RequestParam String company_name,@RequestParam String company_email
//			,@RequestParam String address,@RequestParam String city,@RequestParam String contact_no,
//		@RequestParam String state,@RequestParam String pin_code,@RequestParam Long userId) 
//	{
//		CompanyDto companyDTO= new CompanyDto(company_name,company_email,address,city,state,pin_code,contact_no);
//		//companyDTO.getUser().setUserId(userId);
//		{
//			try {
//				  companyDTO.setImage(image.getBytes());
//				  companyDTO.setImageContentType(image.getContentType());
//				
//				
//					return new ResponseDTO<>(HttpStatus.OK, "company details added", companyService.addCompanyDetails(companyDTO));
//				}
//		catch (Exception e) 
//		{
//			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "not able to create profile reason "+e.getMessage(),e);
//			
//			
//		}
//	 }
//
//
//		
//	}
	
	
	@GetMapping("/{companyId}")
	public ResponseDTO<?> getCompanyDetails(@PathVariable Long companyId) {
		System.out.println("in get company dtls " + companyId);
		
		return new ResponseDTO<>(HttpStatus.OK, "Sending company details", companyService.getCompanyDetails(companyId));
	}

	@GetMapping("/getcompanybyuserid/{userId}")
	public ResponseDTO<?> getCompanyDetails_by_uid(@PathVariable Long userId) {
		System.out.println("in get company dtls " + userId);
		List<Company> company=companyService.getAllcompany();
		Company c1=new Company();
		for (Company c: company)   
		{ 
			if((c.getUser().getUserId())== userId )
			{ 
				
				c1=c;
				
			}
		//prints the elements of the List  
		System.out.println(c1);   
		}  
		return new ResponseDTO<>(HttpStatus.OK, "Sending company details", c1);
	}
	@PutMapping("/{companyId}")
	public ResponseDTO<?> updateCompanyDetails(@PathVariable Long companyId, @RequestBody CompanyDto companyDTO) {
		System.out.println("in rest : update details " + companyId + " " + companyDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Updated company details",
				companyService.updateCompanyDetails(companyId, companyDTO));
	}

	
	@DeleteMapping("/{companyId}")
	public ResponseDTO<?> deleteUserDetails(@PathVariable Long companyId) {
		System.out.println("in del company dtls " + companyId);
		try {
			companyService.deleteCompanyDetails(companyId);
			return new ResponseDTO<>(HttpStatus.OK, "comapny details deleted", null);
		} catch (RuntimeException e) {
			System.out.println("err in delete " + e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "company details deletion failed", null);
		}
	}

}
