/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;
import java.util.*;

public class J_8_31_2 
{
    public static void main(String[] args)
    {
        List<String> a=new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        
        List<String> b=new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        
        ListIterator<String> aIter=a.listIterator();
        Iterator<String> bIter=b.iterator();
        
        while(bIter.hasNext())
        {
            if(aIter.hasNext())
            {
                aIter.next();
            }
            aIter.add(bIter.next());    //注意，将b插入a，a改变，b没有变，但是a与b的迭代器都变了，可以通过重新初始化迭代器来返回列表的开始
        }
        
        System.out.println(a);
        System.out.println(b);
        System.out.println("aIter p is : "+aIter.previous());
     //   System.out.println("bIter p is :"+bIter.next());
        
        bIter=b.iterator();
     //   System.out.println(bIter.next());
        System.out.println("After change b=="+b);
        System.out.println("After change a=="+a);
        
        while(bIter.hasNext())
        {
            bIter.next();
            if(bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println("helo,the b is : "+b);
        
        a.removeAll(b);
        
        System.out.println(a);
        System.out.println(b);
        
     //   aIter.previous();
        System.out.println("==========");
        aIter.previous();
       System.out.println(aIter.next());
    }
    
}
