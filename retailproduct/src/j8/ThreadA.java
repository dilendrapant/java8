package j8;

import java.util.concurrent.TimeUnit;

public class ThreadA {
	public static void main1(String[] args) {

		
			Runnable task = () -> {
				String thName = Thread.currentThread().getName();
				System.out.println("HI,  " + thName);

			};
			task.run();

			Thread td = new Thread(task);
			td.start();

			System.out.println("Done!!");

		}

	}



class RunnableA {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			try {
				 String name = Thread.currentThread().getName();
				System.out.println("Foo " + name);
			        
			        TimeUnit.SECONDS.sleep(10);
			        System.out.println("Bar " + name);

			} catch (InterruptedException e) {
				e.printStackTrace();

			}

		};
		
		Thread thread = new Thread(runnable);
		
thread.start();
	}
}
//abstract class A{
//	abstract void a();
//	
//}
//class B extends ThreadA{
//
//	@Override
//	void a() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
//}
//
//abstract class ThreadA extends A{
//	public static void main(String[] args) {
//	
//		System.out.println("A::");
//		
//	}
//}
