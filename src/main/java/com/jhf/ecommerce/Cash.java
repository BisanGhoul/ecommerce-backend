package com.jhf.ecommerce;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cash", schema = "ecommerce")
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ColumnDefault("0")
    @Column(name = "receipt_number")
    private Integer receiptNumber;

    @Size(max = 10)
    @ColumnDefault("'USD'")
    @Column(name = "currency", length = 10)
    private String currency;

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "billing_address_id")
    private address billingAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Integer getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(address billingAddress) {
        this.billingAddress = billingAddress;
    }

}