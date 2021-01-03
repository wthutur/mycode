package com.gec.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gec.pojo.Province;

import java.util.List;

public interface ProvinceService {
    //普通方式
//    public List<Province> getProviceList();

    //redis方式
    public String getgetProviceList() throws JsonProcessingException;
}
