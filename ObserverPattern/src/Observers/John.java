package Observers;

import Subject.Twitter;

public class John extends Follower {

	private Twitter twitter;
	
	public John(Twitter twitter){
		this.twitter = twitter;
		twitter.registerObserver(this);
	}
	@Override
	public void update(String tweet) {
		System.out.println("John received tweet: "+tweet+" and favorites it");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
