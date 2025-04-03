package com.yasithsandesh.cconnect_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ServiceProfileUpdateDTO {
    private long id;
    private double rate;
    private int limit;

    public ServiceProfileUpdateDTO() {}
    public ServiceProfileUpdateDTO(long id, double rate, int limit) {
        this.id = id;
        this.rate = rate;
        this.limit = limit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
