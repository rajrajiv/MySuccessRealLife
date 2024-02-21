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
	
    UserConstant user = new UserConstant();
    String sponsorName = null;
    
    public String validateSignIn(String msrlId, String password) {
    	
    	String userStatement = "SELECT * FROM USER_DETAILS";
    	String url = dataSource.getUrl();
    	String userName = dataSource.getUserName();
    	String dbPassword = dataSource.getPassword();
    	System.out.println("url is "+url);
    	
    	try (Connection conn = DriverManager.getConnection(url, userName, dbPassword); 
    	        PreparedStatement ps = conn.prepareStatement(userStatement); 
    	        ResultSet rs = ps.executeQuery()) {
    		System.out.println("outside while");
    	        while (rs.next()) {
    	            long id = rs.getLong("msrlid");
    	            System.out.println("user ID is  "+id);
    	            String name = rs.getString("FirstName");
    	            System.out.println("user name is "+name);
    	            String lastName = rs.getString("LastName");

    	            // do something with the extracted data...
    	        }
    	} catch (SQLException e) {
    	    // handle the exception
    	}
    	
    	
        if (msrlId.equals(user.msrlId) && password.equals(user.msrlPassword)) {
            return user.userName;
        } else {
            return userName;
        }
    }
    
    public String verifysponsorMethod(String sponsorId) {
    	
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
    	if(null == sponsorName) {
    		
    		System.out.println("sponsor ID does not exist");
    		
    		return "sponsor ID does not exist";
    		
    	}
    	
		return sponsorName;
    	
    }
    
}

