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

 */