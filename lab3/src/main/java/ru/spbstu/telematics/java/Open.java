package ru.spbstu.telematics.java;

public class Open implements Runnable
{
    private Window window;
    
    Open(Window window)
    {
        this.window = window;
    }
    
    public void run()
    {
        window.nowopen = true;
        while (window.getTime_passed() < window.getHold_button_time())
        {
            if(window.isFull_open())
            {
                break;
            }
            try
            {
                Thread.sleep(window.getDelta_time());
                window.AddOpened_percent();
            } catch (InterruptedException e)
            {
                System.out.println("Thread has been interrupted");
            }
        }
        window.nowopen = false;
    }
}