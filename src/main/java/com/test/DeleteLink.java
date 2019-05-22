package com.test;

public class DeleteLink {


    public static void main(String[] args) {
        int[] values = new int[]{0, 0, 0, 1, 2, 0, 3, 0, 4, 5};
        Node tail = buildLink(values);
        int v = 0;

        Node result = deleteNode(tail, v);
        System.out.println(result);

        result = revertLink(result);
        System.out.println(result);
    }

    public static Node revertLink(Node tail) {

        //做法一： 当前节点指向上一个节点
//        Node current = tail, pred = null;
//        while (current != null) {
//           Node x = current.next;
//           current.next = pred;
//           pred = current;
//           current = x;
//        }
//        return pred;

        //做法二： 下一个节点指向当前节点 ?
        Node temp = tail, next = null;
        while (temp.next != null) {
            next = temp.next.next;
            temp.next.next = temp;

        }
        return null;
    }

    public static Node deleteNode(Node tail, int v) {
        Node pred = null;
        Node current = tail;
        while(current != null) {
            if(current.value == v) {
                if(pred == null) {
                    tail = current.next;
                } else {
                    pred.next = current.next;
                }
            } else {
                pred = current;
            }
            current = current.next;
        }
        return tail;
    }

    public static Node buildLink(int[] values) {
        Node tail = null, current = null;
        for(int x : values) {
            Node node = new Node(x);
            if(tail == null) {
                tail = node;
            }
            if(current != null) {
                current.next = node;
            }
            current = node;
        }
        return tail;
    }

    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }

        @Override
        public String toString() {
            return "(value: " + value + ", next: " + next + ")";
        }
    }
}
