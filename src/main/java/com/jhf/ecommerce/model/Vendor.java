package com.jhf.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "vendor", schema = "ecommerce")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @ColumnDefault("0")
    @Column(name = "owner_id")
    private Integer ownerId;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @Size(max = 255)
    @Column(name = "phone")
    private String phone;

    @Size(max = 255)
    @Column(name = "website")
    private String website;

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address_id")
    private address address;

    @Size(max = 255)
    @NotNull
    @Column(name = "business_name", nullable = false)
    private String businessName;

    @ColumnDefault("0.0")
    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

    @Size(max = 255)
    @Column(name = "logo_url")
    private String logoUrl;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "contract_start_date", nullable = false)
    private Instant contractStartDate;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "contract_end_date", nullable = false)
    private Instant contractEndDate;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @ManyToMany(mappedBy = "vendors")
    private Set<Productvariant> productvariants = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public com.jhf.ecommerce.model.address getAddress() {
        return address;
    }

    public void setAddress(com.jhf.ecommerce.model.address address) {
        this.address = address;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Instant getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Instant contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Instant getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Instant contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Productvariant> getProductvariants() {
        return productvariants;
    }

    public void setProductvariants(Set<Productvariant> productvariants) {
        this.productvariants = productvariants;
    }

}