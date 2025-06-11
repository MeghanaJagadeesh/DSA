package org.topics.graph;

import java.util.ArrayList;

public class AdjacencyListGraph {
    //Adjacency List
    static int v=4;
    static ArrayList<Edges> graph[]=new ArrayList[v];
    static ArrayList<Edges1> graph1[]=new ArrayList[v];
    public static void main(String[] args) {
        //Unweighed graph
        storeUnweightedGraph(graph);
        getNeighbours(2) ;

        //weighted grapg
        storWweightedGraph(graph1);
        getNeighboursOfWeighedGrapg(2);
    }

    private static void storWweightedGraph(ArrayList<Edges1>[] graph) {
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edges1(0,2,2));
        graph[1].add(new Edges1(1,2,10));
        graph[1].add(new Edges1(1,3,0));
        graph[2].add(new Edges1(2,0,2));
        graph[2].add(new Edges1(2,1,10));
        graph[2].add(new Edges1(2,3,-1));
        graph[3].add(new Edges1(3,1,0));
        graph[3].add(new Edges1(3,2,-1));
    }

    private static void getNeighboursOfWeighedGrapg(int src) {
        for(int i=0; i<graph1[src].size(); i++){
            Edges1 edge=graph1[src].get(i);
            System.out.println(edge.destination+", "+edge.weight);
            
        }
    }

    private static void getNeighbours(int src) {
        for(int i=0; i<graph[src].size(); i++){
            System.out.print(graph[src].get(i).destination+" ");
        }
        System.out.println();
    }

    private static void storeUnweightedGraph(ArrayList<Edges>[] graph) {
//        graph is null, if we store anything in null we will get error, so we need to create empty object
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<Edges>();
        }
        graph[0].add(new Edges(0,2));
        graph[1].add(new Edges(1,2));
        graph[1].add(new Edges(1,3));
        graph[2].add(new Edges(2,0));
        graph[2].add(new Edges(2,1));
        graph[2].add(new Edges(2,3));
        graph[3].add(new Edges(3,1));
        graph[3].add(new Edges(3,2));

    }
}
