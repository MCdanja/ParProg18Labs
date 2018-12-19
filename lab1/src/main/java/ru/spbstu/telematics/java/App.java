package ru.spbstu.telematics.java;

import java.io.*;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        String str;
        str = ReadFromFile("text.txt");
        System.out.println(str);
        str = ReadFromFile("prog.txt");
        System.out.println(str);
    }

    public static String ReadFromFile(String fname) throws IOException
    {
        String tmp = "";
        FileReader reader = new FileReader(fname);
        // читаем посимвольно
        int c;
        while((c=reader.read())!=-1)
        {
            tmp += (char)c;
        }
        return tmp;
    }
}
