package com.tts.finalproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Tea 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tea_id")
    private Long id;
    
    @NotEmpty(message = "Type cannot be empty")
    @Size(min=2, max=50, message = "Tea type must be more than 2 characters")
    @Column(name = "type")
	private String type;
   
    @Column(name = "notes")
	private String notes;
    
    @NotEmpty(message = "Type cannot be empty!")
    @Column(name = "name")
	private String name;
   
    @Column(name = "year")
	private int year;
	
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	
	}
}
