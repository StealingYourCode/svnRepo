package commands;

import interfaces.ICommand;
import robot.RobotCannon;

public class CannonCommand implements ICommand{
	
	private RobotCannon cannon;
	
	public CannonCommand(RobotCannon cannon){
		this.cannon=cannon;
	}

	@Override
	public void Execute() {
		cannon.fireLasers();
	}
	
	

}
