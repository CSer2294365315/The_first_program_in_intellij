package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

public class J_9_6_6
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new DialogFrame();
            frame.setTitle("这是一个Dialog测试..");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
           // pack();
        });
    }
}

class DialogFrame extends JFrame
{
    public final int DEFAULT_WIDTH=300;
    public final int DEFAULT_HEIGHT=200;
    private  AboutDialog_2 dialog;

    public DialogFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);



        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu=new JMenu("File..");
        menuBar.add(fileMenu);

        JMenuItem menuItem=new JMenuItem("About");
        menuItem.addActionListener(event->
        {
            if(dialog==null)
                dialog=new AboutDialog_2(DialogFrame.this);
            dialog.setVisible(true);
        });
        fileMenu.add(menuItem);

        JMenuItem exit=new JMenuItem("EXIT..");
        exit.addActionListener(event->{
           System.exit(0);
        });
        fileMenu.add(exit);
      //  pack();

    }
}

class AboutDialog_2 extends JDialog
{
    public AboutDialog_2(JFrame owner)
    {
        super(owner,"这是对话框的名字..",true);

        add(new JLabel("这是一个html"),BorderLayout.CENTER);

        JButton ok=new JButton("这是对话框中按钮的名字，ok..");
        ok.addActionListener(event->setVisible(false));

        JPanel panel=new JPanel();
        panel.add(ok);
        add(panel,BorderLayout.SOUTH);
        pack();
    }
}
/*

public JDialog(JFrame owner,String title,boolean modal)
owner 对话框拥有者的框架
title 对话框的标题
modal true 代表模式的对话框



 */