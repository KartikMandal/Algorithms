package com.kartik.org;

import java.util.HashSet;
import java.util.LinkedList;
/**
 * Given two jugs with the maximum capacity of m and n liters respectively. The jugs don’t have markings on them which can help us to measure smaller quantities. The task is to measure d liters of water using these two jugs. Hence our goal is to reach from initial state (m, n) to final state (0, d) or (d, 0).

Examples:

Input: 4 3 2
Output: (0, 0) –> (4, 0) –> (4, 3) –> (0, 3) –> (3, 0) –> (3, 3) –> (4, 2) –> (0, 2)

Input: 5 2 4
Output: (0, 0) –> (5, 0) –> (5, 2) –> (0, 2) –> (2, 0) –> (2, 2) –> (4, 0)
 * 
 * @author kmandal
 *
 */
public class WaterJugBFS {

	class State {
	    /*
	     * Amount in jug1 for current State
	     */

	    int x;
	    /*
	     * Amount in jug2 for current State
	     */
	    int y;

	    /*
	     * Parent of current State
	     */
	    State pre;

	    public State(int x, int y) {
	        super();
	        this.x = x;
	        this.y = y;
	    }

	    public State(int x, int y, State pre) {
	        super();
	        this.x = x;
	        this.y = y;
	        this.pre = pre;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + x;
	        result = prime * result + y;
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        State other = (State) obj;
	        if (x != other.x) {
	            return false;
	        }
	        if (y != other.y) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        StringBuilder builder = new StringBuilder();
	        if (pre != null) {
	            builder.append(pre);
	        }
	        builder.append(x);
	        builder.append("    ").append(y).append("\n");
	        return builder.toString();
	    }
	}

	
	
	HashSet<State> uniqueStates;

    void letsRoll() {
        /*
         * The capacity of jug1(jug1 capacity is greater than jug2 capacity)
         */
        int jug1 = 5;

        /*
         * The capacity of jug two
         */
        int jug2 = 4;

        /*
         * Final Amount needed in jug1
         */
        int amtNeeded = 2;

        State initialState = new State(0, 0);
        State finalState = new State(amtNeeded, 0);
        State finalPath = null;

        uniqueStates = new HashSet<>();

        /*
         * Change queue to stack to convert to DFS
         */
        LinkedList<State> queue = new LinkedList<>();
        queue.add(initialState);

        while (!queue.isEmpty()) {
            State currState = queue.poll();
            if (currState.equals(finalState)) {
                finalPath = currState;
                break;
            }

            // if x is zero fill it
            if (currState.x == 0) {
                State nextState = new State(jug1, currState.y, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if y is empty fill it
            if (currState.y == 0) {
                State nextState = new State(currState.x, jug2, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if x is not empty , empty it
            if (currState.x > 0) {
                State nextState = new State(0, currState.y, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if y is not empty, empty it
            if (currState.y > 0) {
                State nextState = new State(currState.x, 0, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // transfer from x to y, when x non empty and y is not full
            if (currState.x > 0 && currState.y < jug2) {
                int amtToTransfer = Math.min(currState.x, jug2 - currState.y);
                State nextState = new State(currState.x - amtToTransfer, currState.y
                        + amtToTransfer,
                        currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // transfer from y to x, when y is not empty and x is not full
            if (currState.y > 0 && currState.x < jug1) {
                int amtToTransfer = Math.min(currState.y, jug1 - currState.x);
                State nextState = new State(currState.x + amtToTransfer, currState.y
                        - amtToTransfer,
                        currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }
        }
        if (finalPath != null) {
            System.out.println("J1  J2");
            System.out.println(finalPath);
        }
        else{
            System.out.println("Not Possible");
                    
        }
    }

    /*
     * Checks whether State toCheck has been generated before, if not it is
     * added to queue and uniqueStates Set
     */
    void checkUniqueStates(HashSet<State> uniqueStates, State toCheck, 
            LinkedList<State> queue) {
        if (!uniqueStates.contains(toCheck)) {
            uniqueStates.add(toCheck);
            queue.add(toCheck);
        }
    }

   
	public static void main(String[] args) {
		new WaterJugBFS().letsRoll();

	}

}
