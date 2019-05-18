package com.test;

public class DeleteLink {


    public static void main(String[] args) {
        int[] values = new int[]{0, 0, 0, 1, 2, 0, 0, 4};
        Node tail = buildLink(values);
        int v = 2;

        Node result = deleteNode(tail, v);
        System.out.println(result);
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
