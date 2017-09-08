package resource;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class J_9_8_2_Single_Thread_Ball
{
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("这是一个单线程ball测试..");
        });
    }



    /**
     * Adds a bouncing ball to the panel and makes it bounce 1000 times
     */


}

   class BounceFrame extends JFrame
    {
        private BallComponent comp;
        public static final int STEPS=10000;
        public static final int DELAY=3;

        /**
         * Constructs the frame with the component for showing the bouncing ball and Start and Close buttons
         */

        public BounceFrame()
        {
            setTitle("Bounce...");
            comp=new BallComponent();
            add(comp,BorderLayout.CENTER);
            JPanel buttonPanel=new JPanel();
            addButton(buttonPanel,"Start",event->addBall());
            addButton(buttonPanel,"Close",event->System.exit(0));
            add(buttonPanel,BorderLayout.SOUTH);
            pack();
        }

        public void addBall() {
            try {
                Ball ball = new Ball();
                comp.add(ball);

                for (int i = 1; i <= STEPS; i++) {
                    System.out.println(i);

                    ball.move(comp.getBounds());
                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }

            } catch (InterruptedException e) {

            }
        }

        public void addButton(Container c, String title, ActionListener listener) {
            JButton button = new JButton(title);
            c.add(button);
            button.addActionListener(listener);
        }
    }





/*

getBounds

Rectangle getBounds()
返回一个完全包围 Shape 的整型 Rectangle。注意，不保证返回的 Rectangle 是包围 Shape 的最小边界框，只保证 Shape 完全位于指示的 Rectangle 中。如果 Shape 超出了整数数据类型的有效范围，则返回的 Rectangle 也可能不完全包围 Shape。 getBounds2D 方法由于在表示形式上具有更大的灵活性，所以通常返回更紧密的边界框。
返回：
完全包围 Shape 的整型 Rectangle



getGraphics

public Graphics getGraphics()
为组件创建一个图形上下文。如果组件当前是不可显示的，则此方法返回 null。
返回：
组件的图形上下文，如果其没有，则返回 null
从以下版本开始：
 */
