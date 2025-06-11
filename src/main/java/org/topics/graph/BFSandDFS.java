package org.topics.graph;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
        0
       / \
      1   2
       \   \
        3---4
         \ /
          5
           \
            6

 */
public class BFSandDFS {

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edges> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.print("bfs : ");
        bfs(graph, v);

        System.out.print("dfs : ");
        dfs(graph, 0, new boolean[v]);
        System.out.println();


        Paths paths=new Paths();
        int target=5;
        int src=0;
        System.out.println("available paths are : ");
        paths.findpath(graph,new boolean[v],src,src+"",target);


        System.out.println("just");
        List<String> result=new ArrayList<>();
        paths.shortestPath(graph,new boolean[v], 2,target,2+"", result );
        int length=Integer.MAX_VALUE;
        String shortest= "";
        for (String res:result){
            if(res.length()<length) {
                length = res.length();
                shortest = res;
            }
        }
        System.out.println("shortest path : "+shortest);
    }

    public static void createGraph(ArrayList<Edges> graph[]) {
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

    //    TC=O(v+e)
    public static void bfs(ArrayList<Edges> graph[], int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        queue.add(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
                for (int i = 0; i < graph[current].size(); i++) {
                    Edges edges = graph[current].get(i);
                    queue.add(edges.destination);
                }
            }
        }
        System.out.println();
    }

    //    TC=O(v+e)
    //
    public static void dfs(ArrayList<Edges> graph[], int current, boolean[] visited) {
        System.out.print(current + " ");
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edges edges = graph[current].get(i);
            if (!visited[edges.destination]) {
                dfs(graph, edges.destination, visited);
            }
        }
    }
}
