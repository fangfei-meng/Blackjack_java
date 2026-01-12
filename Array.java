package blackjack_haofu;

import java.util.*;
import java.io.PrintWriter;

public class Array 
{
	/*Method Name: print (for integer arrays)
	 * Description: Prints each element in the array to the screen with a space between each element.
	 * Parameters: the array to print
	 * Returns:n/a
	 */
	public static void print(int[] array) 
	{
		System.out.print(array[0]); //print the first element
		//add comma and print from the second element
		for(int i = 1; i<=array.length-1; i++)
		{
			System.out.print(", "+ array[i]);
		}
	}//end print (for integer arrays)
	
	/*Method Name: print (for double arrays)
	 * Description: Prints each element in the array to the screen with a space between each element.
	 * Parameters: the array to print
	 * Returns:n/a
	 */
	public static void print(double[] array) 
	{
		System.out.print(array[0]); //print the first element
		//add comma and print from the second element
		for(int i = 1; i<=array.length-1; i++)
		{
			System.out.print(", "+ array[i]);
		}
	}//end print (for double arrays)
	
	/*Method Name: print (for string arrays)
	 * Description: Prints each element in the array to the screen with a space between each element.
	 * Parameters: the array to print
	 * Returns:n/a
	 */
	public static void print(String[] array) 
	{
		System.out.print(array[0]); //print the first element
		//add comma and print from the second element
		for(int i = 1; i<=array.length-1; i++)
		{
			System.out.print(" "+ array[i]);
		}
	}//end print (for string arrays)
	
	
	
	/*Method Name: createUserDefinedIntArray
	 * Description: Returns array of size indicated filled with information entered by the user
	 * Parameters: array size
	 * Returns: integer array
	 */
	public static int[] createUserDefinedIntArray(int size) 
	{
		//set up
		Scanner myInput = new Scanner (System.in);
		int [] array = new int [size];//collect size
		//stores integers to the array
		for (int i=0; i<array.length ; i++ )
		{
			array[i] = myInput.nextInt();
		}
		//return
		return array;
	}//end createUserDefinedIntArray
	
	
	
	/*Method Name: createEmptyIntArray
	 * Description: Returns empty array of size indicated
	 * Parameters: array size
	 * Returns: integer array
	 */
	public static int[] createEmptyIntArray(int size) 
	{
		int [] array = new int [size]; //create integer array with defined size
		//return
		return array;
	}//end createEmptyIntArray
	
	
	
	/*Method Name: createRandomIntArray
	 * Description: Returns array of size indicated filled with random integers between min and max
	 * Parameters: array size, min, max
	 * Returns: integer array
	 */
	public static int[] createRandomIntArray(int size, int min, int max) 
	{
		//set up
		Random rand = new Random();
		int [] array = new int[size]; //create integer array with defined size
		//fill the array with random integers between min and max
		for(int i=0; i<array.length; i++)
		{
			array[i] = rand.nextInt(min)+(max-min);
		}
		//return
		return array;
	}//end createRandomIntArray
	
	
	
	/*Method Name: findMax
	 * Description: Returns the position of the maximum value in the array.
	 * Parameters: array-the array of the max value to find
	 * Returns: int-position of the max value
	 */
	public static int findMax(int[] array) 
	{
		int maxPosition = 0; // Start with the first number as the maximum
		for (int i = 1; i < array.length; i++) 
        {
            if (array[i] > array[maxPosition]) 
            {
                maxPosition = i; // Update max if current number is larger
            }
        }
		//return
		return maxPosition;
	}// end findMax
	
	
	
	/*Method Name: findMin
	 * Description: Returns the position of the mininum value in the array.
	 * Parameters: array-the array of the min value to find
	 * Returns: int - position of the min value
	 */
	public static int findMin(int[] array)
	{
		int minPosition = 0; // Start with the first number as the minimum
        for (int i = 1; i < array.length; i++) 
        {
            if (array[i] < array[minPosition]) 
            {
                minPosition = i; // Update min if current number is smaller
            }
        }
        //return
		return minPosition;
	}//end findMin
	
	
	
	/*Method Name: swapElements
	 * Description: Swaps the values at index position1 with index position2.
	 * Parameters: array-the array of the values need to be swaped, int-index1, int-index2
	 * Returns: n/a
	 */
	public static void swapElements(int[] array, int position1, int position2) 
	{
		int temp = array [position1];
		array [position1] = array [position2];
		array [position2] = temp;
	}//end swapElements
	
	/*Method Name: swapElements(for String array)
	 * Description: Swaps the values at index position1 with index position2.
	 * Parameters: array-the array of the values need to be swaped, int-index1, int-index2
	 * Returns: n/a
	 */
	public static void swapElements(String[] array, int position1, int position2) 
	{
		String temp = array [position1];
		array [position1] = array [position2];
		array [position2] = temp;
	}//end swapElements
	
	
	
	/*Method Name: findElement
	 * Description: Returns the position of the first instance of the indicated value. Returns -1 if the ‘value’ is not found.
	 * Parameters: int-defined value, array-the array of the value need to be found
	 * Returns: int-index of the element
	 */
	public static int findElement(int value, int[] array) 
	{
		//set up
		int i=0;
		//find value
		for (i=0; array[i]!=value; i++)
		{
			//if value is not found
			if (i>array.length-2)
			{
				i=-1;
				break;
			}
		}
		//return index
		return i;
	}//end findElement
	
	
	
	/*Method Name: countElements
	 * Description: Returns the number of times the ‘value’ is found in the array.
	 * Parameters: int-the value need to be counted, array-the array of the value need to be counted
	 * Returns: int-the number counted
	 */
	public static int countElements(int value, int[] array) 
	{
		//set up
		int i=0;
		int numOfElements = 0;
		//count elements
		for (i=0; i<array.length; i++)
		{
			if (array[i]==value)
			{
				numOfElements++;
			}
		}
		//return the number counted
		return numOfElements;
	}
	
	
	
	/*Method Name: copyArray
	 * Description: Makes a copy of the original array in another location and returns the copy.
	 * Parameters: array-array need to be copied
	 * Returns: array-copy version of the array
	 */
	public static int[] copyArray(int[] originalArray) 
	{
		int[] copyArray = new int[originalArray.length];//create new array
		System.arraycopy(originalArray, 0, copyArray, 0, originalArray.length);//copy array
		//return copied array
		return copyArray;
	}//copyArray
	
	
	
	/*Method Name: checkIfCopy
	 * Description: check if there are two unique arrays that contain all the same elements in the same order but stored in a different location.
	 * Parameters: array-array1, array-array2
	 * Returns: boolean-true/false
	 */
	public static boolean checkIfCopy(int[] array1, int[] array2)
	{
		//check if the two arrays are stored in the same location
		if (array1==array2)
		{
			return false;
		}
		//check if they have same length
		if (array1.length != array2.length)
		{
			return false;
		}
		//use loop to check each element
		for (int i=0; i<array1.length; i++)
		{
			//if there is a different element, return false
			if (array1[i]!=array2[i])
			{
				return false;
			}
		}
		return true;//every element is the same till the end, return true
	}//end checkIfCopy
	
	
	
	/*Method Name: checkIfIdentical
	 * Description: check if the two arrays are stored in the same location
	 * Parameters: array-array1, array-array2
	 * Returns: boolean-true/false
	 */
	public static boolean checkIfIdentical(int[] array1, int[] array2)
	{
		if (array1==array2)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	
	
	/*Method Name: replaceElement
	 * Description: Replaces the element at index ‘position’ with the indicated ‘value’
	 * Parameters: int array-array, int-value, int-position
	 * Returns:n/a
	 */
	public static void replaceElement(int[] array, int value, int position)
	{
		array[position] = value;
	}

	
	
	/*Method Name: replaceElements
	 * Description: Replaces all elements of the original value with the new value
	 * Parameters: int array-array, int-originalValue, int-newValue
	 * Returns: boolean-true/false
	 */
	public static void replaceElements(int[] array, int originalValue, int newValue) 
	{
		do
		{
		array[Array.findElement(originalValue, array)] = newValue;
		}while(Array.findElement(originalValue, array)!= -1);
	}

	
	
	/*Method Name: insertElement
	 * Description: Creates an array with size originalArray.length +1 and inserts the element ‘value’
	 *				at index ‘position’. All other values >position, are shifted to index+1
	 * Parameters: int array-originalArray, int-value, int-position
	 * Returns: int array-newArray
	 */
	public static int[] insertElement(int[] originalArray, int value, int position) 
	{
		int [] newArray = new int[originalArray.length+1];
		System.arraycopy(originalArray, 0, newArray, 0, position);
		newArray [position] = value;
		for (int i=position+1; i<newArray.length; i++)
		{
		newArray[i] = originalArray[i-1];
		}//end loop
		return newArray;
	}

	
	
	/*Method Name: deleteElement
	 * Description: Creates an array with size originalArray.length -1 and deletes the element at
	 * 				index ‘position’. All other values >position, are shifted to index+1
	 * Parameters: int array-originalArray, int-position
	 * Returns: newArray
	 */
	public static int[] deleteElement(int[] originalArray, int position)
	{
		int [] newArray = new int[originalArray.length-1];
		System.arraycopy(originalArray, 0, newArray, 0, position);
		for (int i=position; i<newArray.length; i++)
		{
		newArray[i] = originalArray[i+1];
		}//end loop
		return newArray;
	}

	/*Method Name: deleteElement (for double array)
	 * Description: Creates an array with size originalArray.length -1 and deletes the element at
	 * 				index ‘position’. All other values >position, are shifted to index+1
	 * Parameters: double array-originalArray, int-position
	 * Returns: newArray
	 */
	public static double[] deleteElement(double[] originalArray, int position)
	{
		double [] newArray = new double[originalArray.length-1];
		System.arraycopy(originalArray, 0, newArray, 0, position);
		for (int i=position; i<newArray.length; i++)
		{
		newArray[i] = originalArray[i+1];
		}//end loop
		return newArray;
	}
	
	/*Method Name: deleteElement (for String array)
	 * Description: Creates an array with size originalArray.length -1 and deletes the element at
	 * 				index ‘position’. All other values >position, are shifted to index+1
	 * Parameters: String array-originalArray, int-position
	 * Returns: newArray
	 */
	public static String[] deleteElement(String[] originalArray, int position)
	{
		String [] newArray = new String[originalArray.length-1];
		System.arraycopy(originalArray, 0, newArray, 0, position);
		for (int i=position; i<newArray.length; i++)
		{
		newArray[i] = originalArray[i+1];
		}//end loop
		return newArray;
	}
	
	
	
	/*Method Name: sortHighToLow
	 * Description: Creates a new array where the values from the original array are sorted from
	 * 				the Highest value to the Lowest value
	 * Parameters: int array-originalArray
	 * Returns: newArray
	 */
	public static int[] sortHighToLow(int[] originalArray) 
	{
		int[] newArray = Array.copyArray(originalArray);
		//sort from low to high
		Arrays.sort(newArray);
		//reverse the array
        int first = 0;
        int last = newArray.length - 1;
        int a;
        //swape the first one and the last one, then the second and the second last, etc.
        while (last > first)
        {
            a = newArray[first];
            newArray[first] = newArray[last];
            newArray[last] = a;
            first++;
            last--;
        }
		return newArray;
	}

	
	
	/*Method Name: sortLowToHigh
	 * Description: Creates a new array where the values from the original array are sorted from the
	 * 				Lowest value to the Highest value
	 * Parameters: int array-originalArray
	 * Returns: newArray
	 */
	public static int[] sortLowToHigh(int[] originalArray)
	{
		int[] newArray = Array.copyArray(originalArray);
		//sort from low to high
		Arrays.sort(newArray);
		return newArray;
	}
	
	

	/**Prints each element in an array to a file on a single line, separated by commas.
	* @param myOutput a PrintWriter indicating where to print the information
	* @param array the array of values to print
	* @author Mrs McCaffery
	*/
	public static void printArrayToFile(PrintWriter myOutput, int [] array)
	{
	//prints first line
	myOutput.print(array[0]);
	// prints the rest of the elements separated by commas and spaces
	for (int i = 1; i<=array.length-1; i++)
	{
	myOutput.print(", "+ array[i]);
	} 
	myOutput.println(); //brings cursor to a new line
	}// ends printArrayToFile method
	
	
	/**Prints each element in an array to a file on a single line, separated by commas.
	* @param myOutput a PrintWriter indicating where to print the information
	* @param array the array of values to print
	* @author Mrs McCaffery
	*/
	public static void printArrayToFile(PrintWriter myOutput, String [] array) 
	{
	//prints first line
	myOutput.print(array[0]);
	// prints the rest of the elements separated by commas and spaces
	for (int i = 1; i<=array.length-1; i++)
	{
	myOutput.print(", "+ array[i]);
	}
	myOutput.println(); //brings cursor to a new line
	}// ends printArrayToFile method
	
}
