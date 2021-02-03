package com.lecture.questions.Oct20Graphs;

public class mapGraphClient {
    public static void main(String[] args) {
        AdjancyMapGraph<String> graph = new AdjancyMapGraph<>();

        // adding vertices to the graph
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Adding the edges to the graph
        graph.addEdgeWeight("B","D",4);
        graph.addEdgeWeight("C","D",2);
        graph.addEdgeWeight("A","C",1);
        graph.addEdgeWeight("A","B",3);
        graph.addEdgeWeight("A","D",2);

        //System.out.println("---------------input graph (kruskal algorithm)------------");
        //graph.display();
        AdjancyMapGraph<String> resGraph = graph.kruskal();
        System.out.println("---------------output graph (kruskal algorithm)------------");
        resGraph.display();
    }
}
