package Observers;

import Subject.Twitter;

public class Mary extends Follower {

private Twitter twitter;
	
	public Mary(Twitter twitter){
		this.twitter = twitter;
		twitter.registerObserver(this);
	}
	@Override
	public void update(String tweet) {
		System.out.println("Mary received tweet: "+tweet+". And retweets it in caps "+tweet.toUpperCase());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
