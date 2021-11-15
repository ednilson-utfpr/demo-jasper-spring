package com.mballem.curso.jasper.spring.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Entity
@ToString
@Data
@Table(name="EMPLOYEE_TBL")
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Este campo deve ser informado")
    @Column(length = 255, nullable = false)
    private String name;

    @NotEmpty(message = "Este campo deve ser informado")
    @Column(length = 100, nullable = false)
    private String designation;

    @NotEmpty(message = "Este campo deve ser informado")
    @Column(length = 100, nullable = false)
    private Double salary;

    @NotEmpty(message = "Este campo deve ser informado")
    @Column(length = 1024, nullable = false)
    private String doj;




}


