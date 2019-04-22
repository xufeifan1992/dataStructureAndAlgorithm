package com.tree;

/**
 * 二分搜索树
 * Created by xufei
 * 2019/4/22
 */
public class BSTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        /*if (root == null) {
            root = new Node(e);
            size++;
        } else
            add(root, e);*/
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素E,递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {

        //递归中止
        /*if (e.compareTo(node.e) == 0) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }*/
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            //add(node.left, e);
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0)
            //add(node.right, e);
            node.right = add(node.right, e);

        return node;
    }

}
