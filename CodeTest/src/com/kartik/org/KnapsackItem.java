/**
 * 
 */
package com.kartik.java.eight;

/**
 * @author kmandal
 *
 */
public class KnapsackItem {
	Double cost; 
    double wt, val, ind; 
    String name;
    public KnapsackItem(){
    }
    // item value function 
    public KnapsackItem(int wt, int val, int ind,String name) 
    { 
        this.wt = wt; 
        this.val = val; 
        this.ind = ind; 
        cost = new Double(val/wt ); 
        this.name=name;
    }
	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	/**
	 * @return the wt
	 */
	public double getWt() {
		return wt;
	}
	/**
	 * @param wt the wt to set
	 */
	public void setWt(double wt) {
		this.wt = wt;
	}
	/**
	 * @return the val
	 */
	public double getVal() {
		return val;
	}
	/**
	 * @param val the val to set
	 */
	public void setVal(double val) {
		this.val = val;
	}
	/**
	 * @return the ind
	 */
	public double getInd() {
		return ind;
	}
	/**
	 * @param ind the ind to set
	 */
	public void setInd(double ind) {
		this.ind = ind;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	} 
}
