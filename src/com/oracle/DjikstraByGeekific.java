package com.oracle;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DjikstraByGeekific {

    public static void main(String[] args){
     Node nodeA = new Node("A");
     Node nodeB = new Node("B");
     Node nodeC = new Node("C");
     Node nodeD = new Node("D");
     Node nodeE = new Node("E");
     Node nodeF = new Node("F");

      nodeA.addAdjacentNode(nodeB, 2); 
      nodeA.addAdjacentNode(nodeC, 4);
      
      nodeB.addAdjacentNode(nodeC,3);
      nodeB.addAdjacentNode(nodeD, 1);
      nodeB.addAdjacentNode(nodeE, 5);


      nodeC.addAdjacentNode(nodeD, 2);

      nodeD.addAdjacentNode(nodeE, 1);
      nodeD.addAdjacentNode(nodeF, 4);

      nodeE.addAdjacentNode(nodeF, 2);

      calculateShortestPath(nodeA);
    
      printPath(Arrays.asList(nodeA,nodeB,nodeC,nodeD,nodeE,nodeF));



    }


public static void calculateShortestPath(Node source){
source.setDistance(0);
Set<Node> settleNodes = new HashSet<>();
Queue<Node> unsettletNodes = new PriorityQueue<>(Collections.singleton(source));
while (!unsettletNodes.isEmpty()) {
    Node currentNode = unsettletNodes.poll();
    currentNode.getAdjacentNodes()
    .entrySet().stream()
    .filter(entry -> !settleNodes.contains(entry.getKey()))
    .forEach(entry-> {
        evaluateDistanceAndPath(entry.getKey(),entry.getValue(),currentNode);
        unsettletNodes.add(entry.getKey());
    });
    settleNodes.add(currentNode);
} 



}


private static void evaluateDistanceAndPath(Node adjacentNode, Integer edgeWeight, Node sourceNode) {
   Integer newDistance = sourceNode.getDistance()+ edgeWeight;
if(newDistance < adjacentNode.getDistance()){
    adjacentNode.setDistance(newDistance);
    adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(),
    Stream.of(sourceNode)).toList());
}


}


private static void printPath(List<Node> nodes){
     System.out.println("execute process ");

nodes.forEach(node -> {
String path = node.getShortestPath().stream()
    .map(Node::getName)
    .collect(Collectors.joining("->  "));
    System.out.println(path.isBlank()? "%s : %s".formatted(node.getName(),
    node.getDistance()) :" %s -> %s : %s".formatted(path, node.getName(),node.getDistance())
);

});

}


}






    









 class Node implements Comparable<Node> {

private String name;
private Integer distance = Integer.MAX_VALUE;
private List<Node> shortestPath = new LinkedList<>();
private Map<Node,Integer> adjacentNodes = new HashMap<>();



public Node(String name, Integer distance, List<Node> shortestPath, Map<Node, Integer> adjacentNodes) {
    this.name = name;
    this.distance = distance;
    this.shortestPath = shortestPath;
    this.adjacentNodes = adjacentNodes;
}

public Node(String name) {
    this.name = name;
    
}



public void addAdjacentNode(Node node, int weight) {
    adjacentNodes.put(node, weight);
}



@Override
public int compareTo(Node node) {
    return Integer.compare(this.distance,node.getDistance());
}


public Integer getDistance() {
    return distance;
}

public String getName(){
    return name;
}

public void setDistance(Integer distance) {
    this.distance = distance;
}

public List<Node> getShortestPath() {
    return shortestPath;
}

public void setShortestPath(List<Node> shortestPath) {
    this.shortestPath = shortestPath;
}

public Map<Node, Integer> getAdjacentNodes() {
    return adjacentNodes;
}

public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
    this.adjacentNodes = adjacentNodes;
}





}
