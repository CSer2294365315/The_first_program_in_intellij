package J_9_3_01;

public class J_9_7_3_fileChooser
{

}
//JFileChooser是一个模式对话框，JFileChooser类不是JDialog类的子类，需要调用shouOpenDialog，而不是setVisible（true）显示打开文件的对话框，或者调用showSaveDialog显式保存文件的对话框。接收文件的按钮被自动的标签为Open或者Save。也可以调用showDialog方法为按钮设定标签
//JFileChooser chooser=new JFileChooser();
//chooser.setCurrentDirectory(new File("."));
/*
setSelectedFile


    public void setSelectedFile(File file)  作为用户选择的默认文件名
设置选中的文件。如果该文件的父目录不是当前目录，则将当前目录更改为该文件的父目录。
        参数：
        file - 选中的文件

如果允许用户在对话框中选择多个文件，需要调用setMultiSelectionEnable
chooser.setMultiSelectionEnable(ture);
如果想让对话框只显示某一种类型的文件，需要设置文件过滤器
在默认情况下，用户在文件选择其中只能选择文件，如果希望选择目录，需要调用setFileSelectionMode的方法。参数值为JFileChooser.FIlES_ONLY(默认值），JFileChooser.DIRECTORIES_ONLY或者JFileChooser.FILES_AND_DIRECTORISE
调用showOpenDialog或者showSaveDialog方法显式对话框。必须为这些调用提供上层组件
int result=chooser.showOpenDialog(parent);
或者
int result=chooser.showSaveDialog(parent);
这两种方法的区别是默认按钮的不同
可以通过showDialog的方法来指定按钮
int result =chooser.showDialog(parent，"selected");
仅当用户确认，取消或者离开对话框时才返回调用。

调用getSelectedFile()或者getSelectedFiles()方法获得用户选择的一个或者多个文件，这些方法将返回一个文件对象或者一组文件对象。如果需要知道文件对象名，可以调用getPath的方法
String fileName=chooser.getSelectedFile().getPath();
使用文件对话框的主要困难在于指定用户需要的文件子集。
要想限制显示的文件，需要创建一个javax.swing.filechooser.FileFilter的对象。文件选择器将每一个文件传给文件过滤器，只有文件过滤器接受的文件才能被显示出来

public boolean accept(File f)
public String getDescription();


showDialog

public int showDialog(Component parent,
                      String approveButtonText)
               throws HeadlessException
弹出具有自定义 approve 按钮的自定义文件选择器对话框。例如，以下代码弹出具有 "Run Application" 按钮（而不是普通的 "Save" 或 "Open" 按钮）的文件选择器：







        */