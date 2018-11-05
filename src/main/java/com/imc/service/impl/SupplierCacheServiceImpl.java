package com.imc.service.impl;

import com.imc.dao.SupplierDao;
import com.imc.model.Supplier;
import com.imc.service.SupplierCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoly
 * @date 2018/11/5 18:01
 * @description
 */

@Service
@Slf4j
public class SupplierCacheServiceImpl implements SupplierCacheService{

    private static final String DEMO_CACHE_NAME = "suppliers";

    @Autowired
    private SupplierDao supplierDao;

    public List<Supplier> findByIds(List<Object> idList) {
        return this.supplierDao.findByIds(idList);
    }

    @Cacheable(value = DEMO_CACHE_NAME,key = "#id")
    @Override
    public Supplier findById(Integer id) {
        log.info("SupplierService.findById query from DB;id---->"+id);
        return this.supplierDao.findById(id);
    }
}
