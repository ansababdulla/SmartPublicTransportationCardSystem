package com.sptcs.transportation_card_system.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "phone_no", nullable = false)
    private String phoneNo;
    @Column(name = "user_type", nullable = false)
    private int userType;
    @Column(nullable = false)
    private String address;
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

    public User() {}

    public User(String name, String username, String password, String phoneNo, int userType, String address, String createdBy) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNo = phoneNo;
        this.userType = userType;
        this.address = address;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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