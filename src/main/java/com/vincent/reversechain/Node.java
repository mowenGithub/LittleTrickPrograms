package com.vincent.reversechain;

/**
 * Created by Vincent on 5/4/16.
 */
public class Node {
    String value;
    Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }
}
