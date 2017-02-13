package com.tinymood.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class SimpleThreadPool implements ThreadPool {
	private static final int DEFAULT_POOL_SIZE = Runtime.getRuntime().availableProcessors();
	
	// 任务队列
	private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
	
	// 线程类Worker，抓取任务并执行任务
	private final List<Worker> workers = new ArrayList<Worker>(DEFAULT_POOL_SIZE);
	
	private final ThreadFactory threadFactory = new SimpleThreadFactory();

	private int size;
	
	public SimpleThreadPool(int size) {
		this.size = size < 1 ? DEFAULT_POOL_SIZE:size;
		prestartThread();
	}
	
	private void prestartThread() {
		for (int i=0; i<size; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			
			// 启动线程
			threadFactory.newThread(worker).start();
		}
	}
	
	@Override
	public boolean execute(Runnable task) {
		return taskQueue.offer(task);
	}

	// 关闭线程池
	@Override
	public void shutdown() {
		for (Worker worker : workers) {
			worker.shutdown();
		}
		System.out.println("=====");
//		for (Worker worker : workers) {
//			System.out.println(worker.running);
//		}
	}
	
	class Worker implements Runnable {
		private volatile boolean running = true;
		
		@Override
		public void run() {
			while (running) {
				System.out.println(running);
				Runnable task = null;
				try {
					task = taskQueue.take();
				} catch (Exception e) {
					return;
				}
				
				if (task != null) {
					try {
						task.run();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public void shutdown() {
			running = false;
		}
	}
}
