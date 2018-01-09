package com.kmn.bryuki.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Description:
 *
 * @author: Feluna
 * @Date: 2018/1/2 21:40
 * @email: bryuki@outlook.com
 */
public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static final SimpleDateFormat SIMPLE_DATE_FOERMAT= new SimpleDateFormat("yyyyMMddHHmmss");

    private static final Random RANDOM = new Random();

    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath +
                            "watermark.png")), 0.25f)
                    .outputQuality(0.8f).toFile("new.jpg");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("图片处理失败");
        }

        return null;
    }

    /**
     * 创建目标路径所涉及的目录
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输出文件流的扩展名
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile thumbnail) {
        String orginalFileName = thumbnail.getOriginalFilename();
        return orginalFileName.substring(orginalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名
     * @return
     */
    private static String getRandomFileName() {
        int randomNum = RANDOM.nextInt(89999) + 10000;
        String nowTimeStr = SIMPLE_DATE_FOERMAT.format(new Date());
        return nowTimeStr + randomNum;
    }

    public static void main(String[] args) throws IOException {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("src/main/web/resources/image/2017061320371786788.jpg"))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath +
                "watermark.png")), 0.25f).outputQuality(0.8f).toFile("new.jpg");
    }
}