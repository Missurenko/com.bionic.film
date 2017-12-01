package com.bionic.film.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")// This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +

                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}