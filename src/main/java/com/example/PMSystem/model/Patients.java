package com.example.PMSystem.model;

import lombok.Builder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Document(collection = "Patients")
public class Patients {

	@Id
	private int id;
	private String name;
	private double age;
	private String nic;
	private String dob;
	private String contact;
	private String address;
	private String allergies;
	private String diseases;
	private String medicines;
	private Date createdDate;
	private Date updatedDte;
	private boolean deleted;



	@Builder.Default
	private List<Visits> visits = new ArrayList<>();



	public Patients() {
		super();
	}



	public Patients(int id, String name, double age, String nic, String dob, String contact, String address, String allergies, String diseases, String medicines, Date createdDate, Date updatedDte) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nic = nic;
        this.dob = dob;
		this.contact = contact;
        this.address = address;
		this.diseases = diseases;
        this.allergies = allergies;
		this.medicines = medicines;
        this.createdDate = createdDate;
        this.updatedDte = updatedDte;
    }

    public Patients(int id, String name, double age, String nic, String dob, String contact, String address, String allergies, String diseases, String medicines, Date createdDate, Date updatedDte, boolean deleted, List<Visits> visits) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nic = nic;
        this.dob = dob;
		this.contact = contact;
        this.address = address;
        this.allergies = allergies;
		this.diseases = diseases;
		this.medicines = medicines;
        this.createdDate = createdDate;
        this.updatedDte = updatedDte;
		this.deleted = deleted;
		this.visits = visits;
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

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
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


    public List<Visits> getVisits() {
        return visits;
    }

    public void setVisits(List<Visits> comments) {
        this.visits = comments;
    }

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
