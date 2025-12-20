package SEE;
import CIE.Personal;
public class Externals extends Personal{
    public int [] externalMarks = new int[5];
    Externals(String usn, String name, int sem, int[]marks){
        super(usn, name, sem);
        for(int i = 0; i<5; i++){
            externalMarks[i] = marks[i];
        }
    }
    
}
