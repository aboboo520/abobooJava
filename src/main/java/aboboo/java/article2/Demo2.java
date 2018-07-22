package aboboo.java.article2;

public class Demo2 {
	private static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + "获取了锁，开始进入休眠");
				try {
					Thread.sleep(10000); // 休眠十秒，期间并不释放锁
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "休眠结束，释放了锁");
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
	}
}
