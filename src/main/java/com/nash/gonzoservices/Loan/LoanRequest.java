package com.nash.gonzoservices.Loan;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LoanRequest {
    Long userId, clientId;
    Double cost;
    Integer nit,days;
    ArrayList<MovieQuantity> movieQuantities;
    LocalDateTime expirationTime;

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public ArrayList<MovieQuantity> getMovieQuantities() {
        return movieQuantities;
    }

    public void setMovieQuantities(ArrayList<MovieQuantity> movieQuantities) {
        this.movieQuantities = movieQuantities;
    }
}
