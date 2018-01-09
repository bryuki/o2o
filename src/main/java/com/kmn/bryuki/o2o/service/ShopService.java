package com.kmn.bryuki.o2o.service;

import com.kmn.bryuki.o2o.dto.ShopExecution;
import com.kmn.bryuki.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/5 21:47
 * @email: bryuki@outlook.com
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws  RuntimeException;
}
