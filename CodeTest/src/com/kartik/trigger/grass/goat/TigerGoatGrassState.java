package com.kartik.triger.grass.goat;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * A state is defined as a 4-bit string (encapsulated by
 * the Pos enum) which represents whether a particular entity (in the order
 * TigerGoatGrassState) is on the west or east side of the river.
 * 
 * @author kartik chandra Mandal
 * 
 */
public class TigerGoatGrassState implements State
{
 // constant for the goal state
 private final TigerGoatGrassState.Pos[] GOAL = new TigerGoatGrassState.Pos[]
 { Pos.EAST, Pos.EAST, Pos.EAST, Pos.EAST };
 /*
  * All fwgc states are defined by the 4-item array of Pos primitives, either
  * east or west (side of the river) for each member of the problem
  * "BoatMan, Tiger, Goat, Grass" in that order
  */
 public enum Pos
 {
  WEST, EAST
 };
 // The current 4-bit representation of the state
 public Pos[] curState;
 /**
  * Default Constructor
  */
 public TigerGoatGrassState()
 {
  curState = new Pos[]
  { Pos.WEST, Pos.WEST, Pos.WEST, Pos.WEST };
 }
 /**
  * Polymorphic constructor #1
  * 
  * @param fPos
  *            - Farmer position
  * @param wPos
  *            - Tiger position
  * @param gPos
  *            - Goat position
  * @param cPos
  *            - Grass position
  */
 public TigerGoatGrassState(Pos fPos, Pos wPos, Pos gPos, Pos cPos)
 {
  curState = new Pos[]
  { fPos, wPos, gPos, cPos };
 }
 /**
  * Polymorphic constructor #2
  * 
  * @param stateArr
  *            - Array containing a state, which has all four positions
  */
 public TigerGoatGrassState(TigerGoatGrassState.Pos[] stateArr)
 {
  curState = new Pos[]
  { stateArr[0], stateArr[1], stateArr[2], stateArr[3] };
 }
 /**
  * How much it costs to come to this state
  */
 @Override
 public double findCost()
 {
  return 1;
 }
 /**
  * Generate all possible successors to the current state.
  * 
  * Will trim out successor states that match a state description in the
  * "invalid states" array.
  */
 @Override
 public ArrayList<State> genSuccessors()
 {
  ArrayList<State> successors = new ArrayList<State>();
  TigerGoatGrassState.Pos[] tempState = Arrays.copyOf(curState, curState.length);
  /*
   * If the farmer is on the west He can take the w
   */
  // if the farmer is on the west
  if (tempState[0] == Pos.WEST)
  {
   // he must select an entity to take
   // taking the tiger east, if the goat isn't alone there
   if (tempState[1] == Pos.WEST)
   {
    tempState[0] = Pos.EAST;
    tempState[1] = Pos.EAST;
    successors.add(new TigerGoatGrassState(tempState));
    tempState = Arrays.copyOf(curState, curState.length);// reset
   }
   // taking the goat east
   if (tempState[2] == Pos.WEST)
   {
    tempState[0] = Pos.EAST;
    tempState[2] = Pos.EAST;
    successors.add(new TigerGoatGrassState(tempState));
    tempState = Arrays.copyOf(curState, curState.length);
   }
   // taking the grass east, if the goat isn't alone there
   if (tempState[3] == Pos.WEST)
   {
    tempState[0] = Pos.EAST;
    tempState[3] = Pos.EAST;
    successors.add(new TigerGoatGrassState(tempState));
    tempState = Arrays.copyOf(curState, curState.length);
   }
   // going alone, if we didn't add anything
   tempState[0] = Pos.EAST;
   successors.add(new TigerGoatGrassState(tempState));
   tempState = Arrays.copyOf(curState, curState.length);
  }
  // if the farmer is on the east
  else
  {
   // he must select an entity to take
   // taking the tiger west
   if (tempState[1] == Pos.EAST)
   {
    tempState[0] = Pos.WEST;
    tempState[1] = Pos.WEST;
    successors.add(new TigerGoatGrassState(tempState));
    tempState = Arrays.copyOf(curState, curState.length);
   }
   // taking the goat west
   if (tempState[2] == Pos.EAST)
   {
    tempState[0] = Pos.WEST;
    tempState[2] = Pos.WEST;
    successors.add(new TigerGoatGrassState(tempState));
    tempState = Arrays.copyOf(curState, curState.length);
   }
   // taking the grass west
   if (tempState[3] == Pos.EAST)
   {
    tempState[0] = Pos.WEST;
    tempState[3] = Pos.WEST;
    successors.add(new TigerGoatGrassState(tempState));
    tempState = Arrays.copyOf(curState, curState.length);
   }
   // going alone
   tempState[0] = Pos.WEST;
   successors.add(new TigerGoatGrassState(tempState));
   tempState = Arrays.copyOf(curState, curState.length);
  }
  for (int i = 0; i < successors.size(); i++)
  {
   TigerGoatGrassState s = (TigerGoatGrassState) successors.get(i);
   tempState = s.curState;
   // check for conflicts, also don't return to the starting state why
   // not
   if (Arrays.equals(tempState, new TigerGoatGrassState.Pos[]
   { Pos.EAST, Pos.EAST, Pos.WEST, Pos.WEST })
     || Arrays.equals(tempState, new TigerGoatGrassState.Pos[]
     { Pos.EAST, Pos.WEST, Pos.WEST, Pos.WEST })
     || Arrays.equals(tempState, new TigerGoatGrassState.Pos[]
     { Pos.EAST, Pos.WEST, Pos.WEST, Pos.EAST })
     || Arrays.equals(tempState, new TigerGoatGrassState.Pos[]
     { Pos.WEST, Pos.EAST, Pos.EAST, Pos.WEST })
     || Arrays.equals(tempState, new TigerGoatGrassState.Pos[]
     { Pos.WEST, Pos.WEST, Pos.EAST, Pos.EAST })
     || Arrays.equals(tempState, new TigerGoatGrassState.Pos[]
     { Pos.WEST, Pos.EAST, Pos.EAST, Pos.EAST })
     || Arrays.equals(tempState, new TigerGoatGrassState.Pos[]
     { Pos.WEST, Pos.WEST, Pos.WEST, Pos.WEST }))
   {
    successors.remove(i);
    i = 0; // start the search over to ensure all nodes are checked
      // x.x
   }
  }
  return successors;
 }
 /**
  * Check to see if the current state is the goal state.
  * 
  * @return - true or false, depending on whether the current state matches
  *         the goal
  */
 @Override
 public boolean isGoal()
 {
  if (Arrays.equals(curState, GOAL))
  {
   return true;
  }
  return false;
 }
 /**
  * Overriden equals method. Generated by Eclipse
  */
 @Override
 public boolean equals(Object obj)
 {
  if (this == obj)
   return true;
  else if (obj == null)
   return false;
  else if (getClass() != obj.getClass())
   return false;
  TigerGoatGrassState other = (TigerGoatGrassState) obj;
  if (!curState.equals(other.curState))
   return false;
  return true;
 }
 /**
  * Method to print out the current state. Prints the current position of
  * each thing.
  */
 @Override
 public void printState()
 {
 
  System.out.println("Boatman: " + curState[0]+"\t|");
  System.out.println("Tiger: " + curState[1]+"\t|");
  System.out.println("Goat: " + curState[2]+"\t|");
  System.out.println("Grass: " + curState[3]+"\t|");
 }

 @Override
 public void printStateOdd() {
  StringBuffer br = new StringBuffer();
  br.append("Boatman: ").append(curState[0]).append("\n\t\t")
    .append("Tiger: ").append(curState[1]).append("\n\t\t")
    .append("Goat: ").append(curState[2]).append("\n\t\t")
    .append("Grass: ").append(curState[3]).append("\n");
  String newTabFromat = br.toString();
  System.out.println(newTabFromat);
 }

 /**
  * Overloaded equals method to compare two states.
  * 
  * @return true or false, depending on whether the states are equal
  */
 @Override
 public boolean equals(State s)
 {
  if (Arrays.equals(curState, ((TigerGoatGrassState) s).getCurState()))
  {
   return true;
  }
  else
   return false;
 }
 /**
  * @return the curState
  */
 public Pos[] getCurState()
 {
  return curState;
 }
}
