import java.util.Scanner;
public class SafeListAccess {
    public static void main(String[] args) {
        String[] items = {"Apple", "Banana", "Cherry", "Date"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Items: ");
        for(int i = 0; i<items.length; i++){
            System.out.println(i + ":" + items[i]);
        }
        try{
            System.out.println("Enter index to access: ");
            int index = sc.nextInt();
            System.out.println("Item at index" + index + "is: " + items[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Index out of range");
        }
        catch(Exception e){
            System.out.println("Invalid Input. Please enter an integer.");
        }
        sc.close();
    }
}
