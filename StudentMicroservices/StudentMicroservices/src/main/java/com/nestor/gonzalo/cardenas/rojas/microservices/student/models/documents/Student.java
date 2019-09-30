package com.nestor.gonzalo.cardenas.rojas.microservices.student.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document(collection = "student")

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@NotEmpty
	private String fullName;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String birthdate;
	@NotEmpty
	private String typeDocument;
	@NotEmpty
	@Size(min = 8, max = 8, message = "The document number contains 8 digits")
	private String numberDocument;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}
	public String getNumberDocument() {
		return numberDocument;
	}
	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}
	public Student(String id, @NotEmpty String fullName, @NotEmpty String gender, @NotEmpty String birthdate,
			@NotEmpty String typeDocument,
			@NotEmpty @Size(min = 8, max = 8, message = "The document number contains 8 digits") String numberDocument) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.typeDocument = typeDocument;
		this.numberDocument = numberDocument;
	}
	public Student() {
		super();
	}
	
	
	
}