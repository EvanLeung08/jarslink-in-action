package com.eshare.handler;

import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.ActionHandler;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 预审核动作处理类
 * Created by liangyh on 2018/5/5.
 * Email:10856214@163.com
 */
@Component
@Data
public class PreApprovalActionHandler implements ActionHandler {
    @Autowired
    private ModuleManager moduleManager;
    @Autowired
    private ModuleLoader moduleLoader;

    @Override
    public void handle(ProcessInstance processInstance, Context context) {
        String moduleName = (String) context.getProcessService().getProcessVariable("moduleName",processInstance);
        String actionName =(String) context.getProcessService().getProcessVariable("actionName",processInstance);
        //查找模块
        Module findModule = moduleManager.find(moduleName);
        String actionRequest = "预审核";
        findModule.doAction(actionName, actionRequest);
    }
}
