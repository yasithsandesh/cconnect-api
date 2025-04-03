package com.yasithsandesh.cconnect_api.entitiy;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "service_profile")
public class ServiceProfile {
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

    @Column(name = "counseller_id",nullable = false)
    private String counsellerId;

    @Column(name = "fname",nullable = false)
    private String firstName;

    @Column(name = "lname",nullable = false)
    private String lastName;

    @Column(name = "rate",nullable = false)
    private double rate;

    @Column(name = "session_limit",nullable = false)
    private int limit;

    @Column(name = "status",nullable = false)
    private boolean status;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    public ServiceProfile() {}

    public ServiceProfile(String counsellerId, String firstName, String lastName, double rate, int limit, boolean status, double latitude, double longitude) {
        this.counsellerId = counsellerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rate = rate;
        this.limit = limit;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
