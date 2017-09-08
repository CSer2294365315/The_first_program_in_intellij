package J_9_8_3_Interrupt_thread;
import java.util.*;

public class Bank
{
    private final double[] accounts;
    /**
     * Constructs the bank
     * @param n the number of account
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n,double initialBalance)
    {
        accounts=new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    /**
     * Transfers money from one account to another
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from,int to,double amount)
    {
        if(accounts[from]<amount)
            return ;
        System.out.print(Thread.currentThread());  //打印现在的线程
        accounts[from]-=amount;
        System.out.printf("%10.2f from %d to %d\n",amount,from,to);
        accounts[to]+=amount;
        System.out.printf("Total Balance :%10.2f\n",getTotalBalance());
    }
    /**
     * get the sum og all account balances
     * @return the total balance
     */
    public double getTotalBalance()
    {
        double sum=0;

        for(double a:accounts)
            sum+=a;
        return sum;
    }

    /**
     * gets the number of accounts int the bank
     * @return the number of accounts
     */
    public int size()
    {
        return accounts.length;
    }

}
