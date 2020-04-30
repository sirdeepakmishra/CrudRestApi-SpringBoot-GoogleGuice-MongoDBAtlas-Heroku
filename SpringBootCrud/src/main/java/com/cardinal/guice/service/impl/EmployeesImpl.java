package com.cardinal.guice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.cardinal.guice.connection.MongoConnect;
import com.cardinal.guice.service.IEmployees;
import com.cardinal.model.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

public class EmployeesImpl implements IEmployees {

	@Override
	public List<?> getAll() {
		List<Document> documents = null;
		try {
			documents = (List<Document>) MongoConnect.getMongoCollection().find().into(new ArrayList<Document>());
		//	MongoConnect.getMongoClient().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documents;

	}

	@Override
	public Object getOne(long id) {
		Document query = new Document("_id", id);
		Document documents = (Document) MongoConnect.getMongoCollection().find(query).iterator().next();
		//MongoConnect.getMongoClient().close();
		return documents;
	}

	@Override
	public Employee postOne(Employee json1) {
		Document query = new Document().append("_id", json1.getId()).append("firstName", json1.getFirstName())
				.append("lastName", json1.getLastName()).append("emailId", json1.getEmailId());
		MongoConnect.getMongoCollection().insertOne(query);
		return json1;
	}

	@Override
	public boolean deleteOne(long id) {
		Document query = new Document("_id", id);
		DeleteResult dr = MongoConnect.getMongoCollection().deleteOne(query);
		//MongoConnect.getMongoClient().close();
		return dr.wasAcknowledged();
	}

	@Override
	public boolean deleteAll() {
		DeleteResult dr = MongoConnect.getMongoCollection().deleteMany(new BasicDBObject());// new Document()
	//	MongoConnect.getMongoClient().close();
		return dr.wasAcknowledged();
	}

	@Override
	public Employee putOne(Long id,Employee json1) {
		Bson filter = Filters.eq("_id", id);
		Document query = new Document().append("firstName", json1.getFirstName())
				.append("lastName", json1.getLastName()).append("emailId", json1.getEmailId());
		MongoConnect.getMongoCollection().findOneAndReplace(filter, query);
		json1.setId(id);
		return json1;
	}

}
