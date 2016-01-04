
public class UniqueCharNoDS {
	
	public boolean hasUniqueChar(String myStr) 
	{
		if(myStr.length() < 1) return false;
		if(myStr.length() == 1) return true;
		
		for(int i = 0; i<(myStr.length() - 1); i++)
		{
			char letter = myStr.charAt(i);
			for(int j = (i + 1); j<myStr.length(); j++)
			{
				if ( myStr.charAt(j) == letter) return false;
			}
		}
		return true;
	}
}
