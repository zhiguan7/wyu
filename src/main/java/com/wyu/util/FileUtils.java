package com.wyu.util;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class FileUtils{

    private static String path;
    private static String separator = java.io.File.separator;
    static {
        try {
            path = ResourceUtils.getURL("").getPath() +"src" + separator + "main" + separator + "resources";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean copyDir(String src, String des){
        File file = new File(src);
        String[] filePath = file.list();
        CountDownLatch countDownLatch = new CountDownLatch(filePath.length);
        ExecutorService service = Executors.newCachedThreadPool();
        if (!(new File(des)).exists()) {
            (new File(des)).mkdirs();
        }
        try {
            for (int i = 0; i < filePath.length; i++) {
                if ((new File(src + separator + filePath[i])).isDirectory()) {
                    copyDir(src  + separator  + filePath[i], des  + separator + filePath[i]);
                }
                if (new File(src  + separator + filePath[i]).isFile()) {
                    service.execute(new FileCopy(src + separator + filePath[i], des + separator + filePath[i]));
                }
                countDownLatch.countDown();
            }
            countDownLatch.await();
        } catch (Exception e) {
            return false;
        }finally {
            service.shutdown();
        }
        return true;
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

    public static boolean uploadTempFile(MultipartFile file,String where){
        if (file.isEmpty()) {
            return false;
        }
        if(null==GetInfoUtils.getUser1()) return false;
        String fileName = file.getOriginalFilename();
        String filePath = path + separator +"temporary" + separator + GetInfoUtils.getUserId() + where;
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();
        String name = filePath + separator + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean tempToData(String type) throws IOException {

        String src = path + separator +"temporary" + separator + GetInfoUtils.getUserId() + separator + type;
        String des = path + separator + "data" + separator + GetInfoUtils.getUserId() + separator + type;
        File srcFile = new File(src);
        if(copyDir(src,des)) {
            deleteDir(srcFile);
            return true;
        }
        return false;
    }
}

class FileCopy implements Runnable{

    private String src;
    private String des;
    public FileCopy(String src,String des){
        this.src = src;
        this.des = des;
    }

    @Override
    public void run() {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(src).getChannel();
            outputChannel = new FileOutputStream(des).getChannel();
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
}
