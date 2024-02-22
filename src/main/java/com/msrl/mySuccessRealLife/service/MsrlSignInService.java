package com.msrl.mySuccessRealLife.service;

import com.msrl.mySuccessRealLife.configuration.DataSourceConfig;
import com.msrl.mySuccessRealLife.constant.UserConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsrlSignInService {
	
	@Autowired
	DataSourceConfig dataSource;
	
//    UserConstant user = new UserConstant();
    String userName = null;
    
    public String validateSignIn(String msrlId, String password) {
    	
    	String fetchedPassword = null;
    	boolean isExist = false;
    	ResultSet rs;
    	QueryDataBase queryDb = new QueryDataBase();
    	rs = queryDb.fetchFromDataBase(msrlId, dataSource, "signin");
    	
    	if(null != rs) {
    		
    		try {
				while (rs.next()) {
					
					fetchedPassword = rs.getString("password");
					System.out.println("password after query is :::"+password);
					
					if(null != fetchedPassword && fetchedPassword.equals(password)) {
						userName = rs.getString("username");
						System.out.println("userName after query is :::"+userName);
						isExist = true;
					}
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		finally {
    			if(null != queryDb) {
    				queryDb = null;
    			}
    		}    		
    	}
		if(!isExist) {
			return "INVALID USERNAME OR PASSWORD !";
		}
		else {
			return userName;
		}
    }
    
    public String verifysponsorMethod(String sponsorId) {
    	String sponsorName = null;
    	ResultSet rs;
    	QueryDataBase queryDb = new QueryDataBase();
    	rs = queryDb.fetchFromDataBase(sponsorId, dataSource, "verifysponsor");
    	
    	if(null != rs) {
    		
    		try {
				while (rs.next()) {
					
					sponsorName = rs.getString("username");
					System.out.println("sponsorName after query is :::"+sponsorName);
					break;
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		finally {
    			if(null != queryDb) {
    				queryDb = null;
    			}
//    			if(null != rs) {
//    				rs = null;    				
//    			}
    		}
    		
    	}
    	System.out.println("sponsorName returning is :::"+sponsorName);
    	if(null == sponsorName) {
    		
    		System.out.println("sponsor ID does not exist");
    		
    		return "NOT PRESENT";
    		
    	}
    	
		return sponsorName;
    	
    }
    
}

