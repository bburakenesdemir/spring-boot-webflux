package com.burakenesdemir.reactiveprogramming.data.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@Builder
@ToString
public class Employee {

    @Id
    private String id;

    private String name;

    private String surname;

    private LocalDate birthDate;

    private Float salary;
}
