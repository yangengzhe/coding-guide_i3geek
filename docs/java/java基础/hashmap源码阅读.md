## HashMap介绍 ##

HashMap是基于哈希链表的Map接口的**非同步**实现。允许使用null值和null键，存储是无序的，是按照哈希散列排序的。

## 数据结构 ##

![image](http://note.7tool.cn:9000/file/outputImage?fileId=57c4e32528a8521390000090)

最基本的结构是链表散列，如图由两部分组成：数组和链表。HashMap的底层就是一个数组，数组中的每一项都是一个链表。

## 初始化

当新建一个HashMap的时候，会初始化一个数组`Entry<K,V>[] table` 

Entry<K,V>是实现了Map.Entry接口。具体定义如下：

    transient Entry[] table;  
      
    static class Entry<K,V> implements Map.Entry<K,V> {  
        final K key;  
        V value;  
        Entry<K,V> next;  
        final int hash;  
        ……  
    }  

可以看出每个元素其实就是包含了Key、Value以及Next指针。记录自身数据的同时，指向下一个结点，形成了链表。

## 存取实现

### 存储

    public V put(K key, V value) {
	//如果是空的，则进行初始化大小
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
        //允许K/V存放null
        //若key为null则调用putForNullKey方法 放在数组第一位置
        if (key == null)
            return putForNullKey(value);
        //计算hash
        int hash = hash(key);
        //搜索指定hash值在对应table中的索引。
        int i = indexFor(hash, table.length);
        //如果i处不为空，则循环遍历下一个元素，产生链表
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        //如果i处索引为null或没有相同的，则表明还没有Entry
        modCount++;
        //插入，将k v插入到i处
        addEntry(hash, key, value, i);
        return null;
    }

从put的源代码中可以看出，当put时先计算hashcode值，根据该值找到数组的下标。若该元素已经存在，就遍历链表找到是否有相同元素。若存在相同元素则直接替换。**若没有相同元素则在链表头插入新元素**，最先加入的元素在链表尾。

最后若链表没有该元素，或数组中该位置为null，均执行addEntry方法插入元素。

    void addEntry(int hash, K key, V value, int bucketIndex) {
    //若大小不够就扩充到原理的2倍
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
	//创建新entry
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, K key, V value, int bucketIndex) {
    //获取指定索引处的Entry
        Entry<K,V> e = table[bucketIndex];
        //将新创建的 Entry 放入 bucketIndex 索引处，并让新的 Entry 指向原来的 Entry
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        //增加大小
        size++;
    }

这样就完成了元素的添加，这里需要注意的是，链表中是新结点插入头部，方法和创建结点一样。利用构造函数完成了链表的链接创建。

### 技术点

#### hash(int h)

    final int hash(Object k) {
        int h = hashSeed;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }
	//结合哈希种子计算哈希值
        h ^= k.hashCode();
        
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

hash是根据key的hashcode重新计算一遍散列，加入了高位计算，防止低位不变高位变化时，造成的冲突。

#### indexFor(int h,int length)

Hashmap中元素的存储位置是由Key的哈希值所决定，只要对象的Hashcode相同，那么hash后的值一定也相同。利用一个比较好的哈希算法，可以让元素比较均匀的分布在数组链表中，使得每个位置上的元素尽量只有一个，这样在查找元素时不需要遍历链表，从而大大提高效率。

这样的哈希算法我们首先想到的就是把hash值对数组长度取模运算，这样一来，元素的分布相对来说是比较均匀的。但是，**“模”运算的消耗还是比较大的**，所以在HashMap中是这样做的：**调用 indexFor(int h, int length) 方法来计算该对象应该保存在 table 数组的哪个索引处。**

    static int indexFor(int h, int length) {
        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
        return h & (length-1);
    }

这个方法非常的巧妙，**通过 h&(length-1)来取得对象的保存位，而数组的长度总是2的N次方，结果等同于 h%length。但是在效率上却大大超过了%方法。**

    //初始化数组大小为16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

初始化数组也十分巧妙的利用了位移运算，通过向左位移扩大一倍的方法，位移四次变成16.该方法效率很高。在每一次扩容时也是扩大一倍，所以保证了长度永远是2的N次方。

#### 总结

当程序试图将一个key-value对放入HashMap中时，程序首先根据该 key 的 hashCode() 返回值决定该 Entry 的存储位置：如果两个 Entry 的 key 的 hashCode() 返回值相同，那它们的存储位置相同。如果这两个 Entry 的 key 通过 equals 比较返回 true，新添加 Entry 的 value 将覆盖集合中原有 Entry 的 value，但key不会覆盖。如果这两个 Entry 的 key 通过 equals 比较返回 false，新添加的 Entry 将与集合中原有 Entry 形成 Entry 链，而且新添加的 Entry 位于 Entry 链的头部。

**所以，equals相同hashcode必须相同，hashcode相同equals不一定相同。存储原理是利用取模的办法，但是换用了&高效的代替了%，因此必须保证数组的长度必须是2的N次方。**

为什么容量是2的N次方？
答：哈希算法中利用&代替%，必须是2的N次方才有等同的效果，否则分布不均匀。

Hash算法是什么？取模吗？
答：在HashMap中查找存储位置的是indexFor方法，原理是取模，但是为了保证高效利用&代替取模运算。

为什么每次扩大2倍？怎么扩大？
答：保证长度必须是2的倍数，所以每次扩大2倍。可以通过位移扩大，左移1位扩大2倍。

### 读取

有了上面的基础，读取来说就比较容易了，在此不做过多的解释了，直接上代码：

    public V get(Object key) {
        if (key == null)
            return getForNullKey();
        Entry<K,V> entry = getEntry(key);

        return null == entry ? null : entry.getValue();
    }

### 总结

HashMap 底层采用一个 Entry[] 数组来保存所有的 key-value 对，当需要存储一个 Entry 对象时，会根据hash算法来决定其在数组中的存储位置，在根据equals方法决定其在该数组位置上的链表中的存储位置；当需要取出一个Entry时，也会根据hash算法找到其在数组中的存储位置，再根据equals方法从该位置上的链表中取出该Entry。

## 数组扩容resize(rehash) ##

当元素不断的添加时，HASH冲突的概率也就越来越高了，因为数组的长度是固定不变的。所以为了提高效率，减少冲突，就要扩容数组了。数组的扩容是一个常见的操作，比如在ArrayList中。但是在HashMap中扩容的话就要面临一个最耗能的点了：原数组中的数据必须重新计算其在数组中的位置，并放进去，就是resize。

### 扩充方法

当HashMap中的元素个数超过数组大小*loadFactor时，就会进行数组扩容。（loadFactor默认值为0.75）也就是说默认情况下，数组大小为16，那么当达到16*0.75=12的时候，就把数组的大小扩展为32（即扩大一倍），然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作。

HashMap的基础构造器HashMap(int initialCapacity, float loadFactor)带有两个参数，它们是初始容量initialCapacity和加载因子loadFactor。

threshold = (int)(capacity * loadFactor);  threshold就是在此loadFactor和capacity对应下允许的最大元素数目，超过这个数目就重新resize，以降低实际的负载因子。

	void resize(int newCapacity) {   //传入新的容量
    Entry[] oldTable = table;    //引用扩容前的Entry数组
    int oldCapacity = oldTable.length;         
    if (oldCapacity == MAXIMUM_CAPACITY) {  //扩容前的数组大小如果已经达到最大(2^30)了
        threshold = Integer.MAX_VALUE; //修改阈值为int的最大值(2^31-1)，这样以后就不会扩容了
        return;
    }

    Entry[] newTable = new Entry[newCapacity];  //初始化一个新的Entry数组
    transfer(newTable);                         //！！将数据转移到新的Entry数组里
    table = newTable;                           //HashMap的table属性引用新的Entry数组
    threshold = (int)(newCapacity * loadFactor);//修改阈值
    }

看了源码 其实就是用一个更大的数组替换原先的小数组，transfer方法将原有Entry数组拷贝到新的Entry里面

    void transfer(Entry[] newTable) {
        Entry[] src = table;                   //src引用了旧的Entry数组
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) { //遍历旧的Entry数组
            Entry<K,V> e = src[j];             //取得旧Entry数组的每个元素
            if (e != null) {
                src[j] = null;//释放旧Entry数组的对象引用（for循环后，旧的Entry数组不再引用任何对象）
                do {
                    Entry<K,V> next = e.next;
                    int i = indexFor(e.hash, newCapacity); //！！重新计算每个元素在数组中的位置
                    e.next = newTable[i]; //标记[1]
                    newTable[i] = e;      //将元素放在数组上
                    e = next;             //访问下一个Entry链上的元素
                } while (e != null);
            }
        }
    }

注释1处同样用了头结点插入的方式，构造了一个链表，通过indexFor计算每个元素在数组中的位置，重新遍历。

这样，在旧数组中同一条Entry链上的元素，通过重新计算索引位置后，有可能被放到了新数组的不同位置上；
例如，旧数组容量为16，对象A的hash值是4，对象B的hash值是20,对象C的hash值是36； 
通过indexFor()计算后，A、B、C对应的数组索引位置分别为4,4,4; 说明这3个对象在数组的同一位置上，形成了Entry链； 
旧数组扩容后容量为16*2，重新计算对象所在的位置索引，A、B、C对应的数组索引位置分别为4,20,4; B对象已经被放到别处了； 

### 总结

resize时，HashMap使用新数组代替旧数组，对原有的元素根据hash值重新就算索引位置，重新安放所有对象；resize是耗时的操作。