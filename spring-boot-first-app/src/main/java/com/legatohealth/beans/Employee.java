package com.legatohealth.beans;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "employee")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class ,property ="pid")
public class Employee {
	@Id
	@Column(name = "eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(targetEntity=ProductEntity.class,mappedBy="employee",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<ProductEntity> productentity;
	
	public Employee() {
		super();
	}

	public Employee(int id, String lastname, String firstname, String password, Set<ProductEntity> productentity) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.password = password;
		this.productentity = productentity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Set<ProductEntity> getProductentity() {
		return productentity;
	}
	public void setProductentity(Set<ProductEntity> productentity) {
		this.productentity = productentity;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", password=" + password
				+ ", productentity=" + productentity + "]";
	}
	
	
}