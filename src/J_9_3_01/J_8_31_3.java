/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;
import java.util.*;
/**

Iterator可用来遍历Set和List集合，但是ListIterator只能用来遍历List。 
Iterator对集合只能是前向遍历，ListIterator既可以前向也可以后向。 
ListIterator实现了Iterator接口，并包含其他的功能，比如：增加元素，替换元素，获取前一个和后一个元素的索引，等等。
 * @author cmx
 */
public class J_8_31_3 
{
    public static void main(String[] args)
    {
        Set<String> words=new HashSet<>();
        long totalTime=0;
        try(Scanner in=new Scanner(System.in))
        {
            int j=0;
            while(in.hasNext())
            {
                String word=in.next();
                ++i;
                
                long callTime =System.currentTimeMillis();
                words.add(word);
                callTime=System.currentTimeMillis()-callTime;
                totalTime+=callTime;
                if(j>5)
                    break;
                
            }
        }
        
        Iterator<String> iter=words.iterator();
        for(int i=0;i<20 &&iter.hasNext();++i)
        {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size()+"distinct words "+totalTime+" milliseconds.");
        
        
    }
    
    
}
