package ru.spbstu.telematics.java;

import java.io.*;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        FileReader reader = new FileReader("prog.txt");
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1)
            {
                System.out.print((char)c);
            }
    }
}
