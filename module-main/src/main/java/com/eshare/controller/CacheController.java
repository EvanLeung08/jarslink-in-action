package com.eshare.controller;

import com.alipay.jarslink.api.*;
import com.eshare.cache.module.api.model.ActionRequest;
import com.eshare.scheduler.ModuleRefreshSchedulerImpl;
import com.eshare.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 缓存控制器
 * Created by liangyh on 2018/5/19.
 * Email:10856214@163.com
 */
@RequestMapping("/cache")
@Controller
public class CacheController {

    private static String UPLOADED_FOLDER = "D://upload//lib//";

    @Resource(name = "moduleManager")
    private ModuleManager moduleManager;
    @Resource(name = "moduleService")
    private ModuleService moduleService;
    @Autowired
    private FileService fileService;


    @GetMapping("/index")
    public String index() {
        return "cache_index";
    }

    @GetMapping("/manage")
    public String manage() throws IOException {
        return "cache_manage";
    }

    @GetMapping("/reload")
    public String reload() throws IOException {
        return "cache_reload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "请选择一个模块进行上传");
            return "redirect:/cache/index";
        }
        //上传文件
        fileService.uploadFile(file, redirectAttributes);
        return "redirect:/cache/index";
    }


    @PostMapping(value = "/set")
    public String set(@RequestParam("key") String key, @RequestParam("val") String val, RedirectAttributes redirectAttributes) {
        // 查找服务
        Module findModule = moduleManager.find("cache-module");
        // 得到具体模块
        Action<ActionRequest, String> action = findModule.getAction("cache");
        ActionRequest req = new ActionRequest();
        req.setOperation(ActionRequest.OPERATION.SAVE.getIndex());
        req.setKey(key);
        req.setValue(val);
        // 执行Action，数据交互
        redirectAttributes.addFlashAttribute("message",
                "成功执行: '" + action.execute(req) + "'");
        return "redirect:/cache/manage";
    }

    @PostMapping(value = "/get")
    public String get(@RequestParam("key") String key, RedirectAttributes redirectAttributes) {
        Module findModule = moduleManager.find("cache-module");
        Action<ActionRequest, String> action = findModule.getAction("cache");
        ActionRequest req = new ActionRequest();
        req.setOperation(ActionRequest.OPERATION.GET.getIndex());
        req.setKey(key);
        // 执行Action，数据交互
        redirectAttributes.addFlashAttribute("message",
                "查询结果为: '" + action.execute(req) + "'");
        return "redirect:/cache/manage";
    }

    @PostMapping(value = "/reloadModule")
    public String reloadModule(@RequestParam("module") String module, @RequestParam("version") String version, RedirectAttributes redirectAttributes) {
        ModuleConfig moduleConfig = ModuleRefreshSchedulerImpl.buildCacheModuleConfig(module, version);
        moduleConfig.setEnabled(true);
        moduleService.loadAndRegister(moduleConfig);
        redirectAttributes.addFlashAttribute("message",
                String.format("切换缓存模块成功!执行缓存模块为:{%s},版本为:{%s}", module, version));
        return "redirect:/cache/reload";
    }
}
