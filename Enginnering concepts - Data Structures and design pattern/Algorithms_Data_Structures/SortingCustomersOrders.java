package Algorithms_Data_Structures;

// Exercise - 3
public class SortingCustomersOrders {

    public void bubbleSort(Order[] orders){
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }


     public void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivot = partition(orders, low, high);

            quickSort(orders, low, pivot - 1);
            quickSort(orders, pivot + 1, high);
        }
    }

    // helper function for quickSort
    public static int partition(Order[] orders, int low, int high) {

        Order pivot = orders[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot.totalPrice) {
                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }


    public static void main(String[] args) {
        /*

        ans.1
        - Bubble Sort: Repeatedly compares and swaps adjacent elements until the array is sorted. Time Complexity: O(n^2).

        - Insertion Sort: Picks one element at a time and inserts it into its correct position. Time Complexity: O(n^2).

        - Quick Sort: Selects a pivot, partitions the array into smaller and larger elements, then recursively sorts both parts. Average: O(n log n), Worst: O(n^2).

        - Merge Sort: Divides the array into halves, recursively sorts each half, and merges them back together. Time Complexity: O(n log n).

        ---------------------------------------------------------------------------------------------------------

        ans.2 - Created "Order" class below

        ---------------------------------------------------------------------------------------------------------

        ans.3 - implemented both "bubble sort" and "quick sort" above

        ---------------------------------------------------------------------------------------------------------

        ans.4
        - bubble sort -> time complexity - O(n^2)
        - quick sort -> average  time complexity - O(n log n)
                     -> worst time complexity - O(n^2)


        --> quick sort is generally prefer than bubble sort because it's average time complexity is O(n log n) while, time complexity of bubble sort is O(n^2) in average and worse both cases.
        */



//        ---- Demo ----
        SortingCustomersOrders sorter = new SortingCustomersOrders();

        Order[] orders = {
                new Order(101, "Laptop", 65000),
                new Order(102, "Mouse", 700),
                new Order(103, "Keyboard", 1500),
                new Order(104, "Monitor", 12000)
        };

        // Bubble Sort Demo
        Order[] bubbleOrders = orders.clone();
        sorter.bubbleSort(bubbleOrders);

        System.out.println("Bubble Sort:");
        for (Order order : bubbleOrders) {
            System.out.println(order.orderName + " - " + order.totalPrice);
        }

        // Quick Sort Demo
        Order[] quickOrders = orders.clone();
        sorter.quickSort(quickOrders, 0, quickOrders.length - 1);

        System.out.println("\nQuick Sort:");
        for (Order order : quickOrders) {
            System.out.println(order.orderName + " - " + order.totalPrice);
        }
    }
}

class Order{
    int orderId;
    String orderName;
    double totalPrice;

    Order(int orderId, String orderName, double totalPrice) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.totalPrice = totalPrice;
    }
}