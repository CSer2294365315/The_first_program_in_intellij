/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.util.*;

/**
 *
 * @author cmx
 */
public class J_8_31_6_map 
{
    public static void main(String[] args)
    {
        Map<String,Employee_61> staff=new HashMap<>();
        staff.put("1", new Employee_61("well"));
        staff.put("2", new Employee_61("hello"));
        staff.put("3", new Employee_61("good"));
        staff.put("4", new Employee_61("thanks"));
        
        Set<String> kys=staff.keySet();
        Collection<Employee_61> em=staff.values();
        Set<Map.Entry<String,Employee_61>> vie=staff.entrySet();
        for(String a:kys)
        {
            System.out.println(a);
        }
        for(Employee_61 b:em)
        {
            System.out.println(b.getName());
        }
        for(Map.Entry<String,Employee_61> v:vie)
        {
            System.out.println(v);
        }
        staff.forEach((a,b)->System.out.println("a=  "+a+"  b=  "+b));
        
        
        
        
        /*
        
        System.out.println(staff+"______1");
        
        staff.remove("1");
         System.out.println(staff+"______2");
        
        staff.put("5", new Employee_61("oo"));
         System.out.println(staff+"______3");
        
        System.out.println(staff.get("1"));
        
        staff.forEach((x,y)->System.out.println(staff.get(x)));
         System.out.println(staff+"______4");
*/
    }
    
}
class Employee_61 
{
    private String name;
    public  Employee_61(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}