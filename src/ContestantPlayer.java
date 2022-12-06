import java.util.Scanner;

<<<<<<< HEAD
public class ContestantPlayer extends Difficulty
=======
public class ContestantPlayer implements Difficulty
>>>>>>> branch 'main' of https://github.com/thedemosdude/WheelOfFortuneGUI2
{
	//setStage and getStage method needed
	//
	
	private String setName;
	//these 3 fields are used for our interface method!
	private int numDifficulty;
	public static String setDiffString;
	public static int funds;
	public static int stage = 0;
	

	public void setName(String name)
	{
		
		 setName = name;
		 	
	}
	public String getName()
	{
		return setName;
	}
	
	//fund setter. For the start of the game players funds updates to 1000.
	public void setFunds(int newFunds)
	{
		newFunds = 0;
		funds = 1000;
		System.out.println("Congrats you get 1000 just for starting the game!");
	}
	//traditional getter
	public int getFunds()
	{
		return funds;
	}
	//sets to stage 1- must do something. in NewgamePlay FileIO is set
	public void setStage()
	{
		
	} 
		 
//		 numDifficulty = diff;
//		 if(numDifficulty == 1)
//		 {
//			 setDiffString = "Easy";
//			 funds = 1000; 
//		 }
//		 
//		 else if(numDifficulty == 2)
//		 {
//			 setDiffString = "Normal";
//			 funds = 2500; 
//		 }
//		 
//		 else
//		 {
//			 setDiffString = "Hard";
//			 funds = 5000; 
//		 }
		 	
	}
	
	public int getStage()
	{
		return stage;
	}
}