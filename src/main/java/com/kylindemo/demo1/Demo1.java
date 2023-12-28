package com.kylindemo.demo1;

import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @auth kylin
 * @date 2023/12/26 17:17
 */
public class Demo1 {


    public static void createToken(){
        //自定义传输数据
        Map<String,Object> map = new HashMap<>();
        map.put("uid", Integer.parseInt("123"));
        map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);//15天过期

        //生成密钥
        String token = JWTUtil.createToken(map, "服务器密钥".getBytes());
        System.out.println(token);

        //验证密钥
        boolean verify = JWTUtil.verify(token, "服务器密钥".getBytes());
        System.out.println(verify);

        //解析密钥
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        JSONObject claimsJson = payload.getClaimsJson();
        System.out.println(claimsJson.toString());


    }

    public static void main(String[] args) {
        createToken();
    }
}
