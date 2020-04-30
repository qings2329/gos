package com.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.LinkedList;

/**
 * @author qings2329
 *
 * @date 2:53:21 PM Jun 17, 2016
 */
public class Test {
	
//	private Logger log = Logger.getLogger(this.getClass());
	
//	public void testLog() {
//		log.info("test log!");
//	}
	
	public static void main(String[] args) {
		
		//PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		
//		Test instance = new Test();
//		instance.testLog();


		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);

		long currentTimeMillis = System.currentTimeMillis();
		long nano = System.nanoTime();

		System.out.println(currentTimeMillis + " " + nano);

		
		System.out.println(String.format("%04d%02d%02d", 2019, 1, 1));

		String tesStr = "23456";

		int x = Integer.parseInt(tesStr);

		for(int i = 0; i < tesStr.length(); i++) {
			System.out.println(tesStr.charAt(i) - '0');
		}


		
	}
	

}
