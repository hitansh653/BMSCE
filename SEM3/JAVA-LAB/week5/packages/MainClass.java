
import mypackage.Addition;


public class MainClass {
    public static void main(String[] args) {
        Addition obj = new Addition();
        int result = obj.Add(10, 20);
        System.out.println("Sum of 2 nos: " + result);
    }
}