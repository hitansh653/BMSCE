class CollegeThread extends Thread{
    private String message;
    private int delayInMillis;
    public CollegeThread(String message, int delayInMillis){
        this.message = message;
        this.delayInMillis = delayInMillis;
    }
	@Override
	public void run(){
		try{
			while(true){
				System.out.println(message);
				Thread.sleep(delayInMillis);
			}
		}
		catch(InterruptedException e){
			System.out.println("Thread Interrupted " + message);
		}
	}
}

public class TwoThreadsDemo{
	public static void main(String[] args){
		CollegeThread t1 = new CollegeThread("BMS College of Engineering", 10000);
		CollegeThread t2 = new CollegeThread("CSE", 2000);
		t1.start();
		t2.start();
	}
}