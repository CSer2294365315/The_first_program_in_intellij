package J_9_3_01;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;


public class ResouceTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
           JFrame frame=new ResourceTestFrame();
           frame.setTitle("ResourceTest...");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
        });
    }
}

class ResourceTestFrame extends JFrame
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=300;

    public ResourceTestFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        URL aboutURL=getClass().getResource("about.gif");
        Image img=new ImageIcon(aboutURL).getImage();
        setIconImage(img);


        JTextArea textArea =new JTextArea();
        InputStream stream=getClass().getResourceAsStream("about.txt");
        try(Scanner in=new Scanner(stream))
        {
            while(in.hasNext())
                textArea.append(in.nextLine()+"\n");
        }
        add(textArea);
    }
}


/*

ImageIcon

public ImageIcon(URL location)
根据指定的 URL 创建一个 ImageIcon。使用 MediaTracker 预载图像以监视图像的加载状态。图标的描述被初始化为 URL 的字符串表示形式。
参数：
location - 图像的 URL


getImage

public Image getImage()
返回此图标的 Image。
返回：
此 ImageIcon 的 Image 对象



setIconImage

public void setIconImage(Image image)
设置要作为此窗口图标显示的图像。
将单个图像指定为窗口的图标时，可以使用此方法代替 setIconImages()。

以下语句：

     setIconImage(image);

等价于：
     ArrayList imageList = new ArrayList();
     imageList.add(image);
     setIconImages(imageList);

注：根据上下文的不同（例如，窗口装饰、窗口列表、任务栏等），本机窗口系统可以使用不同尺寸的不同图像表示一个窗口。也可以对所有上下文使用一个图像，或者根本不用图像。

覆盖：
类 Frame 中的 setIconImage
参数：
image - 要显示的图标图像。



setProperty

public static String setProperty(String key,
                                 String value)
设置指定键指示的系统属性。
首先，如果安全管理器存在，则通过 PropertyPermission(key, "write") 权限调用其 SecurityManager.checkPermission 方法。这可能导致抛出 SecurityException。如果没有抛出异常，则将指定属性设置为给定值。

参数：
key - 系统属性的名称。
value - 系统属性的值。
返回：
系统属性以前的值，如果没有以前的值，则返回 null。
抛出：
SecurityException - 如果安全管理器存在并且其 checkPermission 方法不允许设置指定属性。
NullPointerException - 如果 key 或 value 为 null。
IllegalArgumentException - 如果 key 为空。



setProperty

public static String setProperty(String key,
                                 String value)
设置指定键指示的系统属性。
首先，如果安全管理器存在，则通过 PropertyPermission(key, "write") 权限调用其 SecurityManager.checkPermission 方法。这可能导致抛出 SecurityException。如果没有抛出异常，则将指定属性设置为给定值。

参数：
key - 系统属性的名称。
value - 系统属性的值。
返回：
系统属性以前的值，如果没有以前的值，则返回 null。
抛出：
SecurityException - 如果安全管理器存在并且其 checkPermission 方法不允许设置指定属性。
NullPointerException - 如果 key 或 value 为 null。
IllegalArgumentException - 如果 key 为空。


应用首选项的存储
属性映射：（property map）是一种存储键值对的数据结构，属性映射通常用来存储配置信息。
1、键和值是字符串
2、映射可以很容易的存入文件以及从文件中加载
3、有一个二级表保存默认值
实现属性映射的java类名为Properies
属性映射对于制定程序的配置选项很有用。
Properties settings=new Properties();
settings.setProperty("width","200");
settings.setProperty("title","hello,world")
可以使用store方法将属性映射列表保存到一个文件中。在这里，我们将属性映射保存在文件program.properties中。第二个参数是包含在这个文件中的注释
OutputStream out=new FileOutputStream("program.properties");

保存属性列表的首选方法是通过 store(OutputStream out, String comments) 方法或 storeToXML(OutputStream os, String comment) 方法来进行。



FileOutputStream

public FileOutputStream(File file)
                 throws FileNotFoundException
创建一个向指定 File 对象表示的文件中写入数据的文件输出流。创建一个新 FileDescriptor 对象来表示此文件连接。
首先，如果有安全管理器，则用 file 参数表示的路径作为参数来调用 checkWrite 方法。

如果该文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；抑或因为其他某些原因而无法打开，则抛出 FileNotFoundException。

参数：
file - 为了进行写入而打开的文件。
settings.store(out,"Program Properties");

这个示例会给出以下输出：



 */