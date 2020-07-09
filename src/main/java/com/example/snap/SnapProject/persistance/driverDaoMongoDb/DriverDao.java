package com.example.snap.SnapProject.persistance.driverDaoMongoDb;

import com.example.snap.SnapProject.model.Driver;
import com.example.snap.SnapProject.persistance.mainMongoDb.MongoDb;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;


public class DriverDao implements DriverDaoI{
    MongoDb mongoDb=MongoDb.getInstance();
    MongoCollection<Driver> driversCollection =mongoDb.getDriverCollection();
    @Override
    public Boolean creat(Driver driver) {




        boolean g=false;
        try {
             driversCollection.insertOne(driver);

            g=true;
        }catch (Exception e)
        {
            e.printStackTrace();

        }
        return g;


    }

    @Override
    public Boolean setBusy(ObjectId objectId) {

        driversCollection.findOneAndUpdate(eq("_id",objectId),set("busy",true));

        return false;
    }

    @Override
    public Boolean setFree(ObjectId objectId) {
        Driver driver=driversCollection.findOneAndDelete(eq("_id",objectId));
        driver.setBusy(false);
        driver.setWallet(driver.getWallet()+1000);
        driversCollection.insertOne(driver);
        return null;
    }

    @Override
    public Boolean checkout(ObjectId objectId) {
        System.out.println(objectId);
        Driver driver=driversCollection.findOneAndDelete(eq("_id",objectId));
        driver.setWallet(0);
        driversCollection.insertOne(driver);
        //driversCollection.findOneAndUpdate(eq("_id",objectId),set("wallet",0));
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

    @Override
    public List<Driver> freeDrivers() {
          List<Driver> drivers=new ArrayList<>();
          driversCollection=mongoDb.getDriverCollection();
        BasicDBObject query = new BasicDBObject("busy", false);
        MongoCursor<Driver>  cursor= driversCollection.find(query).cursor();

        try {
            while(cursor.hasNext()) {
                drivers.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return drivers;
    }

    @Override
    public List<Driver> busyDrivers() {
        List<Driver> drivers=new ArrayList<>();
        driversCollection=mongoDb.getDriverCollection();
        BasicDBObject query = new BasicDBObject("busy", true);
        MongoCursor<Driver>  cursor= driversCollection.find(query).cursor();

        try {
            while(cursor.hasNext()) {
                drivers.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return drivers;
    }

    @Override
    public List<Driver> Drivers() {
        List<Driver> drivers=new ArrayList<>();
        driversCollection=mongoDb.getDriverCollection();
        //BasicDBObject query = new BasicDBObject("busy", true);
       // MongoCursor<Driver>  cursor= driversCollection.find(query).cursor();
        MongoCursor<Driver>  cursor= driversCollection.find().cursor();

        try {
            while(cursor.hasNext()) {
                drivers.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return drivers;
    }
}
