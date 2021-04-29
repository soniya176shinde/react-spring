package com.app.service;

import java.util.List;

import com.app.dto.ClientDto;
import com.app.pojos.Clients;


public interface IClientService {
	
	List<Clients> getAllclient();
	Clients addClientDetails(ClientDto client);


	Clients getClientDetails(Long clientId);

	Clients updateClientDetails(Long clientId, ClientDto companyDTO);

	void deleteClientDetails(Long clientId);

}
