package com.iiht.eStockMarket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.eStockMarket.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company,String> {

}
