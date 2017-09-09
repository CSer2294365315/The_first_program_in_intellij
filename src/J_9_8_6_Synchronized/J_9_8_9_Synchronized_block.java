package J_9_8_6_Synchronized;

public class J_9_8_9_Synchronized_block
{

}


/*
同步阻塞
每一个java对象有一个锁，线程可以通过调用同步方法获得锁。还有一种机制可以获得锁，通过进入一个同步阻塞。当线程进入如下形式的阻塞：
synchronized(obj)
{
    ...
}
于是他获得obj锁

有时会发现"特殊的"锁

public class Bank
{
    private double[] accounts;
    private Object lock=new Object();
    ...
    public void transfer(int from,int to,int amount)
    {
        synchronized(lock)
        {
            accounts[from]-=amount;
            accounts[to]+=amount;
         }
         System.out.println();
    }
}
在此，lock对象被创建仅仅是用来使用每个java对象所持有的锁
有时程序员使用一个对象的锁来实现额外的原子操作，实际上称为客户端锁定（client side locking）。例如，考虑Vector类，一个列表，他的方法是可以同步的，现在，假定在Vector<Double>中存储余额。这里有一个transfier方法的原始实现
Vector类的get方法和set方法是同步的，但是，这对于我们并没有什么帮助，在第一次，对get的调用已经完成之后，一个线程完全可能在transfer方法中被剥夺运行权。于是，另一个线程可能在相同的存储位置存入不同的值，但是我们可以截获这个锁：
public void transfer(Vector<Double> accounts ,int from,int to,int amount)
{
    synchronized(accounts)
    {
        account.set(from,accounts.get(from)-amount);
        account.set(to,accounts.get(to)+amount);
    }
}
这个方法可以工作，但是他完全依赖这样的一个事实：Vector类对自己的所有可修改方法都使用内部锁。然而，这是真的吗？者必须要阅读源代码
客户端锁定非常脆弱，通常不推荐使用
监视器的概念
锁和条件是线程同步的强大工具，但是，严格的讲，他们不是面向对象的。有一种可以不需要考虑如何加锁就能保证多线程的安全性，这种方法就是监视器（monitor），监视器的特性：
1、监视器是只包含私有域的类
2、每个监视器类对象有一个相关的锁。换句话说，如果客户端调用obj.method().那么obj对象的锁在方法调用开始时自动获得。并且在该方法返回时自动释放所，因为所有的域都是私有的，这样的安排可以确保一个线程在对对象操作时，没有其他的线程能访问该域。
3、锁可以有人以多个相关条件
监视器的早期版本只有单一的条件。是有一种很优雅的句法。可以简单的调用await accounts[from]>=balance 而不适用任何显式的条件变量。然而，研究表明盲目的重新测试条件是低效的。显示的条件变量解决了这一问题。每一个条件变量管理一个独立的线程级；
java设计者以不是很精确的方式采用了监视器的概念。java中的每一个对象有一个内部的所和内部的条件。如果一个方法用synchronized关键字声明。那么，他表现的就像是一个监视器方法。通过调用wait/notifyAll/notify来访问条件变量
然而，在下属的三个方面Java对象不同于监视器，从而使得线程安全性下降。
1、域不要求是private
2、方法不要求是synchronized
3、内部所对用户是可用的

Volatile域

同步格言：如果想一个变量写入值，而这个变量接下来可能被另一个线程读取，或者，从一个变量读取值，而这个变量可能之前被另一个县城写入，此时必须使用同步

volatile关键字为实例域的同步访问提供了一种免锁机制。如果声明一个域为volatile，那么编译器和虚拟机就知道该与可能被另一个线程并发更新。
例如，假定有一个对象有一个布尔标记done，它的值为一个线程设置何为另一个线程查询，如同我们讨论的那样。可以使用锁：
private boolean done;
public synchronized boolean isDone()
{
    return done;
}
public synchronized void setDone()
{
    done=true;
}
或许使用内部锁不是好主意，如果另一个线程已经对该对象加锁，isDone和setDone方法可能阻塞。如果注意到这个方面，一个线程可以为这一变量使用独立的Lock。但是，这也会带来许多麻烦。
在这种情况下，将域声明为volatile是合理的
private volatile boolean done;
public boolean isDone()
{
    return done;
}
public void setDone()
{
    done=true;
}

Volatile变量不能提供原子性，例如，方法：
public void flipDone()
{
    done=！done;
}
不能确保翻转域中的值，不能保证读取，翻转和写入不被中断

final变量

上一节已经了解到，除非使用锁或者volatile修饰符，否则无法从多个线程中安全的读取一个域。
还有一种情况可以安全的访问一个共享域，即这个域声明为final时，考虑以下声明：
final Map<String,Double> accounts =new HashMap<>();
其他线程会在构造函数完成后才看到这个accounts变量。
如果不使用final，就不能保证其他线程看到的是accounts更新后的值，他们可能只是看到null。而不是这个新构造的HashMap
当然，对这个映射表的操作并不是线程安全的。如果多个线程再度写这个映射表，仍然需要进行同步

原子性

假设对共享变量除了赋值之外并不完成其他操作，那么可以将这些共享变量声明为volatile。
java.util.concurrent.atomic包中有很多使用了很高效的机器指令（而不是使用锁）。来保证其他操作的原子性。例如，AtomicInteger类提供了方法incrementAndGet和decrementAndGet，他们分别以原子方式讲一个整数自增或者自减。例如，可以安全的生成一个数值序列，如图所示：
public static AtomicLong nextNumber =new AtomicLong();
long id=nextNumber.incrementAndGet();
incrementAndGet方法以原子方式将AtomicLong自增或者自减。并返回自增后的值。也就是说，获得值，增加1，并且设置然后生成新值的操作不会中断。可以保证即使是多个线程并发的访问同一个实例，也会计算并且返回正确的值。
有很多方法可以以原子的方式设置和增减值，不过，如果希望完成更复杂的更新，就必须使用compareAndSet方法。例如，假设希望跟踪不同线程观察的最大值。下面的代码是不可行的
public static AtomicLong largest =new AtomicLong();
largest.set(Math.max(largest.get(),observed));
这个更新不是原子的，应该在一个循环中计算新值和使用compareAndSet()
do{
oldValue=largest.get();
newValur=Math.max(oldValue,observed);
}while(!largest.compareAndSet(oldValue,newValue))

如果另外一个线程也在更新largest，就有可能阻止这个线程更新，这样一来，compareAndSet就会返回false，而不会设置新值。在这种情况系，循环会再次尝试，读取新更新后的值，并修改。最后他会成功的用新值替换原来的值。这听起来很麻烦，但是compareAndSet方法会映射到一个处理器操作，比使用所的速度更快
在javaSE8中，不再需要编写这样的循环样板代码。实际上，可以提供一个lambda表达式更新变量，他会为你完成更新。对于这个例子，我们可以调用：
largest.updataAndGet(x->Math.max(x,observed));
或者
largest.accumulateAndGet(observed,Math::max);
accumulateAndGet方法利用一个二元操作符来合并原子值和所提供的参数
还有getAndUpdata和getAndAccumulate方法来返回原值
如果有大量线程要访问相同的原子值，性能会大幅度下降，因为乐观更新需要太多次重试。
JavaSE8中，提供了LongAdder和LongAccumulator来解决这个问题，LongAdder包括多个变量，其总和为当前值。可以有多个线程更新不同的家属，县城个数增加是，会自动提供新的加数，通常情况下，只有当所有工作都完成后才需要总和的值，对于这种情况，这种方法会很高效。性能会有很高的提升
如果认为可能存在大量竞争，只需要使用LongAdder而不是AtomicLong。方法名稍有区别，调用increment让计数器自增。或者调用add来增加一个量，或者调用sum来获取总和
final LongAdder adder=new LongAdder();
for(...)
    pool.submit(()->{
    ...
    adder.increment();

当然，inrement方法不会返回原值，这样做会消除讲求和分解到多个加数所带来的性能提升。
LongAccumulator将这种思想推广到任意的累加操作，在构造其中，可以提供这个操作以及他的另元素，要加入新的值，可以调用accumulate。





 */
