package com.link;

import com.queue.Queue;

/**
 * Created by xufei
 * 2019/4/20
 */
public class LinkedListQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;

    //屏蔽底层实现细节
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if (tail == null) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        Node retNode = head;
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue Filed");
        } else {
            head = head.next;
            retNode.next = null;
            if (head == null) {
                tail = null;
            }
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("getFront Filed");
        }
        return head.e;
    }

}
