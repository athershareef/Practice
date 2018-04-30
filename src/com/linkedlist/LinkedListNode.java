package com.linkedlist;

public class LinkedListNode {
    private LinkedListNode next;
    private int value;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public LinkedListNode() {
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " -> " + next;
    }

    public void append(LinkedListNode n){
        LinkedListNode head = this;
        while(head.next!=null){
            head = head.next;
        }
        head.next = n;

    }

    public void append(int value){
        LinkedListNode head = this;
        while(head.next !=null){
            head = head.next;
        }
        head.next = new LinkedListNode(value);
    }

}
