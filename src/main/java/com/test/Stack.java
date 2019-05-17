package com.test;

public class Stack {

    private Node tail, head;

    private void push(Node node) {
        if(head == null) {
            tail = node;
            head = node;
        } else {
            head.setNext(node);
            head = node;
        }
    }

    private Node pop() {
        if(head == null) {
            return null;
        }
        Node tem = tail;
        if(tem.getNext() != null) {
            //        while (tem.next == head) {
            while (tem.getNext() != head) {
                tem = head;
            }
            Node tem2 = head;
            tem.setNext(null);
            head = tem;
            return tem2;
        } else {
            head = null;
            tail = null;
            return tem;
        }
    }

    public class Node {
        private Object value;
        private Node next;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
