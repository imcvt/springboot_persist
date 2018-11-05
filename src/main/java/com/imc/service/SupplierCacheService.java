package com.imc.service;

import com.imc.dao.SupplierDao;
import com.imc.model.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoly
 * @date 2018/11/5 17:17
 * @description
 */
public interface SupplierCacheService {

    public List<Supplier> findByIds(List<Object> idList);

    public Supplier findById(Integer id);

}
