package com.gec.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gec.pojo.Province;
import com.gec.service.ProviceServiceImpl;
import com.gec.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yangxin
 * @功能描述：
 * @date 2020/12/22
 */
public class ProvinceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProvinceService provinceService = new ProviceServiceImpl();

        //调用service 获取list集合
//        List<Province> proviceList = provinceService.getProviceList();

        //将list集合 转换为json数据
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json_str = objectMapper.writeValueAsString(proviceList);

        //redis方式获取数据
        String json_str = provinceService.getgetProviceList();

        //设置编码集
        resp.setContentType("application/json;charset=utf-8");
        //将转换后的数据返回给前端
        resp.getWriter().write(json_str);
    }
}
