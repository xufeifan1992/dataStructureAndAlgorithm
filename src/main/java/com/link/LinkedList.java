package com.link;

/**
 * Created by xufei
 * 2019/4/18
 */
public class LinkedList<E> {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

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

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表中是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向链表头中添加元素
    public void addFirst(E e) {
        Node node = new Node(e);
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    //在链表中间添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild,Illegal index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            size ++;
        }
    }

    public void addLast(E e){
        add(size,e);
    }
}
