package cn.hfbin.concurrent019;
import java.io.IOException;  
import java.util.Random;  
import java.util.concurrent.BrokenBarrierException;  
import java.util.concurrent.CyclicBarrier;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors; 
public class UseCyclicBarrier {

	static class Runner implements Runnable {  
	    private CyclicBarrier barrier;  
	    private String name;  
	    
	    public Runner(CyclicBarrier barrier, String name) {  
	        this.barrier = barrier;  
	        this.name = name;  
	    }  
	    @Override  
	    public void run() {  
	        try {
	        	//随机休眠0-5秒
	            Thread.sleep(1000 * (new Random()).nextInt(5));  
	            System.out.println(name + " 准备OK.");
	            //等待
	            barrier.await();  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        } catch (BrokenBarrierException e) {  
	            e.printStackTrace();  
	        }  
	        System.out.println(name + " Go!!");  
	    }  
	} 
	
    public static void main(String[] args) throws IOException, InterruptedException {  
        CyclicBarrier barrier = new CyclicBarrier(3);  // 3
		//3个固定的线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);  
        
        executor.submit(new Thread(new Runner(barrier, "hfbin-01")));
        executor.submit(new Thread(new Runner(barrier, "hfbin-02")));
        executor.submit(new Thread(new Runner(barrier, "hfbin-03")));

        //关闭线程池
        executor.shutdown();  
    }  
  
}  