package com.example.majorprogrammingproject;

public class BinarySearchTree {
    BSTNode root;

    BinarySearchTree() {
        root = null;
    }

    public BSTNode insert(BSTNode node, int key) {
        if (node == null) {
            node = new BSTNode(key);
            return node;
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public BSTNode search(BSTNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key < key) {
            return search(root.right, key);
        }

        return search(root.left, key);
    }
}
