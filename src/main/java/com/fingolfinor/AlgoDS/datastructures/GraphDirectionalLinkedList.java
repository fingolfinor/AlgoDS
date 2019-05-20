package com.fingolfinor.AlgoDS.datastructures;


/**
 * Vertices == Nodes. So V = {A,B,C} where A,B,C are Vertices
 *
 * Undirectional GraphDirectionalArray: G = (V, E)
 * - Think of like a Two-Directional relationship
 * - Edges between Vertices. So E = {(A,B), (B,C), (C,A)} So can be written in any order. So E = {(B,A), (C,B)..}
 *
 * e.g. FB Networks where a friend Vertex is connected with another Friend Vertex
 *
 * Directional GraphDirectionalArray:
 * - Same as above but One direction and Order of Vertices is important. Start at Origin, then Destination.
 * - Paths: are following arrows of Vertices to Destination Vertex
 * - Degree: number of Edges connected to a Vertex (with a direction)
 * - Adgjacency: showing neighbours of Pointing-To Vertices. Imagine a spreadsheet table with T/F for (Adjacency) connections
 *
 * e.g. Navigation along streets, a series of one way streets would be the only One-Directional path
 *
 *
 * Represent using:
 * - Multi-Dimensional Array, or
 * - Adjacency List
 *
 * /////////////////
 *
 * Example use:
 *  Graph myGraph = new Graph(2, "directed");
 *  myGraph.addVertex("State");
 *  myGraph.addVertex("Elm");
 *  myGraph.addEdge("State", "Elm");
 */
// TODO can also implement with a SingleLinkedList
public class GraphDirectionalLinkedList {

    Vertex[] arrayOfLists;
    int indexCounter = 0;
    boolean unidrected = true;


    public GraphDirectionalLinkedList(int size, String directedType) {
        if (directedType == "directed") {
            this.unidrected = false;
        }

        arrayOfLists = new Vertex[size];    // No need to initialize each element, will add one at a time
    }

    public void addVertex(String vertexName) {
        // Q. How to know neighbours?
        // A. Just start as null.(WRONG: Assuming to add neighbours later..)
        arrayOfLists[indexCounter] = new Vertex(vertexName, null);

        indexCounter++;
    }

    // Q. I think edges are stored in Neighbour now - so this isn't needed anymore?
    // A. Yes and No. Set Neighbour  on Vertext here.
    public void addEdge(String srcVertexName, String destVertexName) {
        // My Initial understanding:
        // Search list for src
        // on Src, search linkedList if exists
        // if not, add new Neighbour to src

        int vertex1Index = indexForName(srcVertexName);
        int vertex2Index = indexForName(destVertexName);

        // Create a new Edge by linking Source Vertex with a new Destination Vertex
        Vertex sourceVertex = arrayOfLists[vertex1Index];
        sourceVertex.adjacentList = new Node(vertex2Index, sourceVertex.adjacentList);

        // Reverse logic for undirected Graph
        if (unidrected) {
            arrayOfLists[vertex2Index].adjacentList = new Node(vertex1Index, arrayOfLists[vertex2Index].adjacentList);
        }
    }

    // Search through array of Vertices and find index position for target name
    private int indexForName(String name) {
        for (int i = 0; i < arrayOfLists.length; i++) {
            if (arrayOfLists[i].name.equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public void print() {
        for (int i = 0; i < arrayOfLists.length; i++) {
            Vertex currentVertex = arrayOfLists[i];
            System.out.print("Vertex " + currentVertex.name);

            Node current = currentVertex.adjacentList;
            while (current != null) {
                System.out.print(" -->" + arrayOfLists[current.vertexIndex].name);
                current = current.next;
            }

            System.out.println("\n");
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private class Vertex {
        String name;
        Node adjacentList;   // Linked List of Nodes (Vertices)

        public Vertex(String name, Node node) {
            this.name  = name;
            adjacentList = node;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private class Node {        // TODO Neighbour may be a better name - or use LinkedList class instead
        public int vertexIndex;     // Used to mark what Vertex has connection with
        public Node next;

        public Node(int vertexIndex, Node node) {
            this.vertexIndex = vertexIndex;
            next = node;
        }
    }
}
