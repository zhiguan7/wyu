package com.wyu.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CodeUtils {

    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
       int i= 6;
       while(0<i--){
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

}
