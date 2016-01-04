
public class StringCompress {
	boolean debug = false;

	public String basicCompress(String myString)
	{
		StringBuffer buff = new StringBuffer();
		
		for(int i = 0; i<myString.length(); i++) 
		{
			char currChar = myString.charAt(i);
			buff.append(currChar);
			int count;
						
			for(count=1; i+count<myString.length(); count++) 
			{
				if(myString.charAt(i + count) != currChar) 
				{
					i+=(count-1);
					break;
				}
				
				if((i+count) == myString.length() - 1)
				{
					i+=( count );
				}
			}	
			if(debug) System.out.println("count: " + count);
			buff.append(count);
			
		}
		
		if(buff.length() >= myString.length()) return myString;
		
		return buff.toString();
	}
}
