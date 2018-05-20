package com.eshare.workflow.tencent.config;

import com.eshare.workflow.tencent.action.TencentApprovalAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean注册类
 * Created by liangyh on 2018/5/20.
 * Email:10856214@163.com
 */
@Configuration
public class TencentApprovalActionConfig {

    @Bean
    public TencentApprovalAction getDemoAction() {
        return new TencentApprovalAction();
    }

}
