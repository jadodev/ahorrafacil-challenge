package com.challenge.ahorrafacil.domain.models;

public class Client {
    private Long id;
    private String name;
    private String email;
    private String numIdentification;
    private String phone;
    private String address;
    private String avatarUrl;

    public Client(Long id, String name, String email, String numIdentification, String phone, String address, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.numIdentification = numIdentification;
        this.phone = phone;
        this.address = address;
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumIdentification() {
        return numIdentification;
    }

    public void setNumIdentification(String numIdentification) {
        this.numIdentification = numIdentification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
