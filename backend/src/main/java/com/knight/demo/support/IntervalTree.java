package com.knight.demo.support;

public class IntervalTree {

    private class Node {
        int start, end;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
        }
    }

    private Node root;

    public IntervalTree() {
        root = null;
    }

    public void insert(int start, int end) {
        root = insert(root, start, end);
    }

    private Node insert(Node node, int start, int end) {
        if (node == null) {
            return new Node(start, end);
        } else if (start < node.start) {
            node.left = insert(node.left, start, end);
        } else {
            node.right = insert(node.right, start, end);
        }
        return node;
    }

    public boolean search(int start, int end) {
        return search(root, start, end);
    }

    private boolean search(Node node, int start, int end) {
        if (node == null) {
            return false;
        } else if (node.start <= end && start <= node.end) {
            return true;
        } else if (node.left != null && node.left.end >= start) {
            return search(node.left, start, end);
        } else {
            return search(node.right, start, end);
        }
    }
}
