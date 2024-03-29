package com.Transaction.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "transactions") // Lowercase table name for PostgreSQL convention
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txn_id")
    private String txnId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "service")
    private String service;

    @Column(name = "amount")
    private double amount;

    @Column(name = "gst")
    private double gst;

    @Column(name = "commission")
    private double commission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
