package week8.FileException;
import java.util.Scanner;
public class OpenFile {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        try{
            Scanner fileScanner = new Scanner(new java.io.File(fileName));
            System.out.println("File opened Successfully\nContents:\n");
            while(fileScanner.hasNextLine()){
                System.out.println(fileScanner.nextLine());
            }
        }
        catch(Exception e){
            System.out.println("Error: File not found or cannot be opened.");
        }
        sc.close();
	}
}
