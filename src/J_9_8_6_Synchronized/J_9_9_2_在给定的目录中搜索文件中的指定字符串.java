package J_9_8_6_Synchronized;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class J_9_9_2_在给定的目录中搜索文件中的指定字符串
{
    private static final int FILE_QUEUE_SIZE=10;
    private static final int SEARCH_THREADS=100;
    private static final File DUMMY=new File("");
    private static BlockingQueue<File> queue=new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args)
    {
        try(Scanner in=new Scanner(System.in))
        {
            System.out.print("Enter base directory(输入一些东西): ");
            String directory_String=in.nextLine();
            System.out.print("Enter keyword (输入一些东西2？）");
            String keyword=in.nextLine();

            /**
             * 将给定文件中的所有文件放在队列中，在队尾放一个空文件（不是null）
             */
            Runnable enumerator=()->{
                try
                {
                    enumerate(new File(directory_String));                 // 线程1中的核心代码
                    queue.put(DUMMY);
                }
                catch(InterruptedException e)
                {

                }
            };
            new Thread(enumerator).start();

            /**
             * 搜索线程，用来启动搜索方法，每一个线程从队列中取出一个文件，并且检测是否为队尾，如果为队尾，停止搜索
             */
            for(int i=1;i<=SEARCH_THREADS;++i)
            {
                Runnable searcher=()->
                {
                    try
                    {
                        boolean done =false;
                        while(!done)
                        {
                            File file=queue.take();         //从队中取出文件
                            if(file==DUMMY)     //检测队尾
                            {
                                queue.put(file);
                                done=true;
                            }
                            else
                                search(file,keyword);
                        }
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch(InterruptedException e)
                    {

                    }
                };
                new Thread(searcher).start();
            }
        }
    }


    /**
     * Recurively enumerates all files in a given directory and its subdirectories
     * @param directory_String the directroy in which to start
     * enumerate 将目录中的所有文件提取出来，放在队列中
     */
    public static void enumerate(File directory_String) throws InterruptedException

    {
        File[] files=directory_String.listFiles();
        for(File f:files)
        {
            if(f.isDirectory())
                enumerate(f);
            else
                queue.put(f);
        }
    }

    /**
     * Searches a file for a given keyword and prints all matching lines
     * @param file the file to search
     * @param keyword the keyword to search for
     * 在单个文件中搜索关键字
     */
    public static void search(File file,String keyword) throws IOException
    {
        try(Scanner in=new Scanner(file,"UTF-8"))
        {
            int lineNumber=0;
            while(in.hasNextLine())
            {
                lineNumber++;
                String line=in.nextLine();
                if(line.contains(keyword))
                    System.out.printf("%s : %d : %s\n",file.getPath(),lineNumber,line);
            }
        }
    }

}












/*

listFiles

public File[] listFiles()
返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
如果此抽象路径名不表示一个目录，那么此方法将返回 null。否则返回一个 File 对象数组，每个数组元素对应目录中的每个文件或目录。表示目录本身及其父目录的名称不包括在结果中。得到的每个抽象路径名都是根据此抽象路径名，使用 File(File, String) 构造方法构造的。所以，如果此路径名是绝对路径名，那么得到的每个路径名都是绝对路径名；如果此路径名是相对路径名，那么得到的每个路径名都是相对于同一目录的路径名。

不保证所得数组中的相同字符串将以特定顺序出现，特别是不保证它们按字母顺序出现。

返回：
抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件和目录。如果目录为空，那么数组也将为空。如果抽象路径名不表示一个目录，或者发生 I/O 错误，则返回 null。
抛出：
SecurityException - 如果存在安全管理器，且其 SecurityManager.checkRead(java.lang.String) 方法拒绝对目录进行读访问




 */


