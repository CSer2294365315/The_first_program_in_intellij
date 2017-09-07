package J_9_3_01;

public class J_9_7_6_Color_selected
{

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
 */