package com.nash.gonzoservices.Loan;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"loan\"")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer discount_id, client_id, user_id, nit;
    Double cost;
    LocalDateTime creation_time,expiration_time;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiscout_id() {
        return discount_id;
    }

    public void setDiscout_id(Integer discout_id) {
        this.discount_id = discout_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(LocalDateTime creation_time) {
        this.creation_time = creation_time;
    }

    public LocalDateTime getExpiration_time() {
        return expiration_time;
    }

    public void setExpiration_time(LocalDateTime expiration_time) {
        this.expiration_time = expiration_time;
    }
}
