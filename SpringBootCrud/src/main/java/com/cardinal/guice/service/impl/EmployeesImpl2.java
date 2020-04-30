//package com.cardinal.guice.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.bson.Document;
//import org.springframework.beans.BeanUtils;
//
//import com.cardinal.guice.service.IEmployees;
//import com.cardinal.model.Employee;
//import com.google.inject.Singleton;
//import com.mongodb.BasicDBObject;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.result.DeleteResult;
//
////@Service("EmpService")
////@Component
////@Transactional
////@Configuration
//
//public class EmployeesImpl2 implements IEmployees {
//
//	
////	@Value("${spring.data.mongodb.uri}")
////	private String url;
//	// @Autowired
//	// private EmployeeRepository employeeRepository;
//
//	
//	@Singleton
//	private static  MongoClient getMongoClient() {
//		MongoClient mongoClient = null;
//		try {
//
//			String s = "mongodb+srv://root:root@cluster0-qd39t.mongodb.net/EmployeeDB?retryWrites=true&w=majority";
//
//			MongoClientURI uri = new MongoClientURI(s);
//			 mongoClient = new MongoClient(uri);
//			 
//			// mongoClient.close();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return mongoClient;
//	}
//	@Singleton
//	private static  MongoCollection<Document> getMongoCollection() {
//		MongoCollection<Document> collection =null;
//		//MongoClient mongoClient = null;
//		try {
//
////			String s = "mongodb+srv://root:root@cluster0-qd39t.mongodb.net/EmployeeDB?retryWrites=true&w=majority";
////
////			MongoClientURI uri = new MongoClientURI(s);
////			 mongoClient = new MongoClient(uri);
//			MongoDatabase database =EmployeesImpl2.getMongoClient().getDatabase("EmployeeDB");
//			 collection = database.getCollection("employee");
//			 
//			// mongoClient.close();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return collection;
//	}
//	
//	@Override
//	public List<?> getAll() {
//
//		
//		
////		DBCursor cursor = dBCollection.find();
////		 while(cursor.hasNext())
////		    {
////		        System.out.println(cursor.next());
////		    }
//
//		System.out.println("showAll--------------------");
////		System.out.println("+ employeeRepository.findAll()-----------------" + employeeRepository.findAll());
////		return employeeRepository.findAll();
//
//		List<Document> l = new ArrayList<Document>();
//		List<Document> documents =null;
//		try {
//			 documents = (List<Document>) EmployeesImpl2.getMongoCollection().find().into(new ArrayList<Document>());
//			 EmployeesImpl2.getMongoClient().close();
//
////			String s = "mongodb+srv://root:root@cluster0-qd39t.mongodb.net/EmployeeDB?retryWrites=true&w=majority";
////
////			MongoClientURI uri = new MongoClientURI(s);
////			MongoClient mongoClient = new MongoClient(uri);
////			MongoDatabase database = mongoClient.getDatabase("EmployeeDB");
////			MongoCollection<Document> collection = database.getCollection("employee");
//
//			// Document res=collection.find().iterator().next();
//
////			Iterator<Document> itr = collection.find().iterator();
////			while (itr.hasNext()) {
////
////				System.out.println("----->>>");
////				l.add(itr.next());
////			}
//
////			 documents = (List<Document>) collection.find().into(new ArrayList<Document>());
//
////			for (Document document : documents) {
////				System.out.println(document);
////			}
//
////			mongoClient.close();
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return documents; // res.toJson();
//
//	}
//
//	@Override
//	public Object getOne(long id) {
//		Document query = new Document("_id", id);
//	Document documents = (Document) EmployeesImpl2.getMongoCollection().find(query).iterator().next();
//		 EmployeesImpl2.getMongoClient().close();
//		return documents;
//	}
//
//	@Override
//	public Employee postOne(Employee json1) {
////		String json = "{'database' : 'mkyongDB','table' : 'hosting'," +
////				  "'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";
////
////				DBObject dbObject = (DBObject)JSON.parse(json1);
////
////				//EmployeesImpl.getMongoCollection().insertOne(dbObject);
////				
////				BasicDBObject document = new BasicDBObject();
////				document.put("database", "mkyongDB");
////				document.put("table", "hosting");
////
////				BasicDBObject documentDetail = new BasicDBObject();
////				documentDetail.put("records", 99);
////				documentDetail.put("index", "vps_index1");
////				documentDetail.put("active", "true");
//
////				document.put("detail", documentDetail);
//		Document query = new Document();
//		//query.toJson();
//		BeanUtils.copyProperties(json1, query);
////				Document query = new Document("_id", "1")
////						.append("name", "deep")
////						.append("", "");
//				System.out.println("----"+query);
//	//	EmployeesImpl.getMongoCollection().insertOne(query);
//				//collection.insert(document);
//		return json1;
//	}
//	
//	
//	
//
//	@Override
//	public boolean deleteOne(long id) {
//		Document query = new Document("_id", id);
//		DeleteResult dr= EmployeesImpl2.getMongoCollection().deleteOne(query);
//		 EmployeesImpl2.getMongoClient().close();
//		return dr.wasAcknowledged();
//	}
//	@Override
//	public boolean deleteAll() {
//		// Delete All documents from collection Using blank BasicDBObject
//		DeleteResult dr= EmployeesImpl2.getMongoCollection().deleteMany(new BasicDBObject());//new Document()
//		 EmployeesImpl2.getMongoClient().close();
//		return dr.wasAcknowledged();
//	}
//	@Override
//	public Employee putOne(Employee json1) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//
//}
