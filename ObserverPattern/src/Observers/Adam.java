package Observers;

import java.util.ArrayList;

import Interfaces.Subject;
import Subject.Twitter;

public class Adam extends Follower {
	
private Twitter twitter;
	
	public Adam(Twitter twitter){
		this.twitter = twitter;
		twitter.registerObserver(this);
	}
	
	@Override
	public void update(String tweet) {
		System.out.println("Adam received tweet: "+tweet+" and replaces o's with zeroes "+tweet.replace('o', '0'));
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}
