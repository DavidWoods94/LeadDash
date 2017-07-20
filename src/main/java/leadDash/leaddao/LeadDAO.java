/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadDash.leaddao;


import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import leadDash.model.Lead;

/**
 *
 * @author David
 */
/*
@Repository
public class LeadDAO implements LeadDAOInterface{

    @Autowired
    private SessionFactory sessionFactory;
 
    
    public void addLead(Lead l) {
        sessionFactory.getCurrentSession().saveOrUpdate(l);
    }

    public List<Lead> getAllLeads() {
        return sessionFactory.getCurrentSession().createQuery("from Lead").list();
    }

    public void deleteLead(String leadName) {
        Lead lead = (Lead)sessionFactory.getCurrentSession().load(Lead.class, leadName);
        if(lead != null) {
            sessionFactory.getCurrentSession().delete(lead);
        }
    }

    public Lead updateLead(Lead lead) {
        sessionFactory.getCurrentSession().update(lead);
        return lead;
    }

    public Lead getLead(String leadName) {
        return (Lead) sessionFactory.getCurrentSession().get(Lead.class, leadName);
    }
    
} */
