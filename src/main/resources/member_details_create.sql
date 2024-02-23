CREATE TABLE member_details 
(   
	memberId int,
	MsrlId int,
	TotalUsers int,
	DirectUsers int,
	IndirectUsers int,
	ActiveUsers int,
	InactiveUsers int,
	Rewards varchar(100),
	Category varchar(25),
	 PRIMARY KEY(memberId)
)
	
	public String insertIntoUserDetails = "INSERT INTO `msrl`.`user_details` (`SponsorID`, "
			+ "`DateOfBirth`, `Email`, `Password`, `UserName`, `Address`, `MobileNumber`, "
			+ "`AdhaarNumber`, `Pan`, `Country`, `State`, `JoiningDate`, `userStatus`) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";