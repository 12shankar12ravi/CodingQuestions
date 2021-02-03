package com.lecture.questions.Oct20Graphs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjancyListGraph<T> {

    private LinkedList<Vertex> vertices = new LinkedList<>();

    public void add(T value){
        vertices.add(new Vertex(value));
    }

    public void addEdge(T first , T second){
        Vertex f = find(first);
        Vertex s = find(second);

        if(f!=null && s!=null) {
            f.neighbours.add(s);
            s.neighbours.add(f);
        }
    }

    public Vertex find(T value){
        for (Vertex vertex:vertices) {
            if(vertex.value.equals(value))
                return vertex;
        }
        return null;
    }

    class Vertex{
        T value ;
        LinkedList<Vertex> neighbours;
        boolean isVisited;
        public Vertex(T value) {
            this.value = value;
            this.neighbours = new LinkedList<>();
            this.isVisited = false;
        }
    }

    public void display(){
        for (Vertex vertex : vertices) {
            System.out.print(vertex.value+" => ");
            for (Vertex v : vertex.neighbours) {
                System.out.print(v.value+" ");
            }
            System.out.println();
        }
    }


    /**
     *   There are two types of traversals in the graph
     *      1. BFT (Breadth first traversal) -> Bit similar to level order in tree
     *      2. DFT (Depth first traversal) -> Bit similar to preorder in the tree
      */

    public void BFTBySet(){
       Vertex vertex = vertices.get(0);
       HashSet<Vertex> visited = new HashSet<>();
       Queue<Vertex> queue = new LinkedList<>();

       queue.add(vertex);
       visited.add(vertex);

       while (!queue.isEmpty()){
            Vertex temp = queue.remove();
            System.out.println(temp.value);

           for (Vertex v : temp.neighbours) {
               if(!visited.contains(v)) {
                   queue.add(v);
                   visited.add(v);
               }
           }

       }

    }

    /**
     * DFT (Depth first traversal ) : it is similar to pre order , first we are printing the current node
     * then go to neighbours and print next node .... so on
     */
    private void DFT(){
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertices.get(0);
        stack.push(vertex);
        vertex.isVisited = true;

        while (!stack.isEmpty()){
            Vertex temp = stack.pop();
            System.out.println(temp.value);
            for (Vertex v : temp.neighbours) {
                if(!v.isVisited){
                    stack.push(v);
                    v.isVisited = true;
                }
            }
        }

        resetVisitedStatus(vertices);

    }

    private void resetVisitedStatus(LinkedList<Vertex> vertices) {
        for (Vertex v: vertices) {
            v.isVisited = false;
        }
    }


    private void BFT(){
        Vertex vertex = vertices.get(0);
        //HashSet<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        vertex.isVisited = true;
        //visited.add(vertex);

        while (!queue.isEmpty()){
            Vertex temp = queue.remove();
            System.out.println(temp.value);
            for (Vertex v : temp.neighbours) {
                if(!v.isVisited) {
                    queue.add(v);
                    v.isVisited = true;
                }
            }
        }

    }

    public void BFTOp(){
        BFT();
        resetVisitedStatus(vertices);
    }

    public void DFTOp(){
        DFT();
        resetVisitedStatus(vertices);
    }


    /**
     *   Print connected components of graph , Print count of connected components of graph
     */
    public int  connectedComponents(){
        int count = 0 ;
        for (Vertex vertex : vertices) {
            if(vertex.isVisited){
                continue;
            }
            count++;
            Queue<Vertex> queue = new LinkedList<>();
            queue.add(vertex);
            vertex.isVisited = true;
            //visited.add(vertex);

            while (!queue.isEmpty()){
                Vertex temp = queue.remove();
                System.out.print(temp.value+" ");
                for (Vertex v : temp.neighbours) {
                    if(!v.isVisited) {
                        queue.add(v);
                        v.isVisited = true;
                    }
                }
            }
            System.out.println();
        }

        resetVisitedStatus(vertices);

        return count;
    }



    /**
     *  Check if graph is connected or not , connected components should be 1 or 0
     */
     public boolean isConnected(){
         return connectedComponents()<=1;
     }


    /**
     *  Check if graph is bipartite or not  (Bipartite means suppose , I have two sets of red and green colour , so in one set
     *  only one color element should exist and elements of same set can't be neighbours (adjacent nodes))
     *
     *    red -------- green
     *     |             |
     *     |             |
     *    green-------red
     *
     *    The above graph is bipartite , as adjacent nodes are not simlar in color.
     *
     *    red -------green
     *     | \        |
     *     |   \      |
     *     |    \     |
     *     |     \    |
     *     |       \  |
     *   green-----red
     *
     *   The above graph is not bipartite as red vertex has same colour red neighbour
     */
     public boolean isBipartite(){
         HashSet<Vertex> red = new HashSet<>();
         HashSet<Vertex> green = new HashSet<>();
         Queue<Vertex> queue = new LinkedList<>();
         // BFT

         Vertex temp = vertices.get(0);
         red.add(temp);
         queue.add(temp);
         temp.isVisited = true;

         while (!queue.isEmpty()){
             Vertex vertex = queue.remove();
             if(red.contains(vertex)){
                 for (Vertex v: vertex.neighbours) {
                     if(!v.isVisited){
                         green.add(v);
                         queue.add(v);
                         v.isVisited = true;
                     }else{
                        if(red.contains(v))
                            return false;
                     }
                 }
             }

             if(green.contains(vertex)){
                 for (Vertex v: vertex.neighbours) {
                     if(!v.isVisited){
                         red.add(v);
                         queue.add(v);
                         v.isVisited = true;
                     }else{
                         if(green.contains(v))
                             return false;
                     }
                 }
             }
         }

         return true;
     }

    /**
     *  No of islands question
     */


}
