package j8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/

class Ex {

	// Java 8 Concurrency Tutorial: Threads and Executors

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		executor.submit(() -> {
			String th = Thread.currentThread().getName();
			System.out.println("Name ::" + th);

		});

		try {
			System.out.println("Attampting shutdown executor service ");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} finally {

			if (!executor.isTerminated()) {
				System.err.println("Non fnished task");
			}
			executor.shutdownNow();
			System.out.println("Shutdown now!!");
		}

		// Callables and Futures

		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("Task exception :: " + e);
			}

		};

		//

		ExecutorService ex = Executors.newFixedThreadPool(1);
		Future<Integer> future = ex.submit(task);
		System.out.println("Future done ?? " + future.isDone());
		Integer res = future.get();

		System.out.println("Future done ?? " + future.isDone());
		System.out.println("Result::" + res);

		ex.shutdown();
		future.get();
		System.out.println("Future done ?? " + future.isDone());
		System.out.println("Result::" + res);

		// Timeouts

		ExecutorService exc = Executors.newFixedThreadPool(1);
		Future<Integer> fu = exc.submit(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("Task interrupted :: " + e);
			}
		});

		fu.get(6, TimeUnit.SECONDS);// <5 will throw eption in thread "main" java.util.concurrent.TimeoutException

		// Invoke All invokeAll()
		// accepts a collection of callables and returns a list of futures.

		ExecutorService exe = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(() -> "Task-1", () -> "Task-2", () -> "Task-3",
				() -> "Task-4");

		exe.invokeAll(callables).stream().map(fx -> {
			try {
				return fx.get();
			} catch (Exception e) {
				throw new IllegalStateException("Exceptions here :: " + e);
			}
		}).forEach(System.out::println);

		// InvokeAny

		ExecutorService exes = Executors.newWorkStealingPool();
		List<Callable<String>> clabes = Arrays.asList(
				// callable("Task-1",1),
				callable("Task-2", 2), callable("Task-3", 3), callable("Task-4", 4), callable("Task-5", 5),
				callable("Task-6", 6));
		String ress = exes.invokeAny(clabes);
		System.out.println("REsults Invoke Any :: " + ress);

		// Scheduled Executors

		ScheduledExecutorService sces = Executors.newScheduledThreadPool(1);
		Runnable taskT = () -> System.out.println("Scheduled time " + System.nanoTime());

		ScheduledFuture<?> schFuture = sces.schedule(taskT, 3, TimeUnit.SECONDS);

		TimeUnit.MICROSECONDS.sleep(1233);
		long emaningDelay = schFuture.getDelay(TimeUnit.MILLISECONDS);
		System.out.println("Delay Timing is :: " + emaningDelay);

		// scheduleWithFixedDelay()

		ScheduledExecutorService sces1 = Executors.newScheduledThreadPool(1);
		Runnable taskT1 = () -> System.out.println("Scheduled time scheduleWithFixedDelay " + System.nanoTime());

		int initialDelay = 0;
		int period = 1;

		sces1.scheduleAtFixedRate(taskT1, initialDelay, period, TimeUnit.SECONDS);

		TimeUnit.SECONDS.sleep(30);
		sces1.shutdown();// stopping above loops

		//

		
		ScheduledExecutorService secx = Executors.newScheduledThreadPool(1);
		Runnable tasks0 =()->{
		
			try{TimeUnit.SECONDS.sleep(3);
			System.out.println("Schedulling is ::::  "+System.nanoTime());
			}
			catch(InterruptedException e) {
				System.out.println("Exception "+e);
			}
			
		};
		
		secx.scheduleWithFixedDelay(tasks0, 0, 1, TimeUnit.SECONDS);
		
	}
	/* InvokeAny */

	static Callable<String> callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;

		};
	}
	/* InvokeAny */
}
