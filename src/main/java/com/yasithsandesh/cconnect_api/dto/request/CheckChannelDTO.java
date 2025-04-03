package com.yasithsandesh.cconnect_api.dto.request;

public class CheckChannelDTO {

    private long serviceProfileId;

    private int month;


    private int year;


    private int day;

    public CheckChannelDTO() {
    }

    public CheckChannelDTO(long serviceProfileId, int month, int year, int day) {
        this.serviceProfileId = serviceProfileId;
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public long getServiceProfileId() {
        return serviceProfileId;
    }

    public void setServiceProfileId(long serviceProfileId) {
        this.serviceProfileId = serviceProfileId;
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
