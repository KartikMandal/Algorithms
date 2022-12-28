package com.kartik.org;

/**
 * 
 * @author kmandal
 * 
 * <pre>
3 * 3 * 3 * 3 = 81</pre>

<table summary="Steps to calculate power using recursive function in Java">
	<caption>Execution steps</caption>
	<thead>
		<tr background-color="#EAEAEC">
			<th scope="col">Iteration</th>
			<th scope="col">power()</th>
			<th scope="col">powerRaised</th>
			<th scope="col">result</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>power(3, 4)</td>
			<td>4</td>
			<td>3 * result<sub>2</sub></td>
		</tr>
		<tr>
			<td>2</td>
			<td>power(3, 3)</td>
			<td>3</td>
			<td>3 * 3 * result<sub>3</sub></td>
		</tr>
		<tr>
			<td>3</td>
			<td>power(3, 2)</td>
			<td>2</td>
			<td>3 * 3 * 3 * result<sub>4</sub></td>
		</tr>
		<tr>
			<td>4</td>
			<td>power(3, 1)</td>
			<td>1</td>
			<td>3 * 3 * 3 * 3 * result<sub>final</sub></td>
		</tr>
		<tr>
			<td>Final</td>
			<td>power(3, 0)</td>
			<td>0</td>
			<td>3 * 3 * 3 * 3 * 1 = 81</td>
		</tr>
	</tbody>
</table>
 *
 */
public class Power {

    public static void main(String[] args) {
        int base = 3, powerRaised = 5;
        int result = power(base, powerRaised);

        System.out.printf("%d^%d = %d", base, powerRaised, result);
        System.out.println();
        System.out.printf("%d^%d = %d",base, powerRaised,powerUsingDivideAndConquer(base, powerRaised));
    }

    /**
     * here time complexity is O(n)
     * @param base
     * @param powerRaised
     * @return
     */
    public static int power(int base, int powerRaised) {
        if (powerRaised != 0)
            return (base * power(base, powerRaised - 1));
        else
            return 1;
    }
    
    /**
     * Here Time complexity is O(logy)
     * @param x
     * @param y
     * @return
     */
    public static int powerUsingDivideAndConquer(int x, int y) 
    { 
        int temp; 
        if( y == 0) 
            return 1; 
        temp = powerUsingDivideAndConquer(x, y/2); 
        if (y%2 == 0) 
            return temp*temp; 
        else
            return x*temp*temp;
    } 
}
