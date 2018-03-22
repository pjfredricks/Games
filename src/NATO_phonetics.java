import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NATO_phonetics 
{
	public static void main(String[] args) 
	{
		Map<Character,String> map = new HashMap<>();   //Declaring Map to store phonetics
		String name=new String();
		int score = 0;
		Scanner s = new Scanner(System.in);
		map.put('a',"alfa");													//Filling up the map with NATO phonetics
		map.put('b',"bravo");
		map.put('c',"charlie");
		map.put('d',"delta");
		map.put('e',"echo");
		map.put('f',"foxtrot");
		map.put('g',"golf");
		map.put('h',"hotel");
		map.put('i',"india");
		map.put('j',"juliett");
		map.put('k',"kilo");
		map.put('l',"lima");
		map.put('m',"mike");
		map.put('n',"november");
		map.put('o',"oscar");
		map.put('p',"papa");
		map.put('q',"quebec");
		map.put('r',"romeo");
		map.put('s',"sierra");
		map.put('t',"tango");
		map.put('u',"uniform");
		map.put('v',"victor");
		map.put('w',"whiskey");
		map.put('x',"xray");
		map.put('y',"yankee");
		map.put('z',"zulu");		
		
		System.out.println("?????????????????????????Welcome to the NATO phonetic alphabet game?????????????????????????????");
		System.out.println("\nYour aim is to type the corresponding phonetic for the character displayed...."
				+ "\nSince this is a recall test and not a typing test you are allowed to make minor spelling mistakes......"
				+ "\nSimilar sounding words ex. new-knew are allowed as well........."
				+ "\nHave fun and Good luck!!!!");
		
		System.out.println("\nEnter your username");
		name = s.nextLine();
		
		System.out.println("Enter a time limit(in seconds)");
		int limit = s.nextInt();
		
		System.out.println("Greetings "+name+" the game shall now commence");
		
		for(int i=0;i<10;i++)
		{
			char rchar = (char) ThreadLocalRandom.current().nextInt(97, 122 + 1); //Generates a random lowercase character
			System.out.println("Answer the phonetic for this character [within "+limit+" seconds] \n" + rchar);
			
			long initialtime = System.nanoTime(); 		
			String answer = s.next();
			long elapsedtime = (System.nanoTime() - initialtime)/1000000000;		//Implementing the time limit
			
			if(elapsedtime>limit)
			{
				System.out.println("\nTime expired - your answer will not be counted");
				continue;
			}
			else
			{
				if(/* Levenshtien.LD(/map.get(rchar),answer) < 3 ||*/ Soundex.check(map.get(rchar),answer)) //|| (answer.toLowerCase()).equals(map.get(rchar)))
				{
					System.out.println("\nThats the correct answer (Y)");
					score += 1;
						}
				else
				{
					System.out.println("\nYOU WERE WRONG!!");
					//System.out.println("The correct answer is " + map.get(rchar));
					}
				}
		}
		System.out.println("\nYour score is " + score);
		if(score == 10)
			System.out.println("You're a master of phonetics");
		else if(score>5)
			System.out.println("You're good but not good enough");
		else
			System.out.println("You Sierra Uniform Charlie Kilo at this");
		s.close(); 
		}
	}
