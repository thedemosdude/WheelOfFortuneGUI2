import java.util.Scanner;

public abstract class ContestantPlayer implements Difficulty
//>>>>>>> branch 'main' of https://github.com/thedemosdude/WheelOfFortuneGUI2.git
{
	//setStage and getStage method needed
	//
	
	private String setName;
	//these 3 fields are used for our interface method!
	private int numDifficulty;
	public static String setDiffString;
	public static int funds = 0;
	public static int stage = 0;
	

	public void setName(String name)
	{
		
		 setName = name;
		 	
	}
	public String getName()
	{
		return setName;
	}
	
	/* ***********Interface Section******************
	//This is where our interface is first used. In main it runs along the Gameplay Interface methods
	 * Where do they differ? Well gameplay initializes the game and sets our funds and stages for t
	 * Why not have one interface section here? Simplicity. In main we would like to use one object to do everything
	 * However the player class must have a fund initialized since its part of our contestants info
	 * the stage is an after thought but they should be initialized as well and part of the contestants info.
	 * 
	 */
	//fund setter. For the start of the game players funds updates to 1000.
	
	
	//basically changing our funds. Namestyle to match interface
	//this is a fund updater
	public int setFunds(int newFunds)
	{
		funds += newFunds;
		return funds;
	}
	//operates the same as contestant player
	public int getFunds()
	{
		return funds;	
	}
	
	//This setStage method differs from the oen in ContestantPlayer since it updates our stages
	//We keep the name because of our interface, it updates the stage by 'setting' it
	public void setStage(int diff)
	{
		//funds must meet a threshold of 1000 for each stage to be able to go into the next stage
		//since funds are automatically 1000 no more code is necessary

		if(funds >= 2000)
			stage = 2;
		else if(funds >= 3000)
			stage = 3;
			
	}
	
	//Traditional getter
	public int getStage()
	{
		return stage;
	}
	
}