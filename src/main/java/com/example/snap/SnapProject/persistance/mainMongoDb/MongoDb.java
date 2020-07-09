package com.example.snap.SnapProject.persistance.mainMongoDb;

import com.example.snap.SnapProject.model.Driver;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDb {
    private static MongoDb mongoDb;
    private final CodecRegistry pojoCodecRegistry;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Driver> driverCollection;


    private MongoDb(){
         pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient= MongoClients.create("mongodb://localhost");
        mongoDatabase=mongoClient.getDatabase("snapDb").withCodecRegistry(pojoCodecRegistry);
    }
    public static MongoDb getInstance(){
        if(mongoDb==null){
            mongoDb=new MongoDb();
            return mongoDb;
        }else{
            return mongoDb;
        }
    }
    public MongoCollection<Driver> getDriverCollection(){
             driverCollection=mongoDatabase.getCollection("driver",Driver.class);
        driverCollection.withCodecRegistry(pojoCodecRegistry);
        return driverCollection;
    }
}
