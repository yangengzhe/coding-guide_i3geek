package com.tinymood.threadpool;

public interface ThreadPool {
	boolean execute(Runnable task);
	void shutdown();
}
