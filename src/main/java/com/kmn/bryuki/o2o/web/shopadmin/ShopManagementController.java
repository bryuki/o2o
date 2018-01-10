package com.kmn.bryuki.o2o.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.kmn.bryuki.o2o.dto.ShopExecution;
import com.kmn.bryuki.o2o.entity.PersonInfo;
import com.kmn.bryuki.o2o.entity.Shop;
import com.kmn.bryuki.o2o.enums.ShopStateEnum;
import com.kmn.bryuki.o2o.service.ShopService;
import com.kmn.bryuki.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/6 21:12
 * @email: bryuki@outlook.com
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {

    @Autowired
    private ShopService shopService;


    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        // 1.接收并转化相应的参数, 包括店铺信息以及图片信息
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
       try {
           shop = mapper.readValue(shopStr, Shop.class);
       } catch (Exception e) {
           modelMap.put("success", false);
           modelMap.put("errMsg", e.getMessage());
           return modelMap;
       }
       CommonsMultipartFile shopImg = null;
       CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
               request.getSession().getServletContext());
       if (commonsMultipartResolver.isMultipart(request)) {
           MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
           shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
       } else {
           modelMap.put("success", false);
           modelMap.put("errmsg", "上传图片不能为空");
           return modelMap;
       }

        // 2.注册店铺
        if (shop != null && shopImg != null) {
           PersonInfo owner = new PersonInfo();
           owner.setUserId(1L);
           shop.setOwner(owner);
            ShopExecution se = shopService.addShop(shop, shopImg);
            if (se.getState() == ShopStateEnum.CHECK.getState()) {
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", se.getStateInfo());
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "请输入店铺信息");
            return modelMap;
        }
        // 3.返回结果
    }

    private static void inputStreamToFile(InputStream in, File file) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch(Exception e) {
            throw new RuntimeException("调用inputStreamToFile产生异常:" + e.getMessage());

        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch(IOException e) {
                throw new RuntimeException("inputStreamToFile关闭io产生异常:" + e.getMessage());
            }
        }
    }
}