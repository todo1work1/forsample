package com.smm.model.factory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

@SuppressWarnings("deprecation")
public class MongoFactory {

	private static Mongo mongodb;
	
	private MongoFactory(){}
	
	
	public static Mongo getMongoDb(){
		if(mongodb == null){
			mongodb = new Mongo("localhost", 27017);
		}
		return mongodb;
	}
	
	public static DB getDB(String dbName){
		return getMongoDb().getDB(dbName);
	}
	
	public static DBCollection getCollection(String dbName, String collectionName){
		return getDB(dbName).getCollection(collectionName);
	}
}
