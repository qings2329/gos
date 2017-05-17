package org.leetcode.bitcoinreaver;

public class PrintRhombus {

	/**
	 * 打印菱形
	 * @param args
	 */
	public static void main(String args[]) {
//		System.out.println("args: " + args[0]);
		
		int n  = 103;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i <= n/2) {
					if(Math.abs(n/2 - j) <= i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}	
				} else {
					if(Math.abs(n/2 - j) < Math.abs(n - i)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
		
	}
	
	
	
}
