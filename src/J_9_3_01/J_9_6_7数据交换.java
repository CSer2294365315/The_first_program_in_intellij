
package J_9_3_01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class J_9_6_7数据交换
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new DataExchangeFrame();
            frame.setTitle("这是一个数据交换测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            // pack();
        });
    }
}



class DataExchangeFrame extends JFrame          //缺少user
{
    public static final int TEXT_ROWS=20;
    public static final int TEXT_COLUMNS=40;
    private PasswordChooser dialog=null;
    private JTextArea textArea;

    public DataExchangeFrame ()
    {
        JMenuBar mbar=new JMenuBar();
        setJMenuBar(mbar);
        JMenu fileMenu=new JMenu("File..");
        mbar.add(fileMenu);

        JMenuItem connectItem=new JMenuItem("Connect..");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        JMenuItem exitItem=new JMenuItem("Exit");
        exitItem.addActionListener(event->System.exit(0));
        fileMenu.add(exitItem);

        textArea=new JTextArea(TEXT_ROWS,TEXT_COLUMNS);
        add(new JScrollPane(textArea),BorderLayout.CENTER);
        pack();
    }

    private class ConnectAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(dialog==null)
                dialog=new PasswordChooser();
            dialog.setUser(new User("your name",null));    //? where is User?

            if(dialog.showDialog(DataExchangeFrame.this,"Connect"))
            {
                User u=dialog.getUser();
                textArea.append("User name = "+u.getName()+" , password = "+(new String(u.getPassword()))+"\n");
            }
        }
    }
}

class PasswordChooser extends JPanel
{
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser()
    {
        setLayout(new BorderLayout());

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JLabel("User name:"));
        panel.add(username=new JTextField(""));
        panel.add(new JLabel("Password:"));
        panel.add(password=new JPasswordField(""));
        add(panel,BorderLayout.CENTER);

        okButton=new JButton("ok");
        okButton.addActionListener(event->{
            ok=true;
            dialog.setVisible(false);
        });

        JButton cancelButton=new JButton("Cancel");
        cancelButton.addActionListener(event->dialog.setVisible(false));

        JPanel buttonPanel=new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel,BorderLayout.SOUTH);

    }

    public void setUser(User u)
    {
        username.setText(u.getName());
    }

    public User getUser()
    {
        return new User(username.getText(),password.getPassword());
    }

    public boolean showDialog(Component parent,String title)
    {
        ok=false;

        Frame owner=null;
        if(parent instanceof Frame)
        {
            owner=(Frame) parent;
        }
        else
            owner=(Frame)SwingUtilities.getAncestorOfClass(Frame.class,parent);

        if(dialog==null||dialog.getOwner()!=owner)
        {
            dialog=new JDialog(owner,true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;

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

getAncestorOfClass

public static Container getAncestorOfClass(Class<?> c,
                                           Component comp)
在组件层次结构中搜索上面的 comp 的便捷方法，返回它找到的类 c 的第一个对象。如果无法找到类 c，可以返回 null。




Component.getCursor(), Cursor
getOwner

public Window getOwner()
返回此窗口的所有者。



JDialog

public JDialog(Dialog owner,
               boolean modal)
创建一个具有指定所有者 Dialog 和模式的对话框。
此构造方法将该组件的语言环境属性设置为 JComponent.getDefaultLocale 所返回的值。

参数：
owner - 显示该对话框的所有者 Dialog；如果此对话框没有所有者，则为 null
modal - 指定对话框在显示时是否阻塞用户向其他顶层窗口输入。如果为 true，则模式类型属性被设置为 DEFAULT_MODALITY_TYPE；否则对话框是无模式的。


 */

