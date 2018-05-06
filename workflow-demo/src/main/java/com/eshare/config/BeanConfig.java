package com.eshare.config;

import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import com.eshare.scheduler.ModuleRefreshSchedulerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangyh on 2018/4/2.
 * Email:10856214@163.com
 */
@Configuration
public class BeanConfig {

    /**
     * 初始化模块加载器
     */
    @Bean(name = "moduleLoader")
    public ModuleLoaderImpl generateLoaderImpl() {
        ModuleLoaderImpl loaderImpl = new ModuleLoaderImpl();
        return loaderImpl;
    }

    /**
     * 初始化模块管理器
     *
     * @return
     */
    @Bean(name = "moduleManager")
    public ModuleManagerImpl generateManagerImpl() {
        ModuleManagerImpl managerImpl = new ModuleManagerImpl();
        return managerImpl;
    }

    /**
     * 初始化模块调度器
     *
     * @return
     */
    @Bean(name = "moduleRefreshScheduler")
    public ModuleRefreshSchedulerImpl generateSchedulerImpl() {
        ModuleRefreshSchedulerImpl schedulerImpl = new ModuleRefreshSchedulerImpl();
        schedulerImpl.setModuleLoader(generateLoaderImpl());
        schedulerImpl.setModuleManager(generateManagerImpl());
        return schedulerImpl;
    }


/*
    *//**
     * 初始化预审核动作处理器
     * @return
     *//*
    @Bean(name = "preApprovalActionHandler")
    public PreApprovalActionHandler generatePreApprovalActionHandler() {
        PreApprovalActionHandler handler = new PreApprovalActionHandler();
        handler.setModuleManager(generateManagerImpl());
        handler.setModuleLoader(generateLoaderImpl());
        return handler;
    }*/


}
