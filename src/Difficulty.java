
public class Difficulty
{
	public static String setDiffString;
	public static int funds;
	private int numDifficulty;
	
	// Difficulty selection done here, sets specified value of funds based of difficulty selection
	public String setDifficulty(int diff) throws NullPointerException
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
		 return setDiffString;
	}
	
	public void getDifficulty()
	{
	
		System.out.println("With a chosen difficulty of " + setDiffString + " your funds start at: $" + funds);		
	
	}
	
	public int getFunds()
	{
		return funds;
	}
	

}
