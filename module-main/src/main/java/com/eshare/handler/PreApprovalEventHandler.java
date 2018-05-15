package com.eshare.handler;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.NodeEventHandler;
import com.bstek.uflo.process.node.Node;
import org.springframework.stereotype.Component;

/**
 * 预审核事件处理类
 * Created by liangyh on 2018/5/5.
 * Email:10856214@163.com
 */
@Component
public class PreApprovalEventHandler implements NodeEventHandler {
    @Override
    public void enter(Node node, ProcessInstance processInstance, Context context) {

    }

    @Override
    public void leave(Node node, ProcessInstance processInstance, Context context) {

    }
}
