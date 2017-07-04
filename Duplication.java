import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Duplication {

    static String duplication(int x){
        char[] duplicate = new char[x];
        int y,t;
        t=Integer.parseInt("0",16);
        y= ~t;
        System.out.println(t);
        System.out.println(y);
        String temp;
        for(int i=1;i<x;i++){
            temp=t+""+y;
            System.out.println(temp);
            t=Integer.parseInt(temp);
            y=~t;
            
        }
        String binaryString = Integer.toBinaryString(t);
		char[] dup = binaryString.toCharArray();
		return dup[x]+"";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            String result = duplication(x);
            System.out.println(result);
        }
    }
}
