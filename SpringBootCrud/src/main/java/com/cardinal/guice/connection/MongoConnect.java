package com.cardinal.guice.connection;

import org.bson.Document;
import com.google.inject.Singleton;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Singleton
public class MongoConnect {

	private static MongoClient mongoClient = null;
	private static MongoCollection<Document> collection = null;

	public static MongoClient getMongoClient() {
		if (mongoClient == null) {
			try {

				String s = "mongodb+srv://root:root@cluster0-qd39t.mongodb.net/EmployeeDB?retryWrites=true&w=majority";

				MongoClientURI uri = new MongoClientURI(s);
				mongoClient = new MongoClient(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return mongoClient;

	}

	public static MongoCollection<Document> getMongoCollection() {
		if (collection == null) {
			try {
				MongoDatabase database = MongoConnect.getMongoClient().getDatabase("EmployeeDB");
				collection = database.getCollection("employee");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return collection;
	}

}
