package com.tinymood.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


public class SimpleThreadFactory implements ThreadFactory {
	private static final String MARK = "SimpleThreadPool-Worker-";
	
	private AtomicInteger id = new AtomicInteger();
	
	private boolean isDaemon = false;
	
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r, MARK+id.incrementAndGet());
		thread.setDaemon(isDaemon);
		
		return thread;
	}

}
