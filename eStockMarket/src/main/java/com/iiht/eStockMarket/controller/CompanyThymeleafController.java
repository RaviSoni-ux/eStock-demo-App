package com.iiht.eStockMarket.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.iiht.eStockMarket.model.Company;
import com.iiht.eStockMarket.service.CompanyService;

@Controller
public class CompanyThymeleafController {
	
	 private CompanyService companyService;
	 
	@Autowired
	public CompanyThymeleafController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping("/reservations-ui")
    public String reservations(Model model) {
        model.addAttribute("reservations", companyService.getAllReservations());
        return "reservations";
    }

    @GetMapping("/delete-reservation/{id}")
    public String removeReservation(@PathVariable("id") String id, Model model) {
        companyService.deleteReservationById(id);
        model.addAttribute("reservations", companyService.getAllReservations());
        return "reservations";
    }

    @GetMapping(value = {"/edit-add-reservation/{id}", "/edit-add-reservation"})
    public String editReservation(@PathVariable("id") Optional<String> id, Model model) {
        Company reservation = id.isPresent() ?
                companyService.findReservationById(id.get()).get() : new Company();
        model.addAttribute("reservation", reservation);
        return "add-edit";
    }

    @PostMapping("/save-reservation")
    public String editReservation(@ModelAttribute("reservation") @Valid Company reservation,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit";
        }
        companyService.saveReservation(reservation);
        return "redirect:reservations-ui";
    }
	 
	 

}
