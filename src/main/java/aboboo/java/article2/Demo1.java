package aboboo.java.article2;

public class Demo1 {
	private static Object lock = new Object();

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			
			try {
				Thread.sleep(0); // sleep并不要求在同步方法或同步代码里面调用
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (lock) {
				try {
					lock.wait();  // wait方法必须在同步代码块（同步方法）里调用
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t.setName("线程1");
		t.start();
	}
}
