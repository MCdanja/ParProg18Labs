package ru.spbstu.telematics.java;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>
{
    public class Node<T>
    {
        Node<T> _prev;
        Node<T> _next;
        T _data;
        Node(T data)
        {
            _data = data;
        }
    }

    private int list_size;
    private Node<T> Head;
    private Node<T> Tail;

    MyLinkedList()
    {
        Head = new Node<T>(null);
        Tail = new Node<T>(null);
        Head._prev = Tail;
        Tail._prev = Head;
        list_size = 0;
    }

    void add(T item)
    {
        Node<T> node = new Node(item);
        node._data = item;
        node._prev = Tail._prev;
        node._next = Tail;
        Tail._prev._next = node;
        Tail._prev = node;
        list_size++;
    }

    int size()
    {
        return list_size;
    }

    void remove(int index)
    {
        Node<T> node = Head._next;
        for(int i = 0; i < index; i++)
        {
            node = node._next;
        }
        node._next._prev = node._prev;
        node._prev._next = node._next;
        list_size--;
    }

    boolean contains(T item)
    {
        Node<T> node = Head._next;
        for(int i = 0; i < list_size; i++)
        {
            if(node._data.equals(item))
            {
                return true;
            }
            node = node._next;
        }
        return false;
    }

    T get(int index)
    {
        Node<T> node = Head._next;
        for(int i = 0;i < index; i++)
        {
            node = node._next;
        }
        return node._data;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            int len = list_size;
            int index = 0;
            @Override
            public boolean hasNext()
            {
                // TODO Auto-generated method stub
                return index < len;
            }

            @Override
            public T next()
            {
                // TODO Auto-generated method stub
                Node<T> node = Head;
                index++;
                for(int i = 0; i < index; i++)
                {
                    node = node._next;
                }
                return node._data;
            }

            @Override
            public void remove()
            {

            }
        };
    }
}
