
/*
Create a class Book which contains four members: name,
author, price, num_pages. Include a constructor to set the
values for the members. Include methods to set and get the
details of the objects. Include a toString( ) method that
could display the complete details of the book. Develop a
Java program to create n book objects.
*/
import java.util.Scanner;

class Book {
     String name, author;
     int price, num_pages;

    public Book(String name, String author, int price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    public void setName(String name) { this.name = name;}

    public String getName() { return name; } 

    public void setAuthor(String author) { this.author = author; }

    public String getAuthor() { return author; }

    public void setPrice(int price) { this.price = price; }

    public int getPrice() { return price; }

    public void setNum_pages(int num_pages) { this.num_pages = num_pages; }

    public int getNum_pages() { return num_pages; }

    public String toString() { 
        return "Book [name=" + this.name + ", author=" + this.author + ", price=" + this.price + ", num_pages=" + this.num_pages + "]"; 
    }
}

class bookManager {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the number of books: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        Book[] book = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of book: ");
            String name = sc.nextLine();
            
            System.out.println("Enter the author of book: ");
            String author = sc.nextLine();
            System.out.println("Enter the price of book: ");
            int price = sc.nextInt();
            System.out.println("Enter the number of pages of book: ");
            int num_pages = sc.nextInt();
            sc.nextLine();
            book[i] = new Book(name, author, price, num_pages);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(book[i]);
        }
        sc.close();
    }
}
