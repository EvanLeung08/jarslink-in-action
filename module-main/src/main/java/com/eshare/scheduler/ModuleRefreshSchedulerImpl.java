package com.eshare.scheduler;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.eshare.lang.Const;
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

    public ModuleRefreshSchedulerImpl(ModuleLoader moduleLoader, ModuleManager moduleManager) {
        super.setModuleLoader(moduleLoader);
        super.setModuleManager(moduleManager);
    }

    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return buildModuleConfig();
    }

    private static List<ModuleConfig> buildModuleConfig() {
        List<ModuleConfig> moduleConfigs = new ArrayList<ModuleConfig>();
        moduleConfigs.add(buildWorkflowTaobaoModuleConfig());
        moduleConfigs.add(buildWorkflowTencentModuleConfig());
        moduleConfigs.add(buildCacheModuleConfig());
        moduleConfigs.removeAll(Collections.singleton(null));
        return moduleConfigs.isEmpty() ? null : moduleConfigs;
    }
    /**
     * 构建工作流taobao模块配置
     * @return
     */
    private static ModuleConfig buildWorkflowTaobaoModuleConfig() {
        try {
            ModuleConfig moduleConfig = new ModuleConfig();
            File jarFile = JarFileUtils.getSingleFile(Const.UPLOADED_FOLDER,"workflow-module-taobao*.jar");
            URL demoModule = JarFileUtils.toURL(jarFile);
            String jarVersion = JarFileUtils.getJarVersion(jarFile);
            if (demoModule == null) {
                return null;
            }
            moduleConfig.setName("workflow-module-taobao");
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(jarVersion);
            moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            moduleConfig.addScanPackage("com.eshare.workflow.taobao");
            return moduleConfig;
        } catch (Exception e) {
            log.debug("构建工作流Taobao模块配置异常{}",e);
        }
        return null;
    }

    /**
     * 构建工作流tencent模块配置
     * @return
     */
    private static ModuleConfig buildWorkflowTencentModuleConfig() {
        try {
            ModuleConfig moduleConfig = new ModuleConfig();
            File jarFile = JarFileUtils.getSingleFile(Const.UPLOADED_FOLDER,"workflow-module-tencent*.jar");
            URL demoModule = JarFileUtils.toURL(jarFile);
            String jarVersion = JarFileUtils.getJarVersion(jarFile);
            if (demoModule == null) {
                return null;
            }
            moduleConfig.setName("workflow-module-tencent");
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(jarVersion);
            moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            moduleConfig.addScanPackage("com.eshare.workflow.tencent");
            return moduleConfig;
        } catch (Exception e) {
            log.debug("构建工作流tencent模块配置异常{}",e);
        }
        return null;
    }

    /**
     * 构建缓存模块配置
     * @return
     */
    private static ModuleConfig buildCacheModuleConfig() {
        try {
            ModuleConfig moduleConfig = new ModuleConfig();
            //默认加载内存缓存模块
            File jarFile = JarFileUtils.getSingleFile(Const.UPLOADED_FOLDER,"cache-module-memory*.jar");
            URL demoModule = JarFileUtils.toURL(jarFile);
            String jarVersion = JarFileUtils.getJarVersion(jarFile);
            if (demoModule == null) {
                return null;
            }
            moduleConfig.setName("cache-module");
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(jarVersion);
            moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            moduleConfig.addScanPackage("com.eshare.cache");
            return moduleConfig;
        } catch (Exception e) {
            log.debug("构建缓存模块配置异常{}",e);
        }
        return null;
    }

    /**
     * 按构件缓存模块配置
     * @param module 模块名称
     * @param version 模块版本
     * @return
     */
    public static ModuleConfig buildCacheModuleConfig(String module,String version) {
        try {
            ModuleConfig moduleConfig = new ModuleConfig();
            File jarFile = JarFileUtils.getSingleFile(Const.UPLOADED_FOLDER,String.format("%s-%s.jar", module, version));
            URL demoModule = JarFileUtils.toURL(jarFile);
            String jarVersion = JarFileUtils.getJarVersion(jarFile);
            if (demoModule == null) {
                return null;
            }
            moduleConfig.setName("cache-module");
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(jarVersion);
            moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            moduleConfig.addScanPackage("com.eshare.cache");
            return moduleConfig;
        } catch (Exception e) {
            log.debug("构建缓存模块配置异常{}",e);
        }
        return null;
    }


}