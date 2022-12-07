import java.util.Scanner;

public class SuperGame
{
	public static void main(String[] args) throws Exception
	{
		
		String name;
		String diffString = "";
		String userChoice = "";
		String fullGuess = "";
		String chosenPhrase = "";
		boolean guess = false;
		boolean found = false;
		boolean spin = false;
		boolean isLetter;
		int difficulty;
		int funds = 0;
		char charChosen;
		

		//Player and game object declarations
		ContestantPlayer player = new ContestantPlayer();
		Gameplay game = new Gameplay();
				
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Hey whats good, heres whats up. We got some Wheel of fortune stuff but our own spin");
		
		// Asking player information
		System.out.println("What's your name sparky?");
		name = scnr.nextLine();
		player.setName(name);
		
		//STAGES IMPLEMENTED HERE
		System.out.println("Alright sparky, er " + name + " lets go");
		
		//Start of the game, gameplay funds are set. funds is set here. player funds are updated. Funds are essentially set everywhere. 
		//Encapsulatin essentially.
		NewGameplay.setFunds();
		funds = NewGameplay.getFunds();
		player.setFunds(funds);
		//player.setStage(); 
		
		
		funds = player.getFunds();
		NewGameplay.buyVowel(funds);
		
		// Returns the difficulty chosen
		player.getStage();

		// lets start the game!
		// boolean flag in main- pass over to contestantPlayer class. boolean method is isGameRunning
		// player.gameStart();

		System.out.println("Welcome to the game " + name + "!, we're very happy to have you join us today :)");
		
		System.out.println("Press 'enter' or 'return' to spin for your first phrase.");
		
		scnr.nextLine();
		scnr.nextLine();
		
		System.out.println("Good luck! Your first phrase is....");
		
		//this will access our file. Phrase and Value for it is set
	
		chosenPhrase = game.setPhrase();
		Gameplay.setCharArray();
		System.out.println("hidden should show up");
		System.out.println(Gameplay.hide(chosenPhrase));
		// the first option is to guess the entire phrase.
		// Depending on the difficulty, guessing the entire
		

		
		
		//prompting users choice
		System.out.println("Guess entire phrase or use a letter? \nType guess or letter");	 
		userChoice = scnr.nextLine(); 
		isLetter = Gameplay.guessOrLetter(userChoice);

		//Loop that runs while player guesses phrase
		do
		{
			if(isLetter)
			{
				//guess method calls to  contestant player
				//109 and 113 in gameplay
				
				//letter method calls  to contestant player
				//127 and 142 in gameplay
				System.out.println("Playing it safe? Coward! \nWould you like a constant or a vowel?");
				charChosen = scnr.next().toLowerCase().charAt(0);
				Gameplay.guessLetter(charChosen);
				
				userChoice = "";
				userChoice = scnr.nextLine(); 
				
				isLetter = Gameplay.guessOrLetter(userChoice);
					
			}
			else
			{
				System.out.println("Feelin lucky I see, what's life without some risk? \nWhat's your guess?");
				
				fullGuess = scnr.nextLine();
				guess = Gameplay.guessPhrase(fullGuess); 
				if(guess)
				
					break;


			
			}
			

			//prompting users choice
			System.out.println("Guess entire phrase or use a letter? \nType guess or letter");	
			userChoice = "";
			userChoice = scnr.nextLine(); 
			
			isLetter = Gameplay.guessOrLetter(userChoice); 
			
			funds = player.getFunds();  
			
		}
			while (!found);
			
		

		System.out.println("Congrats " + name + " " + "you ended up with: " + funds + " chocolate dollar coins!!!");
		System.out.println("We'd offer you a prize but our producer has just notified us that we are bankrupt!! \nNo Chocolate for you! ");
	
	
	}
		
}