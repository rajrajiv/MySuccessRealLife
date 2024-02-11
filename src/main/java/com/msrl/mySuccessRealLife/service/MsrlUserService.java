package com.msrl.mySuccessRealLife.service;

import com.msrl.mySuccessRealLife.constant.UserConstant;
import org.springframework.stereotype.Service;

@Service

public class MsrlUserService {

    UserConstant user = new UserConstant();

    private String sponsor_id = null;
    private String name = null;
    private String total_user = null;
    private String active_user = null;
    private String inactive_user = null;
    private String total_direct = null;
    private String tair = null;
    private String reward = null;
    private String categoty = null;
    private String joining_date = null;
    private String activation_date = null;

    public String Show() {

        sponsor_id = user.msrlId;
        name = user.userName;
        total_user = user.total_user;
        active_user = user.active_user;
        inactive_user = user.inactive_user;
        total_direct = user.total_direct;
        tair = user.tair;
        reward = user.reward;
        joining_date = user.joining_date;
        activation_date = user.activation_date;

        return sponsor_id;

    }


}
