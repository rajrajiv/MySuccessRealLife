package com.msrl.mySuccessRealLife.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistration {
	
    @JsonProperty("SponsorID") 
    public int sponsorID;
    
    @JsonProperty("SponsorName") 
    public String sponsorName;
    
    @JsonProperty("UserName") 
    public String userName;
    
    @JsonProperty("DateOfBirth") 
    public String dateOfBirth;
    
    @JsonProperty("Email") 
    public String email;
    
    @JsonProperty("Password") 
    public String password;
    
    @JsonProperty("MobileNumber") 
    public long mobileNumber;
    
    @JsonProperty("AdhaarNumber") 
    public String adhaarNumber;
    
    @JsonProperty("Pan") 
    public String pan;
    
    @JsonProperty("Country") 
    public String country;
    
    @JsonProperty("State") 
    public String state;
    
    @JsonProperty("Address") 
    public String address;

}
