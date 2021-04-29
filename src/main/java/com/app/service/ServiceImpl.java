package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import com.app.dao.ServiceRepository;
import com.app.dto.ServiceDto;
import org.springframework.stereotype.Service;

import com.app.pojos.Company;
import com.app.pojos.Services;

@Service
@Transactional 
public class ServiceImpl implements IService 
{

	@Autowired
	private ServiceRepository ServiceRepo;
	@Override
	public List<Services> getAllService() {
		return ServiceRepo.findAll();
	}
	@Override
	public Services addServiceDetails(ServiceDto serviceDTO)
	{
		Services Service = new Services();
		BeanUtils.copyProperties(serviceDTO, Service);
		System.out.println("add service src : " +serviceDTO);
		System.out.println(Service);
		// invoke dao's method for persistence
		return ServiceRepo.save(Service);
		
	}
	@Override
	public Services getServiceDetails(Long serviceId) {
		Optional<Services> optionalUser = ServiceRepo.findById(serviceId);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}
	@Override
	public Services updateServiceDetails(Long serviceId, ServiceDto serviceDTO) {
		System.out.println("in update "+serviceDTO);
		//fetch exsiting details from the db
		Services ServiceDetails=ServiceRepo.findById(serviceId).get();
		System.out.println("service dtls from db "+ServiceDetails);
		
		BeanUtils.copyProperties(serviceDTO, ServiceDetails);
		
		System.out.println("updated service dtls "+ServiceDetails);
		//modified state of persistent POJO
		return ServiceDetails;
	}
	@Override
	public void deleteServiceDetails(Long serviceId) {
		// check if service id exists
		boolean exists = ServiceRepo.existsById(serviceId);
		if (!exists)
			throw new ResourceNotFoundException("Invalid Service id!!!!!");
		ServiceRepo.deleteById(serviceId);
		return;
		
	}

}
