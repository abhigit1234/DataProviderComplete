package demo;

import java.util.HashMap;

public class demo {
	public static void main(String[] args) {

	String s = "abhi lash naidu 21";
	HashMap<Character , Integer> m = new HashMap<Character, Integer>();
	char[] ch = s.toCharArray();
	for (char c : ch) {
		if(m.containsKey(c)) {
			m.put(c, m.get(c)+1);
		}else {
			
		
			m.put(c, 1);
		}	
	
	}System.out.println(m);
	
	
	
	}
}
