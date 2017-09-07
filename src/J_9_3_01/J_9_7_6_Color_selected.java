package J_9_3_01;


import java.awt.*;
        import javax.swing.*;
        import java.awt.event.*;
        import javax.swing.*;
import java.awt.*;
import java.beans.*;
import java.lang.reflect.*;

public class J_9_7_6_Color_selected
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new ColorChooserPanel();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("这是一个颜色选择器测试...");


            /**
             * AWT
             */
            J_9_7_8 tracer=new J_9_7_8();
            tracer.add(frame);

        });
    }
}

class ColorChooserPanel extends JFrame
{
    public ColorChooserPanel()
    {
        JButton modalButton=new JButton("Modal");
        modalButton.addActionListener(new ModalListener());
        add(modalButton,BorderLayout.NORTH);

        JButton modelessButton=new JButton("Modeless");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton,BorderLayout.CENTER);

        JButton immediateButton=new JButton("Immediate");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton,BorderLayout.SOUTH);
        pack();
    }


    private class ModalListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Color defaultColor=getBackground();
            Color selected=JColorChooser.showDialog(ColorChooserPanel.this,"Set background..这是在这里",defaultColor);
            if(selected!=null)
                setBackground(selected);
        }
    }

    private class ModelessListener implements ActionListener
    {
        private JDialog dialog;
        private JColorChooser chooser;

        public ModelessListener()
        {
            chooser=new JColorChooser();
            dialog=JColorChooser.createDialog(ColorChooserPanel.this,
                    "Background color",
                    false,
                    chooser,
                    event->setBackground(chooser.getColor()),
                    null);
        }

        public void actionPerformed(ActionEvent event)
        {
            chooser.setColor(getBackground());
            dialog.setVisible(true);

        }
    }

    private class ImmediateListener implements ActionListener
    {
        private JDialog dialog;
        private JColorChooser chooser;

        public ImmediateListener()
        {
            chooser=new JColorChooser();
            chooser.getSelectionModel().addChangeListener(event->setBackground(chooser.getColor()));

            dialog=new JDialog((Frame)null,false);
            dialog.add(chooser);
            dialog.pack();

        }

        public void actionPerformed(ActionEvent event)
        {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }

}


/**
 *
 */

 class J_9_7_8
{
    //如果想在GUI的应用中生成的每一个AWT事件的记录，可以在发出事件的每一个组件中安装一个监听器。利用反射，可以很容易的自动完成这个工作
    private InvocationHandler handler;

    public J_9_7_8()
    {
        handler=new InvocationHandler()
        {
            public Object invoke(Object proxy,Method method,Object[] args)
            {
                System.out.println(method+":"+args[0]);
                return null;
            }
        };
    }


    /**
     * 为所有有监听器的事件暗转一个事件跟踪器
     */
    public void add(Component c)
    {
        try
        {
            //得到所有可以监听的组件
            BeanInfo info=Introspector.getBeanInfo(c.getClass());

            EventSetDescriptor[] eventSets=info.getEventSetDescriptors();
            for(EventSetDescriptor eventSet:eventSets)
            {
                addListener(c,eventSet);
            }
        }
        catch(IntrospectionException e)
        {
        }

        if(c instanceof Container)
        {
            for(Component comp:((Container)c).getComponents())
            {
                add(comp);
            }
        }
    }

    public void addListener(Component c,EventSetDescriptor eventSet)
    {
        Object proxy=Proxy.newProxyInstance(null,new Class[]{eventSet.getListenerType()},handler);

        Method addListenerMethod=eventSet.getAddListenerMethod();
        try
        {
            addListenerMethod.invoke(c,proxy);
        }
        catch(ReflectiveOperationException e)
        {

        }

    }

}



















/*

showDialog

public static Color showDialog(Component component,
                               String title,
                               Color initialColor)
                        throws HeadlessException
显示有模式的颜色选取器，在隐藏对话框之前一直阻塞。如果用户按下 "OK" 按钮，则此方法隐藏/释放对话框并返回所选颜色。如果用户按下 "Cancel" 按钮或者在没有按 "OK" 的情况下关闭对话框，则此方法将隐藏/释放对话框并返回 null。
参数：
component - 对话框的父 Component
title - 包含对话框标题的 String
initialColor - 显示颜色选取器时的初始 Color 设置
返回：
所选颜色；如果用户退出，则返回 null

Color a=JColorChooser.showDialog(own,title,initilalColor



createDialog

public static JDialog createDialog(Component c,
                                   String title,
                                   boolean modal,
                                   JColorChooser chooserPane,
                                   ActionListener okListener,
                                   ActionListener cancelListener)
                            throws HeadlessException
创建并返回包含指定 ColorChooser 窗格及 "OK"、"Cancel" 和 "Reset" 按钮的新对话框。如果按下 "OK" 或 "Cancel" 按钮，则对话框自动隐藏（但未释放）。如果按下 "Reset" 按钮，则将颜色选取器的颜色重置为上一次在对话框上调用 show 时设置的颜色，并且对话框仍然显示。
参数：
c - 对话框的父组件
title - 对话框的标题
modal - 一个 boolean,为 true 时，在关闭对话框之前，程序的剩余部分将一直处于非激活状态。
chooserPane - 要置于对话框中的颜色选取器
okListener - 按下 "OK" 时调用的 ActionListener
cancelListener - 按下 "Cancel" 时调用的 ActionListener
返回：
包含颜色选取器窗格的新对话框
抛出：
HeadlessException - 如果 GraphicsEnvironment.isHeadless() 返回 true。



getSelectionModel

public ColorSelectionModel getSelectionModel()
返回处理颜色选择的数据模型。
返回：
ColorSelectionModel 对象




setColor

public void setColor(Color color)
将颜色选取器的当前颜色设置为指定颜色。 ColorSelectionModel 将激发 ChangeEvent
参数：
color - 要在颜色选取器中设置的颜色


getSelectionModel

public ColorSelectionModel getSelectionModel()
返回处理颜色选择的数据模型。
返回：
ColorSelectionModel 对象
 */