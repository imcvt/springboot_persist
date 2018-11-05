package com.imc.controller;

import com.imc.dao.Supplier2Dao;
import com.imc.dao.Supplier3Dao;
import com.imc.dao.Supplier4Dao;
import com.imc.dao.SupplierDao;
import com.imc.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author luoly
 * @date 2018/11/2 11:29
 * @description  这里简单描述一下连接池与持久层框架的区别，连接池是简化了我们的程序连接数据库操作，而持久层框架更多的关注将编程语言映射成sql结构化语言，
 *              两者协同操作，并且后者依赖于前者
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

    @Autowired
    Supplier4Dao supplier4Dao;

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

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

    @GetMapping("/jooq")
    private Object listWithJooq() {
        return supplier4Dao.findAll();
    }

    @GetMapping("/logback")
    private String logback(@RequestParam String name) {
        logger.info("logtest->" + name);
        return name + new Date();
    }
}
