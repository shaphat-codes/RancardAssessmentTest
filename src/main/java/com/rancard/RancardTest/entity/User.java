package com.rancard.RancardTest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer phoneNumber;

    private String address;

    public User(Integer id) {
        this.id = id;
    }

    public User(String johnDoe, int i, String s) {
    }
}