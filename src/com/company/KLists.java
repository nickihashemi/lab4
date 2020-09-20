package com.company;

import java.util.Arrays;

public class KLists {

    double[] merge (double[] outer, double[] inner) {
        int i = 0;
        int j = 0;
        int k = 0;
        double finalArray[] = new double[outer.length + inner.length]; // length of outter and inner


        // Compare items between left and right
        while (i < outer.length && j < inner.length) {
            if (outer[i] < inner[j]) {
                finalArray[k++] = outer[i++];
            } else {
                finalArray[k++] = inner[j++];
                // same thing as above
            }
        }

        // Copy remaining elements on left
        while (i < outer.length) {
            finalArray[k++] = outer[i++];
        }

        // Copy right
        while (j < inner.length) {
            finalArray[k++] = inner[j++];           // increments i and r after
            // the statement executes
        }
        return finalArray;
    }

    public double[] mergeKLists (double[][] outerArray) {

        if (outerArray.length == 0) {
            return new double[0];
        }

        double finalArray[] = outerArray[0];
        //System.out.println(finalArray.length);


        for (int i=1; i<outerArray.length; i++) {               //merges first array and second array, combined
            finalArray = merge(finalArray, outerArray[i]);

        }
        return finalArray;

    }

    public static void main(String[] args) {
        KLists kLists = new KLists();

	    //double[][] outerArray = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};
        //double[][] outerArray = {};
        //double[][] outerArray = {{}};
        double[][] outerArray = {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};

	    double[] array = kLists.mergeKLists(outerArray);

        System.out.println(Arrays.toString(array));
    }
}
