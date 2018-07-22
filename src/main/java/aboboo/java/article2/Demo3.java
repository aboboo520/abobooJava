package aboboo.java.article2;

public class Demo3 {

private static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + "获取了锁，开始进入等待");
				try {
					lock.wait(); // 等待notify的召唤
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "等待结束");
			}
		});
		t1.setName("线程一");
		
		Thread t2 = new Thread(() -> {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + "获取了锁");
			}
		});
		t2.setName("线程二");
		
		t1.start();
		Thread.sleep(2000); // 休眠2秒，在启动线程2，去获取lock
		t2.start();
		
		t2.join();  // 等待线程二执行完毕，再唤醒线程一
		System.out.println("唤醒线程一");
		synchronized (lock) {
			lock.notify();
		}
	}
}
