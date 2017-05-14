package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qings2329
 *
 * @since Oct 20, 2016   1:10:39 AM
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


		Long.valueOf("1");
		Long.parseLong("2");


		Object obj = new Object();
		obj.equals(null);

		// 几种map
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
		hashtable.get("");
		// hashtable key value 不能为空
//		hashtable.put(null, null);

		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("", null);
		hashMap.get("");
		hashMap.remove("");

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


	}


	// 利用递归 构造k重循环

}
