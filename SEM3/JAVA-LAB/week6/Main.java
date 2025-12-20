import SEE.Externals;
import CIE.*;
public class Main {
    public static void main(String[] args) {
        Externals student = new Externals("1BM20CS001", "Alice", 3, new int[]{85, 90, 78, 88, 92});
        for(int mark : student.externalMarks){
            System.out.println(mark);
        }
    }
}
