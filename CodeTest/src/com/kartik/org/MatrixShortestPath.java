package com.kartik.org;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * 
 * @author kmandal
 * 
 * The idea is inspired from Lee algorithm and uses BFS.

We start from the source cell and calls BFS procedure.
We maintain a queue to store the coordinates of the matrix and initialize it with the source cell.
We also maintain a Boolean array visited of same size as our input matrix and initialize all its elements to false.
We LOOP till queue is not empty
Dequeue front cell from the queue
Return if the destination coordinates have reached.
For each of its four adjacent cells, if the value is 1 and they are not visited yet, we enqueue it in the queue and also mark them as visited.
Note that BFS works here because it doesn’t consider a single path at once. It considers all the paths starting from the source and moves ahead 
one unit in all those paths at the same time which makes sure that the first
 time when the destination is visited, it is the shortest path.
 *
 */
public class MatrixShortestPath {

	static int ROW = 9; 
	static int COL = 10; 
	  
	// To store matrix cell cordinates 
	static class Point 
	{ 
	    int x; 
	    int y; 
	  
	    public Point(int x, int y) 
	    { 
	        this.x = x; 
	        this.y = y; 
	    } 
	}; 
	  
	// A Data Structure for queue used in BFS 
	static class CustomQueueNode 
	{ 
	    Point pt; // The cordinates of a cell 
	    int dist; // cell's distance of from the source 
	  
	    public CustomQueueNode(Point pt, int dist) 
	    { 
	        this.pt = pt; 
	        this.dist = dist; 
	    } 
	}; 
	  
	// check whether given cell (row, col)  
	// is a valid cell or not. 
	static boolean isValid(int row, int col) 
	{ 
	    // return true if row number and  
	    // column number is in range 
	    return (row >= 0) && (row < ROW) && 
	           (col >= 0) && (col < COL); 
	} 
	  
	// These arrays are used to get row and column 
	// numbers of 4 neighbours of a given cell 
	static int rowNum[] = {-1, 0, 0, 1}; 
	static int colNum[] = {0, -1, 1, 0}; 
	  
	// function to find the shortest path between 
	// a given source cell to a destination cell. 
	static int BFS(int mat[][], Point src, 
	                            Point dest) 
	{ 
	    // check source and destination cell 
	    // of the matrix have value 1 
	    if (mat[src.x][src.y] != 1 ||  
	        mat[dest.x][dest.y] != 1) 
	        return -1; 
	  
	    boolean [][]visited = new boolean[ROW][COL]; 
	      
	    // Mark the source cell as visited 
	    visited[src.x][src.y] = true; 
	  
	    // Create a queue for BFS 
	    Queue<CustomQueueNode> q = new LinkedList<>(); 
	      
	    // Distance of source cell is 0 
	    CustomQueueNode s = new CustomQueueNode(src, 0); 
	    q.add(s); // Enqueue source cell 
	  
	    // Do a BFS starting from source cell 
	    while (!q.isEmpty()) 
	    { 
	        CustomQueueNode curr = q.peek(); 
	        Point pt = curr.pt; 
	  
	        // If we have reached the destination cell, 
	        // we are done 
	        if (pt.x == dest.x && pt.y == dest.y) 
	            return curr.dist; 
	  
	        // Otherwise dequeue the front cell  
	        // in the queue and enqueue 
	        // its adjacent cells 
	        q.remove(); 
	  
	        for (int i = 0; i < 4; i++) 
	        { 
	            int row = pt.x + rowNum[i]; 
	            int col = pt.y + colNum[i]; 
	              
	            // if adjacent cell is valid, has path  
	            // and not visited yet, enqueue it. 
	            if (isValid(row, col) &&  
	                    mat[row][col] == 1 &&  
	                    !visited[row][col]) 
	            { 
	                // mark cell as visited and enqueue it 
	                visited[row][col] = true; 
	                CustomQueueNode adjcell = new CustomQueueNode(new Point(row, col), 
	                                                      curr.dist + 1); 
	                q.add(adjcell); 
	            } 
	        } 
	    } 
	  
	    // Return -1 if destination cannot be reached 
	    return -1; 
	} 
	  
	// Driver Code 
	public static void main(String[] args)  
	{ 
	    int mat[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
	                   { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
	                   { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
	                   { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
	                   { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
	                   { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
	                   { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
	                   { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
	                   { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }}; 
	  
	    Point source = new Point(0, 0); 
	    Point dest = new Point(3, 4); 
	  
	    int dist = BFS(mat, source, dest); 
	  
	    if (dist != Integer.MAX_VALUE) 
	        System.out.println("Shortest Path is " + dist); 
	    else
	        System.out.println("Shortest Path doesn't exist"); 
	    } 
	} 