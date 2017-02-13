package com.tinymood.threadpool;

import java.util.concurrent.CountDownLatch;
import org.junit.Test;

public class SimpleThreadPoolTest {

	@Test
	public void test() throws InterruptedException {
		// 创建线程池
		SimpleThreadPool threadPool = new SimpleThreadPool(2);

		final CountDownLatch latch = new CountDownLatch(6);
		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " task1");
				latch.countDown();
			}
		};

		Runnable task2 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " task2");
				latch.countDown();
			}
		};

		Runnable task3 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " task3");
				latch.countDown();
			}
		};

		Runnable task4 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " task4");
				latch.countDown();
			}
		};

		threadPool.execute(task1);
		threadPool.execute(task1);
		threadPool.execute(task2);
		threadPool.execute(task2);
		threadPool.execute(task3);
		threadPool.execute(task3);

		latch.await();
		threadPool.shutdown();
		
		threadPool.execute(task4);
		threadPool.execute(task4);
		threadPool.execute(task4);
		threadPool.execute(task4);
		threadPool.execute(task4);
		threadPool.execute(task4);
	}
}
