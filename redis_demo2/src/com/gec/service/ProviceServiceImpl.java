package com.gec.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gec.dao.ProvinceDao;
import com.gec.dao.ProvinceDaoImpl;
import com.gec.pojo.Province;
import com.gec.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author yangxin
 * @功能描述：
 * @date 2020/12/22
 */
public class ProviceServiceImpl implements ProvinceService {

    private ProvinceDao provinceDao = new ProvinceDaoImpl();

    //普通方式
//    @Override
//    public List<Province> getProviceList() {
//        return provinceDao.getProviceList();
//    }
    
    //redis方式
    @Override
    public String getgetProviceList() throws JsonProcessingException {

        //集成redis
        //获取redis
        Jedis jedis = JedisPoolUtils.getJedis();

        //通过key值"province"查询value值
        String pro = jedis.get("province");

        if (pro==null||pro.length()==0){
            System.out.println("redis中没有数据，查询数据库。。。");
            //如果jedis没有数据，则是第一次查询数据
            //从数据库中查询
            List<Province> proviceList = provinceDao.getProviceList();

            //将list转换成json
            ObjectMapper objectMapper = new ObjectMapper();
            //将转换成json的数据存入redis
            pro = objectMapper.writeValueAsString(proviceList);
            jedis.set("province", pro);

        }else {
            //redis已经有数据
            System.out.println("redis中有数据，从redis缓存中获取数据。。。");
        }
        return pro;
    }
    
    
}
