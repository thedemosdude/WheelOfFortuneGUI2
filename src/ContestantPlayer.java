import java.util.Scanner;

public class ContestantPlayer 
{

	
	private String setName;
	private int numDifficulty;
	public static String setDiffString;
	public static int funds;
	public static char[] alphabet = new char[26];
	public static int[] charValues = new int[26];
	int i;// for some reason if this doesnt exist.SetCharValueRa method for loop will not work
	public static int charValue = 0;
	
	private int startingMoney;


	
	 //look at main about the scanner
	private static Scanner scan = new Scanner(System.in);
	
	public void setName(String name)
	{
		
		 setName = name;
		 	
	}
	
	
	// Difficulty selection done here, sets specified value of funds based of difficulty selection
	public void setDifficulty(int diff) throws NullPointerException
	{
		
		 numDifficulty = diff;
		 if(numDifficulty == 1)
		 {
			 setDiffString = "Easy";
			 funds = 1000; 
		 }
		 
		 else if(numDifficulty == 2)
		 {
			 setDiffString = "Normal";
			 funds = 2500; 
		 }
		 
		 else
		 {
			 setDiffString = "Hard";
			 funds = 5000; 
		 }
		 	
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
		for(int i = 0; i < charValues.length; i++);
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
	
	public void getDifficulty()
	{
		
		System.out.println("With a chosen difficulty of " + setDiffString + " your funds start at: $" + funds);		
		
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
	
	public int getFunds()
	{
		return funds;
	}
	
	public String getName()
	{
		return setName;
	}

}
