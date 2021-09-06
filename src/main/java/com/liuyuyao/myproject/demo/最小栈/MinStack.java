package com.liuyuyao.myproject.demo.最小栈;

import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2021/7/24 10:17 上午
 * @description：
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else {
            if(val <= minStack.peek()){
                minStack.push(val);
            }
        }
    }

    public void pop() {
        int tmp = stack.peek();
        if(tmp == minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuffer longest = new StringBuffer(strs[0]);
        for(int i = 1; i < strs.length; i++){
            int len = Math.min(longest.length(), strs[i].length());
            int tmp = 0;
            for(int j = 0; j < len; j++){
                if(longest.charAt(j) == strs[i].charAt(j)){
                    tmp++;
                }else {
                    break;
                }
            }
            longest = new StringBuffer(longest.substring(0, tmp));
        }
        return longest.toString();
    }

    public static void main(String[] args) {

    }
}
