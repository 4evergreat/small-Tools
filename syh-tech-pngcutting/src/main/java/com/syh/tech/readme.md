# 使用Java实现PNG图片尺寸批量剪裁的简单算法。我们将使用javax.imageio包来读取和写入图片文件。

## 实现步骤：
遍历指定文件夹中的所有PNG图片。
读取每张图片并根据给定的剪裁区域进行剪裁。
将剪裁后的图片保存到指定目录。

## 代码说明：
路径设置：在代码中，设置sourceDir和targetDir为源图片文件夹和剪裁后图片的目标文件夹路径。
剪裁区域：设置x, y, width, height来定义剪裁区域的起始位置和大小。
图片处理：
使用ImageIO.read读取每个PNG文件。
使用getSubimage方法剪裁图片。
使用ImageIO.write保存剪裁后的图片。
## 注意事项：
确保剪裁区域在图片范围内，否则会抛出RasterFormatException。
在执行代码前，请确保已正确配置Java环境，并替换文件夹路径为实际路径。