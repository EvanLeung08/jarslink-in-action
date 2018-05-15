package com.eshare.controller;

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

    private static String UPLOADED_FOLDER = "D://upload//lib//";

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
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/workflow/uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            //获取当前类加载器上下文真实路径
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/workflow/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "forward:/index";
    }
}
