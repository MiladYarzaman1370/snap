package com.example.snap.SnapProject.persistance.driverDaoMongoDb;

import com.example.snap.SnapProject.model.Driver;
import org.bson.types.ObjectId;

import java.util.List;


public interface DriverDaoI {
    public Boolean creat(Driver driver);
    public Boolean setBusy(ObjectId objectId);
    public Boolean setFree(ObjectId objectId);
    public Boolean checkout(ObjectId objectId);
    public Driver read(ObjectId objectId);
    public boolean delete(ObjectId objectId);
    public List<Driver> freeDrivers();
    public List<Driver> busyDrivers();
    public List<Driver> Drivers();
}
