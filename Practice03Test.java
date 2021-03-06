package Lesson3;

import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}

    /**
     * find_min_iterative()
     *
     * This iterative function allows for the use of a variable going through each element of array.
     * Find the index of the element with the least value out of other variables.
     *
     * @return the index of the element of the array with the least value
     */
	public int find_min_iterative () {
		// TODO: Fill in this iterative function.

        int index=0;
        double min_value = arr[index];
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min_value){
                min_value = arr[i];  // Used at first to check that this index had the number with the minimum value
                index = i;
            }
        }
//        System.out.printf("Minimum Value: %.2f\n", min_value);  // Original output showed the minimum value in array
        return index;  // Return the index of the number in array with the least value

	}

    /**
     * find_min_recursive()
	 *
     * @return the index of the element number in the array with the least value
     */
	public int find_min_recursive () {
        // TODO: Fill in this recursive function.

        int index = 0;
        int length_of_arr = arr.length;
        return get_min_r_index(index, length_of_arr-1);

    }

    /**
     * get_min_r_index()
     *
	 * Called by the find_min_recursive function to conduct the recursion process for this class
     *
     * @param key the number that is used as the index for the recursive function (initialized at 0)
     * @param len total number of elements in the array being used
     * @return the index of the array with the number of the least value
     */
    public int get_min_r_index(int key, int len){

	    if(key == len)
	        return len;
	    if(arr[key] < arr[len])
	        return get_min_r_index(key, len-1);
	    else
	        return get_min_r_index(key+1, len);

    }

    /**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive());
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
