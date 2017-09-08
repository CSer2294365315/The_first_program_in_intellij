package J_9_8_3_MultiThread_Ball_可run代码;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;


public class J_9_8_3_MultiThread_ball_class
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * The frame with panel buttons
 */
class BounceFrame extends JFrame
{
    private BallComponent comp;
    public static final int STEPS=10000;
    public static final int DELAY=5;

    /**
     * Construct the frame with the component for showing the bouncing ball and Start and Close buttons
     */
    public BounceFrame()
    {
        comp=new BallComponent();
        add(comp,BorderLayout.CENTER);
        JPanel buttonPanel=new JPanel();
        addButton(buttonPanel,"Start.这是启动按钮",event->addBall());
        addButton(buttonPanel,"Close,这是关闭按钮",enent->System.exit(0));
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container
     * @param c the container
     * @param title the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c,String title ,ActionListener listener)
    {
        JButton button=new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the canvas and starts a threat to make it bounce
     */
    public void addBall()
    {
        Ball ball=new Ball();
        comp.add(ball);
        Runnable r=()->{
            try
            {
                for(int i=1;i<STEPS;++i)
                {
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY);
                }
            }
            catch(InterruptedException e)
            {

            }
        };
        Thread t=new Thread(r);
        t.start();
    }
}

/**
 * BallComponent
 */
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


/**
 * Ball
 */
class Ball
{
    private static final int XSIZE=15;
    private static final int YSIZE=15;

    private double x=0;
    private double y=0;

    private double dx=1;
    private double dy=1;

    /**
     * Moves the ball to the next position,reversing direction if it hits one of the edges
     */

    public void move(Rectangle2D bounds)
    {
        x+=dx;
        y+=dy;
        if(x<bounds.getMinX())
        {
            x=bounds.getMinX();
            dx=-dx;
        }
        if(x+XSIZE>=bounds.getMaxX())
        {
            x=bounds.getMaxX()-XSIZE;
            dx=-dx;
        }
        if(y<bounds.getMinY())
        {
            y=bounds.getMinY();
            dy=-dy;
        }
        if(y+YSIZE>=bounds.getMaxY())
        {
            y=bounds.getMaxY()-YSIZE;
            dy=-dy;
        }
    }

    /**
     * Gets the shape of the ball at its current position
     */
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }
}











/*
实际上可以将移动球防止在一个单独的线程中，运行这段代码可以提高提案跳球的响应能力。实际上，可以发起多个球，每个球都在自己的线程中运行，另外，AWT的事件分派线程将一直并行运行，以处理用户界面的事件。由于每个线程都有机会得以运行，所以在弹跳期间，当用户点击Close按钮时，事件调度线程将有机会关注到这个事件，并处理关闭这一动作
这里用球弹跳代码作为示例，让大家对兵法处理有一个视觉印象。通常，人们总会提防长时间的运算。这个计算很可能是某个大框架的一个组成部分，例如，GUI或者web框架，无论何时框架调用自身的方法都会很快的返回一个异常。如果需要执行一个比较耗时的任务。应当并发的运行任务。

下面是在一个单独的线程中执行一个任务的简单过程
1）将任务代码移到实现了Runnable接口的类的run方法中。这个接口非常简单，只有一个方法：
    public interface Runnable
    {
        void run();
    }
 由于Runnable是一个函数式接口，可以用lambda表达式建立一个实例
 Runnable r=()->
 {
   // task code;
 }
 2)由Runnable创建一个Thread对象
 Thread t=new Thread(r);
 3)启动线程
 t.start();
 要想将弹跳球代码放在一个独立的线程中，只需要实现一个类BallRunnable，然后，将动画代码放在run方法中，如同下面这段代码
 Runnable r=()->
 {
    try
    {
        for(int i=1;i<=STEPS;++i)
        {
            ball.move(comp.getBounds());
            comp.repaint();
            Thread.sleep(DELAY);
         }
     }
     catch(InterruptedException e)
     {}
 };
 Thread t=new Thread(r);
 t.start();
 同样的，需要捕获sleep方法可能抛出的异常InterruptedException。下一节将讨论这个异常。在一般情况下，线程在中断时被终止。因此，当发生InterruptedException异常时，run方法将结束执行。
 无论何时点击start按钮，球会移入一个新的线程中。
 仅此而已，现在应该知道如何并行运行多个任务了，本章剩余部分将阐述如何控制线程之间的交互。
 也可以通过构建一个Thread类的子类定义一个线程，如下图所示：
 class MyThread extends Thread
 {
    public void run()
    {
        task code
    }
 }
 然后，构造一个子类的对象，并调用start方法，不过，这种方法已经不再推荐。应该将要并行运行的任务与运行机制相耦合。如果有很多任务，要为每个任务创建一个独立的线程付出的代价太大了。可以使用线程池来解决这个问题。
 不要调用Thread类或者Runnable对象的run方法。直接调用run方法，只会执行同一个线程中的任务，而不会启动新线程。应该调用Thread.start方法。这个方法将创建一个执行run方法的新线程。









 */

/*
Thread

public Thread(Runnable target)
分配新的 Thread 对象。这种构造方法与 Thread(null, target, gname ) 具有相同的作用，其中的 gname 是一个新生成的名称。自动生成的名称的形式为 “Thread-”+ n，其中的 n 为整数。
参数：
target - 其 run 方法被调用的对象。



public class Thread


      extends
      Object




      implements
      Runnable

线程 是程序中的执行线程。Java 虚拟机允许应用程序并发地运行多个执行线程。

每个线程都有一个优先级，高优先级线程的执行优先于低优先级线程。每个线程都可以或不可以标记为一个守护程序。当某个线程中运行的代码创建一个新 Thread 对象时，该新线程的初始优先级被设定为创建线程的优先级，并且当且仅当创建线程是守护线程时，新线程才是守护程序。

当 Java 虚拟机启动时，通常都会有单个非守护线程（它通常会调用某个指定类的 main 方法）。Java 虚拟机会继续执行线程，直到下列任一情况出现时为止：

调用了 Runtime 类的 exit 方法，并且安全管理器允许退出操作发生。
非守护线程的所有线程都已停止运行，无论是通过从对 run 方法的调用中返回，还是通过抛出一个传播到 run 方法之外的异常。
创建新执行线程有两种方法。一种方法是将类声明为 Thread 的子类。该子类应重写 Thread 类的 run 方法。接下来可以分配并启动该子类的实例。例如，计算大于某一规定值的质数的线程可以写成：



 */