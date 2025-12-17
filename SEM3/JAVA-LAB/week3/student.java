import java.util.Scanner;

public class student {
    String usn, name;
    int[] credits = new int[3];
    int[] marks = new int[3];
    int[] grade = new int[3];
    void input_details(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student name and USN: ");
        name = sc.nextLine();
        usn = sc.nextLine();
        System.out.println("Enter credits and marks in the order Math, Java, Physics: ");
        for (int i = 0; i < 3; i++) {
            credits[i] = sc.nextInt();
            marks[i] = sc.nextInt();
        }
        sc.close();
    }
    void output_details(){
        System.out.println("Name: " + name + " USN: " + usn);
        for (int i = 0; i < 3; i++) {
            System.out.println("Credits: " + credits[i]);
            System.out.println("Marks: " + marks[i]);
        }
    }
    float calculate(){
        float sgpa = 0;
        int total_credits = 0;
        for(int i = 0; i<3; i++){
            if(marks[i] >= 90)
                grade[i] = 10;
            else if(marks[i] >= 80)
                grade[i] = 9;
            else if(marks[i] >= 70)
                grade[i] = 8;
            else if(marks[i] >= 60)
                grade[i] = 7;
            else if(marks[i] >= 50)
                grade[i] = 6;
            else
                grade[i] = 0;
            sgpa += grade[i] * credits[i];
            total_credits += credits[i];
        }
        sgpa = sgpa / total_credits;
        return sgpa;
    }
}

class Demo{
    public static void main(String args[]){
        student s = new student();
        s.input_details();
        s.output_details();
        float sgpa = s.calculate();
        System.out.println("SGPA: " + sgpa);
    }
}