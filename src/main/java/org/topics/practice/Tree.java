package org.topics.practice;

import org.topics.binarytree.Node;
import org.topics.graph.Edges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    public static void main(String[] args) {
        int[] preorder = {1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1};
        Node node = buildBinaryTree(preorder);
//        Traversals
        preorder(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        postOrder(node);
        System.out.println();
        levelOrder(node);
        System.out.println();
        findLevels(node);
//        Graph.findLevels(node);
    }

    private static void findLevels(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelSize = queue.size();// mention queue size separately because that is where we can get the level, as we are adding the data in queue with in for loop
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        System.out.println("levels: " + level);
    }


    private static void levelOrder(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.root + ", ");
            if (current.left != null) {
                levelOrder(current.left);
            }
            if (current.right != null) {
                levelOrder(current.right);
            }

        }
    }


    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.root + "-");
    }

    private static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.root + "->");
        inOrder(node.right);
    }

    private static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.root + ", ");
        preorder(node.left);
        preorder(node.right);
    }

    static int i = -1;

    private static Node buildBinaryTree(int[] preorder) {
        i++;
        if (preorder.length <= 0 || preorder[i] == -1) {
            return null;
        }
        Node node = new Node(preorder[i]);
        node.left = buildBinaryTree(preorder);
        node.right = buildBinaryTree(preorder);
        return node;
    }


    public static void bfs(ArrayList<Edges> graph[], int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                for (Edges edge : graph[current]) {
                    queue.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edges>[] graph, boolean[] visited, int current) {
        System.out.print(current + " ");
        visited[current] = true;
        for (Edges edge : graph[current]) {
            if (!visited[edge.destination]) {
                dfs(graph, visited, edge.destination);
            }
        }
    }

    public static void findAllPaths(ArrayList<Edges>[] graph, boolean[] visited, int current, int target, String path, List<String> paths) {
        if (current == target) {
            paths.add(path);
            return;
        }
        for (Edges edge : graph[current]) {
            if (!visited[edge.destination]) {
                visited[current] = true;
                findAllPaths(graph, visited, edge.destination, target, path + edge.destination, paths);
                visited[current] = false;
            }
        }
    }

    public static void shortPath(ArrayList<Edges>[] graph, int src, int target) {
        List<String> paths = new ArrayList<>();
        findAllPaths(graph, new boolean[graph.length], src, target, src + "", paths);
        int length = Integer.MAX_VALUE;
        String shortest = "";
        for (String path : paths) {
            if (path.length() < length) {
                shortest = path;
                length = path.length();
            }
        }
        System.out.println("shortest path: " + shortest);
        paths.stream().forEach(n-> System.out.print(n+" "));
    }
}
