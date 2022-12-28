package com.kartik.org;


/**
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * @author kmandal
 *
 *Input:   price[] = {10, 22, 5, 75, 65, 80}
Output:  87
Trader earns 87 as sum of 12 and 75
Buy at price 10, sell at 22, buy at 5 and sell at 80

Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
Output:  100
Trader earns 100 as sum of 28 and 72
Buy at price 2, sell at 30, buy at 8 and sell at 80

Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
Output:  72
Buy at price 8 and sell at 80.

Input:   price[] = {90, 80, 70, 60, 50}
Output:  0
Not possible to earn.


We can do this O(n) using following Efficient Solution. The idea is to store the maximum possible profit of every subarray and solve the problem in the following two phases.

1) Create a table profit[0..n-1] and initialize all values in it 0.

2) Traverse price[] from right to left and update profit[i] such that profit[i] stores maximum profit achievable from one transaction in subarray price[i..n-1]

3) Traverse price[] from left to right and update profit[i] such that profit[i] stores maximum profit such that profit[i] contains maximum achievable profit from two transactions in subarray price[0..i].

4) Return profit[n-1]

To do step 2, we need to keep track of the maximum price from right to left side and to do step 3, we need to keep track of the minimum price from left to right. Why we traverse in reverse directions? The idea is to save space, in the third step, we use the same array for both purposes, maximum with 1 transaction and maximum with 2 transactions. After iteration i, the array profit[0..i] contains the maximum profit with 2 transactions and profit[i+1..n-1] contains profit with two transactions.



 */
public class ArrayMaxProfitBuyAndSell {

	// Returns maximum profit with two transactions on a given 
    // list of stock prices, price[0..n-1] 
    static int maxProfit(int price[], int n) 
    { 
        // Create profit array and initialize it as 0 
        int profit[] = new int[n]; 
        for (int i=0; i<n; i++) 
            profit[i] = 0; 
       
        /* Get the maximum profit with only one transaction 
           allowed. After this loop, profit[i] contains maximum 
           profit from price[i..n-1] using at most one trans. */
        int max_price = price[n-1]; 
        for (int i=n-2;i>=0;i--) 
        { 
            // max_price has maximum of price[i..n-1] 
            if (price[i] > max_price) 
                max_price = price[i]; 
       
            // we can get profit[i] by taking maximum of: 
            // a) previous maximum, i.e., profit[i+1] 
            // b) profit by buying at price[i] and selling at 
            //    max_price 
            profit[i] = Math.max(profit[i+1], max_price-price[i]); 
            
        } 
        //price=[2, 30, 15, 10, 8, 25, 80]
      //profit=[78, 72, 72, 72, 72, 55, 0]
       
        /* Get the maximum profit with two transactions allowed 
           After this loop, profit[n-1] contains the result */
        int min_price = price[0]; 
        for (int i=1; i<n; i++) 
        { 
            // min_price is minimum price in price[0..i] 
            if (price[i] < min_price) 
                min_price = price[i]; 
       //min_price=2,
            // Maximum profit is maximum of: 
            // a) previous maximum, i.e., profit[i-1] 
            // b) (Buy, Sell) at (min_price, price[i]) and add 
            //    profit of other trans. stored in profit[i] 
            profit[i] = Math.max(profit[i-1], profit[i] + 
                                        (price[i]-min_price) ); 
        } 
        //profit=[78, 100, 100, 100, 100, 100, 100]
        int result = profit[n-1]; 
        return result; 
    } 
  
    
    
	static BuySellInterval[] buySellIntervalArr;

	public static class BuySellInterval {
		int buy;
		int sell;
	}

	// Returns maximum profit with two transactions on a given
	// list of stock prices, price[0..n-1]
	static void bestTimeBuyAndSell(int price[], int n) {
		int count = 0;
		// if there are no more than 1 element ie, 1 day
		buySellIntervalArr = new BuySellInterval[n];
		if (n == 1) {
			return;
		}

		int i = 0;
		// Till the end of the array
		while (i < n - 1) {

			BuySellInterval buySellInterval = new BuySellInterval();
			//first you need to buy next you will sell,So  Finding the local minima first
			while ((i < n - 1) && (price[i + 1] <= price[i])) {
				i++;
			}
			if (i == n - 1) {
				break;
			}
			// Storing the local minima
			buySellInterval.buy = i++;

			// Finding the local maxima for sell 
			while ((i < n) && (price[i - 1] <=price[i])) {
				i++;
			}
			// Storing the local maxima
			buySellInterval.sell = i - 1;

			// storing global array
			buySellIntervalArr[count] = buySellInterval;

			count++;

		}

		int maxProfit=0;
		if (count == 0) {
			System.out
					.println("There is no day when buying the stock will make profit");
		} else {
			for (int j = 0; j < count; ++j) {
				System.out
						.println("Buy on day "
								+ buySellIntervalArr[j].buy
								+ "  sell on day "
								+ buySellIntervalArr[j].sell
								+ " and maximum profit <--> "
								+ (price[buySellIntervalArr[j].sell] - price[buySellIntervalArr[j].buy]));
				maxProfit=maxProfit+(price[buySellIntervalArr[j].sell] - price[buySellIntervalArr[j].buy]);
			}
		}
		
		System.out.println("Maximum Profit "+maxProfit);

	}

	public static void main(String args[]) {
		int price[] = { 2, 30, 15, 10, 8, 25, 80 };
		int n = price.length;
		System.out.println("Maximum Profit = " + maxProfit(price, n));
		int price2[] = { 100, 180, 260, 310, 40, 535, 695 };
		System.out.println("Maximum Profit ddd= " + maxProfit(price2, price2.length));
		bestTimeBuyAndSell(price2, price2.length);
		bestTimeBuyAndSell(price, price.length);
	}

}
