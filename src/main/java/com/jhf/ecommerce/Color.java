package com.jhf.ecommerce;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "color", schema = "ecommerce")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 7)
    @Column(name = "hexa_value", length = 7)
    private String hexaValue;

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

    public String getHexaValue() {
        return hexaValue;
    }

    public void setHexaValue(String hexaValue) {
        this.hexaValue = hexaValue;
    }

}