package com.groovyexamples.mongo

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
@Grab(group="org.mongodb", module="mongodb-driver", version="3.4.1")
import com.mongodb.client.MongoDatabase
import org.bson.Document;


MongoClient client = new MongoClient(new ServerAddress("localhost"));
MongoDatabase database = client.getDatabase("databaseTest")
MongoCollection<Document> collection = database.getCollection("collectionTest")

println "Connected"

Document newDocument = new Document().append("name", "eduardo")

collection.insertOne(newDocument)


