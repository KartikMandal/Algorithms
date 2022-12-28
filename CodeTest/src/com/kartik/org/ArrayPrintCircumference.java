package com.kartik.org;

public class ArrayPrintCircumference {
	private ArrayPrintCircumference() {
    }

    public static void printCircumference(int[][] matrix) {

        if (matrix == null) {
            throw new NullPointerException("The input matrix cannot be null");
        }

        for (int currentRow = 0, 
                 rowCount = matrix.length, 
                 columnCount = matrix[0].length; currentRow < rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                System.out.println(matrix[currentRow][currentColumn] +"==="+currentRow+"_"+currentColumn
                                   + " --> " 
                                   + collectNeighbors(matrix, rowCount, columnCount, currentRow, currentColumn));
            }
        }
    }

    private static String collectNeighbors(int[][] matrix, int rowCount, int columnCount, int originCellRow, int originCellColumn) {
        StringBuilder neighbors = new StringBuilder();
        StringBuilder neighborsPoint = new StringBuilder();
        for (int neighborRow = Math.max(0, originCellRow - 1), 
                 neighborRowLimit = Math.min(rowCount, originCellRow + 2), 
                 neighborColumnLimit = Math.min(columnCount, originCellColumn + 2); neighborRow < neighborRowLimit; neighborRow++) {
            for (int neighborColumn = Math.max(0, originCellColumn - 1); neighborColumn < neighborColumnLimit; neighborColumn++) {
                if (neighborRow != originCellRow || neighborColumn != originCellColumn) {
                    neighbors.append(matrix[neighborRow][neighborColumn]);
                    neighborsPoint.append(neighborRow+"_"+neighborColumn+" ");
                }
            }
        }
        System.out.println(neighborsPoint.toString());
        return neighbors.toString();
    }
    
    
    public static void main(String args[]){
		int mat[][] = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 1, 0, 1, 0, 1 } 
				};
    	 
    	 printCircumference(mat);
    }
}
