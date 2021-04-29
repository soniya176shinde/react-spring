package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Clients;



public interface  ClientRepository  extends JpaRepository<Clients,Long> {

}
