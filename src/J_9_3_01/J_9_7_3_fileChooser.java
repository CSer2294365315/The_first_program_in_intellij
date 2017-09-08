
package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

public class J_9_7_3_fileChooser
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new ImageViewerFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("文件选择器测试...");
        });
    }
}

class ImageViewerFrame extends JFrame
{
    private static final int DEFAULT_WIDTH=400;
    private static final int DEFAULT_HEIGHT=300;
    private JFileChooser chooser;
    private JLabel label;

    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu=new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem=new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event->
        {
            chooser.setCurrentDirectory(new File("."));
            int result=chooser.showOpenDialog(ImageViewerFrame.this);

            if(result==JFileChooser.APPROVE_OPTION)
            {
                String name=chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
        JMenuItem exitItem=new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event->System.exit(0));

        label=new JLabel();
        add(label);

        chooser=new JFileChooser();

     //  FileNameExtensionFilter filter=new FileNameExtensionFilter("Image files","jpg","jpeg","gif");???
        chooser.setFileFilter(new FileNameExtensionFilter("Image files","jpg","jpeg","gif"));
        chooser.setAccessory(new ImagePreviewer(chooser));

        chooser.setFileView(new FileIconView(new FileNameExtensionFilter("Image files","jpg","jpeg","gif"),new ImageIcon()));

    }
}

class ImagePreviewer extends JLabel
{
    public ImagePreviewer(JFileChooser chooser)
    {
        setPreferredSize(new Dimension(100,100));
        setBorder(BorderFactory.createEtchedBorder());

        chooser.addPropertyChangeListener(event->
        {
           if(event.getPropertyName()==JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
            {
                File f=(File)event.getNewValue();
                if(f==null)
                {
                    setIcon(null);
                    return;
                }

                ImageIcon icon=new ImageIcon(f.getPath());

                if(icon.getIconWidth()>this.getWidth())
                    icon=new ImageIcon(icon.getImage().getScaledInstance(getWidth(),-1,Image.SCALE_DEFAULT));
                setIcon(icon);
            }
        });
    }
}


class FileIconView extends FileView
{
    private FileFilter filter;
    private Icon icon ;
    public FileIconView(FileFilter aFilter,Icon anIcon)
    {
        filter=aFilter;
         icon=anIcon;
    }

    public Icon getIcon(File f)
    {
        if(!f.isDirectory()&&filter.accept(f))
            return icon;
        else
            return null;
    }


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


setFileFilter

public void setFileFilter(FileFilter filter)
设置当前文件过滤器。文件选择器使用文件过滤器从用户的视图中过滤文件。
参数：
filter - 要使用的新的当前文件过滤器



FileNameExtensionFilter

public FileNameExtensionFilter(String description,
                               String... extensions)
使用指定的描述和文件扩展名创建一个 FileNameExtensionFilter。返回的 FileNameExtensionFilter 将接受所有的目录和所有带有 extensions 中所包含的文件扩展名的文件。
参数：
description - 过滤器的文本描述，可以为 null
extensions - 接受的文件扩展名

如果想禁止使用All files过滤器，需要调用
chooser.setAcceptAllFileFilterUsed(false);
如果想要加载和保存不同类型的文件使用同一文件选择器，用chooser.resetChoosableFilters();再添加新文件过滤器之前清楚就的文件过滤器



SELECTED_FILE_CHANGED_PROPERTY

public static final String SELECTED_FILE_CHANGED_PROPERTY
标识用户单个文件选择的更改。



getNewValue

public Object getNewValue()
获得已更改属性的新值。
返回：
包含属性新值的 Object。



showOpenDialog

public int showOpenDialog(Component parent)
                   throws HeadlessException
弹出一个 "Open File" 文件选择器对话框。注意，approve 按钮上显示的文本由 L&F 决定。
参数：
parent - 该对话框的父组件，可以为 null；详情请参阅 showDialog
返回：
该文件选择器被弹下时的返回状态：
JFileChooser.CANCEL_OPTION
JFileChooser.APPROVE_OPTION
JFileChooser.ERROR_OPTION 如果发生错误或者该对话框已被解除



setAccessory

public void setAccessory(JComponent newAccessory)
设置 accessory 组件。accessory 通常用于显示已选中文件的预览图像；可按程序员的要求将其用来显示任何内容，如额外的自定义文件选择器控件。
注：如果有以前使用的 accessory，则应该取消注册该 accessory 已向文件选择器所注册的所有侦听器。


ImageIcon

public ImageIcon()
创建一个未初始化的图像图标。
方法详细信息
loadImage

protected void loadImage(Image image)
加载图像，并且只在图像已加载时返回。
参数：
image - 图像
        */