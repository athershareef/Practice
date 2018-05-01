package com.linkedlist;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedListNode n = new LinkedListNode(3);
        n.append(4);
        n.append(5);
        n.append(66);
        n.append(3);


        System.out.println(isLinkedListPalindrome(n));

    }


    public static boolean isLinkedListPalindrome(LinkedListNode n){

        LinkedListNode reverse = reverse(n);

        while(reverse != null && n != null){
            if(reverse.getValue() != n.getValue()){
                return false;
            }
            reverse = reverse.getNext();
            n = n.getNext();
        }

        return true;
    }



    private static LinkedListNode reverse(LinkedListNode n){

        Stack<Integer> stack = new Stack<Integer>();

        while(n != null){
            stack.push(n.getValue());
            n = n.getNext();
        }

        LinkedListNode reverse = new LinkedListNode(stack.pop());

        while(!stack.isEmpty()){
            reverse.append(stack.pop());
        }

        return reverse;
    }

    public static LinkedListNode partitionN(LinkedListNode n, int p){

        LinkedListNode lower = new LinkedListNode();
        LinkedListNode upper = new LinkedListNode();
        while(n.getNext()!=null){
            if(n.getValue()< p){
                lower.append(n.getValue());
            } else {
                upper.append(n.getValue());
            }
            n = n.getNext();
        }

        while(upper!=null){
            if(upper.getValue()!=0) {
                lower.append(upper.getValue());
            }
            upper = upper.getNext();
        }

        return lower;

    }

    public static int findLastKthElemN(LinkedListNode n, int k){

        int size =0;

        LinkedListNode temp = new LinkedListNode();

        temp = n;

        while(temp!=null){
            temp = temp.getNext();
            size++;
        }

        int j = size - k;

        for(int i =j; n!= null &&  i > 0; i--){
            n = n.getNext();
        }

        return n.getValue();

    }


    public static int findLastKthElemNRECURSION(LinkedListNode n, int k){
        if(n == null){
            return 0;
        }

        int index = findLastKthElemNRECURSION(n.getNext(), k) +1;

        if(index == k){
            System.out.println(k + "th element is: "+ n.getValue());
        }

        return index;

    }



    public static LinkedListNode removeDuplicatesN(LinkedListNode n){

        LinkedHashSet<Integer> list = new LinkedHashSet<>();

        while (n!=null){
            list.add(n.getValue());
            n = n.getNext();
        }

        System.out.println(list);

        LinkedListNode linkedListNode = new LinkedListNode();

        for(Integer each: list){
            linkedListNode.append(each);
        }

        return linkedListNode;
    }

}