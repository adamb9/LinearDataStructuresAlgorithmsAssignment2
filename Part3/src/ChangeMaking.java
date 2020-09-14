//Author: Adam Baldwin R00176025
//Class: SDH2-A


/**
* Classical Change making problem with an unlimited amount of coins of each type. <br> 
* Version 2: Selection function with more elaborated policy: First biggest-coin.<br> 
* Depending on the type of coins, it can lead to an optimal solution.<br>
* The class encapsulates all the functions of the Greedy schema<br>
*/

public class ChangeMaking {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking(){}

	
	// -------------------------------------------------------------------
	// 1. selectionFunctionFirstCandidate--> It selects the first candidate 
	// -------------------------------------------------------------------
	/**
	 * Given a current solution that is not a final solution, this function
	 * selects the new candidate to be added to it.<br>
	 * The policy followed is very simple: Just pick the first unused item.
	 * 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of first candidate to be selected.
	 */
	public int selectionFunctionFirstCandidate(MyList<Integer> candidates) {

		int res = 0;
		
		return res;
	}

		
	//-------------------------------------------------------------------
	// 1. selectionFunction --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is more elaborated: Pick the best coin according to the objective function of minimizing the number
	 * of coins that make the change of the amount. 
	 * @param candidates: List of candidates
	 * @return: The index of candidate to be selected.
	 */	
	public int selectionFunctionBestCandidate( MyList<Integer> candidates ){
		int res = 0;
		int num = 0;
		//Calculates the largest number in the candidates list and returns it
		for(int i=0; i<candidates.length();i++) {
			int currentNum = candidates.getElement(i);
			if(currentNum > num) {
				num = currentNum;
				res = i;
			}
		}
		return res;
		
	}
	
	//-------------------------------------------------------------------
	// 2. feasibilityTest --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param candidateValue: The value of the candidate coin selected. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
		 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean feasibilityTest(int candidateValue, int amount, int changeGenerated){
		boolean res = false;
		
		if((candidateValue + changeGenerated)<= amount) {
			res = true;
		}
		
		
		return res;
	}
	
	// -------------------------------------------------------------------
	// 5. solutionTest --> It selects if the current solution is the final
	// solution
	// -------------------------------------------------------------------
	/**
	 * Given a current solution, this function states whether it is a final
	 * solution or it can still be improved.<br>
	 * To determine it, it checks whether there is (at least) one item not
	 * picked before that fits into the knapsack.
	 * 
	 * @param nbCandidates:
	 *            number of candidates that have not been yet selected by the
	 *            selection function
	 * @return: Whether the current solution is the final solution.
	 */
	public boolean solutionTest(MyList<Integer> candidates) {
		//Checks to see if there are any candidates that have not been tried
		boolean res = false;
		if(candidates.length() == 0) {
			res = true;
		}
		
		return res;
	}


	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its objective function value according to:<br>
	 * How many coins are used in the solution.<br>
	 * @param sol: The MyList containing the solution to the problem. 
	 * @return: The objective function value of such solution.
	 */	
	public int  objectiveFunction(MyList<Integer> sol){
		//Returns the length of the solution list
		int res = sol.length();
		return res;
	}
	
	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param typeSelectFunc:
	 *            Type of selection function to choose.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(int typeSelectFunc, MyList<Integer> coinValues, int amount){
		int nextNumber = 0;
		int change = 0;
		int index = 0;
		int scenario = 0;
		MyList<Integer> res = new MyDynamicList<Integer>();
		MyList<Integer> candidates = new MyDynamicList<Integer>();
		
		if(coinValues.length() == 0) {
			return coinValues;
		}
		for(int i=0; i<coinValues.length();i++) {
			int num = coinValues.getElement(i);
			candidates.addElement(i, num);
		}
		
		
		if(typeSelectFunc == 1)
			scenario = 1;
		
		else if(typeSelectFunc == 2)
			scenario = 2;
		
		switch(scenario) {
		
		case 1:
			//Dummy coin selection.
			//Loops until a solution has been reached
			//feasabilityTest checks to see if the current coin choice is valid
			while(solutionTest(candidates) == false) {
				index = selectionFunctionFirstCandidate(candidates);
				nextNumber = candidates.getElement(index);
			
				if(feasibilityTest(nextNumber, amount, change) == true) {
					change += nextNumber;
					res.addElement(0, nextNumber);
				}
				else {
					candidates.removeElement(index);
				}
			}
			break;
			
		case 2:
			//Biggest coin selection.
			//Loops until a solution has been reached
			//feasabilityTest checks to see if the current coin choice is valid
			while(solutionTest(candidates) == false) {
				index = selectionFunctionBestCandidate(candidates);
				nextNumber = candidates.getElement(index);
			
				while(feasibilityTest(nextNumber, amount, change) == true) {
					change += nextNumber;
					res.addElement(0, nextNumber);
				}
				candidates.removeElement(index);
				
			}
			break;
		
		}
		for(int i=0;i<res.length();i++) {
			System.out.println(res.getElement(i));
		}
		System.out.println("Number of coins: " + objectiveFunction(res));
		return res;
	}
	
}
