/**
 *name: Deema Alrashdan
 */
package recovery;
 
public class RecoveryFractional implements RecoveryBehavior 
{
	private double percentRecovery;
     
    public RecoveryFractional(double percent)
    {
        percentRecovery = percent;
    }
    
    /**
     * The recovery percent is calculated and if the current life points are less than
     * maxlife points, the current life added the recovery percent, if is bigger than maxlife
     * the current life set the maxlife points
     */
    @Override
    public int calculateRecovery(int currentLife, int maxLife) 
    {
        double rr = percentRecovery * currentLife;
        
        if(currentLife < maxLife)
        {
	        currentLife = (int) (currentLife + rr);
	        if(currentLife > maxLife)
	        {
	        	currentLife = maxLife;
	        } 
        } 
        return currentLife;
    }
}