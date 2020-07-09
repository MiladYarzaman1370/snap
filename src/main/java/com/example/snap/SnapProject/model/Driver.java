package com.example.snap.SnapProject.model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Driver {
    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private String name;
    private  String mobileNumber;
    private double wallet;


    // private CarType carType;
    private String carType;
    private boolean busy;

    public Driver() {
    }

    public Driver(ObjectId id, String name, String mobileNumber,double wallet, boolean busy, String carType) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.busy = busy;
        this.carType=carType;
        this.wallet=wallet;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
