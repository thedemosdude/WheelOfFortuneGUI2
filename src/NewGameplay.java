import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewGameplay
{
	private int value = 0;
	private String chosenPhrase; 
	private String playerGuesses;
	private int funds;
	private static final int VOWEL_COST = 250;
	
	//Lo2
	List<String> listOfStrings = new ArrayList<String>();
	
	//Arraylist of char, used to be an array but this makes it easier to use across methods 
	//since we dont know how long our array is till spin is called
	private static List<Character> raChar = new ArrayList<Character>();
	
	//char block
	//work later brought over from contestant player
	public static char[] alphabet = new char[26];
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
	 
	//Learning outcome for exception handling
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
    
    /* Method: buyVowel */
	/** Runs through the vowel buying option */
	private void buyVowel() {
		if (currentPlayer.getBalance() >= VOWEL_COST) {
			currentPlayer.changeBalance(-VOWEL_COST); // Charges the player the cost of the vowel.
			canvas.updateBalance(currentPlayer.getBalance(), currentPlayerNumber());
			while(true) { // Prompts user to enter a letter until a vowel is entered.
				String guess = readLine("Enter vowel: ");
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
	}
	
	//INTERFACE SECTION__________________
	public int changeFunds(int newFunds)
	{
		funds += newFunds;
		return funds;
		//this is a fund updater
	}
	public int getFunds()
	{
		return funds;
		//operates the same as contestant player
	}
	
	public void setStage(int diff)
	{
		//operates different stages 2-3
	}
	
	public String getStage();
	{
		//operates the same as contesntant
	}
	
}
