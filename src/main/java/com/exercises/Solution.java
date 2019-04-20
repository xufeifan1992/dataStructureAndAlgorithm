package com.exercises;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by xufei
 * 括号匹配
 * 2019/4/17
 */
public class Solution {
    //括号匹配
    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ('(' == aChar || '[' == aChar || '{' == aChar) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
            }
            if (')' == aChar && '(' != (char) stack.pop()) {
                return false;
            }
            if (']' == aChar && '[' != (char) stack.pop()) {
                return false;
            }
            if ('}' == aChar && '{' != (char) stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    //删除链表中多个元素
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null){
            return head;
        }

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;

    }

    @Test
    public void main() {
        String str = "())(";
        boolean valid = isValid(str);
        System.out.println(valid);
    }
}
