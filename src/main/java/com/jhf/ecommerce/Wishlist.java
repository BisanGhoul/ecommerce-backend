package com.jhf.ecommerce;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "wishlist", schema = "ecommerce")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "wishlist")
    private Customer customers;

    @OneToMany(mappedBy = "wishlist")
    private Set<Wishlistproductvariant> wishlistproductvariants = new LinkedHashSet<>();

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

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Set<Wishlistproductvariant> getWishlistproductvariants() {
        return wishlistproductvariants;
    }

    public void setWishlistproductvariants(Set<Wishlistproductvariant> wishlistproductvariants) {
        this.wishlistproductvariants = wishlistproductvariants;
    }

}