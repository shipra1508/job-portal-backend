package com.jobportal.BO;

public class JobBO {
	
	    private Long id;
	    private String title;
	    private String description;
	    private String company;
	    private String location;
	    private Double salary;
	    private String status;
	     
	    //default constructor for JPA
		public JobBO() {
			
		}
		// All-args constructor
		public JobBO(Long id, String title, String description, String company, String location, Double salary) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.company = company;
			this.location = location;
			this.salary = salary;
		}

		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}


}
