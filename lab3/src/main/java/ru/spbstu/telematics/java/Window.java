package ru.spbstu.telematics.java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Window
{
    private boolean full_open;
    private boolean full_close;
    boolean nowclose;
    boolean nowopen;
    private int opened_percent;
    private int time_passed;
    private int hold_button_time;
    private int delta_time;
    private ReentrantLock locker;
    private Condition condition;
    private Open open;
    private Close close;
    private Thread t_open;
    private Thread t_close;
    
    
    Window()
    {
        full_close = true;
        full_open = false;
        nowclose = false;
        nowopen = false;
        opened_percent = 0;
        time_passed = 0;
        delta_time = 50;
        open = new Open(this);
        close = new Close(this);
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }
    
    public boolean isFull_close()
    {
        return full_close;
    }
    
    public boolean isFull_open()
    {
        return full_open;
    }
    
    public void AddOpened_percent()
    {
        if (!full_open)
        {
            time_passed += delta_time;
            if (time_passed % (delta_time * 5) == 0)
            {
                opened_percent += 1;
                CheckWindowStatus();
            }
        } else
        {
            System.out.println("Error: the window was already open");
        }
    }
    
    public void SubOpened_percent()
    {
        if (!full_close)
        {
            time_passed += delta_time;
            if (time_passed % (delta_time * 5) == 0)
            {
                opened_percent -= 1;
                CheckWindowStatus();
            }
        } else
        {
            System.out.println("Error: the window was already close");
        }
    }
    
    public void CheckWindowStatus()
    {
        if (opened_percent == 0)
        {
            full_close = true;
            full_open = false;
        } else if (opened_percent == 100)
        {
            full_close = false;
            full_open = true;
        } else
        {
            full_close = false;
            full_open = false;
        }
    }
    
    public int getOpened_percent()
    {
        return opened_percent;
    }
    
    public int getTime_passed()
    {
        return time_passed;
    }
    
    public int getHold_button_time()
    {
        return hold_button_time;
    }
    
    public void setHold_button_time(int time)
    {
        hold_button_time = time;
    }
    
    public int getDelta_time()
    {
        return delta_time;
    }
    
    public void FullClose()
    {
        setHold_button_time(100 * delta_time * 5);
        start_close();
    }
    
    public void FullOpen()
    {
        setHold_button_time(100 * delta_time * 5);
        start_open();
    }
    
    public void start_close()
    {
        locker.lock();
        time_passed = 0;
        t_close = new Thread(close);
        System.out.println("Start close");
        t_close.start();
        try
        {
            t_close.join();
            while (nowclose)
                Thread.currentThread().sleep(delta_time);
            stop_close();
        } catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void stop_close()
    {
        System.out.println("Stop close. Window open " + getOpened_percent() + " percent");
        condition.signalAll();
        locker.unlock();
    }
    
    public void start_open()
    {
        locker.lock();
        time_passed = 0;
        t_open = new Thread(open);
        System.out.println("Start open");
        t_open.start();
        try
        {
            t_open.join();
            while (nowopen)
                Thread.currentThread().sleep(delta_time);
            stop_open();
        } catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void stop_open()
    {
        System.out.println("Stop open. Window open " + getOpened_percent() + " percent");
        condition.signalAll();
        locker.unlock();
    }
}
