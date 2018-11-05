package com.imc.dao;

import com.imc.model.Supplier;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoly
 * @date 2018/11/5 09:44
 * @description
 */

@Repository
public class Supplier4Dao {

    @Autowired
    private DSLContext dslContext;
    public List<Supplier> findAll() {
        List<Supplier> list = this.dslContext.select()
                .from("supplier")
                .fetch()
                .map(record -> record.into(Supplier.class));
        return list;
    }
}
