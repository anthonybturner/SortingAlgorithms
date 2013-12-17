// File: Heapsort.java
// A Java application to illustrate the use of a heapsort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Heapsort.html
 
/******************************************************************************
* The <CODE>Heapsort</CODE> Java application illustrates a heapsort.
* Part of the implementation (the <CODE>makeHeap</CODE> and
* <CODE>reheapifyDown</CODE> methods) is left
* as a student exercise.
*
* <p><dt><b>Java Source Code for this class (without 
* <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>:</b><dd>
*   <A HREF="../applications/Heapsort.java">
*   http://www.cs.colorado.edu/~main/applications/Heapsort.java
*   </A>
*
* @author Michael Main and (Anthony Turner) 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Dec 3, 2013
******************************************************************************/
public class Heapsort
{
   /**
   * The main method illustrates the use of a heapsort to sort a 
   * small array.
   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used 
   * in this implementation.
   **/
   public static void main(String[ ] args)
   {
      final String BLANKS = "  "; // A String of two blanks
      int i;                      // Array index

      //int[ ] data = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0 };
      int[ ] data = { 21, 35, 22, 27, 23, 45, 42, 19, 4, 5 };

      // Print the array before sorting:
      System.out.println("Here is the entire original array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );

      // Sort the numbers, and print the result with two blanks after each number.
      heapsort(data, data.length);
      System.out.println("After sorting, the numbers are:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );
   }
   
   
   /**
   * This method cannot be used until the student implements 
   * <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>.
   * Sort an array of integers from smallest to largest, using a heapsort
   * algorithm.
   * @param <CODE>data</CODE>
   *   the array to be sorted
   * @param <CODE>n</CODE>
   *   the number of elements to sort, (from <CODE>data[0]</CODE> 
   *   through <CODE>data[n-1]</CODE>)
   * <dt><b>Precondition:</b><dd>
   *   <CODE>data</CODE> has at least <CODE>n</CODE> elements.
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of </CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[0] &lt= data[1] &lt= ... &lt= data[n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>data</CODE> has fewer than </CODE>n</CODE> elements.
   * */
   public static int heapsort(int[ ] data, int n)
   {
      int unsorted; // Size of the unsorted part of the array
      int temp;     // Used during the swapping of two array locations
      int comparisons = 0;
      
      comparisons += makeHeap(data, n);
      unsorted = n;


      comparisons++;
      while (unsorted > 1)
      {
         unsorted--;
         comparisons++;

         // Swap the largest element (data[0]) with the final element of unsorted part  
         temp = data[0];
         data[0] = data[unsorted];
         data[unsorted] = temp;

         comparisons+= reheapifyDown(data, unsorted);

      }

      return comparisons;
   }
   
   // Precondition: data is an array with at least n elements.
   // Postcondition: The elements of data have been rearranged so that the
   // complete binary tree represented by this array is a heap.
   private static int makeHeap(int[ ] data, int n){
	   
	   int comparisons = n;
	   
	   for(int i = 1; i < n; i++){
		   int k = i;
		   
		  comparisons+= reheapUp(data, k);
  
	   }
	   	  
	   return comparisons;
   }
   
   /*
    * Swaps each child with its parent if the child's priority is > parent
    */
   private static int reheapUp(int[]data, int k){

	   int comparisons = 0;
	   
	   comparisons++;
       if( k <= 0){
    	   return comparisons;
       }
       

       int parent_index = parent(k);

       comparisons++;
       while( data[k] > data[parent_index] ){

           swap(data, k, parent_index );

           k = parent_index;
           parent_index = parent(k);
           comparisons++;

       }
       
       return comparisons;
   }
   
   private static int parent(int k){
	   
	   return (k-1)/2;
   }
   

   private static int getLeftChildIndex(int k){

       return 2*k + 1;
   }


   private static int getRightChildIndex(int k){

       return 2*k + 2;
   }
   
   //Swaps two nodes
   private static void swap(int[]data , int k, int parent_index) {

       //Swap the child and parent's location
       int child_data = data[k];//Get the child
       data[k] = data[parent_index];//place the parent where the child was
       data[parent_index] = child_data;//place the child where the parent was

   }

   // Precondition: n > 0, and data is an array with at least n elements. These
   // elements form a heap, except that data[0] may be in an incorrect
   // location.
   // Postcondition: The data values have been rearranged so that the first
   // n elements of data now form a heap.
   private static int reheapifyDown(int[ ] data, int n){
 
	   int comparisons = 0;
	   int current;
	   int bigChildIndex;
	   boolean heapOkay;
	   
	   current = 0;
	   heapOkay =false;
	   
	   comparisons++;//The final comparison when while condition for heapOkay is false
	   while( (!heapOkay) ){
		   
		   comparisons++;//isLeaf comparison		   
		   if( !isLeaf(data, n, current) ){
			   
			   comparisons++;
			   //Find the biggest child
		        if( getRightChildIndex(current) >= n)//No right child
		        	bigChildIndex = getLeftChildIndex(current);
		        else{
		        	bigChildIndex = getBiggestChild(data,n, current);
		        	comparisons++;//There is a comparison which happens in this method call
		        }
		        
		       comparisons++;//current < data[bigChildIndex] comparison
			   if( data[current] < data[bigChildIndex]){
				   
				   swap(data, current, bigChildIndex);
				   current = bigChildIndex;			 
			   }else{
				   
				   heapOkay = true;
			   }
			   
			   
		   }else{
			   
			   comparisons++;//isLeaf comparison and the other comparison for the heapOkay is recorded when breaking this loop
			   break;
		   }		   
		   
		   
		   comparisons++;//While loop comparison
	   }
	   
	   return comparisons;
   }
   
   private static int getBiggestChild(int[]data, int n,  int current){
	   
      	int left_child_index = getLeftChildIndex(current);      		
        int right_child_index = getRightChildIndex(current);
       
         //Determine which child is the greater
        if( data[right_child_index] > data[left_child_index] )
            return right_child_index;
        
        else 
        	return left_child_index;
      
   }
   

	private static boolean isLeaf(int[] data, int n, int current) {
		
		if( getLeftChildIndex(current) >= n && getRightChildIndex(current) >= n)
			return true;
		
		return false;
		
	}
      
}



