/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadDash.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import leadDash.leadrepository.LeadRepository;
//import leadDash.leadservice.LeadService;
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
    
    @RequestMapping(value = "/deleteLead", method = RequestMethod.GET) 
    public ModelAndView deleteLead(HttpServletRequest request) {
        String name = request.getParameter("name");
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/editLead", method = RequestMethod.GET)
    public ModelAndView editLead(HttpServletRequest request) {
        String leadName = request.getParameter("name"); 
       // Lead lead = leadService.getLead(leadName);
        ModelAndView model = new ModelAndView("LeadForm");
        //model.addObject("lead", lead);
        
        return model;
    } 
}
