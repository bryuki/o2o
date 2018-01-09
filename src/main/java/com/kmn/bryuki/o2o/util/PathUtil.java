package com.kmn.bryuki.o2o.util;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/2 21:54
 * @email: bryuki@outlook.com
 */
public class PathUtil {

    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "e:/images/";
        } else {
            basePath = "/home/bryuki/image/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}