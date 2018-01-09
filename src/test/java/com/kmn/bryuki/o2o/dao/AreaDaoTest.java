package com.kmn.bryuki.o2o.dao;

import com.kmn.bryuki.o2o.BaseTest;
import com.kmn.bryuki.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/1 19:14
 * @email: bryuki@outlook.com
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryAre() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }
}