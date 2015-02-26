package robot;

import commands.CannonCommand;
import commands.LeftLegForward;
import commands.RightLegForward;
import commands.TurnHeadDown;
import commands.TurnHeadUp;
import commands.TurnLeft;
import commands.TurnRight;

public class Test {
	
	public static void main(String[] args) {
		
		RobotHead head = new RobotHead();
		RobotLowerBody legs = new RobotLowerBody();
		RobotCannon cannon = new RobotCannon();
		
		TurnHeadDown thd = new TurnHeadDown(head);
		TurnHeadUp thu = new TurnHeadUp(head);
		
		LeftLegForward llf = new LeftLegForward(legs);
		RightLegForward rlf = new RightLegForward(legs);
		
		Controller headController = new Controller(thd, thu);
		
//		headController.CommandLeft();
//		headController.CommandRight();
		
		Controller WalkController = new Controller(llf, rlf);
		
//		WalkController.CommandLeft();
//		WalkController.CommandRight();
		
		CannonCommand cc = new CannonCommand(cannon);
		
		Controller CannonController = new Controller(cc);
		
//		CannonController.DoCommand();
		
//		WalkController.CommandLeft();
//		WalkController.CommandRight();
		
		TurnLeft tl = new TurnLeft(legs);
		TurnRight tr = new TurnRight(legs);
		
		Controller TurnController = new Controller(tl, tr);
		
//		TurnController.CommandLeft();
//		TurnController.CommandRight();
		
		
//		ListOfOperations.WalkDistance(2);
		TurnController.CommandRight();
		CannonController.DoCommand();
		

	}
	
	
}
