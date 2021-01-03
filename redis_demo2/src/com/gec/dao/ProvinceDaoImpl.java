package com.gec.dao;

import com.gec.pojo.Province;
import com.gec.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author yangxin
 * @功能描述：
 * @date 2020/12/22
 */
public class ProvinceDaoImpl implements ProvinceDao{

    //获取数据源
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> getProviceList() {
        String sql = "select * from province";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

    }
}
