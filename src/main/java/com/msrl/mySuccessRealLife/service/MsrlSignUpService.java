package com.msrl.mySuccessRealLife.service;

import jakarta.persistence.Entity;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.msrl.mySuccessRealLife.configuration.DataSourceConfig;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class MsrlSignUpService {
	
	@Autowired
	DataSourceConfig dataSource;
	
	private UserRegistration userRegistration = null;
	private Integer newMsrlId = null;
	private ResultSet rs ;

	public String reigsterUser(JsonNode signUpNode) {
		// TODO Auto-generated method stub
		ObjectMapper om = new ObjectMapper();
		try {
			userRegistration = om.treeToValue(signUpNode, UserRegistration.class);
			if(null != userRegistration) {
				System.out.println("name is::"+userRegistration.userName);
				System.out.println("Adhaar number is::"+userRegistration.adhaarNumber);	
				
				boolean isExists = checkIfUserExists(userRegistration.adhaarNumber);
				System.out.println("Doest user already exist::"+isExists);	
								
				if(!isExists) {
					registerNewUser();
				}
				else {
					System.out.println("USER WITH THIS ADHAAR ALREADY EXIST");
				}
			}
			else
				System.out.println("user registratiion object is null");
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private void registerNewUser() {
		
		
		QueryDataBase queryDb = new QueryDataBase();
		System.out.println("user doest not Exist !! Registering new user");
		queryDb.insertIntoDataBase(userRegistration, dataSource);
		
		if(null != queryDb) {
			queryDb = null;
		}
		
		
	}

	private boolean checkIfUserExists(String adhaarNumber) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean isExist = false;
		QueryDataBase queryDb = new QueryDataBase();
    	
		rs = queryDb.fetchFromDataBase(adhaarNumber, dataSource,"checkadhaar");
		try {
			if(null!= rs) {
				while(rs.next()) {
					System.out.println("USER ALREADY EXIST WITH ID:"+rs.getInt("MsrlId"));
					isExist = true;
					break;
				}
			}
		}
		finally {
			if(null!= rs) {
				rs = null;
			}
			if(null != queryDb) {
				queryDb = null;
			}
		}
		
		return isExist;
	}
}
