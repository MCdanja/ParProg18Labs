package ru.spbstu.telematics.java;

public class Close implements Runnable
{
    private Window window;
    
    Close(Window window)
    {
        this.window = window;
    }
    
    public void run()
    {
        window.nowclose = true;
        while (window.getTime_passed() < window.getHold_button_time())
        {
            if(window.isFull_close())
            {
                break;
            }
            try
            {
                Thread.sleep(window.getDelta_time());
                window.SubOpened_percent();
            } catch (InterruptedException e)
            {
                System.out.println("Thread has been interrupted");
            }
        }
        window.nowclose = false;
    }
}
