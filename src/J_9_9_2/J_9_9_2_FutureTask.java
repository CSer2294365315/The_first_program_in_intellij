package J_9_9_2;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class J_9_9_2_FutureTask
{
    public static void main(String [] args)
    {
        try(Scanner in =new Scanner(System.in))
        {
            System.out.println("输入目录地址：");
            String directory_String=in.nextLine();
            System.out.println("输入关键字：");
            String keyword_String=in.nextLine();

            MatchCounter counter=new MatchCounter(new File(directory_String),keyword);
            FutureTask<Integer> task=new FutureTask<>(counter);
            Thread t=new Thread(task);
            t.start();

            try
            {
                System.out.println(task.get()+" matching files");
            }
            catch(ExecutionException e)
            {
                e.printStackTrace();
            }
            catch(InterruptedException e)
            {

            }

        }
    }

}

class MatchCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;

    /**
     * 构造一个MatchCounter
     */
    public MatchCounter (File directory,String keyword)
    {
        this.directory=directory;
        this.keyword=keyword;
    }

    public Integer call()
    {
        int count=0;
        try
        {
            File[] files=directory.listFiles();
            List<Future<Integer>> results=new ArrayList<>();

            for(File file :files)
            {
                if(file.isDirectory())
                {
                    MatchCounter counter=new MatchCounter(file,keyword);
                    
                    FutureTask<Integer> task=new FutureTask<Integer>(counter);
                }
            }
        }
    }
}
