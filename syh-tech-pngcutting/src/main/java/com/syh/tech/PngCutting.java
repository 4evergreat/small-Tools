package com.syh.tech;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;

/**
 * @author wendao
 **/

public class PngCutting{
    public static void main(String[] args) {
        // 源文件夹路径
//        String sourceDir = "path/to/source/folder";
        String sourceDir = "path/to/source/folder";
        // 目标文件夹路径
//        String targetDir = "path/to/target/folder";
        String targetDir = "path/to/target/folder";
        // 剪裁区域的坐标和尺寸 (x, y, width, height)
        int x = 50; // 剪裁起始点的x坐标
        int y = 50; // 剪裁起始点的y坐标
        int width = 200; // 剪裁宽度
        int height = 200; // 剪裁高度

        File sourceFolder = new File(sourceDir);
        File targetFolder = new File(targetDir);

        // 创建目标文件夹（如果不存在）
        if (!targetFolder.exists()) {
            targetFolder.mkdir();
        }

        // 遍历源文件夹中的每个PNG文件
        for (File file : sourceFolder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".png")) {
                try {
                    // 读取图片
                    BufferedImage originalImage = ImageIO.read(file);

                    // 剪裁图片
                    BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);

                    // 保存剪裁后的图片
                    File outputFile = new File(targetFolder, file.getName());
                    ImageIO.write(croppedImage, "png", outputFile);
                    System.out.println("Cropped image saved to: " + outputFile.getAbsolutePath());
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
