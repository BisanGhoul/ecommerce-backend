package com.jhf.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productvariant_vendors", schema = "ecommerce")
public class ProductvariantVendor {
    @EmbeddedId
    private ProductvariantVendorId id;

    @MapsId("productvariantsId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "productvariants_id", nullable = false)
    private Productvariant productvariants;

    @MapsId("vendorsId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vendors_id", nullable = false)
    private Vendor vendors;

    public ProductvariantVendorId getId() {
        return id;
    }

    public void setId(ProductvariantVendorId id) {
        this.id = id;
    }

    public Productvariant getProductvariants() {
        return productvariants;
    }

    public void setProductvariants(Productvariant productvariants) {
        this.productvariants = productvariants;
    }

    public Vendor getVendors() {
        return vendors;
    }

    public void setVendors(Vendor vendors) {
        this.vendors = vendors;
    }

}