package com.example.ss3.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "studentid")
    private String studentid;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "nativeland")
    private String nativeland;


    public StudentEntity(String name, String birth, String gender, String studentid, String phone, String email, String nativeland) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.studentid = studentid;
        this.phone = phone;
        this.email = email;
        this.nativeland = nativeland;
    }
}
