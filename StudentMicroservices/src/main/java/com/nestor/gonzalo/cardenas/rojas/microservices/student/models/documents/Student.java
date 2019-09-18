package com.nestor.gonzalo.cardenas.rojas.microservices.student.models.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String numberDocument;
}