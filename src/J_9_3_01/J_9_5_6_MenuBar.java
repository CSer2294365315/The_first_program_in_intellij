package J_9_3_01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class J_9_5_6_MenuBar
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new MenuFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("这是一个菜单设置测试...");
            frame.setVisible(true);
        });
    }
}

class MenuFrame extends JFrame
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem read_onlyItem;
    private JPopupMenu popup;

    public class TestAction extends AbstractAction
    {
        public TestAction(String name)
        {
            super(name);
        }

        public void actionPerformed(ActionEvent event)
        {
            System.out.println(getValue(Action.NAME)+" ...selected.");
        }
    }



    public MenuFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JMenu fileMenu=new JMenu("File");
        fileMenu.add(new TestAction("new ---File..."));     //test name

        JMenuItem openItem=fileMenu.add(new TestAction("Open..name"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl 0"));

        fileMenu.addSeparator();

        saveAction=new TestAction("Save");
        JMenuItem saveItem=fileMenu.add(saveAction);  //动作的名字就是saveItem的名字，动作一定有名字，要么是默认的，要么是指定的
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAsAction=new TestAction("Save As");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Exit...1")     //因为别的都是定制的AbstractAction，这个是特殊的动作，不同于其他的动作，所以需要新增一个AbstractAction，使用匿名类
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }

        });

         //demonstrate checkBox and radio menus
        read_onlyItem=new JCheckBoxMenuItem("Read-only...1");
        read_onlyItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                boolean saveOK=!read_onlyItem.isSelected();   //如果为只读（readonly），则不可选
                saveAction.setEnabled(saveOK);
                saveAsAction.setEnabled(saveOK);
            }
        });

        ButtonGroup group=new ButtonGroup();

        JRadioButtonMenuItem insertItem=new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);   //设置按钮状态？就可默认的可以按这个按钮 但是没有触发按钮？？？？？？
        JRadioButtonMenuItem overtypeItem=new JRadioButtonMenuItem("Over type");

        group.add(insertItem);
        group.add(overtypeItem);

        Action cutAction=new TestAction("Cut");
        cutAction.putValue(Action.NAME,"用cut.gif的控制台输出来代替图标");   //Action.putValue(Action.NAME,string) 用于将动作的名字存到动作中，也就是，将隐式对象与属性为Action.NAME的Object关联起来，Action.NAME仅用于说明属性，真正关联的是隐式对象与Object

        Action copyAction=new TestAction("Copy");
        copyAction.putValue(Action.NAME,"copy.gif的控制台输出来代替图标");

        Action pasteAction=new TestAction("Paste");
        pasteAction.putValue(Action.NAME,"paste.gif的控制台输出来代替图标");

        JMenu editMenu=new JMenu("Edit");

        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        JMenu optionMenu=new JMenu("Options");

        optionMenu.add(read_onlyItem);   //一个复选框
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overtypeItem);

        editMenu.addSeparator();
        editMenu.add(optionMenu);



        JMenu helpMenu=new JMenu("Help");
        helpMenu.setMnemonic('H');   //看一下怎么显式在菜单中，有没有下划线

        JMenuItem indexItem=new JMenuItem("Index...");
        indexItem.addActionListener(event->{
            System.out.println("用控制台输出Index...");
        });

        indexItem.setMnemonic('I');

        helpMenu.add(indexItem);

        Action aboutAction=new TestAction("About");
        aboutAction.putValue(Action.MNEMONIC_KEY,new Integer('A'));

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        popup=new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        JPanel panel=new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);
     }
}















/*
setJMenuBar

public void setJMenuBar(JMenuBar menubar)
设置此窗体的菜单栏。
参数：
menubar - 放置于该窗体中的菜单栏


JMenuItem

public JMenuItem(Action a)
创建从指定的 Action 获取其属性的菜单项。
参数：
a - JMenuItem 的操作


show

public void show(Component invoker,
                 int x,
                 int y)
在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单。
参数：
invoker - 弹出菜单在其空间中显示的组件
x - 用于显示弹出菜单的调用者的坐标空间中的 X 坐标
y - 用于显示弹出菜单的调用者的坐标空间中的 Y 坐标


setDisplayedMnemonicIndex

public void setDisplayedMnemonicIndex(int index)
                               throws IllegalArgumentException
提供关于应该装饰文本中哪一个字符来表示助记符的外观提示。并不是所有的外观都能支持此方法。值 -1 指示没有助记符（助记符字符没有包含在字符串中），或者开发人员不希望显示助记符。
与助记符相关的属性发生更改时（比如助记符本身、文本……），此索引值也被更改。如果不希望默认字符带下划线，那么只能不断地调用此方法。例如，如果文本 'Save As' 带有一个助记符 'a'，您想装饰 'A'（比如装饰成 'Save As'），那么您必须在调用 setMnemonic(KeyEvent.VK_A) 之后调用 setDisplayedMnemonicIndex(5)。

参数：
index - String 中的索引，指示要加下划线的字符
抛出：
IllegalArgumentException - 如果 index >= 文本的长度，或者 < -1，则抛出该异常


putValue

void putValue(String key,
              Object value)
使用关联的键设置此对象的一个属性。如果值发生了更改，则将一个 PropertyChangeEvent 发送到侦听器。
参数：
key - 一个包含键的 String
value - 一个 Object 值


MNEMONIC_KEY

static final String MNEMONIC_KEY
用来存储对应于一个 KeyEvent 键代码的 Integer 值的键。该值通常用于指定助记符。例如： myAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A) 将 myAction 的助记符设置为 'a'。


public class KeyStroke


      extends
      AWTKeyStroke

表示键盘或等效输入设置上的键操作的 KeyStroke。KeyStroke 仅能对应于按下或释放某个特定的键，正如 KEY_PRESSED 和 KEY_RELEASED KeyEvents 执行的操作；或者，它们可能对应于键入特定的 Java 字符，正如 KEY_TYPED KeyEvents 执行的操作。在所有情况下，KeyStroke 都可以指定修饰符（alt、shift、control、meta、altGraph 或其组合），在针对精确匹配的操作中，这些修饰符必须存在。

KeyStroke 用于定义高级（语义)操作事件。不用捕获每个 keystroke 并抛弃不感兴趣的 keystroke，这些重要的 keystroke 会自动在其注册的 Components 上启动操作。

KeyStroke 是不可变的，而且是唯一的。客户端代码无法创建 KeyStroke；必须使用 getKeyStroke 的变体。这些工厂方法使得 KeyStroke 实现能够高效缓存和共享实例。


getKeyStroke

public static KeyStroke getKeyStroke(String s)
分析字符串并返回 KeyStroke。字符串必须具有以下语法：
    <modifiers>* (<typedID> | <pressedReleasedID>)

    modifiers := shift | control | ctrl | meta | alt | altGraph
    typedID := typed <typedKey>
    typedKey := string of length 1 giving Unicode character.
    pressedReleasedID := (pressed | released) key
    key := KeyEvent key code name, i.e. the name following "VK_".

如果没有指定是键入、按下还是释放，则假定为按下。以下是一些示例：
     "INSERT" => getKeyStroke(KeyEvent.VK_INSERT, 0);
     "control DELETE" => getKeyStroke(KeyEvent.VK_DELETE, InputEvent.CTRL_MASK);
     "alt shift X" => getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK);
     "alt shift released X" => getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK, true);
     "typed a" => getKeyStroke('a');

为了维持向后兼容性，指定 null String 或格式不正确的 String 将返回 null。
参数：
s - 用上述方法格式化的 String
返回：
该 String 的 KeyStroke 对象，如果指定的 String 为 null 或格式不正确，则返回 null


setEnabled

public void setEnabled(boolean b)
设置此对象的启用状态。
指定者：
接口 AccessibleComponent 中的 setEnabled
参数：
b - 如果此参数为 ture，则启用此对象；否则将禁用它


public abstract class AbstractAction


      extends
      Object




      implements
      Action,
      Cloneable,
      Serializable

此类提供 JFC Action 接口的默认实现。它定义了一些标准行为，比如 Action 对象属性（icon、text 和 enabled）的 get 和 set 方法。开发人员只需为此抽象类创建子类并定义 actionPerformed 方法即可。
构造方法摘要
AbstractAction()
          用默认描述字符串和默认图标定义一个 Action 对象。
AbstractAction(String name)
          用指定描述字符串和默认图标定义一个 Action 对象。
AbstractAction(String name, Icon icon)
          用指定描述字符串和指定图标定义一个 Action 对象。
方法摘要
 void	addPropertyChangeListener(PropertyChangeListener listener)
          向侦听器列表添加一个 PropertyChangeListener。
protected  Object	clone()
          复制抽象操作。
protected  void	firePropertyChange(String propertyName, Object oldValue, Object newValue)
          支持报告绑定 (bound) 属性的改变。
 Object[]	getKeys()
          返回 Object 的数组，这些对象是一些已经为其设置此 AbstractAction 值的键，如果没有已经设置该值的键，则返回 null。
 PropertyChangeListener[]	getPropertyChangeListeners()
          返回使用 addPropertyChangeListener() 添加到此 AbstractAction 中的所有 PropertyChangeListener 组成的数组。
 Object	getValue(String key)
          获得与指定键关联的 Object。
 boolean	isEnabled()
          如果启用该操作，则返回 true。
 void	putValue(String key, Object newValue)
          设置与指定键关联的 Value。
 void	removePropertyChangeListener(PropertyChangeListener listener)
          从侦听器列表中移除一个 PropertyChangeListener。
 void	setEnabled(boolean newValue)
          启用或禁用该操作。


          AbstractAction

public AbstractAction(String name)
用指定描述字符串和默认图标定义一个 Action 对象。


getValue

public Object getValue(String key)
获得与指定键关联的 Object。
指定者：
接口 Action 中的 getValue
参数：
key - 包含指定 key 的字符串
返回：
用此键存储的绑定 Object；如果没有键，则将返回 null



NAME

static final String NAME
用来存储动作的 String 名称的键，用于菜单或按钮。


add

public JMenuItem add(Action a)
创建连接到指定 Action 对象的新菜单项，并将其追加到此菜单的末尾。
参数：
a - 要添加的菜单项的 Action



JRadioButtonMenuItem

public JRadioButtonMenuItem(String text)
创建一个带文本的 JRadioButtonMenuItem。




 */