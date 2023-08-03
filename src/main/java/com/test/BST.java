package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BinSearchTree
 */
public class BST {

    public class Node {
        public Node left;
        public Node right;
        public int value;
    }

    // BST(int), n,  => n=1, max, n=2, next to max
    public Integer find(Node node, int n) {
        if (node == null) {
            return null;
        }

        Integer right = find(node.right, n);
        if (right != null) {
            return right;
        }
        n = n - 1;
        if (n == 0) {
            return node.value;
        }
        return find(node.left, n);
    }

    // check whether a given tree is a bst
    public boolean check(Node root) {
        if (root == null) {
            return true;
        }
        List<Node> nodeList = new LinkedList<>();
        try {
            visit(root, nodeList);
        } catch (RuntimeException ex) {
            return false;
        }

        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).value > nodeList.get(i + 1).value) {
                return false;
            }
        }
        return true;
    }

    private void visit(Node node, List<Node> list) {
        if (node == null || list == null) {
            return;
        }
        // 中序遍历
        if (node.left != null) {
            if (node.value < node.left.value) {
                throw new RuntimeException("invalid BST");
            }
            visit(node.left, list);
        }

        list.add(node);

        if (node.right != null) {
            if (node.value > node.right.value) {
                throw new RuntimeException("invalid");
            }
            visit(node.right, list);
        }

    }

    // 广度优先搜索
    private void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.value);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }


    public static void main(String[] args) {

    }

}
