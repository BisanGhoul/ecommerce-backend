package com.jhf.ecommerce.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "size", schema = "ecommerce")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 10)
    @ColumnDefault("'M'")
    @Column(name = "code", length = 10)
    private String code;

    @ColumnDefault("0.00")
    @Column(name = "value", precision = 5, scale = 2)
    private BigDecimal value;

    @jakarta.validation.constraints.Size(max = 10)
    @Column(name = "unit", length = 10)
    private String unit;

    @jakarta.validation.constraints.Size(max = 5)
    @ColumnDefault("'EU'")
    @Column(name = "country_code", length = 5)
    private String countryCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}