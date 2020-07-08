package com.example.snap.SnapProject.model;

import com.example.snap.SnapProject.model.enum_.CarType;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Driver {
    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private String name;
    private  String mobileNumber;
    private CarType carType;
    private boolean statusIsFree;

    public Driver() {
    }

    public Driver(ObjectId id, String name, String mobileNumber, boolean statusIsFree, CarType carType) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.statusIsFree = statusIsFree;
        this.carType=carType;

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

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public boolean isStatusIsFree() {
        return statusIsFree;
    }

    public void setStatusIsFree(boolean statusIsFree) {
        this.statusIsFree = statusIsFree;
    }
}
