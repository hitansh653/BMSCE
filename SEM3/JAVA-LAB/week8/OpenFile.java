/* WAP that asks for a filename and tries to open it. Handle error if file does not exist. */
import java.util.Scanner;
public class OpenFile {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String filename = sc.nextLine();
        try{
            Scanner fileScanner = new Scanner(new java.io.File(filename));
            System.out.println("File opened successfully.\n Contents:");
            while(fileScanner.hasNextLine()){
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        }
        catch (Exception e){
           System.out.println("Error: File Not found. Cannot be opened.");
        }
        sc.close();
    }
        
}
