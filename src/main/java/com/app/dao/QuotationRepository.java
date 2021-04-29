package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Quotation;



public interface QuotationRepository extends JpaRepository<Quotation,Long>  {

}
