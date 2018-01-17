import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;


public class HuffmanEncoding 
{
	public static void main(String[] args) throws IOException {
		HashMap<Character,Integer> count_tracker = readFileUtil("input.txt");
		System.out.println("Output generated for file input.txt");
		Huffman(count_tracker);
		System.out.println("=====================================");
		System.out.println("Output generated for file input_2.txt");
		count_tracker = readFileUtil("input_2.txt");
		Huffman(count_tracker);
		
		

	}

	private static void Huffman(HashMap<Character, Integer> count_tracker) {
		Set<Character> valid_keys = count_tracker.keySet();
		Iterator<Entry<Character,Integer>> it = count_tracker.entrySet().iterator();
		PriorityQueue<Node_1> queue = new PriorityQueue<Node_1>();
		int total_sum = 0;
		while(it.hasNext())
		{
			Map.Entry<Character,Integer> entry= (Entry<Character, Integer>) it.next();
			queue.add(new Node_1(entry.getKey(),entry.getValue(),null,null));
			total_sum+=entry.getValue();
		}
		int queue_size = queue.size();
		for(int i=0;i<queue_size;i++)
		{	
			if(queue.size()>1)
			{
				Node_1 left_node = queue.poll();
				Node_1 right_node = queue.poll();
				Node_1 temp_root = new Node_1('\0',left_node.freq+right_node.freq,left_node,right_node);
				queue.add(temp_root);
			}
		}
		Node_1 rootNode = queue.peek();
		int optimized_bits = 0;
		for(char c : valid_keys)
		{
			optimized_bits+=count_tracker.get(c)*(lengthOfPathFromRoot(queue.peek(),c)-1);
		}
		System.out.println("Tree elements path");
		printElements(rootNode,"");
		System.out.println("The text had "+total_sum+" valid characters ");
		System.out.println("Total number of bytes with 5-bit fixed length encoding is "+total_sum*5);
		System.out.println("Total number of bytes with variable length encoding is "+optimized_bits);	
		System.out.println("So we saved "+((total_sum*5)-optimized_bits)+" bits!");
		
	}

	private static HashMap<Character,Integer> readFileUtil(String inputFileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		
		HashMap<Character,Integer> count_tracker = new HashMap<Character,Integer>();
		//generating the characters a-z
		for(int i=97;i<=122;i++)
			count_tracker.put((char)i, 0);
		count_tracker.put('!', 0);
		count_tracker.put(' ', 0);
		count_tracker.put(',', 0);
		count_tracker.put('?', 0);
		count_tracker.put('\'', 0);
		count_tracker.put('.', 0);
		String line = br.readLine();
		while(line!=null)
		{
			String cur_line = line.toLowerCase();
			char[] line_chars = cur_line.toCharArray();
			for(char c:line_chars)
			{
				if(count_tracker.containsKey(c))
					count_tracker.put(c, count_tracker.get(c)+1);
			}
			line = br.readLine();
		}
		br.close();
		return count_tracker;
		
	}

	private static int lengthOfPathFromRoot(Node_1 root, char c) {
		if(root==null)
			return 0;
		else if(root.data==c)
			return 1;
		else if(root.left!=null && (lengthOfPathFromRoot(root.left, c)>0))
			return 1+lengthOfPathFromRoot(root.left, c);
		else if(root.right!=null && (lengthOfPathFromRoot(root.right, c)>0))
			return 1+lengthOfPathFromRoot(root.right, c);
		return 0;
	}

	private static void printElements(Node_1 poll,String path) {
		if(poll.left!=null)
			printElements(poll.left, path+"0");
		if(poll.right!=null)
			printElements(poll.right, path+"1");
		if(poll.left==null && poll.right==null)
			System.out.println(poll.data+"-"+path);
	}
}

class Node_1 implements Comparable<Node_1>{
	Node_1(char data,int freq,Node_1 left,Node_1 right)
	{
		this.freq = freq;
		this.data = data;
		this.left = left;
		this.right = right;
	}
	int freq;
	char data;
	Node_1 left;
	Node_1 right;
	
	@Override
	public int compareTo(Node_1 o) {
		return this.freq-o.freq; 	
	}
}
