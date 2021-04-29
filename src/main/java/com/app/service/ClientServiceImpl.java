package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ClientRepository;

import com.app.dto.ClientDto;
import com.app.pojos.Clients;

@Service
@Transactional
public class ClientServiceImpl implements IClientService
{
	@Autowired
	private ClientRepository clientRepo;
	@Override
	public List<Clients> getAllclient() {
		return clientRepo.findAll();
	}

	@Override
	public Clients addClientDetails(ClientDto clientdto) {
		Clients client = new Clients();
		BeanUtils.copyProperties(clientdto, client);
		System.out.println("add client src : " +clientdto);
		System.out.println(client);
		// invoke dao's method for persistence
		return clientRepo.save(client);
	}

	@Override
	public Clients getClientDetails(Long clientId) {
		Optional<Clients> optionalUser = clientRepo.findById(clientId);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	@Override
	public Clients updateClientDetails(Long clientId, ClientDto clientDTO) {
		System.out.println("in update "+clientDTO);
		//fetch exsiting details from the db
		Clients clientDetails=clientRepo.findById(clientId).get();
		System.out.println("client dtls from db "+clientDetails);
	
		BeanUtils.copyProperties(clientDTO, clientDetails);
	
		System.out.println("updated client dtls "+clientDetails);
		//modified state of persistent POJO
		return clientDetails;
	}

	@Override
	public void deleteClientDetails(Long clientId) {
		
				boolean exists = clientRepo.existsById(clientId);
				if (!exists)
					throw new ResourceNotFoundException("Invalid client id!!!!!");
				clientRepo.deleteById(clientId);
				return;
	}

}
