package com.msrl.mySuccessRealLife.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
//import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msrl.mySuccessRealLife.configuration.DataSourceConfig;
import com.msrl.mySuccessRealLife.constant.UserConstant;

@Service
public class QueryDataBase {

	UserConstant userConstant = new UserConstant();
	String url = null;
	String userName = null;
	String dbPassword = null;

	
	public ResultSet fetchFromDataBase(String queryParam1, DataSourceConfig dataSource, String flow) {

    	String query = null;
    	if("checkadhaar".equals(flow)) {
    		System.out.println("IN CHECK ADHAARRRRRR !!!");
    		query = userConstant.checkAdhaarExist;
    		
    	}
    	else if("verifysponsor".equals(flow) || "signin".equals(flow)) {
    		System.out.println("IN CHECK SIGNIN/VERIFYSPONSORRRRR !!!");
    		query = userConstant.verifysponsorId;
    	}
    	else if("memberdetails".equals(flow)) {
    		System.out.println("IN GET MEMBER DETAILSSSSSSS !!!");
    		query = userConstant.getMemberDetails;
    	}
    	
    	setDataSource(dataSource);
    	ResultSet rs =null;
    	try
    	{
    		Connection conn = DriverManager.getConnection(url, userName, dbPassword); 
	        PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, queryParam1);
			
			System.out.println("queriying with adhaar no/sponsorid::"+queryParam1+": with flow as:"+flow);
			System.out.println("prepared statement with adhaar no/sponsorid::"+ps.toString());
			
	        rs = ps.executeQuery();
	        System.out.println("Result set after execution is:"+rs);
    	} 
    	catch (SQLException e) {
    	    // handle the exception
    		System.out.println("ERROR OCCURRED WHILE QUERYING DATABASE");
    		e.printStackTrace();
    	}
    		
		return rs;
		
	}
	
	private void setDataSource(DataSourceConfig dataSource) {
		// TODO Auto-generated method stub
		
		
		url = dataSource.getUrl();
		userName = dataSource.getUserName();
		dbPassword = dataSource.getPassword();
		
    	System.out.println("url is in setDataSource::  "+url);
		
	}

	public Integer insertIntoDataBase (UserRegistration userRegistration, DataSourceConfig dataSource) {
		
		Integer id = null;
		String insertQuery = userConstant.insertIntoUserDetails;
		ResultSet rs =null;
		
		setDataSource(dataSource);

//		java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
//		System.out.println("system sqlDate is ::"+sqlDate);
		Date registrationDate = Date.valueOf(LocalDate.now());
		System.out.println("Today's date is:"+registrationDate);
		
		try
    	{
			Connection conn = DriverManager.getConnection(url, userName, dbPassword); 
	        PreparedStatement ps = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS); 
	        ps.setInt(1, userRegistration.sponsorID);
	        ps.setString(2, userRegistration.dateOfBirth);
	        ps.setString(3, userRegistration.email);
	        ps.setString(4, userRegistration.password);
	        ps.setString(5, userRegistration.userName);
	        ps.setString(6, userRegistration.address);
	        ps.setLong(7, userRegistration.mobileNumber);
	        ps.setString(8, userRegistration.adhaarNumber);
	        ps.setString(9, userRegistration.pan);
	        ps.setString(10, userRegistration.country);
	        ps.setString(11, userRegistration.state);
	        ps.setDate(12, registrationDate);
	        ps.setString(13, "INACTIVE");
	        int count = ps.executeUpdate();
//	        conn.commit();
//	        conn.close();
	        
	        System.out.println("INSERT STATEMENT IS ::"+ps.toString());
	        System.out.println("No of records Inserted is::"+count);
	        
	        if(count>0) {
	        	rs = ps.getGeneratedKeys();
	        	
	        	while (rs.next()) {
	                // these are your autogenerated keys, do something with them
	        		id = rs.getInt(1);
	                System.out.println("USER REGISTERED SUCCESSFULY WITH MSRLID ::"+id);
	            }
	        	
	        }
    	} 
    	catch (SQLException e) {
    	    // handle the exception
    		System.out.println("ERROR OCCURRED WHILE INSERTING INTO DATABASE");
    		e.printStackTrace();
    	}
		return id;
		
		
	}
}
