package com.wyu.controller;

import com.wyu.entity.*;
import com.wyu.service.DemandService;
import com.wyu.service.FactoryService;
import com.wyu.service.InstitutionService;
import com.wyu.service.UserService;
import com.wyu.util.FileUtils;
import com.wyu.util.GetInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private FactoryService fs;
    @Autowired
    private InstitutionService is;
    @Autowired
    private DemandService ds;
    @Autowired
    private UserService us;

    String path = ResourceUtils.getURL("").getPath()+"/src/main/resources";
    public UploadController() throws FileNotFoundException { }

    @PostMapping("/f_license")
    public ReturnValue<Object> f_upload_1(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory/license";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath + "/" + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/f_pic")
    public ReturnValue<Object> f_upload_2(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory/pic";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath + "/" + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/i_license")
    public ReturnValue<Object> i_upload_1(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/license";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath + "/" + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/i_credentials")
    public ReturnValue<Object> i_upload_2(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/credentials";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath + "/" + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/i_enclosure")
    public ReturnValue<Object> i_upload_3(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/enclosure";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath + "/" + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/i_pic")
    public ReturnValue<Object> i_upload_4(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/pic";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath + "/" + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/d_enclosure")
    public ReturnValue<Object> d_upload(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/demand/enclosure";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();
        String name = filePath + "/" + fileName;
        File des = new File(name);
        try {
            file.transferTo(des);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/f_apply")
    public ReturnValue<Object> f_apply(@RequestBody Factory factory){
        User u = new User();
        u.setUser_id(GetInfoUtils.getUserId());
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/factory";
        File srcFile = new File(src);
        File srcFile1 = new File(src+"/license");
        File desFile1 = new File(des+"/license");
        File srcFile2 = new File(src+"/pic");
        File desFile2 = new File(des+"/pic");
        String[] srcFileNames1 = srcFile1.list();
        String[] srcFileNames2 = srcFile2.list();
        if (!srcFile1.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if (!srcFile2.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if (!desFile1.exists()) desFile1.mkdirs();
        if (!desFile2.exists()) desFile2.mkdirs();
        if (srcFileNames1.length<1) return new ReturnValue<Object>(-2,"文件未上传",null);
        if (srcFileNames2.length<1) return new ReturnValue<Object>(-2,"文件未上传",null);

        try {
            int i = 0;
            while(i<srcFileNames1.length) FileUtils.copyFile(src,des,srcFileNames1[i++]);
            i = 0;
            while(i<srcFileNames2.length) FileUtils.copyFile(src,des,srcFileNames2[i++]);
        }catch (FileNotFoundException e) {
            return new ReturnValue<Object>(-2,"文件未上传",null);
        }finally {
            FileUtils.deleteDir(srcFile.getParentFile());
        }
        factory.setFactory_license(des+"/license");
        factory.setFactory_pic(des+"/pic");
        u.setFactory(factory);
        try {
            fs.add(factory);
            us.update(u);
        } catch (Exception e) {
            return new ReturnValue<Object>(-1,"提交申请失败",null);
        }
        return new ReturnValue<Object>(1,"提交申请成功",null);
    }

    @PostMapping("/i_apply")
    public ReturnValue<Object> i_apply(@RequestBody Institution institution){
        User u = new User();
        u.setUser_id(GetInfoUtils.getUserId());
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/institution";
        File srcFile = new File(src);
        File srcFile1 = new File(src+"/license");
        File desFile1 = new File(des+"/license");
        File srcFile2 = new File(src+"/credentials");
        File desFile2 = new File(des+"/credentials");
        File srcFile3 = new File(src+"/enclosure");
        File desFile3 = new File(des+"/enclosure");
        File srcFile4 = new File(src+"/pic");
        File desFile4 = new File(des+"/pic");
        String[] srcFileNames1 = srcFile1.list();
        String[] srcFileNames2 = srcFile2.list();
        String[] srcFileNames3 = srcFile3.list();
        String[] srcFileNames4 = srcFile4.list();
        if(!srcFile1.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if(!srcFile2.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if(!srcFile3.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if(!srcFile4.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if(!desFile1.exists()) desFile1.mkdirs();
        if(!desFile2.exists()) desFile2.mkdirs();
        if(!desFile3.exists()) desFile3.mkdirs();
        if(!desFile4.exists()) desFile4.mkdirs();
        if (srcFileNames1.length<1) return new ReturnValue<Object>(-2,"文件未上传",null);
        if (srcFileNames2.length<1) return new ReturnValue<Object>(-2,"文件未上传",null);
        if (srcFileNames3.length<1) return new ReturnValue<Object>(-2,"文件未上传",null);
        if (srcFileNames4.length<1) return new ReturnValue<Object>(-2,"文件未上传",null);

        try {
            int i = 0;
            while(i<srcFileNames1.length) FileUtils.copyFile(src,des,srcFileNames1[i++]);
            i = 0;
            while(i<srcFileNames2.length) FileUtils.copyFile(src,des,srcFileNames2[i++]);
            i = 0;
            while(i<srcFileNames1.length) FileUtils.copyFile(src,des,srcFileNames3[i++]);
            i = 0;
            while(i<srcFileNames2.length) FileUtils.copyFile(src,des,srcFileNames4[i++]);
        }catch (FileNotFoundException e) {
            return new ReturnValue<Object>(-2,"文件未上传",null);
        }finally {
            FileUtils.deleteDir(srcFile.getParentFile());
        }
        institution.setInstitution_license(des+"/license");
        institution.setCredentials(des+"/credentials");
        institution.setEnclosure(des+"/enclosure");
        institution.setInstitution_pic(des+"/pic");

        u.setInstitution(institution);
        try {
            is.add(institution);
            us.update(u);
        } catch (Exception e) {
            return new ReturnValue<Object>(-1,"提交申请失败",null);
        }
        return new ReturnValue<Object>(1,"提交申请成功",null);
    }

    @PostMapping("/d_apply")
    public ReturnValue<Object> d_apply(@RequestBody Demand demand){

        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/demand/enclosure";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/demand/enclosure";
        File srcFile = new File(src);
        File desFile = new File(des);
        String[] srcFileNames = srcFile.list();
        if(srcFile.exists()) {
            if(!desFile.exists()) desFile.mkdirs();
            if (srcFileNames.length<1) return new ReturnValue<Object>(-2,"文件未上传",null);

            try {
                int i = 0;
                while(i<srcFileNames.length){
                    FileUtils.copyFile(src,des,srcFileNames[i++]);
                }
            }catch (FileNotFoundException e) {
                return new ReturnValue<Object>(-2,"文件未上传",null);
            }finally {
                FileUtils.deleteDir(srcFile.getParentFile().getParentFile());
            }
            demand.setEnclosure(des);
        }
        demand.setUser(GetInfoUtils.getUser1());
        System.out.println(GetInfoUtils.getUser1());
        try {
            ds.add(demand);
        } catch (Exception e) {
            return new ReturnValue<Object>(-1,"需求发布失败",null);
        }
        return new ReturnValue<Object>(1,"需求发布成功",null);
    }

}
