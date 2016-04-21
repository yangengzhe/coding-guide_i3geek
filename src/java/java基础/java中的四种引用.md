http://www.i3geek.com/archives/1239

# java中的四种引用

从jdk1.2以后，为了更好的控制对象的生命周期，从而定义了四中级别：强引用、软引用、弱引用和虚引用。不同的引用对于JVM的垃圾回收以及内存泄露等有着重要的影响。

## 强引用

正常的使用中，声明的对象都是强引用，是最普遍的引用。强引用是不能被回收机制所回收的，即使达到一定程度之后，报出OutOfMemoryError异常也不会进行对象的回收

## 软引用

**当一个对象只有软引用指向时，若内存不足时，垃圾回收器将进行回收；若内存足够时，垃圾回收器将不会进行回收。**，由于其这样的特性，一般可以用来做缓存使用，当JVM需要内存时 才将这些软引用的对象进行回收。

java.lang.ref.SoftReference 表示软引用。具体代码如下：

	Counter prime = new Counter(); 
	SoftReference soft = new SoftReference(prime) ; 
	prime = null; 

1）创建强引用对象prime

2）创建软引用对象soft，并指向对象prime

3）将强引用对象置空，此时当内存不足时，垃圾回收器将进行回收。（若不置空，将有强引用和软引用同时指向 永远不会进行回收）

## 弱引用

弱引用的生命周期比软引用还要短，**当触发垃圾回收机制时，无论内存是否满足都将进行回收处理，这是一种急切回收方式。**一般非常适合存储元数据，例如：存储ClassLoader引用。或者需要存储大量数据，而且在被回收后很容易再次加载的数据。

java.lang.ref.WeakReference<class> 来创建弱引用。具体代码如下：

	Counter counter = new Counter(); 
	WeakReference<Counter> weakCounter = new WeakReference<Counter>(counter); 
	counter = null;

1）创建强引用对象counter

2）创建弱引用对象weakCounter

3）将强引用对象置空，此时垃圾回收器发现该对象时将立即回收。

## 虚引用

虚引用，就是形同虚设，不影响对象的生命周期，一个对象持有虚引用和没有引用的效果是一样的。任何时候 都可能被垃圾回收机制所回收。和软引用、弱引用的区别主要在于，**必须与引用队列联合使用**。主要用来跟踪对象被垃圾回收的活动。

java.lang.ref.PhantomReference 来创建虚引用。具体代码如下：

	DigitalCounter digit = new DigitalCounter(); 
	PhantomReference phantom = new PhantomReference(digit); 
	digit = null;

用途：
处理类似图片的大文件的情况。当你确定一个图片数据对象应该被回收，你可以利用虚引用来判断这个对象回收之后在继续加载下一张图片。

## 引用队列

软引用、弱引用和虚引用可以使用引用队列。**当该引用的对象被垃圾回收器标记为待回收时，便会加入到引用队列中。**可以通过判断对象是否在引用队列中得知，对象是否将被回收，从而完成相关的删除工作。

	ReferenceQueue refQueue = new ReferenceQueue(); 	DigitalCounter digit = new DigitalCounter();
	PhantomReference<DigitalCounter> phantom = new PhantomReference<DigitalCounter>(digit, refQueue);

## 总结

强引用：永远不会被垃圾回收器删除。（垃圾回收器是回收不可达的对象，不可达代表没有引用所指）

软引用：内存不足时进行回收。可以做缓存用

弱引用：只要发现就进行回收。可以做缓存、存储元数据、大数据等用

虚引用：和没有引用一样，必须与引用队列一起使用。可以用于跟踪对象是否被回收。

引用队列：被回收器标记的对象，该引用则会加入引用队列中。（只有软引用、弱引用和虚引用可以使用）