package commands;

import robot.RobotLowerBody;
import interfaces.ICommand;

public class LeftLegForward implements ICommand{
	
	private RobotLowerBody robotLegs;
	
	public LeftLegForward(RobotLowerBody robot){
		this.robotLegs = robot;
	}

	@Override
	public void Execute() {
		robotLegs.leftLegStep();
	}

}
