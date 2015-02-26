package commands;

import interfaces.ICommand;
import robot.RobotLowerBody;

public class RightLegForward implements ICommand {
	
	private RobotLowerBody robotLegs;
	
	public RightLegForward(RobotLowerBody robot){
		this.robotLegs = robot;
	}

	@Override
	public void Execute() {
		robotLegs.rightLegStep();
	}

}
