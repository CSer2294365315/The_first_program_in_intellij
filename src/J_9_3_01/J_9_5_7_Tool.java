package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class J_9_5_7_Tool
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new ToolBarFrame();
            frame.setTitle("这是一个工具栏测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ToolBarFrame extends JFrame
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    private JPanel panel;

    public ToolBarFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        panel=new JPanel();
        add(panel,BorderLayout.CENTER);

        Action blueAction=new ColorAction("Blue.....",Color.BLUE);   //按钮名，
        Action redAction=new ColorAction("red..",Color.red);
        Action yellowAction=new ColorAction("yellow.",Color.yellow);

        Action exitAction=new AbstractAction("Exit.....")
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION,"这是一个Exit按钮, 注意看是怎么关联的");

        JToolBar bar=new JToolBar();
        bar.add(blueAction);
        bar.add(redAction);
        bar.add(yellowAction);
        bar.addSeparator();
        bar.add(exitAction);

        add(bar,BorderLayout.NORTH);

        JMenu menu=new JMenu("Color..这是菜单栏");
        menu.add(yellowAction);
        menu.add(blueAction);
        menu.add(redAction);
        menu.add(exitAction);
        JMenuBar menuBar =new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);




    }

    public class ColorAction extends AbstractAction
    {
        public ColorAction(String name,Color c)   //构造函数，只有在构造的时候才执行，而不是作为动作执行。
        {
            putValue(Action.NAME,name);   //作为add了这个动作的按钮的名字
        //    putValue(Action.SMALL_ICON,icon);   作为add了这个动作的按钮的icon
            putValue(Action.SHORT_DESCRIPTION,name+" ......background...");  //作为add了这个动作的按钮的描述

            putValue("Color..",c);    //此处putValue中的第一个string不是关键字，而是以字符串形式的自定义的key

        }
        public void actionPerformed(ActionEvent event)
        {
            Color c=(Color)getValue("Color..");           //getValue("键的string");
            panel.setBackground(c);    //设置框架JFrame上的面板panel为颜色，而不是将Frame设置为颜色
        }
    }
}




/*




JToolBar

public JToolBar(String name,
                int orientation)
创建一个具有指定 name 和 orientation 的新工具栏。所有其他构造方法均调用此构造方法。如果 orientation 是一个无效值，则将抛出异常。
参数：
name - 工具栏的名称
orientation - 初始方向，它不是 HORIZONTAL 就是 VERTICAL



setToolTipText

public void setToolTipText(String text)
注册要在工具提示中显示的文本。光标处于该组件上时显示该文本。
有关更多信息，请参阅 The Java Tutorial 中的 How to Use Tool Tips。

参数：
text - 要显示的字符串；如果 text 为 null，则关闭此组件的工具提示
另请参见：
TOOL_TIP_TEXT_KEY
getToolTipText

public String getToolTipText()
返回通过 setToolTipText 所设置的工具提示字符串。
返回：
工具提示文本



getValue

Object getValue(String key)
使用关联的键获取此对象的一个属性。
另请参见：
putValue(java.lang.String, java.lang.Object)
putValue

void putValue(String key,
              Object value)
使用关联的键设置此对象的一个属性。如果值发生了更改，则将一个 PropertyChangeEvent 发送到侦听器。
参数：
key - 一个包含键的 String
value - 一个 Object 值




构造方法详细信息
AbstractAction

public AbstractAction()
用默认描述字符串和默认图标定义一个 Action 对象。
AbstractAction

public AbstractAction(String name)
用指定描述字符串和默认图标定义一个 Action 对象。
AbstractAction

public AbstractAction(String name,
                      Icon icon)
用指定描述字符串和指定图标定义一个 Action 对象。

 */