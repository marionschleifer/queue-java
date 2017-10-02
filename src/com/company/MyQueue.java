package com.company;

import java.util.ArrayList;

public class MyQueue<T> {
    T[] list = (T[]) new Object[5];
    int size = 0;
    int beginning = 0;

    public void enqueue(T element) {
        if(size + 1 > list.length) {
            T[] biggerList = (T[]) new Object[list.length * 2];
            for(int i = 0; i < list.length; i++) {
                biggerList[i] = list[(i + beginning) % size];
            }
            list = biggerList;
        }
        if(beginning + 1 > list.length) {
            beginning = 0;
        }
            list[size] = element;
            size += 1;

    }

    public int size() {
        return size;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        T element = list[0];
        for (int i = 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[size - 1] = null;
        size--;
        return element;
    }

    public T front() {
        return list[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return list.length;
    }

}
