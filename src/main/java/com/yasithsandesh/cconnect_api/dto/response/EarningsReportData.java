package com.yasithsandesh.cconnect_api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


public class EarningsReportData {
    private double total;
    private int year;
    private HashMap<Integer, Double> earnings;

    public EarningsReportData(){

    }

    public EarningsReportData(double total, int year, HashMap<Integer, Double> earnings) {
        this.total = total;
        this.year = year;
        this.earnings = earnings;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public HashMap<Integer, Double> getEarnings() {
        return earnings;
    }

    public void setEarnings(HashMap<Integer, Double> earnings) {
        this.earnings = earnings;
    }
}
