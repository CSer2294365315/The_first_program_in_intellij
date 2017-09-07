/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;


public class J_8_30_2 
{
    public static void main(String[] args)
    {
        Manager ceo=new Manager("hello",80);
        Manager cfo=new Manager("well",10);
        Pair1<Manager> buddies=new Pair1<>(ceo,cfo);
        printBuddies(buddies);
        
        ceo.setBonus(100000);
        cfo.setBonus(1);
        
        Manager[] managers={ceo,cfo};
        
        Pair1<Employee> result=new Pair1<>();
        minmaxBonus(managers,result);
        
        System.out.println("first: "+result.getFirst().getName()+" second: "+result.getSecond().getName());
        maxminBonus(managers,result);
         System.out.println("first: "+result.getFirst().getName()+" second: "+result.getSecond().getName());
        
        
    }
    public static void printBuddies(Pair1 <? extends Employee>  p)
    {
        Employee first=p.getFirst();
        Employee second =p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" is buddies");
        
    }
    
    public static void minmaxBonus(Manager[] a,Pair1<? super Manager> result)
    {
        Manager min=a[0];
        Manager max=a[0];
        for(int i=0;i<a.length;++i)
        {
            if(a[i].getBonus()<min.getBonus())
                min=a[i];
            if(a[i].getBonus()>max.getBonus())
                max=a[i];
            result.setFirst(min);
            result.setSecond(max);
            
        }
    }
    
    public static void maxminBonus(Manager[] a,Pair1<? super Manager> result)
    {
        minmaxBonus(a,result);
        PairAlg.swap(result);   //?
    }
    
    
    
    
}
class PairAlg
{
    public static boolean hasNull(Pair1<?> p)
    {
        return p.getFirst()==null || p.getSecond()==null;
    }
    
    public static void swap(Pair1<?> p)
    {
        swapHelper(p);
    }
    public static <T> void swapHelper(Pair1<T> p)
    {
        T t=p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
    
}
        
        
        
class Employee 
{
    private double salary;
    private String name;
    private double bonus;
   
    public Employee(String name,double salary)
    {
        this.name=name;
        this.salary=salary;
      
        this.bonus=0;
    }
    public double getSalary()
    {
        return salary;
    }
    public String getName()
    {
        return name;
    }
    public double getBonus()
    {
        return bonus;
    }
    public void setBonus(double bonus)
    {
        this.bonus=bonus;
    }
}
class Manager extends Employee
{
    public Manager(String name,double salary)
    {
        super(name,salary);
       
    }
    public void setBonus(double bonus)
    {
        super.setBonus(bonus);
        
    }
            
}
class Pair1<T>
{
    private T first;
    private T second;
    public Pair1()
    {
        
    }
    public Pair1(T first,T second)
    {
        this.first=first;
        this.second=second;
    }
    public void setFirst(T t)
    {
        this.first=t;
    }
    public void setSecond(T t)
    {
        this.second=t;
    }
    
    public T getFirst()
    {
        return  first;
    }
    public T getSecond()
    {
        return second;
    }   
}

