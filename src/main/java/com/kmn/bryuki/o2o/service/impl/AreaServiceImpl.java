package com.kmn.bryuki.o2o.service.impl;

import com.kmn.bryuki.o2o.dao.AreaDao;
import com.kmn.bryuki.o2o.entity.Area;
import com.kmn.bryuki.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/1 20:16
 * @email: bryuki@outlook.com
 */

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}