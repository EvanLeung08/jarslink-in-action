package com.eshare.scheduler;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {

    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return ImmutableList.of(buildKnModuleConfig(),buildWpsModuleConfig());
    }

    public static ModuleConfig buildKnModuleConfig() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("lib/kn-module-demo-0.0.1.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("kn");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0.0.20180402");
        moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        moduleConfig.setOverridePackages(ImmutableList.of("com.eshare.kn"));
        return moduleConfig;
    }

    public static ModuleConfig buildWpsModuleConfig() {URL demoModule = Thread.currentThread().getContextClassLoader().getResource("lib/wps-module-demo-0.0.1.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("wps");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0.0.20180505");
        moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        moduleConfig.setOverridePackages(ImmutableList.of("com.eshare.wps"));
        return moduleConfig;
    }


}