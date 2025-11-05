import java.util.Scanner;

abstract class Shape{
    int dim1, dim2;
    abstract void printArea();
}

class Rectangle extends Shape{
    Rectangle(int a, int b){
        dim1 = a;
        dim2 = b;
    }
    
    void printArea(){
        System.out.println("Area of Rectangle: "+ (dim1*dim2));
    }
}

class Triangle extends Shape{
    Triangle(int a, int b){
        dim1 = a;
        dim2 = b;
    }
    void printArea(){
        System.out.println("Area of Triangle: " + (0.5*dim1*dim2));
    }
}

class Circle extends Shape{
    Circle(int r){
        dim1 = r;
    }
    void printArea(){
        System.out.println("Area of Circle: " + Math.PI*dim1*dim1);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and breadth of Rectangle: ");
        int l = sc.nextInt();
        int b = sc.nextInt();
        Rectangle rect = new Rectangle(l, b);
        rect.printArea();
        System.out.println("Enter base and height of Triangle: ");
        int base = sc.nextInt();
        int height = sc.nextInt();
        Triangle tri = new Triangle(base, height);
        tri.printArea();
        System.out.println("Enter the radius of a Circle: ");
        int r = sc.nextInt();
        Circle cir = new Circle(r);
        cir.printArea();
        sc.close();
    }
}