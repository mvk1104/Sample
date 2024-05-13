package Tests;

import com.sun.corba.se.pept.transport.ContactInfo;

import java.util.Arrays;

public class MergeTwoArraysAndSort {
     private static int[] mergeArrays(int[] arr1, int[] arr2) {
         int[] mergeArray = new int[arr1.length + arr2.length];
         int i = 0, j = 0, k=0;
         while(i<arr1.length){
             mergeArray[k] = arr1[i];
             i++;
             k++;
         }
         while(j<arr2.length){
             mergeArray[k] = arr2[j];
             j++;
             k++;
         }
         Arrays.sort(mergeArray);
         return mergeArray;
     }
     public static void main(String[] args) {
         int[] arr1 = {1,2,3,4,5};
         int[] arr2 = {-2,-3,-4,15};
         int[] mergeArray = mergeArrays(arr1, arr2);
         System.out.println("Value of Array1 :" + Arrays.toString(arr1));
         System.out.println("Value of Array2 :" + Arrays.toString(arr2));
         System.out.println("Value of MergedArray :" + Arrays.toString(mergeArray));

     }
}
