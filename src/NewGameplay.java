import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NewGameplay 
{
	private int m = 0;
	private int value = 0;
	private String chosenPhrase; 
	private String playerGuesses;
	private static int funds;
	private static final int VOWEL_COST = 250;
	private static int stage;
	
	ContestantPlayer player = new ContestantPlayer();
	
	//Learning Outcome 2
	List<String> listOfStrings = new ArrayList<String>();
	
	//Arraylist of char, used to be an array but this makes it easier to use across methods 
	//since we dont know how long our array is till spin is called
	private static List<Character> raChar = new ArrayList<Character>();
	
	//char block
	//work later brought over from contestant player
	public char[] alphabet = new char[26];
	public static int[] charValues = new int[26];
	public static int charValue = 0;
	
	//File IO declaration goes here
	//work later file IO needs extra code for 3 different phrase files depending on difficulty
	//somehow call whichDifficulty method from difficulty superclass
	File phrases = new File("easyPhrases.txt");
	
	private int[] raValue = new int[37];

	private Random rand = new Random();
	
	/* Method: setPhrase */
	/** Reads phrase from file and sets each character of phrase to array variable
	 *  @return true if vowel, otherwise false.
	 */
	 
	//Learning outcome for exception handling - must improve
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
	
	/* Method: isVowel */
	/** Determines if the inputted letter is a vowel. 
	 *  @return true if vowel, otherwise false.
	 */
	private boolean isVowel(String guess) 
	{
    	char guessch = Character.toUpperCase(guess.charAt(0));
		return guessch == 'A' || guessch == 'E' || guessch == 'I' || guessch == 'O' || guessch == 'U';
	}
	
	/* Method: isLegalGuess */
	/**
	 * Determines if the user input is legal in the game. If not legal, displays a message telling user why the entry
	 * was not accepted.
	 * @param	guess	user inputted String
	 * @return true if the guess is allowed. Otherwise, false.
	 */
    private boolean isLegalGuess (String guess) {
		char guessch = Character.toUpperCase(guess.charAt(0));
		if (guess.length() != 1 || ! Character.isLetter(guessch)) { // Ensures entry is a single letter.
    		System.out.println("That guess is illegal. Try again.");
    		return false;
		} else if (playerGuesses.indexOf(guessch) != -1) { // Ensures the letter has not been guessed already.
    		System.out.println("The letter " + guessch + " has already been guessed.");
    		return false;
    	} else {
    		return true;
    	}
    }
    
    /* Method: guessConsonant */
	/** Prompts the user to enter a letter until a consonant is entered. */
	private void guessConsonant() {
		while(true) {
			String guess = readLine("Your guess: ");
			if (isLegalGuess(guess) && ! isVowel(guess)) {
				trackPlayerGuess(guess);
				return;
			} else if (guess.length() == 1 && isVowel(guess)){
				System.out.println("Please enter a consonant.");
	    	}
		}
	}
	
    /* Method: trackPlayerGuess */
	/** 
	 *  Determines if the inputted letter is in the phrase. If so, displays the letter and the user's new balance.
	 * 	If not, ends the turn.
	 *  @param	guess	user inputted String
	 */
    private void trackPlayerGuess(String guess) {
    	char guessch = Character.toUpperCase(guess.charAt(0));
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
    
    /* Method: buyVowel */
	/** Runs through the vowel buying option */
	public static int buyVowel(int balance) 
	{
		funds = balance;
		
		if (funds >= VOWEL_COST) {
			funds -= VOWEL_COST; // Charges the player the cost of the vowel.
		//GUI update later	canvas.updateBalance(currentPlayer.getBalance(), currentPlayerNumber());
			while(true) { // Prompts user to enter a letter until a vowel is entered.
				System.out.println("Enter vowel: ");
				String guess = sc.nextLine();
				if (isLegalGuess(guess) && isVowel(guess)) {
					trackPlayerGuess(guess);
					return;
				} else if (guess.length() == 1 && ! isVowel(guess)){
					System.out.println("Please enter a vowel.");
				}
			}
		} else {
			System.out.println("You cannot afford to buy a vowel."); // If player's balance is too low, does not let the player buy a vowel.
		}
		return funds;
	}
	

	//INTERFACE SECTION__________________
	// public int changeFunds(int newFunds)

	
	//********INTERFACE SECTION**********
	//Our Setters are different however our getters remain the same. Here they set
	//Sets our funds initially to 1000 
	public static void setFunds()
	{
		funds = 1000;
		System.out.println("Congrats you get 1000 just for starting the game!");
	}
	//traditional getter
	public static int getFunds()
	{
		return funds;
	}
	//Sets our first stage. Nothing more
	public void setStage()
	{
		stage = 0;
	} 

	//Traditional getter
	public static int getStage()
	{
		return stage;
	}
}
