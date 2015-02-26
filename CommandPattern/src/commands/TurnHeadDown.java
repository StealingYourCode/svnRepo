package commands;

import interfaces.ICommand;
import robot.RobotHead;

public class TurnHeadDown implements ICommand{
	
	private RobotHead robotHead;
	
	public TurnHeadDown(RobotHead robotHead){
		this.robotHead=robotHead;
	}
	
	public void Execute(){
		robotHead.lookDown();
	}

}
