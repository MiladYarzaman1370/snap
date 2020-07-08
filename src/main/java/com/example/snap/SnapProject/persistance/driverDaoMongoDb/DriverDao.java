package com.example.snap.SnapProject.persistance.driverDaoMongoDb;

import com.example.snap.SnapProject.model.Driver;
import com.example.snap.SnapProject.persistance.MongoDb.MongoDb;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;


public class DriverDao implements DriverDaoI{
    MongoDb mongoDb=MongoDb.getInstance();
    @Override
    public Boolean creat(Driver driver) {

        MongoCollection<Driver> drivers=mongoDb.getDriverCollection();


        boolean g=false;
        try {
             drivers.insertOne(driver);
            System.out.println("not exception exception");
            g=true;
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("exception");
        }
        return g;


    }

    @Override
    public Boolean update(ObjectId objectId) {
        return null;
    }

    @Override
    public Driver read(ObjectId objectId) {
        return null;
    }

    @Override
    public boolean delete(ObjectId objectId) {
        return false;
    }
}
