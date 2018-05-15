package com.eshare.scheduler;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.eshare.utils.JarFileUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {

    private static String UPLOADED_FOLDER = "D://upload//lib//";

    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return buildModuleConfig();
    }

    public static List<ModuleConfig> buildModuleConfig() {
        List<ModuleConfig> moduleConfigs = new ArrayList<ModuleConfig>();
        moduleConfigs.add(buildAModuleConfig());
        moduleConfigs.add(buildBModuleConfig());
        moduleConfigs.removeAll(Collections.singleton(null));
        return moduleConfigs.isEmpty() ? null : moduleConfigs;
    }

    public static ModuleConfig buildAModuleConfig() {
        try {
            ModuleConfig moduleConfig = new ModuleConfig();
            File jarFile = JarFileUtils.getFile(UPLOADED_FOLDER,"workflow-module-a*.jar");
            URL demoModule = JarFileUtils.toURL(jarFile);
            String jarVersion = JarFileUtils.getJarVersion(jarFile);
            if (demoModule == null) {
                return null;
            }
            moduleConfig.setName("a");
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(jarVersion);
            moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            moduleConfig.setOverridePackages(ImmutableList.of("com.eshare.workflow.a"));
            return moduleConfig;
        } catch (Exception e) {
            log.debug("构建A模块配置异常{}",e);
        }
        return null;
    }

    public static ModuleConfig buildBModuleConfig() {
        try {
            ModuleConfig moduleConfig = new ModuleConfig();
            File jarFile = JarFileUtils.getFile(UPLOADED_FOLDER,"workflow-module-b*.jar");
            URL demoModule = JarFileUtils.toURL(jarFile);
            String jarVersion = JarFileUtils.getJarVersion(jarFile);
            if (demoModule == null) {
                return null;
            }
            moduleConfig.setName("b");
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(jarVersion);
            moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            moduleConfig.setOverridePackages(ImmutableList.of("com.eshare.workflow.b"));
            return moduleConfig;
        } catch (Exception e) {
            log.debug("构建B模块配置异常{}",e);
        }
        return null;
    }


}