package com.jhf.ecommerce;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tag", schema = "ecommerce")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @ColumnDefault("0")
    @Column(name = "tag_number")
    private Integer tagNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(Integer tagNumber) {
        this.tagNumber = tagNumber;
    }

}