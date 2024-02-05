package com.msrl.mySuccessRealLife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.msrl.mySuccessRealLife.service.MsrlSignInService;

@RestController
public class MySuccessRealLifeController {
    @Autowired
    MsrlSignInService msrlService;

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
        System.out.println("msg");
        return msg;
    }

}
