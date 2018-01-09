package com.kmn.bryuki.o2o.dao;

import com.kmn.bryuki.o2o.BaseTest;
import com.kmn.bryuki.o2o.entity.Area;
import com.kmn.bryuki.o2o.entity.PersonInfo;
import com.kmn.bryuki.o2o.entity.Shop;
import com.kmn.bryuki.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/2 21:13
 * @email: bryuki@outlook.com
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testupdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setShopImg("test");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }
}