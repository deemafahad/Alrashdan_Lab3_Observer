/**
 * name: Deema Alrashdan
 */
package gameplay;

/**
 * An interface for the subject that will works with the observer
 */
public interface Timer 
{
	public void addTimeObserver(TimeObserver observer);
	public void removeTimeObserver(TimeObserver observer);
	public void timeChanged();
}