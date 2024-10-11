package com.challenge.ahorrafacil.infra.entities;

import com.challenge.ahorrafacil.domain.models.Client;
import jakarta.persistence.*;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;
    private String name;
    private String email;
    @Column(name = "num_identification", unique = true)
    private String numIdentification;
    private String phone;
    private String address;
    @Column(name = "avatar_url")
    private String avatarUrl;

    public ClientEntity() {
    }

    public ClientEntity(Long clientId, String name, String email, String numIdentification, String phone, String address, String avatarUrl) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.numIdentification = numIdentification;
        this.phone = phone;
        this.address = address;
        this.avatarUrl = avatarUrl;
    }

    public ClientEntity(Long clientId) {
        this.clientId = clientId;
    }

    public static ClientEntity fromDomainModel(Client client) {
        return new ClientEntity(client.getId(), client.getName(), client.getEmail(), client.getNumIdentification(), client.getPhone(), client.getAddress(), client.getAvatarUrl());
    }

    public Client toDomainModel() {
        return new Client(clientId, name, email, numIdentification, phone, address, avatarUrl);
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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