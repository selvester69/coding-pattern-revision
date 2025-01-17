package com.practice.datastructure.trees;

public class BinarySearchTreeRecursive {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
        }
        Node temp = this.root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            } else if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean rContains(int value) {
        return rContains(this.root, value);
    }

    private boolean rContains(Node temp, int value) {
        if (temp == null)
            return false;
        if (temp.value == value)
            return true;
        else if (value < temp.value)
            return rContains(temp.left, value);
        else
            return rContains(temp.right, value);
    }

    public void rInsert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }
        rInsert(this.root, value);
    }

    private Node rInsert(Node curr, int value) {
        if (curr == null)
            return new Node(value);
        if (value < curr.value) {
            curr.left = rInsert(curr.left, value);
        } else if (value > curr.value) {
            curr.right = rInsert(curr.right, value);
        }
        return curr;
    }

    public int minValue(Node temp) {
        while (temp != null && temp.left != null) {
            temp = temp.left;
        }
        return temp.value;
    }

    public void rDelete(int value) {
        this.root = rDelete(root, value);
    }

    private Node rDelete(Node curr, int value) {
        if (curr == null)
            return null;
        if (value < curr.value) {
            curr.left = rDelete(curr.left, value);
        } else if (value > curr.value) {
            curr.right = rDelete(curr.right, value);
        } else {
            // there are 4 cases
            // if both left and right child are null
            if (curr.left == null && curr.right == null) {
                return null;
            } else if (curr.left == null) {// left child is null
                curr = curr.right;
            } else if (curr.right == null) {
                // right child is null
                curr = curr.right;
            } else {
                // both child are not null;
                // swap the value with min value from right sub child
                int min = minValue(curr.right);
                curr.value = min;
                curr.right = rDelete(curr.right, min);
            }
        }
        return curr;
    }

}
