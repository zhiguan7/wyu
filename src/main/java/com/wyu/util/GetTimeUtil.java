package com.wyu.util;

import org.springframework.stereotype.Component;

@Component
public class GetTimeUtil {

    public static long getTime(){
        return System.currentTimeMillis();
    }
}
