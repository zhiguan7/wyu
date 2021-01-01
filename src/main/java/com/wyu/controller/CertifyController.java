package com.wyu.controller;

import com.wyu.entity.Factory;
import com.wyu.entity.Institution;
import com.wyu.entity.User;
import com.wyu.service.FactoryService;
import com.wyu.service.InstitutionService;
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
    private Factory f;
    @Autowired
    private Institution i;

    Subject subject = SecurityUtils.getSubject();
    User u = (User) subject.getPrincipal();
//    Factory f = new Factory();
//    Institution i = new Institution();

    @CrossOrigin
    @PostMapping("/f_license")
    public int f_upload_1(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return 0;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + u.getUser_id() + "_license" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            f.setFactory_license(path);
            return 1;
        } catch (IOException e) {

        }
        return 0;
    }

    @CrossOrigin
    @PostMapping("/f_pic")
    public int f_upload_2(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return 0;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + u.getUser_id() + "_pic" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            f.setFactory_pic(path);
            return 1;
        } catch (IOException e) {

        }
        return 0;
    }

    @CrossOrigin
    @PostMapping("/i_license")
    public int i_upload_1(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return 0;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + u.getUser_id() + "_license" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setInstitution_license(path);
            return 1;
        } catch (IOException e) {

        }
        return 0;
    }

    @CrossOrigin
    @PostMapping("/i_credentials")
    public int i_upload_2(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return 0;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + u.getUser_id() + "_credentials" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setCredentials(path);
            return 1;
        } catch (IOException e) {

        }
        return 0;
    }

    @CrossOrigin
    @PostMapping("/i_enclosure")
    public int i_upload_3(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return 0;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + u.getUser_id() + "_enclosure" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setEnclosure(path);
            return 1;
        } catch (IOException e) {

        }
        return 0;
    }

    @CrossOrigin
    @PostMapping("/i_pic")
    public int i_upload_4(@RequestBody MultipartFile file){
        if (file.isEmpty()) {
            return 0;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "classpath:/temporary/";
        String path = filePath + u.getUser_id() + "_pic" + suffixName;
        File dest = new File(path);
        try {
            file.transferTo(dest);
            i.setInstitution_pic(path);
            return 1;
        } catch (IOException e) {

        }
        return 0;
    }

    @CrossOrigin
    @PostMapping("/f_apply")
    public int f_apply(@RequestBody Factory factory){
        factory.setFactory_license(this.f.getFactory_license());
        factory.setFactory_pic(this.f.getFactory_pic());
        fs.add(factory);
        return 0;
    }

    @CrossOrigin
    @PostMapping("/i_apply")
    public int i_apply(@RequestBody Institution institution){
        institution.setInstitution_license(this.i.getInstitution_license());
        institution.setCredentials(this.i.getCredentials());
        institution.setEnclosure(this.i.getEnclosure());
        institution.setInstitution_pic(this.i.getInstitution_pic());
        is.add(institution);
        return 0;
    }
}
