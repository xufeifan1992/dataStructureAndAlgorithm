package com.link;

/**
 * Created by xufei
 * 2019/4/20
 */
public class LinkListDummyHead<E> {
    private Node dummyHead;
    private int size;

    public LinkListDummyHead() {
        dummyHead = new Node(null, null);
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
        add(0, e);
        size++;
    }

    //在链表中间添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild,Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;

    }

    public void addLast(E e) {
        add(size, e);
    }

    //获得链表的第index(0-based)个位置得元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild,Illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //修改链表得第index个位置得元素e
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set faild,Illegal index");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current + "->");
            current = current.next;
        }
        res.append("NULL");
        return res.toString();
    }

    //删除链表中的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove faild,Illegal index");
        }
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node retNode = previous.next;
        previous.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //删除链表头元素
    public E removeFirst() {
        return remove(size - 1);
    }

}
