package com.example.PMSystem.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@SpringBootApplication
@Document(collection = "Patients")
public class Visits {

    @Id
    private int id;
//    private Date createdDate;
    private String disease;
    private String notes;

    public Visits() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Date getCreatedDate() {
//        return createdDate;
//    }

//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
