package Aufgabe10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Graph {
    HashMap<String, Node> dictionary;

    public Graph(){
        dictionary= new HashMap<String, Node>();
    }

    public void insertEdges(String startNodeName, String endnoteName, int weight){
        if (!dictionary.containsKey(startNodeName)){
            Node node= new Node(startNodeName);
            dictionary.put(startNodeName, node);
        }
        if (!dictionary.containsKey(endnoteName)){
            Node node= new Node(endnoteName);
            dictionary.put(endnoteName, node);
        }
        Node startnode= dictionary.get(startNodeName);
        Node endnode= dictionary.get(endnoteName);

        startnode.addEdge(endnode, weight);
        endnode.addEdge(startnode, weight);
    }

    public String[] getNodes(){
        String [] array= new String[dictionary.size()];
        int i= 0;
        for (String key: dictionary.keySet()){
            array[i]= key;
            i++;
        }
        return array;
    }

    public void dijkstra(String s, Map<String,Integer> result){
        //start Festlegen
        Node currentNode= dictionary.get(s);
        String currentString= s;

        //m füllen mit ausgangswerten
        HashMap<String, Integer> m= new HashMap<String, Integer>();
        for (Node value: dictionary.values()){
            if(value.getName() != s){
                m.put(value.getName(), Integer.MAX_VALUE);
            } else {
                m.put(value.getName(), 0);
            }
        }

        int currentmin= 0;
        String nextString= null;
        while(m.size()!= 0){
            ArrayList<Edge> neighbors= currentNode.getEdges();
            int nodeMin= Integer.MAX_VALUE;

            //durch Kanten iterieren und Gewichte berechnen
            for (Edge edge: neighbors){
                Node endnode= edge.getEndnote();
                String nodeName= endnode.getName();
                if(m.containsKey(nodeName)){
                    int edgeweight= currentmin+ edge.getWeight();
                    if( edgeweight< m.get(nodeName)){
                        m.replace(nodeName, edgeweight);
                        dictionary.get(nodeName).setWeight(edgeweight);
                    }
                    if(edgeweight < nodeMin){
                        nodeMin= edgeweight;
                    }
                }
            }

            result.put(currentString, m.get(currentString));
            m.remove(currentString);

            //find minimum in m
            int min= Integer.MAX_VALUE;
            String minString= null;
            for( String key: m.keySet()){
                int value= m.get(key);
                if(value< min){
                    minString= key;
                    min= value;
                }
            }
            currentmin= min;
            currentString= minString;
            currentNode= dictionary.get(minString);
        }
    }
}
