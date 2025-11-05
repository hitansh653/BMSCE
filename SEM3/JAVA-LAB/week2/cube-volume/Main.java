import java.util.Scanner;

class Cube{
    int length, breadth, height, volume;
    public void read(){
        System.out.println("Enter length, breadth, height: ");
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        breadth = sc.nextInt();
        height = sc.nextInt();
    }
    public void calculate(){
        volume = length*breadth*height;
    }
    public void display(){
        System.out.println(" Length: " + length + " Breadth: " + breadth + " Height: " + height + " Volume: " + volume);
    }

    
}

public class Main{
    public static void main(String[] args) {
        Cube c = new Cube();
        c.read();
        c.calculate();
        c.display();
    }
}