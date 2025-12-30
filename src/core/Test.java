package core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String[] args) {
		System.out.println("test");
		 Queue<String> pq = new PriorityQueue<>();
		 
	        pq.add("Geeks");
	        pq.add("For");
	        pq.add("Geeks");
	        pq.offer("t");
	        System.out.println(pq);
	        
	        ArrayList<String> list = new ArrayList<>(8);
	        list.add("1");
	        list.add("2");
	        list.add("3");
	        list.add("4");
	        list.add("5");
	        list.add("6");
	        list.add("7");
	        list.add("8");
	        list.add("9");
	        list.add("10");
	        list.add("10");
	        list.add(null);
	        list.add(null);
	        System.out.println("test:::"+list);
	        
	        
	        
	        LinkedHashSet lhs = new LinkedHashSet<>();
	        lhs.add(null);
	        lhs.add(null);
	        lhs.add(null);
	        System.out.println(lhs);
	        
	        
	        HashSet hs = new HashSet<>();
	        hs.add(null);
	        hs.add(null);
	        hs.add(null);
	        System.out.println(hs);
	        
	        Map<String, String> map=new HashMap<>();
	        map.put(null, null);
	        map.put("m", null);
	        map.put("m", "dup val");
	        map.put(null, "dupnull");
	        System.out.println("map:"+map);
	        
	        
	        List<Integer> intlist = Collections.singletonList(12);
	        //intlist.add(34);
	        System.out.println(intlist);
	        
	        Hashtable<String, String> ht=new Hashtable<>();
	       // ht.put("t", null); //NPE
	        
	        Map m=new HashMap();
	        Map m2 = Collections.synchronizedMap(m);
	        m2.put(null, null);
	        
	        Map<Integer,String> map3=new ConcurrentHashMap<>();
			map3.put(101, "A");
			map3.put(102, null);
	        
	}

}
