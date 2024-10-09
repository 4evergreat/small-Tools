package com.syh.tech.phototool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author wendao
 **/

public class PngCutting{
    public static void main(String[] args) {
        // TODO 源文件夹路径（设置成你的，建议使用绝对路径）
//        String sourceDir = "path/to/source/folder";
        String sourceDir = "path/to/source/folder";

        // TODO 目标文件夹路径（设置成你的，建议使用绝对路径）
        String targetDir = "path/to/target/folder";


        // 剪裁区域的坐标和尺寸 (x, y, width, height) TODO 设置尺寸
        int x = 10; // 剪裁起始点的x坐标
        int y = 10; // 剪裁起始点的y坐标
        int width = 310; // 剪裁宽度
        int height = 155; // 剪裁高度

        File sourceFolder = new File(sourceDir);
        File targetFolder = new File(targetDir);

        // 创建目标文件夹（如果不存在）
        if (!targetFolder.exists()) {
            targetFolder.mkdir();
        }

        // 遍历源文件夹中的每个PNG文件
        for (File file : sourceFolder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".jpg")) {
                try {
                    System.out.println("正在裁剪文件"+file.getName()+".png");
                    // 读取图片
                    BufferedImage originalImage = ImageIO.read(file);

                    // 剪裁图片
                    BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);

                    //使用UUID生成新的文件名。
//                    String shortUuidStr = UUID.randomUUID().toString()+".png";
                    //原装UUID太长，没必要
                    String shortUuidStr = UUID.randomUUID().toString().substring(1,8)+".png";

                    File outputFile = new File(targetFolder,shortUuidStr);

                    ImageIO.write(croppedImage, "png", outputFile);

                    System.out.println("成功把文件"+file.getName()+".png 裁切到了文件"+shortUuidStr);
                } catch (IOException e) {
                    System.err.println("Error processing file: " + file.getName());
                    e.printStackTrace();
                } catch (RasterFormatException e) {
                    System.err.println("Invalid crop area for file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}
