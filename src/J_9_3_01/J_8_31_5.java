/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 *
 * @author cmx
 */
public class J_8_31_5 
{
    public static void main(String[] args)
    {
         PriorityQueue<LocalDate> pq=new PriorityQueue<>();
         pq.add(LocalDate.of(2005, 1, 1));
         pq.add(LocalDate.of(2003, 1, 1));
         pq.add(LocalDate.of(2002, 1, 1));
         pq.add(LocalDate.of(2001,1,1));
         System.out.println("iterating over a elements");
         for(LocalDate a:pq)
             System.out.println(a);
         System.out.println("Removing element...");
         while(!pq.isEmpty())
             System.out.println(pq.remove());
    }
}

