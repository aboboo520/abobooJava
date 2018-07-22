package aboboo.java.article2;

public class Demo4 {
	private static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			try {
				synchronized (lock) {
					System.out.println("开始等待");
					lock.wait();
				}
				// java.lang.InterruptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}
}
