package com.yasithsandesh.cconnect_api.dto.request;


import java.util.Date;

public class ChannelSaveDTO {

    private String userId;

    private long serviceProfileId;


    private double price;

    private int month;

    private int year;

    private int day;

    public ChannelSaveDTO() {
    }

    public ChannelSaveDTO(String userId, long serviceProfileId,double price, int month, int year, int day) {
        this.userId = userId;
        this.serviceProfileId = serviceProfileId;
        this.price = price;
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getServiceProfileId() {
        return serviceProfileId;
    }

    public void setServiceProfileId(long serviceProfileId) {
        this.serviceProfileId = serviceProfileId;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
