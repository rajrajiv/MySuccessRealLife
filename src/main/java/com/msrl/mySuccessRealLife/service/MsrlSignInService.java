package com.msrl.mySuccessRealLife.service;

import com.msrl.mySuccessRealLife.constant.UserConstant;
import org.springframework.stereotype.Service;


@Service
public class MsrlSignInService {
    
    UserConstant user = new UserConstant();
    String name = null;
    public String validateSignIn(String msrlId, String password) {
        if (msrlId.equals(user.msrlId) && password.equals(user.msrlPassword)) {
            return user.userName;
        } else {
            return name;
        }
    }
}

