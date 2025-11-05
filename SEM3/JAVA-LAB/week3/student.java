import java.util.Scanner;

public class student {
    String usn, name;
    void input_details(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student name and USN: ");
        name = sc.nextLine();
        usn = sc.nextLine();
        int[] credits = new int[3];
        int[] marks = new int[3];
        System.out.println("Enter credits and marks in the order Math, Java, Physics: ");
        for (int i = 0; i < 3; i++) {
            credits[i] = sc.nextInt();
            marks[i] = sc.nextInt();
        }
    }
    void output_details(){
        System.out.println("Name: " + name + " USN: " + usn);
        for (int i = 0; i < 3; i++) {
            System.out.println("Credits: " + credits[i]);
            System.out.println("Marks: " + marks[i]);
        }
    }
    float calculate(){
        
    }
}
