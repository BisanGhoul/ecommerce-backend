package com.jhf.ecommerce.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "vendorproductvariant", schema = "ecommerce")
public class Vendorproductvariant {
    @EmbeddedId
    private VendorproductvariantId id;

    @MapsId("vendorId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @MapsId("productVariantId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private Productvariant productVariant;

    public VendorproductvariantId getId() {
        return id;
    }

    public void setId(VendorproductvariantId id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Productvariant getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(Productvariant productVariant) {
        this.productVariant = productVariant;
    }

}