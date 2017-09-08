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
public class J_8_31_4
{
    public static void main(String[] args)
    {
        SortedSet<Item> parts=new TreeSet<>();
        parts.add(new Item("Modem",9912));
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);
        
        NavigableSet<Item> sortByDescription=new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
        
    }
}
class Item implements Comparable<Item>
{
    private String description;
    private int partNumber ;
    public Item(String description,int partNumber)
    {
        this.description=description;
        this.partNumber=partNumber;
    }
    public String getDescription()
    {
        return description;
    }
    public String toString()
    {
        return "[description="+description+",partNumber="+partNumber;
    }
    public boolean equals(Object otherItem)
    {
        if(this==otherItem)
            return true;
        if(otherItem==null)
            return false;
        if(this.getClass()!=otherItem.getClass())
            return false;
        Item other=(Item) otherItem;   //?  类不是已经相等了吗？为什么还需要转换？
        return Objects.equals(this.description, other.description) && this.partNumber==other.partNumber;
            
    }
    public int hashCode()
    {
        return Objects.hash(description,partNumber);
        
    }
    public int compareTo(Item other)
    {
        int diff=Integer.compare(this.partNumber, other.partNumber);
        return diff!=0? diff : description.compareTo(other.description);
    }
    
}