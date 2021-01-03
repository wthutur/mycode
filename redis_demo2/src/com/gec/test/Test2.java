package com.gec.test;

import com.gec.pojo.Province;
import com.gec.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author yangxin
 * @功能描述：使用JdbcTemplate操作数据库(由spring封装jdbc的对象)
 * @date 2020/12/21
 */
public class Test2 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

        //
        String sql = "select * from province";
        List<Province> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        if(list!=null){
            for (Province province : list) {
                System.out.println(province);

            }
        }
    }
}
