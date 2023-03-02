package com.pw.demo.Dto;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name= "Name", length = 50, nullable = false)
    private String name;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name="gender", length = 100, nullable = false)
    private String gender;
    @Column(name = "phone_number",length = 12, nullable = false)
    private long phone;
}
