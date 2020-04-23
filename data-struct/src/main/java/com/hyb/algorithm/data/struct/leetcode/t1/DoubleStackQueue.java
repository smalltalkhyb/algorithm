package com.hyb.algorithm.data.struct.leetcode.t1;

import java.util.Stack;

public class DoubleStackQueue {


    Stack<Integer> stackMaster = new Stack<>();

    Stack<Integer> stackSlave = new Stack<>();

    public void appendTail(int value) {
        while (!stackMaster.empty()) {
            stackSlave.push(stackMaster.pop());
        }

        stackSlave.push(value);

        while (!stackSlave.empty()) {
            stackMaster.push(stackSlave.pop());
        }
    }

    public int deleteHead() {
        if (stackMaster.isEmpty()) {
            return -1;
        }

        return stackMaster.pop();
    }
}
