package com.burakenesdemir.reactiveprogramming.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    public MongoClient reactiveMongoClient(){
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "testMongoDB";
    }
}
