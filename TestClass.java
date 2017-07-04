

//import for Scanner and other utility  classes
import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TreeSet<String> variables = new TreeSet<String>();
        for (int i = 0; i < n; i++) {
            String inp = s.next();
            String[] tokens = inp.split("=");
            if(tokens.length>0)
            {
            	 if(!variables.contains(tokens[0]))
                 {
                 	variables.add(tokens[0]);
                 }
            }
           
        }
        System.out.println(variables.size());

    }
}
