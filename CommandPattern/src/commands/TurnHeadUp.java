package commands;

import interfaces.ICommand;
import robot.RobotHead;

public class TurnHeadUp implements ICommand {
	
	private RobotHead robothead;
	
	public TurnHeadUp(RobotHead robothead){
		this.robothead = robothead;
	}
	
	public void Execute(){
		robothead.lookUp();
	}


}
