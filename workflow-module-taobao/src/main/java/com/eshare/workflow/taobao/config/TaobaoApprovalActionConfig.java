package com.eshare.workflow.taobao.config;

import com.eshare.workflow.taobao.action.TaobaoApprovalAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean注册类
 * Created by liangyh on 2018/5/20.
 * Email:10856214@163.com
 */
@Configuration
public class TaobaoApprovalActionConfig {

    @Bean
    public TaobaoApprovalAction getDemoAction() {
        return new TaobaoApprovalAction();
    }

}
