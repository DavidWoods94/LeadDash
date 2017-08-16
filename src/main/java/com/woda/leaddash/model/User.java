package com.woda.leaddash.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User implements Serializable {
	  
	   private Long id;

	   private String username;
	   
	   private String passwordHash;
	   
	   private String role;
	   
	   private Set<Lead> leads = new HashSet<Lead>(0);
	   
	   public User() {
		   
	   }
	   
	   public User(String username, String passwordHash, String role) {
		   this.username = username;
		   this.passwordHash = passwordHash;
		}
	   
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "user_id", nullable = false, updatable = false)
	   public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		@Column(name = "username", nullable = false, unique = true)
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
		@Column(name = "password", nullable = false)
		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
		
		@Column(name = "role", nullable = false)
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
		
		@OneToMany(mappedBy="user")
		public Set<Lead> getLeads() {
			return this.leads;
		}
		
		public void setLeads(Set<Lead> leads) {
			this.leads = leads;
		}

}
