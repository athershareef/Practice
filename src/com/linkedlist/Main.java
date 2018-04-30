package com.linkedlist;

import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedListNode n = new LinkedListNode(3);
        n.append(4);
        n.append(6);
        n.append(3);

        System.out.println(removeDuplicatesN(n));

    }


    public static LinkedListNode removeDuplicatesN(LinkedListNode n){

        <Integer> set = new HashSet<Integer>();

        while (n!=null){
            set.add(n.getValue());
            n = n.getNext();
        }

        System.out.println(set);

        LinkedListNode linkedListNode = new LinkedListNode();

        for(Integer each: set){
            linkedListNode.append(each);
        }

        return n;
    }

}