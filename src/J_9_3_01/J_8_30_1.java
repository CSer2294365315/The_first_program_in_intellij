/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.awt.Component;
import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author cmx
 */


 public class J_8_30_1
 {
    public static void main(String[] args)
    {
        new Block()
        {
            public void body()  throws Exception
            {
                Scanner in=new Scanner(new File("q"),"UTF-8");
                while(in.hasNext())
                    System.out.println(in.next());
            }
        }.toThread().start();
    }
     public static abstract class Block
     {
    public  abstract void body() throws Exception;
 
    public Thread toThread()
    {
        return new Thread()    //匿名类
        {
           public void run()
            {
                try
                {
                    body();
                }
                catch(Throwable t)
                {
                    Block.<RuntimeException>throwAs(t);
                }
            }
        };
    }
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T
    {
        throw (T) e;
    }
 }
 }


