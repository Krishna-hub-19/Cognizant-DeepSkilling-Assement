package Algorithms_Data_Structures;

import java.util.Arrays;

// Exercise - 2
public class EcommercePlatForm {

    public boolean linearSearch(Product1[] arr, Product target){
        for(Product1 element : arr){
            if(element.productId == target.productId) return true;
        }

        return false;
    }


    public boolean binarySearch(Product[] arr, Product1 target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid].productId == target.productId) return true;
            else if(arr[mid].productId > target.productId) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }


    public  void sort(Product1[] arr){
        Arrays.sort(arr, (a, b) -> a.productId - b.productId);
    }

    public static void main(String[] args) {
        /* ans.1 
        - Big O helps to understand the algorithms performance by analyze it how fast the algorithm is when the input is become larger.

        - Best case - O(1) for both linear and binarySearch
        - average case - O(n) for linear Search and O(log n) for binarySearch
        - worse case - is when we found our ansewr in the end of the array in  - O(n) time for linear Search and O(log n) time for binarySearch

        ---------------------------------------------------------------------------------------------------------

        ans.2 - "Product class" created below

        ---------------------------------------------------------------------------------------------------------

        ans.3 - implemented the "linearSearch and binarySearch method above"
        created method "sort" for binarySearch algorithm for sort the data(array) 

        ---------------------------------------------------------------------------------------------------------
        ans.4 
        - linearSearch time complexity - O(n)
        - binarySearch time complexity - O(log n)

        - Binary Search is more suitable for an e-commerce platform because products can be stored in sorted order. It provides O(log n) search time, making searches much faster than Linear Search for large inventories.*/
    }
    
}


class Product1{
    int productId;
    String productName;
    String category;
}