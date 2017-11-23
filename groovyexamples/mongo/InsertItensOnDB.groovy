package com.groovyexamples.mongo

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
@Grab(group="commons-io", module="commons-io", version="2.4")

import org.apache.commons.io.IOUtils
import org.bson.Document
import org.json.JSONArray
import org.json.JSONObject;


MongoClient client = new MongoClient(new ServerAddress("localhost"))
MongoDatabase database = client.getDatabase("databaseTest")
MongoCollection<Document> collection;

def jsons = $/{"Makes":[{"make_id":"acura","make_display":"Acura","make_is_common":"1","make_country":"USA"},{"make_id":"alpina","make_display":"Alpina","make_is_common":"0","make_country":"UK"},{"make_id":"aston-martin","make_display":"Aston Martin","make_is_common":"1","make_country":"UK"},{"make_id":"audi","make_display":"Audi","make_is_common":"1","make_country":"Germany"},{"make_id":"bentley","make_display":"Bentley","make_is_common":"1","make_country":"UK"},{"make_id":"bmw","make_display":"BMW","make_is_common":"1","make_country":"Germany"},{"make_id":"bugatti","make_display":"Bugatti","make_is_common":"1","make_country":"Italy"},{"make_id":"buick","make_display":"Buick","make_is_common":"1","make_country":"USA"},{"make_id":"cadillac","make_display":"Cadillac","make_is_common":"1","make_country":"USA"},{"make_id":"chevrolet","make_display":"Chevrolet","make_is_common":"1","make_country":"USA"},{"make_id":"chrysler","make_display":"Chrysler","make_is_common":"1","make_country":"USA"},{"make_id":"dodge","make_display":"Dodge","make_is_common":"1","make_country":"USA"},{"make_id":"ferrari","make_display":"Ferrari","make_is_common":"1","make_country":"Italy"},{"make_id":"ford","make_display":"Ford","make_is_common":"1","make_country":"USA"},{"make_id":"gmc","make_display":"GMC","make_is_common":"1","make_country":"USA"},{"make_id":"honda","make_display":"Honda","make_is_common":"1","make_country":"Japan"},{"make_id":"hummer","make_display":"Hummer","make_is_common":"1","make_country":"USA"},{"make_id":"hyundai","make_display":"Hyundai","make_is_common":"1","make_country":"South Korea"},{"make_id":"infiniti","make_display":"Infiniti","make_is_common":"1","make_country":"Japan"},{"make_id":"jaguar","make_display":"Jaguar","make_is_common":"1","make_country":"UK"},{"make_id":"jeep","make_display":"Jeep","make_is_common":"1","make_country":"USA"},{"make_id":"kia","make_display":"Kia","make_is_common":"1","make_country":"South Korea"},{"make_id":"koenigsegg","make_display":"Koenigsegg","make_is_common":"1","make_country":"Sweden"},{"make_id":"lamborghini","make_display":"Lamborghini","make_is_common":"1","make_country":"Italy"},{"make_id":"land-rover","make_display":"Land Rover","make_is_common":"1","make_country":"UK"},{"make_id":"lexus","make_display":"Lexus","make_is_common":"1","make_country":"Japan"},{"make_id":"lincoln","make_display":"Lincoln","make_is_common":"1","make_country":"USA"},{"make_id":"lotus","make_display":"Lotus","make_is_common":"1","make_country":"UK"},{"make_id":"maserati","make_display":"Maserati","make_is_common":"1","make_country":"Italy"},{"make_id":"maybach","make_display":"Maybach","make_is_common":"1","make_country":"Germany"},{"make_id":"mazda","make_display":"Mazda","make_is_common":"1","make_country":"Japan"},{"make_id":"mercedes-benz","make_display":"Mercedes-Benz","make_is_common":"1","make_country":"Germany"},{"make_id":"mercury","make_display":"Mercury","make_is_common":"1","make_country":"USA"},{"make_id":"mini","make_display":"Mini","make_is_common":"1","make_country":"UK"},{"make_id":"mitsubishi","make_display":"Mitsubishi","make_is_common":"1","make_country":"Japan"},{"make_id":"nissan","make_display":"Nissan","make_is_common":"1","make_country":"Japan"},{"make_id":"pagani","make_display":"Pagani","make_is_common":"1","make_country":"Italy"},{"make_id":"pontiac","make_display":"Pontiac","make_is_common":"1","make_country":"USA"},{"make_id":"porsche","make_display":"Porsche","make_is_common":"1","make_country":"Germany"},{"make_id":"rolls-royce","make_display":"Rolls-Royce","make_is_common":"1","make_country":"UK"},{"make_id":"saab","make_display":"Saab","make_is_common":"1","make_country":"Sweden"},{"make_id":"saturn","make_display":"Saturn","make_is_common":"1","make_country":"USA"},{"make_id":"scion","make_display":"Scion","make_is_common":"1","make_country":"Japan"},{"make_id":"smart","make_display":"Smart","make_is_common":"1","make_country":"France"},{"make_id":"ssc","make_display":"SSC","make_is_common":"1","make_country":"USA"},{"make_id":"subaru","make_display":"Subaru","make_is_common":"1","make_country":"Japan"},{"make_id":"suzuki","make_display":"Suzuki","make_is_common":"1","make_country":"Japan"},{"make_id":"tesla","make_display":"Tesla","make_is_common":"1","make_country":"USA"},{"make_id":"toyota","make_display":"Toyota","make_is_common":"1","make_country":"Japan"},{"make_id":"volkswagen","make_display":"Volkswagen","make_is_common":"1","make_country":"Germany"},{"make_id":"volvo","make_display":"Volvo","make_is_common":"1","make_country":"Sweden"},{"make_id":"zenvo","make_display":"Zenvo","make_is_common":"0","make_country":"Denmark"}]}/$

JSONArray jsonArray = new JSONObject(jsons).get("Makes")
List<Document> documentList = new ArrayList<Document>()

for(json in jsonArray){
    documentList.add(new Document().parse(json.toString()))
}

collection = database.getCollection("cars").insertMany(documentList)
