package com.eshare.config;

import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.ModuleService;
import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import com.alipay.jarslink.api.impl.ModuleServiceImpl;
import com.eshare.scheduler.ModuleRefreshSchedulerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by liangyh on 2018/4/2.
 * Email:10856214@163.com
 */
@Configuration
public class BeanConfig {

    /**
     * 初始化模块加载器
     * @return
     */
    @Bean
    public ModuleLoader moduleLoader() {
        return new ModuleLoaderImpl();
    }
    /**
     * 初始化模块管理器
     *
     * @return
     */
    @Bean
    public ModuleManager moduleManager() {
        return new ModuleManagerImpl();
    }


    @Bean
    @DependsOn(value= {"moduleLoader","moduleManager"})
    public ModuleService moduleService(ModuleLoader moduleLoader, ModuleManager moduleManager) {
        ModuleServiceImpl moduleService = new ModuleServiceImpl();
        moduleService.setModuleLoader(moduleLoader);
        moduleService.setModuleManager(moduleManager);
        return moduleService;
    }


    /**
     * 初始化模块调度器
     *
     * @return
     */
    @Bean
    @DependsOn(value= {"moduleService"})
    public ModuleRefreshSchedulerImpl moduleRefreshSchedulerImpl(ModuleLoader moduleLoader, ModuleManager moduleManager) {
        return new ModuleRefreshSchedulerImpl(moduleLoader, moduleManager);
    }

}
