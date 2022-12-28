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



*/
public class StackImplementByArray {

		int size;
		int arr[];
		int top; //index number of stack
	 
		StackImplementByArray(int size) {
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
	 
		public static void main(String[] args) {
			StackImplementByArray stackImplementByArray = new StackImplementByArray(10);
			stackImplementByArray.pop();
			System.out.println("=================");
			stackImplementByArray.push(10);
			stackImplementByArray.push(30);
			stackImplementByArray.push(50);
			stackImplementByArray.push(40);
			System.out.println("=================");
			stackImplementByArray.pop();
			stackImplementByArray.pop();
			stackImplementByArray.pop();
			System.out.println("=================");
		}
	}