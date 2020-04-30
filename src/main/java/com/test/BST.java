package com.test;

public class BST {

    // BST(int), n,  => n=1, max, n=2, next to max

    public class Node {
        public Node left;
        public Node right;
        public int value;
    }


    public Integer find(Node node, int n) {

        if(node == null) {
            return null;
        }

        Integer right = find(node.right, n);
        if(right != null) {
            return right;
        }
        n = n - 1;
        if(n == 0) {
            return node.value;
        }
        return find(node.left, n);
    }



}
