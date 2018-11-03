package com.imc.dao;

import com.imc.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoly
 * @date 2018/11/3 11:53
 * @description
 */

@Repository
public class Supplier2Dao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Supplier> findAll() {
        return jdbcTemplate.query("select * from supplier", BeanPropertyRowMapper.newInstance(Supplier.class));
    }
}
