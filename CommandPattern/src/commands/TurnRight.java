package commands;

import interfaces.ICommand;
import robot.RobotLowerBody;

public class TurnRight implements ICommand {
	
	RobotLowerBody legs = new RobotLowerBody();
	
	public TurnRight(RobotLowerBody r){
		legs = r;
	}
	
	public void Execute(){
		legs.turnRight();
	}

}