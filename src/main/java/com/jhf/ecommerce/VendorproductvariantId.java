package com.jhf.ecommerce;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VendorproductvariantId implements Serializable {
    private static final long serialVersionUID = 8909953649917739194L;
    @NotNull
    @Column(name = "vendor_id", nullable = false)
    private Integer vendorId;

    @NotNull
    @Column(name = "product_variant_id", nullable = false)
    private Integer productVariantId;

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(Integer productVariantId) {
        this.productVariantId = productVariantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VendorproductvariantId entity = (VendorproductvariantId) o;
        return Objects.equals(this.productVariantId, entity.productVariantId) &&
                Objects.equals(this.vendorId, entity.vendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productVariantId, vendorId);
    }

}