package com.msrl.mySuccessRealLife.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailsDashboard {
	
	public UserDetailsDashboard(String userName, String status, String msrlid, int totalUser, int activeUser, int inactiveUser, 
			int totalDirect, String rewards, String category, String joiningDate, String activationDate) {
		System.out.println("setting values in dashboard constructor !!!");
		setUserName(userName);
		setStatus(status);
		setMsrlId(msrlid);
		setTotalUser(totalUser);
		setActiveUser(inactiveUser);
		setInactiveUser(inactiveUser);
		setTotalDirect(totalDirect);
		setRewards(rewards);
		setCategory(category);
		setJoiningDate(joiningDate);
		setActivationDate(activationDate);
		
	}
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("status")
	private String status;
    
	@JsonProperty("msrlId")
	private String msrlId;
    
	@JsonProperty("totalUser")
	private int totalUser;
	
	@JsonProperty("activeUser")
	private int activeUser;
	
	@JsonProperty("inactiveUser")
	private int inactiveUser;
	
	@JsonProperty("totalDirect")
	private int totalDirect;
	
	@JsonProperty("rewards")
	private String rewards;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("joiningDate")
	private String joiningDate;
	
	@JsonProperty("activationDate")
	private String activationDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsrlId() {
		return msrlId;
	}

	public void setMsrlId(String msrlid2) {
		this.msrlId = msrlid2;
	}

	public int getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
	}

	public int getInactiveUser() {
		return inactiveUser;
	}

	public void setInactiveUser(int inactiveUser) {
		this.inactiveUser = inactiveUser;
	}

	public int getTotalDirect() {
		return totalDirect;
	}

	public void setTotalDirect(int totalDirect) {
		this.totalDirect = totalDirect;
	}

	public String getRewards() {
		return rewards;
	}

	public void setRewards(String rewards) {
		this.rewards = rewards;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

}
