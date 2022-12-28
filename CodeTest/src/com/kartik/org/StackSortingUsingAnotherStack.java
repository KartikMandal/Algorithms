package com.kartik.org;
/**
q1		q2
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|___|	|__|	|__|	|__|
|___|	|_2_|	|__|	|__|	|__|
|_1_|	|_1_|	|__|	|__|	|__|
|	 |	|   |	|  |	|  |	|  |


*/
public class StackSortingUsingAnotherStack {
		int size;
		int arr[];
		int top;
	 
		StackSortingUsingAnotherStack(int size) {
			this.size = size;
			this.arr = new int[size];
			this.top = -1;
		}
	 
		public void push(int pushedElement) {
			if (!isFull()) {
				top++;
				arr[top] = pushedElement;
				System.out.println("Pushed element:" + pushedElement);
			} else {
				System.out.println("Stack is full !");
			}
		}
	 
		public int pop() {
			if (!isEmpty()) {
				int returnedTop = top;
				top--;
				System.out.println("Popped element :" + arr[returnedTop]);
				return arr[returnedTop];
	 
			} else {
				System.out.println("Stack is empty !");
				return -1;
			}
		}
	 
		public int peek() {
			return arr[top];
		}
	 
		public boolean isEmpty() {
			return (top == -1);
		}
	 
		public boolean isFull() {
			return (size - 1 == top);
		}
		
		
		// Sort a stack using another stack 
		public static StackSortingUsingAnotherStack sortStack(StackSortingUsingAnotherStack stack)
		{
			StackSortingUsingAnotherStack tempStack = new StackSortingUsingAnotherStack(10);
			while(!stack.isEmpty())
			{
				int currentData=stack.pop();
				while(!tempStack.isEmpty() && tempStack.peek() > currentData) {
					stack.push(tempStack.pop());
				}
				tempStack.push(currentData);
			}
			return tempStack;
		}
		
		public  void printStack(StackSortingUsingAnotherStack stack)
		{
			if(top>=0)
			{
				System.out.println("Elements of stacks are:");
				for (int i = 0; i <= top; i++) {
					System.out.println(arr[i]);
				}
			}
	 
		}
	 
		public static void main(String[] args) {
			StackSortingUsingAnotherStack stackImplementByArray = new StackSortingUsingAnotherStack(10);
			stackImplementByArray.pop();
			System.out.println("=================");
			stackImplementByArray.push(10);
			stackImplementByArray.push(30);
			stackImplementByArray.push(50);
			stackImplementByArray.push(40);
			System.out.println("=================");
			StackSortingUsingAnotherStack sortedStack=sortStack(stackImplementByArray);
			System.out.println("=================");
			System.out.println("After Sorting :");
			System.out.println("=================");
			sortedStack.printStack(sortedStack);
			System.out.println("=================");
		}
	}