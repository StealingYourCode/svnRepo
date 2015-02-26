package robot;

import interfaces.ICommand;

public class Controller {
	
	private ICommand command1, command2, command3;
	
	public Controller(ICommand c1, ICommand c2){
		command1=c1;
		command2=c2;
	}
	
	public Controller(ICommand c3){
		command3=c3;
	}
	
	public void CommandLeft(){
		command1.Execute();
	}
	
	public void CommandRight(){
		command2.Execute();
	}
	
	public void DoCommand(){
		command3.Execute();
	}


}
