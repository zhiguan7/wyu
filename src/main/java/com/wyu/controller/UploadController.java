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
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        if (FileUtils.uploadTempFile(file,"/factory/license")) return new ReturnValue<>(1,"上传成功",null);
        else return new ReturnValue<>(1,"上传失败",null);
    }

    @PostMapping("/f_pic")
    public ReturnValue<Object> f_upload_2(@RequestBody MultipartFile file){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        if (FileUtils.uploadTempFile(file,"/factory/pic")) return new ReturnValue<>(1,"上传成功",null);
        else return new ReturnValue<>(1,"上传失败",null);
    }

    @PostMapping("/i_license")
    public ReturnValue<Object> i_upload_1(@RequestBody MultipartFile file){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        if (FileUtils.uploadTempFile(file,"/institution/license")) return new ReturnValue<>(1,"上传成功",null);
        else return new ReturnValue<>(1,"上传失败",null);
    }

    @PostMapping("/i_credentials")
    public ReturnValue<Object> i_upload_2(@RequestBody MultipartFile file){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        if (FileUtils.uploadTempFile(file,"/institution/credentials")) return new ReturnValue<>(1,"上传成功",null);
        else return new ReturnValue<>(1,"上传失败",null);
    }

    @PostMapping("/i_enclosure")
    public ReturnValue<Object> i_upload_3(@RequestBody MultipartFile file){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        if (FileUtils.uploadTempFile(file,"/institution/enclosure")) return new ReturnValue<>(1,"上传成功",null);
        else return new ReturnValue<>(1,"上传失败",null);
    }

    @PostMapping("/i_pic")
    public ReturnValue<Object> i_upload_4(@RequestBody MultipartFile file){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        if (FileUtils.uploadTempFile(file,"/institution/pic")) return new ReturnValue<>(1,"上传成功",null);
        else return new ReturnValue<>(1,"上传失败",null);
    }

    @PostMapping("/d_enclosure")
    public ReturnValue<Object> d_upload(@RequestBody MultipartFile file){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        if (FileUtils.uploadTempFile(file,"/demand/enclosure")) return new ReturnValue<>(1,"上传成功",null);
        else return new ReturnValue<>(1,"上传失败",null);
    }

    @PostMapping("/f_apply")
    public ReturnValue<Object> f_apply(@RequestBody Factory factory) throws IOException {
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        User u = new User();
        u.setUser_id(GetInfoUtils.getUserId());
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/factory";
        if (new File(src).exists()) {
            if (!FileUtils.tempToData("factory")) return new ReturnValue<Object>(-1, "申请失败", null);
            else {
                factory.setFactory_license(des+"/license");
                factory.setFactory_pic(des+"/pic");
            }
        }
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
    public ReturnValue<Object> i_apply(@RequestBody Institution institution) throws IOException {
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        User u = new User();
        u.setUser_id(GetInfoUtils.getUserId());
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/institution";
        if (new File(src).exists()) {
            if (!FileUtils.tempToData("institution")) return new ReturnValue<Object>(-1, "申请失败", null);
            else {
                institution.setInstitution_license(des + "/license");
                institution.setCredentials(des + "/credentials");
                institution.setEnclosure(des + "/enclosure");
                institution.setInstitution_pic(des + "/pic");
            }
        }
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
    public ReturnValue<Object> d_apply(@RequestBody Demand demand) throws IOException {

        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String src = path + "/temporary/" + GetInfoUtils.getUserId() + "/demand";
        String des = path + "/data/" + GetInfoUtils.getUserId() + "/demand";
        if (new File(src).exists()) {
            if (!FileUtils.tempToData("demand")) return new ReturnValue<Object>(-1, "需求发布失败", null);
            else {
                demand.setEnclosure(des + "/enclosure");
            }
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
