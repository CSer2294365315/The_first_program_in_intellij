package J_9_3_01;

public class J_9_5_6_MenuBar
{


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
 */