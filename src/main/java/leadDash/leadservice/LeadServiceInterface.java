/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadDash.leadservice;

import java.util.List;

import leadDash.model.Lead;

/**
 * @author David
 */
public interface LeadServiceInterface {
    public void addLead(Lead lead);
    public List<Lead> getAllLeads();
    public void deleteLead(String leadName);
    public Lead getLead(String leadName);
    public Lead updateLead(Lead lead);
}
