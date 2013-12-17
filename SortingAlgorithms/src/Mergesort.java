//File: Mergesort.java
// A Java application to illustrate the use of a merge sort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Mergesort.html
 
/******************************************************************************
* The <CODE>Mergesort</CODE> Java application illustrates a merge sort.
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/Mergesort.java">
*   http://www.cs.colorado.edu/~main/applications/Mergesort.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Dec 3, 2013
******************************************************************************/
public class Mergesort
{
   /**
   * The main method illustrates the use of a merge sort to sort a 
   * small array.
   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used 
   * in this implementation.
   **/
   public static void main(String[ ] args)
   {
      final String BLANKS = "  "; // A String of two blanks
      int i;                      // Array index

      int[ ] data = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000 };

      // Print the array before sorting:
      System.out.println("Here is the entire original array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );

      // Sort the numbers, and print the result with two blanks after each number.
      mergesort(data, 0, data.length-1);
      System.out.println("The numbers are now:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );
   }
   
   
   /**
   * Sort an array of integers from smallest to largest, using a merge sort
   * algorithm.
   * @param <CODE>data</CODE>
   *   the array to be sorted
   * @param <CODE>first</CODE> 
   *   the start index for the portion of the array that will be sorted
   * @param <CODE>n</CODE>
   *   the number of elements to sort
   * <dt><b>Precondition:</b><dd>
   *   <CODE>data[first]</CODE> through <CODE>data[first+n-1]</CODE> are valid
   *   parts of the array.
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of </CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[first] &lt= data[first+1] &lt= ... &lt= data[first+n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>first+n-1</CODE> is an index beyond the end of the
   *   array.
   * */
   public static int mergesort(int[ ] data, int first, int n)
   {
      int n1; // Size of the first half of the array
      int n2; // Size of the second half of the array
      Integer comparisons = 0;

      if (n > 1)
      {
         // Compute sizes of the two halves
         n1 = n / 2;
         n2 = n - n1;

         comparisons += mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
         comparisons += mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

         // Merge the two sorted halves.
         comparisons+=merge(data, first, n1, n2);
      }
      comparisons++;
      
      return comparisons;
   } 
  
   // Precondition: data has at least n1 + n2 components starting at data[first]. The first 
   // n1 elements (from data[first] to data[first + n1 – 1] are sorted from smallest 
   // to largest, and the last n2 (from data[first + n1] to data[first + n1 + n2 - 1]) are also
   // sorted from smallest to largest. 
   // Postcondition: Starting at data[first], n1 + n2 elements of data
   // have been rearranged to be sorted from smallest to largest.
   // Note: An OutOfMemoryError can be thrown if there is insufficient
   // memory for an array of n1+n2 ints.
   private static int merge(int[ ] data, int first, int n1, int n2){
	   
      int[ ] temp = new int[n1+n2]; // Allocate the temporary array
      int copied  = 0; // Number of elements copied from data to temp
      int copied1 = 0; // Number copied from the first half of data
      int copied2 = 0; // Number copied from the second half of data
      int i;           // Array index to copy from temp back into data
      int comparisons = 0;

      // Merge elements, copying from two halves of data to the temporary array.
      while ((copied1 < n1) && (copied2 < n2)){
    	  
    	    	  
         if (data[first + copied1] < data[first + n1 + copied2])
            temp[copied++] = data[first + (copied1++)];
         else
            temp[copied++] = data[first + n1 + (copied2++)];
         
        // comparisons++;//If statement comparison
         
        //comparisons+=2;//While loop comparison. If we went in the loop, then we have two comparisons that occcured
      }
      comparisons+=((n1+n2)*2)+1;//The sum of n1 +n2, doubling that size for each if comparison within the loop, 
      //+1 extra check for when not going in the loop
      

      // Copy any remaining entries in the left and right subarrays.
      while (copied1 < n1){
         temp[copied++] = data[first + (copied1++)];
         comparisons++;
      }
      comparisons++;
      
      while (copied2 < n2){
    	  
         temp[copied++] = data[first + n1 + (copied2++)];
         comparisons++;
      }
      comparisons++;

      // Copy from temp back to the data array.
      for (i = 0; i < n1+n2; i++)
         data[first + i] = temp[i];
      
      comparisons += n1+n2;
      return comparisons;
   }
   
   
   
}