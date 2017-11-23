package com.groovyexamples.mongo

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.result.UpdateResult
import org.bson.Document
import static com.mongodb.client.model.Filters.*;


MongoClient cliente = new MongoClient(new ServerAddress("localhost"))
MongoDatabase database = cliente.getDatabase("databaseTest")
MongoCollection<Document> collection = database.getCollection("cars")

//rename a field
collection.updateOne(eq("make_display", "Hyundai"), new Document('$rename', new Document("make_country", "country")))

//update a value
collection.updateOne(eq("make_display", "Hyundai"), new Document('$set', new Document("make_country", "South Korea")))

//remove a field from a document
collection.updateOne(eq("make_display", "Hyundai"), new Document('$unset', new Document("south korea", "south Korea")))

//update some values
collection.updateMany(eq("make_country", "USA"), new Document('$set', new Document("make_is_common", "1")))

//update some values and print the result
UpdateResult result = collection.updateMany(eq("make_country", "USA"), new Document('$set', new Document("make_is_common", "2")))
println result.getModifiedCount()
