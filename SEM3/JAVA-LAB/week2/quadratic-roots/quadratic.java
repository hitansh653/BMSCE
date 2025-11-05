import java.util.Scanner;

public class quadratic {
    float a,b,c,d, x1, x2, r, i;
    public void read()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficients a, b and c of quadratic equation (ax^2 + bx + c = 0): ");
        a = sc.nextFloat();
        b = sc.nextFloat();
        c = sc.nextFloat();
        sc.close();
    }
    public void calculate()
    {
        d = b*b - 4*a*c;
        if(d > 0)
        {
            x1 = (-b + (float)Math.sqrt(d)) / (2*a);
            x2 = (-b - (float)Math.sqrt(d)) / (2*a);
            System.out.println("Roots are real and different.");
            System.out.println("Root 1: " + x1);
            System.out.println("Root 2: " + x2);
        }
        else if(d == 0)
        {
            x1 = x2 = -b / (2*a);
            System.out.println("Roots are real and same.");
            System.out.println("Root: " + x1);
        }
        else
        {
            r = -b / (2*a);
            i = (float)Math.sqrt(-d) / (2*a);
            System.out.println("Roots are complex and different.");
            System.out.println("Root 1: " + r + " + " + i + "i");
            System.out.println("Root 2: " + r + " - " + i + "i");
        }
    }
}

class Demo{
    public static void main(String args[])
    {
        quadratic q = new quadratic();
        q.read();
        q.calculate();
    }
}
