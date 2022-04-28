package com.test;

//import sun.misc.Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qings2329
 * @since Oct 20, 2016   1:10:39 AM
 */
public class JDKSourceLearning {
    // 什么时候会执行 ?
    String test = new String("test unstatic");

    private String initString = getStr();

    private String getStr() {
        System.out.println("init string !");
        return "init string";
    }

    private static String staticString = getStr4static();

    private static String getStr4static() {
        System.out.println("static string !");
        return "static string";
    }

    private JDKSourceLearning() {
    }

    public JDKSourceLearning(String str) {
        System.out.println("this is JDKSourceLearning class");
    }

    private static JDKSourceLearning ins = new JDKSourceLearning();

    public static JDKSourceLearning getInstance() {
        return ins;
    }

    // 运行函数
    public static void main(String[] args) throws Exception {
        boolean stop = true;

        System.out.println("java版本号：" + System.getProperty("java.version")); // java版本号

        //在 jdk13中 Unsafe 有两个类 sun.misc.Unsafe  jdk.internal.misc.Unsafe
//        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.compareAndSwapObject();

        // 用户不能调用Unsafe.getUnsafe()
//        Unsafe unsafe = Unsafe.getUnsafe();

        //1.最简单的使用方式是基于反射获取Unsafe实例
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        /**
         * 操作数组:
         * 可以获取数组的在内容中的基本偏移量（arrayBaseOffset），获取数组内元素的间隔（比例），
         * 根据数组对象和偏移量获取元素值（getObject），设置数组元素值（putObject），示例如下。
         */
        String[] strings = new String[]{"1", "2", "3"};
        long i = unsafe.arrayBaseOffset(String[].class);
        System.out.println("string[] base offset is :" + i);

        //every index scale
        long scale = unsafe.arrayIndexScale(String[].class);
        System.out.println("string[] index scale is " + scale);

        //print first string in strings[]
        System.out.println("first element is :" + unsafe.getObject(strings, i));

        //set 100 to first string
        unsafe.putObject(strings, i + scale * 0, "100");

        //print first string in strings[] again
        System.out.println("after set ,first element is :" + unsafe.getObject(strings, i + scale * 0));

        if (stop) {
            return;
        }


        // 原子操作
        AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
        atomicReference.compareAndSet(100, 200);
        atomicReference.weakCompareAndSet(200, 300);
        atomicReference.getAndSet(400);

        // 原子整数
        AtomicInteger ai = new AtomicInteger(0);
        // cas
        ai.incrementAndGet();

        // 解决ABA的问题, 记录版本号
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
        int stamp = atomicStampedReference.getStamp();
        boolean success = atomicStampedReference.compareAndSet(100, 200, stamp, stamp + 1);
        // AtomicMarkableReference 记录是否修改


        // 线程局部变量
        ThreadLocal<Integer> testTl1 = new ThreadLocal<>();
        testTl1.set(100);
        testTl1.get();

        ThreadLocal<Integer> testTl2 = new ThreadLocal<>();
        testTl2.set(200);
        testTl2.get();

        // 类对象
        Class classz = JDKSourceLearning.class;
        System.out.println(classz.getName());
        System.out.println(classz.getClass().getName());

//      Number 是抽象类
        Number number = 0.1;
        System.out.println("number = 0.1 " + number.getClass().getName());
        number = 1;
        // 对象变了
        System.out.println("number = 1 " + number.getClass().getName());

//        Object ob = new Object();
//        ob.getClass();


        System.out.println(Integer.valueOf(1000) == Integer.valueOf(1000));
        System.out.println(new Integer(1000) == new Integer(1000));
        System.out.println(Integer.valueOf(10) == Integer.valueOf(10));
        System.out.println(new Integer(10) == new Integer(10));
        Integer a = 10;
        Integer b = 10;
        System.out.println(a == b);

//        if (stop) {
//            return;
//        }

        // 异常
        Exception exc;
        RuntimeException rex;


        // 几种map
        Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
        hashtable.get("");
        // hashtable key value 都不能为空
//		hashtable.put(null, 1);
//		hashtable.put("", null);

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        // hashmap的 key value 都能为空
        hashMap.put("", null);
        System.out.println(hashMap.get(""));
        hashMap.remove("");

        hashMap.put(null, 1);
        System.out.println(hashMap.get(null));
        hashMap.remove("");


        //
        Map synnchronizeMap = Collections.synchronizedMap(hashMap);


        ConcurrentHashMap<String, Integer> concurretHashMap = new ConcurrentHashMap<String, Integer>();
        concurretHashMap.put("", 1);
        concurretHashMap.size();

        // 红黑树
        // 有序映射
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("", 1);


        Set treeSet = new TreeSet();
        treeSet.add("");


        Set hashSet = new HashSet();
        hashSet.add("1");
        hashSet.add(2);

        System.out.println("hashset: " + Arrays.toString(hashSet.toArray()));


//        if (stop) {
//            return;
//        }


        // 输出byte的比特位
        byte b1 = 1;
        byte b2 = -1;
//        Byte by = 1;
//        by.byteValue();
//        System.out.println(by.toString());

        System.out.println(byteToBitStr(b1));
        System.out.println(byteToBitStr(b2));


        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new Object());
        arrayList.remove(0);


        Collections.sort(arrayList, new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });


        // LRU
        LinkedHashMap<Integer, Object> linkMap = new LinkedHashMap(10) {

            protected boolean removeEldestEntry() {
                return false;
            }

        };
        linkMap.put(null, null);
        linkMap.get(null);


        // 若该字符串不存在常量池，则添加到常量池
        String intern = new String("intern").intern();
        // string 的 hashCode 有缓存
        intern.hashCode();
        intern.equals("");
        intern.charAt(0);


        // 优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(1);
        // 移除并返问队列头部的元素
        // 最小的出列
        priorityQueue.poll();
        // 返回队列头部的元素，不出列
        priorityQueue.peek();


        // 双向队列
        Deque<Object> dqueue = new ConcurrentLinkedDeque<Object>();

        // 阻塞队列
        BlockingQueue<Object> bqueue = new ArrayBlockingQueue<Object>(20);
        bqueue.add(new Object());
        bqueue.poll();
        try {
            bqueue.take();
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }

        bqueue.remove();


        Object[] objects = new Object[10];
        // 数组用length，不是size()
        System.out.println(objects.length);


        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        Condition condition = reentrantLock.newCondition();
        condition.signal();
        condition.await();

        Object lockObj = new Object();
        LockSupport.park(lockObj);


        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.await();


        // Long 对象的比较
        Long l1 = new Long(1);
        Long l2 = new Long(1);
        System.out.println(l1 == l2);
        System.out.println(l1.equals(l2));


        System.out.println("start main !");

        System.out.println("************* new JDKSourceLearning() *************");
        JDKSourceLearning instanceq1 = new JDKSourceLearning();

        System.out.println("************* JDKSourceLearning.getInstance() *************");

        JDKSourceLearning instance = JDKSourceLearning.getInstance();

//		boolean flag = false;
//		if(flag = true) {
//			return;
//		}

        String str = new String();
        str.equals("");
        str.hashCode();

        Long.valueOf("1");
        Long.parseLong("2");

        Object obj = new Object();
        obj.equals(null);
        obj.hashCode();


        // 生产线程
        Thread thread = new Thread("thread1") {
            public void run() {
                System.out.println(this.getName());
            }
        };
        thread.start();
        thread.join();


        // 线程池
        // 线程数量固定
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        fixedThreadPool.submit(runnable);
        FutureTask<Object> futureTask = new FutureTask(null);
        fixedThreadPool.execute(runnable);
        Future result = fixedThreadPool.submit(runnable);

        // 核心线程数 0, 最大线程数 正数最大值
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(runnable);

        double d = 1.0;
        long l = 1L;

        d = l;

        // wrong
        // l = d;


        Exception ex = new Exception();
        Error error = new Error();


    }


    public static String byteToBitStr(byte by) {
        StringBuffer sb = new StringBuffer();
        //每一位与 000000001按位与运算。保证每一位是 0或者1
        sb.append((by >> 7) & 0x1);
        sb.append((by >> 6) & 0x1);
        sb.append((by >> 5) & 0x1);
        sb.append((by >> 4) & 0x1);
        sb.append((by >> 3) & 0x1);
        sb.append((by >> 2) & 0x1);
        sb.append((by >> 1) & 0x1);
        sb.append((by >> 0) & 0x1);
        return sb.toString();
    }


    // 利用递归 构造k重循环

}
