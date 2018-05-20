package com.eshare.controller;

import com.eshare.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 工作流控制器
 *
 * @author liangyh
 * @email 10856214@163.com
 * @date 2018/5/10
 */
@RequestMapping("/workflow")
@Controller
public class WorkflowController {

    @Autowired
    private FileService fileService;

    @GetMapping("/index")
    public String index() {
        return "workflow_index";
    }

    @GetMapping("/calendar")
    public String calendar() throws IOException {
        return "forward:/uflo/calendar";
    }

    @GetMapping("/central")
    public String central() {
        return "forward:/uflo/central";
    }

    @GetMapping("/designer")
    public String designer() {
        return "forward:/uflo/designer";
    }

    @GetMapping("/diagram")
    public String diagram() {
        return "forward:/uflo/diagram";
    }

    @GetMapping("/todo")
    public String todo() {
        return "forward:/uflo/todo";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select taobao file to upload");
            return "redirect:/workflow/uploadStatus";
        }
        //上传文件
        fileService.uploadFile(file, redirectAttributes);

        return "redirect:/workflow/index";
    }


    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "forward:/index";
    }
}
