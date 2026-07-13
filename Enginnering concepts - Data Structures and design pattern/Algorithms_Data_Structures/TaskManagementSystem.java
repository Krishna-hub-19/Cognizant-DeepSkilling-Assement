package Algorithms_Data_Structures;

// Exercise - 5
class LinkedList<T>{
    Node head;
    int size;

    private class Node{
        Node next;
        T val;

        Node(T node){
            this(node, null);
        }

        Node(T val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    LinkedList(){
        this.head = null;
        this.size = 0;
    }


    public void add(T value){
        Node node = new Node(value);

        node.next = head;
        head = node;

        this.size++;
    }



    public Node search(T value){
        Node temp = head;
        if(temp == null) return null;

        while(temp != null){
            if(temp.val.equals(value)) return temp;

            temp = temp.next;
        }

        return null; // not found
    }




    public void traverse(){
        Node temp = head;
        if(temp == null) return;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.print("null");
    }




    public boolean delete(T value){
        if(head == null) return false;

        if (head.val.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node prv = head;
        Node temp = head.next;

        while (temp != null) {

            if (temp.val.equals(value)) {
                prv.next = temp.next;
                size--;
                return true;
            }

            prv = temp;
            temp = temp.next;
        }

        return false;
    }



    public int size(){
        return this.size;
    }
}

public class TaskManagementSystem {

    public static void main(String[] args) {
        /*
        ans.1:
        - Singly LinkedList - we can traverse only from left to right, as node only holds the address of it's next element.
        - Doubly LinkedList - we can traverse in both sides as we need, as node holds both previous and next addresses.
        
        ------------------------------------------------------------------------------------------------------

        ans.2 - Created below
    
        ------------------------------------------------------------------------------------------------------

        ans.3 - Implemented above, including methods - add, search, traverse, and delete.

        -------------------------------------------------------------------------------------------------------

        ans.4:
        - add -> O(1)
        - search -> O(n)
        - traverse -> O(n)
        - delete -> O(n)
        */


//        ---- Demo ----
        LinkedList<Task> tasks = new LinkedList<>();

        Task t1 = new Task(101, "Design Database", "Pending");
        Task t2 = new Task(102, "Develop API", "In Progress");
        Task t3 = new Task(103, "Write Tests", "Pending");

        // Add Tasks
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        // Traverse
        System.out.println("Task List:");
        tasks.traverse();

        // Search
        System.out.println("\n\nSearch Task: " + (tasks.search(t2) != null ? "Found" : "Not Found"));

        // Delete
        System.out.println("Delete Task: " + tasks.delete(t2));

        // Traverse Again
        System.out.println("\nTask List After Deletion:");
        tasks.traverse();
    }
}


class Task{
    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return taskName;
    }
}