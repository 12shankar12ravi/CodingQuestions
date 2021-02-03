package com.lecture.questions.Oct20Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AdjancyMapGraph<T> {

    private HashMap<T, Vertex> vertexMap = new HashMap();

    private HashMap<Vertex, Vertex> parentMap = new HashMap<>();

    public void addVertex(T value){
        vertexMap.put(value,new Vertex(value));
    }

    public void addEdge(T first,T second){
        Vertex f = vertexMap.get(first);
        Vertex s = vertexMap.get(second);

        if(f!=null && s!=null){
            f.neighbours.put(s,1);
            s.neighbours.put(f,1);
        }

    }

    public void addEdgeWeight(T first,T second,int weight){
        Vertex f = vertexMap.get(first);
        Vertex s = vertexMap.get(second);

        if(f!=null && s!=null){
            f.neighbours.put(s,weight);
            s.neighbours.put(f,weight);
        }

    }

    /**
     *  Krusal algorithm gives the minimum spanning graph (A connected graph with minimum edges with minimum weight (no cycles))
     *    1. We will save all edges to list in ascending order of their weights
     *    2. We will add edges to the answer graph one by one , and check if it is possible to addEdge (check if cycle is there or not)
     *    3. Cycle detection we will ensure by using parent child example
     *        a) We will have a parent hashmap , in that key will be vertex and value of parent vertex.
     *        b) Before adding the edge b/w two vertex we will check whether both edges has same parents or not (if yes don't add edge)
     *        else add the edge and add the two vertex in parent map also.
     * @return
     */
    public AdjancyMapGraph<T> kruskal(){
        AdjancyMapGraph<T> graph = new AdjancyMapGraph<>();
        ArrayList<Edge> edgesList = new ArrayList<>();

        // Adding vertex to resultant graph from the input graph
        for (T value: vertexMap.keySet()) {
            graph.addVertex(value);
        }

        for (Vertex vertex: vertexMap.values()) {
            for (Vertex padosi : vertex.neighbours.keySet()) {
                edgesList.add(new Edge(vertex,padosi,vertex.neighbours.get(padosi)));
            }
        }

        Collections.sort(edgesList);

        for (Edge edge: edgesList) {
            if(union(edge.first,edge.second)){
                graph.addEdgeWeight(edge.first.value,edge.second.value,edge.weight);
            }
        }


        return graph;
    }


    public boolean union(Vertex first , Vertex second){
        Vertex f = getParent(first);
        Vertex s = getParent(second);

        if(!f.value.equals(s.value)){
            parentMap.put(second,first);
            return true;
        }

        return false;
    }

    public Vertex getParent(Vertex vertex){
        while (parentMap.get(vertex)!=null){
            vertex = parentMap.get(vertex);
        }
        return vertex;
    }


    public void display(){
        for (Vertex v: vertexMap.values()) {
            System.out.print(v.value + " => ");
            for (Vertex padosi : v.neighbours.keySet()) {
                System.out.print(padosi.value+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    class Edge implements Comparable<Edge> {
        Vertex first;
        Vertex second;
        int weight;

        public Edge(Vertex first, Vertex second, int weight) {
            this.first = first;
            this.second = second;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge obj) {
            return this.weight - obj.weight;
        }
    }


    class Vertex{
        T value;
        HashMap<Vertex,Integer> neighbours;

        Vertex(T value){
            this.value = value;
            neighbours = new HashMap<>();
        }
    }

}
