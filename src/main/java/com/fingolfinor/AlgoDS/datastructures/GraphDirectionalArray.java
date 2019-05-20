package com.fingolfinor.AlgoDS.datastructures;


import java.util.ArrayList;

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
 */
// TODO can also implement with a SingleLinkedList
public class GraphDirectionalArray {
    // So an array with each Vertex having a List of connected Vertices.

    // Number of vertices - fixed amount sets ArrayList size
    private int vCount;

    // Number of edges
    private int eCount;

    // Array of integer lists - So an ArrayList with each element containing an ArrayList (see constructor)
    private ArrayList[] adjacents;

    public GraphDirectionalArray(int vCount) {
        this.vCount = vCount;
        this.eCount = 0;
        adjacents = new ArrayList[vCount];

        // Initialize each GraphDirectionalArray element
        for (int i = 0; i < vCount; i++) {
            adjacents[i] = new ArrayList<Integer>();
        }
    }

    public int getVertexCount() {
        return vCount;
    }

    public int getEdgeCount() {
        return eCount;
    }

    // Create a Directional relationship between two Vertices
    public void addEdge(int src, int dest) {
        adjacents[src].add(dest);
        eCount++;
    }

    // Gets the connected relationships to a Vertex
    public Object[] adj(int src) {
        return adjacents[src].toArray();
    }
}
