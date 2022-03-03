package com.iiht.eStockMarket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.eStockMarket.model.Company;
import com.iiht.eStockMarket.repository.CompanyRepository;

@Service
public class CompanyService {
	
	private CompanyRepository companyRepository;

	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	public Company saveReservation(Company company){
        return companyRepository.save(company);
    }

    public Iterable<Company> getAllReservations(){
        return companyRepository.findAll();
    }

    public void deleteAllReservations(){
    	companyRepository.deleteAll();
    }

    public void deleteReservationById(String id){
    	companyRepository.deleteById(id);
    }

    public Optional<Company> findReservationById(String id){
        return companyRepository.findById(id);
    }
	 
	 

}
