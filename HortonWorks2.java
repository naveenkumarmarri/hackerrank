import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HortonWorks2 {
	public static void main(String[] args) {
		String[] ele={"a","a","b","b","c","x","x","x","b","z"};
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<ele.length;i++)
		{
			if(map.containsKey(ele[i]))
				map.put(ele[i], map.get(ele[i])+1);
			else
				map.put(ele[i], 1);
		}
		Map.Entry<String, Integer> e = null;
		for(Map.Entry<String, Integer> s:map.entrySet())
		{
			if(e==null||s.getValue().compareTo(e.getValue())>0)
				e=s;
		}
		ArrayList<String> al=new ArrayList<String>();

		for(Map.Entry<String, Integer> set:map.entrySet())
		{
			if(set.getValue()==e.getValue())
			{
				al.add(set.getKey());
			}
		}
		
		Collections.sort(al);
		System.out.println(al.get(al.size()-1));
	}
}
