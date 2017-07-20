/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadDash.leadservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author David
 */
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

//import leadDash.leaddao.LeadDAO;
import leadDash.model.Lead;
/*
@Service
@Transactional
public class LeadService implements LeadServiceInterface {

    @Autowired
    private LeadDAO leadDAO;
    
    public void addLead(Lead lead) {
        leadDAO.addLead(lead);
    }

    public List<Lead> getAllLeads() {
        return leadDAO.getAllLeads();
    }

    public void deleteLead(String leadName) {
        leadDAO.deleteLead(leadName);
    }

    public Lead getLead(String leadName) {
        return leadDAO.getLead(leadName);
    }

    public Lead updateLead(Lead lead) {
        return leadDAO.updateLead(lead);
    }
    
} */
