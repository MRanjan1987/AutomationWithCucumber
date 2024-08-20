package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class rough {

	public static void main(String[] args) {
		/*
		 * int a = Integer.MIN_VALUE; int b = Integer.MAX_VALUE;
		 * 
		 * // System.out.println(b);
		 * 
		 * int[] arr = { 12, 35, 1, 10, 34, 1 }; Arrays.sort(arr);
		 * System.out.println(arr);
		 * 
		 * System.out.println(arr.length);
		 */

		/*
		 * ArrayList<Integer> arr1 = new ArrayList<Integer>(); arr1.add(1); arr1.add(2);
		 * arr1.add(3);
		 * 
		 * System.out.println(arr1);
		 */

		/*
		 * LinkedList<String> l = new LinkedList<String>(); l.add("Madhu Ranjan");
		 * l.add("Mohan"); l.add("Sohan"); l.add("Ram");
		 * 
		 * System.out.println(l); l.add(0, "Seema"); System.out.println(l);
		 * l.removeFirst(); System.out.println(l);
		 */

		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		p.add(8);
		p.add(0);
		p.add(3);
		p.add(4);

		System.out.println(p);
	System.out.println(	p.isEmpty());

	}
}
