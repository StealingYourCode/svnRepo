package Interfaces;

import Observers.Follower;

public interface Subject {

		public void registerObserver(Follower follower);
		public void removeObserver(Follower follower);
		public void notifyObserver();
}
