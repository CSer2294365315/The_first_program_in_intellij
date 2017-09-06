package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;


public class J_9_6_2_Dialog
{
    public static void main(String[] args)
    {
        JFrame frame=new OptionDialogFrame();
        frame.setTitle("这是一个对话框测试...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class OptionDialogFrame extends JFrame
{
    private ButtonPanel typePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionsPanel;
    private ButtonPanel inputPanel;
    private String messageString="Message";
    private Icon messageIcon=new ImageIcon("blue-bal.gif");
    private Object messageObject=new Date();
    private Component messageComponent =new SampleComponent();

    public OptionDialogFrame()
    {
        JPanel gridPanel=new JPanel();
        gridPanel.setLayout(new GridLayout(2,3));

        typePanel=new ButtonPanel("Type.","Message","Confirm","Option","Input");

        messageTypePanel=new ButtonPanel("Message Type","ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE");

        messagePanel=new ButtonPanel("Message","String","Icon","Component","Other","Object[]");

        optionTypePanel=new ButtonPanel("Confirm","DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANEL_OPTION");

        optionsPanel=new ButtonPanel("Option","String[]","Icon[]","Object[]");
        inputPanel=new ButtonPanel("Input","Text field","Combo box");

        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);

        JPanel showPanel=new JPanel();
        JButton showButton=new JButton("Show.1");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);

        add(gridPanel,BorderLayout.CENTER);
        add(showPanel,BorderLayout.SOUTH);
        pack();
    }

    public Object getMessage()
    {
        String s =messagePanel.getSelection();
        if(s.equals("String"))
            return messageString;
        else if(s.equals("Icon"))
            return messageIcon;
        else if(s.equals("Component"))
            return messageComponent;
        else if(s.equals("Object[]"))
            return new Object[]{messageString,messageIcon,messageComponent,messageObject};
        else if(s.equals("Other"))
            return messageObject;
        else
            return null;

    }

    public Object[] getOption()
    {
        String s=optionsPanel.getSelection();
        if(s.equals("String[]"))
            return new String[]{"Yellow","Blue","Red"};
        else if(s.equals("Icon[]"))
            return new Icon[]{new ImageIcon("yellow-ball.gif"),new ImageIcon("blue-ball.gif"),new ImageIcon("red-ball.gif")};
        else if(s.equals("Object[]"))
            return new Object[]{ messageString,messageIcon,messageComponent,messageObject};
        else
            return null;
    }

    public int getType(ButtonPanel panel)
    {
        String s=panel.getSelection();
        try
        {
            return JOptionPane.class.getField(s).getInt(null);    //?
        }
        catch(Exception e)
        {
            return -1;
        }
    }

    private class ShowAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(typePanel.getSelection().equals("Confirm"))
                JOptionPane.showConfirmDialog(OptionDialogFrame.this,getMessage(),"Title",getType(messageTypePanel));
            else if(typePanel.getSelection().equals("Input"))
            {
                if (inputPanel.getSelection().equals("Text field"))
                    JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
                else
                    JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel), null, new String[]{"Yellow", "Blue", "Red"}, "Blue");
            }


        }
    }


}


class SampleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2=(Graphics2D) g;
        Rectangle2D rect=new Rectangle2D.Double(0,0,getWidth()-1,getHeight()-1);
        g2.setPaint(Color.YELLOW);
        g2.fill(rect);
        g2.setPaint(Color.BLUE);
        g2.draw(rect);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(10,10);
    }




}


class ButtonPanel extends JPanel
{
    private ButtonGroup group;

    public ButtonPanel(String title ,String...options)
    {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));  //测试不同的轴；
        group=new ButtonGroup();

        for(String option:options)
        {
            JRadioButton b=new JRadioButton();
            b.setActionCommand(option);    //设置此按钮激发的动作的名称
            add(b);
            group.add(b);
            b.setSelected(option==options[0]);
        }

    }

    public String getSelection()
    {
        return group.getSelection().getActionCommand();
    }

}




/*
showMessageDialog
showConfirmDialog
showOptionDialog
showInputDialog



javax.swing
类 JOptionPane

java.lang.Object
  继承者 java.awt.Component
      继承者 java.awt.Container
          继承者 javax.swing.JComponent
              继承者 javax.swing.JOptionPane

虽然由于方法数多使 JOptionPane 类可能显得复杂，但几乎所有此类的使用都是对下列静态 showXxxDialog 方法之一的单行调用：

方法名	描述
showConfirmDialog	询问一个确认问题，如 yes/no/cancel。
showInputDialog	提示要求某些输入。
showMessageDialog	告知用户某事已发生。
showOptionDialog	上述三项的大统一 (Grand Unification)。 所有这些方法还可能以 showInternalXXX 风格出现，该风格使用内部窗体来保存对话框（请参见 JInternalFrame）。此外还定义了多种便捷方法，这些方法重载那些基本方法，使用不同的参数列表。
所有对话框都是有模式的。在用户交互完成之前，每个 showXxxDialog 方法都一直阻塞调用者。

图标	消息
输入值
选项按钮 这些对话框的基本外形通常与右图类似，尽管各种外观从根本上决定着最后结果。尤其是，外观可以调整布局以适应选项窗格的 ComponentOrientation 属性。




paintComponent

protected void paintComponent(Graphics g)
如果 UI 委托为非 null，则调用该 UI 委托的 paint 方法。向该委托传递 Graphics 对象的副本，以保护其余的 paint 代码免遭不可取消的更改（例如 Graphics.translate）。
如果在子类中重写此方法，则不应该对传入的 Graphics 进行永久更改。例如，不应更改剪贴区的 Rectangle 或修改转换。如果需要进行这些操作，您会发现根据传入的 Graphics 创建一个新 Graphics 并进行操作更加方便。另外，如果不调用超类的实现，则必须遵守不透明属性，也就是说，如果此组件是不透明的，则必须以透明的颜色完全填充背景。如果不遵守不透明属性，则很可能看到可视的人为内容。

传入的 Graphics 对象可能安装了恒等转换以外的转换。在这种情况下，如果多次应用其他转换，则可能得到不可预料的结果。

参数：
g - 要保护的 Graphics 对象



showConfirmDialog

public static int showConfirmDialog(Component parentComponent,
                                    Object message)
                             throws HeadlessException
调出带有选项 Yes、 No 和 Cancel 的对话框；标题为 Select an Option。
参数：
parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
message - 要显示的 Object
返回：
指示用户所选选项的整数
抛出：
HeadlessException - 如果 GraphicsEnvironment.isHeadless 返回 true
另请参见：
GraphicsEnvironment.isHeadless()
showConfirmDialog

public static int showConfirmDialog(Component parentComponent,
                                    Object message,
                                    String title,
                                    int optionType)
                             throws HeadlessException
调出一个由 optionType 参数确定其中选项数的对话框。
参数：
parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
message - 要显示的 Object
title - 对话框的标题字符串
optionType - 指定可用于对话框的选项的 int： YES_NO_OPTION、 YES_NO_CANCEL_OPTION 或 OK_CANCEL_OPTION
返回：
指示用户所选选项的 int
抛出：
HeadlessException - 如果 GraphicsEnvironment.isHeadless 返回 true
另请参见：
GraphicsEnvironment.isHeadless()
showConfirmDialog

public static int showConfirmDialog(Component parentComponent,
                                    Object message,
                                    String title,
                                    int optionType,
                                    int messageType)
                             throws HeadlessException
调用一个由 optionType 参数确定其中选项数的对话框， messageType 参数确定要显示的图标。 messageType 参数主要用于提供来自外观的默认图标。
参数：
parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame。
message - 要显示的 Object
title - 对话框的标题字符串
optionType - 指定可用于对话框的选项的整数： YES_NO_OPTION、 YES_NO_CANCEL_OPTION 或 OK_CANCEL_OPTION
messageType - 指定此消息种类的整数；主要用于确定来自可插入外观的图标： ERROR_MESSAGE、 INFORMATION_MESSAGE、 WARNING_MESSAGE、 QUESTION_MESSAGE 或 PLAIN_MESSAGE
返回：
指示用户所选选项的整数
抛出：
HeadlessException - 如果 GraphicsEnvironment.isHeadless 返回 true
另请参见：
GraphicsEnvironment.isHeadless()
showConfirmDialog

public static int showConfirmDialog(Component parentComponent,
                                    Object message,
                                    String title,
                                    int optionType,
                                    int messageType,
                                    Icon icon)
                             throws HeadlessException
调出一个带有指定图标的对话框，其中的选项数由 optionType 参数确定。 messageType 参数主要用于提供来自外观的默认图标。
参数：
parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
message - 要显示的 Object
title - 对话框的标题字符串
optionType - 指定可用于对话框的选项的 int： YES_NO_OPTION、 YES_NO_CANCEL_OPTION 或 OK_CANCEL_OPTION
messageType - 指定此消息种类的 int，主要用于确定来自可插入外观的图标： ERROR_MESSAGE、 INFORMATION_MESSAGE、 WARNING_MESSAGE、 QUESTION_MESSAGE 或 PLAIN_MESSAGE
icon - 要在对话框中显示的图标
返回：
指示用户所选选项的 int
抛出：
HeadlessException - 如果 GraphicsEnvironment.isHeadless 返回 true




createTitledBorder

public static TitledBorder createTitledBorder(Border border)
创建一个空标题的新标题边框，使其具有指定的边框对象、默认的文本位置（位于顶线上）、默认的调整 (leading)，以及默认的字体和文本颜色（由当前外观确定）。
参数：
border - 向其添加标题的 Border 对象；如果该参数为 null，则 Border 由当前外观确定。
返回：
TitledBorder 对象





public class BoxLayout
extends Object
implements LayoutManager2, Serializable
一个布局管理器，可以将多个组件垂直或水平放置。 组件不会包裹，例如，当框架调整大小时，部件的垂直布置将保持垂直布置。
The following text describes this graphic.

嵌套具有不同水平和垂直组合的多个面板会产生类似于GridBagLayout的效果，而不会有复杂性。 该图显示了水平布置的两个面板，每个面板垂直布置有3个组件。


BoxLayout

public BoxLayout(Container target,
                 int axis)
创建一个将沿给定轴放置组件的布局管理器。
参数：
target - 需要布置的容器
axis - 布置组件时使用的轴。它可以是以下值之一： BoxLayout.X_AXIS、 BoxLayout.Y_AXIS、 BoxLayout.LINE_AXIS 或 BoxLayout.PAGE_AXIS




字段摘要
static int	LINE_AXIS
          指定应该根据目标容器的 ComponentOrientation 属性确定的文本行方向放置组件。
static int	PAGE_AXIS
          指定应该根据目标容器的 ComponentOrientation 属性确定的文本行在页面中的流向来放置组件。
static int	X_AXIS
          指定组件应该从左到右放置。
static int	Y_AXIS
          指定组件应该从上到下放置。



          setSelected

public void setSelected(boolean b)
设置按钮的状态。注意，此方法不会触发 actionEvent。调用 doClick 以执行程序上的动作更改。
参数：
b - 如果选择了按钮，则该参数为 true，否则为 false


setActionCommand

public void setActionCommand(String command)
设置此按钮激发的动作事件的命令名称。在默认情况下，此动作命令设置为与按钮标签相匹配。
参数：
command - 用于设置按钮动作命令的字符串。如果字符串为 null，则动作命令设置为与按钮标签相匹配。



getSelection

public ButtonModel getSelection()
返回选择按钮的模型。
返回：
选择的按钮模型
setSelected

public void setSelected(ButtonModel m,
                        boolean b)
为 ButtonModel 设置选择值。一次只能选择组中的一个按钮。
参数：
m - ButtonModel
b - 如果此按钮被选择，则该参数为 true，否则为 false
isSelected

public boolean isSelected(ButtonModel m)
返回对是否已选择一个 ButtonModel 的判断。
返回：
如果选择了按钮，则返回 true；否则返回 false




getActionCommand

String getActionCommand()
返回该按钮的动作命令字符串。
返回：
标识生成的事件的 String


getWidth

public double getWidth()
以 double 精度返回窗体矩形的宽度。
指定者：
类 RectangularShape 中的 getWidth
返回：
窗体矩形的宽度


JComponent

public JComponent()
默认的 JComponent 构造方法。除调用 Container 构造方法外，此构造方法几乎不进行初始化工作。例如，初始布局管理器为 null。但是，它将组件的语言环境属性设置为 JComponent.getDefaultLocale 所返回的值。



showConfirmDialog

public static int showConfirmDialog(Component parentComponent,
                                    Object message,
                                    String title,
                                    int optionType)
                             throws HeadlessException
调出一个由 optionType 参数确定其中选项数的对话框。
参数：
parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
message - 要显示的 Object
title - 对话框的标题字符串
optionType - 指定可用于对话框的选项的 int： YES_NO_OPTION、 YES_NO_CANCEL_OPTION 或 OK_CANCEL_OPTION
返回：
指示用户所选选项的 int
抛出：


showInputDialog

public static String showInputDialog(Component parentComponent,
                                     Object message,
                                     String title,
                                     int messageType)
                              throws HeadlessException
显示请求用户输入内容的对话框，它以 parentComponent 为父级，该对话框的标题为 title，消息类型为 messageType。
参数：
parentComponent - 对话框的父 Component
message - 要显示的 Object
title - 要在对话框的标题栏中显示的 String
messageType - 要显示的消息类型： ERROR_MESSAGE、 INFORMATION_MESSAGE、 WARNING_MESSAGE、 QUESTION_MESSAGE 或 PLAIN_MESSAGE
抛出：
 */