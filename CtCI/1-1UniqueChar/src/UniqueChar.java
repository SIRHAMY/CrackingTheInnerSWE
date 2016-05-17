import java.util.HashMap;

public class UniqueChar {

	public boolean hasUniqueChar(String myStr) 
	{
		if(myStr.length() == 0) return false;
		if(myStr.length() == 1) return true;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		if(!Character.isLetter(myStr.charAt(0))) return false;
		map.put(myStr.charAt(0), 1);
		
		for(int i = 1; i<myStr.length(); i++) 
		{
			if(!Character.isLetter(myStr.charAt(i)) || 
					map.containsKey(myStr.charAt(i))) return false;
			else map.put(myStr.charAt(i), 1);
		}
		
		return true;
	}
}
