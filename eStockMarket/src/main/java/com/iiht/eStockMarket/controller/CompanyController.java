package com.iiht.eStockMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.eStockMarket.model.Company;
import com.iiht.eStockMarket.service.CompanyService;

@RestController
public class CompanyController {
	
	private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public Iterable<Company> getAllReservations() {
        return companyService.getAllReservations();
    }


}
