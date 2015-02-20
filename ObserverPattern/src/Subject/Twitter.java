package Subject;
import java.util.ArrayList;

import  Interfaces.Subject;
import Observers.Follower;

public class Twitter implements Subject{
	
	private ArrayList<Follower> followers;
	private String tweet;
	
	public Twitter(){
		followers = new ArrayList();
	}

	@Override
	public void registerObserver(Follower follower) {
		followers.add(follower);
		
	}

	@Override
	public void removeObserver(Follower follower) {
		followers.remove(follower);

	}

	@Override
	public void notifyObserver() {
		for(Follower follower : followers)
			follower.update(tweet);
	}
	
	public void tweetSomething(String tweet){
		this.tweet=tweet;
		notifyObserver();
	}

}
