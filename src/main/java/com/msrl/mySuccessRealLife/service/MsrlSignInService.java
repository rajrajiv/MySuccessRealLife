package com.msrl.mySuccessRealLife.service;

import com.msrl.mySuccessRealLife.configuration.DataSourceConfig;
import com.msrl.mySuccessRealLife.constant.UserConstant;

import java.sql.Connection;
import java.sql.Date;
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
    
    public UserDetailsDashboard validateSignIn(String msrlId, String password) {
    	
    	String fetchedPassword = null;
        String userName = null;
        String status = null;
        String joiningDate = null;
        String activationDate = null;
        Integer totalUsers = null;
        Integer activeUsers = null;
        Integer inactiveUsers = null;
        Integer totalDirectUsers = null;
        Integer totalIndirectUsers = null;
        String rewards = null;
        String category = null;
    	boolean isExist = false;
    	UserDetailsDashboard userDetailsDashboard = null;
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
				if(isExist) {
					status = rs.getString("userstatus");
					joiningDate = rs.getDate("joiningdate").toString();
					
					if(null != status && status.equalsIgnoreCase("active")) {
						activationDate = rs.getDate("activationdate").toString();
					}
					rs = queryDb.fetchFromDataBase(msrlId, dataSource, "memberdetails");
					
					while (rs.next()) {
						
						totalUsers = rs.getInt("TotalUsers");
						activeUsers = rs.getInt("ActiveUsers");
						inactiveUsers = rs.getInt("InactiveUsers");
						totalDirectUsers = rs.getInt("DirectUsers");
						totalIndirectUsers = rs.getInt("IndirectUsers");
						rewards = rs.getString("Rewards");
						category = rs.getString("Category");
						break;
						
					}
					userDetailsDashboard = new 	UserDetailsDashboard(userName, status, msrlId, totalUsers, activeUsers, inactiveUsers, totalDirectUsers, 
									rewards, category, joiningDate, activationDate); 
				}
				
			} 
    		catch (SQLException e) {
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
			return null;
		}
		else {
			return userDetailsDashboard;
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

