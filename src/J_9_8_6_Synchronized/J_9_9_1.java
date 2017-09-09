package J_9_8_6_Synchronized;
import java.util.concurrent.locks.*;

public class J_9_9_1
{
    private ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();

    private Lock readLock=rwl.readLock();
    private Lock writeLock=rwl.writeLock();



    public double getTotalBalance()
    {
        readLock.lock();
        try
        {
            //...
            return 1.0;
        }
        finally
        {
            readLock.unlock();
        }
    }

    public double transfer()
    {
        writeLock.lock();
        try
        {
            //
            return 1.0;
        }
        finally
        {
            writeLock.unlock();
        }
    }


}
