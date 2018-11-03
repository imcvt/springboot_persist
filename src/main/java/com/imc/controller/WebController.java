package com.imc.controller;

import com.imc.dao.Supplier2Dao;
import com.imc.dao.Supplier3Dao;
import com.imc.dao.SupplierDao;
import com.imc.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoly
 * @date 2018/11/2 11:29
 * @description
 */

@RestController
@RequestMapping("/persist")
public class WebController {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierDao supplierDao;

    @Autowired
    Supplier2Dao supplier2Dao;

    @Autowired
    Supplier3Dao supplier3Dao;

    @GetMapping("/jpa")
    private Object list() {
        return supplierRepository.findAll();
    }

    @GetMapping("/mybatis")
    private Object listWithMybatis() {
        return supplierDao.findAll();
    }

    @GetMapping("/jdbcTemplate")
    private Object listWithJdbcTemplate() {
        return supplier2Dao.findAll();
    }

    @GetMapping("/dbutils")
    private Object listWithDBUtils() {
        return supplier3Dao.findAll();
    }
}
