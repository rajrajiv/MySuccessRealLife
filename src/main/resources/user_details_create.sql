CREATE TABLE user_details 
(   MsrlId int AUTO_INCREMENT,
	SponsorID int,
	DateOfBirth varchar(20),
	Email varchar(50),
	Password varchar(25),
	UserName varchar(50),
	Address varchar(255),
	MobileNumber bigint,
	AdhaarNumber varchar(25),
	Pan varchar(25),
	Country varchar(25),
	State varchar(25),
	JoiningDate date,
	userStatus varchar(10),
	ActivationDate date,
	userType varchar(10),
	 PRIMARY KEY(MsrlId, AdhaarNumber, Pan)
	)
	
