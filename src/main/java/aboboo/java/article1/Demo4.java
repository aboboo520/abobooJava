package aboboo.java.article1;

public class Demo4 {
	private static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + "开始执行wait方法");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "唤醒了");
			}
		});
		t.setName("线程一");
		t.start();
		Thread.sleep(2000);
		System.out.println("线程启动后，" + t.getState()); // WAITING
		synchronized (lock) {
			lock.notifyAll();
		}
	}
}
