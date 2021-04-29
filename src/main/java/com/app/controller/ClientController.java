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

import com.app.dto.ClientDto;
import com.app.dto.CompanyDto;
import com.app.dto.ResponseDTO;
import com.app.pojos.Clients;
import com.app.pojos.Company;
import com.app.service.IClientService;


@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController
{
	@Autowired
	private IClientService clientService;

	
	@GetMapping
	public ResponseDTO<?> getAllClient() {
		System.out.println("in get all client");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching client list successfully", clientService.getAllclient());
	}
	
	
	@PostMapping("/add")
	public ResponseDTO<?> addClientDetails(@RequestBody ClientDto clientDTO) {
		
        clientDTO.setStatus("offline");
		System.out.println("in add client details " + clientDTO);
		return new ResponseDTO<>(HttpStatus.OK, "client details added", clientService.addClientDetails(clientDTO));
	}
	
	
	
	@GetMapping("/{clientId}")
	public ResponseDTO<?> getClientDetails(@PathVariable Long clientId) {
		System.out.println("in get client dtls " + clientId);
		return new ResponseDTO<>(HttpStatus.OK, "Sending client details", clientService.getClientDetails(clientId));
	}


	@PutMapping("/{clientId}")
	public ResponseDTO<?> updateClientDetails(@PathVariable Long clientId, @RequestBody ClientDto clientDTO) {
		System.out.println("in rest : update details " + clientId + " " + clientDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Updated client details",
				clientService.updateClientDetails(clientId, clientDTO));
	}

	@GetMapping("/getclientbyuserid/{userId}")
	public ResponseDTO<?> getClientDetails_by_uid(@PathVariable Long userId) {
		System.out.println("in get company dtls " + userId);
		List<Clients> client=clientService.getAllclient();
		Clients c1=new Clients();
		for (Clients c: client)   
		{ 
			if((c.getUser().getUserId())== userId )
			{ 
				
				c1=c;
				
			}
		//prints the elements of the List  
		//System.out.println(cities);   
		}  
		return new ResponseDTO<>(HttpStatus.OK, "Sending company details", c1);
	}
	

	@DeleteMapping("/{clientId}")
	public ResponseDTO<?> deleteClientDetails(@PathVariable Long clientId) {
		System.out.println("in del client dtls " + clientId);
		try {
			clientService.deleteClientDetails(clientId);
			return new ResponseDTO<>(HttpStatus.OK, "client details deleted", null);
		} catch (RuntimeException e) {
			System.out.println("err in delete " + e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "client details deletion failed", null);
		}
	}
}
