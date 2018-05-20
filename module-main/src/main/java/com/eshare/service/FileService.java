package com.eshare.service;

import com.eshare.lang.Const;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件服务类
 * Created by liangyh on 2018/5/20.
 * Email:10856214@163.com
 */
@Service
public class FileService {


    public void uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            //获取当前类加载器上下文真实路径
            Path path = Paths.get(Const.UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
