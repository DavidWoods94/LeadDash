package com.woda.leaddash.model;

/**
 *
 * @author David
 */

 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lead_table")
public class Lead implements Serializable {
    
    private Long id;
    
    private String name;
    
    private String company;
    
    private String priority;
    
    private String phone;
    
    private String email;
    
    private String address;
    
    private String city;
    
    private String state;
    
    private String zip;
    
    private String description;
    
    private String status;
    
    private User user;
   
    
    public Lead() {
    }
    
    public Lead(String name, String phone, String email, String address, String city, String state, String zip,
    		String description, String status) {
    	this.name = name; 
    	this.phone = phone;
    	this.email= email;
    	this.address = address;
    	this.city = city;
    	this.state = state;
    	this.zip = zip;
    	this.description = description;
    	this.status = status;
    	
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    } 
    public void setId(Long i) {
        id = i;
    }
    
    @Column(name = "name")
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
    
    @Column(name = "phone")
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String p){
        phone = p;
    }
    
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String e){
        email = e;
    }
    
    @Column(name = "address")
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String a){
        address = a;
    }
    
    @Column(name = "city")
    public String getCity() {
        return city;
    }
    
    public void setCity(String c) {
        city = c;
    }
    
    @Column(name = "state")
    public String getState() {
        return state;
    }
    
    public void setState(String s){
        state = s;
    }
    
    @Column(name = "zip")
    public String getZip() {
        return zip;
    }
    
    public void setZip(String z) {
        zip = z;
    }
    
    @Column(name = "description")
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String d) {
        description = d;
    }
    
    @Column(name = "status")
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String s) {
        status = s;
    }
    
    
    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
    	return user;
    }
    
    
    public void setUser(User user){
    	this.user = user;
    }

    @Column(name = "company")
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "priority")
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
    
    
}
