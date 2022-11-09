import java.io.*;
import java.util.*;

public class Gameplay 
{

	//Find different files for each difficulty phrase 
	private int spin;
	private int value = 0;
	private int instance = 0;
	//private int index = 0;
	private static String chosenPhrase;
	private String showCurrentPhrase;

	private char instanceChar = 'a';
	
	//booleans related to player choosing to guess
	//more booleans for if they choose to use a letter
	private boolean letterFound = false;
	private boolean chooseGuess = false;
	private boolean chooseLetter = false;


	List<String> listOfStrings = new ArrayList<String>();
	
	//Arraylist of char, used to be an array but this makes it easier to use across methods 
	//since we dont know how long our array is till spin is called
	private static List<Character> raChar = new ArrayList<Character>();

	
	//File IO declaration goes here
	File phrases = new File("easyPhrases.txt");
	
	private int[] raValue = new int[37];


	
	private Random rand = new Random();
	
	
	public String spin() throws Exception 
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
		//if we implement stages we will need to add extra code
		//extra code would find the length (amount of phrases) in the file and in
		//rand.nextint(numPhrasesinfile)
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
	
	/* Method: trackPlayerGuess */
	/** 
	 *  Determines if the inputted letter is in the phrase. If so, displays the letter and the user's new balance.
	 * 	If not, ends the turn.
	 *  @param	guess	user inputted String
	 */
    private void trackPlayerGuess(String guess) {
    	char guessch = Character.toLowerCase(guess.charAt(0));
    	playerGuesses += guessch;
		for (int i = 0; i < phrase.length(); i++) {
    		char currentch = phrase.charAt(i);
    		if (guessch == currentch) {
    			blankPhrase = blankPhrase.substring(0, i) + guessch + blankPhrase.substring(i + 1); // Replaces the spaces with the user's guessed letter.
    			canvas.displayLetters(guessch);
    		}
		}
		if (blankPhrase.indexOf(guessch) != -1) {
			println("That guess is correct.");
			canvas.updateBalance(currentPlayer.getBalance(), currentPlayerNumber()); //Displays the player's new balance.
		} else {
			println("There are no " + guessch + "'s in the phrase.");
			if (! isVowel(guess)) currentPlayer.changeBalance(-canvas.getWedgeValue()); //Only decreases the player's balance to its former value if the guess was a consonant.
			isCurrentPlayerTurn = false;
		}
		canvas.removeLetter(guessch); //Removes the letter from the remaining letters of the alphabet on display.
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
				ContestantPlayer.wrongLetter();
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