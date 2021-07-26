package com.example.PMSystem.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@SpringBootApplication
@Document(collection = "Patients")
public class Patients {

	@Id
	private int id;
	private String name;
	private double age;
	private String nic;
	private String dob;
	private String address;
	private String allergies;
	private Date createdDate;
	private Date updatedDte;

	public Patients() {
		super();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDte() {
		return updatedDte;
	}

	public void setUpdatedDte(Date updatedDte) {
		this.updatedDte = updatedDte;
	}

	public Patients(int id, String name, double age, String nic, String dob, String address, String allergies, Date createdDate, Date updatedDte) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.nic = nic;
		this.dob = dob;
		this.address = address;
		this.allergies = allergies;
		this.createdDate = createdDate;
		this.updatedDte = updatedDte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}
}
