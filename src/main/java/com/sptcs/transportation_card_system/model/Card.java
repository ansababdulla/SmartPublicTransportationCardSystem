package com.sptcs.transportation_card_system.model;

import jakarta.persistence.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(name = "uid", nullable = false)
    private Long uid;

    @Column(name = "card_type")
    private Integer cardType;

    @Column(name="balance")
    private Double balance;

    @Column(name="expiration_date")
    private LocalDate expirationDate;

    private Integer status;

    @Column(name = "created_on", updatable = false, nullable = false)
    private LocalDateTime createdOn;
    @PrePersist
    public void onCreate() {
        // Set the createdOn field to the current time before persisting the entity
        if (createdOn == null) {
            createdOn = LocalDateTime.now();
        }
    }
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_on")
    private String updatedOn;
    @Column(name = "updated_by")
    private String updatedBy;

    public Card() { }


    public Card(User user, Long uid, Integer cardType, Double balance, LocalDate expirationDate, Integer status, String createdBy) {
        this.user = user;
        this.uid = uid;
        this.cardType = cardType;
        this.balance = balance;
        this.expirationDate = expirationDate;
        this.status = status;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
