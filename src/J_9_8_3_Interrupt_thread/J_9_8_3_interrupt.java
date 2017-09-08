package J_9_8_3_Interrupt_thread;
import java.util.*;
/**
 * This program shows data corruption when multiple threads access a data structure
 * @version
 * @author
 */

public class J_9_8_3_interrupt
{
    public static final int NACCOUNTS=100;
    public static final double INITIAL_BALANCE=1000;
    public static final double MAX_AMOUNT=1000;
    public static final int DELAY=10;

    public static void main(String[] args)
    {
        Bank bank=new Bank(NACCOUNTS,INITIAL_BALANCE);
        for(int i=0;i<NACCOUNTS;++i)
        {
            int fromAccount=i;
            Runnable r=()->
            {
                try
                {
                    while(true)
                    {
                        int toAccount=(int)(bank.size()*Math.random());
                        double amount=MAX_AMOUNT*Math.random();
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY*Math.random()));
                    }
                }
                catch(InterruptedException e)
                {

                }
            };
            Thread t=new Thread(r);
            t.start();
        }

    }

}




/*
没有可以强制线程终止的方法，然而，interrupt、方法可以用来请求终止线程。当对一个线程调用interrupt方法时，线程的中断状态将被置位，这是每一个线程都须有的boolean标志。每个线程都应该不是的检查这个标志，以判断线程是否被中断。
要想弄清楚中断状态是否被置位。首要要调用静态的Thread.currentThread方法获得当前线程，然后调用isInterrupted方法
while(!Thread.currentThread().isInterrupted()&&mort work to do)
{
    do more work;
}
但是，如果线程被阻塞，就无法检测中断状态。这是产生InterruptedException异常的地方。当在一个被阻塞的线程（调用sleep或者wait）上调用interrupt方法时，阻塞调用将会被InterruptedException异常中断。（存在不能被中断的阻塞I/O调用，应该考虑选择可中断的调用）
没有任何语言方面的需求要求一个被中断的线程应该终止。中断一个线程不过是引起它的的注意。被中断的线程可以决定如何响应中断。某些异常是如此重要以至于应该处理完异常后，继续执行，而不会理会中断。但是，更普遍的情况是，县城将简单地将中断最为一个中断的请求。这种现成的run方法具有如下的形式：
 Runnable r=()->
 {
    try
    {
        ...
        while(!Thread.currentThread().isInterrupt()&& more work to do)
        {
            do more work;
        }
    }

    catch(InterruptException e)
    {
        //thread was interrupted during sleep or wait
    }
    finally
    {
        cleanup,if required
    }
    //exiting the run method terminates the thread
};

如果在每次工作迭代之后都调用sleep方法（或者其他的可中断方法），isInterrupted检测机没有必要也没有用处。如果在中断状态被置位时调用sleep方法，他不会休眠，相反，他会清除这一状态并抛出InterruptedException。因此，如果你的循环调用sleep，不会检测中断状态。相反，要如下所示捕获InterruptedException异常：
Runnable r=()->
{
    try{

    ...
    while(more work to do)
    {
        do more work;
        Thread.sleep(delay);
    }
    }
    catch(InterruptionException e)
    {
        //thread was interrupted during sleep
    }
    finally
    {
        cleanup,if required
    }
    //exiting the run method terminates the thread

}

有两个非常类似的方法：interrupted和isInterrupted。interrupted方法是一个静态方法，它检测当前的线程是否被中断。而且，调用interrupted方法会清除该线程的中断状态。另一方面，isInterrupted方法是一个实例方法，可用来检测是否有线程被中断，但是调用这个状态不会改变中断状态
void mySubTask()
{
    try
    {sleep(DELAY);}
    catch(InterruptedException e)
    { Thread.currentThread().interrupt();}
}

或者
void mySubTask() throws InterruptedException
{
    sleep(DELAY);
}
可以用setPriority方法提高或者降低任何一个线程的优先级



 */
/*

public class ReentrantLock


      extends
      Object




      implements
      Lock,
      Serializable

一个可重入的互斥锁 Lock，它具有与使用 synchronized 方法和语句所访问的隐式监视器锁相同的一些基本行为和语义，但功能更强大。

ReentrantLock 将由最近成功获得锁，并且还没有释放该锁的线程所拥有。当锁没有被另一个线程所拥有时，调用 lock 的线程将成功获取该锁并返回。如果当前线程已经拥有该锁，此方法将立即返回。可以使用 isHeldByCurrentThread() 和 getHoldCount() 方法来检查此情况是否发生。

此类的构造方法接受一个可选的公平 参数。当设置为 true 时，在多个线程的争用下，这些锁倾向于将访问权授予等待时间最长的线程。否则此锁将无法保证任何特定访问顺序。与采用默认设置（使用不公平锁）相比，使用公平锁的程序在许多线程访问时表现为很低的总体吞吐量（即速度很慢，常常极其慢），但是在获得锁和保证锁分配的均衡性时差异较小。不过要注意的是，公平锁不能保证线程调度的公平性。因此，使用公平锁的众多线程中的一员可能获得多倍的成功机会，这种情况发生在其他活动线程没有被处理并且目前并未持有锁时。还要注意的是，未定时的 tryLock 方法并没有使用公平设置。因为即使其他线程正在等待，只要该锁是可用的，此方法就可以获得成功。






 */