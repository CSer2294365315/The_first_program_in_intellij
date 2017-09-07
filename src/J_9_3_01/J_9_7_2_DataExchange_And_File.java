/*
package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

public class J_9_7_2_DataExchange_And_File
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
           JFrame frame=new DataExchangeFrame();
           frame.setVisible(true);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setTitle("这是一个数据交换测试...");

        });
    }
}

class DataExchangeFrame extends JFrame
{
    private JTextArea textArea;
    private PasswordChooser dialog=null;   //设立dialog为PasswordChooser对象，PasswordChooser是一个JPanel类，设立
    public DataExchangeFrame()
    {
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu=new JMenu("File..");
        menuBar.add(fileMenu);

        JMenuItem connectItem=new JMenuItem("Connect.");
        connectItem.addActionListener(new ConnectAction());

    }

    private class ConnectAction implements ActionListener   //connect Item的动作监听器的动作
    {
        public void actionPerformed(ActionEvent event)
        {
            //动作监听器要执行的动作
            if(dialog==null)    //对话框为空，就新建一个JPanel的子类，将对话框引用这个JPanel
                dialog=new PasswordChooser();
            dialog.setUser(new User("这是显示在哪里的？",null));   //？

            if(dialog.showDialog(DataExchangeFrame.this,"Connect.."))
            {
                //如果接受到，重新检索输入
                User u=dialog.getUser();   //将对话框的用户名和密码组合成User对象
                textArea.append("user name= "+u.getName()+", password= "+(new String(u.getPassword())));
            }

        }

    }
}


class PasswordChooser extends JPanel
{
    private boolean ok;
    private JTextField username;
    private JDialog dialog;
    private JPasswordField password;
    private JButton okButton;
    //构造一个带有使用这名字域和密码域的面板
    public PasswordChooser()
    {
        setLayout(new BorderLayout());

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JLabel("User name:"));
        panel.add(username=new JTextField(""));  //此处省略了""
        panel.add(new JLabel("Password:"));
        panel.add(password=new JPasswordField());//此处省略了""
        add(panel,BorderLayout.CENTER);   //在JPanel的子类Password中添加JPanel   在面板中添加面板

        //创建开始和结束按钮
        okButton=new JButton("Ok..这是按钮");
        okButton.addActionListener(event->
        {
            ok=true;
            dialog.setVisible(false);    //ok 按钮设置dialog不可见
        });

        JButton cancelButton=new JButton("Cancel");
        cancelButton.addActionListener(event->dialog.setVisible(false));    //false 按钮设置dialog不可见

        //将按钮放到面板的南部
        JPanel buttonPanel=new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel,BorderLayout.SOUTH);    //在JPanel的子类Password中添加JPanel   在面板中添加面板
    }

    //设立面板的默认值
    public void setUser(User u)
    {
        username.setText(u.getName());  //为username域添加文本内容为 User对象的名字
    }

    public User getUser()
    {
        return  new User(username.getText(),password.getPassword());
    }

    public boolean showDialog(Component parent ,String title)  //showDialog，用于弹出对话框
    {
        ok=false;

        //定位所有者框架
        Frame owner=null;
        if(parent instanceof Frame)  //如果parent是Frame 就将owner设为parent，否则，在parent的上层框架中找到Frame类型的对象并且传递给owner
        {
            owner=(Frame)parent;
        }
        else
            owner=(Frame)SwingUtilities.getAncestorOfClass(Frame.class,parent);

        //如果第一次，或者所有着改变了，就new新的对话框

        if (dialog==null || dialog.getOwner()!=owner)
        {
            dialog=new JDialog(owner ,true);   //创建新的对话框
            dialog.add(this);   //对话框中添加PasswordChooser面板
            dialog.getRootPane().setDefaultButton(okButton);  //在dialog上层面板设立默认按钮为okButton
            dialog.pack();
        }

        dialog.setTitle(title);  //设立dialog对话框的题目，JDialog不是面板，而是面板的底层框架
        dialog.setVisible(true);
        return ok;   //  ?
    }
}

class User
{
    String name;
    char[] password;
    public User(String name,char[] password)
    {
        this.name=name;
        this.password=password;
    }

    public String getName()
    {
        return this.name;
    }

    public char[] getPassword()
    {
        return this.password;
    }

}

























/*
用户点击ok，会调用setVisible(false)终止对setVisible（true）的调用，同时对话框消失
setVisible（true）阻塞，实现模式对话框



JDialog

public JDialog(Dialog owner,
               boolean modal)
创建一个具有指定所有者 Dialog 和模式的对话框。
此构造方法将该组件的语言环境属性设置为 JComponent.getDefaultLocale 所返回的值。

参数：
owner - 显示该对话框的所有者 Dialog；如果此对话框没有所有者，则为 null
modal - 指定对话框在显示时是否阻塞用户向其他顶层窗口输入。如果为 true，则模式类型属性被设置为 DEFAULT_MODALITY_TYPE；否则对话框是无模式的。


JTextField

public JTextField()
构造一个新的 TextField。创建一个默认的模型，初始字符串为 null，列数设置为 0。
JTextField

public JTextField(String text)
构造一个用指定文本初始化的新 TextField。创建列数为 0 的默认模型。
参数：
text - 要显示的文本，或者为 null



showDialog

public int showDialog(Component parent,
                      String approveButtonText)
               throws HeadlessException
弹出具有自定义 approve 按钮的自定义文件选择器对话框。例如，以下代码弹出具有 "Run Application" 按钮（而不是普通的 "Save" 或 "Open" 按钮）的文件选择器：
 filechooser.showDialog(parentFrame, "Run Application");

或者，以下代码也可以执行相同的操作：
    JFileChooser chooser = new JFileChooser(null);
    chooser.setApproveButtonText("Run Application");
    chooser.showDialog(parentFrame, null);

parent 参数确定两件事情：打开的对话框所依赖的窗体，以及组件(放置对话框时外观应该考虑该组件的位置）。如果 parent 是一个 Frame 对象（例如 JFrame），则该对话框取决于该窗体，并且外观相对于窗体放置该对话框（例如在窗体上居中）。如果 parent 是一个组件，则该对话框取决于包含该组件的窗体，并且相对于该组件放置该对话框（例如在组件上居中）。如果 parent 为 null，则该对话框取决于不可见的窗口，并且将其放置到与外观相关的位置，如屏幕的中央。

参数：
parent - 该对话框的父组件，可以为 null
approveButtonText - ApproveButton 的文本
返回：
该文件选择器被弹下时的返回状态：
JFileChooser.CANCEL_OPTION
JFileChooser.APPROVE_OPTION
JFileChooser.ERROR_OPTION 如果发生错误或者该对话框已被解除
 */