//Author: Adam Baldwin R00176025
//Class: SDH2-A


/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Scenario 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Scenario 2. MyList is not empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		case 1: 
			System.out.println("Empty MyList");
			break;
			
		case 2: 
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){
		int res = 0;
		int scenario = 0;
		
		//Scenario 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Scenario 2. MyList has some elements
		else
			scenario = 2;	
		
		
		switch(scenario){	
		
		case 1: 
			res = -1;
			break;
			
		case 2: 
			//1. We get the first element of MyList
			int e0 = m.getElement(0);
			
			//2. We remove the first element from MyList we just checked
			m.removeElement(0);
			
			//3. We recursively solve the smaller problem
			res = maxInt(m);
			
			//4. We compute the final result, based on the value that we were hosting.
			if(e0 > res) {
				res = e0;
			}
			
			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);
			
			break;
			 
		}	 
		return res;
	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){
		boolean res = false;

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Scenario 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Scenario 2. MyList has some elements
		else
			scenario = 2;		

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				 
		case 1: 
			res = true;
			break;
			
		case 2: 
			if(m.length() == 1) {
				res = true;
				break;
			}
			//1. We get the first 2 elements of MyList
			int e0 = m.getElement(0);
			int e1 = m.getElement(1);
			
			//2. We remove the first element from MyList we just checked
			m.removeElement(0);
			
			//3. We recursively solve the smaller problem
			res = isReverse(m);
			
			//4. We compute the final result, based on the value that we were hosting.
			if(e1 > e0) {
				res = false;
			}
			
			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);
			
			break;
		}		
			
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
	

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyList<Integer> m, int n){
		int res = 0;

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Scenario 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Scenario 2. MyList has some elements
		else
			scenario = 2;		

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		case 1: 
			res = 0;
			break;
			
		case 2: 
			//1. We get the first element of MyList
			int e0 = m.getElement(0);
			
			//2. We remove the first element from MyList we just checked
			m.removeElement(0);
			
			//3. We recursively solve the smaller problem
			res = getNumAppearances(m, n);
			
			//4. We compute the final result, based on the value that we were hosting.
			if(e0 == n) {
				res += 1;
			} 
			
			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);
			
			break;
		}		
			
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
	
	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){
		int res = 0;
		int scenario = 0;
		
		//Scenario 1: The power is 0
		if(m == 0) 
			scenario = 1;
		
		//Scenario 2: The scenario isn't 0
		else
			scenario = 2;
		
		
		switch(scenario) {
		
		case 1:
			res = 1;
			break;
		
		case 2:
			//We solve the equation recursively
			res = power(n, m-1);
			res = res * n;
			
			break;
		}
		return res;
	}
	
	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){
		int res = 0;
		int scenario = 0;
		
		//Scenario 1: The integer n is 0
		if(n ==0)
			scenario = 1;
		//Scenario 2: The integer n is 1
		else if(n == 1)
			scenario = 2;
		//Scenario 3: The integer n is greater than 2
		else
			scenario = 3;
		
		switch(scenario) {
		
		case 1:
			res = 2;
			break;
		
		case 2:
			res = 1;
			break;
			
		case 3:
			int num1 = lucas(n-1);
			int num2 = lucas(n-2);
			
			res = num1 + num2;
			break;
		
		}
		return res;
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n){
		int scenario = 0;
		
		//Scenario 1: The integer n is 0
		if(n == 0)
			scenario = 1;
		//Scenario 2: The integer is greater than 0
		else
			scenario = 2;
		
		switch(scenario) {
		case 1:
			break;
		case 2:
			drawImage(n-1);
			printStar(n);
			System.out.println();
		
		}
		
	}
	
	public void printStar(int n) {
		System.out.print("*");
		
		if(n > 1) {
			printStar(n-1);
		}
		
	}
		
}
