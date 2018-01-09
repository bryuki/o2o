package com.kmn.bryuki.o2o.service;

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
 * @Date: 2018/1/1 20:19
 * @email: bryuki@outlook.com
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("西苑", areaList.get(0).getAreaName());

    }
}