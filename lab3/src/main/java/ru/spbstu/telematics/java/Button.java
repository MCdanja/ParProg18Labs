package ru.spbstu.telematics.java;

public class Button
{
    private Window window;

    Button(Window window)
    {
        this.window = window;
    }

    void PushUp(int time)
    {
        if(time < 15 * window.getDelta_time())
        {
            window.FullClose();
        }
        else
        {
            window.setHold_button_time(time);
            window.start_close();
        }
    }

    void PushDown(int time)
    {
        if(time < 15 * window.getDelta_time())
        {
            window.FullOpen();
        }
        else
        {
            window.setHold_button_time(time);
            window.start_open();
        }
    }
}
