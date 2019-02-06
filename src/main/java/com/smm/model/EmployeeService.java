package com.smm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.smm.model.factory.MongoFactory;

@Service("empService")
@Transactional
public class EmployeeService {

	String dbName ="mydb";
	String collectionName = "employee";
	
	public List getEmployees(){
		List employeeList = new ArrayList();
		DBCollection collection = MongoFactory.getCollection(dbName, collectionName);
		DBCursor cursor = collection.find();
		while(cursor.hasNext()){
			DBObject object = cursor.next();
			Employee employee = new Employee();
			employee.setId(object.get("id").toString());
			employee.setFirstName(object.get("firstName").toString());
			employee.setLastName(object.get("lastName").toString());
			employee.setCompanyName(object.get("companyName").toString());
			employeeList.add(employee);
		}
		
		return employeeList;
	}
	
	public boolean addEmployee(Employee employee){
		DBCollection collection = MongoFactory.getCollection(dbName, collectionName);
		boolean returnVal=true;
		try{
			BasicDBObject empObject = new BasicDBObject();
			empObject.put("id", String.valueOf(new Random().nextInt(100)));
			empObject.put("firstName", employee.getFirstName());
			empObject.put("lastName", employee.getLastName());
			empObject.put("companyName", employee.getCompanyName());
			collection.insert(empObject);
		}catch(Exception ex){
			returnVal = false;
		}
		 return returnVal;
	}
	
	public Boolean editEmployee(Employee employee) {
        boolean output = false;
        
        try {
            BasicDBObject existing = (BasicDBObject) getDBObject(employee.getId());
 
            DBCollection coll = MongoFactory.getCollection(dbName, collectionName);
 
            
            BasicDBObject empObject = new BasicDBObject();
            empObject.put("id", String.valueOf(new Random().nextInt(100)));
			empObject.put("firstName", employee.getFirstName());
			empObject.put("lastName", employee.getLastName());
			empObject.put("companyName", employee.getCompanyName());
 
            
            coll.update(existing, empObject);
            output = true;
        } catch (Exception e) {
            output = false;
                     
        }
        return output;
    }
	
	public Boolean deleteEmployee(String id) {
        boolean output = false;
        
        try {
            
            BasicDBObject item = (BasicDBObject) getDBObject(id);
 
            DBCollection coll = MongoFactory.getCollection(dbName, collectionName);
 
            
            coll.remove(item);
            output = true;          
        } catch (Exception e) {
            output = false;
                  
        }   
        return output;
    }
	
	
	public Employee findEmployeeId(String id) {
        Employee empObject = new Employee();
        DBCollection coll = MongoFactory.getCollection(dbName, collectionName);
 
        
        DBObject where_query = new BasicDBObject();
        where_query.put("id", id);
 
        DBObject dbo = coll.findOne(where_query);       
        empObject.setId(dbo.get("id").toString());
        empObject.setFirstName(dbo.get("firstName").toString());
		empObject.setLastName(dbo.get("lastName").toString());
		empObject.setCompanyName(dbo.get("companyName").toString());
 
        
        return empObject;
    }
}
