package Observers;
import Interfaces.DisplayElement;
import Interfaces.Observer;

public abstract class Follower implements Observer, DisplayElement {

	@Override
	public abstract void update(String tweet);

	@Override
	public abstract void display();

}
