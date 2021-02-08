package Aufgabe10;

import java.util.ArrayList;

public class Node implements Comparable<Node> {
    private String name;
    private int weight;
    private ArrayList<Edge> edgelist;

    public Node(String name){
        this.name= name;
        edgelist= new ArrayList<Edge>();
    }

    public void setWeight(int weight){
        this.weight= weight;
    }

    public int compareTo(Node o){
        if(this.weight>= o.weight){
            return 1;
        } else {
            return -1;
        }
    }

    public void addEdge(Node endnote, int weight){
        edgelist.add(new Edge(this, endnote, weight));
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Edge> getEdges(){
        return this.edgelist;
    }
}
