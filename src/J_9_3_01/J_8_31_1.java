/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author cmx
 */
public class J_8_31_1 
{
    public static void main(String[] args)
    {
        LinkedList<String> list=new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ListIterator list3=list.listIterator(0);
        String get3=list.get(1);
        list3.next();
        String test_2_move=list3.next().toString();
        System.out.println("what >       "+test_2_move);
        list3.set("hhhhh");
        System.out.println(list.toString());
        
        list.listIterator(0);
       int i =list.listIterator(0).nextIndex();
        String a=list.get(0);
        System.out.println(a);
        String b=list.listIterator(1).previous();
        System.out.println(b);
        System.out.println(i);
        ListIterator<String>  list1=list.listIterator(1);
        String c=list1.next();
        System.out.println(c);
        
    }
    
}
/**
 * 
run:
what >       b
[a, hhhhh, c]
a
a
0
hhhhh
成功构建 (总时间: 0 秒)


 */