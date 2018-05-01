package com.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println();

        SortedStack sortedStack = new SortedStack();

        sortedStack.push(5);

        sortedStack.push(1);

        sortedStack.push(55);


        System.out.println(sortedStack);

        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.pop());

    }



}
