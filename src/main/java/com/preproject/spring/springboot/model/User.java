package com.preproject.spring.springboot.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private String surname;
    private String email;
    private int salary;
}
