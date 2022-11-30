import java.io.*;
import java.util.*;

//NEED TRACKGUESS METHOD

public class Gameplay extends Difficulty 
{

	//Find different files for each difficulty phrase 
	private int spin;
	private int value = 0;
	private int instance = 0;
	//private int index = 0;
	private static String chosenPhrase;
	private String showCurrentPhrase;

//	
//	//booleans related to player choosing to guess
//	//more booleans for if they choose to use a letter
//	private boolean letterFound = false;
//	private boolean chooseGuess = false;
//	private boolean chooseLetter = false;


	List<String> listOfStrings = new ArrayList<String>();
	
	//Arraylist of char, used to be an array but this makes it easier to use across methods 
	//since we dont know how long our array is till spin is called
	private static List<Character> raChar = new ArrayList<Character>();
	
	//char block
	//work later brought over from contestant player
	public static char[] alphabet = new char[26];
	public static int[] charValues = new int[26];
	public static int charValue = 0;
	//different char stuff for instance of a char
	private char instanceChar = 'a';
	
	//File IO declaration goes here
	//work later file IO needs extra code for 3 different phrase files depending on difficulty
	//somehow call whichDifficulty method from difficulty superclass
	File phrases = new File("easyPhrases.txt");
	
	private int[] raValue = new int[37];

	private Random rand = new Random();
	
	
	
	// Write other two difficulty.txt files and add to setPhrase 
	public String setPhrase() throws Exception 
	{
		
		 
		BufferedReader phraseFileReader = new BufferedReader(new FileReader("easyPhrases.txt")); 
		String line = phraseFileReader.readLine();
		
		while (line != null)
		{
			listOfStrings.add(line);
			line = phraseFileReader.readLine();
		}
		
		phraseFileReader.close();
		
		String[] phraseStrings = listOfStrings.toArray(new String[0]);
		
		
		//file we are using has 37 phrases
		//if we implement stages we will need to add extra code -- NEED TO DO 
		int index = rand.nextInt(37);

		//sets our phrase from array to a variable
		chosenPhrase = phraseStrings[index];

		
		//sets our value from array to a  variable
		value = raValue[index];
		
		return chosenPhrase;
		//array of values need to be assigned to each index
		//raValue needs to be populated with values for each phrase
		//we might need to look at the file and manually think of a value per phrase		
	}
	
	public void setCharRa()
	{
		alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();		
	}
	
	public char[] getCharRa()
	{
		return alphabet;
	}
	public void setCharValueRa()
	{
		//normal letters 2 and vowels 1
		//each have to return to same value variable
		for(int i = 0; i < charValues.length; i++)
		{
			if((alphabet[i] == 'a') || (alphabet[i] == 'e') ||
			 (alphabet[i] == 'i') || (alphabet[i] == 'o') || (alphabet[i] == 'u'))//and sometimes y!
			{
				charValues[i] = 100;
				charValue = charValues[i];
			}
			else
			{
				charValues[i] = 500;
				charValue = charValues[i];
			}
		}
	}
	//not good
	public int[] getCharValueRa()
	{
		return charValues;
	}
	public static void setCharArray()
	{
		
		for(int i = 0; i < chosenPhrase.length(); i++)
		{
			 raChar.add(chosenPhrase.charAt(i));
		}
		
		for(char s : raChar)
		{
			System.out.print(s);
		}
		System.out.println();
	}
	
	public static List<Character> getCharArray() 
	{
		return raChar;
	}
	
	public static boolean guessPhrase(String guess)
	{
		boolean guessRight;
		if(guess.equals(chosenPhrase))
		{
			System.out.println("Wow you got it right???? Great job! \nHere are your winnings!");
			guessRight = true;
			
		}
		else
		{
			System.out.println("Incorrect, please try again.");
			guessRight = false;	
		}
			// METHOD CALL CONTESTANT PLAYER either way player needs to know they suck
	return guessRight;
	}
	
	//Method that prints instances of a letter showing up within phrase guess
	public static void guessLetter(char chosenChar)
	{
		boolean letterFound = false;
		int instance = 0;
		for(int i = 0; i < chosenPhrase.length(); i++)
		{
			char currentCh = chosenPhrase.charAt(i);
			
			
			if(raChar.get(i).equals(chosenChar))
			{
				instance++;
				letterFound = true;
			}
				
		}
		System.out.println("'" + chosenChar + "' shows up " + instance + " time(s)");
		if(letterFound == false)
			{
				System.out.println("'" + chosenChar + "' didn't show up. Try again!");
				//ContestantPlayer.wrongLetter();
			}
		else
		{
			System.out.println(reveal(chosenChar));
			//System.out.println(ContestantPlayer.guessRight());
		}	
		
	}
	
	
	//METHOD FOR SHOWCURRENTPHRASE THAT REFRESHES CURRENT PHRASE WITH GUESS
	public static void showCurrentPhrase(String currentPhrase)
	{
		//currentPhrase = chosenPhrase.reveal(chosenChar);
	}
	
	
	public static boolean guessOrLetter(String choice)
	{
		boolean chosen;
		if(choice.equalsIgnoreCase("letter"))
			chosen = true;
//		else if(choice != "letter" || "guess")
//			System.out.println("Please type 'letter' or 'guess' to continue.")
		
		else
			chosen = false;

		//false is for guess 
		//true is for letter
		//since we have 2 options we can do this
		return chosen;
	}
	public void rightLetter()
	{
		//Instance variable for number of correct letters goes here 
		if(setDiffString.equals("Easy"))
		 {
			if(charValue == 100)
			 funds = charValue + 1000; 
		 }
		 
		 else if(setDiffString.equals("Normal"))
		 {
			 funds = charValue + 2500; 
		 }
		 
		 else
		 {
			 funds = charValue + 5000; 
		 } 
	}
	
	public static void wrongLetter()
	{
		if(setDiffString.equals("Easy"))
		 {
		
			 funds = charValue - 1000; 
		 }
		 
		 else if(setDiffString.equals("Normal"))
		 {
	
			 funds = charValue - 2500; 
		 }
		 
		 else
		 {
			 funds = charValue - 5000; //value of letter (out of 26)
		 }
		 	
	}
	
	
	
	public void guessRight()
	{
		//addFunds for correct guess based on difficulty selection
		if(setDiffString.equals("Easy"))
		 {
			
			 funds = charValue + 1000; 
		 }
		 
		 else if(setDiffString.equals("Normal"))
		 {
	
			 funds = charValue + 2500; 
		 }
		 
		 else
		 {
			 funds = charValue + 5000; 
		 } 

		
	}
	public void guessWrong()
	{
		//addFunds for wrong guess based on difficulty selection
		if(setDiffString.equals("Easy"))
		 {
			
			 funds = charValue + 1000; 
		 }
		 
		 else if(setDiffString.equals("Normal"))
		 {
	
			 funds = charValue + 2500; 
		 }
		 
		 else
		 {
			 funds = charValue + 5000; 
		 } 
	} 
	
	public static String hide(String word) 
	{
		String stars = "";
		for (int i = 0; i < word.length(); i++) 
		{	
			if(raChar.get(i).equals(' '))
				stars += ' ';
			else if(raChar.get(i).equals('\''))
				stars += "";
			else if(raChar.get(i).equals(','))
				stars += "";
			else
				stars += '*';
		}
		return stars;
	}	
	
	public static String reveal(char chosenChar)
	{
		String stars = "";
		for(int i = 0; i < chosenPhrase.length(); i++)
		{
			if(chosenPhrase.charAt(i) == chosenChar)
				stars += chosenChar;
			else if (chosenPhrase.charAt(i) == ' ')
				stars += " "; 
			else if (chosenPhrase.charAt(i) == '\'')
				stars += "";
			else if (chosenPhrase.charAt(i) == ',')
				stars += "";
			else
				stars += '*';
		}
		
		return stars;
	}
	
	public int getValue()
	{
		return value;
	}

}