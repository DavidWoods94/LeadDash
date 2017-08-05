/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woda.leaddash.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woda.leaddash.leadrepository.LeadRepository;
import com.woda.leaddash.leadrepository.UserRepository;
import com.woda.leaddash.model.Lead;


/**
 *
 * @author David
 */
@Controller
public class LeadController {
    
    @Autowired
    private LeadRepository leadRepository;
    
    @Autowired 
    UserRepository userRepository;
    
    @RequestMapping(value = {"/leads"}, method = RequestMethod.GET)
    public String listLead(Model model, Principal principal) {
    	List<Lead> userLeads = new ArrayList<Lead>();
    	for(Lead lead: leadRepository.findAll()) {
    		if(lead.getUser().getId() == userRepository.findByUsername(principal.getName()).getId()) {
    			userLeads.add(lead);
    		}
    			
    	}
    	model.addAttribute("leads",userLeads);
        return "leads";
    }
    
    @RequestMapping(value = "/add")
    public String newLead(Model model) {
        Lead lead = new Lead();
        model.addAttribute("lead", lead);
        return "addLead";
    }
    
    
    @RequestMapping(value = "/leads", method = RequestMethod.POST)
    public String save(@Valid Lead lead, BindingResult br, Principal p){
    	lead.setUser(userRepository.findByUsername(p.getName()));
        leadRepository.save(lead);
    	return "redirect:/leads";
    }
    
   
    //change
    @RequestMapping(value = "/leads/{id}", method = RequestMethod.GET) 
    public String getLead(@PathVariable("id") Long id, Principal principal, Model model) {
    	Lead lead = leadRepository.findOne(id);
    	if(checkUser(principal, lead)) {
    		model.addAttribute( "lead", lead);
    		return "lead-single";
    	}
    	else {
    		return "login";
    	}
    }
    
    //test
    @RequestMapping(value = "/leads/{id}", method = RequestMethod.DELETE) 
    public @ResponseBody String deleteLead(@PathVariable("id") Long id, Principal principal) {
    	if(checkUser(principal, leadRepository.findOne(id))) {
    		leadRepository.delete(id);
    		return "redirect:/leads";
    	}
    	
		return "redirect:/leads";
    }
    
    
    @RequestMapping(value = "/leads/{id}/edit", method= RequestMethod.GET)
    public String editLead(@PathVariable("id") Long id, Principal principal, Model model) {
    	Lead lead = leadRepository.findOne(id);
    	if(checkUser(principal, lead)) {
    		model.addAttribute("lead", lead);
    		return "editLead";
    	}
    	
		return "redirect:/leads";
    }
    
    @RequestMapping(value = "/leads/{id}", method= RequestMethod.PUT)
    public String saveEdit(@PathVariable("id") Long id, Lead lead, Principal principal) {
    	if(checkUser(principal, lead)) {
    		leadRepository.save(lead);
    		return "redirect:/leads/{id}";
    	}
    	
		return "redirect:/leads";
    }
    public boolean checkUser(Principal principal, Lead lead){
		if(lead.getUser().getId() == userRepository.findByUsername(principal.getName()).getId()) {
			return true;
		}
		else {
			return false;
		}
    }
}
