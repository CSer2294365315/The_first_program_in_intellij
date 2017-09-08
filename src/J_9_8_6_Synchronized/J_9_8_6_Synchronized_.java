package J_9_8_6_Synchronized;
import java.util.*;

/**
 * A bank with a number of bank accounts that uses synchronization primitives
 */

public class J_9_8_6_Synchronized_
{
    public static final int DELAY=50;

    public static void main(String[] args)
    {


        Bank bank=new Bank(20,500);
        for(int i=0;i<20;++i)
        {
            int fromAccount = i;
            Runnable r=()->
            {

                try
                {
                    bank.transfer(fromAccount, (int) (20 * (Math.random())), (int) (300 * (Math.random())));
                    Thread.sleep((int)(DELAY*Math.random()));
                }
                catch (InterruptedException e)
                {
                }
            };
            Thread t=new Thread(r);
            t.start();

        }

    }

}

class Bank
{
    private final double[] accounts;

    public Bank(int numberOfCounter,double initialNumber)
    {
        accounts=new double[numberOfCounter];
        Arrays.fill(accounts,initialNumber);
    }

    /**
     * Transfer number from one count to another
     */
    public synchronized void transfer(int fromAccount,int toAccount,int TransferNumber) throws InterruptedException
    {
        while(accounts[fromAccount]<TransferNumber)
            wait();
        accounts[fromAccount]-=TransferNumber;
        System.out.print(Thread.currentThread());
        accounts[toAccount]+=TransferNumber;
        System.out.printf("total %d from %d to %d\n4",TransferNumber,fromAccount,toAccount);
        System.out.println(getTotalNumber());
        notifyAll();
    }

    public synchronized double getTotalNumber()
    {
        double sum=0;
        for(double a:accounts)
            sum+=a;
        return sum;
    }

    public int size()
    {
        return accounts.length;
    }
}
