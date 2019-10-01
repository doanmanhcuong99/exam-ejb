package com.example.demo.entiy;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prodId;
    private String prodName;
    private String description;
    private long dateOfmanf;
    private int price;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prodId")
    private Set<Sale> saleHashSet = new HashSet<>();

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDateOfmanf() {
        return dateOfmanf;
    }

    public void setDateOfmanf(long dateOfmanf) {
        this.dateOfmanf = dateOfmanf;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
