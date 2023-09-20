package cn.zky;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @Author ZhangKaiYuan
 * @Date 2023/9/20 14:23
 *
 * 写一个验证码程序
 */
public class ImageCode {

    //验证码数据库，用数组保存
    static String[] strs = {"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
            "i" , "j" , "k" , "m" , "n"  , "p" , "q" , "r" , "s",
            "t" , "u" , "v" , "w" , "x" , "y" , "z" , "2" , "3",
            "4" , "5" , "6" , "7" , "8" , "9"};

    public static void main(String[] args) throws Exception {
        //大的需求：通过Java代码生成一张图片（图片上含有字母，数字或者干扰线）

        //例如：画画一样
        /**
         * 1、画板，纸
         * 2、准备画笔
         * 3、准备数据(strs)，从数组中随机获取4个
         * 4、通过画笔把获取到数据画到画板上
         * 5、生成一张真正的图片
         */

        //定义图片的高宽
        int w = 150;
        int h = 50;
        //图片的类型
        int imageType = BufferedImage.TYPE_INT_RGB;
        //int imageType = 1

        //画板，纸  JDK中提供了画板类  ctrl + p 快捷键查看方法参数
        BufferedImage image = new BufferedImage(w,h,imageType);

        //大的需求：把图片的颜色修改一下  默认颜色时黑色的
        //先获取画笔对象
        Graphics g = image.getGraphics();
        //画笔设置颜色
        g.setColor(Color.yellow);
        //填充矩形
        g.fillRect(0,0,w,h);

        //Random类可以取随机数
        Random random = new Random();
        //定义字符串放在图片上的坐标
        int x = 35;
        int y = 30;
        g.setColor(Color.cyan);
        //设置字体
        g.setFont(new Font("宋体",Font.PLAIN,30));
        //3、准备数据(strs)，从数组中随机获取4个
        //编写for循环，循环4次  fori 快捷键
        for (int i = 0; i < 4; i++) {
            //定义一个num随机生成
            int num = random.nextInt(strs.length);  //小于str.length的数字随机取
            //每循环一次取一个
            String str = strs[num];
            //每获取一个字符串，画上去
            g.drawString(str,x + i*30 , y);
        }
        //g.setColor(Color.RED);
        //干扰线颜色随机
        int r = random.nextInt(255);
        int g1 = random.nextInt(255);
        int b = random.nextInt(255);
        g.setColor(new Color(r,g1,b));
        //随机画干扰线
        for (int i = 0; i < random.nextInt(10); i++) {
            int x1 = random.nextInt(30);
            int y1 = random.nextInt(50);

            int x2 = random.nextInt(30) + 120;
            int y2 = random.nextInt(50);
            g.drawLine(x1,y1,x2,y2);
        }

        //5、把image生成到本地的磁盘上
        ImageIO.write(image,"jpg",new File("D:\\java\\Java-Study(2023)\\验证码\\验证码.jpg"));

    }

}
