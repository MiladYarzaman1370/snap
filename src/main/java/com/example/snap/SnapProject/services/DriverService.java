package com.example.snap.SnapProject.services;

import com.example.snap.SnapProject.model.Driver;
import com.example.snap.SnapProject.persistance.driverDaoMongoDb.DriverDao;
import org.bson.types.ObjectId;

import java.util.List;

public class DriverService {
    private DriverDao driverDao=new DriverDao();
    public void addDriver(Driver  driver){

        driverDao.creat(driver);
    }
    public void endJob(ObjectId objectId){
        driverDao.setFree(objectId);
    }
    public void startJob(ObjectId objectId){
        driverDao.setBusy(objectId);
    }
    public boolean checkout(ObjectId objectId){
        driverDao.checkout(objectId);
        return false;
    }
    public List<Driver> freeDrivers(){
      return   driverDao.freeDrivers();
    }

    public List<Driver> busyDrivers(){
        return   driverDao.busyDrivers();
    }

    public List<Driver> drivers(){
        return   driverDao.Drivers();
    }

}
