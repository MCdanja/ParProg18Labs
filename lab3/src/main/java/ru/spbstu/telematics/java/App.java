package ru.spbstu.telematics.java;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Main thread started...");

        Window window = new Window();
        Button button = new Button(window);
        
        button.PushDown(20 * window.getDelta_time() * 5);
        button.PushDown(40 * window.getDelta_time() * 5);
        button.PushUp(50 * window.getDelta_time() * 5);
        button.PushDown(100 * window.getDelta_time() * 5);
        button.PushDown(100 * window.getDelta_time() * 5);
        button.PushUp(50 * window.getDelta_time() * 5);
        button.PushUp(500);
        button.PushDown(500);
        
        System.out.println("Main thread finished...");
    }
}
