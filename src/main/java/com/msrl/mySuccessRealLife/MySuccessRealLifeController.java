package com.msrl.mySuccessRealLife;

import com.msrl.mySuccessRealLife.service.MsrlSignUpService;
import com.msrl.mySuccessRealLife.service.MsrlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.msrl.mySuccessRealLife.service.MsrlSignInService;

@RestController
public class MySuccessRealLifeController {
    @Autowired
    MsrlSignInService msrlService;
    @Autowired
    MsrlSignUpService signUpService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/signIn/{id}/{password}")
    @ResponseBody
    public String signIn(@PathVariable String id, @PathVariable String password) {
        if (null != id)
            System.out.println("hi" + id);
        String msg = msrlService.validateSignIn(id, password);
        return msg;
    }

    @GetMapping("/verify/{sponsorId}")
    @ResponseBody
    public String verifysponsor(@PathVariable String sponsorId)
    {
    	System.out.println("Verifying Sponsor ID ::"+sponsorId);
    	
//    	System.out.println("Sponser Name returning is ::"+sponsorName);
        return msrlService.verifysponsorMethod(sponsorId);
        //new MsrlSignUpService(sponsor_id = "123", name = "Utsav", email = "utsav@gmail.com", password = "123" , re_password = "123, mobile_no = "1234567891", aadhaar_no = "1236547554", pan_no = "YKB2400k", address = "Dehradun");
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody JsonNode signUpNode ) throws Exception
    {
        System.out.println("I am here in signup"+signUpNode.toString());
        
        String userId = signUpService.reigsterUser(signUpNode);
        return signUpNode.toString();
    }

    MsrlUserService user;
    @GetMapping("/User")
    public String userDetails(String sponsor_id, String name,String total_user, String active_user, String inactive_user, String total_direc,String reward, String category, String joining_date, String activation_date) {

        return "Utsav";
    }

}
