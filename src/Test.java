import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Implement a simplified version of Huffman encoding on a string with
 * a given distribution for each character in it.  The chars are the
 * vowels of the latin alphabet.
 * @author thiebaut
 *
 */
public class Test {
      public static void main(String[] args) {
    	String[] versions = new String[] {
    			"19.2.1029",
    			"12.7.1203",
    			"12.5.230",
    			"19.2.232"
    	};
    	//System.out.println(Arrays.toString(versions[0].split("\\.")));
    	List<Build> list = getSorted(versions);
    	for(Build build: list)
    		System.out.println(build.major+" "+build.minor+" "+build.version);
	}
    public static List<Build> getSorted(String[] versions) {
    	List<Build> sortedBuild = new ArrayList<Build>();
    	for(String version: versions) {
    		String[] builds = version.split("\\.");
    		System.out.println(Arrays.toString(builds));
    		sortedBuild.add(new Build(Integer.parseInt(builds[0]),
    								Integer.parseInt(builds[1]),
    								Integer.parseInt(builds[2])
    				));
    	}
    	Collections.sort(sortedBuild, new Comparator<Build>() {
			@Override
			public int compare(Build o1, Build o2) {
				int comp = 0;
				comp = o1.major - o2.major;
				if(comp == 0)
					comp = o1.minor - o2.minor;
				if(comp == 0)
					comp = o1.version - o2.version;
				return comp;
			}
    	});
    	return sortedBuild;
    }
     
}
class Build {
	int major;
	int minor;
	int version;
	Build(int major, int minor, int version) {
		this.major = major;
		this.minor = minor;
		this.version = version;
	}
}