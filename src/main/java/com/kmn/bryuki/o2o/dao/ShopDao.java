package com.kmn.bryuki.o2o.dao;

import com.kmn.bryuki.o2o.entity.Shop;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/2 20:55
 * @email: bryuki@outlook.com
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
