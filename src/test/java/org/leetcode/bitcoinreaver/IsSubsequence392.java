package org.leetcode.bitcoinreaver;

/**
 * @author qings2329
 *
 * @since Sep 17, 2016   1:29:27 AM
 */
public class IsSubsequence392 {
	
	public boolean isSubsequence(String s, String t) {
		
		if(s == null){
			return true;
		} else if(t == null){
			return false;
		}
		
		int i = 0, j = 0;  
		for( ; i < s.length() && j < t.length(); j++) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
			}
		}
		
		if(i == s.length()) {
			return true;
		}

        return false;
    }
}
