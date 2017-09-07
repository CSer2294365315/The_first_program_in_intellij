/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.util.EnumSet;

/**
 *
 * @author cmx
 */

public class J_9_1_1 
{
   
    public static void main(String[] args)
    {
       EnumSet<WeekDay1> always=EnumSet.allOf( WeekDay1.class);
       EnumSet<WeekDay1> never=EnumSet.noneOf(WeekDay1.class);
       EnumSet<WeekDay1> workday=EnumSet.range(WeekDay1.Mom, WeekDay1.Sun);
       EnumSet<WeekDay1> mwf=EnumSet.of(WeekDay1.Mom,WeekDay1.Fri,WeekDay1.Sat);
       System.out.println(always.toArray());
       
       
        
    }
    
}
 enum WeekDay1 {Mom,Tus,Wed,Thu,Fri,Sat,Sun};
