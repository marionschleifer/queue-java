package com.company;

import com.company.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue<String>();
    }

    @Test
    void enqueue() {
        queue.enqueue("hello");
        assertEquals(1, queue.size());
        queue.enqueue("goodbye");
        assertEquals(2, queue.size());
        queue.enqueue("buon giorno");
        queue.enqueue("hola");
        queue.enqueue("adios");
        queue.enqueue("salam");
        assertEquals(10 , queue.capacity());
    }

    void enqueueAndDequeue() {
        queue.enqueue("hello");
        queue.enqueue("goodbye");
        queue.enqueue("buon giorno");
        queue.enqueue("hola");
        queue.enqueue("adios");
        assertEquals(5, queue.capacity());
        queue.dequeue();
        queue.enqueue("salam");
        assertEquals(5, queue.capacity());
        queue.enqueue(("good morning"));
        assertEquals(10, queue.capacity());
    }

    @Test
    void dequeue() {
        queue.enqueue("hello");
        queue.enqueue("goodbye");
        assertEquals("hello", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("goodbye", queue.dequeue());
        assertEquals(0, queue.size());
        assertEquals(true, queue.isEmpty());
        Throwable t = assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
        assertEquals("The queue is empty", t.getMessage());
    }

    @Test
    void front() {
        queue.enqueue("hello");
        queue.enqueue("goodbye");
        assertEquals("hello", queue.front());
    }

    @Test
    void isEmpty() {
        assertEquals(true, queue.isEmpty());
        queue.enqueue("hello");
        assertEquals(false, queue.isEmpty());
    }

    @Test
    void arrayContinuesAtBeginning() {
        queue.enqueue("buon giorno");
        queue.enqueue("hola");
        queue.enqueue("adios");
        queue.enqueue("salam");

    }

}
