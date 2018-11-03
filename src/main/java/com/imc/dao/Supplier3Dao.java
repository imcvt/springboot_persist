package com.imc.dao;

import com.imc.model.Supplier;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author luoly
 * @date 2018/11/3 12:05
 * @description
 */
@Repository
public class Supplier3Dao {

    @Autowired
    private QueryRunner queryRunner;

    public List<Supplier> findAll() {
        List<Supplier> list = null;
        try {
            list = this.queryRunner.query("select * from supplier",new BeanListHandler<>(Supplier.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
