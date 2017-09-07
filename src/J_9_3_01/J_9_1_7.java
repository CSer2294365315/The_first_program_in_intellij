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
public class J_9_1_7 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame a=new SizedFrame();
            a.setTitle("SizedFrame。。。。。。。。");
            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            a.setVisible(true);
            
            
        });
    }
    
}
class SizedFrame extends JFrame
{
    public SizedFrame()
    {
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        Image bj = new ImageIcon(getClass().getClassLoader().getResource("NEW_DATE_SEQUENCE_PACKAGE//1.jpg")).getImage();
       ImageIcon bug = new ImageIcon(ClassLoader.getSystemResource("NEW_DATE_SEQUENCE_PACKAGE/1.jpg"));
        setIconImage(bj);
        Dimension c=kit.getScreenSize();
        System.out.println(c);
    }
    
}
