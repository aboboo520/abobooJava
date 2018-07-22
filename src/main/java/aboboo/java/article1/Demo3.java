package aboboo.java.article1;

public class Demo3 {
	private static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread(lock);
		t1.setName("线程一");
		
		MyThread t2 = new MyThread(lock);
		t2.setName("线程二");
		
		t1.start();
		Thread.sleep(2000); // 休眠2秒，让t1先启动
		t2.start();
		Thread.sleep(2000); // 休眠2秒
		System.out.println("线程启动后，进入休眠：" + t2.getState()); // BLOCKED
	}
}
