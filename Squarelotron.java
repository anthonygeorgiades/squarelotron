package squarelotron;

import java.util.Arrays;

public class Squarelotron implements SquarelotronMethods {

	//instance variables
	public int [][] squarelotron;
	public int size;
	
	//constructor 1
	
	/**
	 * 
	 * @param this is a constructor to fill the two dimensional array
	 * it uses a generalized formula to create a squarelotron of any size and does not use the switch method to limit to those between 4 and 8
	 * it will fill the two dimensional array with the numbers 1 through n^2 in order
	 * note that it also initializes size to n
	 * 
	 */
	public Squarelotron(int n){
		squarelotron = new int[n][n]; //create 2d array called squarelotron
		size = n; //initialize size to n
		for (int i=0; i<n; i++){ //double for loop to cycle through with step, starting from [0][0] and going each i,j iteration by one
			for (int j=0; j<n; j++){
				squarelotron[i][j]= (i*n) + (j+1); //declare each position in the array
			}
		}
		
	}
	
	//constructor 2
	/**
	 * 
	 * @param array- constructor that takes in a 1 dimensional array and turns it into the squarelotron
	 * first we take the square root of the int
	 */
	public Squarelotron(int[] array){ //input any 1D array and return the squarelotron
		int n = (int) Math.sqrt(array.length); //take the square root of the length of the array, which will result in the correct "size" of the@D squarelotron
		size = n; //initialize size to n, which is the square root the length
		squarelotron = new int[n][n]; //define new initialize as having the dimensions nxn
		for (int i=0; i<n; i++){ //use usame double loop as above to cycle through with step, starting from [0][0]
			for (int j=0; j<n; j++){
				squarelotron[i][j]= array[n*i + j]; //declare each position in the array
			}
		}
			
	}
	
	//Methods
	
	/**
	 * 
	 * @param array- this method will construct and return a squarelotron with the given numbers
	 * note that the given array is some perfect square in length
	 * note all the numbers in the array are nonnegative (zero is allowed)
	 * note that all the numbers in the array are less than or equal to 99
	 * if any of aforementioned conditions are not met, return given line of code
	 * @return squarelotron 
	 */
	public static Squarelotron makeSquarelotron(int[] array) {
		// check for errors
	//	if (no errors)
		if (Math.sqrt(array.length) % 1== 0) { //check that array.length (which is just the length of the inputted array) is perfect square and first condition is met
		}else {
			throw new IllegalArgumentException("bad array provided"); //if it is not a perfect square, return this line of code
		}
		int lengtharray = array.length; //go through each number in the array and make sure that it passes the following conditions
			for (int i=0; i<lengtharray; i++){ //for loop to go through each position of length, incremented
				if (array[i]>= 0 || array[i]<99){ //check that each value in every position is less than 99 but at least 0
				}else {
					throw new IllegalArgumentException("bad array provided"); //if this is not the case, return this line of code
				}
			
		}
		return new Squarelotron(array); //if all conditions pass, then with given in inputted array, return a Squarelotron
	}
	

	@Override
	/**
	 * Given an [n][n] squarelotron, return an array of length n*n
	 */
	public int[] numbers() { 
		//return: int[]
		int[] result = new int[size*size];  //determine that size is n*n
		int counter = 0;
		for (int i=0; i<size; i++){ //go through each position and then place that position in an 1d array 
			for (int j=0; j<size; j++){ //continue through each position, from [0][0] all the way through icnrementing by 1continue through each position, from [0][0] all the way through icnrementing by 1
				int current = squarelotron[i][j]; 
				result[counter]=current;
				counter=counter+1;
			}
		}
		return result;
		}
	
	@Override
	/**
	 * this method will perform an upside down flip of the inputted ring 
	 * no other rings will be affected by this method, only the inputted ring
	 * it will return a completely new Squarelotron with the correctly flipped ring
	 * for example, in a 4x4 Squarelotron of [0][0] equals 1 and [4][0] equals 13, then after the flip of ring 1, [0][0] equals 13 and [4][0] equals 1
	 * we will actually take the entered squarelotron, turn it into a 1D array, flip the approprite positions, then return it to a 2d array 
	 */
	public Squarelotron upsideDownFlip(int ring) { 
		int[] returnArray = new int[size*size]; //first return the array of the given size n*n 
		for(int i = 0; i < (size*size); i ++) 
			returnArray[i] = 0; 
		Squarelotron tempSquarelotron = new Squarelotron(returnArray); //first create a completely new temporary Squarelotron
		
		if(size%2 == 0){ //first check that the remainder divided by 2 is 0, showing that size is even (say 4, or 8)
			if(ring > size/2){ //if the ring entered is greater than size /2, pring the following and return the Squarelotron
				System.out.println("Max value of ring possible is: " + (size/2));
				return tempSquarelotron;
			}
		}
		if(size%2 != 0){
			if(ring > (size/2 + 1)){ //performs the same method as above 
				System.out.println("Max value of ring possible is: " + (size/2 + 1));
				return tempSquarelotron;
			}
		}
		
		//create a 1d array of the Squarelotron
		int[][] tempArr = new int[size][size]; //create a temporary array with the given size 
		for(int k = 0; k < size; k++){ //continue through each position, from [0][0] all the way through icnrementing by 1, as we did above
			for(int p = 0; p < size; p++) 
				tempArr[k][p] = squarelotron[k][p]; //temp array has new position [k][p] 
		}
		
		/**
		 * for any given ring entered, we will go through and based on the ring entered, identify the correct position that needs tobe flipped
		 * this method will ensure that the outer ring is not touched but that the first position altered is within the entered ring
		 * it will then cycle back and return the proper value for the values in the inner rings that were affected by the flip method
		 * The original squarelotron should not be modified  
		 */
		for(int j = (ring -1); j <= (size - ring); j++){ //check which position needs to be flipped based on what ring is inputted
			int count = 0;
			for(int i = (ring -1); i <= (size - ring); i++ ){ 
				if(j == (ring - 1) || j == (size - ring)){
					tempArr[size - ring - count][j] = squarelotron[i][j];	
					count++;
				}
				else{
					tempArr[size - ring][j] = squarelotron[ring - 1][j]; //here we ensure that the valus that were not to be impacted are restored 
					tempArr[ring - 1][j] = squarelotron[size - ring][j];
				}
			}
		}
		
		
		int[] tempOneDArr = new int[size*size]; //now go through and place the values that were replaced into a new 2D array 
		int counter = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				tempOneDArr[counter] = tempArr[i][j];
				//System.out.println(returnArr[counter]);
				counter++;
			}
		}
		tempSquarelotron = makeSquarelotron(tempOneDArr);
		//for (int i = 0 ; i < size; i++) {
			//for (int j = 0; j < size; j++) {
			//System.out.print(tempSquarelotron.squarelotron[i][j] + " ");
			//}
			//System.out.println(" ");
		//}
		return tempSquarelotron; //return a new squarelotron after the flip has been implemented 
		
		
	}
	
	/**
	 * this method will, for any inputted ring, flip those values from left to right
	 * it is similar to the method above but now we will be focusing on the particular column positions to flip
	 * we will actually take the entered squarelotron, turn it into a 1D array, flip the appropriate positions, then return it to a 2d array 
	 */
	public Squarelotron leftRightFlip(int ring) {
		int[][] tempArr = new int[size][size]; //again, we will create a temporary array from the original squarelotron
		int[] tempOneDArr = new int[size*size]; 
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				tempArr[i][j] = squarelotron[i][j];

			}
		}		
		/**
		 * 
		 * for any given ring entered, we will go through and based on the ring entered, identify the correct position that needs tobe flipped from left to right
		 * this method will ensure that the outer ring is not touched but that the first position altered is within the entered ring
		 * it will then cycle back and return the proper value for the values in the inner rings that were affected by the flip method 
		 * The original squarelotron should not be modified 
		*/
		for (int j= (ring - 1); j <= (size - ring); j++){ 
			for (int i= (ring  - 1); i <= (size - ring); i++){
				tempArr[i][size-ring-j]= squarelotron[i][ring-1+j];		
			}
		}
			
		for (int j= (ring); j <= (size - ring - 1); j++){
			for (int i= (ring); i <= (size - ring -1); i++){
				tempArr[i][j]= squarelotron[i][j];		
			}
		}
		int counter = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				tempOneDArr[counter] = tempArr[i][j];
				counter++;
			}
		}	

		Squarelotron tempSquarelotron = new Squarelotron(tempOneDArr);
		return tempSquarelotron;
	}

	/**
	 * this method will perform an inverse diagonal flip of anything based on the given ring entered
	 * for example, for a 4x4 matrix with values 0,1,2,3, we will flip the inverse diagonal through so that 0 and 3 are flipped, however the other diagonals are not
	 * this method will ensure that the outer ring is not touched but that the first position altered is within the entered ring
	 */
	public Squarelotron inverseDiagonalFlip(int ring) {
		int[][] tempArr = new int[size][size]; //create a temporary, new place holder of the same size and convert to a 1d array 
		int[] tempOneDArr = new int[size*size];
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				tempArr[i][j] = squarelotron[i][j];

			}
		}		
		
		/**
		 * for a given array, we will use the similar method as performed above in the other flip methods by cyclign through each position based on the ring entered
		 */
		for (int j= (ring - 1); j <= (size - ring); j++){
			for (int i= (ring  - 1); i <= (size - ring); i++){
				tempArr[i][j]= squarelotron[j][i]; //for the inputted squarelotron in the new array, flip the positions with that of the original squarelotron
				tempArr[j][i]= squarelotron[i][j];
			}
		}
			
		for (int j= (ring); j <= (size - ring - 1); j++){
			for (int i= (ring); i <= (size - ring -1); i++){
				tempArr[i][j]= squarelotron[i][j];		
			}
		}
		int counter = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				tempOneDArr[counter] = tempArr[i][j];
				counter++;
			}
		}	

		Squarelotron tempSquarelotron = new Squarelotron(tempOneDArr);
		
		return tempSquarelotron; //return a new squarelotron after the flip has been implemented 
	}

	/**
	 * this method will perform a main diagonal flip of anything based on the given ring entered
	 * for example, for a 4x4 matrix with values 0,1,2,3, we will flip the main diagonal through so that 1 and 2 are flipped, however the other diagonals are not
	 * this method will ensure that the outer ring is not touched but that the first position altered is within the entered ring
	 * The original squarelotron should not be modified 
	 */
	public Squarelotron mainDiagonalFlip(int ring) {
		int[][] tempArr = new int[size][size]; 
		int[] tempOneDArr = new int[size*size];
		
		for(int i = 0; i < size; i++){ //continue through each position, from [0][0] all the way through icnrementing by 1continue through each position, from [0][0] all the way through icnrementing by 1
			for(int j = 0; j < size; j++){
				tempArr[i][j] = squarelotron[i][j];

			}
		}		
		for (int i= (ring - 1); i <= (size - ring); i++){ //based on whatever ring is inputted, determine which position to be flipped based on the size of the squareoloton
			for (int j= (ring  - 1); j <= (size - ring); j++){
				tempArr[size-i-1][size-j-1]= squarelotron[j][i];
			}
		}
			
		for (int j= (ring); j <= (size - ring - 1); j++){ //based on whatever ring is inputted, determine which position to be flipped based on the size of the squareoloton
			for (int i= (ring); i <= (size - ring -1); i++){
				tempArr[i][j]= squarelotron[i][j]; //place the positions of the squarelotron from the temporary array 
			}
		}
		int counter = 0;
		for(int i = 0; i < size; i++){ //increment through each position 
			for(int j = 0; j < size; j++){
				tempOneDArr[counter] = tempArr[i][j]; //place the positions into the temporary array 
				counter++;
			}
		}	

		Squarelotron tempSquarelotron = new Squarelotron(tempOneDArr); 
		
		return tempSquarelotron; //return a full tSquarelotron
	}
	
	/**
	 * this method will perform a side flip based on the string entered
	 * The argument side should be one of the four strings "left", "right", "top", and "bottom"
	 * The two indicated columns (leftmost or rightmost), or the two indicated rows (top two rows or bottom two rows) should be interchanged
	 * The original squarelotron should not be modified 
	 */
	public Squarelotron sideFlip(String side) { 
		int[][] tempArr = new int[size][size]; //create a new array  as a placeholder 
		int[] tempOneDArr = new int[size*size];
		
		for(int i = 0; i < size; i++){ //continue through each position, from [0][0] all the way through incrementing by 1
			for(int j = 0; j < size; j++){
				tempArr[i][j] = squarelotron[i][j];

			}
		}
		if (side.equals("left")){ //if the user enters left proceed to the following in order to flip the values in the leftmost two columns
			int j=0;
			for (int i=0; i<size; i++){ //the temp array takes j+1 of the original, while j for j+1, flipping the left most value
				tempArr[i][j] = squarelotron[i][j+1]; //we place these values into the temp array 
				tempArr[i][j+1] = squarelotron[i][j];
				}
			}else if(side.equals("right")){ //if the user enters right proceed to the following in order to flip the values in the rightmost two column
				int j=size-1;
				for (int i=0; i<size; i++){ //the temp array j takes j-1 of the original, while j for j-1, flipping the right most value
					tempArr[i][j] = squarelotron[i][j-1]; //we place these values into the temp array 
					tempArr[i][j-1] = squarelotron[i][j];
				}
			}else if(side.equals("top")){ //if the user enters top proceed to the following in order to flip the values in the top most two rows
					int i=0;
					for (int j=0; j<size; j++){ //the temp array i takes i+1 of the original, while i+1 for i, flipping the top most values
						tempArr[i][j] = squarelotron[i+1][j]; //we place these values into the temp array 
						tempArr[i+1][j] = squarelotron[i][j];
					}	
		}else if(side.equals("bottom")){ //if the user enters bottom proceed to the following in order to flip the values in the bottom most two rows
			int i=size-1;
			for (int j=0; j<size; j++){ //the temp array i takes i-1 of the original, while i-1 for i, flipping the bottom most values
				tempArr[i][j] = squarelotron[i-1][j]; //we place these values into the temp array 
				tempArr[i-1][j] = squarelotron[i][j];
			}
		}
		int counter = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				tempOneDArr[counter] = tempArr[i][j];
				counter++;
			}
		}	

		Squarelotron tempSquarelotron = new Squarelotron(tempOneDArr); //place the new values of the temp array into a new  Squarelotron
		return tempSquarelotron; //return the new Squarelotron
			
	}

	/**
	 * The argument numberOfTurns indicates the number of times the squarelotron should be rotated 90 clockwise
	 * Any integer, including zero and negative integers, is allowable as the second argument
	 * A value of -1 indicates a 90 counterclockwise rotation
	 * This method modifies the internal representation of the squarelotron and does not create a new one
	 * 
	 */
	public void rotateRight(int numberOfTurns){
			if(numberOfTurns>0){ //if the number of turns entered is greater than 0, proceed to the following for loop to ensure we rotate clockwise 
				for(int k =numberOfTurns; k>0; k--){ //for k number of turns, cycle through and increment through each position 
					for(int i=0; i<size; i++){
						for(int j=0; j<size; j++){
							squarelotron[j][size-i-1] = squarelotron[i][j]; //squarelotron takes the value of j for the original ith position, and the value of size-i-1 for the original j position
						}
				    }
			     }	
			}else if(numberOfTurns<0){ //if the number of turns is negative than we know that we are going counter-clockwise a
				for(int k =numberOfTurns; k<0; k++){ //for k number of turns, cycle through and increment through each position 
					for(int i=0; i<size; i++){
						for(int j=0; j<size; j++){
							squarelotron[size-j-1][i] = squarelotron[i][j]; //squarelotron takes the value of size-j-1 for the original ith position, and the value of i for the original j position

						}
					}
				}
			}	
	}
	
	//@Override
	//public boolean equals(Object object){
	
	/**
	 * 
	 * @param args this method returns true if the object is a squarelotron that is equal to this squarelotron, and false otherwise
	 * Squarelotrons that are the same except for rotations are considered equal
	 * Squarelotrons that are different sizes are never equal
	 * start by determining if sizes are equal then go through each rotation to determine equality
	 */
	
	
	 //public boolean equals(Object object){ 
	public boolean equals(Squarelotron other){	 
			
		if (this.size != other.size){  //first if the size is different return false
			//System.out.println(this);
			return false; 
		}
		
		//for (int i = 0; i < 4; i++){ //next for rotating through each one, determine if it is still equal using the helper
		//other = rotateRight(i);
		if (this.helperEquals(other)){
			return true;
		//}
		}
		return false;

	}

	private boolean helperEquals(Squarelotron other){
			
		for (int i = 0; i < other.size; i++){ //determine if each position is the same
			for (int j = 0; j < other.size; j++){
				if (this.squarelotron[i][j] != other.squarelotron[i][j]){ //if positions are not the same return false 
	
					return false;
				}
			}
		}

		return true;

	}
		
	
	
	/**
	 * Returns a printable version of this squarelotron
	 * The returned string should contain newline characters between rows 
	 * calling this method should not result in any input/output
	 * 
	 */
	
	
	 public String toString(){

			String str = ""; 

			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){
					str+="["+this.squarelotron[i][j]+"]";
					if (j == (size - 1)){
						str+='\n';
					}
				}
			}

			return str;

			}
	
	
	
	public static void main(String[] args){
		
	//	makeSquarelotron({1,2,3});
		/*public static void main(String[] args){
		int[] myMatrix = new int[9];
		for(int i = 0; i < 9; i ++)
			myMatrix[i] = i;
		int[] returnArray = new int[9];
		for(int i = 0; i < 9; i ++)
			returnArray[i] = 0;
		Squarelotron returnMatrix = new Squarelotron(returnArray);
		returnMatrix = makeSquarelotron(myMatrix);
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
			System.out.println(returnMatrix.squarelotron[i][j]);
		*/
	}

}
