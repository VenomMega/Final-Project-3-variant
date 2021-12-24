package com.javaeefinal.itse1908r.javaeefinal.Models;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "buildings_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Building getBuilding() {
//        return building;
//    }
//
//    public void setBuilding(Building building) {
//        this.building = building;
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