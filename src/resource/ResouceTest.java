package resource;
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


 */