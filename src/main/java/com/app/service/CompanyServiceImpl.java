package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.CompanyRepository;
import com.app.dto.CompanyDto;
import com.app.pojos.Company;
import java.util.Optional;


@Service
@Transactional 
public class CompanyServiceImpl implements ICompanyService 
{

	@Autowired
	private CompanyRepository companyRepo;
	@Override
	public Company addCompanyDetails(CompanyDto companydto) {
		Company company = new Company();
		BeanUtils.copyProperties(companydto, company);
		System.out.println("add company src : " +companydto);
		System.out.println(company);
		// invoke dao's method for persistence
		return companyRepo.save(company);
	}
	@Override
	public List<Company> getAllcompany() {
	
		return companyRepo.findAll();

	}
	@Override
	public Company getCompanyDetails(Long companyId) {
		Optional<Company> optionalUser = companyRepo.findById(companyId);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}
	@Override
	public Company updateCompanyDetails(Long companyId, CompanyDto companyDTO) {
		System.out.println("in update "+companyDTO);
		//fetch exsiting details from the db
		Company companyDetails=companyRepo.findById(companyId).get();
		System.out.println("company dtls from db "+companyDetails);
		
		BeanUtils.copyProperties(companyDTO, companyDetails);
		//BeanUtils.copyProperties(companyDTO, companyDetails,"company_name"); it ignore company name during updation
		System.out.println("updated company dtls "+companyDetails);
		//modified state of persistent POJO
		return companyDetails;
	}
	@Override
	public void deleteCompanyDetails(Long companyId) {
		// check if comapny id exists
		boolean exists = companyRepo.existsById(companyId);
		if (!exists)
			throw new ResourceNotFoundException("Invalid company id!!!!!");
		companyRepo.deleteById(companyId);
		return;
		
	}
	@Override
	public Company getCompanyDetails_By_Uid(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
