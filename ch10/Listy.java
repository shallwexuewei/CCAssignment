package ch10.cbc.xuewei.ece.cmu;

import java.util.ArrayList;

public class Listy {
	ArrayList<Integer> list = new ArrayList<Integer>();

	public void add(int val) {
		list.add(val);
	}
	
	public int elementAt(int i) {
		if(i < list.size()) {
			return list.get(i);
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
	}

}
