package com.practise.fun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> al = new ArrayList<Interval>();
		al.add(new Interval(1,3));
		al.add(new Interval(2,6));
		al.add(new Interval(8,10));
		al.add(new Interval(15,18));
		Collections.sort(al, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				
				return o1.start-o2.start;
			}
			
		});
		Stack<Interval> merged = merge(al);
		for(Interval i:merged)
		{
			System.out.println(i.start+"---"+i.end);
		}

	}

	private static Stack<Interval> merge(ArrayList<Interval> al) {
		Stack<Interval> stack = new Stack<Interval>();
		stack.push(al.get(0));
		for(int i=1;i<al.size();i++)
		{
			int cur_start = al.get(i).start;
			int cur_end = al.get(i).end;
			int stack_start = stack.peek().start;
			int stack_end = stack.peek().end;
			if(cur_start <= stack_end)
			{
				if(cur_end>stack_end)
				{
					stack.pop();
					stack.push(new Interval(stack_start,cur_end));
				}
			}
			else
				stack.push(new Interval(al.get(i).start,al.get(i).end));
		}
		
		return stack;
		
	}

}
class Interval
{
	Interval(int start,int end)
	{
		this.start = start;
		this.end = end;
	}
	int start;
	int end;
}