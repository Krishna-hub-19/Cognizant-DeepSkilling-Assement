package Algorithms_Data_Structures;
import java.util.ArrayList;
import  java.util.List;


public class LibraryManagementSystem {
    List<Book> bookSelf;
    private int id;

    LibraryManagementSystem(){
        this.bookSelf = new ArrayList<>();
        this.id = 0;
    }


    public static void main(String[] args) {

        /*
        ans.1:
            -Linear Search - Search linearly - one by one
            -Binary Search - Search by comparing element and find based value is greater or less than

        -------------------------------------------------------------------------------------------------
        ans.2: Implemented "Book" class below -
        ---------------------------------------------------------------------------------------------------
         ans.3 :
         - Implemented Linear Search below - as issueBookLinearSearch
         - Implement binary search - as issueBookLinearSearch
        ---------------------------------------------------------------------------------------------------
         ans.4
            - Time complexity of Linear Search - O(n)
            - Time complexity of Binary Search - O(log n)
            - Discussion:
                - If data is already sorted, use Binary Search.
                - If data is unsorted and only one search is needed, use Linear Search.
                - If many searches are needed, sort once and then use Binary Search.
         */

        // Demo
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook("James Gosling", "Java");
        library.addBook("Robert Martin", "Clean Code");
        library.addBook("Joshua Bloch", "Effective Java");

        System.out.println(library.issueBookLinearSearch("Java"));
    }

    // methods
    public void addBook(String authorName, String bookTitle){
        Book book = new Book(this.id++, authorName, bookTitle);

        this.bookSelf.add(book);
    }

    // using Linear Search
    public String issueBookLinearSearch(String bookTitle){
        for(int i = 0; i < this.id; i++){
            Book book = this.bookSelf.get(i);
            if(book.title.equals(bookTitle)) return "Book id - " + book.bookId + ", title - " + book.title + ", written by - " + book.author;
        }

        return "Current UnAvailable!";
    }


    // using Binary Search
    public String issuebookBinarySearch(String bookTitle){

        // assume that data is sorted

        int start = 0, end = this.id - 1;

        while (start <= end){
            int mid = start + (end - start)/2;

            Book book = this.bookSelf.get(mid);
            int cmp = book.title.compareTo(bookTitle);

            if(cmp == 0) return "Book id - " + book.bookId + ", title - " + book.title + ", written by - " + book.author;
            else if (cmp > 0) end = mid - 1;
            else start = mid + 1;
        }


        return "Current UnAvailable!";
    }
}

class Book{
    int bookId;
    String author;
    String title;

    Book(int id, String author, String title){
        this.bookId = id;
        this.author = author;
        this.title = title;
    }
}