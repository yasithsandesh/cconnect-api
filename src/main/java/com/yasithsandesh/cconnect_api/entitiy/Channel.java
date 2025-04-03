package com.yasithsandesh.cconnect_api.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "channel")
public class Channel implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "service_profile_id",nullable = false)
    private ServiceProfile serviceProfile;


    @Column(name = "date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "day", nullable = false)
    private int day;



    public Channel(){

    }

    public Channel(String userId, ServiceProfile serviceProfile, double price, int month, int year, int day) {
        this.userId = userId;
        this.serviceProfile = serviceProfile;
        this.date = date;
        this.price = price;
        this.month = month;
        this.year = year;
        this.day = day;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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


