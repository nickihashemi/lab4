package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is responsible for merging 2d (sorted) arrays into a 1d sorted array
 */

public class KLists {

    /**
     * We pass in the finalArray and merge it with nextArray
     * @param fin
     * @param nextArray
     * @return
     */
    double[] merge (double[] fin, double[] nextArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        double finalArray[] = new double[fin.length + nextArray.length]; // length of final array and the next array

        // Compare items between finalArray and nextArray
        while (i < fin.length && j < nextArray.length) {
            if (fin[i] < nextArray[j]) {
                finalArray[k++] = fin[i++];
            } else {
                finalArray[k++] = nextArray[j++];
            }
        }

        // Copy remaining elements on finalArray
        while (i < fin.length) {
            finalArray[k++] = fin[i++];
        }

        // Copy remaining elements on nextArray
        while (j < nextArray.length) {
            finalArray[k++] = nextArray[j++];           // increments k and j after the statement executes
        }
        return finalArray;
    }

    /**
     * This calls the merge function, sets finalArray to the newly merged finalArray and outerArray combined
     * This will then get called again until there are no more sub arrays (nextArrays)
     * @param outerArray
     * @return
     */
    public double[] mergeKLists (double[][] outerArray) {

        if (outerArray.length == 0) {
            return new double[0];
        }

        double finalArray[] = outerArray[0];                    // **sets it to the first sub array[0]
        //System.out.println(finalArray.length);


        for (int i=1; i<outerArray.length; i++) {               // merges first array and second array, combined
            finalArray = merge(finalArray, outerArray[i]);      // **sets it to the next subArray[1]
                                                                // when i=2, final array is already combined with [0] and [1],
                                                                // therefore, the next sub array is merged with that whole thing

        }
        return finalArray;

    }

    /**
     * Calls all of the above functions
     * Tests out the different cases
     * @param args
     */
    public static void main(String[] args) {
        KLists kLists = new KLists();

	    //double[][] outerArray = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};
        //double[][] outerArray = {};
        //double[][] outerArray = {{}};

        double[][] outerArray = {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
        System.out.print("Unsorted Array: [");
        for (int i =0; i<outerArray.length; i++) {
            if (i!= outerArray.length-1) {
                System.out.print(Arrays.toString(outerArray[i]) + ", ");
            } else {
                System.out.print(Arrays.toString(outerArray[i]));
            }
        }
        System.out.println("]");

	    double[] array = kLists.mergeKLists(outerArray);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
