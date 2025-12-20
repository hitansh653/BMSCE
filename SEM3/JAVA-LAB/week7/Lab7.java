/*Write a program that demonstrates handling of exceptions in inheritance tree. 
Create a base class called “Father” and derived class called “Son” which extends the base class. 
In Father class, implement a constructor which takes the age and throws the exception WrongAge( ) when the input age=father’s age.*/

import java.util.Scanner;

class WrongAge extends Exception{
    public WrongAge(String messagae){
        super(messagae);
    }
}

class Father{
    int fatherAge;

    Father(int age) throws WrongAge{
        if(age<0){
            throw new WrongAge("Age cannot be negative"); 
        }
        this.fatherAge = age;
        System.out.println("Father's age set to : " + this.fatherAge);
    }
}

class Son extends Father{
    int sonAge;

    Son(int fatherAge , int sonAge) throws WrongAge{
        super(fatherAge);

        if(sonAge>=fatherAge){
            throw new WrongAge("Son's age cannot be greater than or equal to father's age");
        }
        this.sonAge = sonAge;
        System.out.println("Son's age set to : " + this.sonAge);
    } 
}

public class Lab7 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        
        try {
            System.out.println("Enter Father's Age : ");
            int fatherAge = inp.nextInt();

            System.out.println("Enter Son's Age : ");
            int sonAge = inp.nextInt();

            Son s1 = new Son(fatherAge, sonAge);

            System.out.println("\nAges are Valid");
        }

        catch(WrongAge e) {
            System.out.println("\nError: " + e.getMessage());
        }

        catch (java.util.InputMismatchException e){
            System.out.println("\nError: Invalid input Please enter a valid number");
        }

        finally {
            inp.close();
        }
    }    
}
