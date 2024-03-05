package com.msrl.mySuccessRealLife;

import com.msrl.mySuccessRealLife.service.MsrlSignUpService;
import com.msrl.mySuccessRealLife.service.MsrlUserService;
import com.msrl.mySuccessRealLife.service.UserDetailsDashboard;

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

    @GetMapping("/signIn/{id}/{password}")
    @ResponseBody
    public UserDetailsDashboard signIn(@PathVariable String id, @PathVariable String password) {
    	
    	UserDetailsDashboard userDetails = null;
//    	UserDetailsDashboard userDetails = new UserDetailsDashboard("My Success Real Life", "Inactive", "1", 1, 0, 1, 1, "None", "Star", "14-02-2024", null);
    	
        if (null != id && null != password) {            
            userDetails = msrlService.validateSignIn(id, password);
            System.out.println(userDetails);
        }
        
        return userDetails;
    }

    @GetMapping("/verify/{sponsorId}")
    @ResponseBody
    public String verifysponsor(@PathVariable String sponsorId)
    {
        return msrlService.verifysponsorMethod(sponsorId);
    	//return "My Success Real Life";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody JsonNode signUpNode) throws Exception
    {
    	System.out.println("JSON received is:::"+signUpNode.toString());
        String userId = signUpService.reigsterUser(signUpNode);
        System.out.println("returning user ID to page is:::"+userId.toString());
        return userId.toString();
      // return "123";
    }

}
