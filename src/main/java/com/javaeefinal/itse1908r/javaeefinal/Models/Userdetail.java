package com.javaeefinal.itse1908r.javaeefinal.Models;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "userdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Userdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    @Column(name = "fname", nullable = false, length = 50)
    private String fname;

    @Column(name = "lname", nullable = false, length = 50)
    private String lname;

    @Column(name = "age", nullable = false)
    private Integer age;

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getLname() {
//        return lname;
//    }
//
//    public void setLname(String lname) {
//        this.lname = lname;
//    }
//
//    public String getFname() {
//        return fname;
//    }
//
//    public void setFname(String fname) {
//        this.fname = fname;
//    }
//
//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
}