package com.groovyexamples.mongo

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoCursor
import com.mongodb.client.MongoDatabase
import org.bson.Document
import static com.mongodb.client.model.Filters.*;


MongoClient client = new MongoClient(new ServerAddress("localhost"))
MongoDatabase database = client.getDatabase("databaseTest")
MongoCollection<Document> collection = database.getCollection("cars")


Document document = collection.find(eq("make_country", "USA")).first()

println document.toString()


Document document2 = collection.find(and(eq("make_country", "USA"), eq("make_id", "hummer"))).first()

println document2.toString()

MongoCursor<Document> cursor = collection.find(or(eq("make_country", "USA"), eq("make_country", "Japan"))).iterator()
//cursor is a iterator

cursor.each {

    println it
}

