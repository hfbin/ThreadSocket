package cn.hfbin.sync004;
/**
 * 业务整体需要使用完整的synchronized，保持业务的原子性。
 * @author cn.hfbin
 *
 */
public class DirtyRead {

	private String username = "cn.hfbin";
	private String password = "123";
	
	public  void setValue(String username, String password){
		this.username = username;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.password = password;
		
		System.out.println("setValue>>>>最终结果：username = " + username + " , password = " + password);
	}
	
	public void getValue(){
		System.out.println("getValue>>>>方法得到：username = " + this.username + " , password = " + this.password);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		final DirtyRead fb = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				fb.setValue("hfbin", "456");
			}
		});
		t1.start();
		Thread.sleep(1000);
		fb.getValue();
	}
	
}
