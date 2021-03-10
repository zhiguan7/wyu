package com.wyu.controller;

import com.wyu.entity.ReturnValue;
import com.wyu.util.FileUtils;
import com.wyu.util.GetInfoUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

@RestController
@RequestMapping("/delete")
public class FileDeleteController {

    String path = ResourceUtils.getURL("").getPath()+"/src/main/resources";
    public FileDeleteController() throws FileNotFoundException { }

    @PostMapping("/d_enclosure")
    public ReturnValue<Object> fileDelete1(@RequestBody Map<String,String> map){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String des1 = path + "/temporary/" + GetInfoUtils.getUserId() + "/demand/enclosure/" + map.get("fileName");
        String des2 = path + "/data/" + GetInfoUtils.getUserId() + "/demand/enclosure/" + map.get("fileName");
        File f1 = new File(des1);
        File f2 = new File(des2);
        if(f1.exists()){
            try {
                FileUtils.deleteDir(f1);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        if(f2.exists()){
            try {
                FileUtils.deleteDir(f2);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        return new ReturnValue<Object>(1,"删除成功",null);
    }

    @PostMapping("/f_license")
    public ReturnValue<Object> fileDelete2(@RequestBody Map<String,String> map){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String des1 = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory/license/" + map.get("fileName");
        String des2 = path + "/data/" + GetInfoUtils.getUserId() + "/factory/license/" + map.get("fileName");
        File f1 = new File(des1);
        File f2 = new File(des2);
        if(f1.exists()){
            try {
                FileUtils.deleteDir(f1);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        if(f2.exists()){
            try {
                FileUtils.deleteDir(f2);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        return new ReturnValue<Object>(1,"删除成功",null);
    }

    @PostMapping("/f_pic")
    public ReturnValue<Object> fileDelete3(@RequestBody Map<String,String> map){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String des1 = path + "/temporary/" + GetInfoUtils.getUserId() + "/factory/pic/" + map.get("fileName");
        String des2 = path + "/data/" + GetInfoUtils.getUserId() + "/factory/pic/" + map.get("fileName");
        File f1 = new File(des1);
        File f2 = new File(des2);
        if(f1.exists()){
            try {
                FileUtils.deleteDir(f1);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        if(f2.exists()){
            try {
                FileUtils.deleteDir(f2);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        return new ReturnValue<Object>(1,"删除成功",null);
    }

    @PostMapping("/i_license")
    public ReturnValue<Object> fileDelete4(@RequestBody Map<String,String> map){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String des1 = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/license/" + map.get("fileName");
        String des2 = path + "/data/" + GetInfoUtils.getUserId() + "/institution/license/" + map.get("fileName");
        File f1 = new File(des1);
        File f2 = new File(des2);
        if(f1.exists()){
            try {
                FileUtils.deleteDir(f1);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        if(f2.exists()){
            try {
                FileUtils.deleteDir(f2);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        return new ReturnValue<Object>(1,"删除成功",null);
    }

    @PostMapping("/i_credentials")
    public ReturnValue<Object> fileDelete5(@RequestBody Map<String,String> map){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String des1 = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/credentials/" + map.get("fileName");
        String des2 = path + "/data/" + GetInfoUtils.getUserId() + "/institution/credentials/" + map.get("fileName");
        File f1 = new File(des1);
        File f2 = new File(des2);
        if(f1.exists()){
            try {
                FileUtils.deleteDir(f1);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        if(f2.exists()){
            try {
                FileUtils.deleteDir(f2);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        return new ReturnValue<Object>(1,"删除成功",null);
    }

    @PostMapping("/i_enclosure")
    public ReturnValue<Object> fileDelete6(@RequestBody Map<String,String> map){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String des1 = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/enclosure/" + map.get("fileName");
        String des2 = path + "/data/" + GetInfoUtils.getUserId() + "/institution/enclosure/" + map.get("fileName");
        File f1 = new File(des1);
        File f2 = new File(des2);
        if(f1.exists()){
            try {
                FileUtils.deleteDir(f1);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        if(f2.exists()){
            try {
                FileUtils.deleteDir(f2);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        return new ReturnValue<Object>(1,"删除成功",null);
    }

    @PostMapping("/i_pic")
    public ReturnValue<Object> fileDelete7(@RequestBody Map<String,String> map){
        if(null==GetInfoUtils.getUser1()) return new ReturnValue<Object>(-3,"未登陆",null);
        String des1 = path + "/temporary/" + GetInfoUtils.getUserId() + "/institution/pic/" + map.get("fileName");
        String des2 = path + "/data/" + GetInfoUtils.getUserId() + "/institution/pic/" + map.get("fileName");
        File f1 = new File(des1);
        File f2 = new File(des2);
        if(f1.exists()){
            try {
                FileUtils.deleteDir(f1);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        if(f2.exists()){
            try {
                FileUtils.deleteDir(f2);
            } catch (Exception e) {
                return new ReturnValue<Object>(-1,"删除失败",null);
            }
        }
        return new ReturnValue<Object>(1,"删除成功",null);
    }

}
