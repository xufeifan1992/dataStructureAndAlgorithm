package com.array;

import com.link.LinkListDummyHead;

/**
 * Created by xufei
 * 2019/4/20
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkListDummyHead<E> linkList;

    public LinkedListStack(){
        linkList = new LinkListDummyHead<>();
    }

    @Override
    public int getSize(){
        return linkList.getSize();
    }

    @Override
    public boolean isEmpty(){
        return linkList.isEmpty();
    }

    @Override
    public void push(E e){
        linkList.addFirst(e);
    }

    @Override
    public E pop(){
        return linkList.removeFirst();
    }

    @Override
    public E peek(){
        return linkList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(linkList);
        return res.toString();
    }

}
