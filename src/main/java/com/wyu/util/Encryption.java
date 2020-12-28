package com.wyu.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

@Component
public class Encryption {

    public static String encipher(String str1,String str2){
        Object salt= ByteSource.Util.bytes(str1);
        int hashIterations = 101;
        SimpleHash simpleHash = new SimpleHash("SHA-512", str2, salt, hashIterations);
        return simpleHash.toHex();
    }
}
