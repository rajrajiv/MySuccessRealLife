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
	
	public String insertIntoUserDetails = "INSERT INTO msrl.member_details (`memberId`, ";
			+ "`MsrlId`, `TotalUsers`, `DirectUsers`, `IndirectUsers`, `ActiveUsers`, `InactiveUsers`, "
			+ "`Rewards`, `Category`) VALUES ('?', '?', '?', '?', '?', '?', '?', '?')";