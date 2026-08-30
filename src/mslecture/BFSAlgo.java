package mslecture;

import java.util.*;

public class BFSAlgo {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("A", List.of("B", "C"));
        graph.put("B", List.of("D", "E"));
        graph.put("C", List.of("F"));
        graph.put("D", List.of());
        graph.put("E", List.of());
        graph.put("F", List.of());

        System.out.println(bfs(graph, "A"));
    }

    private static Set<String> bfs(Map<String, List<String>> graph, String a) {
        Queue<String > dataOfGraph = new LinkedList<>();
        Set<String> visitedNode = new HashSet<>();
        dataOfGraph.offer(a);
        visitedNode.add(a);

        while(!dataOfGraph.isEmpty()){
           String current =  dataOfGraph.poll();
            graph.get(current).forEach(x->{
                if(!visitedNode.contains(x)){
                    visitedNode.add(x);
                    dataOfGraph.offer(x);
                }
            });
        }
        return visitedNode;
    }
}
