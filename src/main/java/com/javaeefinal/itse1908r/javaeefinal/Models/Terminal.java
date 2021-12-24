package com.javaeefinal.itse1908r.javaeefinal.Models;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name = "terminals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Servicepointstatus status;

//    public Servicepointstatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(Servicepointstatus status) {
//        this.status = status;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
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