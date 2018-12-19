package ru.spbstu.telematics.java;

import java.io.*;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.remove(1);

        System.out.println(list.contains(7));

        Iterator<Integer> it = list.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        for(Integer i: list)
        {
            System.out.println(i);
        }

        MyLinkedList<String> str = new MyLinkedList<String>();
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");
        str.remove(1);

        System.out.println(str.contains("c"));
    }
}
