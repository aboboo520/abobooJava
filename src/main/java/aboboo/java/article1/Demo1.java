package aboboo.java.article1;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			System.out.println("run方法中线程状态为：" + Thread.currentThread().getState()); // RUNNABLE
		});
		System.out.println("new完后的线程状态：" + t.getState()); // NEW
		t.start();
		t.join(); // 等待t线程运行完毕
		System.out.println("线程运行完毕的状态：" + t.getState()); // TERMINATED
	}
}
