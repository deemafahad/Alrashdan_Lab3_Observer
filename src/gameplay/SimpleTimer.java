/**
 * name: Deema Alrashdan
 */
package gameplay;

import java.util.ArrayList;

/**
 *SimpleTimer is observer see if it  sends update correctely to
 *another classes observing.
 */
public class SimpleTimer extends Thread implements Timer
{
	public int round = 0;
	ArrayList<TimeObserver> theObservers = new ArrayList<TimeObserver>();
	 
	 /**
	  * override the run, and any thread is running will stop running for amount of time
	  */
	 @Override
	 public void run() 
	 {
	     while (true) 
	     {
	         timeChanged();
	         try
	         { 
	             Thread.sleep(1000);
	         } catch (InterruptedException e) 
	         {
	             e.printStackTrace();
	         }
	     }
	 }  
	    
	 /**
	  * addTimeObserver to add observer to the ArrayList
	  * @param observer
	  */
	 public void addTimeObserver(TimeObserver observer)
	 {
		 theObservers.add(observer);		 
	 }
	 
	 /**
	  * removeTimeObserver to remove observer from the ArrayList
	  * @param observer
	  */
	 public void removeTimeObserver(TimeObserver observer)
	 {
		 theObservers.remove(observer);
	 }
	 
	 /**
	  * Keep track of what round the game is in. Starts at round 0 and increments
      * the value by 1 each time time Changed is called. 
      * Additionally, it calls the update time function of all observing observer.
	  */
	 public void timeChanged()
	 {
		 for (int i=0; i<theObservers.size(); i++)
	     {
	         TimeObserver observer = theObservers.get(i);
	         observer.updateTime(getRound());
	     }
	 }
	 
	 /**
	  * Get round
	  * @return round
	  */
	 public int getRound()
	 {
		 return round;
	 }
	 
	/**
	 * Set round
	 * @param round 
	 */
	 public void setRound(int round)
	 {
		 this.round = round;
	 }
	 
	 /**
	  * Get Observers
	  * @return theObservers
	  */
	 public ArrayList<TimeObserver> getObservers()
	 {
	     return theObservers;
	 }
}