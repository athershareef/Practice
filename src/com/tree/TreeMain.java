package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMain {
    public static void main(String[] args) {

        Node tree = new Node(1);

        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println(findMaxWidth(tree));

    }

    public static int findMaxWidth(Node tree){

        LinkedList<Node> q = new LinkedList<Node>();

        q.add(tree);

        int maxwidth = 0;

        while(!q.isEmpty()){
            int count = q.size();

            maxwidth = Math.max(maxwidth, count);


            while(count-- > 0) {
                Node temp = q.remove();

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }


        return maxwidth;
    }
}
