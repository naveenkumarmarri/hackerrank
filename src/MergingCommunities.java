import java.util.LinkedList;
import java.util.Scanner;

public class MergingCommunities {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int [] comm = new int[n];
		for(int i=0;i<comm.length;i++) {
			comm[i] = i+1;
		}
		for(int i=0;i<q;i++) {
			String inp = sc.next();
			if(inp.charAt(0) == 'M') {
				int comm_1 = Integer.parseInt(sc.next());
				int comm_2 = Integer.parseInt(sc.next());
				
				if(comm[comm_1-1] != comm_1 && comm[comm_2-1] == comm_2) {
					comm[comm_2-1] = Math.min(comm[comm_1-1], comm_2);
 				}
				else if(comm[comm_1-1] == comm_1 && comm[comm_2-1] != comm_2) {
					comm[comm_1-1] = Math.min(comm_1, comm[comm_2-1]);
				}
				else if(comm[comm_1-1] == comm_1 && comm[comm_2-1] == comm_2) {
					comm[comm_2-1] = Math.min(comm_1, comm_2);
					comm[comm_1-1] = Math.min(comm_1, comm_2);
				}
				else {
					//comm[comm_2-1] = Math.min(comm[comm_1-1], comm[comm_2-1]);
					//comm[comm_1-1] = Math.min(comm[comm_1-1], comm[comm_2-1]);
					if(comm[comm_1-1] < comm[comm_2-1])
						comm[comm_2-1] = comm[comm_1-1];
					if(comm[comm_1-1] > comm[comm_2-1])
						comm[comm_1-1] = comm[comm_1-1];
				}
				
			}
			else if(inp.charAt(0) == 'Q') {
				
				int query = Integer.parseInt(sc.next());
				int value = comm[query - 1];
				int count = 0;
				for(int j:comm) {
					if(j == value) {
						count++;
					}
				}
				ll.add(count);
			}
		}
		for(int i:ll) {
			System.out.println(i);
		}
		sc.close();

	}

}
