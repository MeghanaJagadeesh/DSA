package org.topics.practice;

import org.topics.graph.Edges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static void main(String[] args) {
        ArrayList<Edges> graph[] = new ArrayList[7];

        storeGraph(graph);
        getNeighboursOf(2, graph);
        bfs(graph, 0);
        dfs(graph, 0, new boolean[graph.length]);
        System.out.println();
        findAllPossiblePaths(graph, new boolean[graph.length], 0, 5, 0 + "");
        Tree.bfs(graph, 0);
        Tree.dfs(graph, new boolean[graph.length], 0);
//        Tree.findAllPaths(graph, new boolean[graph.length], 0, 5, 0 + "");
        Tree.shortPath(graph, 2, 6);
    }

    private static void findAllPossiblePaths(ArrayList<Edges>[] graph, boolean[] visited, int src, int target, String path) {
        if (src == target) {
            System.out.println(path);
            return;
        }
        for (Edges egde : graph[src]) {
            if (!visited[egde.destination]) {
                visited[src] = true;
                findAllPossiblePaths(graph, visited, egde.destination, target, path + egde.destination);
                visited[src] = false;
            }
        }
    }

    public static void bfs(ArrayList<Edges> graph[], int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
                for (Edges edge : graph[current]) {
                    queue.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edges> graph[], int current, boolean[] visited) {
        System.out.print(current + " ");
        visited[current] = true;
        for (Edges edge : graph[current]) {
            if (!visited[edge.destination]) {
                dfs(graph, edge.destination, visited);
            }
        }
    }

    private static void getNeighboursOf(int src, ArrayList<Edges> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Edges> edges = graph[i];
            for (Edges edge : edges) {
                if (edge.src != src) {
                    continue;
                }
                System.out.print(edge.destination + " ");
            }
        }
        System.out.println();
    }

    private static void storeGraph(ArrayList<Edges> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edges(0, 1));
        graph[0].add(new Edges(0, 2));

        graph[1].add(new Edges(1, 0));
        graph[1].add(new Edges(1, 3));

        graph[2].add(new Edges(2, 0));
        graph[2].add(new Edges(2, 4));

        graph[3].add(new Edges(3, 1));
        graph[3].add(new Edges(3, 4));
        graph[3].add(new Edges(3, 5));

        graph[4].add(new Edges(4, 2));
        graph[4].add(new Edges(4, 3));
        graph[4].add(new Edges(4, 5));

        graph[5].add(new Edges(5, 3));
        graph[5].add(new Edges(5, 4));
        graph[5].add(new Edges(5, 6));

        graph[6].add(new Edges(6, 5));


    }
}
