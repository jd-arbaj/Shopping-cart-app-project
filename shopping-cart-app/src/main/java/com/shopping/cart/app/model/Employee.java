package com.shopping.cart.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_number")
	private long orderNumber;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="extension")
	private String extension;
	
	@Column(name="email")
	private String email;
	
	@Column(name="report_to")
	private String reportTo;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@ManyToOne
	@JoinColumn(name="office_code")
	private Office office;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="salesRepEmployeeNumber")
	private List<Customer> customers;
	
	@OneToMany(mappedBy="reportTo")
	private List<Employee> employees;

	public Employee() {
		super();
	}

	public Employee(long orderNumber, String lastName, String firstName, String extension, String email,
			Office office, String reportTo, String jobTitle, List<Customer> customers, List<Employee> employees) {
		this.orderNumber = orderNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.office = office;
		this.reportTo = reportTo;
		this.jobTitle = jobTitle;
		this.customers = customers;
		this.employees = employees;
	}
	
	public Employee(String lastName, String firstName, String extension, String email,
			Office office, String reportTo, String jobTitle, List<Customer> customers, List<Employee> employees) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.office = office;
		this.reportTo = reportTo;
		this.jobTitle = jobTitle;
		this.customers = customers;
		this.employees = employees;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Office getoffice() {
		return office;
	}

	public void setoffice(Office office) {
		this.office = office;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Employee [orderNumber=" + orderNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", office=" + office + ", reportTo="
				+ reportTo + ", jobTitle=" + jobTitle + ", customers=" + customers + ", employees=" + employees + "]";
	}
	
	
	
	
	
}
