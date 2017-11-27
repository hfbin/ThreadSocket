package cn.hfbin.sync002;
/**
 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
 * 所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
 * 
 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
 *
 */
public class MultiThread {

	private static int num = -1;

	/**
	 * static
	 */
	public static synchronized void printNum(String tag) {
		try {

			if (tag.equals("a")) {
				num = 1;
				System.out.println("Thread m1");
				Thread.sleep(1000);
			} else {
				num = 2;
				System.out.println("Thread m2");
			}

			System.out.println("Thread " + tag + ", num = " + num);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//注意观察run方法输出顺序
	public static void main(String[] args) {

		//俩个不同的对象
		final MultiThread m1 = new MultiThread();
		final MultiThread m2 = new MultiThread();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				m1.printNum("a");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				m2.printNum("b");
			}
		});

		t1.start();
		t2.start();

	}
}