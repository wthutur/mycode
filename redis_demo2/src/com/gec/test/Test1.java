package com.gec.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxin
 * @功能描述：集合转换成json
 * @date 2020/12/21
 */
public class Test1 {

    public static void main(String[] args) throws JsonProcessingException {

        /**
         * json格式：
         * { "name":"zhangsan",age:10,"adress":"广州"}
         */

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age",20);
        map.put("adress","广州");

        //jackson中的类ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String json_str = objectMapper.writeValueAsString(map);

        System.out.println(json_str);

    }
}
