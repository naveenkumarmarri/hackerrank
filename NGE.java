import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class NGE {
	public static void main(String[] args) {
		int numbersNeeded=100;
		int max=100;
		Random rng = new Random(); // Ideally just create one instance globally
		// Note: use LinkedHashSet to maintain insertion order
		Set<Integer> generated = new LinkedHashSet<Integer>();
		while (generated.size() < numbersNeeded)
		{
		    Integer next = rng.nextInt(max) + 1;
		    // As we're adding to a set, this will automatically do a containment check
		    generated.add(next);
		}
		System.out.println(generated);	
		int b[]={1,2,3,4,5,6,7};
		getNGE(b);
	}

public static void getNGE(int[] a) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(a[0]);

    for (int i = 1; i < a.length; i++) {
        if (s.peek() != null) {
            while (true) {
                if (s.peek() == null || s.peek() > a[i]) {
                    break;
                }
                System.out.println(s.pop() + ":" + a[i]);
            }
        }
        s.push(a[i]);
    }
    while (s.peek() != null) {
        System.out.println(s.pop() + ":" + -1);
    }
}
}