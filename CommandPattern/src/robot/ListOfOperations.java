package robot;

import commands.LeftLegForward;
import commands.RightLegForward;

public class ListOfOperations {
	
public static void WalkDistance(int distance){
		
		RobotLowerBody legs = new RobotLowerBody();

		
		LeftLegForward llf = new LeftLegForward(legs);
		RightLegForward rlf = new RightLegForward(legs);
		
		Controller WalkController = new Controller(llf, rlf);

		int count=distance;
		while (count>0){
			WalkController.CommandLeft();
			WalkController.CommandRight();
			System.out.println();
			count--;
		}
	}

}
