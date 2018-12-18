package ru.spbstu.telematics.java;

import junit.framework.TestCase;

import java.util.LinkedList;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testMyLinkedListInteger()
    {
        MyLinkedList<Integer> myl_i = new MyLinkedList<Integer>();
        myl_i.add(1);
        myl_i.add(2);
        myl_i.add(3);
        myl_i.add(4);
        myl_i.add(5);
        myl_i.remove(2);
        LinkedList<Integer> l_i = new LinkedList<Integer>();
        l_i.add(1);
        l_i.add(2);
        l_i.add(3);
        l_i.add(4);
        l_i.add(5);
        l_i.remove(2);
        boolean flag = true;
        for(int i = 0; i < myl_i.size(); i++)
        {
            if (myl_i.get(i) != l_i.get(i))
            {
                flag = false;
            }
        }
        assertEquals(true, flag);
    }

    public void testMyLinkedListString()
    {
        MyLinkedList<String> myl_str = new MyLinkedList<String>();
        myl_str.add("a");
        myl_str.add("b");
        myl_str.add("c");
        myl_str.add("d");
        myl_str.add("e");
        myl_str.remove(2);
        LinkedList<String> l_str = new LinkedList<String>();
        l_str.add("a");
        l_str.add("b");
        l_str.add("c");
        l_str.add("d");
        l_str.add("e");
        l_str.remove(2);
        boolean flag = true;
        for(int i = 0; i < myl_str.size(); i++)
        {
            if (myl_str.get(i) != l_str.get(i))
            {
                flag = false;
            }
        }
        assertEquals(true, flag);
    }

    public void testMyLinkedListSize()
    {
        MyLinkedList<Integer> myl_i = new MyLinkedList<Integer>();
        myl_i.add(1);
        myl_i.add(2);
        myl_i.add(3);
        myl_i.add(4);
        myl_i.add(5);
        myl_i.remove(2);
        assertEquals(4, myl_i.size());
    }
}
