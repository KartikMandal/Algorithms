package com.kartik.triger.grass.goat;

import java.util.ArrayList;
/**
 * 
 * State interface from which problem states inherit. Defines a method to check
 * if the current state is a goal, generate successors, and find the cost to
 * come to the current state.
 * 
 * @author kartik chandra Mandal
 * 
 */
public interface State {
 /**
  * determine if current state is goal
  * 
  * @return boolean
  */
 boolean isGoal();
 /**
  * generate successors to the current state
  * 
  * @return ArrayList<State>
  */
 ArrayList<State> genSuccessors();
 /**
  * determine cost from initial state to THIS state
  * 
  * @return double
  */
 double findCost();
 /**
  * print the current state
  */
 public void printState();
 /**
  * print the current state
  */
 public void printStateOdd();
 /**
  * compare the actual state data
  * 
  * @param s
  *            s
  * @return boolean
  */
 public boolean equals(State s);
}
