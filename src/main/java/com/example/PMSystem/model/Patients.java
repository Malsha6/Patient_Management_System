package com.example.PMSystem.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SpringBootApplication
@Document(collection = "Patients")
public class Patients {

	@Id
	private long id;
	private String name;
	private double age;
	private String nic;
	private String dob;
	private String address;
	private String allergies;
	private String createdDate;
	private String updatedDte;

	public Patients() {
		super();
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDte() {
		return updatedDte;
	}

	public void setUpdatedDte(String updatedDte) {
		this.updatedDte = updatedDte;
	}

	public Patients(long id, String name, double age, String nic, String dob, String address, String allergies, String createdDate, String updatedDte) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
