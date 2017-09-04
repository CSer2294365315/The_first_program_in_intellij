package J_9_3_01;

public class J_9_4_2
{
    public static void main (String [] args)
    {

    }

}
/*
文本输入
Swing用户界面组件
文本域（JTextField）和 文本区（JTextArea）组件用于获取文本输入。文本域只能接收单行文本的输入，而文本区能够接收多行文本的输入。
JPassword也只能接受单行文本的输入，但是不会将输入的内容显示出来。
这三个类都继承与JTextComponent类。由于JTextComponent是一个抽象类，所以不能够构造这个类的对象。另外，在Java中常会看到这种情况
在查看API文档时，发现自己正在寻找的方法其实来自父类JTextComponent，而不是来自派生类自身。例如，在一个文本域和文本区内获取（get）
和设置（set）文本的方法实际上都是JTextComponent类中的方法。
javax.swing.text.JTextComponent
    String getText();
    void setText(String text)
    获取或者设置文本组件中的文本
    boolean isEditable()
    void setEditable()
    获取或者设置editable特性，这个特性决定了用户是否可以编辑文本组件中的内容
文本域
把文本添加到窗口的常用办法是将它添加到面板或者其他容器中。这与添加按钮完全一样。
JPanel panel=new JPanel（）；
JTextField textField=new JTextField（"Default input...",20);
panel.add(textField);
JTextField

public JTextField(String text,
                  int columns)
构造一个用指定文本和列初始化的新 TextField。创建默认的模型。
参数：
text - 要显示的文本，或者为 null
columns - 用来计算首选宽度的列数；如果列被设置为 0，则首选宽度将是组件实现的自然结果

这段代码将添加一个文本域，同时通过传递字符串进行初始化，构造器的第二个参数是设置了文本域的宽度，一列就是当前使用的字体下一个字符的宽度
如果希望文本域最多能够输入n个字符，就应该将宽度设置为n个字符，将宽度设置为n列，实际中，这样做的效果并不理想。
列数是给AWT设定的首选字符，如果布局管理器要缩放这个文本域，就会调整文本域的大小，可以输入更多的字符，但是就会滚动
可以使用setColumns方法。
validate

public void validate()
验证此容器及其所有子组件。
使用 validate 方法会使容器再次布置其子组件。已经显示容器后，在修改此容器的子组件的时候（在容器中添加或移除组件，或者更改与布局相关的信息），应该调用上述方法。

如果此 Container 无效，则此方法将调用 validateTree 方法，并将此 Container 标记为有效。否则不执行任何动作。

覆盖：
类 Component 中的 validate

使用setColumns方法改变了一个文本域的大小之后，需要调用包含这个文本框容器的revaliable方法（JComponent）
textFile.setColunms(10);
panel.revalidate();
revalidabte()方法会重新计算容器中所有组件的大小，并且对他们进行重新布局，调用revalidate方法后，布局管理器会重新设计容器的大小
然后就可以看到改变尺寸后的文本域了。
revalidate方法是JComponent类中的方法。他并不是马上就改变组建的大小，而是给这个组件加一个需要改变的标记，这样就避免了
改变多个组件大小时带来的重复计算。但是，如果想要扩展一个JFrame中的所有组件，就必须调用validate方法--JFrame没有扩展JComponent
通常情况下，希望用户在文本域中键入文本（或者编辑已经存在的文本）。文本域一般初始为空白。只要不为JTextField构造器提供字符串参数，就可以构造一个
空白文本域。
JTextField textField =new JTextField（20）；
可以在任何时候调用setText方法改变文本域中的内容。这个方法是从前面提到了JTextComponent中继承来的。
textField.setText("helo");
并且，在前面已经看到，可以调用getText方法来获取用户键入的文本。这个方法返回用户输入的文本。如果想要将getText方法返回的文本域中的内容
的前后空格去掉，就应该调用trim方法


toUpperCase(Locale)
trim

public String trim()
返回字符串的副本，忽略前导空白和尾部空白。
如果此 String 对象表示一个空字符序列，或者此 String 对象表示的字符序列的第一个和最后一个字符的代码都大于 '\u0020'（空格字符），则返回对此 String 对象的引用。

否则，若字符串中没有代码大于 '\u0020' 的字符，则创建并返回一个表示空字符串的新 String 对象。

否则，假定 k 为字符串中代码大于 '\u0020' 的第一个字符的索引，m 为字符串中代码大于 '\u0020' 的最后一个字符的索引。创建一个新的 String 对象，它表示此字符串中从索引 k 处的字符开始，到索引 m 处的字符结束的子字符串，即 this.substring(k, m+1) 的结果。

此方法可用于截去字符串开头和末尾的空白（如上所述）。
getText

public AttributedCharacterIterator getText()
获取已提交文本和撰写文本的组合。从索引 0 到索引 getCommittedCharacterCount() - 1 的字符为已提交文本，其余字符为撰写文本。
返回：
文本。对于 CARET_POSITION_CHANGED 始终为 null；如果没有任何撰写文本或已提交文本，则对于 INPUT_METHOD_TEXT_CHANGED 可能为 null。


返回：
此字符串移除了前导和尾部空白的副本；如果没有前导和尾部空白，则返回此字符串。


String text=textField.getText().trim();
如果想要显示文本的字体，就调用setFont的方法
javax.swing.JTextField
    JTextField(int cols)
    构造一个给定列数的空的JTextField对象

    JTextField（String text，int cols）
    构造一个给定列数，给定初始字符串的JTextField对象
    int getColumns（）
    void setColums（int cols)
    获取或者设置文本域使用的列数
java.swing.JComponent
    void revalidate()
    重新计算组建的位置和大小
    void setFont（Font f）
    设置组件的字体
java.awt.Component
    void validate()
    重新计算组建的位置和大小。如果组件是容器，容器中包含的所有组件的位置和大小也被重新计算。
    Font getFond（）
    获取组件的字体
标签和标签组件
    标签是容纳文本的组件，他们没有任何的修饰（例如没有边缘）。也不能影响用户的输入。
    可以利用标签表示组件。例如：与按钮不同，文本域没有表示他们的标签。要想用标识符标识这种不带标签的组件。应该：
    1）用相应的文本构造一个JLabel组件
    2）将标签组件放置在距离需要表示的组件足够近的地方，以便用户可以知道标签所表示的组件。
    JLabel的构造器允许指定初始文本和图标，也可以选择内容的排列方式。可以用SwingConstants接口中的常量来制定排列方式。
    指定右对齐标签：
    JLabel label=new Jlabel（"User name"，SwingConstants.RIGHT);
    或者
    JLabel label=new JLabel（"User name",JLabel.RIGHT)
    利用setText或者setIcon可以在运行期间设置标签和图标
    可以在按钮，标签和菜单项上使用无格式文本后者HTML文本。不推荐在按钮上使用HTML文本---这样会影响观感。但是HTML文本在标签重视非常有效的
    只要将文本放在<html>  ...  </html>中即可
    包含HTML的标签要很长时间才能显示出来
    标签也可以放置在容器中，也就是说，可以用前面介绍的技巧将标签放在任何需要的地方。
javax.swing.JLabel
    JLabel(String text)
    JLable(Icon icon)
    JLabel(String text,int align)
    JLabel(String text,Icon icon,int align)
    align 一个SwingConstants的常量LEFT（默认），CENTER或者RIGHT
    String getText（）
    void setText（）
    获取或者设置标签的文本
    Icon getIcon（）
    void setIcon（Icon icon）
    获取或者设置标签的图标
密码域
    密码域是一种特殊的文本域。用户输入的字符不显示出来，而是用一个（echo character）常用的为"*"来代替，Swing提供了JPasswordField类来实现这样的文本域
javax.swing.JPasswordField
    JPasswordField(String text,int columns)
    构造一个新的密码域对象
    void setEchoChar（char echo）
    为密码域设置echo字符：0表示重新设置为默认的回显字符（echochar）
    char[] getPassword()
    返回密码域中的文本。为了安全起见，在使用之后可以覆盖返回的数组内容。（密码不以String的形式返回，因为字符串在被垃圾机制回收之前会一直驻留在虚拟机中
文本区
输入超过一行，使用JTextArea来接受这样的输入。当在程序中放置一个文本区组件时，用户就可以输入多行文本。用ENTER键换行。每行都以一个\n结尾
在JTextArea组建的构造器中。可以指定文本区的行数和列数
例如：
textArea=new JTextArea（2，3）
2行3列
与文本域一样，可以用setColumns和setRaws来设置行数，这些值只是首选大小。
如果文本区的文本超过现实的范围。剩下的文本就会见裁掉。可以通过开启换行特性来避免裁剪过长的行
textArea.setLineWrap(true);
换行只是视觉效果，文档中的文本没有改变
滚动窗格
在Swing中，文本区没有滚动条。如果需要滚动条，可以将文本区插入到滚动窗格中。
(scroll pane)
textArea=new JTextArea(2,3);
JScrollPane scrollPane=new scrollPane(textArea);
现在将由滚动窗格管理文本的视图。这是一种为任意组件添加滚动功能的通用机制，而不是文本区特有的，也就是说，要想为组建添加滚动条，只需要将它们放入一个滚动窗格中即可
JScrollPane a=new JScrollPane（b）;
JTextArea组件只显示无格式的文本，没有特殊字体或者格式设置，如果使用格式化文本，如HTML，需要使用JEditorPane类。








 */