package org.topics.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        int[] preorder = {1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1};
        Node node = buildBinaryTree(preorder);
        System.out.println(node.left.root);
        System.out.println(node.right.root);
        System.out.print("preorder traversal : ");
        preorderTraversal(node);

        System.out.println();
        System.out.print("inorder traversal : ");
        inOrderTraversal(node);

        System.out.println();
        System.out.print("postorder traversal : ");
        postOrderTraversal(node);

        System.out.println();
        System.out.println("levelorder traversal : ");
        levelOrderTraversal1(node);

        checkNoLevels(node);
    }

    //levelorder traversal
    private static void levelOrderTraversal1(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.root + ", ");
            if (current.left != null) {
                levelOrderTraversal1(current.left);
            }
            if (current.right != null) {
                levelOrderTraversal1(current.right);
            }
        }
    }

    private static void checkNoLevels(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                System.out.print(current.root + " ");
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            System.out.println();
        }
        System.out.println("level: " + level);
    }

    // find number of level
    private static void levelOrderTraversal(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            level++;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.root + " ");

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            System.out.println();
        }
        System.out.println("level size : " + level);
    }

    //post order traversal
    private static void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.root + " ");

    }

    //  inorder traversal
    private static void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.root + " ");
        inOrderTraversal(node.right);
    }

    //  preoder traversal
    private static void preorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.root + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    //build tree with preOrder method
    static int i = -1;

    private static Node buildBinaryTree(int[] preorder) {
        i++;
        if (preorder[i] == -1)
            return null;
        Node node = new Node(preorder[i]);
        node.left = buildBinaryTree(preorder);
        node.right = buildBinaryTree(preorder);
        return node;
    }

}
