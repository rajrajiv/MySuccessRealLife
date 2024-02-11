package com.msrl.mySuccessRealLife.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Service;

@Service
@Entity

@Table(name= "MSRL")

public class MsrlSignUpService {
    @Id
    private String sponsor_id;
    private String name;
    private String email;
    private String password;
    private String re_password;
    private String mobile_no;
    private String aadhaar_no;
    private String pan_no;
    private String address;

    public MsrlSignUpService()
    {

    }

    public MsrlSignUpService(String sponsor_id, String name, String email, String password,String re_password, String mobile_no, String aadhaar_no,String pan_no, String address)
    {
        this.setSponsor_id(sponsor_id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRe_password(re_password);
        this.setMobile_no(mobile_no);
        this.setAadhaar_no(aadhaar_no);
        this.setPan_no(pan_no);
        this.setAddress(address);
    }

    public String getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(String sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRe_password() {
        return re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }


    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAadhaar_no() {
        return aadhaar_no;
    }

    public void setAadhaar_no(String aadhaar_no) {
        this.aadhaar_no = aadhaar_no;
    }
    public String getPan_no() {
        return pan_no;
    }

    public void setPan_no(String pan_no) {
        this.pan_no = pan_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
