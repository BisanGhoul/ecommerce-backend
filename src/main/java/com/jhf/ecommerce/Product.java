package com.jhf.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "product", schema = "ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

        @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
        private Set<ProductCategory> productCategories = new LinkedHashSet<>();

        @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
        private Set<Producttag> producttags = new LinkedHashSet<>();

        @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
        private Set<Productvariant> productvariants = new LinkedHashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Set<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public Set<Producttag> getProducttags() {
        return producttags;
    }

    public void setProducttags(Set<Producttag> producttags) {
        this.producttags = producttags;
    }

    public Set<Productvariant> getProductvariants() {
        return productvariants;
    }

    public void setProductvariants(Set<Productvariant> productvariants) {
        this.productvariants = productvariants;
    }

}