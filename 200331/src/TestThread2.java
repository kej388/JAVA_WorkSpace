
class Thread1 extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			System.out.println("Thread1 : " + i);
			try {
				sleep(50);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}

class Thread2 extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			System.out.println("Thread2 : " + i);
			try {
				sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}

public class TestThread2 {
	public static void main(String[] args) {

		Thread1 t1 = new Thread1();
		t1.setPriority(10);
		t1.start();
		
		
		Thread2 t2 = new Thread2(); 
		t2.start();
		 
	}
}
