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


//                  --- Demo ---
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Add products
        Product p1 = new Product();
        p1.productName = "Laptop";
        p1.quantity = 10;
        p1.price = 50000;

        Product p2 = new Product();
        p2.productName = "Mouse";
        p2.quantity = 25;
        p2.price = 700;

        inventory.add(p1);
        inventory.add(p2);

        // Update product with ID 1
        Product updatedProduct = new Product();
        updatedProduct.productName = "Gaming Laptop";
        updatedProduct.quantity = 8;
        updatedProduct.price = 65000;

        System.out.println("Update Product: " + inventory.update(1, updatedProduct));

        // Delete product with ID 2
        System.out.println("Delete Product: " + inventory.delete(2));

    }
}

class Product{
    int productId;
    String productName;
    int quantity;
    int price;
}