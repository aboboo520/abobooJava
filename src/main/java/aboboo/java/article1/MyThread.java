package aboboo.java.article1;

public class MyThread extends Thread {
	private Object lock;
	
	public MyThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + "占用了锁");
			try {
				Thread.sleep(10000); // 休眠10秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "释放了锁");
		}
	}

}
