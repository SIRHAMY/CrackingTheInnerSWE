
public class CharReplace {
	
	boolean debug = true;
	
	//In-place char replace of spaces with %20
	public void spaceReplace(char[] myString, int tLength)
	{
		if(tLength>myString.length) 
		{
			System.out.println("tLength larger than given array");
			return;
		}
		
		int spaceCount = 0;
		
		for(int i = 0; i< tLength; i++)
		{
			if(myString[i] == (char) " ".charAt(0)) spaceCount++;
		}
		
		if(debug) System.out.println("Spacecount: " + spaceCount);
		
		if(tLength + (spaceCount*2) > myString.length) 
		{
			System.out.println("Not enough room in char[]");
			return;
		}
		
		int origPlace = tLength - 1;
		for(int j = tLength + (spaceCount * 2) - 1; j >= 0; j--)
		{
			//if(debug) System.out.println("j = " + j);
			if(myString[origPlace] == " ".charAt(0)) 
			{
				myString[j] = "0".charAt(0);
				myString[j-1] = "2".charAt(0);
				myString[j-2] = "%".charAt(0);
				j-=2;
			}
			else
			{
				myString[j] = myString[origPlace];
				
			}
			origPlace--;
		}
		
	}
	
	public char[] fillCharArray(String myString, int length)
	{
		char[] result = new char[length];
		
		if(myString.length() < length) length = myString.length();
		
		for(int i = 0; i<length; i++)
		{
			result[i] = myString.charAt(i);
		}
		return result;
	}
}
