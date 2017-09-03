package com.practise.algos;

import java.util.LinkedList;
import java.util.Scanner;

public class PureStorage {

	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1 = null;
		LinkedList<Integer> l2 = l1;
		l1.add(10);
		l1.add(20);
		System.out.println(l2.size());
		
	}

}