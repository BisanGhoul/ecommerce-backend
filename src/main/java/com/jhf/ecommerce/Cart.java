package com.jhf.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cart", schema = "ecommerce")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "cart")
    private Set<Cartproductvariant> cartproductvariants = new LinkedHashSet<>();

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private Customer customers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Cartproductvariant> getCartproductvariants() {
        return cartproductvariants;
    }

    public void setCartproductvariants(Set<Cartproductvariant> cartproductvariants) {
        this.cartproductvariants = cartproductvariants;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

}