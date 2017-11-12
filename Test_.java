/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.*;


class Test_ {
    public static void main(String args[] ) throws Exception {
        
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            Point [] points = new Point[3];
            Point p1 = new Point();
            p1.x = s.nextInt();
            p1.y = s.nextInt();
            points[0]=p1;
            Point p2 = new Point();
            p2.x = s.nextInt();
            p2.y = s.nextInt();
            points[1]=p2;
            Point p3 = new Point();
            p3.x = s.nextInt();
            p3.y = s.nextInt();
            points[2]=p3;
            Point test = new Point();
            test.x = s.nextInt();
            test.y = s.nextInt();
            if(contains(test,points))
                System.out.println("INSIDE");
            else
                System.out.println("OUTSIDE");
      }
    }
    
     public static boolean contains(Point test,Point[] points) {
      int i;
      int j;
      boolean result = false;
      for (i = 0, j = points.length - 1; i < points.length; j = i++) {
        if ((points[i].y > test.y) != (points[j].y > test.y) &&
            (test.x < (points[j].x - points[i].x) * (test.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
          result = !result;
         }
      }
      return result;
      
        }
}
    
  class Point {
      public  double x;;
      public double y;
    }
 
