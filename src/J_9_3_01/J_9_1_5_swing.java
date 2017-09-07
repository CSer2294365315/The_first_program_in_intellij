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
public class J_9_1_5_swing
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            SimpleFrame1 a=new SimpleFrame1();
            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            a.setVisible(true);
            
            
        });
        
    }
    
}
class SimpleFrame1 extends JFrame
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HIGHT=200;
    public SimpleFrame1()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
    }
}
