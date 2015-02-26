package commands;

import interfaces.ICommand;
import robot.RobotLowerBody;

public class TurnLeft implements ICommand {
	
	RobotLowerBody legs = new RobotLowerBody();
	
	public TurnLeft(RobotLowerBody r){
		legs = r;
	}
	
	public void Execute(){
		legs.turnLeft();
	}

}
