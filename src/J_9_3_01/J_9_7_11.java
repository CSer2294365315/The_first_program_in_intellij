package J_9_3_01;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;


public class J_9_7_11
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            ButtonFrame frame=new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        /**
         * 为屏幕连接一个机器人
         */
        GraphicsEnvironment environment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();

        try
        {
            final Robot robot=new Robot(screen);
            root.waitForIdle();
        }



    }




}

class ButtonFrame  extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;






    public ButtonFrame_2()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        buttonPanel=new JPanel();
        add(buttonPanel);

        JButton yellowButton=new JButton("yellow");
        JButton blueButton=new JButton("blue");
        JButton redButton=new JButton("red");
        JButton what=new JButton("what");

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(what);

        what.addActionListener(event->{
            buttonPanel.setBackground(Color.PINK);
        });

        ColorAction y=new ColorAction(Color.YELLOW);
        ColorAction b=new ColorAction(Color.blue);
        ColorAction r=new ColorAction(Color.RED);


        yellowButton.addActionListener(y);
        blueButton.addActionListener(b);
        redButton.addActionListener(r);

        System.out.println("......."+redButton.getActionCommand());


        makeButton("1",Color.GREEN);
        makeButton("2",Color.CYAN);



    }

    /**
     * 辅助方法
     */
    public void makeButton(String n,Color c)
    {
        JButton simpleButton=new JButton(n);
        buttonPanel.add(simpleButton);
        simpleButton.addActionListener(event->
        {
            buttonPanel.setBackground(c);

        });

    }

    private class ColorAction implements ActionListener
    {
        private Color col;

        public ColorAction(Color c)
        {
            col=c;
        }
        public void actionPerformed(ActionEvent event)
        {
            buttonPanel.setBackground(col);
        }


    }



}






/*
keyPress

public void keyPress(int keycode)
按下给定的键。应该使用 keyRelease 方法释放该键。
拥有一个以上与之相关的物理键（例如，KeyEvent.VK_SHIFT 可能指左 shift 键或右 shift 键）的键代码可能映射到左键。

参数：
keycode - 要按下的键（例如， KeyEvent.VK_A）
抛出：
IllegalArgumentException - 如果 keycode 是一个无效的键



createScreenCapture

public BufferedImage createScreenCapture(Rectangle screenRect)
创建包含从屏幕中读取的像素的图像。该图像不包括鼠标光标。
参数：
screenRect - 将在屏幕坐标中捕获的 Rect
返回：
捕获的图像
抛出：
IllegalArgumentException - 如果 screenRect 的宽度和高度不大于零
SecurityException - 如果没有授予 readDisplayPixels 权限



java.awt.image
类 BufferedImage

java.lang.Object
  继承者 java.awt.Image
      继承者 java.awt.image.BufferedImage
所有已实现的接口：
RenderedImage, WritableRenderedImage, Transparency
public class BufferedImage




      extends
      Image
        implements
      WritableRenderedImage,
      Transparency

BufferedImage 子类描述具有可访问图像数据缓冲区的 Image。BufferedImage 由图像数据的 ColorModel 和 Raster 组成。Raster 的 SampleModel 中 band 的数量和类型必须与 ColorModel 所要求的数量和类型相匹配，以表示其颜色和 alpha 分量。所有 BufferedImage 对象的左上角坐标都为 (0, 0)。因此，用来构造 BufferedImage 的任何 Raster 都必须满足：minX=0 且 minY=0。

此类依靠 Raster 的数据获取方法、数据设置方法，以及 ColorModel 的颜色特征化方法。





 */