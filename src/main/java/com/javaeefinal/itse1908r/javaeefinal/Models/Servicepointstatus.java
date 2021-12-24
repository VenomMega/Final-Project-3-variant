package com.javaeefinal.itse1908r.javaeefinal.Models;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name = "servicepointstatuses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicepointstatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
}