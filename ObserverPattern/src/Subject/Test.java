package Subject;

import Observers.Adam;
import Observers.Follower;
import Observers.John;
import Observers.Mary;



public class Test {
	
	public static void main(String[] args) {
		Twitter Someonestwitter = new Twitter();
		Follower John = new John(Someonestwitter);
		Follower Mary = new Mary(Someonestwitter);
		Adam adam = new Adam(Someonestwitter);
		
		Someonestwitter.tweetSomething("Hello Followers");
		
		Someonestwitter.removeObserver(John);
		
		Someonestwitter.tweetSomething("Second tweet");
		
		
	}
	
	

}
