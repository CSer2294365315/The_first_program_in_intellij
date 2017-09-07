/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author cmx
 */
public class J_9_1_6_swing 
{
    public static void main(String [] args)
    {
        EventQueue.invokeLater(()->
        {
            SimpleFrame3 a=new SimpleFrame3();
            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Toolkit kit= Toolkit.getDefaultToolkit();
            Dimension screenSize=kit.getScreenSize();
            int screenWidth=screenSize.width;
            int screenHeight=screenSize.height;
            /**
             * 下面，将框架大小设置为上面取值得50%，然后，告知窗口系统定位框架
             */
            
            a.setSize(screenWidth/2,screenHeight/2);
            a.setLocationByPlatform((true));
            a.setVisible(true);
            Image img=new ImageIcon("icon.gif").getImage();
            a.setIconImage(img);
        });
        
    }
}
class SimpleFrame3 extends JFrame
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HIGHT=200;
    public SimpleFrame3()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
    }
}
