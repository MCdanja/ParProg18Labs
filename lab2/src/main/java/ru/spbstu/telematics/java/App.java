package ru.spbstu.telematics.java;

import java.io.*;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        MyLinkedList<Integer> a = new MyLinkedList<Integer>();
        a.add(5);
        a.add(3);
        a.add(7);
        a.add(1);
        a.remove(1);
        Iterator<Integer> it = a.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        for(Integer i: a)
        {
            System.out.println(i);
        }
    }
}
