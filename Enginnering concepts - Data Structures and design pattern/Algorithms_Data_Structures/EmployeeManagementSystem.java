package Algorithms_Data_Structures;

// Exercise - 4
public class EmployeeManagementSystem {
    Employee[] employees;
    int ind;

    EmployeeManagementSystem(){
        this(10); // default size
    }

    EmployeeManagementSystem(int size){
        this.employees = new Employee[size];
        this.ind = 0;
    }



    public boolean add(Employee employee){
        if(ind >= employees.length) return false;

        this.employees[ind++] = employee;

        return true;
    }


    public int search(Employee employee){
        for(int i = 0; i < this.ind; i++){
            if(this.employees[i].employeeId == employee.employeeId) return i;
        }

        return -1; // not found
    }



    public void traverse(){
        for(int i = 0; i < ind; i++){
            Employee employee = this.employees[i];
            System.out.printf("id - %d name - %s \n", employee.employeeId, employee.employeeName);
        }
    }



    public boolean delete(){
        if(ind == 0) return false;

        this.employees[--ind] = null;

        return true;
    }

    public static void main(String[] args) {
        /*
        ans.1 - Arrays are represented in the memory like a blocks where each block have their unique address, we can simply fetch the element using arrayName[position].

        Advantage:
        - Arrays are faster for fetch the element. time complexsity - O(1)
        - Arrays are more simpler to use then linkedList and ArrayList
        - Arrays consume less memory than linkedList and ArrayList

        ---------------------------------------------------------------------------------------------------------

        ans.2 - created "Employee" class below

        ---------------------------------------------------------------------------------------------------------

        ans.3 - implemented above including all methods - add, search, traverse, delete

        ---------------------------------------------------------------------------------------------------------

        ans.4:
        - add - O(1)
        - Search - O(n)
        - traverse - O(n)
        - delete - O(1)

        limitation:
        - array are fixed in size.
        - array takes O(n) time for searching.
        
        solution:
        - we can use "LinkedList" if we don't know the size.
        - if we have to search frequently, then we can go with Maps.

        when to use:
        - if we already know the size in advanced.
        - if fast access O(1) is required.
        */
    }
}


class Employee{
    int employeeId;
    String employeeName;
    String employeePosition;
    double employeeSalary;
}
