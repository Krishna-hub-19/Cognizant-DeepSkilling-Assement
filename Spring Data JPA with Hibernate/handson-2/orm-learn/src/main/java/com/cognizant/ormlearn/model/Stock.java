package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private Integer id;

    @Column(name = "st_code")
    private String code;

    @Column(name = "st_date")
    private LocalDate date;

    @Column(name = "st_open")
    private double open;

    @Column(name = "st_close")
    private double close;

    @Column(name = "st_volume")
    private long volume;

    public Stock() {
    }

    // constructor
    public Stock(String code, LocalDate date, double open, double close, long volume) {
        this.code = code;
        this.date = date;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getVolume() {
        return volume;
    }

    public double getClose() {
        return close;
    }

    public double getOpen() {
        return open;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", open=" + open +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}