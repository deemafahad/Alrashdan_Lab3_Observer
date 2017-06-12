/**
 * name: Deema Alrashdan
 */
package recovery;
 
public class RecoveryLinear implements RecoveryBehavior 
{                                                        
    private int recoveryStep;
 
    public RecoveryLinear(int step)
    {
        recoveryStep = step;
    }
    /**
     * If the current life points after hurt is less than or equal 0, the
     * currentLife points will be equal zero, if the current life points after hurt is less than
     * the maxLife, add the recoveryStep to the currentLife, and if currentLife points
     * is greater than maxLife, the currentLfie will be equal the maxLife
     */
    @Override
    public int calculateRecovery(int currentLife, int maxLife) 
    {
        if (currentLife <= 0)
        {
        	currentLife = 0;
        }
        else if (currentLife < maxLife)
        {
            currentLife = currentLife + recoveryStep;
        }
        if (currentLife > maxLife) 
        {
            currentLife = maxLife;
        }
        return currentLife;
    }
}