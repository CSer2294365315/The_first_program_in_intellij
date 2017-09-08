package resource;
import java.awt.*;
import java.util.*;
import javax.swing.*;

class BallComponent extends JPanel
{
    private static final int DEFAULT_WIDTH=450;
    private static final int DEFAULT_HEIGHT=350;

    private java.util.List<Ball> balls=new ArrayList<Ball>();

    /**
     * add a ball to component
     * @param b the ball to add
     */
    public void add(Ball b)
    {
        balls.add(b);   //为list增加b
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        for(Ball b:balls)
        {
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}



/*

paintComponent

protected void paintComponent(Graphics g)
如果 UI 委托为非 null，则调用该 UI 委托的 paint 方法。向该委托传递 Graphics 对象的副本，以保护其余的 paint 代码免遭不可取消的更改（例如 Graphics.translate）。
如果在子类中重写此方法，则不应该对传入的 Graphics 进行永久更改。例如，不应更改剪贴区的 Rectangle 或修改转换。如果需要进行这些操作，您会发现根据传入的 Graphics 创建一个新 Graphics 并进行操作更加方便。另外，如果不调用超类的实现，则必须遵守不透明属性，也就是说，如果此组件是不透明的，则必须以透明的颜色完全填充背景。如果不遵守不透明属性，则很可能看到可视的人为内容。

传入的 Graphics 对象可能安装了恒等转换以外的转换。在这种情况下，如果多次应用其他转换，则可能得到不可预料的结果。

参数：
g - 要保护的 Graphics 对象



paintComponent

protected void paintComponent(Graphics g)
绘制此 Filler。如果此 Filler 具有一个 UI，则此方法调用 super 的实现，否则，如果此 Filler 是不透明的，则使用背景填充 Graphics。
覆盖：
类 JComponent 中的 paintComponent
参数：
g - 要绘制的 Graphics
抛出：


 */

