/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadDash.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import leadDash.leadrepository.LeadRepository;
import leadDash.model.Lead;

/**
 *
 * @author David
 */
@Controller
public class LeadController {
    
    @Autowired
    private LeadRepository leadRepository;
    
    
    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public String listLead(Model model) {
    	model.addAttribute("leads", leadRepository.findAll());
        return "leads";
    }
    
    //change this
    @RequestMapping(value = "/newLead", method = RequestMethod.GET)
    public @ResponseBody String newLead(Model model) {
        Lead lead = new Lead();
        lead.setName("David");
        leadRepository.save(lead);
        model.addAttribute(lead);
        return "David";
    }
    
    @RequestMapping(value = "/saveLead", method = RequestMethod.POST)
    public void saveLead(@ModelAttribute Lead lead){
          leadRepository.save(lead);
          
    }
    
    
    @RequestMapping(value = "/leads/{id}", method = RequestMethod.GET) 
    public @ResponseBody Lead getLead(@PathVariable("id") Integer id) {
    	Lead lead = leadRepository.findOne(id);
		return lead;
    }
    @RequestMapping(value = "/lead/{id}", method = RequestMethod.DELETE) 
    public @ResponseBody String deleteLead(@PathVariable("id") Integer id) {
    	leadRepository.delete(id);
		return "deleted";
    }
}
