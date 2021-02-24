package com.wyu.util;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.channels.FileChannel;

@Component
public class FileUtil {

    @SneakyThrows
    public static void copyFile(String src, String des,String filename) throws FileNotFoundException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(src+"/"+filename).getChannel();
            outputChannel = new FileOutputStream(des+"/"+filename).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputChannel.close();
                outputChannel.close();
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
