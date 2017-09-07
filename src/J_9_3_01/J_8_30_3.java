/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cmx
 */
public class J_8_30_3 
{
    public static void main(String[] args)
    {
        Collection<String> c=new ArrayList<>();
        c.add("hello");
        c.add("well");
        c.add("good");
        Collection<String> d=new ArrayList<>();
        d.add("hello");
        d.toArray();
        c.retainAll(d);
        for(String e:c)
        {
            System.out.println(e);
            
        }
        for(String e:d)
        {
            System.out.println(e);
            
        }
        Iterator a=d.iterator();
        String s=a.next().toString();
        System.out.println("3+"+s);
        
       /*
        
        
        c.toArray();
        String[] a;
         System.out.println("hello=========="+c);
         c.toArray();
         System.out.println("hello=========="+c);
        Iterator<String> iter=c.iterator();
        
        System.out.println();
        
        while(iter.hasNext())
        {
            String element=iter.next();
            System.out.println(element);
        }
        
        
        for(String e:c)
        {
            System.out.println(e);
            
        }
        System.out.println("=========");
        c.iterator().forEachRemaining((e)->{
            System.out.println();
        });
        
    //    c.iterator().forEachRemaining(e->{System.out.println(e)});
*/
        
        
    }
    
}
