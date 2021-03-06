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
public class CertifyController {

    @Autowired
    private FactoryService fs;
    @Autowired
    private InstitutionService is;
    @Autowired
    private DemandService ds;
    @Autowired
    private UserService us;

    String path = ResourceUtils.getURL("").getPath()+"/src/main/resources";
    public CertifyController() throws FileNotFoundException { }

    @PostMapping("/f_license")
    public ReturnValue<Object> f_upload_1(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath  + "/1_license" + suffixName;
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath + "/2_pic" + suffixName;
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath  + "1_license" + suffixName;
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath  + "2_credentials" + suffixName;
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath  + "3_enclosure" + suffixName;
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath  + "4_pic" + suffixName;
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = path + "/temporary/" + GetInfoUtils.getUserId() + "/demand";
        File src = new File(filePath);
        if(!src.exists()) src.mkdirs();

        String name = filePath  + "1_enclosure" + suffixName;
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/factory";
        File srcFile = new File(src);
        File desFile = new File(des);
        String[] srcFileNames = srcFile.list();
        if (!srcFile.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if (!desFile.exists()) desFile.mkdirs();
        if (srcFileNames.length!=2) return new ReturnValue<Object>(-2,"文件未上传",null);

        try {
            FileUtils.copyFile(src,des,srcFileNames[0]);
            FileUtils.copyFile(src,des,srcFileNames[1]);
        }catch (FileNotFoundException e) {
            return new ReturnValue<Object>(-2,"文件未上传",null);
        }finally {
            FileUtils.deleteDir(srcFile);
        }
        factory.setFactory_license(des+"/"+srcFileNames[0]);
        factory.setFactory_pic(des+"/"+srcFileNames[1]);
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
        if(!GetInfoUtils.getUser()) return new ReturnValue<Object>(-3,"未登陆",null);
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/institution";
        File srcFile = new File(src);
        File desFile = new File(des);
        String[] srcFileNames = srcFile.list();
        if(!srcFile.exists()) return new ReturnValue<Object>(-2,"文件未上传",null);
        if(!desFile.exists()) desFile.mkdirs();
        if (srcFileNames.length!=4) return new ReturnValue<Object>(-2,"文件未上传",null);

        try {
            FileUtils.copyFile(src,des,srcFileNames[0]);
            FileUtils.copyFile(src,des,srcFileNames[1]);
            FileUtils.copyFile(src,des,srcFileNames[3]);
            FileUtils.copyFile(src,des,srcFileNames[4]);
        }catch (FileNotFoundException e) {
            return new ReturnValue<Object>(-2,"文件未上传",null);
        }finally {
            FileUtils.deleteDir(srcFile);
        }
        institution.setInstitution_license(des+"/"+srcFileNames[0]);
        institution.setCredentials(des+"/"+srcFileNames[1]);
        institution.setEnclosure(des+"/"+srcFileNames[2]);
        institution.setInstitution_pic(des+"/"+srcFileNames[3]);

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

        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/demand";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/demand";
        File srcFile = new File(src);
        File desFile = new File(des);
        String[] srcFileNames = srcFile.list();
        if(srcFile.exists()) {
            if(!desFile.exists()) desFile.mkdirs();
            if (srcFileNames.length!=1) return new ReturnValue<Object>(-2,"文件未上传",null);

            try {
                FileUtils.copyFile(src,des,srcFileNames[0]);
            }catch (FileNotFoundException e) {
                return new ReturnValue<Object>(-2,"文件未上传",null);
            }finally {
                FileUtils.deleteDir(srcFile);
            }

            demand.setEnclosure(des+"/"+srcFileNames[0]);
        }
        demand.setUser(GetInfoUtils.getUser1());
        try {
            ds.add(demand);
        } catch (Exception e) {
            return new ReturnValue<Object>(-1,"需求发布失败",null);
        }
        return new ReturnValue<Object>(1,"需求发布成功",null);
    }

}
