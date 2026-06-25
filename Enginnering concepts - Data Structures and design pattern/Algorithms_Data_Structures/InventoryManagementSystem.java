package Algorithms_Data_Structures;

import java.util.Map;
import java.util.HashMap;

// Exercise - 1

public class InventoryManagementSystem {

    private Map<Integer, Product> map;

    int productId = 0;

    InventoryManagementSystem(){
        this.map = new HashMap<>();
        this.productId = 1;
    }


    // Method - 1
    public boolean add(Product product){
        product.productId = this.productId;
        this.map.put(this.productId, product);
        this.productId++;
        return true;
    }


    // Methhod - 2
    public boolean update(int productId, Product updateProduct){
        if(!map.containsKey(productId)) return false;

        map.put(productId, updateProduct);

        return true;
    }


    // Method - 3
    public boolean delete(int productId){
        if(!map.containsKey(productId)) return false;

        map.remove(productId);

        return true;
    }
    public static void main(String[] args) {


        /* 
        ans.1 - They help store, search, update, and delete inventory efficiently
            1. HashMap - to find the product by productid
            2. ArrayList - to store the products as we don't know the product count, and ArrayList is flexible in size
        
        ---------------------------------------------------------------------------------------------------------

        ans.2 - Create a file named as InventoryManagementSystem

        ---------------------------------------------------------------------------------------------------------

        ans.3 - Implemented below as "Product" class name

        ---------------------------------------------------------------------------------------------------------
        
        ans.4 - The time complexity for each method is - 
            - add - O(1)
            - update - O(1)
            - delete - O(1)
        
        --> since Hashmap already provides constant time for such operation so, we can not further optimized it.
        */

    }
}

class Product{
    int productId;
    String productName;
    int quantity;
    int price;
}