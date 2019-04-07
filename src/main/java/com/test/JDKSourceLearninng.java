package com.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qings2329
 *
 * @since Oct 20, 2016   1:10:39 AM
 * 
 */
public class JDKSourceLearninng {

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

	private JDKSourceLearninng(){

	}

	private static JDKSourceLearninng ins = new JDKSourceLearninng();

	public static JDKSourceLearninng getInstance () {
		return ins;
	}

	public static void main(String[] args) {

		boolean stop = true;

		Queue<Object> queue = new PriorityQueue<>();
		queue.add(null);
		// 移除并返问队列头部的元素
		queue.poll();
		// 返回队列头部的元素
		queue.peek();


		Object[] objects = new Object[10];
		// 数组用length，不是size()
		System.out.println(objects.length);



		ReentrantLock lock = new ReentrantLock();


		// Long 对象的比较
		Long l1 = new Long(1);
		Long l2 = new Long(1);
		System.out.println(l1 == l2);
		System.out.println(l1.equals(l2));

		if(stop) {
			return;
		}


		System.out.println("start main !");

		System.out.println("************* new JDKSourceLearninng() *************");
		JDKSourceLearninng instanceq1 = new JDKSourceLearninng();

		System.out.println("************* JDKSourceLearninng.getInstance() *************");

		JDKSourceLearninng instance = JDKSourceLearninng.getInstance();

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

		Set treeSet = new TreeSet();
		treeSet.add("");
		
		

		Set hashSet = new HashSet();
		hashSet.add("1");
		hashSet.add(2);
		
		System.out.println( "hashset: " + Arrays.toString(hashSet.toArray()) );
		

		// 线程局部变量
		ThreadLocal tl = new ThreadLocal<>();
		tl.set("");


		// 线程池
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);


		// 原子类型
		AtomicInteger ai = new AtomicInteger();
		
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
