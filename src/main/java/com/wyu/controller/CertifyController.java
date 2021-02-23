package com.wyu.controller;

import com.wyu.entity.*;
import com.wyu.service.DemandService;
import com.wyu.service.FactoryService;
import com.wyu.service.InstitutionService;
import com.wyu.service.UserService;
import com.wyu.util.GetUserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    private Factory f = new Factory();
    private Institution i = new Institution();
    private Demand d = new Demand();

    @PostMapping("/f_license")
    public ReturnValue<Object> f_upload_1(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return new ReturnValue<Object>(-1,"上传失败，空文件",null);
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + GetUserUtil.getId() + "_f_license" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            f.setFactory_license(path);
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
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + GetUserUtil.getId() + "_f_pic" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            f.setFactory_pic(path);
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
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + GetUserUtil.getId() + "_i_license" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setInstitution_license(path);
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
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + GetUserUtil.getId() + "_i_credentials" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setCredentials(path);
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
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + GetUserUtil.getId() + "_i_enclosure" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setEnclosure(path);
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
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + GetUserUtil.getId() + "_i_pic" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setInstitution_pic(path);
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
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + GetUserUtil.getId() + "_d_enclosure" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            d.setEnclosure(path);
            return new ReturnValue<Object>(1,"上传成功",null);
        } catch (IOException e) {

        }
        return null;
    }

    @PostMapping("/f_apply")
    public ReturnValue<Object> f_apply(@RequestBody Factory factory){
        User u = new User();
        u.setUser_id(GetUserUtil.getId());
        factory.setFactory_license(this.f.getFactory_license());
        factory.setFactory_pic(this.f.getFactory_pic());
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
        u.setUser_id(GetUserUtil.getId());
        institution.setInstitution_license(this.i.getInstitution_license());
        institution.setCredentials(this.i.getCredentials());
        institution.setEnclosure(this.i.getEnclosure());
        institution.setInstitution_pic(this.i.getInstitution_pic());
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
        Subject subject = SecurityUtils.getSubject();
        User u = (User) subject.getPrincipal();
        demand.setEnclosure(this.d.getEnclosure());
        demand.setUser(u);
        try {
            ds.add(demand);
        } catch (Exception e) {
            return new ReturnValue<Object>(-1,"需求发布失败",null);
        }
        return new ReturnValue<Object>(1,"需求发布成功",null);
    }

}
