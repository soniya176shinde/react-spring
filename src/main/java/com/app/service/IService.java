package com.app.service;

import java.util.List;

import com.app.dto.ServiceDto;
import com.app.pojos.Services;

public interface IService {

	List<Services> getAllService();

	Services addServiceDetails(ServiceDto serviceDTO);

	Services getServiceDetails(Long serviceId);

	Services updateServiceDetails(Long serviceId, ServiceDto serviceDTO);

	void deleteServiceDetails(Long serviceId);

	
}
