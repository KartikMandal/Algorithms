package com.kartik.org;

/**
 * 
 * @author kmandal
 *<code>
 *Fibonacci Iterative vs. Recursive.
Iterator: o(n)
static int fib(int n) 
    { 
        int a = 0, b = 1, c; 
        if (n == 0) 
            return a; 
        for (int i = 2; i <= n; i++) { 
            c = a + b; 
            a = b; 
            b = c; 
        } 
        return b; 
    } 
Fibonacci series:
fib(n) = fib(n-1) + fib(n-2) -> for n > 1
fib(n) = 1-> for n = 0, 1
Fibonacci can be solved iteratively as well as recursively
Recursive approach:
The recursive approach seems to be much simpler and smaller, but there is a caveat, as it is calculating the Fibonacci of a number multiple times.
Time Complexity:
The time complexity of the iterative code is linear, as the loop runs from 2 to n, i.e. it runs in O(n) time
Calculating the time complexity of the recursive approach is not so straightforward, so we are going to dive in
fib(n):
    if n <= 1
        return 1
    return fib(n - 1) + fib(n - 2)
for n > 1:
T(n) = T(n-1) + T(n-2) + 4 (1 comparison, 2 subtractions, 1 addition)
Let’s say c = 4 and try to first establish a lower bound by approximating that T(n-1) ~ T(n-2) , though T(n-1) >= T(n-2), hence lower bound
T(n) = T(n-1) + T(n-2) + c
     = 2T(n-2) + c    //from the approximation T(n-1) ~ T(n-2)
     = 2*(2T(n-4) + c) + c
     = 4T(n-4) + 3c
     = 8T(n-8) + 7c
     = 2^k * T(n - 2k) + (2^k - 1)*c
Let's find the value of k for which: n - 2k = 0
k = n/2
T(n) = 2^(n/2) * T(0) + (2^(n/2) - 1)*c
     = 2^(n/2) * (1 + c) - c
i.e. T(n) ~ 2^(n/2)
now for the upper bound we can approximate T(n-2) ~ T(n-1) as T(n-2) <= T(n-1)
T(n) = T(n-1) + T(n-2) + c
     = 2T(n-1) + c    //from the approximation T(n-1) ~ T(n-2)
     = 2*(2T(n-2) + c) + c
     = 4T(n-2) + 3c
     = 8T(n-3) + 7c
     = 2^k * T(n - k) + (2^k - 1)*c
Let's find the value of k for which: n - k = 0
k = n
T(n) = 2^n * T(0) + (2^n - 1)*c
     = 2^n * (1 + c) - c
i.e. T(n) ~ 2^n
Hence the time taken by recursive Fibonacci is O(2^n) or exponential.
Space Complexity:
For the iterative approach, the amount of space required is the same for fib(6) and fib(100), i.e. as N changes the space/memory used remains the same. Hence it’s space complexity is O(1) or constant.
For Fibonacci recursive implementation or any recursive algorithm the space required is proportional to the maximum depth of the recursion tree, because , that is the maximum number of elements that can be present in the implicit function call stack.
Below is a diagrammatic representation of the Fibonacci recursion tree for fib(6):
 *</code>
 */
public class Fibonacci {

	static int MAX = 1000;
    static int f[];
     /**
      *<code>
 *Below is one more interesting recurrence formula that can be used to find n’th Fibonacci Number in O(Log n) time.

If n is even then k = n/2:
F(n) = [2*F(k-1) + F(k)]*F(k)

If n is odd then k = (n + 1)/2
F(n) = F(k)*F(k) + F(k-1)*F(k-1)
 *</code>
      * @param n
      * @return
      */
    // Returns n'th fibonacci number using 
    // table f[]
    public static int fib(int n)
    {
        // Base cases
        if (n == 0)
            return 0;
             
        if (n == 1 || n == 2)
            return (f[n] = 1);
      
        // If fib(n) is already computed
        if (f[n] != 0)
            return f[n];
      
        int k = (n & 1) == 1? (n + 1) / 2
                            : n / 2;
      
        // Applyting above formula [Note value
        // n&1 is 1 if n is odd, else 0.
        f[n] = (n & 1) == 1? (fib(k) * fib(k) + 
                        fib(k - 1) * fib(k - 1))
                       : (2 * fib(k - 1) + fib(k)) 
                       * fib(k);
      
        return f[n];
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        int n = 9;
        f= new int[MAX];
        System.out.println(fib(n));
    }

}
