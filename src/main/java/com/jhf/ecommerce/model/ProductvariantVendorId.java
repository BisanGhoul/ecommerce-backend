package com.jhf.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductvariantVendorId implements Serializable {
    private static final long serialVersionUID = -484751907074154502L;
    @NotNull
    @Column(name = "productvariants_id", nullable = false)
    private Integer productvariantsId;

    @NotNull
    @Column(name = "vendors_id", nullable = false)
    private Integer vendorsId;

    public Integer getProductvariantsId() {
        return productvariantsId;
    }

    public void setProductvariantsId(Integer productvariantsId) {
        this.productvariantsId = productvariantsId;
    }

    public Integer getVendorsId() {
        return vendorsId;
    }

    public void setVendorsId(Integer vendorsId) {
        this.vendorsId = vendorsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductvariantVendorId entity = (ProductvariantVendorId) o;
        return Objects.equals(this.productvariantsId, entity.productvariantsId) &&
                Objects.equals(this.vendorsId, entity.vendorsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productvariantsId, vendorsId);
    }

}