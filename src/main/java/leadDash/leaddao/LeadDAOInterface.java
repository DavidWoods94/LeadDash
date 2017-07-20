package leadDash.leaddao;

import java.util.List;

import leadDash.model.Lead;


/**
 *
 * @author David
 */
public interface LeadDAOInterface {
    public void addLead(Lead employee);
 
    public List<Lead> getAllLeads();
 
    public void deleteLead(String leadName);
 
    public Lead updateLead(Lead employee);
 
    public Lead getLead(String leadName);
}
