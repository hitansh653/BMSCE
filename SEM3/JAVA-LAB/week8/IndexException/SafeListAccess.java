import java.util.Scanner;
public class SafeListAccess {
    public static void main(String[] args){
        String [] items = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Items:\n");
        for(String item: items){
            System.out.println(item);
        }
        try{
            System.out.print("Enter the index to access: ");
            int index = sc.nextInt();
            System.out.print("Item at index " + index + ": " + items[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Index out of bounds. Please enter a valid index between 0 and " + (items.length - 1) + ".");
        }
        catch(Exception e){
            System.out.println("Invalid Input. Please enter an integer value.");
        }
        sc.close();
    }
}