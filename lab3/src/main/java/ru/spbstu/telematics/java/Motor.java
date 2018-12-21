package ru.spbstu.telematics.java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Motor
{
//    private Close m_close;
//    private Open m_open;
    private Window window;
    private ReentrantLock locker;
    private Condition condition;

    Motor(Window window)
    {
//        m_close = close;
//        m_open = open;
        this.window = window;
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void start_close() //throws InterruptedException
    {
        locker.lock();
        System.out.println("Start close");
        try
        {
            while (!window.isFull_close())
            {
                Thread.sleep(250);
                window.SubOpened_percent();
            }
            stop_close();
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void stop_close()
    {
        System.out.println("Stop close. Window open " + window.getOpened_percent() + " percent");
        condition.signalAll();
        locker.unlock();
    }

    public void start_open()
    {

    }

    public void stop_open()
    {

    }
}
