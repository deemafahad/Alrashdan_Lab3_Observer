/**
 * name : Deema Alrashdan
 */
package recovery;
 
public class RecoveryNone implements RecoveryBehavior 
{
    /**
     * If the current life points are below 0 don't recovery the Alien
     * and current life points assign to 0 
     */
    @Override
    public int calculateRecovery(int currentLife, int maxLife)
    {
        return currentLife;
    }
}