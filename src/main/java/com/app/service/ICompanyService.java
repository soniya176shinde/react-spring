package com.app.service;

import com.app.dto.CompanyDto;

import com.app.pojos.Company;

import java.util.List;
public interface ICompanyService 
{
	Company addCompanyDetails(CompanyDto user);

	List<Company> getAllcompany();

	Company getCompanyDetails(Long companyId);

	Company updateCompanyDetails(Long companyId, CompanyDto companyDTO);

	void deleteCompanyDetails(Long companyId);

	Company getCompanyDetails_By_Uid(Long userId);
  
}
