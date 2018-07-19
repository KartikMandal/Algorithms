package com.kartik.org;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Solution4 {
    
	private final int MAX_NO_OF_VERTICES;
    private int adjacency_matrix[][];
 
    public Solution4(int number_of_vertices)
    {
        MAX_NO_OF_VERTICES = number_of_vertices;
        adjacency_matrix = new int[MAX_NO_OF_VERTICES + 1][MAX_NO_OF_VERTICES + 1];
    }
 
    public void setEdge(int from_vertex, int to_vertex, int edge) 
    {
        try 
        {
            adjacency_matrix[from_vertex][to_vertex] = edge;
        } catch (ArrayIndexOutOfBoundsException indexBounce)
        {
            System.out.println("the vertex entered is not present");
        }
    }
 
    public int getEdge(int from_vertex, int to_vertex)
    {
        try 
        {
            return adjacency_matrix[from_vertex][to_vertex];
        } catch (ArrayIndexOutOfBoundsException indexBounce)
        {
            System.out.println("the vertex entered is not present");
        }
        return -1;
    }
 
    public static void main(String... arg) 
    {
        int number_of_vertices, count = 1;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        Solution4 adjacencyMatrix;
 
        try 
        {   
            System.out.println("Enter the Number of Vertices");
            number_of_vertices = scan.nextInt();
 
            System.out.println("Enter the Number of Edges"); 
            int number_of_edges = scan.nextInt();
 
            adjacencyMatrix  = new Solution4(number_of_vertices);
            System.out.println("Enter The Graph Egdes :<source> <destination>");
            while (count <= number_of_edges)
            {
                source = scan.nextInt();
                destination = scan.nextInt();
                adjacencyMatrix.setEdge(source, destination, 1);
                count++;
            }
            System.out.println("The adjacency matrix for given graph is");
            for (int i = 1; i <= number_of_vertices; i++)
                System.out.print(i);
 
            System.out.println();
            for (int i = 1; i <= number_of_vertices; i++) 
            {
                System.out.print(i);
                for (int j = 1; j <= number_of_vertices; j++)
                {
                    System.out.print(adjacencyMatrix.getEdge(i, j));
                } 
                System.out.println();
            }
        } catch (InputMismatchException inputMisMatch) 
        {
            System.out.println("Error in Input Format.<source index> <destination index>");
        }
        scan.close();
    }
}