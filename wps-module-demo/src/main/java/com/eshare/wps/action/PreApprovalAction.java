package com.eshare.wps.action;


import com.alipay.jarslink.api.Action;

/**
 * 预审核动作类
 * Created by liangyh on 2018/5/5.
 * Email:10856214@163.com
 */
public class PreApprovalAction implements Action<String, String> {
    @Override
    public String execute(String actionRequest) {
        System.out.println("执行WPS"+actionRequest+"成功");
            return "SUCCESS";
    }

    @Override
    public String getActionName() {
        return "preApproval";
    }
}
