package com.vincent.reversechain;

/**
 * Created by Vincent on 5/4/16.
 * 反转链表
 */
public class ReverseChain {
    public static void main(String[] args) {
        final Node header = new Node("", null);
        buildChain(header);
        reverseChain(header);
        printChain(header);
    }

    private static void buildChain(final Node header) {
        header.next = new Node("1", null);
        header.next.next = new Node("2", null);
        header.next.next.next = new Node("3", null);
        header.next.next.next.next = new Node("4", null);
    }

    private static void reverseChain(final Node header) {
        Node tempNode = new Node("", null);
        while (header.next != null) {
            Node temp = header.next.next;
            header.next.next = tempNode.next;
            tempNode.next = header.next;
            header.next = temp;
        }
        header.next = tempNode.next;
    }

    private static void printChain(final Node header) {
        Node tempNode = header.next;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }
}
