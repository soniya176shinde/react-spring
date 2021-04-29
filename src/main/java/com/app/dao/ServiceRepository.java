package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.Services;

public interface ServiceRepository extends JpaRepository<Services,Long> {

}
