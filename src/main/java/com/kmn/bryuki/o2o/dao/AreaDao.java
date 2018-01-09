package com.kmn.bryuki.o2o.dao;

import com.kmn.bryuki.o2o.entity.Area;

import java.util.List;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/1 19:03
 * @email: bryuki@outlook.com
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
