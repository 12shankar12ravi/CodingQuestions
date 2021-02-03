package com.lecture.questions.Oct20Graphs;

import javax.sound.midi.Soundbank;

public class GraphClient {
    public static void main(String[] args) {
        AdjancyListGraph<String> aGraph = new AdjancyListGraph<>();

        // adding vertices to the graph
        aGraph.add("C");
        aGraph.add("A");
        aGraph.add("B");
        aGraph.add("D");
        aGraph.add("E");

        // Adding the edges to the graph
        aGraph.addEdge("B","C");
        aGraph.addEdge("C","D");
        aGraph.addEdge("A","B");
        aGraph.addEdge("A","D");
        //aGraph.addEdge("A","C");
        //aGraph.addEdge("A","E");

         aGraph.display();

//        aGraph.BFTOp();
//
//        System.out.println("----DFT-------");
//        aGraph.DFTOp();

//        System.out.println("--Connected components--");
//        System.out.println(aGraph.connectedComponents());
//
//        System.out.println(aGraph.isConnected());

        System.out.println(aGraph.isBipartite());

    }
}
