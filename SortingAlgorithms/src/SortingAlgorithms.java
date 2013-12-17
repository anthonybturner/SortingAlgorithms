import java.util.Random;
/**
 * 
 * @author Anthony Turner
 * <b>Course:</b> CSIII Advanced Data Structures
 * <b>Assignment: </b> #8 - Sorting Algorithms
 * <b>Date: </b> December 4 2013
 *
 */

public class SortingAlgorithms {
	
	private final int FIRST = 0;
	private final int NUM_RANDOMS = 100;
	private final int MAX_RANDOM_NUMBER = 500;
	private boolean printing_disabled;
	
	public SortingAlgorithms(){
		
		startStageOne();
		startStageTwo();
		
		
		
	}
	
	

	public void startStageOne() {
		

		print("\n===============================================================================================\n\n");
		print("					Stage One\n\n\n");
		print("-----------------------------------------------------------------------------------------------\n\n\n");
		
		selectionSort(NUM_RANDOMS);
		insertionSort(NUM_RANDOMS);
		mergeSort(NUM_RANDOMS);
		quickSort(NUM_RANDOMS);
		heapSort(NUM_RANDOMS);
		
	}

	public void startStageTwo(){
		

		print("\n===============================================================================================\n\n");
		print("					Stage Two\n\n\n");
		print("-----------------------------------------------------------------------------------------------\n\n\n");
		doComparisons();
		
	}

	
	private void doComparisons() {
		
		
		print("------------------------------------------------------------------------------------------------\n");
		
		print("  N\tSelectionsort\t Insertionsort\t Mergesort\t Quicksort\t Heapsort\t NLogN");

		print("\n------------------------------------------------------------------------------------------------\n\n");
		
		String BLANKS = "  ";

		for(int row = 0; row < 10; row++){
			
			int n = (row+1) * 1000;
			
			int[] random_numbers =  getRandomNumbers(n, MAX_RANDOM_NUMBER);
			
			int selection_comparisons = Select.selectionsort(random_numbers, FIRST, n);
			int insertion_comparisons = Insert.insertionsort(random_numbers, FIRST, n);
			int merge_comparisons =		Mergesort.mergesort(random_numbers, FIRST, n);
			int quick_comparisons = Quicksort.quicksort(random_numbers, FIRST, n);
			int heap_comparisons = Heapsort.heapsort(random_numbers, n);
			
			int nlog_n_comparisons = 0;
			
			String comparisons = n + BLANKS+"\t" +  
								selection_comparisons + BLANKS+"\t" + insertion_comparisons + BLANKS+"\t " + 
								merge_comparisons     + BLANKS+"\t  " + quick_comparisons     + BLANKS+"\t    " +
								heap_comparisons	  + BLANKS+"\t  " + nlog_n_comparisons	  + BLANKS+"\t";
			
			print(comparisons);
			print("\n\n");

		}
	}

	private String selectionSort(int size) {
		
		print("\n==================================\n");
		print("	Selection Sort\n");
		print("----------------------------------\n\n");
		int[] random_numbers =  getRandomNumbers(size, MAX_RANDOM_NUMBER);
		print("Here is the entire original array:\n");
		print(random_numbers);
		int comparisons = Select.selectionsort(random_numbers, FIRST, random_numbers.length);
		print("\n\nThe numbers are now:\n");
		print(random_numbers);
		print("\n");
		return String.valueOf(comparisons);
		
	}
	
	private String insertionSort(int size) {
		
		print("\n==================================\n");
		print("	Insertion Sort\n");
		print("----------------------------------\n\n");

		int[] random_numbers = getRandomNumbers(size, MAX_RANDOM_NUMBER);
		print("Here is the entire original array:\n");
		print(random_numbers);
		int comparisons = Insert.insertionsort(random_numbers, FIRST, random_numbers.length);
		print("\n\nThe numbers are now:\n");
		print(random_numbers);
		print("\n");
		return String.valueOf(comparisons);

	}


	private void mergeSort(int size) {
		
		print("\n==================================\n");
		print("	Merge Sort\n");
		print("----------------------------------\n\n");

		int[] random_numbers = getRandomNumbers(size, MAX_RANDOM_NUMBER);
		print("Here is the entire original array:\n");
		print(random_numbers);
		Mergesort.mergesort(random_numbers, FIRST, random_numbers.length);
		print("\n\nThe numbers are now:\n");
		print(random_numbers);
		print("\n");

	}
	
	private void quickSort(int size) {
		
		print("\n==================================\n");
		print("	Quick Sort\n");
		print("----------------------------------\n\n");

		int[] random_numbers = getRandomNumbers(size, MAX_RANDOM_NUMBER);
		print("Here is the entire original array:\n");
		print(random_numbers);
		Quicksort.quicksort(random_numbers, FIRST, random_numbers.length);
		print("\n\nThe numbers are now:\n");
		print(random_numbers);
		print("\n");

	}
	
	private void heapSort(int size) {
		
		print("\n==================================\n");
		print("	Heap Sort\n");
		print("----------------------------------\n\n");

		int[] random_numbers = getRandomNumbers(size, MAX_RANDOM_NUMBER);
		print("Here is the entire original array:\n");
		print(random_numbers);
		Heapsort.heapsort(random_numbers, random_numbers.length);
		print("\n\nThe numbers are now:\n");
		print(random_numbers);
		print("\n");

	}
	
	private void print(int[] random_numbers) {
		
		if( !printing_disabled ){

			for(int i = 0; i < random_numbers.length; i++)
				print( random_numbers[i] );
		      print("");
		      
		}

	}


	private void print(int i) {
		
		if( !printing_disabled ){
			
			final String BLANKS = "  "; // A String of two blanks
			System.out.print(i + BLANKS);
			
		}
		
	}
	
	private void print(String str){
	     
		if( !printing_disabled ){
			
			System.out.print(str);

		}
		
	}


	private int[] getRandomNumbers(int size, int limit) {
		
		int[] random_numbers = new int[size];
		Random rand = new Random();
		
		for(int i = 0; i < random_numbers.length; i++){
		
			random_numbers[i] = rand.nextInt(limit);
			
		}
		
		return random_numbers;
		
	}



	public static void main(String[] args) {
		
		

			new SortingAlgorithms();
	}

}
