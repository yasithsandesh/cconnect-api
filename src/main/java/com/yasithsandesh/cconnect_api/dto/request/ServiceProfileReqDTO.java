package com.yasithsandesh.cconnect_api.dto.request;

import java.io.Serializable;

public class ServiceProfileReqDTO implements Serializable {
    private String counsellerId;
    private String firstName;
    private String lastName;
    private double rate;
    private int limit;
    private boolean status;
    private double latitude;
    private double longitude;

    public ServiceProfileReqDTO(){}

    public String getCounsellerId() {
        return counsellerId;
    }

    public void setCounsellerId(String counsellerId) {
        this.counsellerId = counsellerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
