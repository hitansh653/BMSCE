package CIE;

public class Internals {
    int [] internalMarks = new int[5];
    public Internals(int[]marks){
        for(int i = 0; i<5; i++){
            internalMarks[i] = marks[i];
        }
    }
}
