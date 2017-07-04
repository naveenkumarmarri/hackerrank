import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SparseArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<n;i++)
		{
			String key = br.readLine();
			if(map.get(key)==null)
				map.put(key, 0);
			else
				map.put(key, map.get(key)+1);
		}
		int query = Integer.parseInt(br.readLine());
		List<Integer> al = new ArrayList();
		for(int i=0;i<query;i++)
		{
			String key=br.readLine();
			if (map.get(key)!=null)
					al.add(map.get(key)+1);
			else
					al.add(0);
		}
		for(Integer a:al)
		{
			System.out.println(a);
		}
	}

}
