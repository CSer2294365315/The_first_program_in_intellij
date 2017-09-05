
/*
复选框：
如果想要接受的只是是或者非，就可以使用复选框，复选框自动的带有标签，用户通过点击某个复选框来选的相应的选项。再次点击则取消。当复选框获得焦点时，用户也可以通过空格键进行切换
右焦点的复选框周围有矩形。只要用户选择某个复选框，程序就会刷新屏幕。
复选框需要一个紧邻的标签来说明其用途，在构造器中指定标签文本
bold=new JCheckBox("Bold");
可以使用setSelected方法来选定或者取消选定复选框。例如：
bold.setSelected(true);

setSelected
public void setSelected(boolean b)
设置按钮的状态。 请注意，此方法不会触发actionEvent 。 致电doClick以执行编程式操作更改。
参数
b - 如果选择了按钮，则为true，否则为false


isSelected方法将返回每个复选框的当前状态。如果没有选取则为false，否则为true
当用户点击复选框将触发一个动作事件，通常，可以为复选框设置一个动作监听器。在下面的程序中，两个复选框使用了同一个动作监听器
ActionListener listener=...;
bold.addActionListener(listener);
italic.addActionListener(listener);
actionPerformed方法查询bold和italic两个复选框的状态。并且把面板中的字体设置为常规、加粗、倾斜、或者粗斜体
ActionListener listener=event->{
int mode=0;
if(bold.isSelected())
    mode+=Font.BLOD;
if(italic.isSelected())
    mode+=Font.ITALIC;
label.setFont(new Font(Font.SERIF,mode,FONTSIZE);
Font
public Font(String name,
            int style,
            int size)
从指定的名称，样式和点大小创建一个新的Font 。
字体名称可以是字体名称或字体族名称。 它与风格一起使用以找到适当的字体。 当指定字体系列名称时，样式参数用于选择家庭中最合适的脸部。 指定字体名称时，将合并脸部样式和样式参数，以找到同一系列中匹配最佳的字体。 例如，如果使用样式Font.ITALIC指定面部名称“Arial Bold”，则字体系统会在“Arial”系列中查找粗体和斜体的面部，并可将字体实例与物理字体“Arial Bold Italic”相关联。 。 样式参数与指定的脸部样式合并，不添加或减去。 这意味着，指定粗体和粗体样式不会使字体双倍膨胀，并且指定粗体和纯色样式不会减轻字体。



 */