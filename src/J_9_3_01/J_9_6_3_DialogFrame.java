

package J_9_3_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class J_9_6_3_DialogFrame
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new DialogFrame();
            frame.setTitle("这是一个Dialog对话框测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DialogFrame_3 extends JFrame
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    private AboutDialog dialog;

    public DialogFrame_3()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JMenuBar menuBar =new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu=new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem aboutItem=new JMenuItem("About..");
        aboutItem.addActionListener(event->
        {
            if(dialog==null)
                dialog=new AboutDialog(DialogFrame_3.this);
            dialog.setVisible(true);
        });
        fileMenu.add(aboutItem);

        JMenuItem exitItem=new JMenuItem("Exit..");
        exitItem.addActionListener(event->System.exit(0));
        fileMenu.add(exitItem);

    }

}

class AboutDialog extends JDialog
{
    public AboutDialog(JFrame owner)
    {
        super(owner,"这是在Dialog代码中的标题，这行代码显示了吗？",true);   //对话框中覆盖的超类构造器，中间的string是对话框的名字，会显示在对话框中

        add(new JLabel("<html><h1><i>这是一个html</i></h1><hr>这一行是另起一行吗？</html>"),BorderLayout.CENTER);
        JButton ok=new JButton("ok!");
        ok.addActionListener(event->setVisible(false));

        JPanel panel=new JPanel();
        panel.add(ok);
        add(panel,BorderLayout.SOUTH);

        pack();
    }
}













/*


javax.swing
类 JDialog

java.lang.Object
  继承者 java.awt.Component
      继承者 java.awt.Container
          继承者 java.awt.Window
              继承者 java.awt.Dialog
                  继承者 javax.swing.JDialog

setJMenuBar

public void setJMenuBar(JMenuBar menu)
设置此对话框的菜单栏。
参数：
menu - 该对话框中放置的菜单栏



JDialog

public JDialog(Dialog owner,
               String title,
               boolean modal)
创建一个具有指定标题、模式和指定所有者 Dialog 的对话框。
此构造方法将该组件的语言环境属性设置为 JComponent.getDefaultLocale 所返回的值。

参数：
owner - 显示该对话框的所有者 Dialog；如果此对话框没有所有者，则为 null
title - 该对话框的标题栏中所显示的 String
modal - 指定对话框在显示时是否阻塞用户向其他顶层窗口输入。如果为 true，则模式类型属性被设置为 DEFAULT_MODALITY_TYPE；否则对话框是无模式的。
抛出：


 */