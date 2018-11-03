package com.imc.dao;

import com.imc.model.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author luoly
 * @date 2018/11/2 17:38
 * @description
 */

@Mapper
public interface SupplierDao {

    //如果不想写xml文件，可以直接通过@Select等注解写sql
    //如果要用xml文件，新建xml文件后配置其中的namespace建立关联，再把xml的路径配置到application.properties中可以扫描到即可
//    @Select(value = "select * from supplier")
    public List<Supplier> findAll();
}
