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


线程安全的集合
如果多线程要兵法的修改一个数据结构，例如散列表，那么很容易的破坏这个数据结构，例如：一个线程可能要开始向表中插入一个新元素，假定在调整散列表各个桶之间的连接关系的过程中，被剥夺了控制权，如果另外一个线程也开始便利同一个链表，可能使用无效的链接并造成混乱，可能抛出异常并陷入无限循环

可以通过提供锁来保护共享数据结构，但是选择线程安全的实现作为替代可能会更容易一些。当然，前一节讨论的阻塞队列就是线程安全的集合。下面将讨论java类库提供的另外一些线程安全的集合

高效的映射、集、和队列

java.util.concurrent包提供了包括映射、有序集、和队列的高效实现：ConcurrentHashMap、ConcurrentSkipListMap、ConcurrentSkipListSet和ConcurrentLinkedQueue
这些集合使用复杂的算法，通过允许并发的访问数据结构的不同部分来时竞争极小化
与大多集合不同，size方法不必在常量时间内操作。确定这样的集合当前的大小通常需要遍历
集合返回弱一致性（weakly consistent)的迭代器，这意味着迭代器不一定能反映出他们被构造之后的所有修改，但是，他们不会将同一个值返回两次，也不会抛出ConcurrentModificationException
与之形成对照的是，集合如果在迭代器构造之后发生改变，java.util包中的迭代器将抛出一个ConcurrentModificationException异常。
并发的散列映射表，可以高效的支持大量的读者和一定数量的写者。在默认情况下，假定可以有多大16个写者线程同时执行。可以有更多的写着线程，但是 ，如果同一时间多于16个，其他线程将暂时被阻塞。可以指定更大数目的构造器，然而，恐怕没有这种必要。
散列映射将有相同散列码的所有条目放在同一个桶中，有些应用使用的散列函数不当，以至于所有的条目最后都放在很少的桶中，这会严重的降低性能。即使是一般意义上的还算合理的算列函数，如String类的散列函数，也可能存在这种问题，例如，攻击者可能会制造大量有相同散列值的字符串，让程序的速度变慢，在Java SE 8中，并发散列映射将桶组织为树，而不是列表。键类型实现了Comparable，从而可以保证性能为O(log n）
java.util.concurrent.ConcurrentLinkedQueue<E>
ConcurrentLinkedQueue<E>()
构造一个可以被多线程安全访问的无边界非阻塞的队列
java.util.concurrentLinkedQueue<E>()
ConcurrentSkipListSet<E>()
ConcurrentSkipListSet<E>(Comparator<? super E> comp)
构造一个可以被多线程安全访问的有续集，第一个构造器要求元素实现Comparable接口


 */

/*

replace
public boolean replace(K key,
                       V oldValue,
                       V newValue)
仅当当前映射到给定值时才替换密钥的条目。 这相当于
   if (map.containsKey(key) && Objects.equals(map.get(key), oldValue)) { map.put(key, newValue); return true; } else return false;
除了动作以原子方式执行。
Specified by:
replace在界面 ConcurrentMap<K,V>
Specified by:
replace在界面 Map<K,V>
参数
key - 与指定值相关联的键
oldValue - 预期与指定键相关联的值
newValue - 要与指定键相关联的值
结果
true如果该值被替换


putIfAbsent
public V putIfAbsent(K key,
                     V value)
如果指定的键尚未与值相关联，请将其与给定值相关联。 这相当于
   if (!map.containsKey(key)) return map.put(key, value); else return map.get(key);
除了动作以原子方式执行。
Specified by:
putIfAbsent在接口 ConcurrentMap<K,V>
Specified by:
putIfAbsent在界面 Map<K,V>
参数
key - 要与其关联的指定值的键
value - 与指定键相关联的值
结果
与指定键相关联的上一个值，如果没有键的映射， null
异常
NullPointerException - 如果指定的键或值为空


get
public V get(Object key)
返回到指定键所映射的值，或null如果此映射包含该键的映射。
更正式地，如果该映射包含从键k到值v ，使得key.equals(k) ，则该方法返回v ; 否则返回null 。 （最多可以有一个这样的映射。）

Specified by:
get在界面 Map<K,V>
重写：
get在 AbstractMap<K,V>
参数
key - 要返回其关联值的键
结果
指定键映射到的值，如果此映射不包含键的映射， null
异常
NullPointerException - 如果指定的键为空




compute
public V compute(K key,
                 BiFunction<? super K,? super V,? extends V> remappingFunction)
尝试计算用于指定键和其当前映射的值的映射（或null如果没有当前映射）。 整个方法调用是以原子方式执行的。 在计算过程中可能会阻止其他线程对此映射进行的一些尝试更新操作，因此计算应该简单而简单，而且不得尝试更新此Map的任何其他映射。
Specified by:
compute中的 ConcurrentMap<K,V>
Specified by:
compute在接口 Map<K,V>
参数
key - 指定值与之关联的键
remappingFunction - 计算值的函数
结果
与指定键相关的新值，如果没有则为null
异常
NullPointerException - 如果指定的键或remappingFunction为空
IllegalStateException - 如果计算可检测地尝试递归更新该映射，否则将永远不会完成
RuntimeException - 或者如果remappingFunction这样做，则出错，在这种情况下映射不变



merge
public V merge(K key,
               V value,
               BiFunction<? super V,? super V,? extends V> remappingFunction)
如果指定的键尚未与（非空）值相关联，则将其与给定值相关联。 否则，使用给定的重映射函数的结果替换该值，或者删除null 。 整个方法调用是以原子方式执行的。 在计算过程中可能会阻止其他线程对此映射进行的一些尝试更新操作，因此计算应该简单而简单，而且不得尝试更新此Map的任何其他映射。
Specified by:
merge在界面 ConcurrentMap<K,V>
Specified by:
merge中的 Map<K,V>
参数
key - 与其相关联的指定值的键
value - 缺席时使用的值
remappingFunction - 重新计算值（如果存在）的功能
结果
与指定键相关的新值，如果没有则为null
异常
NullPointerException - 如果指定的键或remappingFunction为空
RuntimeException - 或者如果重映射功能如此，则出错，在这种情况下映射不变



reduceValues
public V reduceValues(long parallelismThreshold,
                      BiFunction<? super V,? super V,? extends V> reducer)
返回使用给定的reducer累加所有值的结果，以组合值，如果没有则返回null。
参数
parallelismThreshold - 并行执行此操作所需的元素数量（估计）
reducer - 一种交换联想组合函数
结果
积累所有价值的结果


newKeySet
public static <K> ConcurrentHashMap.KeySetView<K,Boolean> newKeySet()
创建一个新的Set，由一个ConcurrentHashMap支持，从给定的类型到Boolean.TRUE 。
参数类型
K - 返回集合的元素类型
结果
新集



readAllBytes
public static byte[] readAllBytes(Path path)
                           throws IOException
读取文件中的所有字节。 该方法确保在读取所有字节或抛出I / O错误或其他运行时异常时关闭文件。
请注意，此方法适用于将所有字节读入字节数组的简单情况。 它不是用于阅读大文件。

参数
path - 文件的路径
结果
一个包含从文件读取的字节的字节数组
异常
IOException - 如果从流中读取I / O错误
OutOfMemoryError - 如果无法分配所需大小的数组，例如文件大于 2GB
SecurityException - 在默认提供程序和安全管理器的情况下，将调用 checkRead方法来检查对该文件的读取访问。


List<E> synchArrayList=Collections.synchronizedList(new ArrayList<E>());
List<K,V> synchHashMap=Collections.synchronizedMap(new HashMap<K,V>);
结果集合的方法使用锁加以保护，提供了线程安全访问
应该确保没有任何线程通过原始的非同步方法访问数据结构。最便利的方法是确保不保存任何指向原始对象的引用，简单的构造一个集合并立即传递给包装器，向我们的例子中的那样。

如果在另一个线程可能进行修改时要对集合进行迭代，仍然需要使用客户端锁定
synchronized (synchHashMap)
{
    Iterator<K> iter=synchHashMap.keySet().iterator();
    while(iter.hasNext())
        ...
}

如果使用foreach循环，必须使用同样的代码，因为循环使用了迭代器。注意，如果在迭代的过程中，别的线程修改集合，迭代器会失效，抛出ConcurrentModificationException异常，同步仍然是需要的，因此并发的修改可以被可靠地检测出来。
最好使用java.util.concurrent包中定义的集合，不使用同步包装器中的。特别是，假如他们访问的是不同的桶，由于ConcurrentHashMap已经精心的实现了，多线程可以访问它而且彼此不会阻塞。有一个例外是经常被修改的数组列表。在那种情况下，同步的ArrayList可以胜过CopyOnWriteArrayList。


Callable与Future
Runnable封装是一个异步运行的任务，可以把它想象成一个没有参数和返回值的异步方法。Callable与Runnable类似，但是有返回值。Callable接口是一个参数化的类型，只有一个方法call
public interface Callable<V>
{
    v call() throws Exception;
}
类型参数是返回值的类型，例如：Callable<Integer>表示一个最终返回Integer对象的异步运算。
Future保存异步计算的结果，可以启动一个计算，将Future对象交给某个线程，然后忘掉它。Future对象的所有者在结果计算好后可以获得它
Future接口具有下面方法
{
    V get() throws ...;
    V get(long timeout ,TimeUnit) throws
    void cancel(boolean mayInterrupt);
    boolean isCancelled();
    boolean isDone();
    }
    第一个get方法的调用被阻塞，直到计算完成。如果在计算完成之前，第二个方法的调用超时，抛出一个TimeoutException异常
    FutureTask包装器是一种非常便利的机制，可以将Callable转换成Future和Runnable。他们同时实现两者的接口
    {
        Callable<Integer> myCompution;
        FutureTask<Integer> task=new FutureTask<Integer>(myCompotation)
        Thread t=new Thread(task)
        t.start();
        ...
        Integer result =task.get();
     }
     我们需要仅仅计算匹配的文件数目的程序，所以，我们有一个需要长时间运行的任务，它产生一个数值，一个Callable<Integer>的例子
     class MatchCounter implements Callable<Integer>
     {
        public MatchCounter(File directory,String keyword)
        {
            ...
        }

        public Integer call()
        {
            //return the numbet of matching files
        }
     }

      然后和我们利用MatchCounter创建一个FutureTask对象。并用来启动一个线程。
      FutureTask<Integet> task =new FutureTask<Integer>();
      Thread t=new Thread(task);
      t.start();

 */
