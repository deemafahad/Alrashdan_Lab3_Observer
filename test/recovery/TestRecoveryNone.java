/**
 *name: Deema Alrashdan
 */
package recovery;

import static org.junit.Assert.*;
import org.junit.Test;
import lifeform.Alien;

public class TestRecoveryNone 
{
	 /**
     * Test check the maxLife points stays at the maxLife points after recovery
     */
    @Test
    public void noRecoveryWhenNotHurt() 
    {
        RecoveryNone rn = new RecoveryNone();
        int maxLifePts = 20;
        int result = rn.calculateRecovery(maxLifePts, maxLifePts);
        assertEquals(maxLifePts, result);
    }
    
    /**
     * Test check the maxLife points without any hurt stays at the maxLife points after recovery
     */
    @Test
    public void RecoveryWhenReallyHurt()
    {
        Alien a = new Alien("Monster", 100);
        a.takeHit(10);
        a.recover();
        assertEquals(90, a.getCurrentLifePoints());
    }
    
    /**
     * Test when only hurt a little and return the correct amount of life points 
     * (recovery method will not recover more life points than it started with)
     */
    @Test
    public void RecoveryWhenAlittelHurt()
    {
        Alien a1 = new Alien("Monster", 50);
        a1.takeHit(30);
        a1.recover();
        assertEquals(20, a1.getCurrentLifePoints());
    }
    /**
     * Test check the at max life points are less than hurt 
     * the alien should has 0 points of life.
     */
    @Test
    public void RecoveryWhenDead() 
    {
        Alien a = new Alien("Monster", 30);
        a.takeHit(35);
        a.recover();
        assertEquals(0, a.getCurrentLifePoints());
    }
}