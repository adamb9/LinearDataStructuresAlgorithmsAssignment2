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
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 	
		
		//Scenario 1. MyList is empty
		if (m.length() == 0)
			scenario = 1;
		//Scenario 2. MyList has exactly 1 element
		else if(m.length() == 1) {
			scenario = 2;
		}
		//Scenario 3. MyList has more than 1 element
		else {
			scenario = 3;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		
		case 1:
			break;
			
		case 2:
			System.out.println(m.getElement(0));
			break;
		
		case 3: 
			//1. We get the first element of MyList
			int e0 = m.getElement(0);
			
			//2. We remove the first element from MyList we just checked
			m.removeElement(0);
			
			System.out.print(e0);
			
			//3. We recursively solve the smaller problem
			recursiveDisplayElements(m);

			//4. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);
			
			
			
			
			break;
		}
					
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Scenario 1. MyList is empty
		if (m.length() == 0)
			scenario = 1;
		//Scenario 2. MyList has exactly 1 element
		else if(m.length() == 1) {
			scenario = 2;
		}
		//Scenario 3. MyList has more than 1 element
		else {
			scenario = 3;
		}
			
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		case 1: 
			break;
			
		case 2: 
			//We get the first element of MyList
			int e0 = m.getElement(0);
			
			//It the element is smaller than e, it is added to the list
			if(e > e0) {
				res.addElement(0, e0);
			}
		
		case 3:
			//1. We get the first element of MyList
			e0 = m.getElement(0);
			
			//2. We remove the first element from MyList we just checked
			m.removeElement(0);
			
			//3. We recursively solve the smaller problem
			res = smallerMyList(m,e);
			
			//4. We add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);
			
			//5. We compute the final result, based on the value that we were hosting.
			if(e>e0) {
				res.addElement(0, e0);
			}
			break;
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();

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
		//Scenario 2. MyList has exactly 1 element
		else if(m.length() == 1) {
			scenario = 2;
		}
		//Scenario 3. MyList has more than 1 element
		else {
			scenario = 3;
		}
			
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		
		case 1: 
			break;

		case 2: 
			//We get the first element of MyList
			int e0 = m.getElement(0);
			
			//It the element is greater than or equal to e, it is added to the list
			if(e <= e0) {
				res.addElement(0, e0);
			}
		
		case 3:
			//1. We get the first element of MyList
			e0 = m.getElement(0);
			
			//2. We remove the first element from MyList we just checked
			m.removeElement(0);
			
			//3. We recursively solve the smaller problem
			res = biggerEqualMyList(m,e);
			
			//4. We add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);
			
			//5. We compute the final result, based on the value that we were hosting.
			if(e <= e0) {
				res.addElement(0, e0);
			}
			break;
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res =new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 		
		
		//Scenario 1: m1 is empty and m2 is empty
		if(m1.length() == 0 && m2.length() == 0) {
			scenario = 1;
		}
		//Scenario 2: m1 is empty and m2 contains some elements
		else if( m1.length() == 0 && m2.length() > 0 ) {
			scenario = 2;
		}
		//Scenario 3: m1 has some elements and m2 is empty
		else if(m2.length() == 0 && m1.length() > 0 ) {
			scenario = 3;
		}
		//Scenario 4: m1 and m2 both have elements
		else {
			scenario = 4;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
			
		switch(scenario){	
		case 1:
			break;
			
		case 2:
			//1. We get the first element of MyList
			int e0 = m2.getElement(0);
			//2. We remove the first element from MyList we just checked
			m2.removeElement(0);
			//3. We recursively solve the smaller problem
			res = concatenate(m1, m2);
			//4. We add the element back to m, so as to not to modify its original state
			//We add the element to res so the list returned contains all elements of both lists
			res.addElement(0, e0);
			m2.addElement(0, e0);
			break;
			
		case 3:
			//1. We get the first element of MyList
			e0 = m1.getElement(0);
			//2. We remove the first element from MyList we just checked
			m1.removeElement(0);
			//3. We recursively solve the smaller problem
			res = concatenate(m2, m1);
			//4. We add the element back to m, so as to not to modify its original state
			//We add the element to res so the list returned contains all elements of both lists
			res.addElement(0, e0);
			m1.addElement(0, e0);
			break;
		
		case 4:
			//1. We get the first element of MyList
			e0 = m1.getElement(0);
			//2. We remove the first element from MyList we just checked
			m1.removeElement(0);
			//3. We recursively solve the smaller problem
			res = concatenate(m1, m2);
			//4. We add the element back to m, so as to not to modify its original state
			//We add the element to res so the list returned contains all elements of both lists
			res.addElement(0, e0);
			m1.addElement(0, e0);
			break;
		}
			
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
	
	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList();
		
		MyList<Integer> list1 = new MyDynamicList();
		MyList<Integer> list2 = new MyDynamicList();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Scenario 1: The list is empty
		if(m.length() == 0) {
			scenario = 1;
		}
		//Scenario 2: The list has only one element
		else if(m.length() == 1) {
			scenario = 2;
		}
		//Scenario 3: The list has more than one element
		else {
			scenario = 3;
		}
		
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
			
		switch(scenario){	
			
		case 1:
			break;
			
		case 2:
			//We get the first element of MyList
			int e0 = m.getElement(0);
			//We add this element to res
			res.addElement(0,  e0);
			
			break;
				
		
		case 3:
			//We get the first element of MyList
			e0 = m.getElement(0);
			//We remove the first element from MyList we just checked
			m.removeElement(0);
			
			//We call the smallerMyList method and the biggerEqualMyList method on lists 1 and 2 respectively
			list1 = smallerMyList(m, e0);
			list2 = biggerEqualMyList(m, e0);
			
			//We recursively sort the lists
			list1 = quickSort(list1);
			list2 = quickSort(list2);
			
			list2.addElement(0, e0);
			
			//We concatenate the 2 lists
			res = concatenate(list1, list2);
			
			//We add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);
			
			break;
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}		
	
}
