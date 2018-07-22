package aboboo.java.article1;

public class Demo2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			System.out.println("run方法中线程状态为：" + Thread.currentThread().getState()); // RUNNABLE
			try {
				Thread.sleep(10000); // 休眠10秒，这个时候线程进入TIMED_WAITING
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("new完后的线程状态：" + t.getState()); // NEW
		t.start();
		Thread.sleep(5000); // main线程休眠5秒，确保t线程进入休眠期
		System.out.println("线程启动后，进入休眠：" + t.getState()); // TIMED_WAITING
		t.join(); // 等待t线程运行完毕
		System.out.println("线程运行完毕的状态：" + t.getState()); // TERMINATED
	}
}
