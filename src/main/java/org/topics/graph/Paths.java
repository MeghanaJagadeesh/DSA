package org.topics.graph;

import java.util.ArrayList;
import java.util.List;

public class Paths {
    
    //find all the possible path to reach the destination
    public void findpath(ArrayList<Edges> graph[], boolean[] visited, int current, String path, int target) {
        if (current == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[current].size(); i++) {
            Edges edges = graph[current].get(i);
            if (!visited[edges.destination]) {
                visited[current] = true;
                findpath(graph, visited, edges.destination, path + edges.destination, target);
                visited[current] = false;
                //visited[current]=false because, we need to find all the possibe path, if once it is the true we can't iterate it again
                //if we don't use visited[] we will get stuck inside the loop of 3 and 4 while backward;
            }
        }
    }
    public void shortestPath(ArrayList<Edges> graph[], boolean[] visited, int current, int target, String path, List<String> result){
        if(current==target){
            System.out.println(path);
            result.add(path);
            return;
        }

        for(int i=0; i<graph[current].size();i++){
            Edges edges=graph[current].get(i);
            if(!visited[edges.destination]){
                visited[current]=true;
                shortestPath(graph, visited,edges.destination,target,path+edges.destination,result);
                visited[current]=false;
            }
        }
    }

}
