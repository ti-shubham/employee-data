package com.example.springboot.cruddemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table(name="employeeproj")
public class Employee {

	//define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Size(min=2, message = "First name should have atleast 2 character")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@NotBlank
	@Email
	@Column(name="email")
	private String email;
	
	@NotNull
	@Size(min=10, max = 10,message = "Phone number should be of 10 digit")
	@Column(name="number")
	private String number;
	
	
	//define constructors
	public Employee() {
		
	}


	public Employee(String firstName, Date dateOfBirth, String email, String number) {
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.number=number;
	}

	//define getter and setter
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	//define toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", number=" + number + "]";
	}
	
}
