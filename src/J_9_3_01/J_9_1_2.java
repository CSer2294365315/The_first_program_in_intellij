/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author cmx
 */
public class J_9_1_2 
{
    public static void main(String[] args)
    {
        Map<String,Employee_61> staff=new HashMap<>();
        staff.put("144-25", new Employee_61("well"));
        staff.put("567-24", new Employee_61("hello"));
        staff.put("157-62", new Employee_61("good"));
        staff.put("456-62", new Employee_61("thanks"));
        Iterator<String> a=staff.keySet().iterator();
        while(a.hasNext())
                System.out.println(a.next());
        
         System.out.println("============");
        LinkedHashMap<String,Employee_61> staff2=new LinkedHashMap<>();
        
        staff2.put("144-25", new Employee_61("well"));
        staff2.put("567-24", new Employee_61("hello"));
        staff2.put("157-62", new Employee_61("good"));
        staff2.put("456-62", new Employee_61("thanks"));
        Iterator<String> a2=staff2.keySet().iterator();
        while(a2.hasNext())
                System.out.println(a2.next());
        Map<String,Employee_62>  cache =new  LinkedHashMap<>(128,0.75,true)
	{
		public boolean removeEldestEntry(Map.Entry<String,Employee_62> eldest)
		{
			return size()>100;
		}
	};
        
    }
    
}
class Employee_62 
{
    private String name;
    public  Employee_62(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}
