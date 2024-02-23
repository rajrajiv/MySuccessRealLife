package com.msrl.mySuccessRealLife.constant;

public class UserConstant {

	public String msrlId = "12345";
	public String msrlPassword = "1234567";
	public String userName = "Utsav Tiwari";
	public String total_user = "10";
	public String active_user = "5";
	public String inactive_user = "1";
	public String total_direct = "5";
	public String tair = "gold";
	public String reward = "5000";
	public String category = "middle";
	public String joining_date = "07/02/2024";
	public String activation_date = "07/02/2024";
	
	public String checkAdhaarExist = "SELECT * FROM USER_DETAILS WHERE AdhaarNumber =?";
	
	public String verifysponsorId = "SELECT * FROM USER_DETAILS WHERE msrlid =?";
	
	public String getMemberDetails = "SELECT * FROM MEMBER_DETAILS WHERE msrlid =?";
	
	public String insertIntoUserDetails = "INSERT INTO `msrl`.`user_details` (`SponsorID`, "
			+ "`DateOfBirth`, `Email`, `Password`, `UserName`, `Address`, `MobileNumber`, "
			+ "`AdhaarNumber`, `Pan`, `Country`, `State`, `JoiningDate`, `userStatus`) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
