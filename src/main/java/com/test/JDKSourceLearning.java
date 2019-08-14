package com.test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
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

    public static void main(String[] args) throws Exception {

        // 类对象
        Class classz = JDKSourceLearning.class;

        boolean stop = true;

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new Object());
        arrayList.remove(0);


        Collections.sort(arrayList, new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });


        if (stop) {
            return;
        }

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


        // 优先队列
        Queue<Object> queue = new PriorityQueue<>();
        queue.add(new Object());
        // 移除并返问队列头部的元素
        queue.poll();
        // 返回队列头部的元素
        queue.peek();

        // 双向队列
        Deque<Object> dqueue = new ConcurrentLinkedDeque<Object>();

        // 阻塞队列
        BlockingQueue<Object> bqueue = new ArrayBlockingQueue<Object>(20);
        bqueue.add(new Object());
        bqueue.poll();
        try {
            bqueue.take();
        } catch (Exception ex) {
            ex.printStackTrace();
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


        // 几种map
        Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
        hashtable.get("");
        // hashtable key value 不能为空
//		hashtable.put(null, null);

        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("", null);
        hashMap.get("");
        hashMap.remove("");

        //
        Map synnchronizeMap = Collections.synchronizedMap(hashMap);


        ConcurrentHashMap<String, Integer> concurretHashMap = new ConcurrentHashMap<String, Integer>();
        concurretHashMap.put("", 1);

        // 红黑树
        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("", 1);

        Set treeSet = new TreeSet();
        treeSet.add("");


        Set hashSet = new HashSet();
        hashSet.add("1");
        hashSet.add(2);

        System.out.println("hashset: " + Arrays.toString(hashSet.toArray()));


        // 线程局部变量
        ThreadLocal<Integer> tl = new ThreadLocal<>();
        tl.set(1);
        tl.get();


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


        // 原子类型
        AtomicInteger ai = new AtomicInteger(0);
        ai.incrementAndGet();

        double d = 1.0;
        long l = 1L;

        d = l;

        // wrong
        // l = d;


        Exception ex = new Exception();
        Error error = new Error();


    }


    // 利用递归 构造k重循环

}
