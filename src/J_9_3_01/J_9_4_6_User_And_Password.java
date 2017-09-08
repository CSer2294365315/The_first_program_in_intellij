/*
package J_9_3_01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class J_9_4_6_User_And_Password
{
    public static void main(String [] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new TotalFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("这是一个用户名和密码输入的测试...");
            frame.setVisible(true);
         });
    }
}
class TotalFrame extends JFrame
{
    public final int DEFAULT_WIDTH=600;
    public final int DEFAULT_HEIGHT=600;
    public TotalFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        JPasswordField passwordField=new JPasswordField();
        JTextField textField=new JTextField();

        JPanel northPanel=new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("User Name:",SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password:",SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel,BorderLayout.NORTH);


        JTextArea textArea=new JTextArea(8,20);
        JScrollPane scrollPanel=new JScrollPane(textArea);
        //注意 scrollPanel.add(textArea);  左侧这个句子不可以代替JScrollPane scrollPanel=new JScrollPane(textArea);
        /*
        javax.swing.JScrollPane
            JScrollPane(Component c)
            创建一个滑动窗格，用来显示指定组件的内容。当组件内容超过显示范围时，滚动条会自动出现
            不可以用JScrollPane scrollPane=new JScrollPane();
                   scrollPane.add(textField);来代替
         */
/*
        add(scrollPanel,BorderLayout.CENTER);

        JPanel southPanel=new JPanel();

        JButton insertButton=new JButton("显式账号和密码");
        southPanel.add(insertButton);

        insertButton.addActionListener(event->textArea.append("User name is :"+textField.getText()+" \nPassword is :"+new String(passwordField.getPassword())+"\n"));

        add(southPanel,BorderLayout.SOUTH);

    }
}
*/
