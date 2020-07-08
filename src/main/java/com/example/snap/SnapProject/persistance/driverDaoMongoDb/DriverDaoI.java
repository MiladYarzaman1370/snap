package com.example.snap.SnapProject.persistance.driverDaoMongoDb;

import com.example.snap.SnapProject.model.Driver;
import org.bson.types.ObjectId;


public interface DriverDaoI {
    public Boolean creat(Driver driver);
    public Boolean update(ObjectId objectId);
    public Driver read(ObjectId objectId);
    public boolean delete(ObjectId objectId);
}
