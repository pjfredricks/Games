

public class Soundex 
{
	private static String generate(String word) 
	{
		char[] c = word.toLowerCase().toCharArray();
		char first = c[0];
		String op= "";
		
		for(int i=0;i<c.length;i++)
		{
			switch(c[i])
			{
							case 'b':
							case 'f':
							case 'p':
							case 'v':
								c[i] = '1';
								break;
							case 'c':
							case 'g':
							case 'j':
							case 'k':
							case 'q':
							case 's':
							case 'x':
							case 'z':
								c[i] = '2';
								break;
							case 'd':
							case 't':
								c[i] = '3';
								break;
							case 'l':
								c[i] = '4';
								break;
							case 'm':
							case 'n':
								c[i] = '5';
								break;
							case 'r':
								c[i] = '6';
								break;
							default:
								c[i] = '0';
								break;
				}
		}
			op = "" + first;
			for(int i=1; i<c.length; i++)
				if(c[i] != c[i-1] && c[i] != '0')
					op = op + c[i];
			
		op = op +"0000";	
		return op.substring(0,4);			
	}
	public static boolean check(String word1,String word2) {
		// TODO Auto-generated method stub
		String  code1, code2;
		code1 = generate(word1);
		code2 = generate(word2);
		
		if(code1.equals(code2))
		{
			return true;
		}
		else 
			return false;
		
		
		/*	System.out.println(code1);
		System.out.println(code2);
		System.out.println(check(code1,code2));
		*/
	}
	
	
	public static void main(String[] args) 
	{
		
	
	}
}
