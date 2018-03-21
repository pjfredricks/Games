import java.util.Scanner;

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
	
	public static void main(String[] args) 
	{
		String word1,word2;
		String  code1,code2;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a word");
		word1 = s.next();
		code1 = generate(word1);
		
		System.out.println("Enter another word");
		word2 = s.next();
		code2 = generate(word2);
		
		
		
		if(code1.equals(code2))
		{	
			System.out.println("code1="+code1);
			System.out.println("code2="+code2);
			System.out.println("These words are homophones");
		}
		else
		{
			System.out.println("code1="+code1);
			System.out.println("code2="+code2);
			System.out.println("They aren't homophones");
		}
		s.close();
	}

}
