package com.wyu.util;

import org.springframework.stereotype.Component;

@Component
public class GetTimeUtils {

    public static long getTime(){
        return System.currentTimeMillis();
    }
}
