package Aufgabe10;

public class Edge {
    private Node startnode;
    private Node endnote;
    private int weight;

    public Edge(Node startnode, Node endnote, int weight){
        this.startnode= startnode;
        this.endnote= endnote;
        this.weight= weight;
    }

    public int getWeight() {
        return weight;
    }

    public Node getEndnote() {
        return endnote;
    }
}
