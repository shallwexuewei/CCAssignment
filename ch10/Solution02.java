package ch10.cbc.xuewei.ece.cmu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution02 {
	public static void groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		HashMap<String, LinkedList<String>> stem2strs = new HashMap<String, LinkedList<String>>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String stem = new String(chars);
			if (stem2strs.keySet().contains(stem)) {
				stem2strs.get(stem).add(str);
			} else {
				LinkedList<String> strList = new LinkedList<String>();
				strList.add(str);
				stem2strs.put(stem, strList);
			}
		}
		
		int i = 0;
		for (String stem : stem2strs.keySet()) {
			for(String str:stem2strs.get(stem)){
				strs[i] = str;
				i++;
			}
		}
	}

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println("Before:");
		for(String s:strs){
			System.out.print(s);
			System.out.print(' ');
		}
		System.out.println();
		
		Solution02.groupAnagrams(strs);
		System.out.println("After:");
		for(String s:strs){
			System.out.print(s);
			System.out.print(' ');
		}
		System.out.println();
	}

}
