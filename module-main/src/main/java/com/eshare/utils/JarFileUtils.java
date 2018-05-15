package com.eshare.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;

/**
 * Jar包工具类
 *
 * @author liangyh
 * @email 10856214@163.com
 * @date 2018/5/10
 */
public class JarFileUtils {


    public static File getFile(String parentPath,String fileNamePattern) {
        File dir = new File(parentPath);
        FileFilter fileFilter = new WildcardFileFilter(fileNamePattern);
        File[] files = dir.listFiles(fileFilter);
        return files[0];
    }

    public static URL toURL(File file){
        try {
            return FileUtils.toURLs(new File[]{file})[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJarVersion(File file){
        if(file == null){
            return StringUtils.EMPTY;
        }
       return  file.getName().substring(file.getName().lastIndexOf("-"),file.getName().lastIndexOf(".jar"));
    }



}
