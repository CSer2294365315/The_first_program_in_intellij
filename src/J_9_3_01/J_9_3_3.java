/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;



import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author cmx
 */
public class J_9_3_3
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new MouseFrame();
            frame.setTitle("鼠标点击测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });
    }

}

class MouseFrame  extends JFrame
{
    public MouseFrame()
    {
        add(new MouseComponent());
        pack();

    }
}

class MouseComponent extends JComponent 
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;  //边界长度
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());


    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Rectangle2D r : squares) {
            g2.draw(r);
        }
    }

    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares)
            if (r.contains(p))
                return r;
        return null;
    }

    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s) {
        if (s == null)
            return;
        if (s == current)
            current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            current = find(event.getPoint());
            if (current == null)
                add(event.getPoint());   //?
        }
    }

    public void mouseClicked(MouseEvent event) {
        current = find(event.getPoint());
        if (current != null && event.getClickCount() >= 2)
            remove(current);
    }

    private class MouseMotionHandler implements MouseMotionListener {
        public void mouseMoved(MouseEvent event) {
            if (find(event.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }


        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x = event.getX();
                int y = event.getY();

                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }
}

