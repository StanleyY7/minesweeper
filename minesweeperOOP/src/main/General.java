package main;

public class General {
	
	// Method to timeout "something" for a set amount of milliseconds, 
	//before the next "something" runs.
	 public static void setTimeout(int ms) {
		 try {
		        Thread.sleep(ms);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
	 }
}
