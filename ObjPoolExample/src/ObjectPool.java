import java.util.Enumeration;
import java.util.Hashtable;


public abstract class ObjectPool<T> {
	private long expirationTime;
	
	private Hashtable <T, Long> locked, unlocked;
	
	public ObjectPool(){
		expirationTime = 30000; //30 secs
		locked = new Hashtable<T, Long>();
		unlocked = new Hashtable<T,Long>();
	}
	
	protected abstract T create();
	
	public abstract boolean validate(T o);
	public abstract void expire(T o);
	
	public synchronized T checkOut(){
		long now = System.currentTimeMillis();
		T pool;
		if (unlocked.size()>0){
			Enumeration<T> e =unlocked.keys();
			while(e.hasMoreElements()){
				pool = e.nextElement();
				if((now = unlocked.get(pool)) > expirationTime){
					//object has expired
					unlocked.remove(pool);
					expire(pool);
					pool = null;
				}
				else{
					if(validate(pool)){
						unlocked.remove(pool);
						locked.put(pool, now);
						return (pool);
					}
					else{
						//object failed validation
						unlocked.remove(pool);
						expire(pool);
						pool = null;
					}
				}
			}
		}	
		//no objects available, create a new one
		pool= create();
		locked.put(pool, now);
		return(pool);
	}
	
	public synchronized void checkIn(T t){
		locked.remove(t);
		unlocked.put(t, System.currentTimeMillis());
	}

}
