package com.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

    @Entity
    @Table(name = "jobs")
    public class JobEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Title is mandatory")
	@Size(min = 3, max = 100)
	private String title;
	private String company;
	private String location;
	
	@NotNull(message = "Salary is mandatory")
	private Double salary;

	@NotBlank(message = "Status is mandatory")
	private String status;
	
	@Column(length = 100)
	private String description;
	
	//default constructor for JPA
	public JobEntity() {
		
	}
	
    
    public JobEntity(long id, @NotBlank(message = "Title is mandatory") @Size(min = 3, max = 100) String title,
			String company, String location, Double salary, String status, String description) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.location = location;
		this.salary = salary;
		this.status = status;
		this.description = description;
	}


	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
